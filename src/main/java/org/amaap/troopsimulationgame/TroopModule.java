package org.amaap.troopsimulationgame;

import com.google.inject.AbstractModule;
import org.amaap.troopsimulationgame.controller.ArmyCampController;
import org.amaap.troopsimulationgame.repository.ArmyCampRepository;
import org.amaap.troopsimulationgame.repository.BarrackRepository;
import org.amaap.troopsimulationgame.repository.TroopRepository;
import org.amaap.troopsimulationgame.repository.impl.InMemoryArmyCampRepository;
import org.amaap.troopsimulationgame.repository.impl.InMemoryBarrackRepository;
import org.amaap.troopsimulationgame.repository.impl.InMemoryTroopRepository;
import org.amaap.troopsimulationgame.repository.impl.db.InMemoryDatabase;
import org.amaap.troopsimulationgame.repository.impl.db.impl.FakeDatabase;

public class TroopModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(TroopRepository.class).to(InMemoryTroopRepository.class);
        bind(BarrackRepository.class).to(InMemoryBarrackRepository.class);
        bind(ArmyCampRepository.class).to(InMemoryArmyCampRepository.class);
        bind(InMemoryDatabase.class).to(FakeDatabase.class).asEagerSingleton();
    }
}
