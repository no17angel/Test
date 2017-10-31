package demo.designMode.factory.abstractFactory;

public class AmdFactory extends AbstractFactory {

	@Override
	public Cpu createCpu() {
		return new AmdCpu(938);
	}

	@Override
	public Mainboard createMainboard() {
		return new AmdMainboard(938);
	}

}
