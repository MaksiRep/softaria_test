package ru.maksiRep.softarita_test.notification;

import java.util.ArrayList;
import java.util.Map;

public class Notification {

    public Notification() {
    }

    public Notification(String name,
                        Map<String, String> yesterdayTable,
                        Map<String, String> todayTable) {
        this.name = name;
        this.todayTable = todayTable;
        this.yesterdayTable = yesterdayTable;
    }

    private Map<String, String> yesterdayTable;

    private Map<String, String> todayTable;

    private String name;

    public String getNotification() {

        ArrayList<String> newUrls = findNewUrls();
        ArrayList<String> updatedUrls = findUpdatedUrls();
        ArrayList<String> deletedUrls = findDeletedUrls();

        StringBuilder result = new StringBuilder();
        result.append("Здравствуйте, дорогая ").append(name)
                .append("\n\nЗа последние сутки во вверенных Вам сайтах произошли следующие изменения:\n\n")
                .append("Исчезли следующие страницы: ").append(concatStrings(deletedUrls)).append("\n")
                .append("Появились следующие новые страницы: ").append(concatStrings(newUrls)).append("\n")
                .append("Изменились следующие страницы: ").append(concatStrings(updatedUrls)).append("\n")
                .append("\nС уважением,\nавтоматизированная система \nмониторинга.");

        return result.toString();
    }


    private ArrayList<String> findNewUrls() {
        ArrayList<String> newUrls = new ArrayList<>();
        if (yesterdayTable.isEmpty()) {
            for (var url : todayTable.entrySet()) {
                newUrls.add(url.getKey());
            }
        } else {
            for (var url : todayTable.entrySet()) {
                if (!yesterdayTable.containsKey(url.getKey()))
                    newUrls.add(url.getKey());
            }
        }
        return newUrls;
    }

    private ArrayList<String> findDeletedUrls() {
        ArrayList<String> deletedUrls = new ArrayList<>();
        if (todayTable.isEmpty()) {
            for (var url : yesterdayTable.entrySet()) {
                deletedUrls.add(url.getKey());
            }
        } else {
            for (var url : yesterdayTable.entrySet()) {
                if (!todayTable.containsKey(url.getKey()))
                    deletedUrls.add(url.getKey());
            }
        }
        return deletedUrls;
    }

    private ArrayList<String> findUpdatedUrls() {
        ArrayList<String> updatedUrls = new ArrayList<>();
        for (var url : todayTable.entrySet()) {
            if (yesterdayTable.containsKey(url.getKey()) && !yesterdayTable.get(url.getKey()).equals(url.getValue())) {
                updatedUrls.add(url.getKey());
            }
        }
        return updatedUrls;
    }

    private String concatStrings(ArrayList<String> stringArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : stringArray) {
            stringBuilder.append(string).append("; ");
        }
        return stringBuilder.toString();
    }
}
