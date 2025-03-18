plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("kotlin")
    id("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

kotlin {
    jvmToolchain {
        jvmToolchain(8)
    }
}

dependencies {
    implementation(project(":dagger"))//To include annotations defined my own dagger module/package
    implementation("com.squareup:kotlinpoet:2.0.0")//For code generation
}

