using System;
using System.Collections.Generic;
using System.Linq;

namespace ChatSignalR
{
    public class ChatHub : Hub
    {
        public void Send(string nome, string mensagem)
        {
            Clients.All.broadcastMessage(nome, mensagem);
        }
    }
}