using Microsoft.UI.Xaml;

namespace OseiVPN.Windows;

public sealed partial class MainWindow : Window
{
    public MainWindow()
    {
        this.InitializeComponent();
    }

    private async void OnConnectClick(object sender, RoutedEventArgs e)
    {
        if (DataContext is MainViewModel vm)
        {
            await vm.ConnectCommand.ExecuteAsyncSafe();
        }
    }

    private async void OnDisconnectClick(object sender, RoutedEventArgs e)
    {
        if (DataContext is MainViewModel vm)
        {
            await vm.DisconnectCommand.ExecuteAsyncSafe();
        }
    }
}
