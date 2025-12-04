import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.binary.compatibility.validator)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
    `maven-publish`
    signing
}

group = "com.revoid"

repositories {
    mavenCentral()
    mavenLocal()
    google()
    maven {
        // Tu repositorio de revoid-patcher
        url = uri("https://maven.pkg.github.com/cupul-miu-04/revoid-patcher")
        credentials {
            username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_ACTOR")
            password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
        }
    }
    maven {
        // Repositorio original de ReVanced (si aún necesitas otras dependencias)
        url = uri("https://maven.pkg.github.com/revanced/registry")
        credentials {
            username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_ACTOR")
            password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
        }
    }
    maven { url = uri("https://jitpack.io") }
}

kotlin {
    jvm {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }
    }

    androidTarget {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }

        publishLibraryVariants("release")
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.core.ktx)
            implementation(libs.libsu.nio)
            implementation(libs.libsu.service)
        }

        commonMain.dependencies {
            implementation(libs.apksig)
            implementation(libs.apkzlib)
            implementation(libs.bcpkix.jdk18on)
            implementation(libs.guava)
            implementation(libs.jadb)
            implementation(libs.kotlin.reflect)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.revoid.patcher) // CAMBIADO: revanced.patcher -> revoid.patcher
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test.junit)
            implementation(libs.revoid.patcher) // CAMBIADO: revanced.patcher -> revoid.patcher
        }
    }
}

android {
    namespace = "com.revoid.library"
    compileSdk = 34
    defaultConfig {
        minSdk = 26
    }

    buildFeatures {
        aidl = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

java {
    targetCompatibility = JavaVersion.VERSION_11
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/cupul-miu-04/revoid-library")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_ACTOR")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }

    publications.all {
        if (this !is MavenPublication) return@all

        pom {
            name = "ReVoid Library"
            description = "Library containing common utilities for ReVoid"
            url = "https://github.com/cupul-miu-04/revoid-library"

            licenses {
                license {
                    name = "GNU General Public License v3.0"
                    url = "https://www.gnu.org/licenses/gpl-3.0.en.html"
                }
            }

            developers {
                developer {
                    id = "cupul-miu-04"
                    name = "cupul-miu-04"
                    email = ""
                }
            }

            scm {
                connection = "scm:git:git://github.com/cupul-miu-04/revoid-library.git"
                developerConnection = "scm:git:git@github.com:cupul-miu-04/revoid-library.git"
                url = "https://github.com/cupul-miu-04/revoid-library"
            }
        }
    }
}

signing {
    useGpgCmd()
    sign(publishing.publications)
}