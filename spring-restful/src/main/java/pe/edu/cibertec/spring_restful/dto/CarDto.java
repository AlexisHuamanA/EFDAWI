package pe.edu.cibertec.spring_restful.dto;

public record CarDto(Integer car_id,
                     String make,
                     String model,
                     Integer year
                        ) {
}
