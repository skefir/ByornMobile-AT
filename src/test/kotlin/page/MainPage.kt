package page

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.appium.SelenideAppium.`$`
import com.codeborne.selenide.appium.selector.CombinedBy
import io.appium.java_client.AppiumBy

class MainPage {
    val taskSectionSelector by lazy {
        CombinedBy.android(AppiumBy.xpath("//android.view.View[@content-desc='##Backlog']"))
            .ios(AppiumBy.accessibilityId("##Backlog"))
    }

    val taskElementSelector by lazy {
        CombinedBy.android(
            AppiumBy.xpath(".//android.view.View[@content-desc and .//android.view.View[@content-desc]]")
        )
            .ios(AppiumBy.accessibilityId("taskElement"))
    }

    val newTaskFieldSelector by lazy {
        CombinedBy.android(AppiumBy.xpath("//android.widget.EditText[1]"))
            .ios(AppiumBy.accessibilityId("newTaskField"))
    }

    val addTaskButtonSelector by lazy {
        CombinedBy.android(AppiumBy.xpath("//android.widget.Button[4]"))
            .ios(AppiumBy.accessibilityId("addTaskButton"))
    }


    fun taskElements(): ElementsCollection = `$`(taskSectionSelector).`$$`(taskElementSelector)
}