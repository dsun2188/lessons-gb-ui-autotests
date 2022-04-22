package org.example.dz4;

import lombok.AllArgsConstructor;
import lombok.Data;

import static java.lang.Math.sqrt;

@Data
@AllArgsConstructor

public class Triangle {
    private int a;
    private int b;
    private int c;
    private Colour colour = Colour.WHITE;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public enum Colour {
        RED, WHITE, BLUE, GREEN
    }

    public boolean isValid() {
        int maxSide = Math.max(a, Math.max(b, c));
        return maxSide < (a + b + c - maxSide);
    }

    public boolean hasPositiveSides() {
        return a > 0 && b > 0 && c > 0;
    }

    public int countPerimeter() {
        if (!hasPositiveSides()) {
            throw new IllegalArgumentException("The sides must be positive");
        }
        if (!isValid()) {
            throw new IllegalArgumentException("The triangle must be valid");
        }
        return a + b + c;
    }

    public int countSquare() {
        if (!hasPositiveSides()) {
            throw new IllegalArgumentException("The sides must be positive");
        }
        if (!isValid()) {
            throw new IllegalArgumentException("The triangle must be valid");
        }
        return (int) sqrt(((a+b+c)/2)*((a+b+c)/2-a)*((a+b+c)/2-b)*((a+b+c)/2-c));

    }

    public void paint(Colour colour) {
        if (this.colour == colour) {
            throw new IllegalArgumentException("The new colour must be not equal to old colour");
        }
        this.setColour(colour);
    }

    public void paint(String colour) {
        this.paint(Colour.valueOf(colour));
    }
}
