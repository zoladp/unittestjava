package zadaniesekcja03;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

    @Test
    void newlyCreatedCoordinatesShouldBeBuild() {
        Coordinates coordinates = new Coordinates(2,4);
        assertNotNull(coordinates);
        assertEquals(coordinates.getX(),2);
        assertEquals(coordinates.getY(),4);
    }

    @Test
    void checkPositionIsBelow0ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(-1,0));
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(0,-1));
    }

    @Test
    void checkPositionIsOver100ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(101,0));
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(0,101));
    }

    @Test
    void copyShouldReturnNewObject() {

        //given
        Coordinates coordinates = new Coordinates(10,10);

        //when
        Coordinates copy = new Coordinates(0,0);

        //then
        assertThat(copy,not(sameInstance(coordinates)));
        assertThat(copy,equalTo(coordinates));

    }

    @Test
    void copyShouldReturnAddCoordinates() {

        //given
        Coordinates coordinates = new Coordinates(10,10);

        //when
        Coordinates copy = Coordinates.copy(coordinates,5,6);

        //then
        assertThat(copy.getX(),equalTo(15));
        assertThat(copy.getY(),equalTo(16));

    }
}