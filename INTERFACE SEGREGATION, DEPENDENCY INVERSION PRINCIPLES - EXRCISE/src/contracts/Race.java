package src.contracts;
import src.exeptions.DuplicateModelException;
import src.models.boats.Boat;

import java.util.List;

public interface Race
{
    int getDistance();

    int getWindSpeed();

    int getOceanCurrentSpeed();

    Boolean getAllowsMotorboats();

    void addParticipant(Boat boat) throws DuplicateModelException;

    List<Boat> getParticipants();
}
