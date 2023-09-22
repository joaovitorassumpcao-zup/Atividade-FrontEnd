
const form = document.getElementById("formulario");
form.addEventListener("submit", event =>{
    event.preventDefault();

    const formData = new FormData(form);
    const data = Object.fromEntries(formData);

    fetch("http://localhost:8090/api/alunos/cadastrar", {

    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
}).then(res => res.json()).then(data => console.log(data)).catch(error => console.log(error));
});

function mensagem(){
alert("produto cadastrado com sucesso!")
window.location.reload(true);
}
