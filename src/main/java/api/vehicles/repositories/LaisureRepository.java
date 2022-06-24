package api.vehicles.repositories;

import api.vehicles.models.Laisure;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LaisureRepository extends MongoRepository<Laisure, String> {
}
