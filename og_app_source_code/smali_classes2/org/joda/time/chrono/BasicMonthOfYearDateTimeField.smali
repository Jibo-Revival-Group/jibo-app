.class Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;
.super Lorg/joda/time/field/ImpreciseDateTimeField;
.source "BasicMonthOfYearDateTimeField.java"


# instance fields
.field private final a:Lorg/joda/time/chrono/BasicChronology;

.field private final c:I

.field private final d:I


# direct methods
.method constructor <init>(Lorg/joda/time/chrono/BasicChronology;I)V
    .locals 4

    .prologue
    .line 52
    invoke-static {}, Lorg/joda/time/DateTimeFieldType;->r()Lorg/joda/time/DateTimeFieldType;

    move-result-object v0

    invoke-virtual {p1}, Lorg/joda/time/chrono/BasicChronology;->V()J

    move-result-wide v2

    invoke-direct {p0, v0, v2, v3}, Lorg/joda/time/field/ImpreciseDateTimeField;-><init>(Lorg/joda/time/DateTimeFieldType;J)V

    .line 53
    iput-object p1, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    .line 54
    iget-object v0, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    invoke-virtual {v0}, Lorg/joda/time/chrono/BasicChronology;->S()I

    move-result v0

    iput v0, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->c:I

    .line 55
    iput p2, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->d:I

    .line 56
    return-void
.end method


# virtual methods
.method public a(J)I
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    invoke-virtual {v0, p1, p2}, Lorg/joda/time/chrono/BasicChronology;->b(J)I

    move-result v0

    return v0
.end method

.method public a(JI)J
    .locals 9

    .prologue
    .line 93
    if-nez p3, :cond_0

    .line 157
    :goto_0
    return-wide p1

    .line 99
    :cond_0
    iget-object v0, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    invoke-virtual {v0, p1, p2}, Lorg/joda/time/chrono/BasicChronology;->h(J)I

    move-result v0

    int-to-long v4, v0

    .line 104
    iget-object v0, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    invoke-virtual {v0, p1, p2}, Lorg/joda/time/chrono/BasicChronology;->a(J)I

    move-result v2

    .line 105
    iget-object v0, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    invoke-virtual {v0, p1, p2, v2}, Lorg/joda/time/chrono/BasicChronology;->a(JI)I

    move-result v3

    .line 113
    add-int/lit8 v0, v3, -0x1

    add-int/2addr v0, p3

    .line 114
    if-lez v3, :cond_6

    if-gez v0, :cond_6

    .line 115
    iget v0, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->c:I

    add-int/2addr v0, p3

    int-to-float v0, v0

    invoke-static {v0}, Ljava/lang/Math;->signum(F)F

    move-result v0

    int-to-float v1, p3

    invoke-static {v1}, Ljava/lang/Math;->signum(F)F

    move-result v1

    cmpl-float v0, v0, v1

    if-nez v0, :cond_2

    .line 116
    add-int/lit8 v0, v2, -0x1

    .line 117
    iget v1, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->c:I

    add-int/2addr v1, p3

    .line 122
    :goto_1
    add-int/lit8 v6, v3, -0x1

    add-int/2addr v1, v6

    move v7, v1

    move v1, v0

    move v0, v7

    .line 124
    :goto_2
    if-ltz v0, :cond_3

    .line 125
    iget v6, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->c:I

    div-int v6, v0, v6

    add-int/2addr v1, v6

    .line 126
    iget v6, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->c:I

    rem-int/2addr v0, v6

    add-int/lit8 v0, v0, 0x1

    .line 147
    :cond_1
    :goto_3
    iget-object v6, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    invoke-virtual {v6, p1, p2, v2, v3}, Lorg/joda/time/chrono/BasicChronology;->a(JII)I

    move-result v3

    .line 148
    iget-object v2, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    invoke-virtual {v2, v1, v0}, Lorg/joda/time/chrono/BasicChronology;->b(II)I

    move-result v2

    .line 149
    if-le v3, v2, :cond_5

    .line 155
    :goto_4
    iget-object v3, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    invoke-virtual {v3, v1, v0, v2}, Lorg/joda/time/chrono/BasicChronology;->a(III)J

    move-result-wide v0

    .line 157
    add-long p1, v0, v4

    goto :goto_0

    .line 119
    :cond_2
    add-int/lit8 v0, v2, 0x1

    .line 120
    iget v1, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->c:I

    sub-int v1, p3, v1

    goto :goto_1

    .line 128
    :cond_3
    iget v6, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->c:I

    div-int v6, v0, v6

    add-int/2addr v1, v6

    add-int/lit8 v1, v1, -0x1

    .line 129
    invoke-static {v0}, Ljava/lang/Math;->abs(I)I

    move-result v0

    .line 130
    iget v6, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->c:I

    rem-int/2addr v0, v6

    .line 132
    if-nez v0, :cond_4

    .line 133
    iget v0, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->c:I

    .line 135
    :cond_4
    iget v6, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->c:I

    sub-int v0, v6, v0

    add-int/lit8 v0, v0, 0x1

    .line 137
    const/4 v6, 0x1

    if-ne v0, v6, :cond_1

    .line 138
    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    :cond_5
    move v2, v3

    goto :goto_4

    :cond_6
    move v1, v2

    goto :goto_2
