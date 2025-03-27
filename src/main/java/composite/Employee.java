package composite;

public class Employee extends Entity{
    protected float salary;
    public Employee(String name, float salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public void getInfo() {
        System.out.println("   Employee name: " + this.name);
        System.out.println("   Employee salary: " + this.salary);
    }

    @Override
    public void add(Entity entity) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public void remove(Entity entity) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public String toXML() {
        return "<Employee name=\"" + this.name + "\" salary=\"" + this.salary + "\" />";
    }
}
