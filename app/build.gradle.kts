import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    id ("java")
    id ("checkstyle")
    id ("com.adarshr.test-logger") version "3.0.0"
    id ("com.github.ben-manes.versions") version "0.39.0"
    id ("jacoco")
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories { mavenCentral() }

dependencies {
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.1")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.1")
    testImplementation("org.assertj:assertj-core:3.21.0")
    testImplementation("org.skyscreamer:jsonassert:1.5.0")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(20))
    }
}

tasks.test {
    useJUnitPlatform()
    // https://technology.lastminute.com/junit5-kotlin-and-gradle-dsl/
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        showStackTraces = true
        // showCauses = true
        showStandardStreams = true
    }
}
jacoco {
    toolVersion = "0.8.11"
    reportsDirectory = layout.buildDirectory.dir("customJacocoReportDir")
}

tasks.jacocoTestReport { reports { xml.required.set(true) } }
