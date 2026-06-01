# WINDOWS SETUP

This guide shows how to build and run the Windows starter project (WinUI 3 skeleton).

Prerequisites
- Visual Studio 2022/2023 with .NET 8 and Windows App SDK workload
- Windows 10 19041+ or Windows 11

Steps
1. Open the `windows/src` folder as a project in Visual Studio or open the solution file `windows/OseiVPN.Windows.sln`.
2. Restore NuGet packages.
3. Build and Run.

Notes
- This starter contains stubbed VPN services. Replace VpnServiceStub with real implementations.
- DI host is initialized in `Program.cs` and provides services to App and windows.
