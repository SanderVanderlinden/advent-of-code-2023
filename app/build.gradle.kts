// Top-level build configuration
plugins {
    application
    id("org.sonarqube") version "4.4.1.3373"
    jacoco
}

val jUnitJupiterVersion = "5.9.3"
val guavaVersion = "32.1.1"
val javaVersion = "21"
val mockitoVersion = "5.8.0"

// Configure repositories used for resolving dependencies
repositories {
    mavenCentral()
}

// Dependency declarations
dependencies {
    implementation("com.google.guava:guava:$guavaVersion-jre")

    testImplementation("org.junit.jupiter:junit-jupiter:$jUnitJupiterVersion")
    testImplementation("org.mockito:mockito-core:$mockitoVersion")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

// Java-specific configuration
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(javaVersion))
    }
}

// Application plugin configuration
application {
    mainClass.set("com.sandervanderlinden.adventofcode2023.App")
}

// Configuration for unit tests using JUnit Platform
tasks.named<Test>("test") {
    useJUnitPlatform()
}

// SonarQube plugin configuration
sonarqube {
    properties {
        property("sonar.gradle.skipCompile", "true")
        property("sonar.projectKey", "AdventOfCode2023")
        property("sonar.projectName", "AdventOfCode2023")
        property("sonar.host.url", System.getenv("SONARQUBE_URL"))
        property("sonar.token", System.getenv("SONARQUBE_TOKEN"))
        property("sonar.junit.reportPaths", "build/reports/tests/test")
        property("sonar.scm.provider", "git")
    }
}

// JaCoCo plugin configuration for test coverage
tasks.jacocoTestReport {
    reports {
        xml.required.set(true)
        html.required.set(true)
    }
}

// Link the test report generation with the test task
tasks.test {
    finalizedBy("jacocoTestReport")
}
