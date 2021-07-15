package dev.jorik.apps.commonwaste.person.domain;

public class Person {
    private long id;
    private String name;
    private float balance;

    public Person(long id, String name) {
        this.id = id;
        this.name = name;
        this.balance = 0f;
    }

    public Person(String name){
        this.id = 0;
        this.name = name;
        this.balance = 0f;
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

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
