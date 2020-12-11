package net.htlgkr.feinboeck18.hue11;

import java.time.LocalDateTime;

public class BetweenDatesHue {
    public static void main(String[] args) {
        BetweenDatesHue getBetween = new BetweenDatesHue();
        int[] between = getBetween.getTimeBetween(LocalDateTime.now(), LocalDateTime.now().plusYears(1).plusDays(25).plusMonths(16));
    }

    private int[] getTimeBetween(LocalDateTime localDateTime, LocalDateTime otherLocalDateTime) {

    }
}