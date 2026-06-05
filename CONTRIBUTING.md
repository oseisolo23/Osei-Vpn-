# Contributing to Osei VPN

Thank you for your interest in contributing to **Osei VPN**! This document provides guidelines and best practices for contributing to this project.

## 🚀 Getting Started

### Prerequisites
- **Android Development:**
  - Android Studio Flamingo or later
  - JDK 17+
  - Android SDK with API 26+
  - Kotlin 1.9.10+

- **Windows Development:**
  - Visual Studio 2022/2023
  - .NET 8 SDK
  - Windows App SDK workload
  - Windows 10 (Build 19041) or Windows 11

### Development Setup

**Android:**
```bash
cd android
# Open in Android Studio
./gradlew build
./gradlew installDebug
```

**Windows:**
```bash
cd windows
# Open in Visual Studio
# Open OseiVPN.Windows.sln
# Build > Build Solution
```

## 📋 Branch Strategy

- **main** - Production-ready, stable releases
- **develop** - Integration branch for features and fixes
- **feature/** - Individual feature branches (e.g., `feature/dark-mode`)
- **bugfix/** - Bug fix branches (e.g., `bugfix/connection-timeout`)
- **docs/** - Documentation updates

### Creating a Branch
```bash
git checkout develop
git pull origin develop
git checkout -b feature/your-feature-name
```

## 📝 Code Style & Conventions

### Kotlin (Android)
- Follow [Kotlin Official Style Guide](https://kotlinlang.org/docs/coding-conventions.html)
- Use meaningful variable and function names
- Add KDoc comments for public functions and classes
- Limit line length to 120 characters
- Use coroutines for async operations, not threads

**Example:**
```kotlin
/**
 * Connects to a VPN server with the given configuration.
 * 
 * @param config The VPN server configuration
 * @return Flow emitting connection status updates
 */
suspend fun connectToVpn(config: VpnConfig): Flow<ConnectionStatus> {
    // Implementation
}
```

### C# (Windows)
- Follow [Microsoft C# Coding Conventions](https://learn.microsoft.com/en-us/dotnet/csharp/fundamentals/coding-style/coding-conventions)
- Use PascalCase for public members
- Add XML comments for public APIs
- Use async/await for asynchronous operations
- Implement IDisposable for resource cleanup

**Example:**
```csharp
/// <summary>
/// Connects to a VPN server with the specified configuration.
/// </summary>
/// <param name="config">The VPN server configuration</param>
/// <returns>A task representing the asynchronous operation</returns>
public async Task ConnectAsync(VpnConfiguration config)
{
    // Implementation
}
```

## 🧪 Testing Requirements

### Android
- Write unit tests for ViewModels and Repositories
- Aim for >70% code coverage for critical components
- Use JUnit4 and Mockito

```bash
./gradlew test
./gradlew connectedAndroidTest
```

### Windows
- Write unit tests for ViewModels and Services
- Use xUnit or NUnit

```bash
dotnet test
```

### Running Tests
All tests must pass before submitting a PR:
```bash
# Android
./gradlew test

# Windows
dotnet test
```

## 🔍 Before Submitting a Pull Request

- [ ] **Branch is up to date:** Rebase onto `develop` if needed
- [ ] **Code follows style guidelines** - Run linters
- [ ] **All tests pass** - No failing unit or integration tests
- [ ] **No security issues** - No hardcoded credentials, API keys, or secrets
- [ ] **Documentation updated** - Update README or docs if behavior changed
- [ ] **Changelog updated** - Add entry to relevant section
- [ ] **Commit messages are clear** - Use conventional commits

### Conventional Commit Format
```
<type>(<scope>): <subject>

<body>

<footer>
```

**Types:** `feat`, `fix`, `docs`, `style`, `refactor`, `perf`, `test`, `chore`

**Example:**
```
feat(android): add dark mode support for connection dashboard

- Implement system theme detection
- Add dark theme color palette
- Update all UI components for dark mode compatibility

Closes #42
```

## ✅ Pull Request Checklist

When creating a PR, include:

1. **Description:** Clear description of changes
2. **Type:** Bug fix, Feature, Documentation, etc.
3. **Related Issues:** Link any related issues (e.g., `Closes #123`)
4. **Testing:** How to test the changes
5. **Screenshots:** For UI changes (if applicable)

**PR Template:**
```markdown
## Description
Brief description of what this PR does.

## Type of Change
- [ ] Bug fix
- [ ] New feature
- [ ] Documentation update
- [ ] Performance improvement

## Related Issues
Closes #123

## How to Test
1. Step 1
2. Step 2
3. Verify expected behavior

## Screenshots (if applicable)
[Add screenshots for UI changes]

## Checklist
- [ ] My code follows the project's style guidelines
- [ ] I have performed a self-review
- [ ] All tests pass
- [ ] I have updated documentation
- [ ] No new warnings generated
```

## 🚨 Important Notes

### Security
- **Never commit credentials, API keys, or secrets**
- Use GitHub Secrets for CI/CD
- Report security vulnerabilities privately to the maintainers
- Encrypt sensitive data at rest

### VPN Implementation
- This is a starter/skeleton project
- Replace `VpnServiceStub` implementations with real VPN protocol handlers
- Ensure compliance with platform-specific VPN regulations
- Test thoroughly on actual devices

### Performance
- Keep the APK size minimal
- Optimize database queries
- Profile memory usage on target devices
- Test battery impact on long-running connections

## 📚 Documentation

If your changes affect:
- **Setup/Installation** → Update `docs/SETUP.md` or `docs/WINDOWS_SETUP.md`
- **Architecture** → Update `docs/ARCHITECTURE.md`
- **Development** → Update `docs/DEVELOPMENT.md`
- **API/Interfaces** → Update relevant inline documentation

## 🐛 Reporting Bugs

When reporting bugs, please include:
- **Device/Platform** (e.g., Android 13, Windows 11)
- **Version** (from Settings or About page)
- **Steps to reproduce** (detailed steps)
- **Expected behavior**
- **Actual behavior**
- **Logs** (if applicable)
- **Screenshots** (if applicable)

## 💡 Feature Requests

For feature requests:
- **Describe the use case** - Why is this feature needed?
- **Provide examples** - How should it work?
- **Consider alternatives** - Are there other solutions?
- **Implementation notes** - Any technical considerations?

## ✨ Code Review Process

1. Maintainers review your PR
2. Feedback provided (if any)
3. Address comments and push updates
4. PR approved and merged

**Note:** Code reviews may take 2-7 days depending on complexity.

## 🤝 Community Guidelines

- Be respectful and inclusive
- Assume good intentions
- Provide constructive feedback
- Help others learn and grow
- Report violations of conduct to maintainers

## 📞 Need Help?

- 📖 Check the [Documentation](docs/)
- 🐛 Search [Issues](../../issues) for similar problems
- 💬 Create a new discussion if uncertain
- 📧 Contact maintainers directly

## 📄 License

By contributing, you agree that your contributions will be licensed under the same license as the project (Proprietary).

---

**Thank you for making Osei VPN better!** 🎉
