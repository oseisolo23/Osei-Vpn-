using System.Threading.Tasks;

namespace OseiVPN.Windows;

// Safe stub implementation for Windows starter project
public class VpnServiceStub : IVpnService
{
    public Task ConnectAsync()
    {
        // Placeholder: replace with real VPN integration
        return Task.CompletedTask;
    }

    public Task DisconnectAsync()
    {
        // Placeholder: replace with real VPN integration
        return Task.CompletedTask;
    }
}
