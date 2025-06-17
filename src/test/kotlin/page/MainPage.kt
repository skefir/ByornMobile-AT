package page

import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.appium.selector.CombinedBy
import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.By


class MainPage {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Add task']")
    @AndroidFindBy(xpath = "//android.view.View[./*[@content-desc='Add task']]/android.widget.Button")
    lateinit var addNewTask: SelenideElement

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[./XCUIElementTypeStaticText[@name='Task' and @label='Task']]" +
            "/XCUIElementTypeTextView")
    @AndroidFindBy(xpath = "//android.widget.EditText[./android.widget.TextView[@text='Task']]")
    lateinit var newTaskTitle: SelenideElement

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Add']")
    @AndroidFindBy(xpath = "//android.view.View[./*[@text='Add']]/android.widget.Button")
    lateinit var newTaskCreateButton: SelenideElement

    val task: By = CombinedBy
        .android(By.xpath("//android.view.View[./android.widget.RadioButton and ./android.widget.TextView]"))
        .ios(By.xpath("//XCUIElementTypeOther[./XCUIElementTypeButton[@name and @label] and " +
                "./XCUIElementTypeButton[not(@name)] and ./XCUIElementTypeStaticText]" +
                "/XCUIElementTypeButton[@name and @label]"))
}
