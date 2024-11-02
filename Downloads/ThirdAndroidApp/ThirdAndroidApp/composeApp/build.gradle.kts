import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    //(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
//    androidTarget {
//        @OptIn(ExperimentalKotlinGradlePluginApi::class)
//        compilerOptions {
//            jvmTarget.set(JvmTarget.JVM_11)
//        }
//    }

    jvm("desktop")

    sourceSets {
        val desktopMain by getting

//        androidMain.dependencies {
//            implementation(compose.preview)
//            implementation(libs.androidx.activity.compose)
//        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)



            implementation("io.coil-kt.coil3:coil-compose:3.0.0-rc01")
            implementation("io.coil-kt.coil3:coil-network-okhttp:3.0.0-rc01")
        }
        desktopMain.dependencies {

            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)
        }
    }
}
//android {
//    namespace = "org.example.secondandroidapp"
//    compileSdk = libs.versions.android.compileSdk.get().toInt()
//
//    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
//    sourceSets["main"].res.srcDirs("src/androidMain/res")
//    sourceSets["main"].resources.srcDirs("src/commonMain/resources")
//
//    defaultConfig {
//        applicationId = "org.example.secondandroidapp"
//
//        minSdk = libs.versions.android.minSdk.get().toInt()
//        targetSdk = libs.versions.android.targetSdk.get().toInt()
//        versionCode = 1
//        versionName = "1.0"
//    }
//    packaging {
//        resources {
//            excludes += "/META-INF/{AL2.0,LGPL2.1}"
//        }
//    }
//    buildTypes {
//        getByName("release") {
//            isMinifyEnabled = false
//        }
//    }
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_11
//        targetCompatibility = JavaVersion.VERSION_11
//    }
//    buildFeatures {
//        compose = true
//    }
//    dependencies {
//        debugImplementation(compose.uiTooling)
//    }
//}
//dependencies {
//    implementation(libs.androidx.material3.desktop)
//    implementation(libs.androidx.ui.graphics.android)
//    implementation(libs.androidx.material3.android)
//    implementation(libs.androidx.compose.material3)
//    implementation(libs.androidx.runtime.saveable.desktop)
//    implementation(libs.androidx.benchmark.macro)
//    implementation(libs.androidx.ui.desktop)
//    implementation(libs.androidx.foundation.layout.desktop)
//    implementation(libs.androidx.ui.graphics.desktop)
//    implementation(libs.androidx.runtime.desktop)
//    implementation(libs.volley)
//    implementation(libs.wearable)
//    implementation(libs.androidx.ui.util.desktop)
//}

compose.desktop {
    application {
        mainClass = "org.example.secondandroidapp.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "org.example.secondandroidapp"
            packageVersion = "1.0.0"
        }
    }
}
