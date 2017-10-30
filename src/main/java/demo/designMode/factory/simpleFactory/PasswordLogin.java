package demo.designMode.factory.simpleFactory;

/**
 * 
* @Title: 密码认证
* @Description: 密码认证
* @author lei.wang
* @date 2017年10月30日 下午1:16:05 
* @version v1.0
 */
public class PasswordLogin implements Login {

	@Override
	public boolean verify(String name, String password) {
		return false;
	}

}
