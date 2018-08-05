package app.strategies;

import app.annotaions.Operation;

@Operation(sign = '-')
public class SubtractionStrategy implements Strategy {

    @Override
    public int calculate(int firstOperand, int secondOperand){
        return firstOperand - secondOperand;
    }
}
