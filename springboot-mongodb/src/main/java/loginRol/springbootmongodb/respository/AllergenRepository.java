package loginRol.springbootmongodb.respository;

import loginRol.springbootmongodb.entity.AllergenUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface AllergenRepository extends MongoRepository<AllergenUser, Serializable> {

}
