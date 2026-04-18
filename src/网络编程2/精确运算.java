package 网络编程2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class 精确运算 {
    static void main(String[] args) {
        BigDecimal a = BigDecimal.valueOf(0.1);
        BigDecimal b = BigDecimal.valueOf(0.3);
        BigDecimal c = a.divide(b,3 , RoundingMode.HALF_DOWN);
        BigInteger bigInteger = c.toBigInteger();
        System.out.println(1);
        System.out.println(c);


    }
}
