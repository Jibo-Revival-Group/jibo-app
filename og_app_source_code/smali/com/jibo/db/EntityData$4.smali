.class Lcom/jibo/db/EntityData$4;
.super Ljava/lang/Object;
.source "EntityData.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/db/EntityData;->a(Lcom/jibo/aws/integration/util/Commons$AsyncCallback;)V
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
        "Lcom/jibo/aws/integration/aws/services/account/model/GetRequest;",
        "Ljava/util/List",
        "<",
        "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/util/Commons$AsyncCallback;

.field final synthetic b:Lcom/jibo/db/EntityData;


# direct methods
.method constructor <init>(Lcom/jibo/db/EntityData;Lcom/jibo/aws/integration/util/Commons$AsyncCallback;)V
    .locals 0

    .prologue
    .line 1535
    iput-object p1, p0, Lcom/jibo/db/EntityData$4;->b:Lcom/jibo/db/EntityData;

    iput-object p2, p0, Lcom/jibo/db/EntityData$4;->a:Lcom/jibo/aws/integration/util/Commons$AsyncCallback;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/account/model/GetRequest;Ljava/util/List;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/jibo/aws/integration/aws/services/account/model/GetRequest;",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 1543
    iget-object v1, p0, Lcom/jibo/db/EntityData$4;->b:Lcom/jibo/db/EntityData;

    invoke-interface {p2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    const/4 v2, 0x0

    invoke-virtual {v1, v0, v4, v2}, Lcom/jibo/db/EntityData;->a(Lcom/jibo/aws/integration/aws/services/account/model/Account;ZLcom/amazonaws/handlers/AsyncHandler;)V

    .line 1546
    invoke-interface {p2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->isActive()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1548
    :try_start_0
    iget-object v0, p0, Lcom/jibo/db/EntityData$4;->b:Lcom/jibo/db/EntityData;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/jibo/db/EntityData;->a(Z)Ljava/util/List;

    move-result-object v0

    .line 1549
    iget-object v1, p0, Lcom/jibo/db/EntityData$4;->a:Lcom/jibo/aws/integration/util/Commons$AsyncCallback;

    invoke-interface {v1, v0}, Lcom/jibo/aws/integration/util/Commons$AsyncCallback;->onSuccess(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1556
    :goto_0
    return-void

    .line 1550
    :catch_0
    move-exception v0

    .line 1551
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    .line 1552
    iget-object v1, p0, Lcom/jibo/db/EntityData$4;->a:Lcom/jibo/aws/integration/util/Commons$AsyncCallback;

    invoke-interface {v1, v0}, Lcom/jibo/aws/integration/util/Commons$AsyncCallback;->onError(Ljava/lang/Exception;)V

    goto :goto_0

    .line 1555
    :cond_0
    iget-object v0, p0, Lcom/jibo/db/EntityData$4;->a:Lcom/jibo/aws/integration/util/Commons$AsyncCallback;

    invoke-interface {p2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/jibo/aws/integration/util/Commons$AsyncCallback;->onSuccess(Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 1

    .prologue
    .line 1538
    iget-object v0, p0, Lcom/jibo/db/EntityData$4;->a:Lcom/jibo/aws/integration/util/Commons$AsyncCallback;

    invoke-interface {v0, p1}, Lcom/jibo/aws/integration/util/Commons$AsyncCallback;->onError(Ljava/lang/Exception;)V

    .line 1539
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1535
    check-cast p1, Lcom/jibo/aws/integration/aws/services/account/model/GetRequest;

    check-cast p2, Ljava/util/List;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/db/EntityData$4;->a(Lcom/jibo/aws/integration/aws/services/account/model/GetRequest;Ljava/util/List;)V

    return-void
.end method
