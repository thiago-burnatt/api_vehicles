package api.vehicles.services.implementations;

import api.vehicles.dtos.LaisureDto;
import api.vehicles.models.Laisure;
import api.vehicles.repositories.LaisureRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LaisureServiceImplTest {

    final Laisure laisure = new Laisure();
    final LaisureDto laisureDto = new LaisureDto();

    @Mock
    LaisureRepository laisureRepository;

    @InjectMocks
    LaisureServiceImpl laisureservice;

    @Test
    void deleteById() {
        laisureservice.deleteById(anyString());
        verify(laisureRepository).deleteById(anyString());
    }

    @Test
    void findById() {
        when(laisureRepository.findById(anyString())).thenReturn(Optional.of(laisure));
        Laisure foundLaisure = laisureservice.findById(anyString());
        assertThat(foundLaisure).isNotNull();
        verify(laisureRepository).findById(anyString());
    }

    @Test
    void findAll() {
        List<Laisure> laisureList = new ArrayList<>();
        laisureList.add(laisure);
        List<Laisure> foundLaisureList = laisureservice.findAll();
        verify(laisureRepository).findAll();
    }

    @Test
    void save() {
        when(laisureRepository.findById(anyString())).thenReturn(Optional.of(laisure));
        laisureservice.update(anyString(), laisureDto);
        verify(laisureRepository).save(any(Laisure.class));
    }

    @Test
    void insert() {
        when(laisureRepository.save(any(Laisure.class))).thenReturn(laisure);
        laisureservice.insert(new LaisureDto());
        verify(laisureRepository).save(any(Laisure.class));
    }
}