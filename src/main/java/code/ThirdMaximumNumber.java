package code;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by AXT on 2017/10/27.
 */
public class ThirdMaximumNumber {

    /**
     * @since 123
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 职业百科分类
         * id 生成
         * 顺序为用户自定义
         */
        String crypt = Utils.crypt(UUID.randomUUID().toString().replaceAll("-", ""));
        System.out.println(crypt + "---" + crypt.length());
        System.out.println(crypt.substring(8, 24));


    }
}
