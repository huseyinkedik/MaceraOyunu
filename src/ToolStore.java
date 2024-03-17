public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya hoşgeldiniz");

        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1- Silahlar");
            System.out.println("2- Zırhlar");
            System.out.println("3- Çıkış yap");
            System.out.println("Seçiminiz: ");
            int selectCase = Location.input.nextInt();

            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Geçersiz değer, tekrar giriniz: ");
                selectCase = input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Bir daha bekleriz");
                    showMenu = false;
                    break;
            }

        }
        return true;
    }

    public void printWeapon() {
        System.out.println("Silahlar");
        System.out.println();
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + " - " + w.getName() + "Para :" + w.getPrice() + " , Hasar :" + w.getDamage());
        }
        System.out.println("0 - Çıkış yap");

    }

    public void buyWeapon() {
        System.out.print("Silah seçiniz: ");
        int selectWeaponId = input.nextInt();
        while (selectWeaponId < 0 || selectWeaponId > Weapon.weapons().length) {
            System.out.println("Geçersiz değer, tekrar giriniz: ");
            selectWeaponId = input.nextInt();
        }
        if (selectWeaponId != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjId(selectWeaponId);

            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır");
                } else {
                    System.out.println(selectedWeapon.getName() + "silahını satın aldınız");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                    System.out.println("Önceki silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Şimdiki silahınız: " + this.getPlayer().getInventory().getWeapon().getName());

                }

            }
        }


    }

    public void printArmor() {
        System.out.println("Zırhlar");
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + "-" + a.getName() +
                    " Zırh: " + a.getBlock() +
                    " fiyat: " + a.getPrice());
        }
        System.out.println("0 - Çıkış yap");
    }

    public void buyArmor() {
        System.out.print("Zırh seçiniz: ");
        int selectArmorId = input.nextInt();
        while (selectArmorId < 1 || selectArmorId > Armor.armors().length) {
            System.out.println("Geçersiz değer, tekrar giriniz: ");
            selectArmorId = input.nextInt();
        }
        if (selectArmorId != 0) {
            Armor selectedArmor = Armor.getArmorObjId(selectArmorId);

            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır");

                } else {
                    System.out.println(selectedArmor.getName() + "silahını satın aldınız");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                    System.out.println("Önceki zırhınız: " + this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Şimdiki zırhınız: " + this.getPlayer().getInventory().getArmor().getName());

                }
            }
        }
    }


}
