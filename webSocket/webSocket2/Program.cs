using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Hosting;
// Cria um objeto HostBuilder
namespace webSocket2
{
 class Program
    {
        static void Main(string[] args)
        {
            // Cria um objeto HostBuilder
            var hostBuilder = Host.CreateDefaultBuilder(args)
                // Configura o host da web
                .ConfigureWebHostDefaults(webBuilder =>
                {
                    // Define a URL base como http://localhost:5000
                    webBuilder.UseUrls("http://localhost:5000");
                    // Define o ambiente de execução como Development
                    webBuilder.UseEnvironment("Development");
                    // Chama a classe Startup.cs
                    webBuilder.UseStartup<Startup>();
                });
            // Constrói e executa o host da aplicação    
            hostBuilder.Build().Run();
        }
        
    }
}