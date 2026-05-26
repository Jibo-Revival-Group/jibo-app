.class public Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;
.super Ljava/lang/Object;
.source "BackgroundTracker.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnResumeListener;
.implements Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnStopListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker$Listener;
    }
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

.field private final b:Landroid/os/Handler;

.field private final c:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker$Listener;",
            ">;"
        }
    .end annotation
.end field

.field private d:Z


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;Landroid/os/Handler;)V
    .locals 1

    .prologue
    .line 55
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->newSetFromMap(Ljava/util/Map;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;->c:Ljava/util/Set;

    .line 48
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;->d:Z

    .line 56
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;->a:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    .line 57
    iput-object p2, p0, Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;->b:Landroid/os/Handler;

    .line 58
    return-void
.end method

.method public static a(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;)Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;
    .locals 3

    .prologue
    .line 61
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;

    new-instance v1, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    invoke-direct {v0, p0, v1}, Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;-><init>(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;Landroid/os/Handler;)V

    return-object v0
.end method

.method private a(Z)V
    .locals 2

    .prologue
    .line 106
    iget-boolean v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;->d:Z

    if-eq v0, p1, :cond_0

    .line 107
    iput-boolean p1, p0, Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;->d:Z

    .line 108
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;->c:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker$Listener;

    .line 109
    invoke-interface {v0, p1}, Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker$Listener;->a(Z)V

    goto :goto_0

    .line 112
    :cond_0
    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;->a:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->b()Landroid/app/Activity;

    move-result-object v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;->d:Z

    .line 74
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;->a:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->a(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnResumeListener;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->a(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnStopListener;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    .line 75
    return-void

    .line 73
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public a(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 135
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;->b:Landroid/os/Handler;

    new-instance v1, Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker$1;

    invoke-direct {v1, p0}, Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker$1;-><init>(Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 141
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker$Listener;)V
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;->c:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 87
    return-void
.end method

.method public b()V
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;->a:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->b(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnResumeListener;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->b(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnStopListener;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    .line 83
    return-void
.end method

.method public b(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 125
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;->a(Z)V

    .line 126
    return-void
.end method

.method c()V
    .locals 1

    .prologue
    .line 115
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;->a:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->b()Landroid/app/Activity;

    move-result-object v0

    if-nez v0, :cond_0

    .line 116
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;->a(Z)V

    .line 118
    :cond_0
    return-void
.end method
