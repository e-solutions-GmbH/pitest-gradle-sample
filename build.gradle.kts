plugins {
    id("java")
    id("info.solidsoft.pitest") version "1.9.11"
    id("com.groupcdg.pitest.bitbucket.server") version "1.0.5"
}

repositories {
    mavenCentral()
}

val mockitoVersion = "5.2.0"

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.1")
    testImplementation("org.assertj:assertj-core:3.24.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    testImplementation("org.mockito:mockito-inline:$mockitoVersion")
    testImplementation("org.mockito:mockito-junit-jupiter:$mockitoVersion")

    pitest("com.groupcdg:pitest-git-plugin:1.1.2")
}

tasks.test {
    useJUnitPlatform()
}

pitest {
    mutators.set(setOf("STRONGER"))
    pitestVersion.set("1.15.1")
    targetClasses.set(setOf("de.esolutions.*"))
    junit5PluginVersion.set("1.0.0")
    features.add("+GIT")
    testStrengthThreshold.set(40)

    verbose.set(true)
}

pitestBitbucketServer {
    // required infos automatically populated by env vars on bitbucket-cloud
}