using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Builder;
using webSocket2.WebSocketChatSample;

namespace webSocket2
{
    public class Startup
    {
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }
            app.UseExceptionHandler("/error");
            app.UseRouting(); // adicione esta linha
            app.UseAuthorization();
            app.UseAuthentication();

            app.UseCors(x => x.AllowAnyHeader().AllowAnyMethod().AllowAnyOrigin());
            // Adiciona o middleware do SignalR
            app.UseEndpoints(endpoints =>
            {
                // Mapeia o endpoint /chatHub para a classe ChatHub
                endpoints.MapHub<ChatHub>("/chatHub");
            });
        }
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddSignalR();
            services.AddControllers();
            services.AddAutoMapper(typeof(Startup));

            services.AddAuthorization(); // adicione esta linha
        }
    }
}