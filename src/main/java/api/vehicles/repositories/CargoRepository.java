package api.vehicles.repositories;

import api.vehicles.models.Cargo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CargoRepository extends MongoRepository<Cargo, String> {
}
