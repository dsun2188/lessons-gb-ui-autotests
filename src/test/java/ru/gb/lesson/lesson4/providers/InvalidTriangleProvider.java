package ru.gb.lesson.lesson4.providers;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import ru.gb.lesson.lesson4.Triangle;

import java.util.stream.Stream;

public class InvalidTriangleProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(Arguments.of(new Triangle(1, 1, 10)), Arguments.of(new Triangle(3, 3, 6)));
    }
}
