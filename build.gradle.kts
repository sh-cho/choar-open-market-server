import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.2"
	id("io.spring.dependency-management") version "1.0.12.RELEASE"
	id("org.asciidoctor.jvm.convert") version "3.3.2"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	kotlin("plugin.jpa") version "1.6.21"
	kotlin("kapt") version "1.6.21"
}

group = "com.choar"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17


// TODO: better way to manage versions?
val jjwtVersion = "0.11.5"
val mapstructVersion = "1.5.2.Final"
val h2Version = "2.1.214"

val asciidoctorExtensions: Configuration by configurations.creating

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("org.springframework.boot:spring-boot-starter-logging")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-devtools")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.3")
	runtimeOnly("io.jsonwebtoken:jjwt-jackson:$jjwtVersion")
	implementation("io.jsonwebtoken:jjwt-api:$jjwtVersion")
	runtimeOnly("io.jsonwebtoken:jjwt-impl:$jjwtVersion")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

	implementation("org.mapstruct:mapstruct:$mapstructVersion")
	kapt("org.mapstruct:mapstruct-processor:$mapstructVersion")

	// db
	implementation("org.postgresql:postgresql:42.4.0")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	// local & test
	runtimeOnly("com.h2database:h2:$h2Version")
	testImplementation("com.h2database:h2:$h2Version")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
	asciidoctorExtensions("org.springframework.restdocs:spring-restdocs-asciidoctor")
	kaptTest("org.mapstruct:mapstruct-processor:$mapstructVersion")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks {
	val snippetsDir = file("build/generated-snippets")

	clean {
		delete("src/main/resources/static/docs")
	}

	test {
		useJUnitPlatform()
		systemProperty("org.springframework.restdocs.outputDir", snippetsDir)
		outputs.dir(snippetsDir)
	}

	build {
		dependsOn("copyDocument")
	}

	asciidoctor {
		dependsOn(test)
		doFirst {
			delete("src/main/resources/static/docs")
		}

		attributes(
			mapOf("snippets" to snippetsDir)
		)
		inputs.dir(snippetsDir)
	}

	register<Copy>("copyDocument") {
		dependsOn(asciidoctor)

		destinationDir = file(".")
		from(asciidoctor.get().outputDir) {
			into("src/main/resources/static/docs")
		}
	}

	bootJar {
		dependsOn(asciidoctor)

		from(asciidoctor.get().outputDir) {
			into("BOOT-INF/classes/static/docs")
		}
	}
}
