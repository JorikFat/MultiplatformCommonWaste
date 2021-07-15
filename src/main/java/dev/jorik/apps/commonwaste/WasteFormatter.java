package dev.jorik.apps.commonwaste;

import dev.jorik.apps.commonwaste.person.domain.Person;
import dev.jorik.apps.commonwaste.waste.domain.Waste;

import java.util.Scanner;

public class WasteFormatter {
    private Scanner scanner = new Scanner(System.in);





    public Waste formatWaste(String line){
        System.out.print("Название:");
        String name = scanner.nextLine();

        System.out.print("Сумма:");
        float amount = scanner.nextFloat();

        System.out.print("Оплатил:");
//        Person payer = scanner.nextFloat();

        System.out.print("ID пользователей (0 - все):");




//        return new Waste(0, name, amount, )
        return null;
    }
}
