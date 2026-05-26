.class public abstract Lcom/firebase/jobdispatcher/JobService;
.super Landroid/app/Service;
.source "JobService.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/firebase/jobdispatcher/JobService$JobCallback;
    }
.end annotation


# static fields
.field private static final a:Landroid/os/Handler;


# instance fields
.field private final b:Landroid/support/v4/util/SimpleArrayMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/util/SimpleArrayMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/firebase/jobdispatcher/JobService$JobCallback;",
            ">;"
        }
    .end annotation
.end field

.field private final c:Lcom/firebase/jobdispatcher/IRemoteJobService$Stub;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 84
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    sput-object v0, Lcom/firebase/jobdispatcher/JobService;->a:Landroid/os/Handler;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 58
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 91
    new-instance v0, Landroid/support/v4/util/SimpleArrayMap;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Landroid/support/v4/util/SimpleArrayMap;-><init>(I)V

    iput-object v0, p0, Lcom/firebase/jobdispatcher/JobService;->b:Landroid/support/v4/util/SimpleArrayMap;

    .line 93
    new-instance v0, Lcom/firebase/jobdispatcher/JobService$1;

    invoke-direct {v0, p0}, Lcom/firebase/jobdispatcher/JobService$1;-><init>(Lcom/firebase/jobdispatcher/JobService;)V

    iput-object v0, p0, Lcom/firebase/jobdispatcher/JobService;->c:Lcom/firebase/jobdispatcher/IRemoteJobService$Stub;

    return-void
.end method

.method static synthetic a(Lcom/firebase/jobdispatcher/JobService;)Landroid/support/v4/util/SimpleArrayMap;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobService;->b:Landroid/support/v4/util/SimpleArrayMap;

    return-object v0
.end method


