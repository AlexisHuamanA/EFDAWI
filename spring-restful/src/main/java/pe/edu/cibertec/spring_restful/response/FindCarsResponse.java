package pe.edu.cibertec.spring_restful.response;

import pe.edu.cibertec.spring_restful.dto.CarDto;

public record FindCarsResponse (String code,
                              String error,
                           Iterable<CarDto>cars){
}
