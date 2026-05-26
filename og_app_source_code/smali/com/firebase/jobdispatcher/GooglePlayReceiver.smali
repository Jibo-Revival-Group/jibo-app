.class public Lcom/firebase/jobdispatcher/GooglePlayReceiver;
.super Landroid/app/Service;
.source "GooglePlayReceiver.java"

# interfaces
.implements Lcom/firebase/jobdispatcher/ExecutionDelegator$JobFinishedCallback;


# static fields
.field private static final d:Lcom/firebase/jobdispatcher/JobCoder;

.field private static final h:Landroid/support/v4/util/SimpleArrayMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/util/SimpleArrayMap",
            "<",
            "Ljava/lang/String;",
            "Landroid/support/v4/util/SimpleArrayMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/firebase/jobdispatcher/JobCallback;",
            ">;>;"
        }
    .end annotation
.end field


# instance fields
.field a:Landroid/os/Messenger;

.field b:Lcom/firebase/jobdispatcher/Driver;

.field c:Lcom/firebase/jobdispatcher/ValidationEnforcer;

.field private final e:Lcom/firebase/jobdispatcher/GooglePlayCallbackExtractor;

.field private f:Lcom/firebase/jobdispatcher/ExecutionDelegator;

.field private g:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 55
    new-instance v0, Lcom/firebase/jobdispatcher/JobCoder;

    const-string v1, "com.firebase.jobdispatcher."

    invoke-direct {v0, v1}, Lcom/firebase/jobdispatcher/JobCoder;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->d:Lcom/firebase/jobdispatcher/JobCoder;

    .line 84
    new-instance v0, Landroid/support/v4/util/SimpleArrayMap;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Landroid/support/v4/util/SimpleArrayMap;-><init>(I)V

    sput-object v0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->h:Landroid/support/v4/util/SimpleArrayMap;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 40
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 58
    new-instance v0, Lcom/firebase/jobdispatcher/GooglePlayCallbackExtractor;

    invoke-direct {v0}, Lcom/firebase/jobdispatcher/GooglePlayCallbackExtractor;-><init>()V

    iput-object v0, p0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->e:Lcom/firebase/jobdispatcher/GooglePlayCallbackExtractor;

    return-void
.end method

.method static a(Lcom/firebase/jobdispatcher/Job;)V
    .locals 3

    .prologue
    .line 288
    sget-object v1, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->h:Landroid/support/v4/util/SimpleArrayMap;

    monitor-enter v1

    .line 289
    :try_start_0
    sget-object v0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->h:Landroid/support/v4/util/SimpleArrayMap;

    invoke-virtual {p0}, Lcom/firebase/jobdispatcher/Job;->i()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/support/v4/util/SimpleArrayMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/util/SimpleArrayMap;

    .line 290
    if-nez v0, :cond_0

    .line 291
    monitor-exit v1

    .line 305
    :goto_0
    return-void

    .line 293
    :cond_0
    invoke-virtual {p0}, Lcom/firebase/jobdispatcher/Job;->e()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/support/v4/util/SimpleArrayMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/firebase/jobdispatcher/JobCallback;

    .line 294
    if-nez v0, :cond_1

    .line 295
    monitor-exit v1

    goto :goto_0

    .line 304
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 297
    :cond_1
    :try_start_1
    new-instance v0, Lcom/firebase/jobdispatcher/JobInvocation$Builder;

    invoke-direct {v0}, Lcom/firebase/jobdispatcher/JobInvocation$Builder;-><init>()V

    .line 299
    invoke-virtual {p0}, Lcom/firebase/jobdispatcher/Job;->e()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->a(Ljava/lang/String;)Lcom/firebase/jobdispatcher/JobInvocation$Builder;

    move-result-object v0

    .line 300
    invoke-virtual {p0}, Lcom/firebase/jobdispatcher/Job;->i()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->b(Ljava/lang/String;)Lcom/firebase/jobdispatcher/JobInvocation$Builder;

    move-result-object v0

    .line 301
    invoke-virtual {p0}, Lcom/firebase/jobdispatcher/Job;->f()Lcom/firebase/jobdispatcher/JobTrigger;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->a(Lcom/firebase/jobdispatcher/JobTrigger;)Lcom/firebase/jobdispatcher/JobInvocation$Builder;

    move-result-object v0

    .line 302
    invoke-virtual {v0}, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->a()Lcom/firebase/jobdispatcher/JobInvocation;

    move-result-object v0

    .line 303
    const/4 v2, 0x0

    invoke-static {v0, v2}, Lcom/firebase/jobdispatcher/ExecutionDelegator;->a(Lcom/firebase/jobdispatcher/JobInvocation;Z)V

    .line 304
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0
.end method

