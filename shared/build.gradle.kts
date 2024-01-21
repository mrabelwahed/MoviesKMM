plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    //Kotlinx Serialization
    kotlin("plugin.serialization") version "1.8.0"
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    //Dependencies versions
    val coroutinesVersion = "1.6.4"
    val ktorVersion = "2.2.1"
    val koinVersion = "3.3.2"

    sourceSets {
        commonMain.dependencies {
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
            implementation("io.ktor:ktor-client-core:$ktorVersion")
            implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
            implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

            //Use api so that the android app can use it as well
            api("io.insert-koin:koin-core:$koinVersion")
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        androidMain.dependencies {
                implementation("io.ktor:ktor-client-android:$ktorVersion")
                api("io.insert-koin:koin-android:$koinVersion")
        }

        iosMain.dependencies {
            implementation("io.ktor:ktor-client-darwin:$ktorVersion")
        }
    }
}

android {
    namespace = "com.ramadanapps.movieskmm"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}
