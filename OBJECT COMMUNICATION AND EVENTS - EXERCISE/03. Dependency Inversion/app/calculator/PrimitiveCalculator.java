package app.calculator;

import app.annotaions.Operation;
import app.strategies.*;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PrimitiveCalculator {

    private static final String PATH = "app.strategies.";
    private static final String FULL_PATH = "src/main/java/app/strategies";
    private Strategy strategy;

    public PrimitiveCalculator() {
    }

    @SuppressWarnings("unchecked")
    public void setStrategy(char sigh) {
        File directory = new File(FULL_PATH);
        File[] files = directory.listFiles();
        if (files == null) {
            throw new IllegalArgumentException("Directory is empty!");
        }
        for (File strategyFile : files) {
            try {
                Class<? extends Strategy> strategyClass = (Class<? extends Strategy>) Class.forName(PATH + strategyFile.getName().substring(0, strategyFile.getName().indexOf('.')));
                if (strategyClass.isAnnotationPresent(Operation.class)) {
                    if (strategyClass.getAnnotation(Operation.class).sign() == sigh) {
                        Constructor<? extends Strategy> constructor = strategyClass.getDeclaredConstructor();

                        this.strategy = constructor.newInstance();
                    }
                }
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void changeStrategy(char sign) {
        switch (sign) {
            case '-':
                this.strategy = new SubtractionStrategy();
                return;
            case '+':
                this.strategy = new AdditionStrategy();
                return;
            case '*':
                this.strategy = new MultiplicationStrategy();
                return;
            case '/':
                this.strategy = new DivisionStrategy();
        }
    }

    public int performCalculation(int firstOperand, int secondOperand) {
        return this.strategy.calculate(firstOperand, secondOperand);
    }
}
