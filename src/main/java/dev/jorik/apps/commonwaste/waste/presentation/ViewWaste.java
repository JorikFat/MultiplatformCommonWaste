package dev.jorik.apps.commonwaste.waste.presentation;

public class ViewWaste {
    private String name;
    private float amount;
    private long payerId;
    private long[] consumersId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public long getPayerId() {
        return payerId;
    }

    public void setPayerId(long payerId) {
        this.payerId = payerId;
    }

    public long[] getConsumersId() {
        return consumersId;
    }

    public void setConsumersId(long[] consumersId) {
        this.consumersId = consumersId;
    }
}
