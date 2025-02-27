package com.carwash.carwash.consumer;


import com.carwash.carwash.dto.Client;
import com.carwash.carwash.services.ClientService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class CarWashConsumer {

  private final ClientService ClientService;

  public CarWashConsumer(ClientService ClientService) {
    this.ClientService = ClientService;
  }


  @RabbitListener(queues = "carwash_queue")
  public void receivedMessage(Client client){
    System.out.println("[+] Mensaje recibido " + client);
    ClientService.saveClient(client);
  }

}
