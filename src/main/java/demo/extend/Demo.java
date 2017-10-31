package demo.extend;

/**
 * 继承与类的加载顺序
* @ClassName:  Demo
* @Description: 静态优先级最高，其次是。。。最后是构造函数。
* @author lei.wang
* @date 2017年10月31日 下午3:33:19 
* @version v1.0
 */
public class Demo {
	public static void main(String[] args) {
		new Child();
	}
}
