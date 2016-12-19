#!/bin/sh

export JAVA_HOME="C:\Program Files\Java\jre1.8.0_101\bin"

export PMS_DIR=C:\PMS\dist

export CLASSPATH=.;$PMS_DIR\conf\*;$PMS_DIR\lib\*;

$JAVA_HOME\bin\javac $PMS_DIR\com.infinira.pms.test.PMSTest.java

cd $PMS_DIR

$JAVA_HOME\bin\java com.infinira.pms.test.PMSTest