.class public Lcom/salesforce/android/service/common/liveagentlogging/event/BackgroundedEvent;
.super Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;
.source "BackgroundedEvent.java"


# annotations
.annotation runtime Lcom/salesforce/android/service/common/liveagentlogging/BatchedEvent;
    a = "backgroundedEvents"
.end annotation


# instance fields
.field private final mBackgrounded:Z
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "backgrounded"
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 47
    invoke-direct {p0, p1, p2}, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 48
    iput-boolean p3, p0, Lcom/salesforce/android/service/common/liveagentlogging/event/BackgroundedEvent;->mBackgrounded:Z

    .line 49
    return-void
.end method
