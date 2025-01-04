package org.skefir.conf

import com.codeborne.selenide.WebDriverProvider
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.ios.options.XCUITestOptions
import org.openqa.selenium.Capabilities
import org.openqa.selenium.WebDriver
import org.skefir.common.DataConstants
import org.skefir.common.DataConstants.APPIUM_URL
import org.skefir.common.DataConstants.IOS_DEVICE_NAME
import org.skefir.common.DataConstants.IOS_PLATFORM_VERSION
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
        options.setDeviceName(IOS_DEVICE_NAME)
        options.setPlatformVersion(IOS_PLATFORM_VERSION)
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