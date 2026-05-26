.class public Lcom/mixpanel/android/mpmetrics/ExceptionHandler;
.super Ljava/lang/Object;
.source "ExceptionHandler.java"

# interfaces
.implements Ljava/lang/Thread$UncaughtExceptionHandler;


# static fields
.field private static a:Lcom/mixpanel/android/mpmetrics/ExceptionHandler;


# instance fields
.field private final b:Ljava/lang/Thread$UncaughtExceptionHandler;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    invoke-static {}, Ljava/lang/Thread;->getDefaultUncaughtExceptionHandler()Ljava/lang/Thread$UncaughtExceptionHandler;

    move-result-object v0

    iput-object v0, p0, Lcom/mixpanel/android/mpmetrics/ExceptionHandler;->b:Ljava/lang/Thread$UncaughtExceptionHandler;

    .line 18
    invoke-static {p0}, Ljava/lang/Thread;->setDefaultUncaughtExceptionHandler(Ljava/lang/Thread$UncaughtExceptionHandler;)V

    .line 19
    return-void
.end method

.method public static a()V
    .locals 2

    .prologue
    .line 22
    sget-object v0, Lcom/mixpanel/android/mpmetrics/ExceptionHandler;->a:Lcom/mixpanel/android/mpmetrics/ExceptionHandler;

    if-nez v0, :cond_1

    .line 23
    const-class v1, Lcom/mixpanel/android/mpmetrics/ExceptionHandler;

    monitor-enter v1

    .line 24
    :try_start_0
    sget-object v0, Lcom/mixpanel/android/mpmetrics/ExceptionHandler;->a:Lcom/mixpanel/android/mpmetrics/ExceptionHandler;

    if-nez v0, :cond_0

    .line 25
    new-instance v0, Lcom/mixpanel/android/mpmetrics/ExceptionHandler;

    invoke-direct {v0}, Lcom/mixpanel/android/mpmetrics/ExceptionHandler;-><init>()V

    sput-object v0, Lcom/mixpanel/android/mpmetrics/ExceptionHandler;->a:Lcom/mixpanel/android/mpmetrics/ExceptionHandler;

    .line 27
    :cond_0
    monitor-exit v1

    .line 29
    :cond_1
    return-void

    .line 27
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private b()V
    .locals 2

    .prologue
    .line 61
    const-wide/16 v0, 0x190

    :try_start_0
    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 65
    :goto_0
    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v0

    invoke-static {v0}, Landroid/os/Process;->killProcess(I)V

    .line 66
    const/16 v0, 0xa

    invoke-static {v0}, Ljava/lang/System;->exit(I)V

    .line 67
    return-void

    .line 62
    :catch_0
    move-exception v0

    .line 63
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_0
.end method


# virtual methods
.method public uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V
    .locals 1

    .prologue
    .line 34
    new-instance v0, Lcom/mixpanel/android/mpmetrics/ExceptionHandler$1;

    invoke-direct {v0, p0, p2}, Lcom/mixpanel/android/mpmetrics/ExceptionHandler$1;-><init>(Lcom/mixpanel/android/mpmetrics/ExceptionHandler;Ljava/lang/Throwable;)V

    invoke-static {v0}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI;->a(Lcom/mixpanel/android/mpmetrics/MixpanelAPI$InstanceProcessor;)V

    .line 45
    new-instance v0, Lcom/mixpanel/android/mpmetrics/ExceptionHandler$2;

    invoke-direct {v0, p0}, Lcom/mixpanel/android/mpmetrics/ExceptionHandler$2;-><init>(Lcom/mixpanel/android/mpmetrics/ExceptionHandler;)V

    invoke-static {v0}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI;->a(Lcom/mixpanel/android/mpmetrics/MixpanelAPI$InstanceProcessor;)V

    .line 52
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/ExceptionHandler;->b:Ljava/lang/Thread$UncaughtExceptionHandler;

    if-eqz v0, :cond_0

    .line 53
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/ExceptionHandler;->b:Ljava/lang/Thread$UncaughtExceptionHandler;

    invoke-interface {v0, p1, p2}, Ljava/lang/Thread$UncaughtExceptionHandler;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V

    .line 57
    :goto_0
    return-void

    .line 55
    :cond_0
    invoke-direct {p0}, Lcom/mixpanel/android/mpmetrics/ExceptionHandler;->b()V

    goto :goto_0
.end method
