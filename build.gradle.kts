buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.junit.platform:junit-platform-gradle-plugin:1.2.0")
    }
}
repositories {
    mavenCentral()
}

plugins {
    id("java-library")
    id("eclipse")
    id("idea")
    id("maven-publish")
}

group = "org.jeremiahboothe"
version = "1.0-SNAPSHOT"


dependencies {
    implementation("org.openapitools:openapi-generator:7.1.0")
    //implementation "org.jetbrains.kotlin:kotlin-reflect:$kotlin_version"
    implementation("com.squareup.moshi:moshi-kotlin:1.9.2")
    implementation("com.squareup.moshi:moshi-adapters:1.9.2")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

}

publishing {
    publications {


        create<MavenPublication>("myLibrary") {
            from(components["java"])
            withBuildIdentifier()
        }

        repositories {
            maven {
                name = "myRepo" //indeed it is
                url =
                    uri(layout.buildDirectory.dir("C:/Users/jerem/.m2/repository")) //replace with your local repository uri
            }
        }
    }
}

tasks.test {
    useJUnitPlatform()
}