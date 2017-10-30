package demo.designMode.factory.simpleFactory;

public class Demo {
	public static void main(String[] args) {
		String loginType = "password";
        String name = "name";
        String password = "password";
		Login login = LoginManager.factory(loginType);
		boolean result = login.verify(name, password);
		if(result){
			// 逻辑
		}else{
			// 逻辑
		}
	}
}
