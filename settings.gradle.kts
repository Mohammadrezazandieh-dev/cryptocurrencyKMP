rootProject.name = "Cryptocurrency-KMP"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {

        /* MYKET REPOSITORY */
        maven {url = uri("https://maven.myket.ir")}


//        google {
//            mavenContent {
//                includeGroupAndSubgroups("androidx")
//                includeGroupAndSubgroups("com.android")
//                includeGroupAndSubgroups("com.google")
//            }
//        }
//        mavenCentral()
//        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {

        /* MYKET REPOSITORY */
        maven {url = uri("https://maven.myket.ir")}


//        google {
//            mavenContent {
//                includeGroupAndSubgroups("androidx")
//                includeGroupAndSubgroups("com.android")
//                includeGroupAndSubgroups("com.google")
//            }
//        }
//        mavenCentral()
    }
}

include(":composeApp")