document.getElementById("formStudent").addEventListener("submit", function() {
  const name = document.getElementById("nameStudent").value;
  const age = document.getElementById("ageStudent").value;
  const email = document.getElementById("emailStudent").value;

  const newStudent = {
    name,
    age,
    email
  }

  fetch("http://localhost:8080/api/student", {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(newStudent)
  }).then(res => res.json()).then(newStudent => console.log(newStudent)).catch(error => console.log(error));
})

function message() {
  alert("Cadastro efetuado com sucesso!")
  window.location.reload(true);
}

fetch("http://localhost:8080/api/student").then((dataStudent) => {
  return dataStudent.json();
}).then((allStudents) => {
  let dataStudent1 = "";
  allStudents.map((valueStudent) => {
    dataStudent1 += `
    <tbody>
      <tr>
        <td>${valueStudent.name}</td>
        <td>${valueStudent.email}</td>
      </tr>
    </tbody>
    `
  })
  document.getElementById("studentData").innerHTML = dataStudent1;
  console.log(allStudents)
})