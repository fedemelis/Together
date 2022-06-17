import base.Event.Event;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class test {

    public static void main(String[] args) {
        Date d = new Date();
        Meeting e = new Meeting("Prova", "ddo", "dd", "ddd", d, "d");
        System.out.println(e);
        List<Event> l = new ArrayList<>();
        l.add(e);
        System.out.println(l);
    }
}
