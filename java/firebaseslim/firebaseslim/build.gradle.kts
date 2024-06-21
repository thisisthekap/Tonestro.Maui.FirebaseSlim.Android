plugins {
    id("com.android.library")
}

android {
    namespace = "com.tonestro.firebaseslim"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
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
}

configurations {
    create("copyDependencies")
}

dependencies {
//    implementation("androidx.annotation:annotation:1.3.0")
//    implementation("com.google.android.exoplayer:exoplayer:2.18.6")
//    implementation("androidx.appcompat:appcompat:1.3.1")
//    implementation("com.google.android.material:material:1.4.0")
//    "copyDependencies"("com.google.android.exoplayer:exoplayer:2.18.6")

    // Import the BoM for the Firebase platform
    implementation(platform("com.google.firebase:firebase-bom:31.2.2"))

    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-dynamic-links")
    implementation("com.google.firebase:firebase-messaging")

    "copyDependencies"("com.google.firebase:firebase-analytics-ktx:21.2.0")
    "copyDependencies"("com.google.firebase:firebase-dynamic-links:21.1.0")
    "copyDependencies"("com.google.firebase:firebase-messaging:23.1.1")
}

project.afterEvaluate {
    tasks.register<Copy>("copyDeps") {
        from(configurations["copyDependencies"])
        into("${buildDir}/outputs/deps")
    }
    tasks.named("preBuild") { finalizedBy("copyDeps") }
}
