using Microsoft.AspNetCore.SignalR;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddSignalR();
var app = builder.Build();
app.MapHub<myHub>("/chat");
app.MapGet("/", () => "Hello World!");

app.Run();
