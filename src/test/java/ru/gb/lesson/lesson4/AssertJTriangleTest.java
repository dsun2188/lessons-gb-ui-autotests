package ru.gb.lesson.lesson4;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import ru.gb.lesson.lesson4.providers.InvalidTriangleProvider;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Треугольник")
public class AssertJTriangleTest {

    @BeforeEach
    void setUp() {
        System.out.println("BeforeEach");
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("BeforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("AfterAll");
    }

    public static Stream<Arguments> triangles() {
        return Stream.of(Arguments.of(new Triangle(3, 4, 5), 12),
                Arguments.of(new Triangle(3, 3, 3), 9),
                Arguments.of(new Triangle(3, 4, 6), 13)
        );
    }

    @ParameterizedTest(name = "Периметр треугольника {0} равен {1}")
    @MethodSource("triangles")
    public void countPerimeterTriangleTest(Triangle triangle, int expectedPerimeter) {
        int perimeter = triangle.countPerimeter(); //Act
        assertThat(perimeter).isEqualTo(expectedPerimeter);
    }

    @ParameterizedTest(name = "Перекрашивание треугольника из {0} в {1}")
    @CsvSource({"RED, GREEN", "GREEN, BLUE"})
    public void paintTriangleWithCsvSourceTest(Triangle.Colour colourBefore, Triangle.Colour colourAfter) {
        Triangle triangle = new Triangle(3, 3, 3, colourBefore); //arrange
        triangle.paint(colourAfter);
        assertThat(triangle.getColour()).isEqualTo(colourAfter);
    }

    @ParameterizedTest
    @ArgumentsSource(InvalidTriangleProvider.class)
    public void perimeterInvalidTriangleNegativeTestTest(Triangle triangle) {
        assertThatThrownBy(triangle::countPerimeter)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The triangle must be valid");
    }


    @Test
    void objectsWithAssertJTest() {
        Triangle triangle = new Triangle(1, 1, 1);
        Triangle similarTriangle = triangle.createSimilarTriangle(2);
        assertThat(similarTriangle).usingRecursiveComparison()
                .ignoringFieldsOfTypes(Triangle.Colour.class)
                .isEqualTo(new Triangle(2, 2, 2, Triangle.Colour.RED));
    }

    @Test
    void listWithAssertJTest() {
        Triangle triangle = new Triangle(1, 1, 1);
        List<Triangle> similarTriangles = triangle.createSimilarTriangles(2, 3);

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(similarTriangles).contains(new Triangle(2, 2, 3));
        softAssertions.assertThat(similarTriangles).contains(new Triangle(3, 2, 3));
        softAssertions.assertThat(similarTriangles).hasSize(3);
        softAssertions.assertAll();
//     можно заменить на это   assertThat(similarTriangles).containsExactlyInAnyOrder(new Triangle(2, 2, 2), new Triangle(3, 3, 3));
    }
}