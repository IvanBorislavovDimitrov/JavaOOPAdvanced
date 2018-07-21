package pr0304Barracks.core.commands;

import pr0304Barracks.annotations.Inject;
import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

public class ReportCommand implements Executable {

    @Inject
    private Repository repository;

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
