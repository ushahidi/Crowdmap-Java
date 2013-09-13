### Introduction.
A Java wrapper for the Crowdmap API. It wraps the raw HTTP calls to the Crowdmap APIs. The goal of
this SDK is to ease Crowdmap API integration into your Java applications. For more information on the
Crowdmap API, Go to https://api.crowdmap.com/developers/v1/

### Usage

Create a Crowdmap instance. You will use this to access the various services.

```java
// Instantiate the Crowdmap API.
Crowdmap crowdmap = new Crowdmap("publicKey", "privateKey");

// Call the Utitlity Service and retrieve Crowdmap API's about information.
final String about = crowdmap.utilityService().about().toString();

// Print the about information to the console.
System.out.println(about);
```

### Demo Android apps
#### Media Gallery
A gallery app that download images submitted to Crowdmap.

#### Profile
An app that allows you to login to Crowdmap then displays the profile of the logged in user.

You can get the demo apps from

``


### Building
The project is built with Gradle

```
$ git clone git://github.com/ushahidi/Crowdmap-Java.git
$ cd Crowdmap-Java
$ ./gradlew jar  # Build jar file (build/libs/Crowdmap-Java-1.x.x.jar)
$ ./gradlew test # Run tests
$ ./gradlew postServiceExample # Build and run PostServiceExample
```
### Documentation
Javadocs available at http://ushahidi.github.io/Crowdmap-Java/javadoc/1.0.0-SNAPSHOT/


### Download
All of the dominantColor code for the project resides at [github.com][1]

For Daily SNAPSHOTS, Add the repository

`https://oss.sonatype.org/content/repositories/snapshots`

#### Gradle
```
'com.crowdmap:java-sdk:1.0.0-SNAPSHOT'
```

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

[1]: https://github.com/ushahidi/Crowdmap-Java/
[2]: https://github.com/ushahidi/Crowdmap-Java/blob/master/LICENSE
