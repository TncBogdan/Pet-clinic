package com.tnc.bootstrap;

import com.tnc.model.*;
import com.tnc.services.OwnerService;
import com.tnc.services.PetTypeService;
import com.tnc.services.SpecialityService;
import com.tnc.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality saveRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality saveSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality saveDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michelle");
        owner1.setLastName("Waston");
        owner1.setAddress("123 Brikerel");
        owner1.setCity("Miami");
        owner1.setTelephone("4243643563");

        Pet michellePet = new Pet();
        michellePet.setPetType(saveDogPetType);
        michellePet.setOwner(owner1);
        michellePet.setBirthDate(LocalDate.now());
        michellePet.setName("Rosco");
        owner1.getPets().add(michellePet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Marry");
        owner2.setLastName("Losley");
        owner2.setAddress("5346 Brikerel");
        owner2.setCity("Miami");
        owner2.setTelephone("86544754684");

        Pet marryPet = new Pet();
        marryPet.setPetType(saveDogPetType);
        marryPet.setOwner(owner2);
        marryPet.setBirthDate(LocalDate.now());
        marryPet.setName("Marco");
        owner2.getPets().add(marryPet);

        System.out.println("Loading owners...");

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Rian");
        vet1.setLastName("Corso");
        vet1.getSpecialities().add(saveRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jassie");
        vet2.setLastName("Floyd");
        vet2.getSpecialities().add(saveSurgery);

        vetService.save(vet2);

        System.out.println("Loading vets...");
    }
}
