package net.pozzums.salvation.contract;

import java.util.UUID;

public class ContractDraft {

    private final UUID issuer;
    private UUID target;
    private ContractType type = ContractType.MURDER_FOR_HIRE;

    public ContractDraft(UUID issuer) {
        this.issuer = issuer;
    }

    public UUID getIssuer() { return issuer; }
    public UUID getTarget() { return target; }
    public ContractType getType() { return type; }

    public void setTarget(UUID target) { this.target = target; }
    public void cycleType() { type = type.next(); }
}
