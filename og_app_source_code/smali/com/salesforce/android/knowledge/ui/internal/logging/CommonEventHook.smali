.class Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;
.super Ljava/lang/Object;
.source "CommonEventHook.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker$Listener;
.implements Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Listener;
.implements Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Listener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook$Listener;
    }
.end annotation


# instance fields
.field private a:Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook$Listener;

.field private final b:Ljava/lang/String;

.field private final c:Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;

.field private d:Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker;

.field private e:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;->c:Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;

    .line 52
    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;->b:Ljava/lang/String;

    .line 53
    return-void
.end method

.method static a(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;
    .locals 2

    .prologue
    .line 56
    invoke-static {p0}, Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;->a(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;)Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;

    move-result-object v0

    .line 57
    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;

    invoke-direct {v1, v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;-><init>(Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;Ljava/lang/String;)V

    return-object v1
.end method

.method private a(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;->a:Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook$Listener;

    if-eqz v0, :cond_0

    .line 93
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;->a:Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook$Listener;

    invoke-interface {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook$Listener;->b(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V

    .line 95
    :cond_0
    return-void
.end method


# virtual methods
.method a()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 72
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;->c:Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;->b()V

    .line 73
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;->d:Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker;

    if-eqz v0, :cond_0

    .line 74
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;->d:Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker;->a()V

    .line 75
    iput-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;->d:Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker;

    .line 77
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;->e:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;

    if-eqz v0, :cond_1

    .line 78
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;->e:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;->c()V

    .line 79
    iput-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;->e:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;

    .line 81
    :cond_1
    return-void
.end method

.method a(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 65
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;-><init>()V

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;->a(Landroid/content/Context;)Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;->a(Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Listener;)Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker$Builder;->a()Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;->d:Lcom/salesforce/android/service/common/utilities/internal/device/OrientationTracker;

    .line 66
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;-><init>()V

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;->a(Landroid/content/Context;)Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;->a(Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Listener;)Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;->a()Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;->e:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;

    .line 67
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;->c:Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;->a(Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker$Listener;)V

    .line 68
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;->c:Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;->a()V

    .line 69
    return-void
.end method

.method a(Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook$Listener;)V
    .locals 0

    .prologue
    .line 84
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;->a:Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook$Listener;

    .line 85
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityState;)V
    .locals 5

    .prologue
    .line 107
    invoke-virtual {p1}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;->b()Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;->name()Ljava/lang/String;

    move-result-object v0

    .line 108
    invoke-virtual {p1}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;->c()Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->getRadioName()Ljava/lang/String;

    move-result-object v1

    .line 109
    new-instance v2, Lcom/salesforce/android/service/common/liveagentlogging/event/ConnectivityEvent;

    const-string v3, "KB"

    iget-object v4, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;->b:Ljava/lang/String;

    invoke-direct {v2, v3, v4, v0, v1}, Lcom/salesforce/android/service/common/liveagentlogging/event/ConnectivityEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0, v2}, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;->a(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V

    .line 110
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/spatial/Orientation;)V
    .locals 3

    .prologue
    .line 113
    new-instance v0, Lcom/salesforce/android/service/common/liveagentlogging/event/OrientationEvent;

    const-string v1, "KB"

    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;->b:Ljava/lang/String;

    invoke-direct {v0, v1, v2, p1}, Lcom/salesforce/android/service/common/liveagentlogging/event/OrientationEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/android/service/common/utilities/spatial/Orientation;)V

    invoke-direct {p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;->a(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V

    .line 114
    return-void
.end method

.method public a(Z)V
    .locals 3

    .prologue
    .line 102
    new-instance v0, Lcom/salesforce/android/service/common/liveagentlogging/event/BackgroundedEvent;

    const-string v1, "KB"

    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;->b:Ljava/lang/String;

    invoke-direct {v0, v1, v2, p1}, Lcom/salesforce/android/service/common/liveagentlogging/event/BackgroundedEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-direct {p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/logging/CommonEventHook;->a(Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;)V

    .line 103
    return-void
.end method
