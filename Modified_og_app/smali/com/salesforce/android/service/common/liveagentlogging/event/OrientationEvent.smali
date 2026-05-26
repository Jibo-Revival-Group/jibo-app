.class public Lcom/salesforce/android/service/common/liveagentlogging/event/OrientationEvent;
.super Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;
.source "OrientationEvent.java"


# annotations
.annotation runtime Lcom/salesforce/android/service/common/liveagentlogging/BatchedEvent;
    a = "orientationEvents"
.end annotation


# instance fields
.field private final mOrientation:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "orientation"
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/android/service/common/utilities/spatial/Orientation;)V
    .locals 1

    .prologue
    .line 52
    invoke-direct {p0, p1, p2}, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 54
    invoke-virtual {p3}, Lcom/salesforce/android/service/common/utilities/spatial/Orientation;->b()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 55
    const-string v0, "LANDSCAPE_LEFT"

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/event/OrientationEvent;->mOrientation:Ljava/lang/String;

    .line 61
    :goto_0
    return-void

    .line 56
    :cond_0
    invoke-virtual {p3}, Lcom/salesforce/android/service/common/utilities/spatial/Orientation;->a()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 57
    const-string v0, "PORTRAIT"

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/event/OrientationEvent;->mOrientation:Ljava/lang/String;

    goto :goto_0

    .line 59
    :cond_1
    const-string v0, "UNDEFINED"

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/event/OrientationEvent;->mOrientation:Ljava/lang/String;

    goto :goto_0
.end method
