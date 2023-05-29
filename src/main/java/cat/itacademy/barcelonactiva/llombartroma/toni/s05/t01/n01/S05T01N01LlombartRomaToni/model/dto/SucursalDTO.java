package cat.itacademy.barcelonactiva.llombartroma.toni.s05.t01.n01.S05T01N01LlombartRomaToni.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Data
public class SucursalDTO {
    /* UE Countries list */
    private static final List<String> euCountries = Arrays.asList(
            "Austria",
            "Belgium",
            "Bulgaria",
            "Croatia",
            "Republic of Cyprus",
            "Czech Republic",
            "Denmark",
            "Estonia",
            "Finland",
            "France",
            "Germany",
            "Greece",
            "Hungary",
            "Ireland",
            "Italy",
            "Latvia",
            "Lithuania",
            "Luxembourg",
            "Malta",
            "Netherlands",
            "Poland",
            "Portugal",
            "Romania",
            "Slovakia",
            "Slovenia",
            "Spain",
            "Sweden"
    );
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String country;
    @Getter
    @Setter
    private SucursalType sucursalType;

    public void setSucursalType() {
        if(euCountries.contains(this.country)) {
            this.sucursalType = SucursalType.UE;
        }
        else {
            this.sucursalType = SucursalType.NON_UE;
        }
    }
}
