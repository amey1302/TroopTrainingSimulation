package org.amaap.troopsimulationgame.service;

import com.google.inject.Inject;
import org.amaap.troopsimulationgame.domain.model.entity.Archer;
import org.amaap.troopsimulationgame.domain.model.entity.Barbarian;
import org.amaap.troopsimulationgame.domain.model.entity.Trooper;
import org.amaap.troopsimulationgame.domain.service.Training;
import org.amaap.troopsimulationgame.repository.BarrackRepository;
import org.amaap.troopsimulationgame.service.exception.*;

import java.util.List;

import static org.amaap.troopsimulationgame.service.validator.TroopValidator.isInvalidType;

public class BarrackService {
    private BarrackRepository barrackRepository;
    private Training training;

    @Inject
    public BarrackService(BarrackRepository barrackRepository, Training training) {
        this.barrackRepository = barrackRepository;
        this.training = training;
    }

    public void create(int troopCount, String troopType) throws InvalidTroopDataException, InvalidWeaponException {
        if (troopCount <= 0) throw new InvalidTroopCountException("" + troopCount);
        if (troopCount > 10) throw new BarrackCapacityFullException("" + troopCount);
        if (isInvalidType(troopType)) throw new InvalidTroopTypeException("" + troopType);
        for (int i = 0; i < troopCount; i++) {
            if ("Barbarian".equals(troopType) || "barbarian".equals(troopType)) {
                barrackRepository.insert(new Barbarian(3, 10, "sword"));
            } else if ("Archer".equals(troopType) || "archer".equals(troopType)) {
                barrackRepository.insert(new Archer(6, 20, "bow and arrow"));
            }
        }
    }

    public List<Trooper> train() throws InvalidTroopTypeException {
        List<Trooper> trainedTroops = training.trainTroopers();
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