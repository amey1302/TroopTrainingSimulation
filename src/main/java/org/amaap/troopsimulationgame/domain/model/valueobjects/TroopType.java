package org.amaap.troopsimulationgame.domain.model.valueobjects;

public enum Troop {
    Barbarian("Barbarian"), Archer("Archer");

    private final String typeName;

    Troop(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
