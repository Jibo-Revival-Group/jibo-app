package org.joda.time;

import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes2.dex */
public class IllegalFieldValueException extends IllegalArgumentException {

    /* JADX INFO: renamed from: a */
    private final DateTimeFieldType f15773a;

    /* JADX INFO: renamed from: b */
    private final DurationFieldType f15774b;

    /* JADX INFO: renamed from: c */
    private final String f15775c;

    /* JADX INFO: renamed from: d */
    private final Number f15776d;

    /* JADX INFO: renamed from: e */
    private final String f15777e;

    /* JADX INFO: renamed from: f */
    private final Number f15778f;

    /* JADX INFO: renamed from: g */
    private final Number f15779g;

    /* JADX INFO: renamed from: h */
    private String f15780h;

    /* JADX INFO: renamed from: a */
    private static String m16575a(String str, Number number, Number number2, Number number3, String str2) {
        StringBuilder sbAppend = new StringBuilder().append("Value ").append(number).append(" for ").append(str).append(TokenParser.f15715SP);
        if (number2 == null) {
            if (number3 == null) {
                sbAppend.append("is not supported");
            } else {
                sbAppend.append("must not be larger than ").append(number3);
            }
        } else if (number3 == null) {
            sbAppend.append("must not be smaller than ").append(number2);
        } else {
            sbAppend.append("must be in the range [").append(number2).append(',').append(number3).append(']');
        }
        if (str2 != null) {
            sbAppend.append(": ").append(str2);
        }
        return sbAppend.toString();
    }

    /* JADX INFO: renamed from: a */
    private static String m16576a(String str, String str2) {
        StringBuffer stringBufferAppend = new StringBuffer().append("Value ");
        if (str2 == null) {
            stringBufferAppend.append("null");
        } else {
            stringBufferAppend.append(TokenParser.DQUOTE);
            stringBufferAppend.append(str2);
            stringBufferAppend.append(TokenParser.DQUOTE);
        }
        stringBufferAppend.append(" for ").append(str).append(TokenParser.f15715SP).append("is not supported");
        return stringBufferAppend.toString();
    }

    public IllegalFieldValueException(DateTimeFieldType dateTimeFieldType, Number number, Number number2, Number number3) {
        super(m16575a(dateTimeFieldType.m16510x(), number, number2, number3, null));
        this.f15773a = dateTimeFieldType;
        this.f15774b = null;
        this.f15775c = dateTimeFieldType.m16510x();
        this.f15776d = number;
        this.f15777e = null;
        this.f15778f = number2;
        this.f15779g = number3;
        this.f15780h = super.getMessage();
    }

    public IllegalFieldValueException(DateTimeFieldType dateTimeFieldType, Number number, String str) {
        super(m16575a(dateTimeFieldType.m16510x(), number, null, null, str));
        this.f15773a = dateTimeFieldType;
        this.f15774b = null;
        this.f15775c = dateTimeFieldType.m16510x();
        this.f15776d = number;
        this.f15777e = null;
        this.f15778f = null;
        this.f15779g = null;
        this.f15780h = super.getMessage();
    }

    public IllegalFieldValueException(DateTimeFieldType dateTimeFieldType, String str) {
        super(m16576a(dateTimeFieldType.m16510x(), str));
        this.f15773a = dateTimeFieldType;
        this.f15774b = null;
        this.f15775c = dateTimeFieldType.m16510x();
        this.f15777e = str;
        this.f15776d = null;
        this.f15778f = null;
        this.f15779g = null;
        this.f15780h = super.getMessage();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f15780h;
    }

    /* JADX INFO: renamed from: a */
    public void m16577a(String str) {
        if (this.f15780h == null) {
            this.f15780h = str;
        } else if (str != null) {
            this.f15780h = str + ": " + this.f15780h;
        }
    }
}
