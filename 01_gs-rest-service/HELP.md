[link](https://spring.io/guides/gs/rest-service)

build a service that will accept HTTP GET requests at http://localhost:8080/greeting.

It will respond with a JSON representation of a greeting, as the following listing shows:
```
{"id":1,"content":"Hello, World!"}
```
You can customize the greeting with an optional name parameter in the query string, as the following listing shows:

```http://localhost:8080/greeting?name=User```
The name parameter value overrides the default value of World and is reflected in the response, as the following listing shows:

```{"id":1,"content":"Hello, User!"}```

### test
http://localhost:8080/greeting

http://localhost:8080/greeting?name=User

---

@SpringBootApplication is a convenience annotation that adds all of the following:
 - @Configuration
   - Tags the class as a source of bean definitions for the application context.
 - @EnableAutoConfiguration
   - Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. For example, if spring-webmvc is on the classpath, this annotation flags the application as a web application and activates key behaviors, such as setting up a DispatcherServlet.
 - @ComponentScan 
   - Tells Spring to look for other components, configurations, and services in the com/example package, letting it find the controllers.

### build exec jar
build jar file
```shell
./mvnw clean package
```
run jar file
```shell
java -jar target/_01_gs-rest-service-0.0.1-SNAPSHOT.jar
```
