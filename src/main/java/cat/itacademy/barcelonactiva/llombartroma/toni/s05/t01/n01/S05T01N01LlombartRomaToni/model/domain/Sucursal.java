package cat.itacademy.barcelonactiva.llombartroma.toni.s05.t01.n01.S05T01N01LlombartRomaToni.model.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode
@Entity
@Table(name="sucursals")
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;
    @Column
    @Getter
    @Setter
    private String name;
    @Column
    @Getter
    @Setter
    private String country;

    public Sucursal(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Sucursal() {
    }
}
