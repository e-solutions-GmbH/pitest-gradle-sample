plugins {
    id("java")
    id("info.solidsoft.pitest") version "1.9.11"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.test {
    useJUnitPlatform()
}

pitest {
    pitestVersion.set("1.14.2")
    targetClasses.set(setOf("de.esolutions.*"))
    junit5PluginVersion.set("1.0.0")
}