package org.amaap.troopsimulationgame.service.builder;

import org.amaap.troopsimulationgame.domain.model.entity.Archer;
import org.amaap.troopsimulationgame.domain.model.entity.Barbarian;
import org.amaap.troopsimulationgame.domain.model.entity.Trooper;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopDataException;

import java.util.ArrayList;
import java.util.List;

public class TrainedTroop {
    public static List<Trooper> trainedTroopers() throws InvalidTroopDataException {
        List<Trooper> expectedTrainedTroops = new ArrayList<>();
        Trooper archer1 = new Archer(6, 20, "bow and arrow");
        Trooper archer2 = new Archer(6, 20, "bow and arrow");
        Trooper barbarian1 = new Barbarian(3, 10, "sword");
        Trooper barbarian2 = new Barbarian(3, 10, "sword");
        expectedTrainedTroops.add(archer1);
        expectedTrainedTroops.add(archer2);
        expectedTrainedTroops.add(barbarian1);
        expectedTrainedTroops.add(barbarian2);
        return expectedTrainedTroops;
    }
}
