using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.SignalR;

public class myHub : Hub
{
    public async IAsyncEnumerable<DateTime> Streaming( CancellationToken cancellationToken){
        while (true)
        {
            yield return DateTime.Now;
            await Task.Delay(100,cancellationToken);            
        }
    }
}
