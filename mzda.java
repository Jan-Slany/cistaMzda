import java.util.Scanner;

public class kodovani {
    public static void main(String[] args) {

        CistaMzda();

        }
        public static void CistaMzda(){
            Scanner scan = new Scanner(System.in);

            // veškeré inputy
            System.out.printf("Zadej hrubou měsíční mzdu: ");
            int hrubaMzda = scan.nextInt();

            System.out.printf("Zadej počet dětí: ");
            int pocetDeti = scan.nextInt();

            System.out.printf("Podepsal růžový papír [true/false]: ");
            boolean poplatnik = scan.nextBoolean();

            int slevaDeti;
            
            int slevaPoplatnik = 2570;

            // switch na slevy na děti
            switch (pocetDeti){
                case 0:
                    slevaDeti = 0;
                    break;
                case 1:
                    slevaDeti = 1267;
                    break;
                case 2:
                    slevaDeti = 3127;
                    break;
                case 3:
                    slevaDeti = 5447;
                    break;
                default:
                    slevaDeti = 5447;
                    for (int i = 0; i < pocetDeti - 3; i++) slevaDeti += 2320;
            }

            // výpočet daně z příjmu
            double zprijmu = Math.round(hrubaMzda / 100) * 100 / 100 * 15;
            zprijmu = zprijmu - slevaDeti - slevaPoplatnik;
            Math.ceil(zprijmu);

            // výpočet sociálního pojištění
            double socialni = (hrubaMzda/100)*6.5;
            Math.ceil(socialni);

            // výpočet zdravotního pojištění
            double zdravotni = (hrubaMzda/100)*4.5;
            Math.ceil(zdravotni);

            // výpočet čisté mzdy a roční mzdy
            double cistaMzda = hrubaMzda - zprijmu - socialni - zdravotni;
            double rocniMzda = cistaMzda * 12;

            System.out.printf("%nČistá mzda: %.0f,-%nRoční čistá mzda: %.0f,-%n", cistaMzda, rocniMzda);
        }
}
