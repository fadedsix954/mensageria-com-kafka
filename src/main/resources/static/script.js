document.addEventListener('DOMContentLoaded', () => {
    const notificationList = document.getElementById('notificationList');

    // Simula a atualização de notificações
    function addNotification(message, userType) {
        const listItem = document.createElement('li');
        listItem.textContent = `${userType}: ${message}`;
        notificationList.appendChild(listItem);
    }

    // Aqui você pode adicionar um exemplo de chamadas de notificação
    // Simulando a chegada de notificações
    setInterval(() => {
        const messages = [
            { message: "Lembrete: Prazo de entrega amanhã!", userType: "Aluno" },
            { message: "Mudança de horário na aula de matemática.", userType: "Professor" },
            { message: "Workshop sobre novas tecnologias.", userType: "Admin" }
        ];
        
        // Adiciona uma notificação aleatória
        const randomIndex = Math.floor(Math.random() * messages.length);
        const randomNotification = messages[randomIndex];
        addNotification(randomNotification.message, randomNotification.userType);
    }, 5000); // Atualiza a cada 5 segundos
});
