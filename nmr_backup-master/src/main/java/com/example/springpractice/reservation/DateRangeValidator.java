package com.example.springpractice.reservation;

import java.util.Date;

public class DateRangeValidator {

    private final Date startDate;
    private final Date endDate;

    public DateRangeValidator(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean isWithinRange(Date testDate) {

        // exclusive startDate and endDate
        //return testDate.isBefore(endDate) && testDate.isAfter(startDate);

        // inclusive startDate and endDate
        return (testDate.equals(startDate) || testDate.equals(endDate))
                || (testDate.equals(endDate) && testDate.equals(startDate));


    }

}