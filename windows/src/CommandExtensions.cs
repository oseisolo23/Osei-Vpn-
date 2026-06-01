using System.Threading.Tasks;
using System.Windows.Input;

namespace OseiVPN.Windows;

public static class CommandExtensions
{
    public static Task ExecuteAsyncSafe(this ICommand command)
    {
        var tcs = new TaskCompletionSource<object?>();
        try
        {
            command.Execute(null);
            tcs.SetResult(null);
        }
        catch (System.Exception ex)
        {
            tcs.SetException(ex);
        }
        return tcs.Task;
    }
}
