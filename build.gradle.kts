plugins {
    kotlin("jvm") version "1.9.23"
    id("io.gitlab.arturbosch.detekt").version("1.23.7")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("com.codeborne:selenide-appium:7.9.3")
    testImplementation("org.junit.jupiter:junit-jupiter:5.11.3")
    testImplementation("commons-io:commons-io:2.17.0")
    testImplementation("org.apache.commons:commons-configuration2:2.11.0")
    testImplementation("commons-beanutils:commons-beanutils:1.9.4")
    testRuntimeOnly("org.slf4j:slf4j-simple:2.0.16")


}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
detekt {
    toolVersion = "1.23.7"
    buildUponDefaultConfig = true
}