package ru.maksiRep.softarita_test.notification;

import java.util.HashMap;
import java.util.Map;

public class TestValues {

    private Map<String, String> yesterdayTable;

    private Map<String, String> todayTable;

    private String name;

     {
        yesterdayTable = new HashMap<>();
        todayTable = new HashMap<>();
        name = "Ирина Сергеевна";

        yesterdayTable.put("google.com", "123");
        yesterdayTable.put("yandex.ru", "123");
        yesterdayTable.put("github.com", "123");
        yesterdayTable.put("vk.com", "222");

        todayTable.put("yandex.ru", "222");
        todayTable.put("github.com", "222");
        todayTable.put("vk.com", "222");
        todayTable.put("someurl.com", "222");
        todayTable.put("moreurl.com", "222");
    }

    public Map<String, String> getYesterdayTable() {
        return yesterdayTable;
    }

    public void setYesterdayTable(Map<String, String> yesterdayTable) {
        this.yesterdayTable = yesterdayTable;
    }

    public Map<String, String> getTodayTable() {
        return todayTable;
    }

    public void setTodayTable(Map<String, String> todayTable) {
        this.todayTable = todayTable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