.end method

.method public a(JJ)J
    .locals 11

    .prologue
    .line 162
    long-to-int v0, p3

    .line 163
    int-to-long v2, v0

    cmp-long v1, v2, p3

    if-nez v1, :cond_0

    .line 164
    invoke-virtual {p0, p1, p2, v0}, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a(JI)J

    move-result-wide v0

    .line 210
    :goto_0
    return-wide v0

    .line 169
    :cond_0
    iget-object v0, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    invoke-virtual {v0, p1, p2}, Lorg/joda/time/chrono/BasicChronology;->h(J)I

    move-result v0

    int-to-long v6, v0

    .line 171
    iget-object v0, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    invoke-virtual {v0, p1, p2}, Lorg/joda/time/chrono/BasicChronology;->a(J)I

    move-result v8

    .line 172
    iget-object v0, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    invoke-virtual {v0, p1, p2, v8}, Lorg/joda/time/chrono/BasicChronology;->a(JI)I

    move-result v9

    .line 175
    add-int/lit8 v0, v9, -0x1

    int-to-long v0, v0

    add-long v4, v0, p3

    .line 176
    const-wide/16 v0, 0x0

    cmp-long v0, v4, v0

    if-ltz v0, :cond_2

    .line 177
    int-to-long v0, v8

    iget v2, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->c:I

    int-to-long v2, v2

    div-long v2, v4, v2

    add-long/2addr v0, v2

    .line 178
    iget v2, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->c:I

    int-to-long v2, v2

    rem-long v2, v4, v2

    const-wide/16 v4, 0x1

    add-long/2addr v2, v4

    .line 192
    :goto_1
    iget-object v4, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    invoke-virtual {v4}, Lorg/joda/time/chrono/BasicChronology;->Q()I

    move-result v4

    int-to-long v4, v4

    cmp-long v4, v0, v4

    if-ltz v4, :cond_1

    iget-object v4, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    invoke-virtual {v4}, Lorg/joda/time/chrono/BasicChronology;->R()I

    move-result v4

    int-to-long v4, v4

    cmp-long v4, v0, v4

    if-lez v4, :cond_4

    .line 195
    :cond_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Magnitude of add amount is too large: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3, p4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 180
    :cond_2
    int-to-long v0, v8

    iget v2, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->c:I

    int-to-long v2, v2

    div-long v2, v4, v2

    add-long/2addr v0, v2

    const-wide/16 v2, 0x1

    sub-long v2, v0, v2

    .line 181
    invoke-static {v4, v5}, Ljava/lang/Math;->abs(J)J

    move-result-wide v0

    .line 182
    iget v4, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->c:I

    int-to-long v4, v4

    rem-long/2addr v0, v4

    long-to-int v0, v0

    .line 183
    if-nez v0, :cond_3

    .line 184
    iget v0, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->c:I

    .line 186
    :cond_3
    iget v1, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->c:I

    sub-int v0, v1, v0

    add-int/lit8 v0, v0, 0x1

    int-to-long v4, v0

    .line 187
    const-wide/16 v0, 0x1

    cmp-long v0, v4, v0

    if-nez v0, :cond_6

    .line 188
    const-wide/16 v0, 0x1

    add-long/2addr v0, v2

    move-wide v2, v4

    goto :goto_1

    .line 199
    :cond_4
    long-to-int v4, v0

    .line 200
    long-to-int v2, v2

    .line 202
    iget-object v0, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    invoke-virtual {v0, p1, p2, v8, v9}, Lorg/joda/time/chrono/BasicChronology;->a(JII)I

    move-result v1

    .line 203
    iget-object v0, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    invoke-virtual {v0, v4, v2}, Lorg/joda/time/chrono/BasicChronology;->b(II)I

    move-result v0

    .line 204
    if-le v1, v0, :cond_5

    .line 208
    :goto_2
    iget-object v1, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    invoke-virtual {v1, v4, v2, v0}, Lorg/joda/time/chrono/BasicChronology;->a(III)J

    move-result-wide v0

    .line 210
    add-long/2addr v0, v6

    goto/16 :goto_0

    :cond_5
    move v0, v1

    goto :goto_2

    :cond_6
    move-wide v0, v2

    move-wide v2, v4

    goto :goto_1
