//package org.amaap.troopsimulationgame.domain.model.service;
//
//import org.amaap.troopsimulationgame.domain.model.Archer;
//import org.amaap.troopsimulationgame.domain.model.Barbarian;
//import org.amaap.troopsimulationgame.repository.BarrackRepository;
//import org.amaap.troopsimulationgame.repository.TroopRepository;
//import org.amaap.troopsimulationgame.service.exception.InvalidTroopTypeException;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Training {
//    private static final int MAX_CAPACITY = 10;
//    private final BarrackRepository barrackRepository;
//    private final TroopRepository troopRepository;
//
//    public Training(BarrackRepository barrackRepository, TroopRepository troopRepository) {
//        this.barrackRepository = barrackRepository;
//        this.troopRepository = troopRepository;
//    }
//
//    public void train(List<Object> troops) throws InvalidTroopTypeException {
//        troops = barrackRepository.getTroopers();
//        for (int i = 0; i < troops.size(); i += MAX_CAPACITY) {
//            int endIndex = Math.min(i + MAX_CAPACITY, troops.size());
//            List<Object> batch = troops.subList(i, endIndex);
//            trainBatch(batch);
//        }
//    }
//
//    private void trainBatch(List<Object> batch) throws InvalidTroopTypeException {
//        List<Object> trainedTroops = new ArrayList<>();
//        for (int i = 0; i < batch.size(); i++) {
//            Object troopObj = batch.get(i);
//            if (troopObj instanceof Archer) {
//                Archer archer = (Archer) troopObj;
//                int trainingTime = troopRepository.getTrainingTime("Archer");
//                try {
//                    Thread.sleep(trainingTime * 100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                trainedTroops.add(archer);
//
//                barrackRepository.setTrainedArcherCount(barrackRepository.getTrainedArcherCount() + 1);
//            } else if (troopObj instanceof Barbarian) {
//                Barbarian barbarian = (Barbarian) troopObj;
//                int trainingTime = troopRepository.getTrainingTime("Barbarian");
//                try {
//                    Thread.sleep(trainingTime * 1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                trainedTroops.add(barbarian);
//                barrackRepository.setTrainedBarbarianCount(barrackRepository.getTrainedBarbarianCount() + 1);
//            }
//        }
//        System.out.println("Updated trained troops in repository: " + barrackRepository.getTrainedTroops());
//        barrackRepository.trainedTroops(trainedTroops);
//    }
//}
