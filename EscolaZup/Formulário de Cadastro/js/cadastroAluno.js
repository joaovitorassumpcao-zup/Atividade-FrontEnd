const form = document.getElementById("formulario");

form.addEventListener("submit", event =>{
    event.preventDefault();

    const formData = new FormData(form);
    const data = Object.fromEntries(formData);

    fetch("http://localhost:8080/api/alunos", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    }).then(res => res.json()).then(data => console.log(data)).catch(error => console.log(error));
});

function mensagem(){
    alert("Cadastro feito com sucesso!")
    window.location.reload(true);
}


fetch("http://localhost:8080/api/alunos").then((data)=>{
    return data.json();
  }).then((todosUsuarios) =>{
      let data1 = "";
      todosUsuarios.map((values) =>{
          data1 += `
          <tbody>
              <tr>
                  <th scope="row">${values.id} </td>
                  <td>${values.nome}</td> 
                  <td>${values.idade}</td> 
                  <td>${values.email} </td>
              </tr>
          </tbody>
          `
      })
      document.getElementById("usuarioDados").innerHTML = data1;
      console.log(todosUsuarios);
  })