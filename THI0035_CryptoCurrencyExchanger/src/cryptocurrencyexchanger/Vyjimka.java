
package cryptocurrencyexchanger;


import java.util.Scanner;
import java.util.ArrayList;

        
public class Vyjimka {

    public static void menu(ArrayList<Kryptomena> kryptomeny) {
        Scanner scanner = new Scanner(System.in);
        kryptomeny = Data.parseJSON(kryptomeny, Data.getData());
        String input;
        String input2;
        Double cena1 = null;
        Double cena2 = null;
        Double vysledek = null;
        Double pocet = null;
        int a = 1;
        
        System.out.println("Vitejte v me aplikaci. Zde vidite vypsane nazvy vsech kryptomen pro prevod v me aplikaci.");
        //VYCET
        for(VycetKryptomen vk : VycetKryptomen.values()){
            
            System.out.println(a +  ". "+ vk);
            a++;
        }

        while (true) {
            System.out.println("Prejete si prevest kryptomeny? y/n:");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("n")) {
                scanner.close();
                return;
            }
            else if (input.equalsIgnoreCase("y")) break;
        }

        System.out.println("Vypis zkratek vsech dostupnych kryptomen s aktuální cenou v dolarech:");
        for (Kryptomena k: kryptomeny) {
            System.out.println(k.getZkratka() + " - " + k.getCena() + " USD");
        }

        while (true) {
            System.out.println("Zadejte zkratku kryptomeny, z ktere budete prevadet.");
            input = scanner.nextLine();

            if ((cena1 = Kryptomena.findCena(kryptomeny, input)) == null) {
                System.out.println("Zadana zkratka " + input + " neni v seznamu kryptomen.");
            } else break;
        }

        while (true) {
            System.out.println("Zadejte zkratku kryptomeny, na kterou budete prevadet.");
            input2 = scanner.nextLine();

            if ((cena2 = Kryptomena.findCena(kryptomeny, input2)) == null) {
                System.out.println("Zadana zkratka " + input2 + " neni v seznamu kryptomen.");
            }else if(input.equalsIgnoreCase(input2)){
               System.out.println("Nelze prevadet na stejnou kryptomenu.");
               
            }else break;
        }

        while (true){
            System.out.println("Zadejte pocet minci, ktere chcete prevest.");
            input = scanner.nextLine();

            if ((pocet = Data.tryParse(input)) == null) {
                System.out.println(input + " Neni platne cislo.");
            } else break;
        }

        vysledek = (pocet * cena1) / cena2;
        System.out.println("Vysledek prevodu je " + vysledek + " minci.");
        System.out.println("Dekuji za pouziti me aplikace.");

        scanner.close();
    }
}
