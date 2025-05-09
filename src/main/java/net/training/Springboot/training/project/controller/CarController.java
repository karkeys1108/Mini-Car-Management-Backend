package net.training.Springboot.training.project.controller;

import net.training.Springboot.training.project.model.CarModal;
import net.training.Springboot.training.project.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @PostMapping("/savedata")
    public CarModal addCar(@RequestBody CarModal car) {
        return carRepository.save(car);
    }

    @GetMapping("/getdata")
    public List<CarModal> getAllCars() {
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public CarModal getCarById(@PathVariable Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with this ID: " + id));
    }

    @PutMapping("/{id}")
    public CarModal updateCar(@PathVariable Long id, @RequestBody CarModal Car) {
        CarModal existingCar = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car is not Found with this ID: " + id));

        String OldCar = Car.getCarName();
        int  OldYear = Car.getCarYear();
        existingCar.setCarName(OldCar);
        existingCar.setCarYear(OldYear);

        System.out.println(OldCar +" is updated to " + existingCar.getCarName());
        return carRepository.save(existingCar);
    }

    @DeleteMapping("/{id}")
    public String deleteCar(@PathVariable Long id) {
        carRepository.deleteById(id);
        return "Car with ID " + id + " has been deleted successfully from the DB.";
    }
}
