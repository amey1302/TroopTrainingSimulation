package org.amaap.troopsimulationgame.service;

import com.google.inject.Inject;
import org.amaap.troopsimulationgame.domain.model.entity.Archer;
import org.amaap.troopsimulationgame.domain.model.entity.Barbarian;
import org.amaap.troopsimulationgame.domain.model.entity.Trooper;
import org.amaap.troopsimulationgame.repository.ArmyCampRepository;
import org.amaap.troopsimulationgame.repository.BarrackRepository;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTypeException;
import org.amaap.troopsimulationgame.service.exception.NoTrainedTroopsAvailableException;

import java.util.List;

import static org.amaap.troopsimulationgame.service.validator.TroopValidator.isInvalidType;

public class ArmyCampService {
    private BarrackRepository barrackRepository;
    private ArmyCampRepository armyCampRepository;

    @Inject
    public ArmyCampService(BarrackRepository barrackRepository, ArmyCampRepository armyCampRepository) {
        this.barrackRepository = barrackRepository;
        this.armyCampRepository = armyCampRepository;
    }

    public void addTrainedTrooperFromBarrackToArmyCamp(List<Trooper> trainedTroops)
            throws NoTrainedTroopsAvailableException {
        if (trainedTroops.isEmpty())
            throw new NoTrainedTroopsAvailableException("Troops are not available" + trainedTroops);
        armyCampRepository.save(trainedTroops);
    }

    public List<Trooper> getTrainedTroops() {
        return armyCampRepository.getTrainedTroops();
    }

    public void calculateTroopCount(String troopType) {
        int archerCount = 0;
        int barbarianCount = 0;
        List<Trooper> trainedTroops = armyCampRepository.getTrainedTroops();
        archerCount = (int) trainedTroops.stream()
                .filter(trooper -> trooper instanceof Archer)
                .count();

        barbarianCount = (int) trainedTroops.stream()
                .filter(trooper -> trooper instanceof Barbarian)
                .count();
        armyCampRepository.setTrainedArcherCount(archerCount);
        armyCampRepository.setTrainedBarbarianCount(barbarianCount);
    }

    public int getTroopersCountFor(String troopType) throws InvalidTroopTypeException {
        if (isInvalidType(troopType)) throw new InvalidTroopTypeException("" + troopType);
        else if (troopType.equals("Archer") || troopType.equals("archer")) {
            return armyCampRepository.getTrainedArcherCount();
        } else
            return armyCampRepository.getTrainedBarbarianCount();

    }
}
