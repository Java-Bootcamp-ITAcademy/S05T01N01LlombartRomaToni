package cat.itacademy.barcelonactiva.llombartroma.toni.s05.t01.n01.S05T01N01LlombartRomaToni.model.repository;

import cat.itacademy.barcelonactiva.llombartroma.toni.s05.t01.n01.S05T01N01LlombartRomaToni.model.domain.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {
    public Optional<List<Sucursal>> searchSucursalByName(String name);
}
