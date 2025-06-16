package page

import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.appium.selector.CombinedBy
import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSBy
import org.openqa.selenium.By


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

    val task: By = CombinedBy
        .android(By.xpath("//android.view.View[./android.widget.RadioButton and ./android.widget.TextView]"))
        .ios(By.xpath("//XCUIElementTypeButton[@name='Login']"))


}
