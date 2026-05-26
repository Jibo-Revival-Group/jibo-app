.class Lorg/joda/time/chrono/LimitChronology$LimitDurationField;
.super Lorg/joda/time/field/DecoratedDurationField;
.source "LimitChronology.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/joda/time/chrono/LimitChronology;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "LimitDurationField"
.end annotation


# instance fields
.field final synthetic a:Lorg/joda/time/chrono/LimitChronology;


# direct methods
.method constructor <init>(Lorg/joda/time/chrono/LimitChronology;Lorg/joda/time/DurationField;)V
    .locals 1

    .prologue
    .line 389
    iput-object p1, p0, Lorg/joda/time/chrono/LimitChronology$LimitDurationField;->a:Lorg/joda/time/chrono/LimitChronology;

    .line 390
    invoke-virtual {p2}, Lorg/joda/time/DurationField;->a()Lorg/joda/time/DurationFieldType;

    move-result-object v0

    invoke-direct {p0, p2, v0}, Lorg/joda/time/field/DecoratedDurationField;-><init>(Lorg/joda/time/DurationField;Lorg/joda/time/DurationFieldType;)V

    .line 391
    return-void
.end method


# virtual methods
.method public a(JI)J
    .locals 5

    .prologue
    .line 414
    iget-object v0, p0, Lorg/joda/time/chrono/LimitChronology$LimitDurationField;->a:Lorg/joda/time/chrono/LimitChronology;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, p2, v1}, Lorg/joda/time/chrono/LimitChronology;->a(JLjava/lang/String;)V

    .line 415
    invoke-virtual {p0}, Lorg/joda/time/chrono/LimitChronology$LimitDurationField;->f()Lorg/joda/time/DurationField;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Lorg/joda/time/DurationField;->a(JI)J

    move-result-wide v0

    .line 416
    iget-object v2, p0, Lorg/joda/time/chrono/LimitChronology$LimitDurationField;->a:Lorg/joda/time/chrono/LimitChronology;

    const-string v3, "resulting"

    invoke-virtual {v2, v0, v1, v3}, Lorg/joda/time/chrono/LimitChronology;->a(JLjava/lang/String;)V

    .line 417
    return-wide v0
.end method

.method public a(JJ)J
    .locals 5

    .prologue
    .line 421
    iget-object v0, p0, Lorg/joda/time/chrono/LimitChronology$LimitDurationField;->a:Lorg/joda/time/chrono/LimitChronology;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, p2, v1}, Lorg/joda/time/chrono/LimitChronology;->a(JLjava/lang/String;)V

    .line 422
    invoke-virtual {p0}, Lorg/joda/time/chrono/LimitChronology$LimitDurationField;->f()Lorg/joda/time/DurationField;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3, p4}, Lorg/joda/time/DurationField;->a(JJ)J

    move-result-wide v0

    .line 423
    iget-object v2, p0, Lorg/joda/time/chrono/LimitChronology$LimitDurationField;->a:Lorg/joda/time/chrono/LimitChronology;

    const-string v3, "resulting"

    invoke-virtual {v2, v0, v1, v3}, Lorg/joda/time/chrono/LimitChronology;->a(JLjava/lang/String;)V

    .line 424
    return-wide v0
.end method
