# mircoservices

Mirco services 

Level 1 : Communication and Service Discovery

1. @Loaded
2. Eureka Server
3. Eureka Client
4. RestTemplate
5. WebClient

Level 2 : Fault Tolerance and Resilience 

6. Timeout patterns to handle faliure , Circuit Breaker Pattern
7. Hystrix @EnableCircuitBreaker @HystrixCommand
8. Hystrix Dashboard
9. Bulkhead pattern to handle fault tolerance and can be implement using hystrix threadpool property.

Level 3 : Connfiguration and management

10. Goals 

		Externalized. (property file)
		Environment Specific. (Spring profile)
		Consistent.  (Spring Cloud Config)
		Version history. (Spring Cloud Config)
		Real time management.

11. Placing an application.properties file in the same directory of the jar , Spring will pick up the external application.properties.

12. Geeting properties value from command line 
java -jar spring-boot-config-0.0.1-SNAPSHOT.jar    --my.greeting="Hello sir from command"

13. other way of overriding the application.properties 
https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-external-config


14. Three tricks with @Values --providing default values
                              --providing list 
                              --providing map
15. @ConfigurationProperties 

16. Spring boot Actuators 
in Application.properties use 
#Telling actuators to expose every thing 
management.endpoints.web.exposure.include=*
Call 	-- http://localhost:8080/actuator/configprops
		-- http://localhost:8080/actuator

17. Spring profile 

Create another application-test.yml 
and add 
spring:
  profiles:
    active: test 

Selecting beans by String profile

@Profile("test")
	@Bean
	public String getService() {
		return "test Service";
	}
	
	@Profile("dev")
	@Bean
	public String getService1() {
		return "dev Service";
	}

18. Environment Object  (Don't use in production code)

import org.springframework.core.env.Environment;

@Autowired
	private Environment env;

@RequestMapping("/getEnvDetails")
	public String getEnvDetails() {
		return env.toString();
	}		

19. Spring Cloud Config Server

Option 
========
Zookeeper
ETCD 
HashiCorp Consul
Spring Cloud Configuration Server

@EnableConfigServer
server.port=9090
spring.cloud.config.server.git.uri=C:\\Users\\avkumars\\mypersonalWorkSpace\\configrepo

