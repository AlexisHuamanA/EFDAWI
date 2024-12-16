package pe.edu.cibertec.spring_restful.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.spring_restful.entity.Car;

public interface CarRepository extends CrudRepository<Car, Integer> {
}
