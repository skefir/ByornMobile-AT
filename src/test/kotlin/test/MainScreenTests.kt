package test

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode


@Execution(ExecutionMode.CONCURRENT)
class MainScreenTests : BaseTest() {


    @Test
    fun taskCreateTest() {
        val loginSteps = stepFactory.getLoginSteps()
        loginSteps.addTask("Task1")
        loginSteps.checkTaskCount(1)
    }
}
