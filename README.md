# DependaFix Test Repository

This repository is used for testing the DependaFix GitHub App functional requirements.

## Purpose

This is a test repository with multiple branches designed to validate different scenarios of the DependaFix system.

## Structure

- **Main Branch**: Clean, working Java Maven project with Spring Boot 2.7.0
- **Test Branches**: Each branch represents a specific test case

## Test Branches

| Branch | Purpose | Expected Outcome |
|--------|---------|------------------|
| `test/single-dependency-patch` | Single patch version update | ✅ Success |
| `test/multiple-dependencies` | Multiple dependency updates | ✅ Success |
| `test/breaking-change-major` | Major version breaking change | ⚠️ Compilation failure |
| `test/minor-version-update` | Minor version update | ✅ Success |
| `test/plugin-version` | Maven plugin version update | ✅ Success |
| `test/mixed-files-invalid` | pom.xml + Java file changes | ❌ Workflow skipped |
| `test/no-version-change-invalid` | No version changes | ❌ Workflow skipped |
| `test/multi-commit-invalid` | Multiple commits | ❌ Workflow skipped |

## Testing Workflow

1. Create PR from test branch → main
2. DependaFix analyzes the PR
3. Validate results
4. Close PR without merging (keeps main clean)

## Build Status

![Java CI with Maven](https://github.com/sanadlab/test-dependafix-java-maven/workflows/Java%20CI%20with%20Maven/badge.svg)

## Dependencies

- Spring Boot 2.7.0
- JUnit 5.8.2
- Mockito 4.3.1
- Maven Compiler Plugin 3.8.1

## Notes

- Never merge test branches into main
- Main branch should always remain clean
- All test branches are created from main
- PRs are closed without merging after testing

