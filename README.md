# CI/CD Pipeline for Java Application

## What the Pipeline Does:
- The **CI pipeline** automatically triggers on **push** and **pull request** events to the `main` branch.
- It checks out the source code, sets up **Java 17** using the Temurin distribution, and caches Maven dependencies to speed up builds.
- It builds the Spring Boot Java application using **Maven**, runs tests, and performs **static code analysis** using **SonarCloud**.
- It uploads the generated `.jar` file as a GitHub Actions artifact named `build-artifact`.

- The **release pipeline** is automatically triggered when Git tags matching the pattern `v*.*.*` (e.g., `v1.0.0`) are pushed.
- It builds a Docker image from the project and pushes it to a Docker registry using the provided tag.

## Tools Integrated:
- **GitHub Actions**: for orchestrating CI and release workflows.
- **Maven**: for building and testing the Java application.
- **SonarCloud**: for static code analysis and code quality checks.
- **Docker**: for containerizing the application and publishing Docker images.
- **GitHub Actions Cache**: for caching Maven dependencies and improving build performance.

## Environment Variables and Secrets:
These secrets must be stored securely under **Settings > Secrets and variables > Actions** in the GitHub repository:

- `SONAR_PROJECT_KEY`: SonarCloud project key.
- `SONAR_ORGANIZATION`: SonarCloud organization ID.
- `SONAR_TOKEN`: Authentication token for SonarCloud.
- `REGISTRY_USERNAME`: Docker registry username.
- `REGISTRY_PASSWORD`: Docker registry password.
- `IMAGE_NAME`: Full image name (e.g., `docker.io/yourusername/appname`).

## Artifacts Storage:
- The final `.jar` file is uploaded using the `actions/upload-artifact@v4` action.
- The artifact is named **`build-artifact`** and accessible from the GitHub Actions run.

## Triggering a Release:
To trigger the release workflow and publish a Docker image:

```bash
git tag v1.0.0
git push origin v1.0.0
