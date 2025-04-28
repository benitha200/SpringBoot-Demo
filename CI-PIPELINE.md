# CI Pipeline for Java Application

## What the Pipeline Does:
- The pipeline automatically triggers on push and pull request events to the `main` branch.
- It builds the Spring Boot Java application using Maven, runs tests, and performs a SonarCloud code quality analysis.
- It stores the final build artifact (.jar file) as a GitHub Actions artifact.

## Tools Integrated:
- **GitHub Actions** for the CI pipeline.
- **Maven** for building the Java application.
- **SonarCloud** for code quality analysis.
- **GitHub Secrets** for securely managing sensitive information.

## Environment Variables and Secrets:
- **SONAR_TOKEN**: This secret is used for authenticating with SonarCloud during the code analysis step.

## Artifacts Storage:
- The build artifact (the .jar file) is uploaded and stored in GitHub Actions' artifacts storage using the `actions/upload-artifact` action.
