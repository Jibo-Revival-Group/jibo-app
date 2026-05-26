.class abstract Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$EventTypeEvent;
.super Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent;
.source "LoggingEvent.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x408
    name = "EventTypeEvent"
.end annotation


# instance fields
.field final mEventType:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "eventType"
    .end annotation
.end field


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 47
    invoke-direct {p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent;-><init>(Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;)V

    .line 48
    iput-object p3, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$EventTypeEvent;->mEventType:Ljava/lang/String;

    .line 49
    return-void
.end method
