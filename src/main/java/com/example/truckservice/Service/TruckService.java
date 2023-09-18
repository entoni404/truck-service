package com.example.truckservice.Service;

import com.example.truckservice.Manager.TruckManager;
import com.example.truckservice.Model.Truck;
import com.example.truckservice.Model.TruckEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TruckService {


    private final TruckManager truckManager;

    public List<Truck> getAllTrucks(){
        return truckManager.getAllTrucks().stream().map(this::mapToTruck).collect(Collectors.toList());
    }

    public Truck getTruckByChasis(Long chasisNumber){
        return mapToTruck(truckManager.getTruckByChasis(chasisNumber));
    }

    public void saveTruck(Truck truck){
       truckManager.saveTruck(mapToTruckEntity(truck));
    }

    public void removeTrucks(){
       truckManager.removeTrucks();
    }

    public void removeTruckByChasis(Long chasisNumber){
       truckManager.removeTruckByChasis(chasisNumber);
    }

    public void updateTruck(Truck truck, Long chasisNumber){
        truckManager.updateTruck(mapToTruckEntity(truck), chasisNumber);
    }

    public Truck mapToTruck(TruckEntity source){
        Truck truck = new Truck();
        truck.setChasisNumber(source.getChasisNumber());
        truck.setLicensePlate(source.getLicensePlate());
        truck.setContainerVolume(source.getContainerVolume());
        return truck;
    }

    public TruckEntity mapToTruckEntity(Truck source){
        TruckEntity truckEntity = new TruckEntity();
        truckEntity.setChasisNumber(source.getChasisNumber());
        truckEntity.setLicensePlate(source.getLicensePlate());
        truckEntity.setContainerVolume(source.getContainerVolume());
        return truckEntity;
    }

}
