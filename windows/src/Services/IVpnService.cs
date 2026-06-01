using System.Threading.Tasks;

namespace OseiVPN.Windows;

public interface IVpnService
{
    Task ConnectAsync();
    Task DisconnectAsync();
}
