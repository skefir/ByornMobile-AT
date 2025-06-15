package page

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.appium.SelenideAppium.`$`
import com.codeborne.selenide.appium.selector.CombinedBy
import io.appium.java_client.AppiumBy
import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSBy
import java.awt.Button

class MainPage {

    @iOSBy(id = "a")
    @AndroidFindBy(xpath = "//android.view.View[./*[@content-desc='Add task']]/android.widget.Button")
    lateinit var addNewTask: SelenideElement

    @iOSBy(id = "a")
    @AndroidFindBy(xpath = "//android.widget.EditText[./android.widget.TextView[@text='Task']]")
    lateinit var newTaskTitle: SelenideElement

    @iOSBy(id = "a")
    @AndroidFindBy(xpath = "//android.view.View[./*[@text='Add']]/android.widget.Button")
    lateinit var newTaskCreateButton: SelenideElement



}
