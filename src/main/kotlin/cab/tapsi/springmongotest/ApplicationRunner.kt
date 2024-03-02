package cab.tapsi.springmongotest

import java.time.DayOfWeek
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class ApplicationRunner(
  private val repository: StoreRepository
) : CommandLineRunner {
  private val logger = LoggerFactory.getLogger(this::class.java)

  override fun run(vararg args: String?) {
    logger.info("Hello, Spring Boot!")
    val store = Store(
      id = null,
      slug = "store-slug",
      ownerId = "owner-id",
      name = "store-name",
      preferences = StorePreferences(
        workingTimeslots =
        mapOf(
          (DayOfWeek.FRIDAY to hashSetOf(
            TimeslotOffset(0, 1),
            TimeslotOffset(2, 3)
          )),
          (DayOfWeek.SATURDAY to hashSetOf(
            TimeslotOffset(4, 5),
            TimeslotOffset(6, 7)
          )),
          (DayOfWeek.SUNDAY to hashSetOf(
            TimeslotOffset(8, 9),
            TimeslotOffset(10, 11)
          ))
        )
      )
    )
    repository.save(store)
      .doOnNext {
        logger.info("Saved store: ${it.id}")
      }.doOnError {
        logger.error("Error while saving store", it)
      }.block()
  }
}