package dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


//import lombok.Data;


//@Data
@Setter
@Getter
public class WinnerDetailDTO {
    private String name;
    private String competition;
    private List<ImageDTO> images;

    // Getters and setters
}
