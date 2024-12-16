package pe.edu.cibertec.spring_restful.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.spring_restful.dto.CarDetailDto;
import pe.edu.cibertec.spring_restful.dto.CarDto;
import pe.edu.cibertec.spring_restful.response.*;
import pe.edu.cibertec.spring_restful.service.ManageService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("manage-car")
public class ManageCarApi {



    @Autowired
    ManageService manageService;

    @GetMapping("/all")
    public FindCarsResponse findCars() {

        try {
            List<CarDto> cars = manageService.getAllCars();
            if (!cars.isEmpty())
                return new FindCarsResponse("01", null, cars);
            else
                return new FindCarsResponse("02", "Users not found", null);

        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarsResponse("99", "An error ocurred, please try again", null);

        }
    }

    @GetMapping("/detail")
    public FindCarResponse findCar(@RequestParam(value = "id", defaultValue = "0") String id) {

        try {
            Optional<CarDetailDto> optional = manageService.getCarById(Integer.parseInt(id));
            return optional.map(user ->
                    new FindCarResponse("01", null, user)
            ).orElse(
                    new FindCarResponse("02", "User not found", null)
            );

        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarResponse("99", "An error ocurred, please try again", null);

        }

    }

    @PutMapping("/update")
    public UpdateCarResponse updateCar(@RequestBody CarDto carDto) {

        try {
            if (manageService.updateCar(carDto))
                return new UpdateCarResponse("01", null);
            else
                return new UpdateCarResponse("02", "User not found");

        } catch (Exception e) {
            e.printStackTrace();
            return new UpdateCarResponse("99", "An error ocurred, please try again");

        }

    }

    @DeleteMapping("/delete/{id}")
    public DeleteCarResponse deleteCar(@PathVariable String id) {

        try {
            if (manageService.deleteCarById(Integer.parseInt(id)))
                return new DeleteCarResponse("01", null);
            else
                return new DeleteCarResponse("02", "User not found");

        } catch (Exception e) {
            e.printStackTrace();
            return new DeleteCarResponse("99", "An error ocurred, please try again");

        }

    }

    @PostMapping("/create")
    public CreateCarResponse createCar(@RequestBody CarDetailDto carDetailDto) {

        try {
            if (manageService.addCar(carDetailDto))
                return new CreateCarResponse("01", null);
            else
                return new CreateCarResponse("02", "User already exists");

        } catch (Exception e) {
            e.printStackTrace();
            return new CreateCarResponse("99", "An error ocurred, please try again");

        }

    }

}
