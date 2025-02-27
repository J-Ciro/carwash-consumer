package com.carwash.carwash.dto;
import jakarta.persistence.*;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "client")
@Table(name = "treatment")

public class Treatment {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String type;
  private Double price;
  private Integer duration;
  @ManyToOne
  @JoinColumn(name = "client_id", nullable = false)
  private Client client;


}
