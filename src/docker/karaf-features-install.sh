#!/usr/bin/env bash
cd /opt/karaf/bin

CXF_VERSION="3.1.10"
JACKSON_VERSION="2.9.0"

./client feature:install webconsole
./client feature:repo-add cxf $CXF_VERSION
./client feature:install http cxf-jaxrs cxf
./client feature:install jetty
./client "bundle:install -s mvn:javax.ws.rs/javax.ws.rs-api/2.1/"
./client "bundle:install -s mvn:com.fasterxml.jackson.core/jackson-core/"$JACKSON_VERSION
./client "bundle:install -s mvn:com.fasterxml.jackson.core/jackson-annotations/"$JACKSON_VERSION
./client "bundle:install -s mvn:com.fasterxml.jackson.core/jackson-databind/"$JACKSON_VERSION
./client "bundle:install -s mvn:com.fasterxml.jackson.jaxrs/jackson-jaxrs-base/"$JACKSON_VERSION
./client "bundle:install -s mvn:com.fasterxml.jackson.jaxrs/jackson-jaxrs-json-provider/"$JACKSON_VERSION
#./client bundle:install -s wrap:mvn:org.jetbrains.kotlin/kotlin-osgi-bundle/1.1.4
./client "bundle:install -s mvn:org.jetbrains.kotlin/kotlin-osgi-bundle/1.1.4"
./client "bundle:install -s mvn:com.fasterxml.jackson.module/jackson-module-kotlin/"$JACKSON_VERSION
