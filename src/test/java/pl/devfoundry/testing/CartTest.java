package pl.devfoundry.testing;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@Disabled //wszystkie testy beda ignorowane
@DisplayName("Test cases for Cart")
class CartTest {

    @Disabled //tylko ten test bedzie ignorowany
    @DisplayName("Cart is able process 1000 orders in 14 miliseconds")
    @Test
    void simulateLargeOrder() {
        //given
        Cart cart = new Cart();

        //when
        //then
        assertTimeout(Duration.ofMillis(14), cart::simulateLargeOrder); //sprawdzamy czy metoda wykona sie w czasie mniejszym niz 14 milisekund
    }
}