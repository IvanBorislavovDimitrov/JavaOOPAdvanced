package app.waste_disposal;

import app.waste_disposal.annotations.Disposable;
import app.waste_disposal.contracts.*;

import java.lang.annotation.Annotation;
import java.util.Map;

public class DefaultGarbageProcessor implements GarbageProcessor {

    private DefaultStrategyHolder strategyHolder;

    private DefaultGarbageProcessor(DefaultStrategyHolder strategyHolder) {
        this.setStrategyHolder(strategyHolder);
    }

    public DefaultGarbageProcessor() {
        this(new DefaultStrategyHolder());
    }

    private void setStrategyHolder(DefaultStrategyHolder strategyHolder) {
        this.strategyHolder = strategyHolder;
    }

    @Override
    public StrategyHolder getStrategyHolder() {
        return this.strategyHolder;
    }

    @Override
    public ProcessingData processWaste(Waste garbage) {
        Class type = garbage.getClass();
        Annotation[] garbageAnnotations = type.getAnnotations();
        Class disposableAnnotation = null;
        for (Annotation annotation : garbageAnnotations) {
            if (annotation.annotationType().isAnnotationPresent(Disposable.class)) {
                disposableAnnotation = annotation.annotationType();
                break;
            }
        }

        GarbageDisposalStrategy currentStrategy;
        Map<Class, GarbageDisposalStrategy> disposalStrategies = this.getStrategyHolder().getDisposalStrategies();
        if (disposableAnnotation == null || !disposalStrategies.containsKey(disposableAnnotation)) {
            throw new IllegalArgumentException(
                    "The passed in garbage does not implement an annotation implementing the Disposable meta-annotation or is not supported by the StrategyHolder.");
        }

        currentStrategy = disposalStrategies.get(disposableAnnotation);
        return currentStrategy.processGarbage(garbage);
    }
}
