package cab.tapsi.springmongotest

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.sql.Timestamp
import java.time.DayOfWeek

@Document(collection = "stores")
data class Store(
  @Id val id: String? = null,
  @Indexed(unique = true) val slug: String,
  @Indexed(unique = true) val ownerId: String,
  val name: String,
  val preferences: StorePreferences,
  @CreatedDate val createdTimestamp: Timestamp? = null,
  @LastModifiedDate val updatedTimestamp: Timestamp? = null,
)


data class StorePreferences(
  val workingTimeslots: Map<DayOfWeek, HashSet<TimeslotOffset>> = emptyMap(),
  val processingDurationInSeconds: Long = 0,
)

data class TimeslotOffset(
  val startOffset: Long,
  val endOffset: Long,
)
