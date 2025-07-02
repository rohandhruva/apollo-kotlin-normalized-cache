plugins {
  id("org.jetbrains.kotlin.jvm")
}

lib()

dependencies {
  compileOnly(libs.apollo.compiler)
  testImplementation(libs.apollo.compiler)
  testImplementation(gradleTestKit())
  implementation(libs.apollo.ast)
  implementation(libs.kotlin.poet)
  implementation(project(":normalized-cache-definitions"))
  testImplementation(libs.kotlin.test)
}

tasks.withType(Test::class.java).configureEach {
  dependsOn("publishAllPublicationsToLocalRepository")
  dependsOn(":normalized-cache-definitions:publishAllPublicationsToLocalRepository")
  dependsOn(":normalized-cache:publishAllPublicationsToLocalRepository")
}
