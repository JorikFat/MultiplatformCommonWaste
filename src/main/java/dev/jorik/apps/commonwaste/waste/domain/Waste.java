package dev.jorik.apps.commonwaste.waste.domain;

import dev.jorik.apps.commonwaste.person.domain.Person;

import java.util.List;

public class Waste {
    private long id;
    private String name;
    private float amount;
    private Person payer;
    private List<Person> consumers;

    public Waste(long id, String name, float amount, Person payer, List<Person> consumers) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.payer = payer;
        this.consumers = consumers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Person getPayer() {
        return payer;
    }

    public void setPayer(Person payer) {
        this.payer = payer;
    }

    public List<Person> getConsumers() {
        return consumers;
    }

    public void setConsumers(List<Person> consumers) {
        this.consumers = consumers;
    }
}
