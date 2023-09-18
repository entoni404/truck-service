package com.example.truckservice.Controller;


import com.example.truckservice.Model.Truck;
import com.example.truckservice.Service.TruckService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/truck")
public class TruckController {

    private TruckService truckService;

    @GetMapping("/all")
    public List<Truck> getAllTrucks(){
        return truckService.getAllTrucks();
    }

    @GetMapping("/{chasisNumber}")
    public Truck getTruckByChasis(@PathVariable Long chasisNumber){
        return truckService.getTruckByChasis(chasisNumber);
    }

    @PostMapping("/create")
    public String saveTruck(@RequestBody Truck truck){
        truckService.saveTruck(truck);
        return "New truck joined the crew";
    }

    @DeleteMapping("deleteAll")
    public String deleteAllTrucks(){
        truckService.removeTrucks();
        return "All trucks removed";
    }

    @DeleteMapping("delete/{id}")
    public String deleteTruckByChasis(@PathVariable Long chasisNumber){
        truckService.removeTruckByChasis(chasisNumber);
        return "Truck removed";
    }

    @PutMapping("/update/{chasisNumber}")
    public String updateTruck(@RequestBody Truck truck, @PathVariable Long chasisNumber){
        truckService.updateTruck(truck,chasisNumber);
        return "Truck updated";
    }

}
