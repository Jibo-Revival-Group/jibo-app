.class public Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;
.super Ljava/lang/Object;
.source "PodConnectionManager.java"

# interfaces
.implements Lcom/salesforce/android/service/common/liveagentclient/SessionListener;
.implements Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Listener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;,
        Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Listener;
    }
.end annotation


# static fields
.field private static final a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field private final b:Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;

.field private final c:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;

.field private final d:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;

.field private final e:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;

.field private final f:Lcom/google/gson/GsonBuilder;

.field private g:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Listener;",
            ">;"
        }
    .end annotation
.end field

.field private h:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;

.field private i:Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;

.field private j:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 66
    const-class v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method protected constructor <init>(Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;)V
    .locals 1

    .prologue
    .line 102
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 93
    new-instance v0, Landroid/support/v4/util/ArraySet;

    invoke-direct {v0}, Landroid/support/v4/util/ArraySet;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->g:Ljava/util/Set;

    .line 103
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;->c:Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->b:Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;

    .line 104
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;->d:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->c:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;

    .line 105
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;->e:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->d:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;

    .line 106
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;->f:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;->a(Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Listener;)Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;->a()Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->e:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;

    .line 107
    iget-object v0, p1, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Builder;->g:Lcom/google/gson/GsonBuilder;

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->f:Lcom/google/gson/GsonBuilder;

    .line 108
    invoke-direct {p0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->d()V

    .line 109
    return-void
.end method

.method private a(Ljava/lang/String;)Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .prologue
    .line 169
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->c:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;

    .line 170
    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;->a(Ljava/lang/String;)Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->f:Lcom/google/gson/GsonBuilder;

    .line 171
    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;->a(Lcom/google/gson/GsonBuilder;)Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;

    move-result-object v0

    .line 172
    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient$Builder;->a()Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;

    move-result-object v0

    .line 174
    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->d:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->a(Lcom/salesforce/android/service/common/liveagentclient/LiveAgentClient;)Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession$Builder;->a()Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->h:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;

    .line 175
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->h:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->a(Lcom/salesforce/android/service/common/liveagentclient/SessionListener;)Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;

    .line 176
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->h:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->a()V

    .line 177
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->h:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;

    return-object v0
.end method

.method private a(Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;)V
    .locals 2

    .prologue
    .line 224
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->g:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Listener;

    .line 225
    invoke-interface {v0, p1, p2}, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Listener;->a(Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;)V

    goto :goto_0

    .line 227
    :cond_0
    return-void
.end method

.method private d()V
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 144
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->e:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->a()Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    move-result-object v0

    sget-object v1, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;->CONNECTED:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    if-eq v0, v1, :cond_0

    .line 145
    sget-object v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Unable to connect to a LiveAgent Logging pod because the network is not connected. Waiting for network to be restored..."

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->c(Ljava/lang/String;)V

    .line 166
    :goto_0
    return-void

    .line 151
    :cond_0
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->b:Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;->a()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->j:Ljava/lang/String;

    .line 152
    sget-object v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Attempting to create a LiveAgent Logging session on pod {}"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->j:Ljava/lang/String;

    aput-object v4, v2, v3

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->c(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 153
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->j:Ljava/lang/String;

    invoke-direct {p0, v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->a(Ljava/lang/String;)Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->h:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;
    :try_end_0
    .catch Lcom/salesforce/android/service/common/liveagentlogging/internal/AllPodsUnavailableException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/security/GeneralSecurityException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 154
    :catch_0
    move-exception v0

    .line 155
    sget-object v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Unable to connect to any LiveAgent pod for Logging. Logging has failed."

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->e(Ljava/lang/String;)V

    .line 156
    invoke-direct {p0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->e()V

    goto :goto_0

    .line 157
    :catch_1
    move-exception v0

    .line 158
    sget-object v1, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Unable to connect to the LiveAgent pod {} for Logging. Trying another pod.\n{}"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->j:Ljava/lang/String;

    aput-object v4, v3, v5

    invoke-virtual {v0}, Ljava/security/GeneralSecurityException;->getMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v3, v6

    invoke-interface {v1, v2, v3}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 161
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->b:Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;

    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->j:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;->a(Ljava/lang/String;)V

    .line 164
    invoke-direct {p0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->d()V

    goto :goto_0
.end method

.method private e()V
    .locals 2

    .prologue
    .line 230
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->g:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Listener;

    .line 231
    invoke-interface {v0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Listener;->d()V

    goto :goto_0

    .line 233
    :cond_0
    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Listener;)Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;
    .locals 1

    .prologue
    .line 130
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->g:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 131
    return-object p0
.end method

.method public a(Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;)V
    .locals 2

    .prologue
    .line 185
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->i:Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;

    .line 186
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->h:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;

    iget-object v1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->i:Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;

    invoke-direct {p0, v0, v1}, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->a(Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;)V

    .line 187
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;)V
    .locals 1

    .prologue
    .line 190
    sget-object v0, Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;->Ended:Lcom/salesforce/android/service/common/liveagentclient/lifecycle/LiveAgentState;

    if-ne p1, v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->h:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;

    if-eqz v0, :cond_0

    .line 191
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->h:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->b(Lcom/salesforce/android/service/common/liveagentclient/SessionListener;)Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;

    .line 193
    :cond_0
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;)V
    .locals 2

    .prologue
    .line 213
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->a()Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;->CONNECTED:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    if-ne p2, v0, :cond_0

    .line 214
    sget-object v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Network connection has been restored. Retrying LiveAgent Logging connection."

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->a(Ljava/lang/String;)V

    .line 215
    invoke-direct {p0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->d()V

    .line 217
    :cond_0
    return-void
.end method

.method public a(Ljava/lang/Throwable;)V
    .locals 5

    .prologue
    .line 196
    sget-object v1, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Error encountered during LiveAgent Logging session [Pod - {}, LiveAgent Session ID - {}]\n{}"

    const/4 v0, 0x3

    new-array v3, v0, [Ljava/lang/Object;

    const/4 v0, 0x0

    iget-object v4, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->j:Ljava/lang/String;

    aput-object v4, v3, v0

    const/4 v4, 0x1

    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->i:Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->i:Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;

    .line 197
    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;->a()Ljava/lang/String;

    move-result-object v0

    :goto_0
    aput-object v0, v3, v4

    const/4 v0, 0x2

    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v0

    .line 196
    invoke-interface {v1, v2, v3}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->e(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 199
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->h:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;

    if-eqz v0, :cond_0

    .line 201
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->h:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->b()V

    .line 204
    :cond_0
    invoke-direct {p0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->d()V

    .line 205
    return-void

    .line 197
    :cond_1
    const-string v0, "UNKNOWN"

    goto :goto_0
.end method

.method public a()Z
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->h:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->i:Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public b(Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager$Listener;)Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;
    .locals 1

    .prologue
    .line 135
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->g:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 136
    return-object p0
.end method

.method public b()V
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->e:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->c()V

    .line 121
    return-void
.end method

.method public c()V
    .locals 1

    .prologue
    .line 124
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->h:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;

    if-eqz v0, :cond_0

    .line 125
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;->h:Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;->b()V

    .line 127
    :cond_0
    return-void
.end method
