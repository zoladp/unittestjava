package pl.devfoundry.testing;

import org.junit.jupiter.api.*;

import java.io.IOException;

class OrderBackupTest {

    private static OrderBackup orderBackup;

    @BeforeAll
    static void setup() throws IOException {
        orderBackup = new OrderBackup();
        orderBackup.createFile();
    }

    @BeforeEach
    void appendAtTheStartOfTheLine() throws IOException {
        orderBackup.getWriter().append("New order: ");
    }

    @AfterEach
    void appendAtheEndOfTheLine() throws IOException {
        orderBackup.getWriter().append(" backed up.");
    }

    @Test
    void backupOrderWithOneMeal() throws IOException {
        //given
        Meal meal1 = new Meal(7,"Fries");
        Meal meal2 = new Meal(17,"Burger");
        Meal meal3 = new Meal(5,"Sandwich");
        Order order = new Order();
        order.addMealToOrder(meal1);
        order.addMealToOrder(meal2);
        order.addMealToOrder(meal3);

        //when
        orderBackup.backupOrder(order);

        //then
        System.out.println("Order: " + order.toString() + " backed up.");
    }

    @AfterAll
    static void tearDown() throws IOException {
        orderBackup.closeFile();
    }

}