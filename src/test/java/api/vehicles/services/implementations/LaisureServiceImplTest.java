package api.vehicles.services.implementations;

import api.vehicles.dtos.LaisureDto;
import api.vehicles.models.Laisure;
import api.vehicles.repositories.LaisureRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.constraints.AssertFalse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LaisureServiceImplTest {

    final Laisure laisure = new Laisure();
    final LaisureDto laisureDto = new LaisureDto();

    @Mock
    LaisureRepository laisureRepository;

    @InjectMocks
    LaisureServiceImpl laisureService;

    @Test
    void deleteById() {
        laisureService.deleteById(anyString());
        verify(laisureRepository).deleteById(anyString());
    }

    @Test
    void findById() {
        when(laisureRepository.findById(anyString())).thenReturn(Optional.of(laisure));
        Laisure foundLaisure = laisureService.findById(anyString());
        assertThat(foundLaisure).isNotNull();
        verify(laisureRepository).findById(anyString());
    }

    @Test
    void findAll() {
        List<Laisure> foundLaisureList = laisureService.findAll();
        assertThat(foundLaisureList).isNotNull();
        verify(laisureRepository).findAll();
    }

    @Test
    void save() {
        when(laisureRepository.findById(anyString())).thenReturn(Optional.of(laisure));
        laisureService.update(anyString(), laisureDto);
        verify(laisureRepository).save(any(Laisure.class));
    }

    @Test
    void insert() {
        when(laisureRepository.save(any(Laisure.class))).thenReturn(laisure);
        laisureService.insert(new LaisureDto());
        verify(laisureRepository).save(any(Laisure.class));
    }
}