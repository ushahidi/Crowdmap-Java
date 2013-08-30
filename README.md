### Introduction.
A Java wrapper for the Crowdmap API. It wraps the raw HTTP calls to the Crowdmap APIs. The goal of
this SDK is to ease Crowdmap API integration into your Java applications. For more information on the
Crowdmap API, Go to https://api.crowdmap.com/developers/v1/

### Usage

Create a Crowdmap instance. You will use this to access the various services.

```java
Crowdmap crowdmap = new Crowdmap("publicKey", "privateKey");
```

### Building
The project is built with gradle

```
$ git clone git://github.com/soundcloud/java-api-wrapper.git
$ cd Crowdmap-Java
$ ./gradlew jar  # build jar file (build/libs/Crowdmap-Java-1.x.x.jar)
$ ./gradlew test # run tests
$ ./gradlew allJar

```
### Documentation
Javadocs available at http://ushahidi.github.io/Crowdmap-Java/javadoc/1.0.0-SNAPSHOT/


### Download
All of the source code for the project resides at [github.com][1]

#### Maven
```
<dependency>
  <groupId>com.crowdmap</groupId>
  <artifactId>java-sdk</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>

```

### License
This project is released under the `GNU AFFERO GENERAL PUBLIC LICENSE Version 3`
See the [license][2] file for more details.

[1]: https://github.com/ushahidi/Crowdmap-Java/blob/master/LICENSE
[2]: https://github.com/ushahidi/Crowdmap-Java/