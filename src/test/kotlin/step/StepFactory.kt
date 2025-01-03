package step

abstract class StepFactory {
    private val mainStepsI by lazy {
        MainSteps()
    }
    fun getLoginSteps(): MainSteps {
        return mainStepsI
    }
}