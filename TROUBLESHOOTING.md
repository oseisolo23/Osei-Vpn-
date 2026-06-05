# Troubleshooting Guide - Osei VPN

Common issues and solutions for building and running Osei VPN.

## 📱 Android Issues

### Build Fails with "Gradle sync failed"

**Solution:**
```bash
# Clean and rebuild
./gradlew clean
./gradlew build --refresh-dependencies

# If still failing, check your local.properties
echo "sdk.dir=$ANDROID_HOME" > android/local.properties
```

### "Hilt kapt compilation error"

**Solution:**
```bash
# Invalidate Android Studio caches
# File > Invalidate Caches > Invalidate and Restart

# Or rebuild with clean
./gradlew clean
./gradlew build -x lint
```

### APK Installation Fails

**Solution:**
```bash
# Uninstall existing app
adb uninstall com.oseisolo.oseivpn

# Reinstall
./gradlew installDebug

# Or manually
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

### VPN Service Permission Denied

**Error:** `"BIND_VPN_SERVICE" permission denied`

**Solution:**
- Go to **Settings > Apps > Osei VPN > Permissions > VPN**
- Grant VPN permission
- For biometric: Grant fingerprint permission in Settings

### Compose Preview Not Working

**Solution:**
```bash
# Rebuild and invalidate caches
./gradlew clean

# Update Compose compiler
# In build.gradle.kts:
kotlinCompilerExtensionVersion = "1.5.3"  # Latest stable

./gradlew build
```

### Room Database Migration Issues

**Error:** `"Migration didn't properly handle"` or `"Schema was changed"`

**Solution:**
```bash
# Clear app data
adb shell pm clear com.oseisolo.oseivpn

# Or use fallback destructive migration (dev only)
# In database setup:
allowMainThreadQueries = true  // Temp only
fallbackToDestructiveMigration = true
```

---

## 🖥️ Windows Issues

### Visual Studio Can't Find .NET 8

**Solution:**
1. **Install .NET 8 SDK:**
   - Download from https://dotnet.microsoft.com/download
   - Run installer with Administrator privileges

2. **Configure in Visual Studio:**
   - Tools > Options > Projects and Solutions > .NET
   - Verify .NET 8 appears in SDK list

3. **Restart Visual Studio**

### WinUI 3 Project Won't Load

**Error:** `"The project type is not supported"`

**Solution:**
1. Install Windows App SDK workload in Visual Studio Installer
2. Tools > Get Tools and Features > Workloads
3. Search for "Windows App SDK"
4. Install and restart Visual Studio

### NuGet Restore Fails

**Solution:**
```bash
# Clear NuGet cache
nuget locals all -clear

# Manual restore
cd windows/src
dotnet restore OseiVPN.Windows.csproj

# Or from Visual Studio
# Tools > NuGet Package Manager > Package Manager Console
# Update-Package -Reinstall
```

### Build Error: "Could not find SDK for platform"

**Solution:**
```bash
# Check your project file targets
# Edit OseiVPN.Windows.csproj

# Ensure:
# <TargetFramework>net8.0-windows10.0.19041.0</TargetFramework>

# Then:
dotnet clean
dotnet build
```

### DI Container Initialization Error

**Error:** `"No service of type X is configured"`

**Solution:**
Check `Program.cs`:
```csharp
private static IHostBuilder CreateHostBuilder() =>
    Host.CreateDefaultBuilder()
        .ConfigureServices((context, services) =>
        {
            services.AddSingleton<MainViewModel>();  // Must be registered
            services.AddSingleton<IVpnService, VpnServiceStub>();
        });
```

---

## 🔧 Common Platform Issues

### Git Clone Fails

**Solution:**
```bash
# Check network
ping github.com

# Try HTTPS instead of SSH (if using SSH)
git clone https://github.com/oseisolo23/Osei-Vpn-.git

# Or SSH setup
ssh-keygen -t ed25519 -C "your-email@example.com"
cat ~/.ssh/id_ed25519.pub  # Add to GitHub SSH keys
```

### Permission Denied on Unix/Mac

**Solution:**
```bash
# Make scripts executable
chmod +x android/gradlew
chmod +x windows/gradlew  # If exists

# Or for specific files
chmod +x build.sh
```

### Disk Space Issues

**Solution:**
```bash
# Android build cache is large
# Clear Gradle cache (Linux/Mac)
rm -rf ~/.gradle/caches

# Or (Windows)
rmdir %USERPROFILE%\.gradle\caches /s /q

# Clear Android cache
rm -rf ~/.android/cache
```

---

## 🔐 Security Issues

### Credentials Accidentally Committed

**Solution:**
```bash
# Immediately revoke any exposed tokens/keys

# Remove from git history
git rm --cached <file>
git commit --amend
git push --force-with-lease

# Or use BFG Repo-Cleaner for large files
bfg --delete-files <filename> .
```

### SSL Certificate Error

**Error:** `"CERTIFICATE_VERIFY_FAILED"`

**Solution:**
```bash
# Update certificates
# macOS
/Applications/Python\ 3.x/Install\ Certificates.command

# Or disable verification (NOT recommended for production)
git config --global http.sslVerify false
```

---

## 📊 Performance Issues

### Slow Gradle Build

**Solution:**
```bash
# Optimize build.gradle
org.gradle.parallel=true
org.gradle.workers.max=8
org.gradle.jvmargs=-Xmx4096m

# Build in offline mode
./gradlew build --offline

# Or use build cache
org.gradle.caching=true
```

### App Crashes on Launch

**Android:**
```bash
# Check logcat
adb logcat | grep -i "oseivpn"

# Or in Android Studio
View > Tool Windows > Logcat
```

**Windows:**
```
# Enable debug output
Debug > Windows > Output
# Run app in Debug mode
Debug > Start Debugging
```

### High Memory Usage

**Android:**
- Check for memory leaks in Logcat
- Profile with Android Profiler
- Reduce image asset sizes

**Windows:**
- Use Visual Studio Debugger Memory Profiler
- Check for event handler leaks
- Profile with dotTrace

---

## 🧪 Testing Issues

### Unit Tests Fail Randomly

**Solution:**
```bash
# Android
./gradlew test --continue  # Run all, don't stop on first fail
./gradlew test --debug     # Enable debug

# Windows
dotnet test --logger:console;verbosity=detailed
```

### Espresso Tests Timeout

**Solution:**
```bash
# Increase timeout in test configuration
@RunWith(AndroidJUnit4::class)
class MyTest {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)
    
    init {
        // Increase timeout
        Espresso.registerIdlingResources(IdlingRegistry.getInstance())
    }
}
```

---

## 📞 Getting More Help

| Resource | Description |
|----------|-------------|
| 📖 [Setup Guide](docs/SETUP.md) | Platform-specific setup |
| 🏗️ [Architecture](docs/ARCHITECTURE.md) | Project structure |
| 💬 [GitHub Issues](../../issues) | Bug reports & features |
| 📧 Maintainers | Direct contact |

---

**Last Updated:** June 2026  
**Version:** 1.0.0
