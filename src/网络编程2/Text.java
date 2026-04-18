package 网络编程2;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Text {
    static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy年MM月dd日 HH:mm:ss EEE a");
        String time = sdf.format(date);
        System.out.println(time);
        //-------------------------新旧时间------------------------
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss EEE a");
        String time1 = dtf.format(now);
        System.out.println(time1);
    }
}
