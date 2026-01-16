# Bank Application - Maven & Testing Exercises

This project is a Java-based banking application migrated to **Maven** to demonstrate dependency management, automated testing, code coverage, and Continuous Integration.

## Completed Exercises

### 1. Maven Project Migration (Ex 6)
*   Converted the BankApplication into a standard Maven structure.
*   Configured `pom.xml` with:
    *   **GroupId**: `com.imt.mines`
    *   **ArtifactId**: `bank-application`
    *   **Version**: `1.0-SNAPSHOT`
*   Verified the build using `mvn compile`.

### 2. Lifecycle & Dependencies (Ex 7)
*   Added **JUnit 5** dependencies for unit testing.
*   Explored the Maven lifecycle:
    *   `mvn clean`: Removes the `target/` folder.
    *   `mvn test`: Runs unit tests.
    *   `mvn package`: Generates the JAR file.
    *   `mvn verify`: Runs integration tests and checks the validity of the package.

### 3. Unit Testing (Ex 8)
Implemented comprehensive tests for core logic (e.g., `BankAccount`, `Person`):
*   **Happy Paths**: Valid deposits, withdrawals, and initializations.
*   **Edge Cases**: Handling negative amounts, insufficient balance, and withdrawal limits.
*   Fixed source code bugs identified during testing to ensure robust error handling.

### 4. Code Coverage with JaCoCo (Ex 9)
*   Integrated the **JaCoCo** plugin to monitor test coverage.
*   Generated HTML reports via `mvn jacoco:report` (found in `target/site/jacoco/`).
*   Increased coverage by identifying untested methods (red branches) and adding corresponding tests.

### 5. Continuous Integration with GitHub Actions (Ex 10)
Implemented a CI workflow in `.github/workflows/maven.yml`:
*   Triggers on every **push to main**.
*   Automates `mvn clean test` and `mvn package`.
*   **Artifacts**: Configured the workflow to save the `target/` folder as a build artifact.

### 6. BDD with Cucumber (Ex 11)
*   Integrated **Cucumber** for Behavior-Driven Development.
*   Defined features in `src/test/resources/features/bank_account_basic.feature`.
*   Implemented step definitions in `BankAccountBasicSteps` to bridge Gherkin scenarios with Java code.

