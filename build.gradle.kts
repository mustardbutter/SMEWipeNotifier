plugins {
    id("java")
    id("application")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.jar {
    manifest.attributes["Main-Class"] = "ru.otkatNotifier.Main"
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    implementation ("net.dv8tion:JDA:5.0.0-beta.19")
}