package visitor;

public class File implements FileSystemElement {
    private String name;
    private double size;

    public File(String name, double size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public double getSize() {
        return size;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return String.format("File[name=%s, size=%.2f MB]", name, size);
    }
}
