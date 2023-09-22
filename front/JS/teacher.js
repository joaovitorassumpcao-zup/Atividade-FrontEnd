document.getElementById("formTeacher").addEventListener("submit", function() {
  const name = document.getElementById("teacherName").value;
  const age = document.getElementById("teacherAge").value;
  const course = document.getElementById("teacherCourse").value;
  const wage =  document.getElementById("teacherWage").value;

  const newTeacher = {
    name,
    age,
    course,
    wage
  }

  fetch("http://localhost:8080/api/teacher", {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(newTeacher)
  }).then(res => res.json()).then(newTeacher => console.log(newTeacher)).catch(error => console.log(error));
})

function message() {
  alert("Cadastro efetuado com sucesso!")
  window.location.reload(true);
}

fetch("http://localhost:8080/api/teacher").then((dataTeacher) => {
  return dataTeacher.json();
}).then((allTeachers) => {
  let dataTeacher1 = "";
  allTeachers.map((valueTeacher) => {
    dataTeacher1 += `
    <tbody>
      <tr>
        <td>${valueTeacher.name}</td>
        <td>${valueTeacher.course}</td>
      </tr>
    </tbody>
    `
  })
  document.getElementById("teacherData").innerHTML = dataTeacher1;
  console.log(allTeachers)
})