package org.skefir.common


import org.apache.commons.configuration2.Configuration
import org.apache.commons.configuration2.FileBasedConfiguration
import org.apache.commons.configuration2.PropertiesConfiguration
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder
import org.apache.commons.configuration2.builder.fluent.Parameters


object DataConstants {
    val CONFIG: Configuration by lazy {
            FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration::class.java)
                .configure(
                    Parameters().properties()
                        .setFileName(System.getProperty("autotest.config.file", "autotest.properties"))
                ).configuration
       }
    val CURRENT_PLATFORM = CONFIG.getString("platform")
    val APPIUM_URL = CONFIG.getString("appium.url", "http://127.0.0.1:4723/wd/hub")
    val IOS_INSTALL_PATH = CONFIG.getString("ios.install.path", "/work/sasha/testapk/OmniNotes-alphaDebug-6.2.0.apk")
    val ANDROID_INSTALL_PATH = CONFIG.getString("android.install.path", "/work/sasha/testapk/OmniNotes-alphaDebug-6.2.0.apk")
}

enum class PLATFORM {
    ANDROID,
    IOS
}