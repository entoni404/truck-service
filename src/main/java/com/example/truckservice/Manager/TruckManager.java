package com.example.truckservice.Manager;

import com.example.truckservice.Model.TruckEntity;
import com.example.truckservice.Repository.TruckRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TruckManager {

    private final TruckRepository truckRepository;

    public List<TruckEntity> getAllTrucks(){
        return truckRepository.findAll();
    }

    public TruckEntity getTruckByChasis(Long chasisNumber){
        return truckRepository.findById(chasisNumber).
                orElseThrow(()-> new NoSuchElementException("The truck does not exist"));
    }

    public void saveTruck(TruckEntity truckEntity){
        truckRepository.save(truckEntity);
    }

    public void removeTrucks(){
        truckRepository.deleteAll();
    }

    public void removeTruckByChasis(Long chasisNumber){
        truckRepository.deleteById(chasisNumber);
    }

    public void updateTruck(TruckEntity truckEntity, Long chasisNumber){
        TruckEntity currentTruck = new TruckEntity();
        currentTruck.setLicensePlate(truckEntity.getLicensePlate());
        currentTruck.setContainerVolume(truckEntity.getContainerVolume());
        truckRepository.save(currentTruck);
    }


}
