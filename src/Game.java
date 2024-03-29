import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Macera oyununa hoşgeldiniz");
        System.out.println("Lütfen bir isim giriniz: ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName() + " Oyuna Hoşgeldin");
        System.out.println("Lütfen oyuna başlamak için karakter seç");
        player.selectChar();

        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println("Bölgeler");
            System.out.println("1 - Güvenli ev");
            System.out.println("2 - Mağaza");
            System.out.println("3 - Mağara");
            System.out.println("4 - Orman");
            System.out.println("5 - Nehir");
            System.out.println("0 - Çıkış Yap");
            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz: ");
            int selectlLoc = input.nextInt();
            switch (selectlLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;

                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz");
            }
            if (location == null) {
                System.out.println("Oyundan çıktınız");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("Öldünüz. Game over");
                break;
            }
        }

    }
}
