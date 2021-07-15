package dev.jorik.apps.commonwaste;

import dev.jorik.apps.commonwaste.person.domain.Person;
import dev.jorik.apps.commonwaste.waste.domain.Waste;

import java.util.ArrayList;
import java.util.List;

public class WastesGroup {
    private List<Person> persons;
    private List<Waste> wastes;

    public WastesGroup(List<Person> persons) {
        this.persons = persons;
        this.wastes = new ArrayList<>();
    }

    public void addWaste(Waste waste){
        wastes.add(waste);
        Person payer = waste.getPayer();
        payer.setBalance(payer.getBalance() - waste.getAmount());

        float payPart = waste.getAmount() / waste.getConsumers().size();
        for(Person consumers :waste.getConsumers()){
            consumers.setBalance(consumers.getBalance() + payPart);
        }
    }

    public List<Person> getPersons(){
        return persons;
    }

    public void printWastes(){
        System.out.print("Траты          Сумма     ");
        for(Person person :persons) System.out.printf("%s", format(person.getName(), 10));
        System.out.println();

        for (Waste waste :wastes){
            System.out.printf("%s%s",
                    format(waste.getName(), 15),
                    format(waste.getAmount(), 10)
            );
            for (Person consumer :waste.getConsumers()){
                if(consumer == waste.getPayer()){
                    System.out.print(format(waste.getAmount(), 10, "-"));
                } else {
                    System.out.print(format(waste.getAmount() / waste.getConsumers().size(), 10, "+"));
                }
            }
            System.out.println();
        }
        System.out.println(charLine('=', 25 + (persons.size() * 10)));
        System.out.print(format("", 25));
        for (Person person :persons){
            float balance = person.getBalance();
            if(balance > 0) System.out.print(format(balance, 10, "+"));
            else System.out.print(format(balance, 10));
        }
    }

    private String charLine(char c, int lenght){
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<lenght; i++) builder.append(c);
        return builder.toString();
    }

    private String format(float f, int length){
        return format(String.format("%.2f", f), length);
    }

    private String format(float f, int length, String prefix){
        int dLenght = length - prefix.length();
        return prefix + format(String.format("%.2f", f), dLenght);
    }

    private String format(String src, int length){
        if(src.length() < length){
            int diff = length - src.length();
            StringBuilder builder = new StringBuilder(src);
            for(int i=0; i<diff; i++) builder.append(' ');
            return builder.toString();
        }
        return src;
    }
}
