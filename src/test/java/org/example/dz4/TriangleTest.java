package org.example.dz4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    /*@ParameterizedTest(name = "Периметр треугольника {0} равен {1}")
    @MethodSource("triangles")
    public void countPerimeterTriangleTest(Triangle triangle, int expectedPerimeter) {
        int perimeter = triangle.countPerimeter(); //Act
        assertEquals(expectedPerimeter, perimeter); //Assert
    }*/

    @ParameterizedTest(name = "Площадь треугольника {0} равна {1}")
    @MethodSource("triangles")
    public void countSquareTriangleTest(Triangle triangle, int expectedSquare) {
        int square = triangle.countSquare(); //Act
        assertEquals(expectedSquare, square); //Assert
    }

}
