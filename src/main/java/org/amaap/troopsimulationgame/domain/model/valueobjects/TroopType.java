package org.amaap.troopsimulationgame.domain.model.valueobjects;

public enum TroopType {
    Barbarian("Barbarian"), Archer("Archer");

    private final String typeName;

    TroopType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
