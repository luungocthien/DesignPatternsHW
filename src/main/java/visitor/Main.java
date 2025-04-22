package visitor;

import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // Create file system structure
        Directory root = new Directory("root");
        File file1 = new File("document.txt", 1.2);
        File file2 = new File("image.png", 2.5);
        Directory subDir = new Directory("subfolder");
        File file3 = new File("notes.txt", 0.8);
        File file4 = new File("archive.zip", 5.0);

        root.add(file1);
        root.add(file2);
        root.add(subDir);
        subDir.add(file3);
        subDir.add(file4);

        // Visitor 1: Calculate total size
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.printf("Total size: %.2f MB%n", sizeVisitor.getTotalSize());

        // Visitor 2: Search for .txt files
        Predicate<File> txtCriterion = f -> f.getName().endsWith(".txt");
        SearchVisitor searchVisitor = new SearchVisitor(txtCriterion);
        root.accept(searchVisitor);
        List<File> txtFiles = searchVisitor.getFoundFiles();

        System.out.println("Found .txt files:");
        for (File f : txtFiles) {
            System.out.println(" - " + f.getName());
        }
    }
}
