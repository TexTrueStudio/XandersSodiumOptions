plugins {
    java
    `maven-publish`
    id("dev.architectury.loom") version "1.1-SNAPSHOT"
    id("io.github.juuxel.loom-quiltflower") version "1.+"
}

base.archivesName.set("${project.property("archivesBaseName")}-mc1.19.3")
group = "${project.property("mavenGroup")}"
version = "${project.property("modVersion")}"

loom{
    forge{
        mixinConfig("xanders-sodium-options.mixins.json")
    }
}

repositories {
    mavenCentral()
    maven("https://maven.isxander.dev/releases")
    maven("https://maven.isxander.dev/snapshots")
    maven("https://maven.flashyreese.me/releases")
    maven("https://maven.flashyreese.me/snapshots")
    maven("https://maven.shedaniel.me")
    maven("https://maven.terraformersmc.com")
    maven("https://jitpack.io")
    maven("https://maven.gegy.dev")
    maven("https://api.modrinth.com/maven") {
        content {
            includeGroup("maven.modrinth")
        }
    }
}

dependencies {
    minecraft("com.mojang:minecraft:${project.property("minecraftVersion")}")
    mappings("net.fabricmc:yarn:${project.property("minecraftVersion")}+build.+:v2")
    forge("net.minecraftforge:forge:${project.property("forgeVersion")}")

    modImplementation("com.github.TexTrueStudio:YetAnotherConfigLib-Forge:mc1.19.3-v1.0.0")
    modImplementation("maven.modrinth:rubidium:0.6.3")

    // rubidium extra better options compat
    modImplementation("maven.modrinth:rubidium-extra:0.4.16+mc1.19.3-build.56")
    // moreculling category placement
    //modImplementation("maven.modrinth:moreculling:v0.12.3")
    // oculus category placement
    modImplementation("maven.modrinth:oculus:1.19.2-1.2.8a")
    // entityviewdistance button option compat
    //modImplementation("maven.modrinth:entity-view-distance:1.1.0+1.19.3")

    modRuntimeOnly("me.shedaniel.cloth:cloth-config-forge:9.0.+")
    //modRuntimeOnly("dev.lambdaurora:spruceui:4.1.0+1.19.3")

    implementation(include(annotationProcessor("com.github.llamalad7:mixinextras:0.1.1")!!)!!)
}

tasks {
    processResources {
        inputs.property("version", project.version)

        filesMatching("META-INF/mods.toml") {
            expand("version" to project.version)
        }
    }
}

java {
    withSourcesJar()   
}

publishing {
    publications {
        create<MavenPublication>("mod") {
            groupId = "${project.property("mavenGroup")}"
            artifactId = "${project.property("archivesBaseName")}-mc1.19.3"

            from(components["java"])
        }
    }

    repositories {

    }
}
