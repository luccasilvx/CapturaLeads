const form = document.getElementById('enrollment-form');
const notification = document.getElementById('notification');

form.addEventListener('submit', async (e) => {
    e.preventDefault();

    const aluno = {
        nome: form.nome.value,
        email: form.email.value,
        telefone: form.telefone.value,
        curso_id: form.cursos.value,
        data_cadastro: new Date().toISOString()
    };

    try {
        const response = await fetch('http://localhost:8081/matricula/salvar', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(aluno)
        });

        if (response.ok) {
            notification.classList.add('show');
            form.reset();
            setTimeout(() => {
                notification.classList.remove('show');
            }, 3000);
        } else {
            notification.textContent = 'Erro ao cadastrar aluno.';
            notification.style.background = '#EF4444';
            notification.classList.add('show');
            setTimeout(() => {
                notification.classList.remove('show');
                notification.style.background = '#10B981';
                notification.textContent = 'Aluno cadastrado com sucesso!';
            }, 3000);
        }
    } catch (error) {
        notification.textContent = 'Erro de conexão com o servidor.';
        notification.style.background = '#EF4444';
        notification.classList.add('show');
        setTimeout(() => {
            notification.classList.remove('show');
            notification.style.background = '#10B981';
            notification.textContent = 'Aluno cadastrado com sucesso!';
        }, 3000);
    }
});