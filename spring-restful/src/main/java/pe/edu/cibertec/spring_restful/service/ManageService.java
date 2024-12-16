package pe.edu.cibertec.spring_restful.service;

import pe.edu.cibertec.spring_restful.dto.CarDetailDto;
import pe.edu.cibertec.spring_restful.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {

    List<CarDto> getAllCars() throws Exception;

    Optional<CarDetailDto> getCarById(int id) throws Exception;

    boolean updateCar(CarDto carDto) throws Exception;

    boolean deleteCarById(int id) throws Exception;

    boolean addCar(CarDetailDto carDetailDto) throws Exception;

}
