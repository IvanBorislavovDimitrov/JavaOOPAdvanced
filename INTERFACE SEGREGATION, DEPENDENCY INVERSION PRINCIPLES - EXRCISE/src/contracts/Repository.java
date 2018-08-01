package src.contracts;


import src.exeptions.DuplicateModelException;
import src.exeptions.NonExistantModelException;

public interface Repository<T extends Modelable> {
    void add(T item) throws DuplicateModelException;

    T getItem(String model) throws NonExistantModelException;
}
