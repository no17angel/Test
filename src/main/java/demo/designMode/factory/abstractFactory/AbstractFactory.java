package demo.designMode.factory.abstractFactory;

public abstract class AbstractFactory {
	/**
	 * 创建CPU对象
	 * 
	 * @return CPU对象
	 */
	public abstract Cpu createCpu();

	/**
	 * 创建主板对象
	 * 
	 * @return 主板对象
	 */
	public abstract Mainboard createMainboard();
}
