package org.amaap.troopsimulationgame.controller;

import org.amaap.troopsimulationgame.controller.dto.HttpStatus;
import org.amaap.troopsimulationgame.controller.dto.Response;

public class TroopController {
    public Response create(int troopCount, String troopType) {
        return new Response(HttpStatus.OK,"Troop Created Successfully");
    }
}
