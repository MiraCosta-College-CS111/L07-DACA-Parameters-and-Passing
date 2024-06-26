#! /bin/bash

# Compile the Java code
javac -classpath .:junit-platform-console-standalone-1.11.0-M2.jar TestMain.java Main.java
# Check if compilation was successful
if [ $? -ne 0 ]; then
    exit 1
fi

# Run unit tests
java -jar junit-platform-console-standalone-1.11.0-M2.jar execute --class-path . --scan-class-path
# Check if unit tests were successful
if [ $? -ne 0 ]; then
    exit 2
fi

# Perform style checks
java -jar checkstyle-10.17.0-all.jar -c cs111_l01_style.xml Main.java
# Check if style checks were successful
if [ $? -ne 0 ]; then
    exit 3
fi

# If all checks passed, exit with code 0
exit 0