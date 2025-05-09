package net.training.Springboot.training.project.repository;

import net.training.Springboot.training.project.model.CarModal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarModal , Long> {
}
