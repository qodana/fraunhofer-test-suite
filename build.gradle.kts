plugins {
    id("java")
}

group = "fraunhofer_suite"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("javax.servlet:javax.servlet-api:4.0.1")
    implementation("org.springframework:spring-web:5.3.31")
}