package demo.designMode.factory.abstractFactory;

/**
 * 抽象工厂模式
* @ClassName:  Demo
* @Description: 工程师装机
* @author lei.wang
* @date 2017年10月31日 下午5:49:22 
* @version v1.0
 */
public class Demo {
	public static void main(String[] args) {
		ComputerEngineer ce = new ComputerEngineer();
		
		AbstractFactory intel = new IntelFactory();
		ce.makeComputer(intel);
		
		AbstractFactory amd = new AmdFactory();
		ce.makeComputer(amd);
	}
}
