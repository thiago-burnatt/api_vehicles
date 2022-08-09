package api.vehicles.controllers.laisure;

import api.vehicles.repositories.LaisureRepository;
import api.vehicles.services.interfaces.LaisureService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class LaisureControllerTest {

    @Mock
    LaisureService Laisureservice;

    @InjectMocks
    LaisureController LaisureController;
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(LaisureController).build();
    }

    @Test
    void insertWithCorrectFields() throws Exception {
        mockMvc.perform(post("/laisure")
                        .param("anoModelo", "2000")
                        .param("anoFabricacao", "1991")
                        .param("valor", "15000")
                        .param("modelo", "Uno")
                        .param("consumo", "5")
                        .param("motor", "3.4")
                        .param("corInterna", "verde")
                        .param("corExterna", "azul")
                        .param("nrPortas", "4"))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"" +
                        "field\":\"Sucesso\",\"" +
                        "defaultMessage\":\"OperaÃ§ao realizada com sucesso!\"}]"));
    }

    @Test
    void insertWithInvalidAnoModeloField() throws Exception {
        mockMvc.perform(post("/laisure").param("anoModelo", "1950")
                        .param("anoFabricacao", "1991")
                        .param("valor", "15000")
                        .param("modelo", "Uno")
                        .param("consumo", "5")
                        .param("motor", "3.4")
                        .param("corInterna", "verde")
                        .param("corExterna", "azul")
                        .param("nrPortas", "4"))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"" +
                        "field\":\"anoModelo\",\"" +
                        "defaultMessage\":\"O ano do modelo nao pode ser inferior a 1990\"}]"));
    }

    @Test
    void insertWithInvalidNrPortasField() throws Exception {
        mockMvc.perform(post("/laisure").param("anoModelo", "2000")
                        .param("anoFabricacao", "1991")
                        .param("valor", "15000")
                        .param("modelo", "Uno")
                        .param("consumo", "5")
                        .param("motor", "3.4")
                        .param("corInterna", "verde")
                        .param("corExterna", "azul")
                        .param("nrPortas", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"" +
                        "field\":\"nrPortas\",\"" +
                        "defaultMessage\":\"O numero de portas nao pode ser inferior a 1\"}]"));
    }

    @Test
    void insertWithValorFieldEqualsZero() throws Exception {
        mockMvc.perform(post("/laisure").param("anoModelo", "2000")
                        .param("anoFabricacao", "1991")
                        .param("valor", "0")
                        .param("modelo", "Uno")
                        .param("consumo", "5")
                        .param("motor", "3.4")
                        .param("corInterna", "verde")
                        .param("corExterna", "azul")
                        .param("nrPortas", "1"))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"" +
                        "field\":\"valor\",\"" +
                        "defaultMessage\":\"Valor precisa ser superior a zero\"}]"));
    }

    @Test
    void insertWithEmptyField() throws Exception {
        mockMvc.perform(post("/laisure").param("anoModelo", "2000")
                        .param("anoFabricacao", "1991")
                        .param("valor", "1000")
                        .param("modelo", "Uno")
                        .param("consumo", "5")
                        .param("motor", "3.4")
                        .param("corInterna", "")
                        .param("corExterna", "azul")
                        .param("nrPortas", "1"))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"" +
                        "field\":\"corInterna\",\"" +
                        "defaultMessage\":\"O campo precisa ser preenchido\"}]"));
    }

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/laisure"))
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(get("/laisure/1"))
                .andExpect(status().isOk());
    }

    @Test
    void updateWithValidFields() throws Exception {
        mockMvc.perform(post("/laisure/1")
                        .param("anoModelo", "2000")
                        .param("anoFabricacao", "1991")
                        .param("valor", "15000")
                        .param("modelo", "Uno")
                        .param("consumo", "5")
                        .param("motor", "3.4")
                        .param("corInterna", "verde")
                        .param("corExterna", "azul")
                        .param("nrPortas", "4"))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"" +
                        "field\":\"Sucesso\",\"" +
                        "defaultMessage\":\"OperaÃ§ao realizada com sucesso!\"}]"));
    }

    @Test
    void updateWithInvalidAnoFabricacaoField() throws Exception {
        mockMvc.perform(post("/laisure/1")
                        .param("anoModelo", "1990")
                        .param("anoFabricacao", "1989")
                        .param("valor", "15000")
                        .param("modelo", "Uno")
                        .param("consumo", "5")
                        .param("motor", "3.4")
                        .param("corInterna", "verde")
                        .param("corExterna", "azul")
                        .param("nrPortas", "4"))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"" +
                        "field\":\"anoFabricacao\",\"" +
                        "defaultMessage\":\"O ano de fabricaÃ§ao nao pode ser inferior a 1990\"}]"));
    }

    @Test
    void updateWithEmptyField() throws Exception {
        mockMvc.perform(post("/laisure/1")
                        .param("anoModelo", "1990")
                        .param("anoFabricacao", "1990")
                        .param("valor", "15000")
                        .param("modelo", "Uno")
                        .param("consumo", "5")
                        .param("motor", "3.4")
                        .param("corInterna", "verde")
                        .param("corExterna", "azul")
                        .param("nrPortas", ""))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"" +
                        "field\":\"nrPortas\",\"" +
                        "defaultMessage\":\"O campo precisa ser preenchido\"}]"));
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(get("/laisure/delete/1"))
                .andExpect(status().isOk());
    }
}