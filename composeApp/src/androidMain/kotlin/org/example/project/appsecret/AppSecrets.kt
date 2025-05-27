package org.example.project.appsecret

import org.example.project.BuildConfig

actual object AppSecrets {
    actual val apiKey: String
        get() = BuildConfig.API_KEY
}