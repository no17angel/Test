package demo.designMode.factory.abstractFactory;

public class Demo {
	public static void main(String[] args) {
		ComputerEngineer ce = new ComputerEngineer();
		
		AbstractFactory intel = new IntelFactory();
		ce.makeComputer(intel);
		
		AbstractFactory amd = new AmdFactory();
		ce.makeComputer(amd);
	}
}
