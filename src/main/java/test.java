import base.Eventi;
import base.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

    public static void main(String[] args) {
        Date d = new Date();
        Eventi e = new Eventi("ev", "Me", "yup", "yo", d);
        System.out.println(e);
    }
}
