package com.example.truckservice.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "truck")

public class TruckEntity{

    @Id
    private Long chasisNumber;

    @Column
    private String licensePlate;

    @Column
    private int containerVolume;
}
