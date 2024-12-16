package pe.edu.cibertec.spring_restful.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.spring_restful.dto.CarDto;
import pe.edu.cibertec.spring_restful.response.FindCarsResponse;
import pe.edu.cibertec.spring_restful.service.ManageService;

import java.util.List;

@RestController
@RequestMapping("manage-car")
public class ManageCarApi {

    @Autowired
    ManageService manageService;

    @GetMapping("/all")
    public FindCarsResponse findUsers() {

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

}
