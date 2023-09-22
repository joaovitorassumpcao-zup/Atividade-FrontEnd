const form = document.getElementById("cadastroCurso");

form.addEventListener("submit", event =>{
    event.preventDefault();

    const formData = new FormData(form);
    const data = Object.fromEntries(formData);

    fetch("http://localhost:8080/api/ischool/cursos",{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    }).then(res => res.json()).then(data => console.log(data)).catch(error => console.log(error));
});

function mensagem(){
    alert("Curso cadastrado com sucesso!")
    window.location.reload(true);
}

fetch("http://localhost:8080/api/ischool/cursos").then((data)=>{
    return data.json();
}).then((todosCursos) => {
    let data1 = "";
    todosCursos.map((values) => {
        data1 += `
        <tbody>
            <tr>
                <th scope="row">${values.id}</th>
                <td>${values.nome}</td>
                <td>${values.cargaHoraria}</td>
            </tr>
        </tbody>
        `
    })

    document.getElementById("cursoDados").innerHTML = data1;
    console.log(todosCursos);
})