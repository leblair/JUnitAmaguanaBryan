package bubbleSort;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BubbleSortTest {

    BubbleSort bubbleSort = new BubbleSort();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }


    @org.junit.jupiter.api.Test
    @Order(1)
    void AscendentTest() {
        assertArrayEquals(new double[] {-230,-25.5,5.5,10.24,10.25,34.67,125.55}, bubbleSort.asc(new double[]{ 5.5, -25.5, 10.25, 10.24, 34.67, -230, 125.55 }));
    }

    @org.junit.jupiter.api.Test
    @Order(2)
    void DescendentTest() {
        assertArrayEquals(new double[] { 125.55, 34.67, 10.25, 10.24, 5.5, -25.5, -230 }, bubbleSort.desc(new double[]{ 5.5, -25.5, 10.25, 10.24, 34.67, -230, 125.55 }));
    }

    @org.junit.jupiter.api.Test
    @Order(3)
    void DuplicatesTest() {
        assertAll("duplicate",
                ()->{assertArrayEquals(new double[] {-25.5,10.24,10.24,34.67,125.55}, bubbleSort.asc(new double[]{10.24,-25.5,10.25,10.24,34.67,10.24,125.55}));},
                ()->{assertArrayEquals(new double[] { 125.55, 34.67, 10.25, 10.24, 10.24, -25.5}, bubbleSort.desc(new double[]{10.24,-25.5,10.25,10.24,34.67,10.24,125.55}));});
    }

    @org.junit.jupiter.api.Test
    @Order(4)
    void NullArrayTest() {
        assertAll("Null",
                ()-> assertThrows(NullPointerException.class,()->{bubbleSort.asc(new double[]{});}),
                ()-> assertThrows(NullPointerException.class,()->{bubbleSort.desc(new double[]{});})
    );
    }
}