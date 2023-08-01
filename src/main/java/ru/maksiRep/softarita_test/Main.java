package ru.maksiRep.softarita_test;

import ru.maksiRep.softarita_test.notification.Notification;
import ru.maksiRep.softarita_test.notification.TestValues;

public class Main {

    public static void main(String[] args) {
        TestValues testValues = new TestValues();
        Notification notification = new Notification(testValues.getName(),
                                                     testValues.getYesterdayTable(),
                                                     testValues.getTodayTable());
        String result = notification.getNotification();
        System.out.println(result);
    }
}
