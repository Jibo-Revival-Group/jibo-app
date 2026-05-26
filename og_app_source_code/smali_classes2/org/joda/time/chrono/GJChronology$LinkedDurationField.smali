.class Lorg/joda/time/chrono/GJChronology$LinkedDurationField;
.super Lorg/joda/time/field/DecoratedDurationField;
.source "GJChronology.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/joda/time/chrono/GJChronology;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "LinkedDurationField"
.end annotation


# instance fields
.field private final a:Lorg/joda/time/chrono/GJChronology$ImpreciseCutoverField;


# direct methods
.method constructor <init>(Lorg/joda/time/DurationField;Lorg/joda/time/chrono/GJChronology$ImpreciseCutoverField;)V
    .locals 1

    .prologue
    .line 1136
    invoke-virtual {p1}, Lorg/joda/time/DurationField;->a()Lorg/joda/time/DurationFieldType;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lorg/joda/time/field/DecoratedDurationField;-><init>(Lorg/joda/time/DurationField;Lorg/joda/time/DurationFieldType;)V

    .line 1137
    iput-object p2, p0, Lorg/joda/time/chrono/GJChronology$LinkedDurationField;->a:Lorg/joda/time/chrono/GJChronology$ImpreciseCutoverField;

    .line 1138
    return-void
.end method


# virtual methods
.method public a(JI)J
    .locals 3

    .prologue
    .line 1141
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$LinkedDurationField;->a:Lorg/joda/time/chrono/GJChronology$ImpreciseCutoverField;

    invoke-virtual {v0, p1, p2, p3}, Lorg/joda/time/chrono/GJChronology$ImpreciseCutoverField;->a(JI)J

    move-result-wide v0

    return-wide v0
.end method

.method public a(JJ)J
    .locals 3

    .prologue
    .line 1145
    iget-object v0, p0, Lorg/joda/time/chrono/GJChronology$LinkedDurationField;->a:Lorg/joda/time/chrono/GJChronology$ImpreciseCutoverField;

    invoke-virtual {v0, p1, p2, p3, p4}, Lorg/joda/time/chrono/GJChronology$ImpreciseCutoverField;->a(JJ)J

    move-result-wide v0

    return-wide v0
.end method
