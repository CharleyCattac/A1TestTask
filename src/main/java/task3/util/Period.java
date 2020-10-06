package task3.util;

public enum Period {
    DAY(1000L * 60 * 60 * 24),
    MONTH(1000L * 60 * 60 * 24 * 30),
    QUARTER(1000L * 60 * 60 * 24 * 30 * 3),
    YEAR(1000L * 60 * 60 * 24 * 30 * 3 * 4);

    public final long millisInPeriod;

    Period(long value) {
        this.millisInPeriod = value;
    }
}
