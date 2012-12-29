Cucumber-JVM-Example
====================

This is a simple example of how to use Cucumber-JVM in a real-world scenario. It tests one of <a href="http://www.itv.com">ITV's</a> live feeds.

## Running the example

Please ensure that you have <a href="http://maven.apache.org/">Maven</a> installed.

Do the following in the same directory as the pom.xml file:

	mvn install

The tests will then run.

## Notes ##
The Cucumber runtime parses command line options to know what features to run, where the glue code lives, what formatters to use etc. When you use the JUnit runner, these options are generated from the `@Cucumber.Options` annotation on your test.

For reference, the `@Cucumber.Options` annotation in this project lives in `src/test/java/com/bensnape/example/RunCukesTest.java`.
