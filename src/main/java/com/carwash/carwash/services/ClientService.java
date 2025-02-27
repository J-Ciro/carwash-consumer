package com.carwash.carwash.services;


import com.carwash.carwash.dto.Client;
import com.carwash.carwash.repository.IClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

  private final IClientRepository clientRepository;

  public ClientService(IClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }


  @Transactional
  public void saveClient(Client client){
    if(client.getTreatments() != null){
      client.getTreatments().forEach(treatment -> {
        treatment.setClient(client);
        treatment.setId(null);
      });

    }

    System.out.println("[+] Guardando los servicios con treatments: " +client.getTreatments());
    clientRepository.save(client);
    System.out.println("[+] Se ha guardado el Cliente con Id: " + client.getId());

  }

}
