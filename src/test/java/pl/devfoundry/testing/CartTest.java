package pl.devfoundry.testing;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void simulateLargeOrder() {
        //given
        Cart cart = new Cart();

        //when
        //then
        assertTimeout(Duration.ofMillis(14), cart::simulateLargeOrder); //sprawdzamy czy metoda wykona sie w czasie mniejszym niz 14 milisekund
    }
}