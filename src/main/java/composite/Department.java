package composite;

import java.util.ArrayList;
import java.util.List;

public class Department extends Entity{
    private List<Entity> children = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public void getInfo() {
        System.out.println("Department: " + this.name);
        System.out.println("----------------------------------------");
        System.out.println(this.name + " consists of: ");
        for (Entity child: this.children) {
            child.getInfo();
        }
        System.out.println("----------------------------------------");
    }

    @Override
    public void add(Entity entity) {
        this.children.add(entity);
    }

    @Override
    public void remove(Entity entity) {
        this.children.remove(entity);
    }

    public float totalSalary() {
        float total = 0;
        for (Entity child : this.children) {
            if (child instanceof Employee) {
                total += ((Employee) child).salary;
            } else if (child instanceof Department) {
                total += ((Department) child).totalSalary();
            }
        }
        return total;
    }

    @Override
    public String toXML() {
        StringBuilder xml = new StringBuilder();
        xml.append("<Department name=\"").append(this.name).append("\">");
        for (Entity child : this.children) {
            xml.append(child.toXML());
        }
        xml.append("</Department>");
        return xml.toString();
    }
}
