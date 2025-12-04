// TODO: Figure out why this causes problems.
rootProject.name = "revoid-library"  // CAMBIADO: revanced-library -> revoid-library

buildCache {
    local {
        isEnabled = "CI" !in System.getenv()
    }
}

pluginManagement {
    repositories {
        google()
        mavenCentral()
    }
}