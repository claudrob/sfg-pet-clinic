package my.edu.sfgpetclinic.services.map;

import my.edu.sfgpetclinic.model.Speciality;
import my.edu.sfgpetclinic.model.Vet;
import my.edu.sfgpetclinic.services.SpecialtyService;
import my.edu.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public Vet save(Vet vet) {

        if(vet.getSpecialties().size() > 0){
            vet.getSpecialties().forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpeciality = specialtyService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save( vet);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
