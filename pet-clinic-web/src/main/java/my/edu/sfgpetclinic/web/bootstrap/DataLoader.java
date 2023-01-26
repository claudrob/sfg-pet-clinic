package my.edu.sfgpetclinic.web.bootstrap;

import my.edu.sfgpetclinic.model.Owner;
import my.edu.sfgpetclinic.model.Pet;
import my.edu.sfgpetclinic.model.PetType;
import my.edu.sfgpetclinic.model.Vet;
import my.edu.sfgpetclinic.services.OwnerService;
import my.edu.sfgpetclinic.services.PetTypeService;
import my.edu.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@ComponentScan(basePackages = {"my.edu.sfgpetclinic.web", "my.edu.sfgpetclinic"})
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService){
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();

        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("12345678");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("12345678");

        Pet fionaCat = new Pet();
        fionaCat.setName("Just Cat");
        fionaCat.setOwner(owner2);
        fionaCat.setBirthDate(LocalDate.now());
        fionaCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionaCat);

        ownerService.save(owner2);

        System.out.println("Loading Owners ...");

        Vet vet1 = new Vet();

        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("Bob");
        vet2.setLastName("Bobber");
        vetService.save(vet2);

        System.out.println("Loading Vets ...");




    }
}
