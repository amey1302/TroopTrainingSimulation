package org.amaap.troopsimulationgame.service;

import com.google.inject.Inject;
import org.amaap.troopsimulationgame.domain.model.entity.Trooper;
import org.amaap.troopsimulationgame.domain.model.valueobjects.TroopType;
import org.amaap.troopsimulationgame.repository.TroopRepository;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTrainingTimeAndCostException;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTypeException;
import org.amaap.troopsimulationgame.service.exception.InvalidWeaponException;

import java.util.EnumSet;

import static org.amaap.troopsimulationgame.service.validator.TroopValidator.isInvalid;
import static org.amaap.troopsimulationgame.service.validator.TroopValidator.isInvalidType;

public class TroopService {
    private TroopRepository troopRepository;

    @Inject
    public TroopService(TroopRepository troopRepository) {
        this.troopRepository = troopRepository;
    }

    public void create(String troopType, int trainingCost, int trainingTime, String weapon) throws InvalidTroopTrainingTimeAndCostException, InvalidTroopTypeException, InvalidWeaponException {
        if (trainingCost <= 0) throw new InvalidTroopTrainingTimeAndCostException("" + trainingCost);
        if (trainingTime <= 0) throw new InvalidTroopTrainingTimeAndCostException("" + trainingTime);
        if (isInvalidType(troopType)) throw new InvalidTroopTypeException("" + troopType);
        if (isInvalid(weapon)) throw new InvalidWeaponException("" + weapon);
        Trooper trooper = null;
        if (EnumSet.allOf(TroopType.class).contains(troopType)) {
            if (troopType.equals(TroopType.Archer)) {
                trooper = new Trooper(trainingTime, trainingCost, weapon);
            } else if (troopType.equals(TroopType.Barbarian)) {
                trooper = new Trooper(trainingTime, trainingCost, weapon);
            }
        }
        troopRepository.insert(trooper);
    }


}
