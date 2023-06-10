package is.technologies.dto;

import is.technologies.Entities.HouseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class FlatCreationDto {
    private Long flatId;

    private int flatNumber;

    private int flatSquare;

    private int NumberOfRooms;

    private Long house;
}
