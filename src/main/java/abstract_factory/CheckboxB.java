package abstract_factory;

public class CheckboxB extends Checkbox{
    public CheckboxB(String text) {super(text);}
    @Override
    public void display() {
        System.out.printf("( ) %s", text);
    }
}