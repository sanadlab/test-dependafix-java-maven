# FOP Breaking Change Test Case

## Overview
This test branch demonstrates a breaking API change when upgrading Apache FOP from version 1.0 to 2.2.

## Branch Information
- **Branch**: `test/fop-breaking-change-1.0-to-2.2`
- **Dependency**: `org.apache.xmlgraphics:fop`
- **Version Change**: `1.0` → `2.2`

## Breaking Change Details

### API Change
The `FopFactory.newInstance()` method signature changed between versions:

**FOP 1.0 (Old API):**
```java
FopFactory fopFactory = FopFactory.newInstance();  // No parameters
```

**FOP 2.2 (New API):**
```java
FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());  // Requires URI parameter
```

### Available Methods in FOP 2.2
- `FopFactory.newInstance(FopFactoryConfig)`
- `FopFactory.newInstance(File)`
- `FopFactory.newInstance(URI)`
- `FopFactory.newInstance(URI, InputStream)`

## Test Files

### 1. `pom.xml`
- Baseline commit: Contains FOP 1.0 dependency
- Breaking change commit: Updated to FOP 2.2

### 2. `src/main/java/com/test/FopExample.java`
Contains code using the old FOP 1.0 API:
- `main()` method: Uses `FopFactory.newInstance()` (line 22)
- `createFopFactory()` method: Uses `FopFactory.newInstance()` (line 40)

## Compilation Errors

When compiling with FOP 2.2, you'll see:
```
[ERROR] no suitable method found for newInstance(no arguments)
    method org.apache.fop.apps.FopFactory.newInstance(org.apache.fop.apps.FopFactoryConfig) is not applicable
    method org.apache.fop.apps.FopFactory.newInstance(java.io.File) is not applicable
    method org.apache.fop.apps.FopFactory.newInstance(java.net.URI) is not applicable
    method org.apache.fop.apps.FopFactory.newInstance(java.net.URI,java.io.InputStream) is not applicable
```

## Expected Repair

The repair requires **Java code modification**, not just pom.xml changes:

```java
// Before (FOP 1.0)
FopFactory fopFactory = FopFactory.newInstance();

// After (FOP 2.2)
FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
```

## Testing the Breaking Change

1. **Checkout the baseline commit** (FOP 1.0):
   ```bash
   git checkout 1d102dd
   mvn clean compile  # Should succeed
   ```

2. **Checkout the breaking change commit** (FOP 2.2):
   ```bash
   git checkout c8bae56
   mvn clean compile  # Should fail with compilation errors
   ```

## Related Resources

- [Apache FOP Documentation](https://xmlgraphics.apache.org/fop/)
- [GitHub PR Example](https://github.com/premium-minds/billy/pull/300)

## Notes

- This is a **code-level breaking change** that requires Java source code modification
- The DependaFix system should detect this failure and attempt to repair it using Byam
- The repair should modify `FopExample.java` to use the new API, not just update pom.xml

