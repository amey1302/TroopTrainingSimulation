package org.amaap.troopsimulationgame.domain.service;

import com.google.inject.Inject;
import org.amaap.troopsimulationgame.domain.model.entity.Archer;
import org.amaap.troopsimulationgame.domain.model.entity.Barbarian;
import org.amaap.troopsimulationgame.domain.model.entity.Trooper;
import org.amaap.troopsimulationgame.repository.BarrackRepository;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTypeException;

import java.util.ArrayList;
import java.util.List;

public class Training {
    private static final int MAX_CAPACITY = 10;
    private final BarrackRepository barrackRepository;

    @Inject
    public Training(BarrackRepository barrackRepository) {
        this.barrackRepository = barrackRepository;
    }

    public List<Trooper> trainTroopers() throws InvalidTroopTypeException {
        List<Trooper> troopers = barrackRepository.getTroopers();
        List<Trooper> trainedTroops = new ArrayList<>();
        for (int i = 0; i < troopers.size(); i += MAX_CAPACITY) {
            int endIndex = Math.min(i + MAX_CAPACITY, troopers.size());
            List<Trooper> batch = troopers.subList(i, endIndex);
            trainedTroops = trainBatch(batch);
        }
        return trainedTroops;
    }

    private List<Trooper> trainBatch(List<Trooper> batch) {
        List<Trooper> trainedTroops = new ArrayList<>();
        System.out.println("Troops are Training...");
        for (int i = 0; i < batch.size(); i++) {
            Trooper troopObj = batch.get(i);
            if (troopObj instanceof Archer) {
                Archer archer = (Archer) troopObj;
                int trainingTime = troopObj.getTrainingTime();
                try {
                    Thread.sleep(trainingTime * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                trainedTroops.add(troopObj);

            } else if (troopObj instanceof Barbarian) {
                Barbarian barbarian = (Barbarian) troopObj;
                int trainingTime = troopObj.getTrainingTime();
                try {
                    Thread.sleep(trainingTime * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                trainedTroops.add(troopObj);
            }

        }
        System.out.println("Training Completed...");
        return trainedTroops;
    }

}
