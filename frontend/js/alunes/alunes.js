// FORMULÁRIO DE CADASTRO - REQUISIÇÃO POST

const form = document.getElementById("formulario_cadastro_alune");

form.addEventListener("submit", function(event){
    event.preventDefault();

    const formData = new FormData(form);
    const data = Object.fromEntries(formData);

    fetch("http://localhost:8080/api/alunos", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    }).then(res => res.json()).then(data => {    
        console.log(data);
    })
    .catch(error => console.log(error));  
    

});

// FUNÇÃO DE RELOAD E ALERTA DE SUCESSO
function mensagemSucesso(){
    alert("Cadastro realizado com sucesso! ");
    window.location.reload(true);
} 


// LISTA DE ALUNOS - REQUISIÇÃO GET

fetch("http://localhost:8080/api/alunos").then((data) => {
    return data.json();
    }).then((listarTodos) => {
        let data1 = "";
        listarTodos.map((values) => {
            data1 += `
            <tbody> 
                <tr>
                    <th>${values.id} </td>
                    <td> ${values.nomeAluno} </td>
                </tr>        
            </tbody>
            `
        })
        document.getElementById("lista_alunes").innerHTML = data1;
        console.log(listarTodos);
    
    });