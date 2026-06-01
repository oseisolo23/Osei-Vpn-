# ARCHITECTURE

Osei VPN follows a modular MVVM + Clean Architecture approach.

Layers:
- UI (Jetpack Compose / WinUI 3)
- Presentation (ViewModels)
- Domain (interfaces, business rules)
- Data (Repository, Room, Network)
- Services (VpnService, connection manager, protocol adapters)

Key components:
- Hilt for DI
- Room for local storage
- VpnService + ProtocolAdapter abstraction for VPN implementations

