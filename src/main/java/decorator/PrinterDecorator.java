package decorator;

public class PrinterDecorator implements Printer{
    // Reference to the printer being decorated
    private Printer printer;

    public PrinterDecorator(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(String message) {
        printer.print(message);
    }
}
