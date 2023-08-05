plugins {
    kotlin("jvm") version "1.8.21"
}

group = "com.blacklisting"
version = "0.0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.opencsv", "opencsv", "5.8")
}
