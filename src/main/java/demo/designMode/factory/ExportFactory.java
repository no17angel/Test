package demo.designMode.factory;

/**
 * 抽象工厂
 * 
 * @ClassName: ExportFactory
 * @Description: 抽象工厂
 * @author lei.wang
 * @date 2017年10月30日 下午2:26:25
 * @version v1.0
 */
public interface ExportFactory {
	public ExportFile factory(String type);
}
