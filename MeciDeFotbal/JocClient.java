package MeciDeFotbal;

import java.util.Scanner;

public class JocClient {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Jocul numarul 1:");
            System.out.println("Numele echipei 1:");
            String numeEchipa1Joc1 = scanner.nextLine();
            System.out.println("Numele echipei 2:");
            String numeEchipa2Joc1 = scanner.nextLine();
            System.out.println("Jocul numarul 2:");
            System.out.println("Numele echipei 1:");
            String numeEchipa1Joc2 = scanner.nextLine();
            System.out.println("Numele echipei 2:");
            String numeEchipa2Joc2 = scanner.nextLine();
            Joc joc = new Joc(numeEchipa1Joc1, numeEchipa2Joc1);
            Joc joc2 = new Joc(numeEchipa1Joc2, numeEchipa2Joc2);
            joc.simuleaza();
            joc2.simuleaza();
            System.out.println(joc);
            System.out.println(joc2);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
