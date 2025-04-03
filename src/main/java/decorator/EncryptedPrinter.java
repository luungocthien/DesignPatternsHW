package decorator;

public class EncryptedPrinter extends PrinterDecorator{
    public EncryptedPrinter(Printer printer) {
        super(printer);
    }
    @Override
    public void print(String message) {
        String encryptedMessage = encryptROT13(message);
        super.print(encryptedMessage);
    }

    private String encryptROT13(String message) {
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                result.append((char) ((c - 'a' + 13) % 26 + 'a'));
            } else if (c >= 'A' && c <= 'Z') {
                result.append((char) ((c - 'A' + 13) % 26 + 'A'));
            } else {
                result.append(c); // Keep non-alphabet characters unchanged
            }
        }
        return result.toString();
    }
}
