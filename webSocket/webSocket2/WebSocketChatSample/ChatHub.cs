using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System;
using System.Threading.Tasks;
using Microsoft.AspNetCore.SignalR;

namespace webSocket2.WebSocketChatSample
{
     public class ChatHub : Hub
    {
        public async Task SendMessage(string user, string message)
        {
            // Cria um objeto ChatMessage com os dados recebidos
            var chatMessage = new ChatMessage
            {
                User = user,
                Message = message,
                Date = DateTime.Now
            };

            // Envia a mensagem para todos os clientes conectados no grupo /chat
            await Clients.Group("chat").SendAsync("ReceiveMessage", chatMessage);
        }

        public override async Task OnConnectedAsync()
        {
            // Adiciona o cliente ao grupo /chat quando se conecta
            await Groups.AddToGroupAsync(Context.ConnectionId, "chat");
            await base.OnConnectedAsync();
        }

        public override async Task OnDisconnectedAsync(Exception exception)
        {
            // Remove o cliente do grupo /chat quando se desconecta
            await Groups.RemoveFromGroupAsync(Context.ConnectionId, "chat");
            await base.OnDisconnectedAsync(exception);
        }
    }
}