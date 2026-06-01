using System;
using System.Windows.Input;

namespace OseiVPN.Windows;

// Simple RelayCommand to use in ViewModel for the starter
public class RelayCommand : ICommand
{
    private readonly Func<System.Threading.Tasks.Task> _execute;
    private readonly Func<bool>? _canExecute;

    public RelayCommand(Func<System.Threading.Tasks.Task> execute, Func<bool>? canExecute = null)
    {
        _execute = execute;
        _canExecute = canExecute;
    }

    public bool CanExecute(object? parameter) => _canExecute?.Invoke() ?? true;
    public async void Execute(object? parameter) => await _execute();
    public event EventHandler? CanExecuteChanged;
    public void RaiseCanExecuteChanged() => CanExecuteChanged?.Invoke(this, EventArgs.Empty);
}
