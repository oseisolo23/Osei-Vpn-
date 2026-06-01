using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using Microsoft.UI.Xaml;
using System;

namespace OseiVPN.Windows;

public static class Program
{
    public static IHost Host { get; private set; } = CreateHostBuilder().Build();

    public static IServiceProvider Services => Host.Services;

    [STAThread]
    public static void Main(string[] args)
    {
        Host.Start();

        // Start WinUI application
        Application.Start((p) =>
        {
            var app = new App();
            app.InitializeComponent();
            app.Activate();
        });
    }

    private static IHostBuilder CreateHostBuilder() =>
        Host.CreateDefaultBuilder()
            .ConfigureServices((context, services) =>
            {
                // Register ViewModels and services
                services.AddSingleton<MainViewModel>();
                services.AddSingleton<IVpnService, VpnServiceStub>();
            });
}
