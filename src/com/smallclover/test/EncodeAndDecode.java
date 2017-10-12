package com.smallclover.test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * 常见编码错误代码实际运行测试解析
 * @author smallclover
 * @create 2017-10-12
 * @since
 */
public class EncodeAndDecode {
    private static final String ISO_8859_1 = "ISO-8859-1";
    public static void main(String[] args) {
        EncodeAndDecode.ISO88591_Test();
    }

    /**
     * 测试ISO-8859-1
     */
    public static void ISO88591_Test(){
        //char[] chars = {'淘','！','我','喜','欢','！'};
        String str = "淘！我喜欢！";
        Charset charset = Charset.forName("ISO-8859-1");
        ByteBuffer byteBuffer = charset.encode(str);
        CharBuffer charBuffer = charset.decode(byteBuffer);
        print(byteBuffer,charBuffer,str,ISO_8859_1);
    }

    private static void print(ByteBuffer byteBuffer, CharBuffer charBuffer, String str, String charset){
        System.out.println("字符串["+str+"]");
        System.out.println("解码字符集：" + charset);
        System.out.println("解码结果：");
        System.out.println("十进制表示：");
        for (Byte b: byteBuffer.array()) {
            System.out.print(b + " ");
        }
        System.out.println();
        System.out.println("十六进制表示：");
        for (Byte b : byteBuffer.array()) {
            System.out.print(Integer.toHexString(b.intValue()) + " ");
        }
        System.out.println();
        System.out.println("编码字符集：" + charset);
        System.out.println("编码结果：" + charBuffer);
    }


}
