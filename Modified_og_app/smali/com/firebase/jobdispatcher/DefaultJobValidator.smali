.class public Lcom/firebase/jobdispatcher/DefaultJobValidator;
.super Ljava/lang/Object;
.source "DefaultJobValidator.java"

# interfaces
.implements Lcom/firebase/jobdispatcher/JobValidator;


# instance fields
.field private final a:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 61
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 62
    iput-object p1, p0, Lcom/firebase/jobdispatcher/DefaultJobValidator;->a:Landroid/content/Context;

    .line 63
    return-void
.end method

.method private static a(Landroid/os/Bundle;)I
    .locals 2

    .prologue
    .line 67
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 68
    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Landroid/os/Bundle;->writeToParcel(Landroid/os/Parcel;I)V

    .line 69
    invoke-virtual {v0}, Landroid/os/Parcel;->dataSize()I

    move-result v1

    .line 70
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 72
    return v1
.end method

.method private static a(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;
    .locals 6

    .prologue
    const/4 v0, 0x0

    .line 230
    invoke-virtual {p0, p1}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    .line 232
    if-eqz v1, :cond_0

    instance-of v2, v1, Ljava/lang/Integer;

    if-nez v2, :cond_0

    instance-of v2, v1, Ljava/lang/Long;

    if-nez v2, :cond_0

    instance-of v2, v1, Ljava/lang/Double;

    if-nez v2, :cond_0

    instance-of v2, v1, Ljava/lang/String;

    if-nez v2, :cond_0

    instance-of v2, v1, Ljava/lang/Boolean;

    if-eqz v2, :cond_1

    .line 241
    :cond_0
    :goto_0
    return-object v0

    :cond_1
    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    const-string v3, "Received value of type \'%s\' for key \'%s\', but only the following extra parameter types are supported: Integer, Long, Double, String, and Boolean"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    if-nez v1, :cond_2

    .line 246
    :goto_1
    aput-object v0, v4, v5

    const/4 v0, 0x1

    aput-object p1, v4, v0

    .line 241
    invoke-static {v2, v3, v4}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 246
    :cond_2
    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    goto :goto_1
.end method

.method private static a(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 92
    if-nez p1, :cond_0

    .line 101
    :goto_0
    return-object p0

    .line 95
    :cond_0
    if-nez p0, :cond_1

    .line 96
    invoke-static {p1}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->c(Ljava/lang/String;)Ljava/util/List;

    move-result-object p0

    goto :goto_0

    .line 99
    :cond_1
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    aput-object p1, v0, v1

    invoke-static {p0, v0}, Ljava/util/Collections;->addAll(Ljava/util/Collection;[Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method private static a(Ljava/util/List;Ljava/util/List;)Ljava/util/List;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 79
    if-nez p0, :cond_1

    move-object p0, p1

    .line 87
    :cond_0
    :goto_0
    return-object p0

    .line 82
    :cond_1
    if-eqz p1, :cond_0

    .line 86
    invoke-interface {p0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    goto :goto_0
.end method

.method private static a(ZLjava/util/List;Ljava/lang/String;)Ljava/util/List;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 106
    if-eqz p0, :cond_0

    .line 107
    invoke-static {p1, p2}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->a(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;

    move-result-object p1

    .line 110
    :cond_0
    return-object p1
.end method

.method private static b(Landroid/os/Bundle;)Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Bundle;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 197
    const/4 v0, 0x0

    .line 199
    if-eqz p0, :cond_0

    .line 201
    invoke-virtual {p0}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    move-object v1, v0

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 202
    invoke-static {p0, v0}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->a(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->a(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    move-object v1, v0

    .line 203
    goto :goto_0

    :cond_0
    move-object v1, v0

    .line 206
    :cond_1
    return-object v1
.end method

.method private static b(Ljava/lang/String;)Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 290
    if-nez p0, :cond_0

    .line 291
    const-string v0, "Tag can\'t be null"

    invoke-static {v0}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->c(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 298
    :goto_0
    return-object v0

    .line 294
    :cond_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0x64

    if-le v0, v1, :cond_1

    .line 295
    const-string v0, "Tag must be shorter than 100"

    invoke-static {v0}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->c(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    goto :goto_0

    .line 298
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static c(Landroid/os/Bundle;)Ljava/util/List;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Bundle;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    const/16 v5, 0x2800

    .line 211
    if-nez p0, :cond_1

    .line 225
    :cond_0
    :goto_0
    return-object v0

    .line 215
    :cond_1
    invoke-static {p0}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->a(Landroid/os/Bundle;)I

    move-result v1

    .line 216
    if-le v1, v5, :cond_0

    .line 217
    sget-object v0, Ljava/util/Locale;->US:Ljava/util/Locale;

    const-string v2, "Extras too large: %d bytes is > the max (%d bytes)"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    .line 221
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v3, v4

    const/4 v1, 0x1

    .line 222
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v1

    .line 218
    invoke-static {v0, v2, v3}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 217
    invoke-static {v0}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->c(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    goto :goto_0
.end method

.method private static c(Ljava/lang/String;)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 303
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 304
    invoke-virtual {v0, p0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 305
    return-object v0
.end method


# virtual methods
.method public a(Lcom/firebase/jobdispatcher/JobParameters;)Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/firebase/jobdispatcher/JobParameters;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 121
    const/4 v0, 0x0

    .line 123
    invoke-interface {p1}, Lcom/firebase/jobdispatcher/JobParameters;->f()Lcom/firebase/jobdispatcher/JobTrigger;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->a(Lcom/firebase/jobdispatcher/JobTrigger;)Ljava/util/List;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->a(Ljava/util/List;Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    .line 124
    invoke-interface {p1}, Lcom/firebase/jobdispatcher/JobParameters;->c()Lcom/firebase/jobdispatcher/RetryStrategy;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->a(Lcom/firebase/jobdispatcher/RetryStrategy;)Ljava/util/List;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->a(Ljava/util/List;Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    .line 126
    invoke-interface {p1}, Lcom/firebase/jobdispatcher/JobParameters;->h()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {p1}, Lcom/firebase/jobdispatcher/JobParameters;->f()Lcom/firebase/jobdispatcher/JobTrigger;

    move-result-object v1

    sget-object v2, Lcom/firebase/jobdispatcher/Trigger;->a:Lcom/firebase/jobdispatcher/JobTrigger$ImmediateTrigger;

    if-ne v1, v2, :cond_0

    .line 127
    const-string v1, "ImmediateTriggers can\'t be used with recurring jobs"

    invoke-static {v0, v1}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->a(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 130
    :cond_0
    invoke-interface {p1}, Lcom/firebase/jobdispatcher/JobParameters;->b()Landroid/os/Bundle;

    move-result-object v1

    invoke-static {v1}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->c(Landroid/os/Bundle;)Ljava/util/List;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->a(Ljava/util/List;Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    .line 131
    invoke-interface {p1}, Lcom/firebase/jobdispatcher/JobParameters;->g()I

    move-result v1

    const/4 v2, 0x1

    if-le v1, v2, :cond_1

    .line 133
    invoke-interface {p1}, Lcom/firebase/jobdispatcher/JobParameters;->b()Landroid/os/Bundle;

    move-result-object v1

    invoke-static {v1}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->b(Landroid/os/Bundle;)Ljava/util/List;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->a(Ljava/util/List;Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    .line 136
    :cond_1
    invoke-interface {p1}, Lcom/firebase/jobdispatcher/JobParameters;->e()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->b(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->a(Ljava/util/List;Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    .line 137
    invoke-interface {p1}, Lcom/firebase/jobdispatcher/JobParameters;->i()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->a(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->a(Ljava/util/List;Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    .line 139
    return-object v0
.end method

.method public a(Lcom/firebase/jobdispatcher/JobTrigger;)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/firebase/jobdispatcher/JobTrigger;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 155
    sget-object v0, Lcom/firebase/jobdispatcher/Trigger;->a:Lcom/firebase/jobdispatcher/JobTrigger$ImmediateTrigger;

    if-eq p1, v0, :cond_0

    instance-of v0, p1, Lcom/firebase/jobdispatcher/JobTrigger$ExecutionWindowTrigger;

    if-nez v0, :cond_0

    instance-of v0, p1, Lcom/firebase/jobdispatcher/JobTrigger$ContentUriTrigger;

    if-nez v0, :cond_0

    .line 158
    const-string v0, "Unknown trigger provided"

    invoke-static {v0}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->c(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 161
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public a(Lcom/firebase/jobdispatcher/RetryStrategy;)Ljava/util/List;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/firebase/jobdispatcher/RetryStrategy;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 172
    const/4 v3, 0x0

    .line 174
    invoke-virtual {p1}, Lcom/firebase/jobdispatcher/RetryStrategy;->a()I

    move-result v0

    .line 175
    invoke-virtual {p1}, Lcom/firebase/jobdispatcher/RetryStrategy;->b()I

    move-result v4

    .line 176
    invoke-virtual {p1}, Lcom/firebase/jobdispatcher/RetryStrategy;->c()I

    move-result v5

    .line 178
    if-eq v0, v1, :cond_0

    const/4 v6, 0x2

    if-eq v0, v6, :cond_0

    move v0, v1

    :goto_0
    const-string v6, "Unknown retry policy provided"

    .line 179
    invoke-static {v0, v3, v6}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->a(ZLjava/util/List;Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    .line 183
    if-ge v5, v4, :cond_1

    move v0, v1

    :goto_1
    const-string v6, "Maximum backoff must be greater than or equal to initial backoff"

    .line 184
    invoke-static {v0, v3, v6}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->a(ZLjava/util/List;Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    .line 188
    const/16 v0, 0x12c

    if-le v0, v5, :cond_2

    move v0, v1

    :goto_2
    const-string v5, "Maximum backoff must be greater than 300s (5 minutes)"

    .line 189
    invoke-static {v0, v3, v5}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->a(ZLjava/util/List;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 190
    const/16 v3, 0x1e

    if-ge v4, v3, :cond_3

    :goto_3
    const-string v2, "Initial backoff must be at least 30s"

    invoke-static {v1, v0, v2}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->a(ZLjava/util/List;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 192
    return-object v0

    :cond_0
    move v0, v2

    .line 178
    goto :goto_0

    :cond_1
    move v0, v2

    .line 183
    goto :goto_1

    :cond_2
    move v0, v2

    .line 188
    goto :goto_2

    :cond_3
    move v1, v2

    .line 190
    goto :goto_3
.end method

.method a(Ljava/lang/String;)Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 252
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 253
    :cond_0
    const-string v0, "Service can\'t be empty"

    invoke-static {v0}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->c(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 286
    :goto_0
    return-object v0

    .line 256
    :cond_1
    iget-object v0, p0, Lcom/firebase/jobdispatcher/DefaultJobValidator;->a:Landroid/content/Context;

    if-nez v0, :cond_2

    .line 257
    const-string v0, "Context is null, can\'t query PackageManager"

    invoke-static {v0}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->c(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    goto :goto_0

    .line 260
    :cond_2
    iget-object v0, p0, Lcom/firebase/jobdispatcher/DefaultJobValidator;->a:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    .line 261
    if-nez v0, :cond_3

    .line 262
    const-string v0, "PackageManager is null, can\'t validate service"

    invoke-static {v0}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->c(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    goto :goto_0

    .line 265
    :cond_3
    new-instance v2, Landroid/content/Intent;

    const-string v3, "com.firebase.jobdispatcher.ACTION_EXECUTE"

    invoke-direct {v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 266
    iget-object v3, p0, Lcom/firebase/jobdispatcher/DefaultJobValidator;->a:Landroid/content/Context;

    invoke-virtual {v2, v3, p1}, Landroid/content/Intent;->setClassName(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;

    .line 267
    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/content/pm/PackageManager;->queryIntentServices(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    .line 268
    if-eqz v0, :cond_4

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_5

    .line 270
    :cond_4
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Couldn\'t find a registered service with the name "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ". Is it declared in the manifest with the right intent-filter? If not, the job won\'t be started."

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 275
    const-string v2, "FJD.GooglePlayReceiver"

    invoke-static {v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    move-object v0, v1

    .line 276
    goto :goto_0

    .line 279
    :cond_5
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_6
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_7

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/pm/ResolveInfo;

    .line 280
    iget-object v3, v0, Landroid/content/pm/ResolveInfo;->serviceInfo:Landroid/content/pm/ServiceInfo;

    if-eqz v3, :cond_6

    iget-object v0, v0, Landroid/content/pm/ResolveInfo;->serviceInfo:Landroid/content/pm/ServiceInfo;

    iget-boolean v0, v0, Landroid/content/pm/ServiceInfo;->enabled:Z

    if-eqz v0, :cond_6

    move-object v0, v1

    .line 282
    goto :goto_0

    .line 286
    :cond_7
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " is disabled."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/firebase/jobdispatcher/DefaultJobValidator;->c(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    goto/16 :goto_0
.end method
