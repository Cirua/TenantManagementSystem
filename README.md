# Tenant Management System

An Android app for landlords to record tenants, see total rent, and call tenants.

## Download Latest APK
See **Releases** on the right of this page.

## Features
- Register and log in
- Dashboard with number of tenants and total rent
- Add tenants and view all tenants (saved with Room)
- Call a tenant, options menu and navigation drawer

## Architecture
- `ui/`: Activities, Fragments and TenantViewModel (UI layer)
- `data/`: Tenant, TenantDao, TenantDatabase, TenantRepository (data layer)

Screens → TenantViewModel (LiveData) → TenantRepository → Room

## Team

| Stage | Member | Admission No. | Pull request |
|---|---|---|---|
| 1 Lead | Angela Thuo | 166243 | (link) |
| 2 ViewModel | Abonyo aaron | 191719 | (https://github.com/Cirua/TenantManagementSystem/pull/1) |
| 3 Room | Faith Langat | 189688 | (https://github.com/Cirua/TenantManagementSystem/pull/2) |
| 4 Screens | Lianne Nduku | 189594 | (http://github.com/Cirua/TenantManagementSystem/pull/3) |
| 5 Data integration | Prince Mwaniki | 188924 | (https://github.com/Cirua/TenantManagementSystem/pull/4) |
| 6 Release | Moses Karinge | 190150 | (link) |
