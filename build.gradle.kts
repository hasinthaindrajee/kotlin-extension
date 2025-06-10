import org.jetbrains.kotlin.backend.wasm.ir2wasm.bind

plugins {
    kotlin("jvm") version "1.9.23"
    id("biz.aQute.bnd.builder") version "7.1.0"
}


group = "org.wso2.carbon.identity.organization.management"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.wso2.org/nexus/content/repositories/releases")
    }
    maven {
        url = uri("https://maven.wso2.org/nexus/content/groups/wso2-public/")
    }
    maven {
        url = uri("https://dist.wso2.org/maven2/")
    }
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation("com.ibm.icu:icu4j:74.2")
    implementation("org.osgi:org.osgi.service.component.annotations:1.2.0")
    annotationProcessor("org.osgi:org.osgi.annotation.processor:1.4.0")
    implementation("org.eclipse.osgi:org.eclipse.osgi.services:3.3.100.v20130513-1956")
    implementation("org.eclipse.osgi:org.eclipse.osgi:3.9.1.v20130814-1242")
    implementation("commons-logging:commons-logging:1.2")
    implementation("org.apache.felix:org.apache.felix.scr.ds-annotations:1.2.8")
    implementation("org.apache.axis2.transport:axis2-transport-mail:2.0.0-wso2v69")
    implementation("org.wso2.carbon.identity.framework:org.wso2.carbon.identity.event:7.8.103")
}

tasks.jar.configure {
    manifest {
        attributes(

            "Bundle-SymbolicName" to "com.turo.wso2.customhandler",
            "Manifest-Version" to "1.0",
            "Bundle-Name" to "com.turo.wso2.customhandler",
            "Bundle-SymbolicName" to "com.turo.wso2.customhandler",
            "Bundle-Version" to version,
            "Bundle-Vendor" to "Turo",
 //          "-removeheaders" to "Require-Capability",
            "Require-Capability" to "",
//            "Bundle-Activator" to "com.turo.wso2.customhandler.internal.CustomUserSelfRegistrationHandlerComponent",
            "Import-Package" to "org.osgi.framework; version=\"[1.2.0, 2.0.0)\",\n" +
                    "     org.osgi.service.*; version=\"[1.2.0, 2.0.0)\",\n" +
                    "     org.apache.commons.logging; version=\"[1.2,2.0)\",\n" +
                    "     org.wso2.carbon.identity.event.*; version=\"[7.1.0, 8.0.0)\"",
            "Export-Package" to "com.turo.wso2.customhandler.handler",
            "Private-Package" to "com.turo.wso2.customhandler.internal",
            "Service-Component" to "OSGI-INF/*.xml",
//            "-dsannotations-options" to "nocapabilities",
            "Require-Capability" to """
                osgi.extender;filter:="(&(osgi.extender=osgi.component)(version>=1.2.0)(!(version>=2.0.0)))",
                osgi.service;filter:="(objectClass=org.wso2.carbon.user.core.service.RealmService)";effective:=active,
                osgi.ee;filter:="(&(osgi.ee=JavaSE)(version=11))"
           """.trimIndent().replace("\n", "")
        )
    }
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(11)
}
