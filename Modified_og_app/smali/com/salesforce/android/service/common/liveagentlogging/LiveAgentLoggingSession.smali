.class public interface abstract Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;
.super Ljava/lang/Object;
.source "LiveAgentLoggingSession.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession$Listener;
    }
.end annotation


# virtual methods
.method public abstract a(Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession$Listener;)Lcom/salesforce/android/service/common/liveagentlogging/LiveAgentLoggingSession;
.end method

.method public abstract a()Lcom/salesforce/android/service/common/utilities/control/Async;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/service/common/liveagentlogging/internal/response/BatchedEventsResponse;",
            ">;"
        }
    .end annotation
.end method

.method public abstract a(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V
.end method

.method public abstract a(Ljava/util/Collection;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<+",
            "Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;",
            ">;)V"
        }
    .end annotation
.end method
