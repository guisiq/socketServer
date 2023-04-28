using Microsoft.AspNetCore.SignalR.Client;
const string url = "http://localhost:5211/chat";
// See https://aka.ms/new-console-template for more information
await using var connection = new HubConnectionBuilder()
    .WithUrl(url)
    .Build();
await connection.StartAsync();
await foreach (var date in connection.StreamAsync<DateTime>("Streaming"))
{
    Console.WriteLine(date);
}
Console.WriteLine("Hello, World!");
