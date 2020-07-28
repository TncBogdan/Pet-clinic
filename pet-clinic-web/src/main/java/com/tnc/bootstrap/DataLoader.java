package com.tnc.bootstrap;

import com.tnc.model.Owner;
import com.tnc.model.Vet;
import com.tnc.services.OwnerService;
import com.tnc.services.VetService;
import com.tnc.services.map.OwnerServiceMap;
import com.tnc.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michele");
        owner1.setLastName("Waston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Mary");
        owner1.setLastName("Losley");

        System.out.println("Loading owners...");

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        owner1.setId(1L);
        owner1.setFirstName("Michel");
        owner1.setLastName("Corso");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        owner1.setId(2L);
        owner1.setFirstName("Jassie");
        owner1.setLastName("Floyd");

        vetService.save(vet2);

        System.out.println("Loading vets...");
    }
}
