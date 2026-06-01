using System.ComponentModel;
using System.Runtime.CompilerServices;
using System.Windows.Input;

namespace OseiVPN.Windows;

public class MainViewModel : INotifyPropertyChanged
{
    private readonly IVpnService _vpnService;

    public MainViewModel(IVpnService vpnService)
    {
        _vpnService = vpnService;
        ConnectCommand = new RelayCommand(async () =>
        {
            Status = "Connecting...";
            await _vpnService.ConnectAsync();
            Status = "Connected";
        });

        DisconnectCommand = new RelayCommand(async () =>
        {
            Status = "Disconnecting...";
            await _vpnService.DisconnectAsync();
            Status = "Disconnected";
        });
    }

    private string _status = "Disconnected";
    public string Status
    {
        get => _status;
        set { _status = value; OnPropertyChanged(); }
    }

    public ICommand ConnectCommand { get; }
    public ICommand DisconnectCommand { get; }

    public event PropertyChangedEventHandler? PropertyChanged;
    private void OnPropertyChanged([CallerMemberName] string? name = null) => PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(name));
}
