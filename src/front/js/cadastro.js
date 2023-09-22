//Cadastro de alunos
function cadastraAluno(event) {
    event.preventDefault();

    const nome = document.getElementById('nome').value;
    const idade = document.getElementById('idade').value;
    const email = document.getElementById('email').value;

    // Montando json
    const payload = JSON.stringify({
      nome,
      idade,
      email
    });

    fetch('http://localhost:8080/api/zupescolafull/aluno', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: payload
    })
      .then(response => response.json())
      .then(data => {
        console.log('Success:', data);
        // Display the success message
        document.getElementById('msgsucesso').style.display = 'block';
        document.getElementById('cadastroaluno').reset();  // Reset the form
      })
      .catch(error => {
        console.error('Error:', error);
      });
}

//Cadastro de professores
function cadastraProfessor(event) {
    event.preventDefault();

    const nome = document.getElementById('nome').value;
    const idade = document.getElementById('idade').value;
    const cursoid = document.getElementById('cursoprofessorlista').value;
    const salario = document.getElementById('salario').value;

    // Montando json
    const payload = JSON.stringify({
      nome,
      idade,
      cursoid,
      salario
    });

    fetch('http://localhost:8080/api/zupescolafull/professor', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: payload
    })
      .then(response => response.json())
      .then(data => {
        console.log('Success:', data);
        // Display the success message
        document.getElementById('msgsucesso').style.display = 'block';
        document.getElementById('cadastroprofessor').reset();  // Reset the form
      })
      .catch(error => {
        console.error('Error:', error);
      });
}

//Cadastro de cursos
function cadastraCurso(event) {
    event.preventDefault();

    const nome = document.getElementById('nome').value;
    const cargahoraria = document.getElementById('cargahoraria').value;

    // Montando json
    const payload = JSON.stringify({
      nome,
      cargahoraria
    });

    fetch('http://localhost:8080/api/zupescolafull/curso', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: payload
    })
      .then(response => response.json())
      .then(data => {
        console.log('Success:', data);
        // Display the success message
        document.getElementById('msgsucesso').style.display = 'block';
        document.getElementById('cadastrocurso').reset();  // Reset the form
      })
      .catch(error => {
        console.error('Error:', error);
      });
}

//Cadastro de matriculas
function cadastraMatricula(event) {
    event.preventDefault();

    const alunoid = document.getElementById('alunomatriculalista').value;
    const cursoid = document.getElementById('cursomatriculalista').value;

    // Montando json
    const payload = JSON.stringify({
      alunoid,
      cursoid
    });

    fetch('http://localhost:8080/api/zupescolafull/matricula', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: payload
    })
      .then(response => response.json())
      .then(data => {
        console.log('Success:', data);
        // Display the success message
        document.getElementById('msgsucesso').style.display = 'block';
        document.getElementById('cadastromatricula').reset();  // Reset the form
      })
      .catch(error => {
        console.error('Error:', error);
      });
}
