.class public abstract Lorg/joda/time/field/ImpreciseDateTimeField;
.super Lorg/joda/time/field/BaseDateTimeField;
.source "ImpreciseDateTimeField.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/joda/time/field/ImpreciseDateTimeField$LinkedDurationField;
    }
.end annotation


# instance fields
.field private final a:Lorg/joda/time/DurationField;

.field final b:J


# direct methods
.method public constructor <init>(Lorg/joda/time/DateTimeFieldType;J)V
    .locals 2

    .prologue
    .line 56
    invoke-direct {p0, p1}, Lorg/joda/time/field/BaseDateTimeField;-><init>(Lorg/joda/time/DateTimeFieldType;)V

    .line 57
    iput-wide p2, p0, Lorg/joda/time/field/ImpreciseDateTimeField;->b:J

    .line 58
    new-instance v0, Lorg/joda/time/field/ImpreciseDateTimeField$LinkedDurationField;

    invoke-virtual {p1}, Lorg/joda/time/DateTimeFieldType;->y()Lorg/joda/time/DurationFieldType;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lorg/joda/time/field/ImpreciseDateTimeField$LinkedDurationField;-><init>(Lorg/joda/time/field/ImpreciseDateTimeField;Lorg/joda/time/DurationFieldType;)V

    iput-object v0, p0, Lorg/joda/time/field/ImpreciseDateTimeField;->a:Lorg/joda/time/DurationField;

    .line 59
    return-void
.end method


# virtual methods
.method public abstract a(JI)J
.end method

.method public abstract a(JJ)J
.end method

.method public final d()Lorg/joda/time/DurationField;
    .locals 1

    .prologue
    .line 138
    iget-object v0, p0, Lorg/joda/time/field/ImpreciseDateTimeField;->a:Lorg/joda/time/DurationField;

    return-object v0
.end method
