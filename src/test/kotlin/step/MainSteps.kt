package step

import com.codeborne.selenide.CollectionCondition.size
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.appium.SelenideAppium.`$`
import page.MainPage

class MainSteps {
    val loginPage by lazy { Selenide.page<MainPage>() }

    fun addTask(taskTitle: String) {
        `$`(loginPage.newTaskFieldSelector).type(taskTitle)
        `$`(loginPage.addTaskButtonSelector).click()

    }

    fun checkTaskCount(taskCount: Int) {
        loginPage.taskElements().shouldHave(size(taskCount))
    }
}
