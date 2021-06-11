
async function adicionar() {
    let empregado = {
        nome: document.getElementById("nome").value,
        salario: parseFloat(document.getElementById("salario").value),
        receita:parseFloat(document.getElementById("receita").value)    
    };
    try {
        let result = await $.ajax({
            url: `/api/custeaveis/empregados/producao`,
            method: "post",
            data: JSON.stringify(empregado),
            dataType: "json",
            contentType: "application/json"
        });
        document.getElementById("resultado").innerHTML = 
            JSON.stringify(result);
    } catch(err) {
        console.log(err);
        document.getElementById("resultado").innerHTML = 
            "Erro: "+JSON.stringify(err);
    }
}