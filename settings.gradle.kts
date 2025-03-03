/*
 * This file was generated by the Gradle 'init' task.
 *
 * The settings file is used to specify which projects to include in your build.
 * For more detailed information on multi-project builds, please refer to https://docs.gradle.org/8.12.1/userguide/multi_project_builds.html in the Gradle documentation.
 */

pluginManagement {
    repositories {
        gradlePluginPortal() // Use Gradle Plugin Portal
        mavenCentral() // Use Maven Central
        maven {
            url = uri("https://özel-repo-adresi.com")
        }
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "org.springframework.boot") {
                useVersion("3.1.0")
            }
        }
    }
}

plugins {
    // foojay-resolver plugin uygulandığında otomatik JDK indirilmesine izin verilir
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

rootProject.name = "gradle-multi-project"
include("app")
include("altProje1")

println("Initialization fazı çalıştı.")
include("parentProje")
