package at.campus02.swe.logic;


import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;

import java.util.Stack;

public class CalculatorImpl implements Calculator {

    private Stack<Double> stack_ = new Stack<Double>();

    @Override
    public double perform(Operation op) throws CalculatorException {

        double b;
        double a;


        switch (op) {
            case add:
                b = pop();
                a = pop();
                return a + b;
            case sub:
                b = pop();
                a = pop();
                return a - b;
            case div:
                b = pop();
                a = pop();
                double c = a / b;
                if (Double.isInfinite(c))
                    throw new CalculatorException("Division by zero");
                return c;
            case mul:
                b = pop();
                a = pop();
                return a * b;
            case mod:
                b = pop();
                a = pop();
                return a % b;
            case cos:
                a = pop();
                return Math.cos(a);
            case sin:
                a = pop();
                return Math.sin(a);
            case dotProduct:
                return dotProduct();
        }
        return 0;
    }

    @Override
    public double pop() throws CalculatorException {
        if (stack_.isEmpty())
            throw new CalculatorException();
        return stack_.pop();
    }

    @Override
    public void push(double v) {
        stack_.push(v);
    }

    @Override
    public void clear() {
        stack_.clear();
    }

    private double dotProduct() throws CalculatorException {
        int elements = (int) pop();

        if (elements <= 0) {
            throw new CalculatorException("Number of elements per vector must be greater than zero");
        }

        double[] vectorB = new double[elements];
        double[] vectorA = new double[elements];

        // Fülle zuerst Vektor B
        for (int index = elements - 1; index >= 0; index--) {
            vectorB[index] = pop();
        }

        // Fülle danach Vektor A
        for (int index = elements - 1; index >= 0; index--) {
            vectorA[index] = pop();
        }

        double dot = 0.0;
        for (int index = 0; index < elements; index++) {
            dot += vectorA[index] * vectorB[index];
        }

        return dot;
    }


}
