//Função que inclui códigos externos para facilitar a manutenção
function includeFiles(path,div) {
    const request = new XMLHttpRequest();
    request.open('GET',path,true);
    request.onreadystatechange = function () {
        if(request.readyState === 4 && request.status === 200) {
            const conteudo = request.responseText;
            document.getElementById(div).innerHTML = conteudo;
        }
    }; 

    request.send();
}