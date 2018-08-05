package app.strategies;

import app.annotaions.Operation;

@Operation(sign = '*')
public class MultiplicationStrategy implements Strategy {

    @Override
    public int calculate(int firstOperand, int secondOperand) {
        return firstOperand * secondOperand;
    }
}
