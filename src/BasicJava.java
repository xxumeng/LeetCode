import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;

public class BasicJava {
    public static void main(String[] args) {
       /* break跳出多重循环*/
        here:
        for (int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                System.out.println(i+j);
                break here;
            }
        }

        /*string不同编码*/
        String str = null;
        try {
//            String.getBytes(String decode)方法会根据指定的decode编码返回某字符串在该编码下的byte数组表示
//            new String(byte[], decode)的方式来还原这个“深”字时，这个new String(byte[], decode)实际是使用decode指定的编码来将byte[]解析成字符串
            str = new String("hello".getBytes("ISO-8859-1"), "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(str);

        Integer a;
        int b;


    }
}
