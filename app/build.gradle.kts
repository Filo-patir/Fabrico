import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    alias(libs.plugins.apollo)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.filonKiro.fabrico"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.filonKiro.fabrico"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        val properties = Properties()
        properties.load(project.rootProject.file("local.properties").inputStream())
        buildConfigField("String", "ADMIN_KEY", properties.getProperty("ADMIN_API_ACCESS_TOKEN"))
        buildConfigField("String", "STOREFRONT_KEY", properties.getProperty("STOREFRONT_ACCESS_TOKEN"))
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
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
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //Timber
    implementation (libs.timber)

    // Navigation
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    //retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    //Apollo
    implementation(libs.apollo.runtime)

    // OkHttp Logging (optional, for debugging)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

    //coil for images
    implementation(libs.coil.compose)

    //SwipeToRefresh
    implementation(libs.accompanist.swiperefresh) // Check for the latest version

    //google icons
    implementation(libs.androidx.material.icons.extended.android)

    //Animation
    implementation(libs.lottie.compose)

    //Pagination
    implementation(libs.androidx.paging.runtime.ktx)

    //Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    implementation(libs.androidx.hilt.navigation.compose)


    // Testing
    testImplementation(libs.androidx.core)
    testImplementation(libs.robolectric)
    testImplementation(libs.androidx.core.testing)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.robolectric)

    // Mockito for mocking
    testImplementation (libs.mockito.core)
    testImplementation (libs.mockito.inline)
    testImplementation (libs.mockito.kotlin)
    testImplementation (libs.turbine)
    testImplementation (libs.kotlinx.coroutines.test)
}

kapt {
    correctErrorTypes = true
}

apollo {
    val properties = Properties()
    properties.load(project.rootProject.file("local.properties").inputStream())
    service("service") {
        packageName.set("com.filonKiro.fabrico")
        introspection {
            endpointUrl.set("https://android-alex-team4.myshopify.com/api/2024-10/graphql.json")
            headers.put("X-Shopify-Storefront-Access-Token", properties.getProperty("STOREFRONT_ACCESS_TOKEN"))
            schemaFile.set(file("src/main/graphql/schema.graphqls"))
        }
    }
}