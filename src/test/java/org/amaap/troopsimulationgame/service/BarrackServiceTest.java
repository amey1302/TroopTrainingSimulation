package org.amaap.troopsimulationgame.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.amaap.troopsimulationgame.TroopModule;
import org.amaap.troopsimulationgame.domain.model.entity.Trooper;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopDataException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BarrackServiceTest {

    private BarrackService barrackService;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new TroopModule());
        barrackService = injector.getInstance(BarrackService.class);
    }

    @Test
    void shouldBeAbleToStoreTheTroopsInTheBarrackRepository() throws InvalidTroopDataException {
        // arrange
        barrackService.create(10, "Barbarian");

        // act
        List<Trooper> troopers = barrackService.getTroppers();

        // assert
        assertEquals(10, troopers.size());
    }

    @Test
    void shouldBeAbleToTrainTheTroopsInTheBarrackRepository() throws InvalidTroopDataException {
        // arrange
        barrackService.create(10, "Barbarian");

        // act
        List<Trooper> troopers = barrackService.getTroppers();
        barrackService.train();

        // assert
        assertEquals(10, troopers.size());
        assertEquals(10, barrackService.getTrainedTroppers().size());

    }
}