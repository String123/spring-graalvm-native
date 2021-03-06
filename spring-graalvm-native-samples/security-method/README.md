Spring Boot project with Spring MVC, Tomcat and Jackson.

To build and run the native application packaged in a lightweight container:
```
mvn spring-boot:build-image
docker-compose up
```

And then request the "/hello" or "/admin/hello" endpoints.

```
curl user:password@localhost:8080/hello
```

As an alternative, you can use `build.sh` (with a local GraalVM installation or combined with
`run-dev-container.sh` at the root of `spring-graalvm-native` project). See also the related issue
[Take advantage of Paketo dev-oriented images](https://github.com/spring-projects-experimental/spring-graalvm-native/issues/227).