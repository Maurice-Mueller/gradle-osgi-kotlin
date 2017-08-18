# OSGi, Gradle, Kotlin, Docker, Multi-Project

## install
* clone this repository
* install docker

## run
* start docker
* `./gradlew buildKaraf`
  * builds karaf container and installs needed features and bundles
* `./gradlew startKaraf`
* `./gradlew bundle`
  * creates both _service_ and _consumer_ bundle
* `./gradlew copyJarToDocker`
  * copies the bundles to `/opt/karaf/builds`
  * of course, the destination can be changed (adapt `build.gradle`)
    * e.g. change to `/opt/karaf/deploy` for automatic deployment
* log into the container
  * e.g. `docker exec -it karaf bash`
* `cd /opt/karaf`
* `./bin/client`
* install both _service_ and _consumer_ bundle
  * `bundle:install -s file:builds/service.jar`
  * `bundle:install -s file:builds/consumer.jar`

