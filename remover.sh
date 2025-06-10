#!/bin/bash

JAR_PATH="build/libs/kotlinProject-1.0-SNAPSHOT.jar"
TMP_DIR="./tmp_jar_edit"
MODIFIED_MANIFEST="$TMP_DIR/META-INF/MANIFEST.MF"

# 1. Create temp dir and extract contents
rm -rf "$TMP_DIR"
mkdir -p "$TMP_DIR"
cd "$TMP_DIR" || exit
jar xf "../$JAR_PATH"

# 2. Modify the MANIFEST.MF to remove the 1.3.0 extender capability
sed -i.bak '/osgi.extender=osgi.component)(version>=1.3.0)(!(version>=2.0.0))/d' META-INF/MANIFEST.MF

# 3. Rebuild the jar
cd ..
NEW_JAR="kotlinProject-1.0-SNAPSHOT.jar"
jar cf "$NEW_JAR" -C "$TMP_DIR" .

