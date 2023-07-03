package cat.itacademy.barcelonactiva.llombartroma.toni.s05.t01.n01.S05T01N01LlombartRomaToni.model.services;

import cat.itacademy.barcelonactiva.llombartroma.toni.s05.t01.n01.S05T01N01LlombartRomaToni.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.llombartroma.toni.s05.t01.n01.S05T01N01LlombartRomaToni.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.llombartroma.toni.s05.t01.n01.S05T01N01LlombartRomaToni.model.repository.SucursalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SucursalService {
    private final SucursalRepository sucursalRepository;
    public SucursalService(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }

    /* Implements how API add a new Fruit */
    public Optional<Sucursal> add(SucursalDTO sucursalDTO) {
        Sucursal sucursalToBeAdded = this.fromSucursalDTOToSucursal(sucursalDTO);
        return Optional.of(sucursalRepository.save(sucursalToBeAdded));
    }

    /* Implements how API removes a Sucursal */
    public Optional<Sucursal> delete(int id) {
        Optional<Sucursal> optionalSucursal = sucursalRepository.findById(id);
        sucursalRepository.deleteById(id);
        return optionalSucursal;
    }
    /* Implements how API retrieves a single Fruit */
    public Optional<SucursalDTO> getOne(int id) {
        Sucursal foundSucursal = sucursalRepository.findById(id).get();
        SucursalDTO sucursalDTO = this.fromSucursalToSucursalDTO(foundSucursal);
        sucursalDTO.setSucursalType();
        return Optional.of(sucursalDTO);
    }
    /* Implements how API retrieves all Sucursals */
    public Optional<List<SucursalDTO>> getAll() {
        List<Sucursal> sucursalsFound = Optional.of(sucursalRepository.findAll()).get();
        List<SucursalDTO> sucursals = new ArrayList<>();
        for(Sucursal sucursal:sucursalsFound) {
            SucursalDTO sucursalDTO = this.fromSucursalToSucursalDTO(sucursal);
            sucursalDTO.setSucursalType();
            sucursals.add(sucursalDTO);
        }
        return Optional.of(sucursals);
    }
    /* Implements how API retrieves a Sucursal by name */
    public Optional<List<SucursalDTO>> searchSucursalByName(String name) {
        List<Sucursal> sucursals = sucursalRepository.searchSucursalByName(name).get();
        List<SucursalDTO> sucursalsDTO = sucursals.stream().map(this::fromSucursalToSucursalDTO).collect(Collectors.toList());
        return Optional.of(sucursalsDTO);
    }
    /* Transforms from Sucursal to SucursalDTO */
    private SucursalDTO fromSucursalToSucursalDTO(Sucursal sucursal) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(sucursal, SucursalDTO.class);
    }
    /* Transforms from SucursalDTO to Sucursal */
    private Sucursal fromSucursalDTOToSucursal(SucursalDTO sucursalDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(sucursalDTO, Sucursal.class);
    }


}