.method private static a(Lcom/firebase/jobdispatcher/JobCallback;I)V
    .locals 3

    .prologue
    .line 96
    :try_start_0
    invoke-interface {p0, p1}, Lcom/firebase/jobdispatcher/JobCallback;->a(I)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 100
    :goto_0
    return-void

    .line 97
    :catch_0
    move-exception v0

    .line 98
    const-string v1, "FJD.GooglePlayReceiver"

    const-string v2, "Encountered error running callback"

    invoke-virtual {v0}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method private a(Lcom/firebase/jobdispatcher/JobInvocation;)V
    .locals 2

    .prologue
    .line 257
    new-instance v0, Lcom/firebase/jobdispatcher/Job$Builder;

    invoke-direct {p0}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->e()Lcom/firebase/jobdispatcher/ValidationEnforcer;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Lcom/firebase/jobdispatcher/Job$Builder;-><init>(Lcom/firebase/jobdispatcher/ValidationEnforcer;Lcom/firebase/jobdispatcher/JobParameters;)V

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/firebase/jobdispatcher/Job$Builder;->a(Z)Lcom/firebase/jobdispatcher/Job$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/firebase/jobdispatcher/Job$Builder;->j()Lcom/firebase/jobdispatcher/Job;

    move-result-object v0

    .line 259
    invoke-direct {p0}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->d()Lcom/firebase/jobdispatcher/Driver;

    move-result-object v1

    invoke-interface {v1, v0}, Lcom/firebase/jobdispatcher/Driver;->a(Lcom/firebase/jobdispatcher/Job;)I

    .line 260
    return-void
.end method

.method private static a(Lcom/firebase/jobdispatcher/JobParameters;I)Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 271
    invoke-interface {p0}, Lcom/firebase/jobdispatcher/JobParameters;->h()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 272
    invoke-interface {p0}, Lcom/firebase/jobdispatcher/JobParameters;->f()Lcom/firebase/jobdispatcher/JobTrigger;

    move-result-object v1

    instance-of v1, v1, Lcom/firebase/jobdispatcher/JobTrigger$ContentUriTrigger;

    if-eqz v1, :cond_0

    if-eq p1, v0, :cond_0

    .line 271
    :goto_0
    return v0

    .line 272
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method static b()Lcom/firebase/jobdispatcher/JobCoder;
    .locals 1

    .prologue
    .line 277
    sget-object v0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->d:Lcom/firebase/jobdispatcher/JobCoder;

    return-object v0
.end method

.method private declared-synchronized c()Landroid/os/Messenger;
    .locals 3

    .prologue
    .line 146
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->a:Landroid/os/Messenger;

    if-nez v0, :cond_0

    .line 147
    new-instance v0, Landroid/os/Messenger;

    new-instance v1, Lcom/firebase/jobdispatcher/GooglePlayMessageHandler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-direct {v1, v2, p0}, Lcom/firebase/jobdispatcher/GooglePlayMessageHandler;-><init>(Landroid/os/Looper;Lcom/firebase/jobdispatcher/GooglePlayReceiver;)V

    invoke-direct {v0, v1}, Landroid/os/Messenger;-><init>(Landroid/os/Handler;)V

    iput-object v0, p0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->a:Landroid/os/Messenger;

    .line 149
    :cond_0
    iget-object v0, p0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->a:Landroid/os/Messenger;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 146
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private declared-synchronized d()Lcom/firebase/jobdispatcher/Driver;
    .locals 2

    .prologue
    .line 161
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->b:Lcom/firebase/jobdispatcher/Driver;

    if-nez v0, :cond_0

    .line 162
    new-instance v0, Lcom/firebase/jobdispatcher/GooglePlayDriver;

    invoke-virtual {p0}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/firebase/jobdispatcher/GooglePlayDriver;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->b:Lcom/firebase/jobdispatcher/Driver;

    .line 164
    :cond_0
    iget-object v0, p0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->b:Lcom/firebase/jobdispatcher/Driver;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 161
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private declared-synchronized e()Lcom/firebase/jobdispatcher/ValidationEnforcer;
    .locals 2

    .prologue
    .line 174
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->c:Lcom/firebase/jobdispatcher/ValidationEnforcer;

    if-nez v0, :cond_0

    .line 175
    new-instance v0, Lcom/firebase/jobdispatcher/ValidationEnforcer;

    invoke-direct {p0}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->d()Lcom/firebase/jobdispatcher/Driver;

    move-result-object v1

    invoke-interface {v1}, Lcom/firebase/jobdispatcher/Driver;->a()Lcom/firebase/jobdispatcher/JobValidator;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/firebase/jobdispatcher/ValidationEnforcer;-><init>(Lcom/firebase/jobdispatcher/JobValidator;)V

    iput-object v0, p0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->c:Lcom/firebase/jobdispatcher/ValidationEnforcer;

    .line 177
    :cond_0
    iget-object v0, p0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->c:Lcom/firebase/jobdispatcher/ValidationEnforcer;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 174
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method


