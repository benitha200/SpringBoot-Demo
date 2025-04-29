# CI Pipeline for Java Application

## What the Pipeline Does:
- The pipeline automatically triggers on **push** and **pull request** events to the `main` branch.
- It checks out the source code, sets up **Java 17** using the Temurin distribution, and caches Maven dependencies to speed up builds.
- It builds the Spring Boot Java application using **Maven**, runs tests, and performs **static code analysis** using **SonarCloud**.
- It uploads the generated `.jar` file as a GitHub Actions artifact.

## Tools Integrated:
- **GitHub Actions**: for orchestrating the continuous integration workflow.
- **Maven**: for building, testing, and integrating with SonarCloud.
- **SonarCloud**: for static code analysis and code quality checks.
- **GitHub Actions Cache**: for caching Maven dependencies and improving build performance.

## Environment Variables and Secrets:
- **SONAR_PROJECT_KEY**: SonarCloud project key.
- **SONAR_ORGANIZATION**: SonarCloud organization ID.
- **SONAR_TOKEN**: Secure token used for authenticating with SonarCloud.
- These secrets must be stored securely in the GitHub repository's **Settings > Secrets and variables > Actions** section.

## Artifacts Storage:
- The final build artifact (`.jar` file) is uploaded and stored using the **actions/upload-artifact@v4** action.
- The artifact is accessible through the GitHub Actions run under the name **`build-artifact`**.
