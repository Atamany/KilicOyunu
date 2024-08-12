import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] deste = Deste();
        kar(deste);

        System.out.println("Deste karılıyor...");
        System.out.println("Desteyi kesmek için Enter'a basınız...");
        scanner.nextLine();
        System.out.println("Deste kesiliyor...");
        System.out.println("Oyun Başladı...");
        System.out.println("Kart Giriniz (Kart No-Kart Türü): ");
        String sayi = scanner.nextLine();

        int kullaniciSira = 1;
        int AcikKartlar = 0;

        
        while (deste.length > 0) {
            System.out.println(kullaniciSira + " numaralı kullanıcının sırası. Kart istemek için Enter'a basınız...");
            scanner.nextLine();
            String card = deste[0];
            deste = CardCikar(deste);

            AcikKartlar++;

            System.out.println("Açılmış Kart: " + card);
            System.out.println("Kullanıcı-" + kullaniciSira + " açıldı " + AcikKartlar + " kart.");
            System.out.println("*************************************");
            if(card.equals(sayi)){
                System.out.println("Tebrikler! Kazandın " + kullaniciSira + " numaralı kullanıcı");
                break;
    }
            kullaniciSira = (kullaniciSira % 2) + 1;
            
        }

        scanner.close();
    }

    private static String[] Deste() {
        String[] deste = new String[52];
        String[] turler = {"Maça", "Kupa", "Karo", "Sinek"};
        String[] degerler = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        int index = 0;
        for (String tur : turler) {
            for (String deger : degerler) {
                deste[index++] = deger + "-" + tur;
            }
        }

        return deste;
    }

    private static void kar(String[] deste) {
        Random random = new Random();
        for (int i = deste.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            String gecici = deste[i];
            deste[i] = deste[j];
            deste[j] = gecici;
        }
    }

    private static String[] CardCikar(String[] deste) {
        String[] newdeste = new String[deste.length - 1];
        System.arraycopy(deste, 1, newdeste, 0, deste.length - 1);
        return newdeste;
    }

}
