package org.amaap.troopsimulationgame.controller;

import com.google.inject.Inject;
import org.amaap.troopsimulationgame.controller.dto.HttpStatus;
import org.amaap.troopsimulationgame.controller.dto.Response;
import org.amaap.troopsimulationgame.domain.model.entity.Trooper;
import org.amaap.troopsimulationgame.service.ArmyCampService;

import java.util.List;

public class ArmyCampController {
    private ArmyCampService armyCampService;

    @Inject
    public ArmyCampController(ArmyCampService armyCampService) {
        this.armyCampService = armyCampService;
    }

    public Response addTrainedTrooperIntoArmyCamp(List<Trooper> trainedTroops) {
        try {
            armyCampService.addTrainedTrooperFromBarrackToArmyCamp(trainedTroops);
            return new Response(HttpStatus.OK, "Troops are available in ArmyCamp");
        } catch (Exception exception) {
            return new Response(HttpStatus.BAD_REQUEST, "Troops are not available");
        }
    }

    public Response getTroopersCountFor(String troopType) {
        try {
            int count = armyCampService.getTroopersCountFor(troopType);
            return new Response(HttpStatus.OK, "Troops Available in ArmyCamp", count);
        } catch (Exception exception) {
            return new Response(HttpStatus.BAD_REQUEST, "No Troops in ArmyCamp For this TroopType", 0);
        }
    }
}
