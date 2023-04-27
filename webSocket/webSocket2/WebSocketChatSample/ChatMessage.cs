using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace webSocket2.WebSocketChatSample
{
    public class ChatMessage
    {
        public string User { get; set; }
        public string Message { get; set; }
        public DateTime Date { get; set; }
    }
}