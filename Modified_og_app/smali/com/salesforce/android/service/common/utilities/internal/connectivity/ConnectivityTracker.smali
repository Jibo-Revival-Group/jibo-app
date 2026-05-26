.class public Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;
.super Landroid/content/BroadcastReceiver;
.source "ConnectivityTracker.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;,
        Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Listener;
    }
.end annotation


# static fields
.field private static final a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field private final b:Landroid/content/Context;

.field private final c:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Listener;

.field private final d:Landroid/net/ConnectivityManager;

.field private final e:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo$Builder;

.field private f:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 64
    const-class v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method protected constructor <init>(Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;)V
    .locals 2

    .prologue
    .line 85
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 79
    sget-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;->UNKNOWN:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->f:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    .line 86
    iget-object v0, p1, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;->a:Landroid/content/Context;

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->b:Landroid/content/Context;

    .line 87
    iget-object v0, p1, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;->b:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Listener;

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->c:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Listener;

    .line 88
    iget-object v0, p1, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;->d:Landroid/net/ConnectivityManager;

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->d:Landroid/net/ConnectivityManager;

    .line 89
    iget-object v0, p1, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;->e:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo$Builder;

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->e:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo$Builder;

    .line 91
    sget-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Setting up network connectivity broadcast receiver"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 92
    iget-object v0, p1, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;->c:Lcom/salesforce/android/service/common/utilities/internal/android/IntentFactory;

    const-string v1, "android.net.conn.CONNECTIVITY_CHANGE"

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/internal/android/IntentFactory;->a(Ljava/lang/String;)Landroid/content/IntentFilter;

    move-result-object v0

    .line 93
    iget-object v1, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->b:Landroid/content/Context;

    invoke-virtual {v1, p0, v0}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 94
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->a()Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->f:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    .line 95
    return-void
.end method


# virtual methods
.method public a()Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;
    .locals 2

    .prologue
    .line 102
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->d:Landroid/net/ConnectivityManager;

    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    .line 103
    iget-object v1, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->e:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo$Builder;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo$Builder;->a(Landroid/net/NetworkInfo;)Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo$Builder;->a()Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;

    move-result-object v1

    .line 104
    invoke-virtual {v1}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;->a()Z

    move-result v1

    invoke-virtual {p0, v0, v1}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->a(Landroid/net/NetworkInfo;Z)Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    move-result-object v0

    return-object v0
.end method

.method a(Landroid/net/NetworkInfo;Z)Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;
    .locals 2

    .prologue
    .line 122
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/net/NetworkInfo;->getState()Landroid/net/NetworkInfo$State;

    move-result-object v0

    .line 123
    :goto_0
    sget-object v1, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$1;->a:[I

    invoke-virtual {v0}, Landroid/net/NetworkInfo$State;->ordinal()I

    move-result v0

    aget v0, v1, v0

    packed-switch v0, :pswitch_data_0

    .line 134
    sget-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;->UNKNOWN:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    :goto_1
    return-object v0

    .line 122
    :cond_0
    sget-object v0, Landroid/net/NetworkInfo$State;->DISCONNECTED:Landroid/net/NetworkInfo$State;

    goto :goto_0

    .line 128
    :pswitch_0
    if-eqz p2, :cond_1

    sget-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;->SWITCHING:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    goto :goto_1

    :cond_1
    sget-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;->DISCONNECTED:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    goto :goto_1

    .line 132
    :pswitch_1
    sget-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;->CONNECTED:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    goto :goto_1

    .line 123
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public b()Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;
    .locals 2

    .prologue
    .line 108
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->d:Landroid/net/ConnectivityManager;

    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    .line 109
    iget-object v1, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->e:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo$Builder;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo$Builder;->a(Landroid/net/NetworkInfo;)Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo$Builder;->a()Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;

    move-result-object v0

    return-object v0
.end method

.method public c()V
    .locals 2

    .prologue
    .line 113
    sget-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Removing network connectivity broadcast receiver"

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;)V

    .line 114
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->b:Landroid/content/Context;

    invoke-virtual {v0, p0}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 115
    return-void
.end method

.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 8

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 144
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 145
    if-nez v0, :cond_1

    .line 168
    :cond_0
    :goto_0
    return-void

    .line 150
    :cond_1
    const-string v1, "networkInfo"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 151
    if-eqz v0, :cond_0

    instance-of v1, v0, Landroid/net/NetworkInfo;

    if-eqz v1, :cond_0

    .line 155
    check-cast v0, Landroid/net/NetworkInfo;

    .line 156
    iget-object v1, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->e:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo$Builder;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo$Builder;->a(Landroid/net/NetworkInfo;)Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo$Builder;->a()Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;

    move-result-object v1

    .line 157
    invoke-virtual {v1}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;->a()Z

    move-result v2

    invoke-virtual {p0, v0, v2}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->a(Landroid/net/NetworkInfo;Z)Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    move-result-object v0

    .line 159
    iget-object v2, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->f:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    if-eq v0, v2, :cond_0

    .line 163
    iget-object v2, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->f:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    .line 164
    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->f:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    .line 165
    sget-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v3, "Connectivity change: {} -> {}"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v2}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;->name()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    iget-object v5, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->f:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    invoke-virtual {v5}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;->name()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v7

    invoke-interface {v0, v3, v4}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 166
    sget-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v3, "{}"

    new-array v4, v7, [Ljava/lang/Object;

    aput-object v1, v4, v6

    invoke-interface {v0, v3, v4}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 167
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->c:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Listener;

    iget-object v3, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->f:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;

    invoke-interface {v0, v1, v3, v2}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Listener;->a(Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;)V

    goto :goto_0
.end method
