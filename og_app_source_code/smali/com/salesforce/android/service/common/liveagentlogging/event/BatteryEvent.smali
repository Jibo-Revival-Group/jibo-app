.class public Lcom/salesforce/android/service/common/liveagentlogging/event/BatteryEvent;
.super Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;
.source "BatteryEvent.java"


# annotations
.annotation runtime Lcom/salesforce/android/service/common/liveagentlogging/BatchedEvent;
    a = "batteryEvents"
.end annotation


# instance fields
.field private final mLevel:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "level"
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 2

    .prologue
    const/16 v0, 0x64

    .line 47
    invoke-direct {p0, p1, p2}, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 49
    if-gez p3, :cond_1

    .line 50
    const/4 v1, 0x0

    .line 53
    :goto_0
    if-le v1, v0, :cond_0

    .line 57
    :goto_1
    iput v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/event/BatteryEvent;->mLevel:I

    .line 58
    return-void

    :cond_0
    move v0, v1

    goto :goto_1

    :cond_1
    move v1, p3

    goto :goto_0
.end method
