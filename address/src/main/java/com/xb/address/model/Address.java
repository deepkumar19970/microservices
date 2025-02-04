package com.xb.address.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@Table(name = "address_details")
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    Long id ;

    String name;
}
