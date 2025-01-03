package org.skefir.conf


import com.codeborne.selenide.WebDriverProvider
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import org.openqa.selenium.Capabilities
import org.openqa.selenium.WebDriver
import org.skefir.common.DataConstants.ANDROID_INSTALL_PATH
import org.skefir.common.DataConstants.APPIUM_URL
import org.skefir.common.DataConstants.CONFIG
import java.io.File
import java.net.URI
import javax.annotation.ParametersAreNonnullByDefault


@ParametersAreNonnullByDefault
object AndroidDriverProvider : WebDriverProvider {
    lateinit var androidDriver: AndroidDriver

    override fun createDriver(capabilities: Capabilities): WebDriver {
        downloadApk()
        val options = UiAutomator2Options()
        options.merge(capabilities)
        options.setAppPackage(CONFIG.getString("app.package"))
        options.setAppActivity(CONFIG.getString("app.activity"))
        androidDriver = AndroidDriver(URI(APPIUM_URL).toURL(), options)

        return androidDriver
    }

    private fun downloadApk() = File(ANDROID_INSTALL_PATH)
}

