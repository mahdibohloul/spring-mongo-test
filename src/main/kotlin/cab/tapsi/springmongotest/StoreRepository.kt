package cab.tapsi.springmongotest

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface StoreRepository : ReactiveMongoRepository<Store, String>