package decorator;

public class Main {
    public static void main(String[] args) {

        // Basic printer
        Printer printer = new BasicPrinter();
        printer.print("Hello World!");

        System.out.println(); // Separator

        // Encrypted printer (ROT13)
        Printer printer2 = new EncryptedPrinter(new BasicPrinter());
        printer2.print("Hello World!");

        System.out.println(); // Separator

        // XML and Encrypted printer (ROT13)
        Printer printer3 = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
        printer3.print("Hello World!");

        System.out.println(); // Separator

        // XML printer
        Printer printer4 = new XMLPrinter(new BasicPrinter());
        printer4.print("Hello World!");
    }
}


