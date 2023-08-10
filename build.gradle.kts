plugins {
    kotlin("jvm") version "1.8.21"
    `maven-publish`
}

group = "com.blacklisting"
version = "0.0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.opencsv", "opencsv", "5.8")
}

publishing {
    repositories {
        maven {
            name = "LocalM2"
        }
    }
    publications {
        create<MavenPublication>("blacklisting.lib") {
            groupId = "com.blacklisting"
            artifactId = "lib"
            version = "0.0.0.1"
            from(components["java"])
            pom {
                name.set("blacklisting.lib")
                developers {
                    developer {
                        id.set("Blacklisting")
                        name.set("Blacklisting")
                        email.set("who@knows.me")
                    }
                }
                scm {
                    url.set("git@github.com:blacklisting/lib")
                }
            }
        }
    }
}
