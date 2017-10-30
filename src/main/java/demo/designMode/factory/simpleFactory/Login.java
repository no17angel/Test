package demo.designMode.factory.simpleFactory;

/**
* @Title: 简单工厂模式
* @Description: 简单工厂模式
* 假如应用系统需要支持多种登录方式如：口令认证、域认证（口令认证通常是去数据库中验证用户，而域认证则是需要到微软的域中验证用户）。
* 那么自然的做法就是建立一个各种登录方式都适用的接口
* @author lei.wang
* @date 2017年10月30日 下午12:22:00 
* @version v1.0
 */
public interface Login {
	
	public boolean verify(String name, String password);
}
