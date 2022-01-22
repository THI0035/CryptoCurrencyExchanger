
package cryptocurrencyexchanger;
import java.util.ArrayList;


public class Kryptomena {

    private String jmeno;
    private String zkratka;
    private Double cena;

    public String getJmeno() {
        return this.jmeno;
    }
    public void setJmeno(String name) {
        this.jmeno = name;
    }

    public String getZkratka() {
        return this.zkratka;
    }
    public void setZkratka(String zkratka) {
        this.zkratka = zkratka;
    }

    public Double getCena() {
        return this.cena;
    }
    public void setCena(Double cena) {
        this.cena = cena;
    }

    
    
    public static ArrayList<Kryptomena> kryptomeny = new ArrayList<>();
  
    public static Double findCena(ArrayList < Kryptomena > kryptomeny, String input) {

        for (Kryptomena k: kryptomeny) {
            if (input.equalsIgnoreCase(k.getZkratka())) {
                return k.getCena();

            }

        }
        return null;

    }
}