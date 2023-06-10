package is.technologies.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class HouseCreationDto {

    private Long houseId;

    private String houseName;

    private Date dateOfConstruction;

    private int numberOfFloors;

    private String houseType;

    private Long street;
}