.end method

.method public b(JI)J
    .locals 5

    .prologue
    .line 309
    const/4 v0, 0x1

    iget v1, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->c:I

    invoke-static {p0, p3, v0, v1}, Lorg/joda/time/field/FieldUtils;->a(Lorg/joda/time/DateTimeField;III)V

    .line 311
    iget-object v0, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    invoke-virtual {v0, p1, p2}, Lorg/joda/time/chrono/BasicChronology;->a(J)I

    move-result v2

    .line 313
    iget-object v0, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    invoke-virtual {v0, p1, p2, v2}, Lorg/joda/time/chrono/BasicChronology;->b(JI)I

    move-result v1

    .line 314
    iget-object v0, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    invoke-virtual {v0, v2, p3}, Lorg/joda/time/chrono/BasicChronology;->b(II)I

    move-result v0

    .line 315
    if-le v1, v0, :cond_0

    .line 320
    :goto_0
    iget-object v1, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    invoke-virtual {v1, v2, p3, v0}, Lorg/joda/time/chrono/BasicChronology;->a(III)J

    move-result-wide v0

    iget-object v2, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    invoke-virtual {v2, p1, p2}, Lorg/joda/time/chrono/BasicChronology;->h(J)I

    move-result v2

    int-to-long v2, v2

    add-long/2addr v0, v2

    return-wide v0

    :cond_0
    move v0, v1

    goto :goto_0
.end method

.method public b(J)Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 331
    iget-object v1, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    invoke-virtual {v1, p1, p2}, Lorg/joda/time/chrono/BasicChronology;->a(J)I

    move-result v1

    .line 332
    iget-object v2, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    invoke-virtual {v2, v1}, Lorg/joda/time/chrono/BasicChronology;->e(I)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 333
    iget-object v2, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    invoke-virtual {v2, p1, p2, v1}, Lorg/joda/time/chrono/BasicChronology;->a(JI)I

    move-result v1

    iget v2, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->d:I

    if-ne v1, v2, :cond_0

    const/4 v0, 0x1

    .line 335
    :cond_0
    return v0
.end method

.method public d(J)J
    .locals 3

    .prologue
    .line 360
    iget-object v0, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    invoke-virtual {v0, p1, p2}, Lorg/joda/time/chrono/BasicChronology;->a(J)I

    move-result v0

    .line 361
    iget-object v1, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    invoke-virtual {v1, p1, p2, v0}, Lorg/joda/time/chrono/BasicChronology;->a(JI)I

    move-result v1

    .line 362
    iget-object v2, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    invoke-virtual {v2, v0, v1}, Lorg/joda/time/chrono/BasicChronology;->a(II)J

    move-result-wide v0

    return-wide v0
.end method

.method public e()Lorg/joda/time/DurationField;
    .locals 1

    .prologue
    .line 326
    iget-object v0, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    invoke-virtual {v0}, Lorg/joda/time/chrono/BasicChronology;->D()Lorg/joda/time/DurationField;

    move-result-object v0

    return-object v0
.end method

.method public f()Lorg/joda/time/DurationField;
    .locals 1

    .prologue
    .line 345
    iget-object v0, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->a:Lorg/joda/time/chrono/BasicChronology;

    invoke-virtual {v0}, Lorg/joda/time/chrono/BasicChronology;->s()Lorg/joda/time/DurationField;

    move-result-object v0

    return-object v0
.end method

.method public g()I
    .locals 1

    .prologue
    .line 350
    const/4 v0, 0x1

    return v0
.end method

.method public h()I
    .locals 1

    .prologue
    .line 355
    iget v0, p0, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->c:I

    return v0
.end method

.method public i(J)J
    .locals 3

    .prologue
    .line 367
    invoke-virtual {p0, p1, p2}, Lorg/joda/time/chrono/BasicMonthOfYearDateTimeField;->d(J)J

    move-result-wide v0

    sub-long v0, p1, v0

    return-wide v0
.end method
