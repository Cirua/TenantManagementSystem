package com.example.tenantmanagementsystem.data.repository

import androidx.lifecycle.LiveData
import com.example.tenantmanagementsystem.data.local.TenantDao
import com.example.tenantmanagementsystem.data.model.Tenant

// The Repository acts as the single access point to the data layer.
class TenantRepository(
    private val tenantDao: TenantDao
) {

    // Gets all tenants from Room.
    // LiveData automatically receives updates when the database changes.
    val tenants: LiveData<List<Tenant>> =
        tenantDao.getAllTenants()

    // Saves a tenant into the Room database.
    // This must be called from a coroutine.
    suspend fun addTenant(tenant: Tenant) {
        tenantDao.insertTenant(tenant)
    }
}
