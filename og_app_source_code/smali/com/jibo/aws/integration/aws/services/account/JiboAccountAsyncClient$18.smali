.class Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$18;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->update(Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable",
        "<",
        "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;

.field final synthetic b:Lcom/amazonaws/handlers/AsyncHandler;

.field final synthetic c:Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;


# direct methods
.method constructor <init>(Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;Lcom/amazonaws/handlers/AsyncHandler;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$18;->c:Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    iput-object p2, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$18;->a:Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;

    iput-object p3, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$18;->b:Lcom/amazonaws/handlers/AsyncHandler;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 3

    :try_start_0
    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$18;->c:Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$18;->a:Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->update(Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;)Lcom/jibo/aws/integration/aws/services/account/model/Account;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$18;->b:Lcom/amazonaws/handlers/AsyncHandler;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$18;->b:Lcom/amazonaws/handlers/AsyncHandler;

    iget-object v2, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$18;->a:Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;

    invoke-interface {v1, v2, v0}, Lcom/amazonaws/handlers/AsyncHandler;->onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V

    :cond_0
    return-object v0

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$18;->b:Lcom/amazonaws/handlers/AsyncHandler;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$18;->b:Lcom/amazonaws/handlers/AsyncHandler;

    invoke-interface {v1, v0}, Lcom/amazonaws/handlers/AsyncHandler;->onError(Ljava/lang/Exception;)V

    :cond_1
    throw v0
.end method

.method public synthetic call()Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$18;->a()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    return-object v0
.end method