# virtual methods
.method declared-synchronized a()Lcom/firebase/jobdispatcher/ExecutionDelegator;
    .locals 1

    .prologue
    .line 153
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->f:Lcom/firebase/jobdispatcher/ExecutionDelegator;

    if-nez v0, :cond_0

    .line 154
    new-instance v0, Lcom/firebase/jobdispatcher/ExecutionDelegator;

    invoke-direct {v0, p0, p0}, Lcom/firebase/jobdispatcher/ExecutionDelegator;-><init>(Landroid/content/Context;Lcom/firebase/jobdispatcher/ExecutionDelegator$JobFinishedCallback;)V

    iput-object v0, p0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->f:Lcom/firebase/jobdispatcher/ExecutionDelegator;

    .line 156
    :cond_0
    iget-object v0, p0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->f:Lcom/firebase/jobdispatcher/ExecutionDelegator;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 153
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method a(Landroid/content/Intent;)Lcom/firebase/jobdispatcher/JobInvocation;
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 188
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    .line 189
    if-nez v1, :cond_0

    .line 190
    const-string v1, "FJD.GooglePlayReceiver"

    const-string v2, "No data provided, terminating"

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 200
    :goto_0
    return-object v0

    .line 195
    :cond_0
    iget-object v2, p0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->e:Lcom/firebase/jobdispatcher/GooglePlayCallbackExtractor;

    invoke-virtual {v2, v1}, Lcom/firebase/jobdispatcher/GooglePlayCallbackExtractor;->a(Landroid/os/Bundle;)Landroid/util/Pair;

    move-result-object v1

    .line 196
    if-nez v1, :cond_1

    .line 197
    const-string v1, "FJD.GooglePlayReceiver"

    const-string v2, "no callback found"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 200
    :cond_1
    iget-object v0, v1, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v0, Lcom/firebase/jobdispatcher/JobCallback;

    iget-object v1, v1, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v1, Landroid/os/Bundle;

    invoke-virtual {p0, v0, v1}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->a(Lcom/firebase/jobdispatcher/JobCallback;Landroid/os/Bundle;)Lcom/firebase/jobdispatcher/JobInvocation;

    move-result-object v0

    goto :goto_0
.end method

