package api.vehicles.controllers.cargo;

import api.vehicles.models.Cargo;
import api.vehicles.services.interfaces.CargoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class CargoControllerTest {

    @Mock
    CargoService cargoService;

    @InjectMocks
    CargoController cargoController;
    List<Cargo> cargoList = new ArrayList<>();
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        cargoList.add(new Cargo());
//        given(cargoService.findAll()).willReturn(cargoList);
        mockMvc = MockMvcBuilders.standaloneSetup(cargoController).build();
    }

    @Test
    void testControllerShowCargoList() throws Exception {
        mockMvc.perform(get("/cargo"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void insert() throws Exception {
        mockMvc.perform(post("/cargo")
                    .param("anoModelo", "1990")
                    .param("anoFabricacao", "1991")
                    .param("valor", "15000")
                    .param("modelo", "Furgao")
                    .param("consumo", "5")
                    .param("motor", "3.4")
                    .param("cargaMax", "200")
                    .param("largura", "250")
                    .param("comprimento", "1200")
                    .param("altura", "210"))
                .andExpect(status().isOk());
    }

    @Test
    void insertWithErrors() throws Exception {
        mockMvc.perform(post("/cargo")
                        .param("anoModelo", "1989")
                        .param("anoFabricacao", "1991")
                        .param("valor", "15000")
                        .param("modelo", "Furgao")
                        .param("consumo", "5")
                        .param("motor", "3.4")
                        .param("cargaMax", "200")
                        .param("largura", "250")
                        .param("comprimento", "1200")
                        .param("altura", "210"))
                .andExpect(status().isOk());
    }

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/cargo"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(get("/cargo/12345"))
                .andExpect(status().isOk());
    }

    @Test
    void update() throws Exception {
        mockMvc.perform(post("/cargo/1")
                .param("anoModelo", "1989")
                .param("anoFabricacao", "1991")
                .param("valor", "15000")
                .param("modelo", "Furgao")
                .param("consumo", "5")
                .param("motor", "3.4")
                .param("cargaMax", "200")
                .param("largura", "250")
                .param("comprimento", "1200")
                .param("altura", "210"))
                .andExpect(status().isOk());
    }

    @Test
    void deleteById() {
    }
}