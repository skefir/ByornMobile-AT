package config


import com.codeborne.selenide.WebDriverProvider
import common.DataConstants.ANDROID_INSTALL_PATH
import common.DataConstants.APPIUM_URL
import common.DataConstants.CONFIG
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import org.openqa.selenium.Capabilities
import org.openqa.selenium.WebDriver
import java.io.File
import java.net.URI




object AndroidDriverProvider : WebDriverProvider {

    override fun createDriver(capabilities: Capabilities): WebDriver {
        downloadApk()
        val options = UiAutomator2Options()
        options.merge(capabilities)
        options.setAppPackage(CONFIG.getString("app.package"))
        options.setAppActivity(CONFIG.getString("app.activity"))
        return AndroidDriver(URI(APPIUM_URL).toURL(), options)
    }

    private fun downloadApk() = File(ANDROID_INSTALL_PATH)
}


