package abstract_factory;

public abstract class Elements {
    protected String text;
    public Elements(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    abstract void display();
}
