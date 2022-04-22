package org.example.dz4;

import org.example.dz4.providers.InvalidTriangleProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

@DisplayName("Треугольник")
public class TriangleTest {

    /*@Test
    @DisplayName("Периметр треугольника: прямоугольный треугольник")
   //@Disabled("Перенесены в параметризированный тест")
    public void countPerimeterTriangleSuccessTest() {
        Triangle triangle = new Triangle(3, 4, 5);
        int perimeter = triangle.countPerimeter();
        assertEquals(12, perimeter);
    }
    @Test
    @DisplayName("Периметр треугольника: равносторонний треугольник")
    //@Disabled("Перенесены в параметризированный тест")
    public void countPerimeterTriangleWithEqualsSidesTest() {
        Triangle triangle = new Triangle(3, 3, 3); //Arrange
        int perimeter = triangle.countPerimeter(); //Act
        assertEquals(9, perimeter); //Assert
    }
    @Test
    @DisplayName("Периметр треугольника: тупоугольный треугольник")
    //@Disabled("Перенесены в параметризированный тест")
    public void angleGreaterThan90Test() {
        Triangle triangle = new Triangle(3, 4, 6); //Arrange
        int perimeter = triangle.countPerimeter(); //Act
        assertEquals(13, perimeter); //Assert
    }*/

    public static Stream<Arguments> triangles() {
        return Stream.of(Arguments.of(new Triangle(3, 4, 5), 6),
                Arguments.of(new Triangle(6, 8, 10), 24),
                Arguments.of(new Triangle(12, 16, 20), 96));
    }

    @ParameterizedTest(name = "Периметр треугольника {0} равен {1}")
    @MethodSource("triangles")
    public void countPerimeterTriangleTest(Triangle triangle, int expectedPerimeter) {
        int perimeter = triangle.countPerimeter(); //Act
        assertEquals(expectedPerimeter, perimeter); //Assert
    }

    @ParameterizedTest(name = "Площадь треугольника {0} равна {1}")
    @MethodSource("triangles")
    public void countSquareTriangleTest(Triangle triangle, int expectedSquare) {
        int square = triangle.countSquare(); //Act
        assertEquals(expectedSquare, square); //Assert
    }

    @ParameterizedTest
    @ArgumentsSource(InvalidTriangleProvider.class)
    public void perimeterInvalidTriangleNegativeTestTest(Triangle triangle) {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("The triangle must be valid", illegalArgumentException.getMessage());
    }


    @ParameterizedTest(name = "Перекрашивание треугольника из {0} в {1}")
    @CsvSource({"RED, GREEN", "GREEN, BLUE"})
    public void paintTriangleWithCsvSourceTest(Triangle.Colour colourBefore, Triangle.Colour colourAfter) {
        Triangle triangle = new Triangle(3, 3, 3, colourBefore); //arrange
        triangle.paint(colourAfter);
        assertEquals(colourAfter, triangle.getColour()); //Assert
    }

    @Nested
    class PaintTriangleTest {
        Triangle triangle;

        @BeforeEach
        void setUp() {
            triangle = new Triangle(3, 3, 3);
        }

        @ParameterizedTest(name = "Перекрашивание треугольника в {0}")
        @EnumSource(Triangle.Colour.class)
        public void paintTriangleTest(Triangle.Colour colour) {
            //Triangle triangle = new Triangle(3, 3, 3);
            assumeFalse(colour.equals(triangle.getColour()));
            triangle.paint(colour);
            assertEquals(colour, triangle.getColour()); //Assert
        }

        @ParameterizedTest(name = "Перекрашивание треугольника в {0}")
        @ValueSource(strings = {"RED", "GREEN"})
        public void paintTriangleWithValueSourceTest(String colour) {
            //Triangle triangle = new Triangle(3, 3, 3);
            triangle.paint(colour);
            assertEquals(Triangle.Colour.valueOf(colour), triangle.getColour()); //Assert
        }
    }
}