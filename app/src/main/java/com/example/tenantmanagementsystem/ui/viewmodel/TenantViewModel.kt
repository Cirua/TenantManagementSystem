package com.example.tenantmanagementsystem.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.tenantmanagementsystem.data.local.TenantDatabase
import com.example.tenantmanagementsystem.data.model.Tenant
import com.example.tenantmanagementsystem.data.repository.TenantRepository
import kotlinx.coroutines.launch

// AndroidViewModel receives the Application context.
// This is used to initialise the Room database safely.
class TenantViewModel(application: Application) :
    AndroidViewModel(application) {

    // Build the data layer:
    // Database → DAO → Repository
    private val repository = TenantRepository(
        TenantDatabase.getDatabase(application).tenantDao()
    )

    // Room is now the source of tenant records.
    val tenants: LiveData<List<Tenant>> = repository.tenants

    // Calculates the number of tenants.
    val tenantCountText: LiveData<String> = tenants.map { list ->
        "Tenants\n${list.size}"
    }

    // Calculates the total rent.
    val totalRentText: LiveData<String> = tenants.map { list ->

        val total = list.sumOf {
            it.rent.toDoubleOrNull() ?: 0.0
        }

        "Total rent\nKSh %,.0f".format(total)
    }

    // Produces the tenant information displayed by ViewTenantsFragment.
    val allTenantsText: LiveData<String> = tenants.map { list ->

        if (list.isEmpty()) {
            "No tenants yet. Add one from the Dashboard."
        } else {
            list.joinToString("\n\n") {
                it.summary()
            }
        }
    }

    // Validates tenant information and saves it through the Repository.
    fun addTenant(
        name: String,
        phone: String,
        rent: String
    ): Tenant? {

        val cleanName = name.trim()
        val cleanPhone = phone.trim()
        val cleanRent = rent.trim()

        // All three fields are required.
        if (
            cleanName.isEmpty() ||
            cleanPhone.isEmpty() ||
            cleanRent.isEmpty()
        ) {
            return null
        }

        // Create the tenant object.
        val tenant = Tenant(
            cleanName,
            cleanPhone,
            cleanRent
        )

        // Save the tenant asynchronously.
        viewModelScope.launch {
            repository.addTenant(tenant)
        }

        return tenant
    }

    // Lifecycle logging.
    init {
        Log.d(
            "TENANT_LIFECYCLE",
            "TenantViewModel: created"
        )
    }

    override fun onCleared() {
        super.onCleared()

        Log.d(
            "TENANT_LIFECYCLE",
            "TenantViewModel: onCleared"
        )
    }
}

