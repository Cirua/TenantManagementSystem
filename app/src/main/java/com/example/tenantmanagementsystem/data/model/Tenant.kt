package com.example.tenantmanagementsystem.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

// @Entity: every Tenant is stored as one ROW in the "tenants" table
@Entity(tableName = "tenants")
data class Tenant(
    // Each property becomes a COLUMN in the table
    val name: String,
    val phone: String,
    val rent: String,

    // A unique ID number for each row; Room fills it in automatically (1, 2, 3...)
    // id = 0 means "not saved yet" and keeps existing code working
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
): Serializable {
    fun summary(): String {
        return "Tenant: $name\nPhone: $phone\nRent: KSh $rent"
    }
}