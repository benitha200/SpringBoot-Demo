# CI Pipeline for Java Application

## What the Pipeline Does:
- The pipeline automatically triggers on **push** and **pull request** events to the `main` branch.
- It checks out the source code, sets up **Java 17** using the Temurin distribution, and caches Maven dependencies to speed up builds.
- It builds the Spring Boot Java application using **Maven**, runs tests, and skips tests during the build step to ensure a clean package.
- It uploads the generated `.jar` file as a GitHub Actions artifact.

## Tools Integrated:
- **GitHub Actions**: for orchestrating the continuous integration workflow.
- **Maven**: for building and testing the Java application.
- **GitHub Actions Cache**: for caching Maven dependencies and improving build performance.

## Environment Variables and Secrets:
- No external secrets (like tokens) are used in this workflow.
- Environment settings are configured via action inputs, such as specifying **Java version 17**.

## Artifacts Storage:
- The final build artifact (`.jar` file) is uploaded and stored using the **actions/upload-artifact@v4** action.
- The artifact is accessible through the GitHub Actions run under the name **`build-artifact`**.
