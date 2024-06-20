package org.amaap.troopsimulationgame.service;

import com.google.inject.Inject;
import org.amaap.troopsimulationgame.domain.model.entity.Archer;
import org.amaap.troopsimulationgame.domain.model.entity.Barbarian;
import org.amaap.troopsimulationgame.domain.model.entity.Trooper;
import org.amaap.troopsimulationgame.domain.service.Train;
import org.amaap.troopsimulationgame.repository.BarrackRepository;
import org.amaap.troopsimulationgame.service.exception.*;

import java.util.List;

import static org.amaap.troopsimulationgame.service.validator.TroopValidator.isInvalid;

public class BarrackService {
    private BarrackRepository barrackRepository;
    private Train train;

    @Inject
    public BarrackService(BarrackRepository barrackRepository, Train train) {
        this.barrackRepository = barrackRepository;
        this.train = train;
    }

    public void create(int troopCount, String troopType) throws InvalidTroopDataException {
        if (troopCount <= 0) throw new InvalidTroopCountException("Invalid Troop Count" + troopCount);
        if (troopCount > 10) throw new BarrackCapacityFullException("Barrack Capacity is Full" + troopCount);
        if (isInvalid(troopType)) throw new InvalidTroopTypeException("Invalid TroopType" + troopType);
        for (int i = 0; i < troopCount; i++) {
            if ("Barbarian".equals(troopType) || "barbarian".equals(troopType)) {
                barrackRepository.insert(new Barbarian(3, 10, "sword"));
            } else if ("Archer".equals(troopType) || "archer".equals(troopType)) {
                barrackRepository.insert(new Archer(6, 20, "bow and arrow"));
            }
        }
    }

    public List<Trooper> train() throws InvalidTroopTypeException {
        List<Trooper> trainedTroops = train.trainTroopers();
        barrackRepository.save(trainedTroops);
        return trainedTroops;
    }

    public List<Trooper> getTroppers() {
        return barrackRepository.getTroopers();
    }

    public List<Trooper> getTrainedTroppers() {
        return barrackRepository.getTrainedTroops();
    }
}