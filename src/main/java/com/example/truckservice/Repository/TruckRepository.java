package com.example.truckservice.Repository;

import com.example.truckservice.Model.TruckEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TruckRepository extends JpaRepository<TruckEntity,Long> {

}
