.class public Lcom/jibo/service/MediaDeletingService;
.super Landroid/app/IntentService;
.source "MediaDeletingService.java"


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field private b:Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 27
    const-class v0, Lcom/jibo/service/MediaDeletingService;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/service/MediaDeletingService;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 35
    sget-object v0, Lcom/jibo/service/MediaDeletingService;->a:Ljava/lang/String;

    invoke-direct {p0, v0}, Landroid/app/IntentService;-><init>(Ljava/lang/String;)V

    .line 32
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/service/MediaDeletingService;->b:Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;

    .line 36
    return-void
.end method

.method public static a(Landroid/content/Context;Lcom/jibo/aws/integration/aws/services/media/model/Media;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 46
    if-nez p1, :cond_0

    .line 52
    :goto_0
    return-void

    .line 48
    :cond_0
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/jibo/service/MediaDeletingService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 49
    const-string v1, "EXTRA_IDS"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->getPath()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/Intent;

    .line 50
    const-string v1, "EXTRA_FROM_OUTSIDE"

    invoke-virtual {v0, v1, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 51
    invoke-static {p0, v0}, Lcom/jibo/utils/ServiceUtils;->a(Landroid/content/Context;Landroid/content/Intent;)V

    goto :goto_0
.end method

.method public static a(Landroid/content/Context;[Ljava/lang/String;Z)V
    .locals 2

    .prologue
    .line 62
    if-eqz p1, :cond_0

    array-length v0, p1

    if-nez v0, :cond_1

    .line 68
    :cond_0
    :goto_0
    return-void

    .line 64
    :cond_1
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/jibo/service/MediaDeletingService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 65
    const-string v1, "EXTRA_IDS"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/Intent;

    .line 66
    const-string v1, "EXTRA_FROM_OUTSIDE"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 67
    invoke-static {p0, v0}, Lcom/jibo/utils/ServiceUtils;->a(Landroid/content/Context;Landroid/content/Intent;)V

    goto :goto_0
.end method


# virtual methods
.method public onCreate()V
    .locals 0

    .prologue
    .line 73
    invoke-super {p0}, Landroid/app/IntentService;->onCreate()V

    .line 74
    invoke-static {p0}, Lcom/jibo/utils/ServiceUtils;->a(Landroid/app/Service;)V

    .line 75
    return-void
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 80
    invoke-super {p0}, Landroid/app/IntentService;->onDestroy()V

    .line 81
    invoke-static {p0}, Lcom/jibo/utils/ServiceUtils;->b(Landroid/app/Service;)V

    .line 82
    return-void
.end method

.method protected onHandleIntent(Landroid/content/Intent;)V
    .locals 8

    .prologue
    const/4 v0, 0x0

    .line 86
    const-string v1, "EXTRA_IDS"

    invoke-virtual {p1, v1}, Landroid/content/Intent;->getStringArrayExtra(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 87
    const-string v1, "EXTRA_FROM_OUTSIDE"

    invoke-virtual {p1, v1, v0}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v3

    .line 89
    if-eqz v2, :cond_0

    array-length v1, v2

    if-nez v1, :cond_1

    .line 135
    :cond_0
    :goto_0
    return-void

    .line 91
    :cond_1
    sget-object v1, Lcom/jibo/service/MediaDeletingService;->a:Ljava/lang/String;

    const-string v4, "onHandleIntent-start"

    invoke-static {v1, v4}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 93
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 95
    :try_start_0
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v5

    move v1, v0

    .line 97
    :goto_1
    array-length v0, v2

    if-ge v1, v0, :cond_7

    .line 99
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    aget-object v6, v2, v1

    invoke-virtual {v0, v6}, Lcom/jibo/db/EntityData;->e(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/media/model/Media;

    move-result-object v0

    .line 101
    if-nez v0, :cond_2

    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    aget-object v6, v2, v1

    invoke-virtual {v0, v6}, Lcom/jibo/db/EntityData;->d(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/media/model/Media;

    move-result-object v0

    .line 103
    :cond_2
    if-eqz v0, :cond_5

    .line 105
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v6

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->getLoopId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/jibo/db/EntityData;->c(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v6

    .line 106
    if-nez v3, :cond_3

    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isOwner(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_3

    .line 107
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->getAccountId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 108
    :cond_3
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->getPath()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 109
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->getReference()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_4

    .line 110
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->getReference()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v4, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 97
    :cond_4
    :goto_2
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_1

    .line 114
    :cond_5
    aget-object v0, v2, v1

    invoke-interface {v4, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_2

    .line 127
    :catch_0
    move-exception v0

    .line 128
    :try_start_1
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 130
    iget-object v0, p0, Lcom/jibo/service/MediaDeletingService;->b:Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;

    if-eqz v0, :cond_6

    .line 131
    iget-object v0, p0, Lcom/jibo/service/MediaDeletingService;->b:Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;->shutdown()V

    .line 134
    :cond_6
    :goto_3
    sget-object v0, Lcom/jibo/service/MediaDeletingService;->a:Ljava/lang/String;

    const-string v1, "onHandleIntent-end"

    invoke-static {v0, v1}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 118
    :cond_7
    :try_start_2
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0, v4}, Lcom/jibo/db/EntityData;->a(Ljava/util/List;)V

    .line 120
    if-nez v3, :cond_8

    invoke-interface {v4}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_8

    .line 122
    new-instance v0, Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;

    new-instance v1, Lcom/amazonaws/auth/BasicAWSCredentials;

    .line 123
    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v2

    .line 124
    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v0, v1}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    iput-object v0, p0, Lcom/jibo/service/MediaDeletingService;->b:Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;

    .line 125
    iget-object v0, p0, Lcom/jibo/service/MediaDeletingService;->b:Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;

    invoke-virtual {v0, v4}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;->remove(Ljava/util/List;)Ljava/util/List;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 130
    :cond_8
    iget-object v0, p0, Lcom/jibo/service/MediaDeletingService;->b:Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;

    if-eqz v0, :cond_6

    .line 131
    iget-object v0, p0, Lcom/jibo/service/MediaDeletingService;->b:Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;->shutdown()V

    goto :goto_3

    .line 130
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/jibo/service/MediaDeletingService;->b:Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;

    if-eqz v1, :cond_9

    .line 131
    iget-object v1, p0, Lcom/jibo/service/MediaDeletingService;->b:Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;->shutdown()V

    :cond_9
    throw v0
.end method
