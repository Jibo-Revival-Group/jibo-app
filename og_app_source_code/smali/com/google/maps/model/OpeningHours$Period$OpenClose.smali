.class public Lcom/google/maps/model/OpeningHours$Period$OpenClose;
.super Ljava/lang/Object;
.source "OpeningHours.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/maps/model/OpeningHours$Period;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "OpenClose"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/maps/model/OpeningHours$Period$OpenClose$DayOfWeek;
    }
.end annotation


# instance fields
.field public day:Lcom/google/maps/model/OpeningHours$Period$OpenClose$DayOfWeek;

.field public time:Lorg/joda/time/LocalTime;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