# virtual methods
.method a(Lcom/firebase/jobdispatcher/JobParameters;Lcom/firebase/jobdispatcher/IJobCallback;)V
    .locals 7

    .prologue
    .line 151
    iget-object v1, p0, Lcom/firebase/jobdispatcher/JobService;->b:Landroid/support/v4/util/SimpleArrayMap;

    monitor-enter v1

    .line 152
    :try_start_0
    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobService;->b:Landroid/support/v4/util/SimpleArrayMap;

    invoke-interface {p1}, Lcom/firebase/jobdispatcher/JobParameters;->e()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/support/v4/util/SimpleArrayMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 153
    const-string v0, "FJD.JobService"

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    const-string v3, "Job with tag = %s was already running."

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    .line 154
    invoke-interface {p1}, Lcom/firebase/jobdispatcher/JobParameters;->e()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v2, v3, v4}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 153
    invoke-static {v0, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 155
    monitor-exit v1

    .line 175
    :goto_0
    return-void

    .line 157
    :cond_0
    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobService;->b:Landroid/support/v4/util/SimpleArrayMap;

    invoke-interface {p1}, Lcom/firebase/jobdispatcher/JobParameters;->e()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/firebase/jobdispatcher/JobService$JobCallback;

    const/4 v4, 0x0

    invoke-direct {v3, p1, p2, v4}, Lcom/firebase/jobdispatcher/JobService$JobCallback;-><init>(Lcom/firebase/jobdispatcher/JobParameters;Lcom/firebase/jobdispatcher/IJobCallback;Lcom/firebase/jobdispatcher/JobService$1;)V

    invoke-virtual {v0, v2, v3}, Landroid/support/v4/util/SimpleArrayMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 159
    sget-object v0, Lcom/firebase/jobdispatcher/JobService;->a:Landroid/os/Handler;

    new-instance v2, Lcom/firebase/jobdispatcher/JobService$2;

    invoke-direct {v2, p0, p1}, Lcom/firebase/jobdispatcher/JobService$2;-><init>(Lcom/firebase/jobdispatcher/JobService;Lcom/firebase/jobdispatcher/JobParameters;)V

    invoke-virtual {v0, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 174
    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method a(Lcom/firebase/jobdispatcher/JobParameters;Z)V
    .locals 4

    .prologue
    .line 183
    iget-object v1, p0, Lcom/firebase/jobdispatcher/JobService;->b:Landroid/support/v4/util/SimpleArrayMap;

    monitor-enter v1

    .line 184
    :try_start_0
    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobService;->b:Landroid/support/v4/util/SimpleArrayMap;

    invoke-interface {p1}, Lcom/firebase/jobdispatcher/JobParameters;->e()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/support/v4/util/SimpleArrayMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/firebase/jobdispatcher/JobService$JobCallback;

    .line 185
    if-nez v0, :cond_1

    .line 186
    const-string v0, "FJD.JobService"

    const/4 v2, 0x3

    invoke-static {v0, v2}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 187
    const-string v0, "FJD.JobService"

    const-string v2, "Provided job has already been executed."

    invoke-static {v0, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 189
    :cond_0
    monitor-exit v1

    .line 203
    :goto_0
    return-void

    .line 192
    :cond_1
    sget-object v2, Lcom/firebase/jobdispatcher/JobService;->a:Landroid/os/Handler;

    new-instance v3, Lcom/firebase/jobdispatcher/JobService$3;

    invoke-direct {v3, p0, p1, p2, v0}, Lcom/firebase/jobdispatcher/JobService$3;-><init>(Lcom/firebase/jobdispatcher/JobService;Lcom/firebase/jobdispatcher/JobParameters;ZLcom/firebase/jobdispatcher/JobService$JobCallback;)V

    invoke-virtual {v2, v3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 202
    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public abstract a(Lcom/firebase/jobdispatcher/JobParameters;)Z
.end method

.method public final b(Lcom/firebase/jobdispatcher/JobParameters;Z)V
    .locals 3

    .prologue
    .line 214
    if-nez p1, :cond_0

    .line 215
    const-string v0, "FJD.JobService"

    const-string v1, "jobFinished called with a null JobParameters"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 226
    :goto_0
    return-void

    .line 219
    :cond_0
    iget-object v2, p0, Lcom/firebase/jobdispatcher/JobService;->b:Landroid/support/v4/util/SimpleArrayMap;

    monitor-enter v2

    .line 220
    :try_start_0
    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobService;->b:Landroid/support/v4/util/SimpleArrayMap;

    invoke-interface {p1}, Lcom/firebase/jobdispatcher/JobParameters;->e()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v4/util/SimpleArrayMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/firebase/jobdispatcher/JobService$JobCallback;

    .line 222
    if-eqz v0, :cond_1

    .line 223
    if-eqz p2, :cond_2

    const/4 v1, 0x1

    :goto_1
    invoke-virtual {v0, v1}, Lcom/firebase/jobdispatcher/JobService$JobCallback;->a(I)V

    .line 225
    :cond_1
    monitor-exit v2

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 223
    :cond_2
    const/4 v1, 0x0

    goto :goto_1
.end method

.method public abstract b(Lcom/firebase/jobdispatcher/JobParameters;)Z
.end method

.method protected final dump(Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 267
    invoke-super {p0, p1, p2, p3}, Landroid/app/Service;->dump(Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V

    .line 268
    return-void
.end method

.method public final onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1

    .prologue
    .line 238
    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobService;->c:Lcom/firebase/jobdispatcher/IRemoteJobService$Stub;

    return-object v0
.end method

.method public final onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 0

    .prologue
    .line 272
    invoke-super {p0, p1}, Landroid/app/Service;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 273
    return-void
.end method

.method public final onRebind(Landroid/content/Intent;)V
    .locals 0

    .prologue
    .line 259
    invoke-super {p0, p1}, Landroid/app/Service;->onRebind(Landroid/content/Intent;)V

    .line 260
    return-void
.end method

.method public final onStart(Landroid/content/Intent;I)V
    .locals 0

    .prologue
    .line 263
    return-void
.end method

.method public final onStartCommand(Landroid/content/Intent;II)I
    .locals 1

    .prologue
    .line 230
    invoke-virtual {p0, p3}, Lcom/firebase/jobdispatcher/JobService;->stopSelf(I)V

    .line 232
    const/4 v0, 0x2

    return v0
.end method

.method public final onTaskRemoved(Landroid/content/Intent;)V
    .locals 0

    .prologue
    .line 277
    invoke-super {p0, p1}, Landroid/app/Service;->onTaskRemoved(Landroid/content/Intent;)V

    .line 278
    return-void
.end method

.method public final onUnbind(Landroid/content/Intent;)Z
    .locals 4

    .prologue
    .line 244
    iget-object v3, p0, Lcom/firebase/jobdispatcher/JobService;->b:Landroid/support/v4/util/SimpleArrayMap;

    monitor-enter v3

    .line 245
    :try_start_0
    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobService;->b:Landroid/support/v4/util/SimpleArrayMap;

    invoke-virtual {v0}, Landroid/support/v4/util/SimpleArrayMap;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    move v2, v0

    :goto_0
    if-ltz v2, :cond_2

    .line 246
    iget-object v0, p0, Lcom/firebase/jobdispatcher/JobService;->b:Landroid/support/v4/util/SimpleArrayMap;

    iget-object v1, p0, Lcom/firebase/jobdispatcher/JobService;->b:Landroid/support/v4/util/SimpleArrayMap;

    invoke-virtual {v1, v2}, Landroid/support/v4/util/SimpleArrayMap;->b(I)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v4/util/SimpleArrayMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/firebase/jobdispatcher/JobService$JobCallback;

    .line 247
    if-eqz v0, :cond_0

    .line 248
    iget-object v1, v0, Lcom/firebase/jobdispatcher/JobService$JobCallback;->a:Lcom/firebase/jobdispatcher/JobParameters;

    invoke-virtual {p0, v1}, Lcom/firebase/jobdispatcher/JobService;->b(Lcom/firebase/jobdispatcher/JobParameters;)Z

    move-result v1

    .line 249
    if-eqz v1, :cond_1

    const/4 v1, 0x1

    :goto_1
    invoke-virtual {v0, v1}, Lcom/firebase/jobdispatcher/JobService$JobCallback;->a(I)V

    .line 245
    :cond_0
    add-int/lit8 v0, v2, -0x1

    move v2, v0

    goto :goto_0

    .line 249
    :cond_1
    const/4 v1, 0x2

    goto :goto_1

    .line 252
    :cond_2
    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 254
    invoke-super {p0, p1}, Landroid/app/Service;->onUnbind(Landroid/content/Intent;)Z

    move-result v0

    return v0

    .line 252
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method
