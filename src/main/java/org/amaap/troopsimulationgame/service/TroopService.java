package org.amaap.troopsimulationgame.service;

import jakarta.inject.Inject;
import org.amaap.troopsimulationgame.domain.model.valueobjects.Troop;
import org.amaap.troopsimulationgame.repository.TroopRepository;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopCountException;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTypeException;

public class TroopService {
    private TroopRepository troopRepository;

    @Inject
    public TroopService(TroopRepository troopRepository) {
        this.troopRepository = troopRepository;
    }

    public void create(int troopCount, String troopType) throws InvalidTroopCountException, InvalidTroopTypeException {
        if (troopCount <= 0) throw new InvalidTroopCountException("" + troopCount);
        if (isInvalid(troopType)) throw new InvalidTroopTypeException("" + troopType);
        troopRepository.insert(troopCount,troopType);
    }

    private boolean isInvalid(String troopType) {
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

    private boolean isValidTroopType(String troopType) {
        for (Troop troop : Troop.values()) {
            if (troop.getTypeName().equalsIgnoreCase(troopType)) {
                return true;
            }
        }
        return false;
    }
}
