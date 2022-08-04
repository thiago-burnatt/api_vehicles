package api.vehicles.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CargoTest {

    Cargo cargo = new Cargo("12", 2000, 2001, 15000, "Palio",
            "12", "1.0", 2000, 180, 200, 150);


    @Test
    void getCargaMax() {
        assertEquals(2000, cargo.getCargaMax());
    }

    @Test
    void setCargaMax() {
        cargo.setCargaMax(2500);
        assertEquals(2500, cargo.getCargaMax());
    }

    @Test
    void getLargura() {
    }

    @Test
    void setLargura() {
    }

    @Test
    void getComprimento() {
    }

    @Test
    void setComprimento() {
    }

    @Test
    void getAltura() {
    }

    @Test
    void setAltura() {
    }
}