.method a(Lcom/firebase/jobdispatcher/JobCallback;Landroid/os/Bundle;)Lcom/firebase/jobdispatcher/JobInvocation;
    .locals 5

    .prologue
    .line 205
    sget-object v0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->d:Lcom/firebase/jobdispatcher/JobCoder;

    invoke-virtual {v0, p2}, Lcom/firebase/jobdispatcher/JobCoder;->a(Landroid/os/Bundle;)Lcom/firebase/jobdispatcher/JobInvocation;

    move-result-object v1

    .line 206
    if-nez v1, :cond_0

    .line 207
    const-string v0, "FJD.GooglePlayReceiver"

    const-string v1, "unable to decode job"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 208
    const/4 v0, 0x2

    invoke-static {p1, v0}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->a(Lcom/firebase/jobdispatcher/JobCallback;I)V

    .line 209
    const/4 v0, 0x0

    .line 220
    :goto_0
    return-object v0

    .line 211
    :cond_0
    sget-object v2, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->h:Landroid/support/v4/util/SimpleArrayMap;

    monitor-enter v2

    .line 212
    :try_start_0
    sget-object v0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->h:Landroid/support/v4/util/SimpleArrayMap;

    invoke-virtual {v1}, Lcom/firebase/jobdispatcher/JobInvocation;->i()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/support/v4/util/SimpleArrayMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/util/SimpleArrayMap;

    .line 213
    if-nez v0, :cond_1

    .line 214
    new-instance v0, Landroid/support/v4/util/SimpleArrayMap;

    const/4 v3, 0x1

    invoke-direct {v0, v3}, Landroid/support/v4/util/SimpleArrayMap;-><init>(I)V

    .line 215
    sget-object v3, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->h:Landroid/support/v4/util/SimpleArrayMap;

    invoke-virtual {v1}, Lcom/firebase/jobdispatcher/JobInvocation;->i()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4, v0}, Landroid/support/v4/util/SimpleArrayMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 218
    :cond_1
    invoke-virtual {v1}, Lcom/firebase/jobdispatcher/JobInvocation;->e()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3, p1}, Landroid/support/v4/util/SimpleArrayMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 219
    monitor-exit v2

    move-object v0, v1

    .line 220
    goto :goto_0

    .line 219
    :catchall_0
    move-exception v0

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public a(Lcom/firebase/jobdispatcher/JobInvocation;I)V
    .locals 5

    .prologue
    .line 225
    sget-object v2, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->h:Landroid/support/v4/util/SimpleArrayMap;

    monitor-enter v2

    .line 227
    :try_start_0
    sget-object v0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->h:Landroid/support/v4/util/SimpleArrayMap;

    invoke-virtual {p1}, Lcom/firebase/jobdispatcher/JobInvocation;->i()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v4/util/SimpleArrayMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/util/SimpleArrayMap;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 228
    if-nez v0, :cond_1

    .line 248
    :try_start_1
    sget-object v0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->h:Landroid/support/v4/util/SimpleArrayMap;

    invoke-virtual {v0}, Landroid/support/v4/util/SimpleArrayMap;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 250
    iget v0, p0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->g:I

    invoke-virtual {p0, v0}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->stopSelf(I)V

    :cond_0
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 254
    :goto_0
    return-void

    .line 231
    :cond_1
    :try_start_2
    invoke-virtual {p1}, Lcom/firebase/jobdispatcher/JobInvocation;->e()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v4/util/SimpleArrayMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/firebase/jobdispatcher/JobCallback;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 232
    if-nez v1, :cond_3

    .line 248
    :try_start_3
    sget-object v0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->h:Landroid/support/v4/util/SimpleArrayMap;

    invoke-virtual {v0}, Landroid/support/v4/util/SimpleArrayMap;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 250
    iget v0, p0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->g:I

    invoke-virtual {p0, v0}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->stopSelf(I)V

    :cond_2
    monitor-exit v2

    goto :goto_0

    .line 253
    :catchall_0
    move-exception v0

    monitor-exit v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    throw v0

    .line 235
    :cond_3
    :try_start_4
    invoke-virtual {v0}, Landroid/support/v4/util/SimpleArrayMap;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 236
    sget-object v0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->h:Landroid/support/v4/util/SimpleArrayMap;

    invoke-virtual {p1}, Lcom/firebase/jobdispatcher/JobInvocation;->i()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/support/v4/util/SimpleArrayMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 239
    :cond_4
    invoke-static {p1, p2}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->a(Lcom/firebase/jobdispatcher/JobParameters;I)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 240
    invoke-direct {p0, p1}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->a(Lcom/firebase/jobdispatcher/JobInvocation;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 248
    :goto_1
    :try_start_5
    sget-object v0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->h:Landroid/support/v4/util/SimpleArrayMap;

    invoke-virtual {v0}, Landroid/support/v4/util/SimpleArrayMap;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 250
    iget v0, p0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->g:I

    invoke-virtual {p0, v0}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->stopSelf(I)V

    .line 253
    :cond_5
    monitor-exit v2
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_0

    .line 242
    :cond_6
    :try_start_6
    const-string v0, "FJD.GooglePlayReceiver"

    const/4 v3, 0x2

    invoke-static {v0, v3}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 243
    const-string v0, "FJD.GooglePlayReceiver"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "sending jobFinished for "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Lcom/firebase/jobdispatcher/JobInvocation;->e()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " = "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 245
    :cond_7
    invoke-static {v1, p2}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->a(Lcom/firebase/jobdispatcher/JobCallback;I)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    goto :goto_1

    .line 248
    :catchall_1
    move-exception v0

    :try_start_7
    sget-object v1, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->h:Landroid/support/v4/util/SimpleArrayMap;

    invoke-virtual {v1}, Landroid/support/v4/util/SimpleArrayMap;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_8

    .line 250
    iget v1, p0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->g:I

    invoke-virtual {p0, v1}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->stopSelf(I)V

    :cond_8
    throw v0
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0
.end method

.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 2

    .prologue
    .line 137
    if-eqz p1, :cond_0

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-lt v0, v1, :cond_0

    const-string v0, "com.google.android.gms.gcm.ACTION_TASK_READY"

    .line 139
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 140
    :cond_0
    const/4 v0, 0x0

    .line 142
    :goto_0
    return-object v0

    :cond_1
    invoke-direct {p0}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->c()Landroid/os/Messenger;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Messenger;->getBinder()Landroid/os/IBinder;

    move-result-object v0

    goto :goto_0
.end method

.method public final onStartCommand(Landroid/content/Intent;II)I
    .locals 3

    .prologue
    const/4 v2, 0x2

    .line 105
    :try_start_0
    invoke-super {p0, p1, p2, p3}, Landroid/app/Service;->onStartCommand(Landroid/content/Intent;II)I

    .line 107
    if-nez p1, :cond_1

    .line 108
    const-string v0, "FJD.GooglePlayReceiver"

    const-string v1, "Null Intent passed, terminating"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_4

    .line 123
    sget-object v1, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->h:Landroid/support/v4/util/SimpleArrayMap;

    monitor-enter v1

    .line 124
    :try_start_1
    iput p3, p0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->g:I

    .line 125
    sget-object v0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->h:Landroid/support/v4/util/SimpleArrayMap;

    invoke-virtual {v0}, Landroid/support/v4/util/SimpleArrayMap;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 126
    iget v0, p0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->g:I

    invoke-virtual {p0, v0}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->stopSelf(I)V

    .line 128
    :cond_0
    monitor-exit v1

    .line 121
    :goto_0
    return v2

    .line 128
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    .line 112
    :cond_1
    :try_start_2
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 113
    const-string v1, "com.google.android.gms.gcm.ACTION_TASK_READY"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 114
    invoke-virtual {p0}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->a()Lcom/firebase/jobdispatcher/ExecutionDelegator;

    move-result-object v0

    invoke-virtual {p0, p1}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->a(Landroid/content/Intent;)Lcom/firebase/jobdispatcher/JobInvocation;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/firebase/jobdispatcher/ExecutionDelegator;->a(Lcom/firebase/jobdispatcher/JobInvocation;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_4

    .line 123
    sget-object v1, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->h:Landroid/support/v4/util/SimpleArrayMap;

    monitor-enter v1

    .line 124
    :try_start_3
    iput p3, p0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->g:I

    .line 125
    sget-object v0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->h:Landroid/support/v4/util/SimpleArrayMap;

    invoke-virtual {v0}, Landroid/support/v4/util/SimpleArrayMap;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 126
    iget v0, p0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->g:I

    invoke-virtual {p0, v0}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->stopSelf(I)V

    .line 128
    :cond_2
    monitor-exit v1

    goto :goto_0

    :catchall_1
    move-exception v0

    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    throw v0

    .line 116
    :cond_3
    :try_start_4
    const-string v1, "com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_4

    move-result v0

    if-eqz v0, :cond_5

    .line 123
    sget-object v1, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->h:Landroid/support/v4/util/SimpleArrayMap;

    monitor-enter v1

    .line 124
    :try_start_5
    iput p3, p0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->g:I

    .line 125
    sget-object v0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->h:Landroid/support/v4/util/SimpleArrayMap;

    invoke-virtual {v0}, Landroid/support/v4/util/SimpleArrayMap;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 126
    iget v0, p0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->g:I

    invoke-virtual {p0, v0}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->stopSelf(I)V

    .line 128
    :cond_4
    monitor-exit v1

    goto :goto_0

    :catchall_2
    move-exception v0

    monitor-exit v1
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    throw v0

    .line 120
    :cond_5
    :try_start_6
    const-string v0, "FJD.GooglePlayReceiver"

    const-string v1, "Unknown action received, terminating"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_4

    .line 123
    sget-object v1, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->h:Landroid/support/v4/util/SimpleArrayMap;

    monitor-enter v1

    .line 124
    :try_start_7
    iput p3, p0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->g:I

    .line 125
    sget-object v0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->h:Landroid/support/v4/util/SimpleArrayMap;

    invoke-virtual {v0}, Landroid/support/v4/util/SimpleArrayMap;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 126
    iget v0, p0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->g:I

    invoke-virtual {p0, v0}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->stopSelf(I)V

    .line 128
    :cond_6
    monitor-exit v1

    goto :goto_0

    :catchall_3
    move-exception v0

    monitor-exit v1
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_3

    throw v0

    .line 123
    :catchall_4
    move-exception v0

    sget-object v1, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->h:Landroid/support/v4/util/SimpleArrayMap;

    monitor-enter v1

    .line 124
    :try_start_8
    iput p3, p0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->g:I

    .line 125
    sget-object v2, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->h:Landroid/support/v4/util/SimpleArrayMap;

    invoke-virtual {v2}, Landroid/support/v4/util/SimpleArrayMap;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_7

    .line 126
    iget v2, p0, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->g:I

    invoke-virtual {p0, v2}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->stopSelf(I)V

    .line 128
    :cond_7
    monitor-exit v1
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_5

    throw v0

    :catchall_5
    move-exception v0

    :try_start_9
    monitor-exit v1
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_5

    throw v0
.end method
