package abstract_factory;

public class main {
    public static void main(String[] args) {
        UIFactory factory = new BFactory();
        Button button = factory.createButton("Click Me");
        TextField textField = factory.createTextField("Enter Text");
        Checkbox checkbox = factory.createCheckbox("Check Me");

        button.display();
        textField.display();
        checkbox.display();
    }
}
