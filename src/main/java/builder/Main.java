package builder;

public class Main {
    public static void main(String[] args) {
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector gamingDirector = new ComputerDirector(gamingBuilder);
        gamingDirector.constructComputer();
        Computer gamingPC = gamingDirector.getComputer();
        System.out.println("Gaming PC: \n" + gamingPC);

        System.out.println();

        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        ComputerDirector officeDirector = new ComputerDirector(officeBuilder);
        officeDirector.constructComputer();
        Computer officePC = officeDirector.getComputer();
        System.out.println("Office PC: \n" + officePC);
    }
}

