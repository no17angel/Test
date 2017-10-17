package demo.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @Title: SHA
 * @Description: SHA算法
 * @author lei.wang
 * @date 2017年10月12日 下午2:17:57
 * @version v1.0
 */
public class SHAUtil {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String passwordToHash = "password";
		String salt = getSalt();

		String securePassword = getSecurePassword(passwordToHash, salt, "SHA-1");
		System.out.println(securePassword);

		securePassword = getSecurePassword(passwordToHash, salt, "SHA-256");
		System.out.println(securePassword);

		securePassword = getSecurePassword(passwordToHash, salt, "SHA-384");
		System.out.println(securePassword);

		securePassword = getSecurePassword(passwordToHash, salt, "SHA-512");
		System.out.println(securePassword);
	}

	private static String getSecurePassword(String passwordToHash, String salt, String shaType) {
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance(shaType);
			md.update(salt.getBytes());
			byte[] bytes = md.digest(passwordToHash.getBytes());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}

	// Add salt
	private static String getSalt() throws NoSuchAlgorithmException {
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		byte[] saltbyte = new byte[16];
		sr.nextBytes(saltbyte);
		return saltbyte.toString();
	}
}