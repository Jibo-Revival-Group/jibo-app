.class public Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;
.super Ljava/lang/Object;
.source "ActivityTracker.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnStopListener;,
        Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnDestroyListener;,
        Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnPauseListener;,
        Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnResumeListener;,
        Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnStartListener;,
        Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnCreateListener;,
        Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$LifecycleCallbacks;
    }
.end annotation


# static fields
.field private static final j:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field a:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/utilities/activity/ActivityReference",
            "<",
            "Landroid/app/Activity;",
            ">;"
        }
    .end annotation
.end field

.field final b:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$LifecycleCallbacks;

.field final c:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnCreateListener;",
            ">;"
        }
    .end annotation
.end field

.field final d:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnStartListener;",
            ">;"
        }
    .end annotation
.end field

.field final e:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnResumeListener;",
            ">;"
        }
    .end annotation
.end field

.field final f:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnPauseListener;",
            ">;"
        }
    .end annotation
.end field

.field final g:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnDestroyListener;",
            ">;"
        }
    .end annotation
.end field

.field final h:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnStopListener;",
            ">;"
        }
    .end annotation
.end field

.field private i:Landroid/app/Application;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 59
    const-class v0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->j:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;->a()Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->a:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    .line 48
    new-instance v0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$LifecycleCallbacks;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$LifecycleCallbacks;-><init>(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;)V

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->b:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$LifecycleCallbacks;

    .line 50
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->c:Ljava/util/Set;

    .line 51
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->d:Ljava/util/Set;

    .line 52
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->e:Ljava/util/Set;

    .line 53
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->f:Ljava/util/Set;

    .line 54
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->g:Ljava/util/Set;

    .line 55
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->h:Ljava/util/Set;

    return-void
.end method

.method static synthetic c()Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;
    .locals 1

    .prologue
    .line 45
    sget-object v0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->j:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-object v0
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnCreateListener;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->c:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 87
    return-object p0
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnDestroyListener;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->g:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 127
    return-object p0
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnPauseListener;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->f:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 117
    return-object p0
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnResumeListener;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->e:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 107
    return-object p0
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnStartListener;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->d:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 97
    return-object p0
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnStopListener;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->h:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 137
    return-object p0
.end method

.method public a()V
    .locals 2

    .prologue
    .line 71
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->i:Landroid/app/Application;

    if-eqz v0, :cond_0

    .line 72
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->i:Landroid/app/Application;

    iget-object v1, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->b:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$LifecycleCallbacks;

    invoke-virtual {v0, v1}, Landroid/app/Application;->unregisterActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V

    .line 73
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->i:Landroid/app/Application;

    .line 75
    :cond_0
    return-void
.end method

.method public a(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 82
    invoke-static {p1}, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;->a(Landroid/app/Activity;)Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->a:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    .line 83
    return-void
.end method

.method public a(Landroid/content/Context;)V
    .locals 2

    .prologue
    .line 66
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Landroid/app/Application;

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->i:Landroid/app/Application;

    .line 67
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->i:Landroid/app/Application;

    iget-object v1, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->b:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$LifecycleCallbacks;

    invoke-virtual {v0, v1}, Landroid/app/Application;->registerActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V

    .line 68
    return-void
.end method

.method public b()Landroid/app/Activity;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->a:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/Activity;

    return-object v0
.end method

.method public b(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnCreateListener;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->c:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 92
    return-object p0
.end method

.method public b(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnDestroyListener;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->g:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 132
    return-object p0
.end method

.method public b(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnPauseListener;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->f:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 122
    return-object p0
.end method

.method public b(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnResumeListener;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->e:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 112
    return-object p0
.end method

.method public b(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnStartListener;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->d:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 102
    return-object p0
.end method

.method public b(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnStopListener;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;
    .locals 1

    .prologue
    .line 141
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->h:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 142
    return-object p0
.end method
