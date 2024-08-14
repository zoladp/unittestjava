package zadaniesekcja03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CargoTest {

    @Test
    void testIfAllArgumentsAreNull() {
        assertNotNull(new Cargo(null,0));
    }
}