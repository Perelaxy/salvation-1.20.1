package net.pozzums.salvation.contract;

public enum ContractType {

    MURDER_FOR_HIRE("Murder for Hire"),
    KILL_ON_SIGHT("Kill on Sight"),
    BANISHMENT("Banishment"),
    MAX_HEALTH_REDUCTION("Max Health Reduction");

    private final String displayName;

    ContractType(String displayName) { this.displayName = displayName; }

    public String displayName() { return displayName; }

    public ContractType next() {
        ContractType[] values = values();
        return values[(this.ordinal() + 1) % values.length];
    }
}
