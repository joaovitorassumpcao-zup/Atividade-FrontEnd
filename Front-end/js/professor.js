const form = document.getElementById("cadastroProfessor");

form.addEventListener("submit", event =>{
    event.preventDefault();

    const formData = new FormData(form);
    const data = Object.fromEntries(formData);

    fetch("http://localhost:8080/api/ischool/professores",{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    }).then(res => res.json()).then(data => console.log(data)).catch(error => console.log(error));
});

function mensagem(){
    alert("Professor cadastrado com sucesso!")
    window.location.reload(true);
}

fetch("http://localhost:8080/api/ischool/professores").then((data)=>{
    return data.json();
}).then((todosProfessores) => {
    let data1 = "";
    todosProfessores.map((values) => {
        data1 += `
        <tbody>
            <tr>
                <th scope="row">${values.id}</th>
                <td>${values.nome}</td>
                <td>${values.idade}</td>
                <td>${values.salario}</td>
            </tr>
        </tbody>
        `
    })

    document.getElementById("professorDados").innerHTML = data1;
    console.log(todosProfessores);
})