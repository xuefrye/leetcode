package cn.xuefei.剑指offer;

/**
 * @author: xuefei
 * @date: 2020-09-01
 * @version: 1.0
 * @description: TODO
 */
public class JZ2替换空格 {
    public class Solution {
        public String replaceSpace(StringBuffer str) {
            int spaceCount = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ')
                    spaceCount++;
            }

            char[] chars = new char[str.length() + spaceCount * 2];

            int i = 0;
            int j = 0;
            for (; i < str.length(); i++) {
                if(str.charAt(i) != ' '){
                    chars[j++] = str.charAt(i);
                }else{
                    chars[j++] = '%';
                    chars[j++] = '2';
                    chars[j++] = '0';
                }
            }

            return new String(chars);
        }
    }
}
