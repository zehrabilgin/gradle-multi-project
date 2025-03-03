plugins {
    id("application")
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.google.guava:guava:32.1.1-jre")
}

application {
    mainClass = "com.example.Main"
}


tasks.test {
    useJUnitPlatform()
}

println("Bu satır altProje1'in configuration fazında çalıştı.")

tasks.register("altProje1-task-1") {
    doFirst {
        println("Bu satır altProje1-task-1 görevinin execution fazında çalıştı.")
    }
    doLast {
        println("Bu satır altProje1-task-1 görevinin execution fazında çalıştı.")
    }
    println("Bu satır altProje1-task-1 görevinin configuration fazında çalıştı.")
}



tasks.register("ozelBirGorev") {
    doLast {
        println("Bu özel bir Gradle görevidir")
    }
}

tasks.register("baskaBirGorev") {
    dependsOn("ozelBirGorev")
    doLast {
        println("Bu başka bir Gradle görevidir")
    }
}


if (project.hasProperty("env") && project.property("env") == "dev") {
    dependencies {
        implementation("org.apache.commons:commons-lang3:3.12.0")
    }
} else {
    dependencies {
        implementation("org.apache.commons:commons-lang3:3.12.0") {
            exclude(group = "org.slf4j")
        }
    }
}
























