package api.vehicles.services.implementations;

import api.vehicles.dtos.CargoDto;
import api.vehicles.models.Cargo;
import api.vehicles.repositories.CargoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CargoServiceImplTest {

    final Cargo cargo = new Cargo();
    final CargoDto cargoDto = new CargoDto();

    @Mock
    CargoRepository cargoRepository;

    @InjectMocks
    CargoServiceImpl cargoService;

    //TDD Tests

    @Test
    void insert() {
        when(cargoRepository.save(any(Cargo.class))).thenReturn(cargo);
        cargoService.insert(new CargoDto());
        verify(cargoRepository).save(any(Cargo.class));
    }

    @Test
    void findAll() {
        List<Cargo> cargoList = new ArrayList<>();

        cargoList.add(cargo);
        List<Cargo> foundCargoList = cargoService.findAll();
        assertThat(foundCargoList).isNotNull();
        verify(cargoRepository).findAll();
    }

    @Test
    void findById() {
        when(cargoRepository.findById(anyString())).thenReturn(Optional.of(cargo));
        Cargo foundCargo = cargoService.findById(anyString());
        assertThat(foundCargo).isNotNull();
        verify(cargoRepository).findById(anyString());
    }

    @Test
    void save() {
        when(cargoRepository.findById(anyString())).thenReturn(Optional.of(cargo));
        cargoService.update(anyString(), cargoDto);
        verify(cargoRepository).save(any(Cargo.class));
    }

    @Test
    void deleteById() {
        cargoService.deleteById(anyString());
        verify(cargoRepository).deleteById(anyString());
    }

    //************************************************************//

    // BDD Tests

    @Test
    void findByIdBddTest() {
        given(cargoRepository.findById(anyString())).willReturn(Optional.of(cargo));
        Cargo foundCargo = cargoService.findById(anyString());

        assertThat(foundCargo).isNotNull();
        then(cargoRepository).should(times(1)).findById(anyString());
    }

    @Test
    void deleteByIdBddTest() {
        cargoService.deleteById(anyString());
        cargoService.deleteById(anyString());

        then(cargoRepository).should(times(2)).deleteById(anyString());
    }

    @Test
    void findAllBddTest() {
        List<Cargo> cargoList = new ArrayList<>();
        cargoList.add(cargo);
        given(cargoRepository.findAll()).willReturn(cargoList);
        List<Cargo> foundCargoList = cargoService.findAll();
        then(cargoRepository).should().findAll();
        assertThat(foundCargoList).isNotNull();
    }

    @Test
    void saveBddTest() {
        given(cargoRepository.findById(anyString())).willReturn(Optional.of(cargo));
        cargoService.update(anyString(), cargoDto);
        then(cargoRepository).should().save(any(Cargo.class));
    }
}