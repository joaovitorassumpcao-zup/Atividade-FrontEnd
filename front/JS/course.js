  document.getElementById("formCourse").addEventListener("submit", function() {
    const name = document.getElementById("nameCourse").value;
    const workload = document.getElementById("workload").value;
  
    const newCourse = {
      name,
      workload
    }
  
    fetch("http://localhost:8080/api/course", {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(newCourse)
    }).then(res => res.json()).then(newCourse => console.log(newCourse)).catch(error => console.log(error));
  })
  
  function message() {
    alert("Cadastro efetuado com sucesso!")
    window.location.reload(true);
  }
  
  fetch("http://localhost:8080/api/course").then((dataCourse) => {
    return dataCourse.json();
  }).then((allCourses) => {
    let dataCourse1 = "";
    allCourses.map((valueCourse) => {
      dataCourse1 += `
      <tbody>
        <tr>
          <td>${valueCourse.name}</td>
          <td>${valueCourse.workload}</td>
        </tr>
      </tbody>
      `
    })
    document.getElementById("courseData").innerHTML = dataCourse1;
    console.log(allCourses)
  })



