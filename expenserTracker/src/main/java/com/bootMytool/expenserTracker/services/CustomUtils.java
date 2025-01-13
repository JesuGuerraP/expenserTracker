package com.bootMytool.expenserTracker.services;

import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class CustomUtils {
    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

    public String formatDate(Date date) {
        if (date == null) {
            return "";
        }
        return dateFormatter.format(date);
    }


}