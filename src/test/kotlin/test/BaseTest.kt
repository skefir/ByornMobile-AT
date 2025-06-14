package test

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import common.DataConstants
import common.DataConstants.CURRENT_PLATFORM
import common.PLATFORM
import config.AndroidDriverProvider
import config.IOSDriverProvider
import org.junit.jupiter.api.BeforeEach
import step.AndroidStepFactory
import step.IOSStepFactory
import step.StepFactory

open class BaseTest {

    val stepFactory: StepFactory by lazy {
        when (CURRENT_PLATFORM) {
            PLATFORM.ANDROID.name -> AndroidStepFactory()
            PLATFORM.IOS.name -> IOSStepFactory()
            else -> error("Not supported platform ${DataConstants.CONFIG.getString("platform")}")
        }
    }

    @BeforeEach
    fun setUp() {
        Selenide.closeWebDriver()
        Configuration.browserSize = null

        Configuration.browser = when (CURRENT_PLATFORM) {
            PLATFORM.ANDROID.name -> AndroidDriverProvider::class.java.name
            PLATFORM.IOS.name -> IOSDriverProvider::class.java.name
            else -> error("Not supported platform ${DataConstants.CONFIG.getString("platform")}")
        }
        Selenide.open()
    }
}
