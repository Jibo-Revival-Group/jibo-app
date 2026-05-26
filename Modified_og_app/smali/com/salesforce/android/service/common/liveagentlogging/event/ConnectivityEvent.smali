.class public Lcom/salesforce/android/service/common/liveagentlogging/event/ConnectivityEvent;
.super Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;
.source "ConnectivityEvent.java"


# annotations
.annotation runtime Lcom/salesforce/android/service/common/liveagentlogging/BatchedEvent;
    a = "connectivityEvents"
.end annotation


# instance fields
.field private final mRadioType:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "radioType"
    .end annotation
.end field

.field private final mTechnology:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "technology"
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 94
    invoke-direct {p0, p1, p2}, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 95
    iput-object p3, p0, Lcom/salesforce/android/service/common/liveagentlogging/event/ConnectivityEvent;->mTechnology:Ljava/lang/String;

    .line 96
    iput-object p4, p0, Lcom/salesforce/android/service/common/liveagentlogging/event/ConnectivityEvent;->mRadioType:Ljava/lang/String;

    .line 97
    return-void
.end method
