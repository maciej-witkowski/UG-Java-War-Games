package main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

abstract class Report {
    private final String id = UUID.randomUUID().toString();
    private final Date date = new Date();
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public String authorId() {
        return "No author";
    }

    public String ready() {
        return "(" + this.id + "), " + format.format(this.date);
    }
}
