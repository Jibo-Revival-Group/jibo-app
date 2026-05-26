.class public Lcom/salesforce/android/service/common/liveagentlogging/event/DeviceEvent;
.super Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;
.source "DeviceEvent.java"


# annotations
.annotation runtime Lcom/salesforce/android/service/common/liveagentlogging/BatchedEvent;
    a = "deviceEvents"
.end annotation


# instance fields
.field private final mApplication:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "application"
    .end annotation
.end field

.field private final mApplicationVersion:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "applicationVersion"
    .end annotation
.end field

.field private final mDevice:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "device"
    .end annotation
.end field

.field private final mOsVersion:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "os"
    .end annotation
.end field

.field private final mSdkVersion:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "sdk"
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 53
    invoke-direct {p0, p1, p2}, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 54
    iput-object p4, p0, Lcom/salesforce/android/service/common/liveagentlogging/event/DeviceEvent;->mDevice:Ljava/lang/String;

    .line 55
    iput-object p3, p0, Lcom/salesforce/android/service/common/liveagentlogging/event/DeviceEvent;->mSdkVersion:Ljava/lang/String;

    .line 56
    iput-object p5, p0, Lcom/salesforce/android/service/common/liveagentlogging/event/DeviceEvent;->mApplication:Ljava/lang/String;

    .line 57
    iput-object p6, p0, Lcom/salesforce/android/service/common/liveagentlogging/event/DeviceEvent;->mApplicationVersion:Ljava/lang/String;

    .line 58
    iput-object p7, p0, Lcom/salesforce/android/service/common/liveagentlogging/event/DeviceEvent;->mOsVersion:Ljava/lang/String;

    .line 59
    return-void
.end method
