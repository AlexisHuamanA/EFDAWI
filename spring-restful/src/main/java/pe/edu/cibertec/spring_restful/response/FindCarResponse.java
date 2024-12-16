package pe.edu.cibertec.spring_restful.response;

import pe.edu.cibertec.spring_restful.dto.CarDetailDto;

public record FindCarResponse(String code,
                             String error,
                             CarDetailDto car ) {
}
