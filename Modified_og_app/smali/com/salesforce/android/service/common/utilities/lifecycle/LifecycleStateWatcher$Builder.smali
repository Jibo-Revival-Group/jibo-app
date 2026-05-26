.class public Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher$Builder;
.super Ljava/lang/Object;
.source "LifecycleStateWatcher.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<S:",
        "Ljava/lang/Enum",
        "<TS;>;:",
        "Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleState",
        "<TM;>;M:",
        "Ljava/lang/Enum",
        "<TM;>;:",
        "Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetric;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private a:Landroid/os/Handler;

.field private b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 92
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<TS;>;)",
            "Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher",
            "<TS;TM;>;"
        }
    .end annotation

    .prologue
    .line 103
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher$Builder;->a:Landroid/os/Handler;

    if-nez v0, :cond_0

    .line 104
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher$Builder;->a:Landroid/os/Handler;

    .line 107
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher$Builder;->b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    if-nez v0, :cond_1

    .line 108
    const-class v0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;

    const-string v1, "LifecycleStateWatcher:%s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    .line 109
    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 108
    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;Ljava/lang/String;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher$Builder;->b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    .line 112
    :cond_1
    new-instance v0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;

    iget-object v1, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher$Builder;->a:Landroid/os/Handler;

    iget-object v2, p0, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher$Builder;->b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    invoke-direct {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleStateWatcher;-><init>(Landroid/os/Handler;Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;)V

    return-object v0
.end method
