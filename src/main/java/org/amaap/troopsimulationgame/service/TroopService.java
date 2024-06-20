package org.amaap.troopsimulationgame.service;

import com.google.inject.Inject;
import org.amaap.troopsimulationgame.domain.model.entity.Trooper;
import org.amaap.troopsimulationgame.domain.model.valueobjects.TroopType;
import org.amaap.troopsimulationgame.repository.TroopRepository;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopDataException;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTrainingCostException;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTrainingTimeException;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTypeException;

import java.util.EnumSet;

import static org.amaap.troopsimulationgame.service.validator.TroopValidator.isInvalid;

public class TroopService {
    private TroopRepository troopRepository;

    @Inject
    public TroopService(TroopRepository troopRepository) {
        this.troopRepository = troopRepository;
    }

    public void create(String troopType, int trainingTime, int trainingCost, String weapon) throws InvalidTroopDataException {
        if (trainingCost <= 0) throw new InvalidTroopTrainingCostException("Invalid Troop Cost" + trainingCost);
        if (trainingTime <= 0) throw new InvalidTroopTrainingTimeException("Invalid TrainingTime" + trainingTime);
        if (isInvalid(troopType)) throw new InvalidTroopTypeException("Invalid Troop Type" + troopType);
        Trooper trooper = null;
        if (EnumSet.allOf(TroopType.class).contains(troopType)) {
            if (troopType.equals(TroopType.Archer)) {
                trooper = new Trooper(trainingCost, trainingTime, weapon);
            } else if (troopType.equals(TroopType.Barbarian)) {
                trooper = new Trooper(trainingCost, trainingTime, weapon);
            }
        }
        troopRepository.insert(trooper);
    }


}
