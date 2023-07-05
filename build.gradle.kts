import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
	id("org.springframework.boot") version "3.0.6"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22"
	kotlin("plugin.jpa") version "1.7.22"
}

group = "com.kotlinspring"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	//web
	implementation("org.springframework.boot:spring-boot-starter-web")

	//validator
	implementation("org.springframework.boot:spring-boot-starter-validation")

	//kotlin
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	//logging
	implementation("io.github.microutils:kotlin-logging-jvm:3.0.5")

	//db
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	// runtimeOnly("com.h2database:h2")
	runtimeOnly("org.postgresql:postgresql")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.boot:spring-boot-starter-webflux")
	testImplementation("io.mockk:mockk:1.13.5")
	testImplementation("com.ninja-squad:springmockk:4.0.2")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

sourceSets {
	test {

		// After gradle 7.1
		java {
			setSrcDirs(listOf("src/test/intg", "src/test/unit"))
		}

		// Before gradle 7.1
		/*withConvention(KotlinSourceSet::class) {
			kotlin.setSrcDirs(listOf("src/test/intg", "src/test/unit"))
		}*/
	}
}
