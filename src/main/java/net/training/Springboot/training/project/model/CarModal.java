package net.training.Springboot.training.project.model;


import jakarta.persistence.*;

@Entity
@Table(name="Car_Details")
public class CarModal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long car_id;

    @Column(name="Car_Name")
    String carName;

    @Column(name="Car_year")
    int carYear;

    public CarModal() {
    }

    public CarModal(Long car_id, String carName, int carYear) {
        this.car_id = car_id;
        this.carName = carName;
        this.carYear = carYear;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getCarYear() {
        return carYear;
    }

    public void setCarYear(int carYear) {
        this.carYear = carYear;
    }

    public Long getCar_id() {
        return car_id;
    }

    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }




}
