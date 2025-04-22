package visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchVisitor implements FileSystemVisitor {
    private Predicate<File> criterion;
    private List<File> foundFiles;

    public SearchVisitor(Predicate<File> criterion) {
        this.criterion = criterion;
        this.foundFiles = new ArrayList<>();
    }

    @Override
    public void visit(File file) {
        if (criterion.test(file)) {
            foundFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement elem : directory.getChildren()) {
            elem.accept(this);
        }
    }

    public List<File> getFoundFiles() {
        return foundFiles;
    }
}
