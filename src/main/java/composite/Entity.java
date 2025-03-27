package composite;

public abstract class Entity {
    protected String name;
    public Entity(String name){
        this.name = name;
    }

    public abstract void getInfo();

    public abstract void add(Entity entity);

    public abstract void remove(Entity entity);

    public abstract String toXML();
}
