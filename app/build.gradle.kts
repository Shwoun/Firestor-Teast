plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.firestorteast"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.firestorteast"
        minSdk = 29
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.firestore)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation ("com.google.firebase:firebase-firestore-ktx:24.9.0")
    implementation ("com.google.firebase:firebase-auth-ktx:22.2.0")


    // Firebase BoM (বেসিক Firebase ডিপেন্ডেন্সিগুলো ম্যানেজ করার জন্য)
    // implementation (platform("com.google.firebase:firebase-bom:32.7.0")
    implementation("androidx.navigation:navigation-compose:2.7.5")
    implementation("androidx.compose.foundation:foundation:1.6.0")

    // Jetpack Compose ডিপেন্ডেন্সিগুলো (যদি না থাকে)
    implementation ("androidx.compose.runtime:runtime-livedata:1.6.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")

    // Coroutines (Firebase অপারেশনগুলোর জন্য)
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.7.3")
}