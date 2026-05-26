.class Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest$Factory;
.super Ljava/lang/Object;
.source "EnqueuedRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Factory"
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 107
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method a(Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;Ljava/lang/Class;)Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;",
            "Ljava/lang/Class",
            "<TT;>;)",
            "Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 109
    new-instance v0, Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;

    invoke-direct {v0, p1, p2}, Lcom/salesforce/android/service/common/liveagentclient/integrity/EnqueuedRequest;-><init>(Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;Ljava/lang/Class;)V

    return-object v0
.end method
