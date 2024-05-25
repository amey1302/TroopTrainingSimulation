package org.amaap.troopsimulationgame.service.validator;

import org.amaap.troopsimulationgame.domain.model.entity.Archer;
import org.amaap.troopsimulationgame.domain.model.entity.Barbarian;
import org.amaap.troopsimulationgame.domain.model.entity.Trooper;
import org.amaap.troopsimulationgame.domain.model.valueobjects.TroopType;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTypeException;

public class TroopValidator {
    public static boolean isInvalid(String troopType) {
        if (troopType == null || troopType.isEmpty()) {
            return true;
        }
        if (!isValidTroopType(troopType)) {
            return true;
        }
        if (troopType.matches(".*\\d+.*")) {
            return true;
        }
        return false;
    }

    private static boolean isValidTroopType(String troopType) {
        for (TroopType troop : TroopType.values()) {
            if (troop.getTypeName().equalsIgnoreCase(troopType)) {
                return true;
            }
        }
        return false;
    }
    public static Class<? extends Trooper> getTroopClass(String troopType) throws InvalidTroopTypeException {
        for (TroopType type : TroopType.values()) {
            if (type.getTypeName().equalsIgnoreCase(troopType)) {
                switch (type) {
                    case Archer:
                        return Archer.class;
                    case Barbarian:
                        return Barbarian.class;
                }
            }
        }
        throw new InvalidTroopTypeException("Invalid troop type: " + troopType);
    }

}
