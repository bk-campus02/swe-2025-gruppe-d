package at.campus02.swe.logic;


import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;

import java.util.Stack;

public class CalculatorImpl implements Calculator {

    private Stack<Double> stack_ = new Stack<Double>();

    @Override
    public double perform(Operation op) throws CalculatorException {

        double b = pop();
        double a = pop();
        double ak = pop();
        double gk = pop();
        double hy = pop();

        switch (op) {
            case add:
                return a + b;
            case sub:
                return a - b;
            case div:
                double c = a / b;
                if (Double.isInfinite(c))
                    throw new CalculatorException("Division by zero");
                return c;
            case mul:
                return a * b;
            case mod:
                return a % b;
            case cos:
                if (hy == 0)
                    throw new CalculatorException("Hypotenuse darf nicht 0 sein");
                return ak / hy;
            case sin:
                if (hy == 0)
                    throw new CalculatorException("Hypotenuse darf nicht 0 sein");
                return gk / hy;
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

}
