const form = document.querySelector('form');
form.addEventListener('submit', async (e) =>{
    e.preventDefault();

    const aluno = {
        nome: form.nome.value,
        email: form.email.value,
        telefone: form.telefone.value,
        curso_id: form.cursos.value,
        data_cadastro: new Date().toISOString()
    };

    const response = await fetch('http://localhost:8081/matricula/salvar',{
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(aluno)
    });

    if(response.ok){
        alert('Aluno cadastrado com sucesso!');
    }else{
        alert('Erro ao cadastrar aluno.')
    }
});

const notificacao = document.getElementById("notificacao");
form.addEventListener("submit", function(event){
    event.preventDefault();
    form.reset();
    notificacao.style.display = "block";
    setTimeout(function(){
        notificacao.style.display = "none";
        },3000);
});