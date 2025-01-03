package test

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.BeforeEach
import org.skefir.common.DataConstants
import org.skefir.common.DataConstants.CURRENT_PLATFORM
import org.skefir.common.PLATFORM
import org.skefir.conf.AndroidDriverProvider
import org.skefir.conf.IOSDriverProvider
import step.AndroidStepFactory
import step.IOSStepFactory
import step.StepFactory

open class BaseTest {

    val stepFactory: StepFactory by lazy {
        when (CURRENT_PLATFORM) {
            PLATFORM.ANDROID.name -> AndroidStepFactory()
            PLATFORM.IOS.name -> IOSStepFactory()
            else -> throw IllegalStateException("Not supported platform ${DataConstants.CONFIG.getString("platform")}")
        }
    }

    @BeforeEach
    fun setUp() {
        Selenide.closeWebDriver()
        Configuration.browserSize = null

        Configuration.browser = when (CURRENT_PLATFORM) {
            PLATFORM.ANDROID.name -> AndroidDriverProvider::class.java.name
            PLATFORM.IOS.name -> IOSDriverProvider::class.java.name
            else -> throw IllegalStateException("Not supported platform ${DataConstants.CONFIG.getString("platform")}")
        }
        Selenide.open()
    }
}