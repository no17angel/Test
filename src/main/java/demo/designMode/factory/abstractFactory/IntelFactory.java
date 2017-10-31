package demo.designMode.factory.abstractFactory;

public class IntelFactory extends AbstractFactory {

	@Override
	public Cpu createCpu() {
		return new IntelCpu(775);
	}

	@Override
	public Mainboard createMainboard() {
		return new IntelMainboard(775);
	}

}
