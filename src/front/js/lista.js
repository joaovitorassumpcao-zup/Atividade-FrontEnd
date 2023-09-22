// Lista alunos
fetch("http://localhost:8080/api/zupescolafull/aluno")
  .then((data) => data.json())
  .then((todosAlunos) => {
    let data1 = "";
    todosAlunos.map((values) => {
      data1 += `
        <tbody>
          <tr>
            <th scope="row">${values.id}</td>
            <td>${values.nome}</td>
            <td>${values.idade}</td>
            <td>${values.email}</td>
          </tr>
        </tbody>
      `;
    });
    document.getElementById("listaAlunos").innerHTML = data1;
    console.log(todosAlunos);
  });

// Lista cursos
fetch("http://localhost:8080/api/zupescolafull/curso")
  .then((dataCurso) => dataCurso.json())
  .then((todosCursos) => {
    let dataCurso1 = "";
    todosCursos.map((values) => {
      dataCurso1 += `
        <tbody>
          <tr>
            <th scope="row">${values.id}</td>
            <td>${values.nome}</td>
            <td>${values.cargahoraria}</td>
          </tr>
        </tbody>
      `;
    });
    document.getElementById("listaCursos").innerHTML = dataCurso1;
    console.log(todosCursos);
  });

// Lista professores
fetch("http://localhost:8080/api/zupescolafull/professor")
.then((dataProfessor) => dataProfessor.json())
.then((todosProfessores) => {
  let dataProfessor1 = "";
  todosProfessores.map((values) => {
    dataProfessor1 += `
      <tbody>
        <tr>
          <th scope="row">${values.id}</td>
          <td>${values.nome}</td>
          <td>${values.cargahoraria}</td>
          <td>${values.curso.nome}</td>
          <td>R$${values.salario}</td>
        </tr>
      </tbody>
    `;
  });
  document.getElementById("listaProfessores").innerHTML = dataProfessor1;
  console.log(todosProfessores);
});

// Lista cursos dos professores
fetch("http://localhost:8080/api/zupescolafull/curso")
  .then((dataCursoProfessor) => dataCursoProfessor.json())
  .then((todosCursosProfessores) => {
    let dataProfessor1 = ""; 
    todosCursosProfessores.map((values) => {
      dataProfessor1 += `
        <option value="${values.id}">${values.id} - ${values.nome}</option>
      `;
    });
    document.getElementById("cursoprofessorlista").innerHTML = dataProfessor1;  
    console.log(todosCursosProfessores);
  });


// Lista matrículas dos alunos
fetch("http://localhost:8080/api/zupescolafull/aluno")
  .then((dataMatriculaAluno) => dataMatriculaAluno.json())
  .then((todosMatriculasAlunos) => {
    let dataAluno1 = "";
    todosMatriculasAlunos.map((values) => {
      dataAluno1 += `
        <option value="${values.id}">${values.id} - ${values.nome}</option>
      `;
    });
    document.getElementById("alunomatriculalista").innerHTML = dataAluno1;  
    console.log(todosMatriculasAlunos);
  });

// Lista matrículas dos cursos
fetch("http://localhost:8080/api/zupescolafull/curso")
.then((dataMatriculaCurso) => dataMatriculaCurso.json())
.then((todosMatriculasCursos) => {
  let dataCurso1 = "";
  todosMatriculasCursos.map((values) => {
    dataCurso1 += `
      <option value="${values.id}">${values.id} - ${values.nome}</option>
    `;
  });
  document.getElementById("cursomatriculalista").innerHTML = dataCurso1;  
  console.log(todosMatriculasCursos);
});

// Lista matrículas
fetch("http://localhost:8080/api/zupescolafull/matricula")
  .then((dataMatricula) => dataMatricula.json())
  .then((todasMatriculas) => {
    let dataMatricula1 = "";
    todasMatriculas.map((values) => {
      dataMatricula1 += `
        <tbody>
          <tr>
            <th scope="row">${values.id}</td>
            <td>${values.aluno.nome}</td>
            <td>${values.curso.nome}</td>
            <td>${values.datamatricula}</td>
          </tr>
        </tbody>
      `;
    });
    document.getElementById("listaMatricula").innerHTML = dataMatricula1;
    console.log(todasMatriculas);
  });
