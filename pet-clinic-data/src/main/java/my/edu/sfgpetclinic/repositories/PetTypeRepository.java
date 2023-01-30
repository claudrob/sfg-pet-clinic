package my.edu.sfgpetclinic.repositories;

import my.edu.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long>{
}
