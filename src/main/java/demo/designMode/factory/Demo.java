package demo.designMode.factory;

public class Demo {
	public static void main(String[] args) {
		String data = "";
		ExportFactory exportFactory = new ExportHtmlFactory();
		ExportFile ef = exportFactory.factory("financial");
		ef.export(data);
	}
}
