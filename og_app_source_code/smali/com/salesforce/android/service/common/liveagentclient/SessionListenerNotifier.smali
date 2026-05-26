.class public Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;
.super Ljava/lang/Object;
.source "SessionListenerNotifier.java"

# interfaces
.implements Lcom/salesforce/android/service/common/liveagentclient/MessagesListener;
.implements Lcom/salesforce/android/service/common/liveagentclient/SessionListener;


# instance fields
.field a:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/service/common/liveagentclient/SessionListener;",
            ">;"
        }
    .end annotation
.end field

.field b:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/service/common/liveagentclient/MessagesListener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->newSetFromMap(Ljava/util/Map;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;->a:Ljava/util/Set;

    .line 47
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->newSetFromMap(Ljava/util/Map;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;->b:Ljava/util/Set;

    .line 54
    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/liveagentclient/SessionListener;)Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;->a:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 90
    return-object p0
.end method

.method public a(Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;)V
    .locals 2

    .prologue
    .line 61
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;->a:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/liveagentclient/SessionListener;

    .line 62
    invoke-interface {v0, p1}, Lcom/salesforce/android/service/common/liveagentclient/SessionListener;->a(Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;)V

    goto :goto_0

    .line 64
    :cond_0
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;)V
    .locals 2

    .prologue
    .line 67
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;->a:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/liveagentclient/SessionListener;

    .line 68
    invoke-interface {v0, p1, p2}, Lcom/salesforce/android/service/common/liveagentclient/SessionListener;->a(Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;)V

    goto :goto_0

    .line 70
    :cond_0
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/liveagentclient/response/MessagesResponse;)V
    .locals 2

    .prologue
    .line 79
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;->b:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/liveagentclient/MessagesListener;

    .line 80
    invoke-interface {v0, p1}, Lcom/salesforce/android/service/common/liveagentclient/MessagesListener;->a(Lcom/salesforce/android/service/common/liveagentclient/response/MessagesResponse;)V

    goto :goto_0

    .line 82
    :cond_0
    return-void
.end method

.method public a(Ljava/lang/Throwable;)V
    .locals 2

    .prologue
    .line 73
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;->a:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/liveagentclient/SessionListener;

    .line 74
    invoke-interface {v0, p1}, Lcom/salesforce/android/service/common/liveagentclient/SessionListener;->a(Ljava/lang/Throwable;)V

    goto :goto_0

    .line 76
    :cond_0
    return-void
.end method

.method public b(Lcom/salesforce/android/service/common/liveagentclient/SessionListener;)Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentclient/SessionListenerNotifier;->a:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 95
    return-object p0
.end method
