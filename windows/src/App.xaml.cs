using Microsoft.UI.Xaml;

namespace OseiVPN.Windows;

public partial class App : Application
{
    public App()
    {
        this.InitializeComponent();
    }

    protected override void OnLaunched(Microsoft.UI.Xaml.LaunchActivatedEventArgs args)
    {
        var window = new MainWindow();

        // Resolve DataContext from DI host if available
        if (Program.Host?.Services != null)
        {
            var vm = Program.Services.GetService(typeof(MainViewModel)) as MainViewModel;
            window.DataContext = vm;
        }

        window.Activate();
    }
}
