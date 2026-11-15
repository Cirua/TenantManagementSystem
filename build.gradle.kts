plugins {
    alias(libs.plugins.android.application) apply false
    // Safe Args: generates classes for passing data between screens
    id("androidx.navigation.safeargs.kotlin") version "2.9.8" apply false
    // KSP generates Room's database code while building
    id("com.google.devtools.ksp") version "2.0.21-1.0.25" apply false
}