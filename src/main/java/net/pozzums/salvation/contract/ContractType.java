package net.pozzums.salvation.contract;

public enum ContractType {
    MURDER_FOR_HIRE("Murder for Hire"),
    KILL_ON_SIGHT("Kill on Sight"),
    BANISHMENT("Banishment"),
    MAX_HEALTH_REDUCTION("Max Health Reduction");

    private final String display;

    ContractType(String display) {
        this.display = display;
    }

    public String displayName() {
        return display;
    }

    public ContractType next() {
        ContractType[] values = values();
        return values[(this.ordinal() + 1) % values.length];
    }
}
