package org.example.project.appsecret

import org.example.project.getStringResource

actual object AppSecrets {
    actual val apiKey: String
        get() = getStringResource(
            filename = "Secrets",
            fileType = "plist",
            valueKey = "apiKey"
        ) ?: ""
}