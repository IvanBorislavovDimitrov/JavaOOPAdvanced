package src.database;

import src.Utility.Constants;
import src.contracts.Modelable;
import src.contracts.Repository;
import src.exeptions.DuplicateModelException;
import src.exeptions.NonExistantModelException;

import java.util.HashMap;
import java.util.Map;

public class RepositoryImpl<T extends Modelable> implements Repository {

    private Map<String, T> itemsByModel;

    public RepositoryImpl() {
        this.setItemsByModel(new HashMap<>());
    }

    protected void setItemsByModel(Map<String, T> itemsByModel) {
        this.itemsByModel = itemsByModel;
    }

    @Override
    public void add(Modelable item) throws DuplicateModelException {
        if (this.itemsByModel.containsKey(item.getModel())) {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }

        this.itemsByModel.put(item.getModel(), (T) item);
    }

    @Override
    public T getItem(String model) throws NonExistantModelException {
        if (!this.itemsByModel.containsKey(model)) {
            throw new NonExistantModelException(Constants.NON_EXISTENT_MODEL_MESSAGE);
        }

        return this.itemsByModel.get(model);
    }
}
