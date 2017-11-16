package code;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * MD5工具类
 * com.wl.common
 *                       
 * @Filename Utils.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author wanglian
 *
 * @Email wanglian.us@gmail.com
 *       
 * @History
 *<li>Author: WangLian</li>
 *<li>Date: 2015-4-14下午12:04:06</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class Utils {
	
	public static final String DATE_FORMAT = "^201\\d-((0[1-9])|(1[0-2]))-((0[1-9])|([12]\\d)|(3[0-1]))";
	public static final SimpleDateFormat SDF_XLS = new SimpleDateFormat("_yyyy_MM_dd_HH_mm_ss_ms");
	public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 获取现在时间
	 * 
	 * @return 现在时间
	 */
	public static Timestamp getNowTime() {
		return getNowTime("yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获取现在时间
	 * 
	 * @return 现在时间
	 */
	public static Timestamp nowTime() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * 获取现在时间
	 * 
	 * @return 现在时间 格式 2011-10-01 12:12:12
	 */
	public static String getTime() {
		return getTime("yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获取现在时间
	 * 
	 * @return 现在时间
	 */
	public static String getTime(String dataFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dataFormat); // 设置时间格式
		return sdf.format(new Date());
	}

	/**
	 * 获取现在时间
	 * 
	 * @param dataFormat
	 *            时间格式
	 * @return 现在时间
	 */
	public static Timestamp getNowTime(String dataFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dataFormat); // 设置时间格式
		Date date = new Date(); // 获取当前时间
		return Timestamp.valueOf(sdf.format(date));
	}

	/**
	 * 替换字符串中的特殊符号
	 * 
	 * @param str
	 *            要处理的字符串
	 * @return 处理后的字符串
	 */
	public static String changeStr(String str) {
		if (str != null) {
			return str.replaceAll("\"", "\\\"").replaceAll("'", "\\\'");
		} else {
			return str;
		}
	}
	
	public static final Timestamp getNow(){
		return new Timestamp(System.currentTimeMillis());
	}
	public static final Timestamp getTime(long l){
		return new Timestamp(System.currentTimeMillis()+l);
	}
	
	/**
	 * Encodes a string
	 * 
	 * @param str
	 *            String to encode
	 * @return Encoded String
	 * @throws NoSuchAlgorithmException
	 */
	public static String crypt(String str, String sale) {
		return crypt(str+"{"+sale+"}");
	}
	public static String crypt(String str) {
		if (str == null || str.length() == 0) {
			throw new IllegalArgumentException(
					"String to encript cannot be null or zero length");
		}

		StringBuffer hexString = new StringBuffer();

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] hash = md.digest();

			for (int i = 0; i < hash.length; i++) {
				if ((0xff & hash[i]) < 0x10) {
					hexString.append("0"
							+ Integer.toHexString((0xFF & hash[i])));
				} else {
					hexString.append(Integer.toHexString(0xFF & hash[i]));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return hexString.toString();
	}
	
	//将字符串转为十六进制
	public static String toHexString(String s) {
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			int ch = (int) s.charAt(i);
			String s4 = Integer.toHexString(ch);
			str = str + s4;
		}
		return str;
	}
	
	// 转化十六进制编码为字符串
	public static String toStringHex(String s) {
		byte[] baKeyword = new byte[s.length() / 2];
		for (int i = 0; i < baKeyword.length; i++) {
			try {
				baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			s = new String(baKeyword, "utf-8");// UTF-16le:Not
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return s;
	}
	
	public static String getRandomStr(Object str) {
		StringBuilder builder = new StringBuilder();
		builder.append(Math.round(20000)).append(System.currentTimeMillis());
		if (str != null) {
			builder.append(str);
		}
		return crypt(builder.toString());
	}

	public static String getSolidStr(String str, int id) {
		return crypt(str + id);
	}

	public static String getSolidStr(int id) {
		return getSolidStr("bbsll_", id);
	}
	
	public static int getStringHashCode(String txt) {
		int t = 0;
		if (txt != null) {
			char[] chars = txt.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				t = t + (int) chars[i];
			}
		}
		return t;
	}
	
}
