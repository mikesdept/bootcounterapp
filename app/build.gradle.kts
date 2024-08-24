plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlin.ksp)
}

android {
    namespace = "mikes.dept.bootcounterapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "mikes.dept.bootcounterapp"
        minSdk = 24
        targetSdk = 34
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
        debug {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    // Modules
    implementation(projects.domain)
    implementation(projects.data)
    implementation(projects.presentation)

    //DI
    implementation(libs.dagger)
    ksp(libs.dagger.compiler)

    // Room
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)

    implementation(libs.androidx.appcompat)
    implementation(libs.material)
}
