package org.skefir.conf

import com.codeborne.selenide.WebDriverProvider
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.ios.options.XCUITestOptions
import org.openqa.selenium.Capabilities
import org.openqa.selenium.WebDriver
import org.skefir.common.DataConstants
import org.skefir.common.DataConstants.APPIUM_URL
import java.net.MalformedURLException
import java.net.URI
import javax.annotation.CheckReturnValue
import javax.annotation.Nonnull
import javax.annotation.ParametersAreNonnullByDefault


@ParametersAreNonnullByDefault
object IOSDriverProvider : WebDriverProvider {

    @CheckReturnValue
    @Nonnull
    override fun createDriver(capabilities: Capabilities): WebDriver {
        val options = XCUITestOptions()
        options.merge(capabilities)
        options.setAutomationName("XCUITest")
        options.setPlatformName("iOS")
        options.setDeviceName("iPhone 16 Pro")
        options.setPlatformVersion("18.1")
        options.setApp(DataConstants.IOS_INSTALL_PATH)
        options.setCapability("xcodeSigningId", "iPhone Developer")
        options.setCapability("autoAcceptAlerts", true)

        return try {
            IOSDriver(URI(APPIUM_URL).toURL(), options)
        } catch (e: MalformedURLException) {
            throw RuntimeException(e)
        }
    }

}