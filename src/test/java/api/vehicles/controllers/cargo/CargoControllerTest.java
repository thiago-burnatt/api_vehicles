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
//    List<Cargo> cargoList = new ArrayList<>();
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
//        cargoList.add(new Cargo());
//        given(cargoService.findAll()).willReturn(cargoList);
        mockMvc = MockMvcBuilders.standaloneSetup(cargoController).build();
    }

    @Test
    void testControllerShowCargoList() throws Exception {
        mockMvc.perform(get("/cargo"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string("[]"));
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
                .andExpect(status().isOk())
                .andExpect(content().string(
                        "[{\"" +
                                "field\":\"Sucesso\",\"" +
                                "defaultMessage\":\"OperaÃ§ao realizada com sucesso!\"}]"));

    }

    @Test
    void insertWithAnoModeloError() throws Exception {
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
                .andExpect(status().isOk())
                .andExpect(content().string(
                        "[{\"" +
                                "field\":\"anoModelo\",\"" +
                                "defaultMessage\":\"O ano do modelo nao pode ser " + "inferior a 1990\"}]"));
    }

    @Test
    void insertWithEmptyModeloField() throws Exception {
        mockMvc.perform(post("/cargo")
                        .param("anoModelo", "2000")
                        .param("anoFabricacao", "1991")
                        .param("valor", "15000")
                        .param("modelo", "")
                        .param("consumo", "5")
                        .param("motor", "3.4")
                        .param("cargaMax", "200")
                        .param("largura", "250")
                        .param("comprimento", "1200")
                        .param("altura", "210"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        "[{\"" +
                                "field\":\"modelo\",\"" +
                                "defaultMessage\":\"O campo precisa ser preenchido\"}]"));
    }

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/cargo"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(get("/cargo/6"))
                .andExpect(status().isOk());
    }

    @Test
    void updateWithAnoModeloError() throws Exception {
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
                .andExpect(status().isOk())
                .andExpect(content().string(
                        "[{\"" +
                                "field\":\"anoModelo\",\"" +
                                "defaultMessage\":\"O ano do modelo nao pode ser " + "inferior a 1990\"}]"));
    }

    @Test
    void updateWithCorrectFields() throws Exception {
        mockMvc.perform(post("/cargo/1")
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
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"" +
                        "field\":\"Sucesso\",\"" +
                        "defaultMessage\":\"OperaÃ§ao realizada com sucesso!\"}]"));
    }

    @Test
    void updateWithEmptyField() throws Exception {
        mockMvc.perform(post("/cargo/1")
                        .param("anoModelo", "1990")
                        .param("anoFabricacao", "1991")
                        .param("valor", "15000")
                        .param("modelo", "Furgao")
                        .param("consumo", "5")
                        .param("motor", "")
                        .param("cargaMax", "200")
                        .param("largura", "250")
                        .param("comprimento", "1200")
                        .param("altura", "210"))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"" +
                        "field\":\"motor\",\"" +
                        "defaultMessage\":\"O campo precisa ser preenchido\"}]"));
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(get("/cargo/delete/1"))
                .andExpect(status().isOk());
    }
}