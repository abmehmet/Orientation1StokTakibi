import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Main {
    public enum Choices {
        EXIT(0), ADDBOOK(1), ADDCUSTOMER(2), SELLBOOK(3), RENTBOOK(4), SALECANCEL(5), REFUNDBOOK(6), START(7);
        private int value;

        Choices(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        DataBaseOperations dataBaseOperations = new DataBaseOperations(dataBase);
        Store rentaBookStore = new Store();
        Cashier cashier = new Cashier("Mehmet E.", "Akcan", "551 010 6464", "237V+6F Ümraniye, İstanbul");

        cashier.setDataBaseOperations(dataBaseOperations);
        rentaBookStore.workCashier(cashier);
        printMenu(cashier);
    }

    public static void printMenu(Cashier cashier) {
        Scanner readScreen = new Scanner(System.in);
        Choices choice = Choices.START;
        System.out.println(" # RentaBook - KİTAP KİRALAMA UYGULAMASI # ");

        while (choice != Choices.valueOf("EXIT")) {

            //clearScreen();
            System.out.println("\n");
            System.out.println("1.) Kitap Ekle ");
            System.out.println("2.) Müşteri Ekle ");
            System.out.println("3.) Kitap Satışı ");
            System.out.println("4.) Kitap Kirala ");
            System.out.println("5.) Satış İşlemi İptali ");
            System.out.println("6.) Kitap Geri Al ");
            System.out.println("0.) Çıkış\n");
            System.out.print(" Seçiminiz --> ");

            choice = Choices.values()[readScreen.nextInt()];
            if (choice != Choices.EXIT) {
                cashier.work(choice.ordinal());
            }
        }

        System.out.println("İyi Günler Dileriz. ");
    }

    public static void clearScreen() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_NUM_LOCK);
            robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_NUM_LOCK);
            Thread.sleep(10);

        } catch (AWTException ex) {
            ex.printStackTrace(System.err);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
