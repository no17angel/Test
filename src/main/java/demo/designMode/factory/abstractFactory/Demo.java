package demo.designMode.factory.abstractFactory;

public class Demo {
	public static void main(String[] args) {
		ComputerEngineer ce = new ComputerEngineer();
		
		IntelFactory intel = new IntelFactory();
		ce.makeComputer(intel);
		
		AmdFactory amd = new AmdFactory();
		ce.makeComputer(amd);
	}
}
