package pl.devfoundry.testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Order order;

    @BeforeEach
    void initializaOrder() {
        System.out.println("Inside @BeforeEach method");
        order = new Order();
    }

    @AfterEach
    void cleanUp() {
        System.out.println("Inside @AfterEach method\n");
        order.cancel();
    }


    @Test
    void testAssertArrayEquals() {
        System.out.println("Inside test testAssertArrayEquals");
        //given
        int[] ints1 = {1,2,3};
        int[] ints2 = {1,2,3};

        //then
        assertArrayEquals(ints1,ints2);
    }

    @Test
    void mealListShouldBeEmptyAfterCreationOfOrder() {
        System.out.println("Inside test mealListShouldBeEmptyAfterCreationOfOrder");
        //given

        //then
        assertThat(order.getMeals(), empty());
        assertThat(order.getMeals().size(), equalTo(0));
        assertThat(order.getMeals(), hasSize(0));
        assertThat(order.getMeals(), emptyCollectionOf(Meal.class));
    }

    @Test
    void addingMealToOrderShouldIncreaseOrderSize() {
        System.out.println("Inside test addingMealToOrderShouldIncreaseOrderSize");
        //given
        Meal meal = new Meal(15,"Burger");
        Meal meal2 = new Meal(5,"Sandwich");

        //when
        order.addMealToOrder(meal);

        //then
        assertThat(order.getMeals(), hasSize(1));
        assertThat(order.getMeals(), contains(meal));
        assertThat(order.getMeals(), hasItem(meal));
        assertThat(order.getMeals().get(0).getPrice(), equalTo(15));
    }

    @Test
    void removingMealFromOrderShouldDecreaseOrderSize() {
        System.out.println("Inside test removingMealFromOrderShouldDecreaseOrderSize");
        //given
        Meal meal = new Meal(15,"Burger");

        //when
        order.addMealToOrder(meal);
        order.removeMealFromOrder(meal);

        //then
        assertThat(order.getMeals(), hasSize(0));
        assertThat(order.getMeals(), not(contains(meal)));
    }

    @Test
    void mealsShouldBeInCorrectOrderAfterAddingThemToOrder() {
        System.out.println("Inside test mealsShouldBeInCorrectOrderAfterAddingThemToOrder");
        //given
        Meal meal1 = new Meal(15,"Burger");
        Meal meal2 = new Meal(5,"Sandwich");

        //when
        order.addMealToOrder(meal1);
        order.addMealToOrder(meal2);

        //then
        //assertThat(order.getMeals(), contains(meal1,meal2));
        assertThat(order.getMeals(), containsInAnyOrder(meal2,meal1));
    }

    @Test
    void testIfTwoMealListsAreTheSame() {
        System.out.println("Inside test testIfTwoMealListsAreTheSame");
        //given
        Meal meal1 = new Meal(15,"Burger");
        Meal meal2 = new Meal(5,"Sandwich");
        Meal meal3 = new Meal(11,"Kebab");

        List<Meal> meals1 = Arrays.asList(meal1,meal2);
        List<Meal> meals2 = Arrays.asList(meal1,meal2);
        //List<Meal> meals2 = Arrays.asList(meal1,meal2,meal3);

        //then
        assertThat(meals1, is(meals2));

    }

}