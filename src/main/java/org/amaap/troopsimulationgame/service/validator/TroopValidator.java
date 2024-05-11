package org.amaap.troopsimulationgame.service.validator;

import org.amaap.troopsimulationgame.domain.model.valueobjects.TroopType;

public class TroopValidator {
    public static boolean isInvalidType(String troopType) {
        if (troopType == null || troopType.isEmpty()) {
            return true;
        }
        if (troopType.matches(".*\\s+.*")) {
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

    public static boolean isInvalid(String weapon) {
        if (weapon == null || weapon.isEmpty()) {
            return true;
        }
        if (weapon.matches(".*\\d+.*")) {
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
}
