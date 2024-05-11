package org.amaap.troopsimulationgame.controller;

import com.google.inject.Inject;
import org.amaap.troopsimulationgame.controller.dto.HttpStatus;
import org.amaap.troopsimulationgame.controller.dto.Response;
import org.amaap.troopsimulationgame.service.TroopService;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopDataException;

public class TroopController {
    private TroopService troopService;

    @Inject
    public TroopController(TroopService troopService) {
        this.troopService = troopService;
    }

    public Response create(String troopType, int trainingTime, int trainingCost, String weapon) {
        try {
            troopService.create(troopType, trainingTime, trainingCost, weapon);
            return new Response(HttpStatus.OK, "Troop Created Successfully");
        } catch (InvalidTroopDataException exception) {
            return new Response(HttpStatus.BAD_REQUEST, "Invalid Input Parameter " + exception.getMessage());
        }
    }
}
