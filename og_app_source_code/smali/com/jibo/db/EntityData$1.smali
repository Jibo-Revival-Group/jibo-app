.class Lcom/jibo/db/EntityData$1;
.super Ljava/lang/Object;
.source "EntityData.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/db/EntityData;->a(Lcom/jibo/aws/integration/aws/services/account/model/Account;ZLcom/amazonaws/handlers/AsyncHandler;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazonaws/handlers/AsyncHandler",
        "<",
        "Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;",
        "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/amazonaws/handlers/AsyncHandler;

.field final synthetic b:Lcom/jibo/aws/integration/aws/services/account/model/Account;

.field final synthetic c:Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;

.field final synthetic d:Lcom/jibo/db/EntityData;


# direct methods
.method constructor <init>(Lcom/jibo/db/EntityData;Lcom/amazonaws/handlers/AsyncHandler;Lcom/jibo/aws/integration/aws/services/account/model/Account;Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;)V
    .locals 0

    .prologue
    .line 517
    iput-object p1, p0, Lcom/jibo/db/EntityData$1;->d:Lcom/jibo/db/EntityData;

    iput-object p2, p0, Lcom/jibo/db/EntityData$1;->a:Lcom/amazonaws/handlers/AsyncHandler;

    iput-object p3, p0, Lcom/jibo/db/EntityData$1;->b:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    iput-object p4, p0, Lcom/jibo/db/EntityData$1;->c:Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
    .locals 5

    .prologue
    const/4 v2, 0x1

    .line 526
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 528
    const-string v1, "type"

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 529
    const-string v1, "retrieved"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 530
    const-string v1, "modified"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 531
    iget-object v1, p0, Lcom/jibo/db/EntityData$1;->b:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1, p2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->update(Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    .line 532
    const-string v1, "_id"

    iget-object v2, p0, Lcom/jibo/db/EntityData$1;->b:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 533
    const-string v1, "data"

    invoke-static {}, Lcom/jibo/db/EntityData;->k()Lcom/google/gson/Gson;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/db/EntityData$1;->b:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v2, v3}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 537
    :try_start_0
    invoke-static {}, Lcom/jibo/db/EntityData;->l()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {v2}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(I)Landroid/net/Uri;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v1, v2, v0, v3, v4}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 540
    iget-object v0, p0, Lcom/jibo/db/EntityData$1;->d:Lcom/jibo/db/EntityData;

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Lcom/jibo/db/EntityData;)V

    .line 543
    iget-object v0, p0, Lcom/jibo/db/EntityData$1;->a:Lcom/amazonaws/handlers/AsyncHandler;

    if-eqz v0, :cond_0

    .line 544
    iget-object v0, p0, Lcom/jibo/db/EntityData$1;->a:Lcom/amazonaws/handlers/AsyncHandler;

    iget-object v1, p0, Lcom/jibo/db/EntityData$1;->c:Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;

    iget-object v2, p0, Lcom/jibo/db/EntityData$1;->b:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-interface {v0, v1, v2}, Lcom/amazonaws/handlers/AsyncHandler;->onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 550
    :cond_0
    :goto_0
    return-void

    .line 545
    :catch_0
    move-exception v0

    .line 546
    :try_start_1
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 547
    :catchall_0
    move-exception v0

    throw v0
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 1

    .prologue
    .line 520
    iget-object v0, p0, Lcom/jibo/db/EntityData$1;->a:Lcom/amazonaws/handlers/AsyncHandler;

    if-eqz v0, :cond_0

    .line 521
    iget-object v0, p0, Lcom/jibo/db/EntityData$1;->a:Lcom/amazonaws/handlers/AsyncHandler;

    invoke-interface {v0, p1}, Lcom/amazonaws/handlers/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 522
    :cond_0
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 517
    check-cast p1, Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/db/EntityData$1;->a(Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    return-void
.end method
