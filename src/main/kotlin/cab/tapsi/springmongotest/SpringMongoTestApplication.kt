package cab.tapsi.springmongotest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing

@SpringBootApplication
@EnableReactiveMongoAuditing
class SpringMongoTestApplication

fun main(args: Array<String>) {
  runApplication<SpringMongoTestApplication>(*args)
}
