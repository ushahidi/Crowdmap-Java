# Crowdmap Java SDK #

A Java wrapper for the Crowdmap API. It wraps the raw HTTP calls to the Crowdmap APIs. 
The goal of this SDK is to ease Crowdmap API integration into your Java applications. 
For more information on the Crowdmap API, see;  http://api.crdmp3.com/developers/v1.type

## Building
The Crowdmap Java SDK is built using [Apache Ant](https://ant.apache.org/)

Run the following command to build a JAR file of the SDK with all the dependencies.
`ant dist` 

And to compile all the source codes, run
`ant compile`

## Javadoc 
You can find the Javadoc which contains all the relevant documentation on the classes 
and the packages in the doc directory found in the root folder of the project.

To generate recent version of the Javadoc, run 
`ant javadoc`

## Clean up
To clean up the generated distribution file and Javadoc in the root folder, run 
`ant clean`
