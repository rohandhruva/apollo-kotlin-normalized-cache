plugins {
  id("org.jetbrains.kotlin.jvm")
}

lib()

dependencies {
  implementation(libs.apollo.ast)
}
