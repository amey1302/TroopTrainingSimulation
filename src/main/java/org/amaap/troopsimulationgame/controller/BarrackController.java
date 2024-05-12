package org.amaap.troopsimulationgame.controller;

import com.google.inject.Inject;
import org.amaap.troopsimulationgame.controller.dto.HttpStatus;
import org.amaap.troopsimulationgame.controller.dto.Response;
import org.amaap.troopsimulationgame.service.BarrackService;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopDataException;

public class BarrackController {
    private BarrackService barrackService;

    @Inject
    public BarrackController(BarrackService barrackService) {
        this.barrackService = barrackService;
    }

    Response create(int troopCount, String troopType) {
        try {
            barrackService.create(troopCount, troopType);
            return new Response(HttpStatus.OK, "Troops Created Successfully");
        } catch (InvalidTroopDataException exception) {
            return new Response(HttpStatus.BAD_REQUEST, "Invalid Input Parameter");
        }
    }

    Response trainTroopers() {
        try {
            barrackService.train();
            return new Response(HttpStatus.OK, "Troops Trained Successfully");
        } catch (Exception exception) {
            return new Response(HttpStatus.BAD_REQUEST, "Invalid Input Parameter"
            );
        }
    }
}
