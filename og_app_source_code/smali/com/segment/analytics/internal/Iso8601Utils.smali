.class final Lcom/segment/analytics/internal/Iso8601Utils;
.super Ljava/lang/Object;
.source "Iso8601Utils.java"


# static fields
.field static final GMT_ID:Ljava/lang/String; = "GMT"

.field static final TIMEZONE_Z:Ljava/util/TimeZone;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 44
    const-string v0, "GMT"

    invoke-static {v0}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v0

    sput-object v0, Lcom/segment/analytics/internal/Iso8601Utils;->TIMEZONE_Z:Ljava/util/TimeZone;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static checkOffset(Ljava/lang/String;IC)Z
    .locals 1

    .prologue
    .line 214
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-ge p1, v0, :cond_0

    invoke-virtual {p0, p1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    if-ne v0, p2, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static format(Ljava/util/Date;)Ljava/lang/String;
    .locals 6

    .prologue
    const/16 v5, 0x3a

    const/16 v4, 0x2d

    .line 48
    new-instance v0, Ljava/util/GregorianCalendar;

    sget-object v1, Lcom/segment/analytics/internal/Iso8601Utils;->TIMEZONE_Z:Ljava/util/TimeZone;

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v0, v1, v2}, Ljava/util/GregorianCalendar;-><init>(Ljava/util/TimeZone;Ljava/util/Locale;)V

    .line 49
    invoke-virtual {v0, p0}, Ljava/util/Calendar;->setTime(Ljava/util/Date;)V

    .line 52
    const-string v1, "yyyy-MM-ddThh:mm:ss.sssZ"

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    .line 53
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 54
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/Calendar;->get(I)I

    move-result v1

    const-string v3, "yyyy"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    invoke-static {v2, v1, v3}, Lcom/segment/analytics/internal/Iso8601Utils;->padInt(Ljava/lang/StringBuilder;II)V

    .line 55
    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 56
    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Ljava/util/Calendar;->get(I)I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    const-string v3, "MM"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    invoke-static {v2, v1, v3}, Lcom/segment/analytics/internal/Iso8601Utils;->padInt(Ljava/lang/StringBuilder;II)V

    .line 57
    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 58
    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Ljava/util/Calendar;->get(I)I

    move-result v1

    const-string v3, "dd"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    invoke-static {v2, v1, v3}, Lcom/segment/analytics/internal/Iso8601Utils;->padInt(Ljava/lang/StringBuilder;II)V

    .line 59
    const/16 v1, 0x54

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 60
    const/16 v1, 0xb

    invoke-virtual {v0, v1}, Ljava/util/Calendar;->get(I)I

    move-result v1

    const-string v3, "hh"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    invoke-static {v2, v1, v3}, Lcom/segment/analytics/internal/Iso8601Utils;->padInt(Ljava/lang/StringBuilder;II)V

    .line 61
    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 62
    const/16 v1, 0xc

    invoke-virtual {v0, v1}, Ljava/util/Calendar;->get(I)I

    move-result v1

    const-string v3, "mm"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    invoke-static {v2, v1, v3}, Lcom/segment/analytics/internal/Iso8601Utils;->padInt(Ljava/lang/StringBuilder;II)V

    .line 63
    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 64
    const/16 v1, 0xd

    invoke-virtual {v0, v1}, Ljava/util/Calendar;->get(I)I

    move-result v1

    const-string v3, "ss"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    invoke-static {v2, v1, v3}, Lcom/segment/analytics/internal/Iso8601Utils;->padInt(Ljava/lang/StringBuilder;II)V

    .line 65
    const/16 v1, 0x2e

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 66
    const/16 v1, 0xe

    invoke-virtual {v0, v1}, Ljava/util/Calendar;->get(I)I

    move-result v0

    const-string v1, "sss"

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    invoke-static {v2, v0, v1}, Lcom/segment/analytics/internal/Iso8601Utils;->padInt(Ljava/lang/StringBuilder;II)V

    .line 67
    const/16 v0, 0x5a

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 68
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static indexOfNonDigit(Ljava/lang/String;I)I
    .locals 2

    .prologue
    .line 272
    :goto_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-ge p1, v0, :cond_2

    .line 273
    invoke-virtual {p0, p1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 274
    const/16 v1, 0x30

    if-lt v0, v1, :cond_0

    const/16 v1, 0x39

    if-le v0, v1, :cond_1

    .line 278
    :cond_0
    :goto_1
    return p1

    .line 272
    :cond_1
    add-int/lit8 p1, p1, 0x1

    goto :goto_0

    .line 278
    :cond_2
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result p1

    goto :goto_1
.end method

.method private static padInt(Ljava/lang/StringBuilder;II)V
    .locals 3

    .prologue
    .line 261
    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    .line 262
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v0

    sub-int v0, p2, v0

    :goto_0
    if-lez v0, :cond_0

    .line 263
    const/16 v2, 0x30

    invoke-virtual {p0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 262
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 265
    :cond_0
    invoke-virtual {p0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 266
    return-void
.end method

.method public static parse(Ljava/lang/String;)Ljava/util/Date;
    .locals 15

    .prologue
    .line 80
    const/4 v1, 0x0

    .line 83
    const/4 v0, 0x4

    :try_start_0
    invoke-static {p0, v1, v0}, Lcom/segment/analytics/internal/Iso8601Utils;->parseInt(Ljava/lang/String;II)I

    move-result v6

    .line 84
    const/16 v1, 0x2d

    invoke-static {p0, v0, v1}, Lcom/segment/analytics/internal/Iso8601Utils;->checkOffset(Ljava/lang/String;IC)Z

    move-result v1

    if-eqz v1, :cond_e

    .line 85
    const/4 v0, 0x5

    move v1, v0

    .line 89
    :goto_0
    add-int/lit8 v0, v1, 0x2

    invoke-static {p0, v1, v0}, Lcom/segment/analytics/internal/Iso8601Utils;->parseInt(Ljava/lang/String;II)I

    move-result v7

    .line 90
    const/16 v1, 0x2d

    invoke-static {p0, v0, v1}, Lcom/segment/analytics/internal/Iso8601Utils;->checkOffset(Ljava/lang/String;IC)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 91
    add-int/lit8 v0, v0, 0x1

    .line 95
    :cond_0
    add-int/lit8 v4, v0, 0x2

    invoke-static {p0, v0, v4}, Lcom/segment/analytics/internal/Iso8601Utils;->parseInt(Ljava/lang/String;II)I

    move-result v8

    .line 97
    const/4 v3, 0x0

    .line 98
    const/4 v2, 0x0

    .line 99
    const/4 v1, 0x0

    .line 100
    const/4 v0, 0x0

    .line 104
    const/16 v5, 0x54

    invoke-static {p0, v4, v5}, Lcom/segment/analytics/internal/Iso8601Utils;->checkOffset(Ljava/lang/String;IC)Z

    move-result v5

    .line 106
    if-nez v5, :cond_1

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v9

    if-gt v9, v4, :cond_1

    .line 107
    new-instance v0, Ljava/util/GregorianCalendar;

    add-int/lit8 v1, v7, -0x1

    invoke-direct {v0, v6, v1, v8}, Ljava/util/GregorianCalendar;-><init>(III)V

    .line 109
    invoke-virtual {v0}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v0

    .line 197
    :goto_1
    return-object v0

    .line 112
    :cond_1
    if-eqz v5, :cond_c

    .line 115
    add-int/lit8 v3, v4, 0x1

    add-int/lit8 v2, v3, 0x2

    invoke-static {p0, v3, v2}, Lcom/segment/analytics/internal/Iso8601Utils;->parseInt(Ljava/lang/String;II)I

    move-result v3

    .line 116
    const/16 v4, 0x3a

    invoke-static {p0, v2, v4}, Lcom/segment/analytics/internal/Iso8601Utils;->checkOffset(Ljava/lang/String;IC)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 117
    add-int/lit8 v2, v2, 0x1

    .line 120
    :cond_2
    add-int/lit8 v5, v2, 0x2

    invoke-static {p0, v2, v5}, Lcom/segment/analytics/internal/Iso8601Utils;->parseInt(Ljava/lang/String;II)I

    move-result v2

    .line 121
    const/16 v4, 0x3a

    invoke-static {p0, v5, v4}, Lcom/segment/analytics/internal/Iso8601Utils;->checkOffset(Ljava/lang/String;IC)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 122
    add-int/lit8 v5, v5, 0x1

    .line 125
    :cond_3
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v4

    if-le v4, v5, :cond_d

    .line 126
    invoke-virtual {p0, v5}, Ljava/lang/String;->charAt(I)C

    move-result v4

    .line 127
    const/16 v9, 0x5a

    if-eq v4, v9, :cond_d

    const/16 v9, 0x2b

    if-eq v4, v9, :cond_d

    const/16 v9, 0x2d

    if-eq v4, v9, :cond_d

    .line 128
    add-int/lit8 v4, v5, 0x2

    invoke-static {p0, v5, v4}, Lcom/segment/analytics/internal/Iso8601Utils;->parseInt(Ljava/lang/String;II)I

    move-result v1

    .line 129
    const/16 v5, 0x3b

    if-le v1, v5, :cond_4

    const/16 v5, 0x3f

    if-ge v1, v5, :cond_4

    .line 130
    const/16 v1, 0x3b

    .line 133
    :cond_4
    const/16 v5, 0x2e

    invoke-static {p0, v4, v5}, Lcom/segment/analytics/internal/Iso8601Utils;->checkOffset(Ljava/lang/String;IC)Z

    move-result v5

    if-eqz v5, :cond_c

    .line 134
    add-int/lit8 v0, v4, 0x1

    .line 135
    add-int/lit8 v4, v0, 0x1

    invoke-static {p0, v4}, Lcom/segment/analytics/internal/Iso8601Utils;->indexOfNonDigit(Ljava/lang/String;I)I

    move-result v4

    .line 136
    add-int/lit8 v5, v0, 0x3

    invoke-static {v4, v5}, Ljava/lang/Math;->min(II)I

    move-result v5

    .line 137
    invoke-static {p0, v0, v5}, Lcom/segment/analytics/internal/Iso8601Utils;->parseInt(Ljava/lang/String;II)I

    move-result v9

    .line 138
    const-wide/high16 v10, 0x4024000000000000L    # 10.0

    sub-int v0, v5, v0

    rsub-int/lit8 v0, v0, 0x3

    int-to-double v12, v0

    invoke-static {v10, v11, v12, v13}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v10

    int-to-double v12, v9

    mul-double/2addr v10, v12

    double-to-int v0, v10

    move v14, v0

    move v0, v4

    move v4, v3

    move v3, v2

    move v2, v1

    move v1, v14

    .line 146
    :goto_2
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v5

    if-gt v5, v0, :cond_5

    .line 147
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "No time zone indicator"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_1

    .line 200
    :catch_0
    move-exception v0

    .line 201
    :goto_3
    new-instance v1, Ljava/lang/RuntimeException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Not an RFC 3339 date: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    .line 151
    :cond_5
    :try_start_1
    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result v5

    .line 153
    const/16 v9, 0x5a

    if-ne v5, v9, :cond_7

    .line 154
    sget-object v0, Lcom/segment/analytics/internal/Iso8601Utils;->TIMEZONE_Z:Ljava/util/TimeZone;

    .line 187
    :cond_6
    :goto_4
    new-instance v5, Ljava/util/GregorianCalendar;

    invoke-direct {v5, v0}, Ljava/util/GregorianCalendar;-><init>(Ljava/util/TimeZone;)V

    .line 188
    const/4 v0, 0x0

    invoke-virtual {v5, v0}, Ljava/util/Calendar;->setLenient(Z)V

    .line 189
    const/4 v0, 0x1

    invoke-virtual {v5, v0, v6}, Ljava/util/Calendar;->set(II)V

    .line 190
    const/4 v0, 0x2

    add-int/lit8 v6, v7, -0x1

    invoke-virtual {v5, v0, v6}, Ljava/util/Calendar;->set(II)V

    .line 191
    const/4 v0, 0x5

    invoke-virtual {v5, v0, v8}, Ljava/util/Calendar;->set(II)V

    .line 192
    const/16 v0, 0xb

    invoke-virtual {v5, v0, v4}, Ljava/util/Calendar;->set(II)V

    .line 193
    const/16 v0, 0xc

    invoke-virtual {v5, v0, v3}, Ljava/util/Calendar;->set(II)V

    .line 194
    const/16 v0, 0xd

    invoke-virtual {v5, v0, v2}, Ljava/util/Calendar;->set(II)V

    .line 195
    const/16 v0, 0xe

    invoke-virtual {v5, v0, v1}, Ljava/util/Calendar;->set(II)V

    .line 197
    invoke-virtual {v5}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v0

    goto/16 :goto_1

    .line 155
    :cond_7
    const/16 v9, 0x2b

    if-eq v5, v9, :cond_8

    const/16 v9, 0x2d

    if-ne v5, v9, :cond_b

    .line 156
    :cond_8
    invoke-virtual {p0, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    .line 158
    const-string v5, "+0000"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_9

    const-string v5, "+00:00"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_a

    .line 159
    :cond_9
    sget-object v0, Lcom/segment/analytics/internal/Iso8601Utils;->TIMEZONE_Z:Ljava/util/TimeZone;

    goto :goto_4

    .line 163
    :cond_a
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "GMT"

    invoke-virtual {v5, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 164
    invoke-static {v5}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v0

    .line 165
    invoke-virtual {v0}, Ljava/util/TimeZone;->getID()Ljava/lang/String;

    move-result-object v9

    .line 166
    invoke-virtual {v9, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_6

    .line 172
    const-string v10, ":"

    const-string v11, ""

    invoke-virtual {v9, v10, v11}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v9

    .line 173
    invoke-virtual {v9, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_6

    .line 174
    new-instance v1, Ljava/lang/IndexOutOfBoundsException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Mismatching time zone indicator: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " given, resolves to "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 178
    invoke-virtual {v0}, Ljava/util/TimeZone;->getID()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 200
    :catch_1
    move-exception v0

    goto/16 :goto_3

    .line 183
    :cond_b
    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid time zone indicator \'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_1
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_1

    :cond_c
    move v14, v0

    move v0, v4

    move v4, v3

    move v3, v2

    move v2, v1

    move v1, v14

    goto/16 :goto_2

    :cond_d
    move v4, v3

    move v3, v2

    move v2, v1

    move v1, v0

    move v0, v5

    goto/16 :goto_2

    :cond_e
    move v1, v0

    goto/16 :goto_0
.end method

.method private static parseInt(Ljava/lang/String;II)I
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/NumberFormatException;
        }
    .end annotation

    .prologue
    const/16 v3, 0xa

    .line 228
    if-ltz p1, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-gt p2, v0, :cond_0

    if-le p1, p2, :cond_1

    .line 229
    :cond_0
    new-instance v0, Ljava/lang/NumberFormatException;

    invoke-direct {v0, p0}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 233
    :cond_1
    const/4 v0, 0x0

    .line 235
    if-ge p1, p2, :cond_5

    .line 236
    add-int/lit8 v1, p1, 0x1

    invoke-virtual {p0, p1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    invoke-static {v0, v3}, Ljava/lang/Character;->digit(CI)I

    move-result v0

    .line 237
    if-gez v0, :cond_2

    .line 238
    new-instance v0, Ljava/lang/NumberFormatException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid number: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0, p1, p2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 240
    :cond_2
    neg-int v0, v0

    .line 242
    :goto_0
    if-ge v1, p2, :cond_4

    .line 243
    add-int/lit8 v2, v1, 0x1

    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v1

    invoke-static {v1, v3}, Ljava/lang/Character;->digit(CI)I

    move-result v1

    .line 244
    if-gez v1, :cond_3

    .line 245
    new-instance v0, Ljava/lang/NumberFormatException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid number: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0, p1, p2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 247
    :cond_3
    mul-int/lit8 v0, v0, 0xa

    .line 248
    sub-int/2addr v0, v1

    move v1, v2

    goto :goto_0

    .line 250
    :cond_4
    neg-int v0, v0

    return v0

    :cond_5
    move v1, p1

    goto :goto_0
.end method
