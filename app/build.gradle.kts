plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.deteck.android)
}

android {
    namespace = "com.htd.bottomnavigationdat"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.htd.bottomnavigationdat"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
        this.jvmTarget = "1.8"
//        jdkHome.set(file("path/to/jdkHome"))
    }
//    tasks.withType<io.gitlab.arturbosch.detekt.DetektCreateBaselineTask>().configureEach {
//        this.jvmTarget = "1.8"
//        jdkHome.set(file("path/to/jdkHome"))
//    }

    detekt {
        // Version of detekt that will be used. When unspecified the latest detekt
        // version found will be used. Override to stay on the same version.
        toolVersion = "1.23.3"

        // The directories where detekt looks for source files.
        // Defaults to `files("src/main/java", "src/test/java", "src/main/kotlin", "src/test/kotlin")`.
        source.setFrom("src/main/java", "src/main/kotlin")

        // Builds the AST in parallel. Rules are always executed in parallel.
        // Can lead to speedups in larger projects. `false` by default.
        parallel = false

        // Define the detekt configuration(s) you want to use.
        // Defaults to the default detekt configuration.
        config.setFrom("detekt-config.yml")

        // Applies the config files on top of detekt's default config file. `false` by default.
        buildUponDefaultConfig = false

        // Turns on all the rules. `false` by default.
        allRules = false

        // Specifying a baseline file. All findings stored in this file in subsequent runs of detekt.
//        baseline = file("path/to/baseline.xml")

        // Disables all default detekt rulesets and will only run detekt with custom rules
        // defined in plugins passed in with `detektPlugins` configuration. `false` by default.
        disableDefaultRuleSets = false

        // Adds debug output during task execution. `false` by default.
        debug = false

        // If set to `true` the build does not fail when the
        // maxIssues count was reached. Defaults to `false`.
        ignoreFailures = false

        // Android: Don't create tasks for the specified build types (e.g. "release")
        ignoredBuildTypes = listOf("release")

        // Android: Don't create tasks for the specified build flavor (e.g. "production")
        ignoredFlavors = listOf("production")

        // Android: Don't create tasks for the specified build variants (e.g. "productionRelease")
        ignoredVariants = listOf("productionRelease")

        // Specify the base path for file paths in the formatted reports.
        // If not set, all file paths reported will be absolute file path.
        basePath = projectDir.absolutePath
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.detekt.gradle.plugin)
}