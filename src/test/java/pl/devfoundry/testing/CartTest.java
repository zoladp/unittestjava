package pl.devfoundry.testing;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@Disabled //wszystkie testy beda ignorowane
@DisplayName("Test cases for Cart")
class CartTest {

    @Test
    @Disabled //tylko ten test bedzie ignorowany
    @DisplayName("Cart is able process 1000 orders in 14 miliseconds")
    void simulateLargeOrder() {
        //given
        Cart cart = new Cart();

        //when
        //then
        assertTimeout(Duration.ofMillis(14), cart::simulateLargeOrder);
        //sprawdzamy czy metoda wykona sie w czasie mniejszym niz 14 milisekund
    }

    @Test
    @DisplayName("Test z alternatywą i test z koniunkcja")
    void cartShouldNotBeEmptyAfterAddingOrderToCart() {

        //given
        Order order = new Order();
        Cart cart = new Cart();

        //when
        cart.addOrderToCart(order);

        //then
        //ta asercja zostanie spelniona jezeli dowolny z tych warunkow zostanie spelniony
        assertThat(cart.getOrders(), anyOf(
                notNullValue(),
                hasSize(1),
                is(not(empty())),
                is(not(emptyCollectionOf(Order.class)))
        ));

        //ta asercja zostanie spelniona jezeli kazdy z tych warunkow zostanie spelniony, i zwraca blad dla pierwszej od gory failujacej asercji
        assertThat(cart.getOrders(), allOf(
                notNullValue(),
                hasSize(1),
                is(not(empty())),
                is(not(emptyCollectionOf(Order.class)))
        ));

        //ta asercja w odroznieniu od innych zwraca blad dla kazdej osobno assercji ktora nie przechodzi
        assertAll("This is a group of assertions for cart",
                () -> assertThat(cart.getOrders(), notNullValue()),
                () -> assertThat(cart.getOrders(), hasSize(1)),
                () -> assertThat(cart.getOrders(), is(not(empty()))),
                () -> assertThat(cart.getOrders(), is(not(emptyCollectionOf(Order.class)))),
                () -> assertThat(cart.getOrders().get(0).getMeals(), empty()),
                () -> {
                    List<Meal> mealList = cart.getOrders().get(0).getMeals();
                    assertThat(mealList, empty());
                }
        );
    }
}