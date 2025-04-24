package builder;

public class OfficeComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("Intel i5-12400");
    }

    @Override
    public void buildRAM() {
        computer.setRamSizeGB(16);
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("512GB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("Integrated Intel UHD Graphics");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 10 Pro");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}

