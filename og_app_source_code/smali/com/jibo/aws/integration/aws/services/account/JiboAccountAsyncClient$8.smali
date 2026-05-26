.class Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$8;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->createAccessToken(Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
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
        "Lcom/jibo/aws/integration/aws/services/account/model/TokenContainer;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/amazonaws/handlers/AsyncHandler;

.field final synthetic b:Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;


# direct methods
.method constructor <init>(Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;Lcom/amazonaws/handlers/AsyncHandler;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$8;->b:Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    iput-object p2, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$8;->a:Lcom/amazonaws/handlers/AsyncHandler;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()Lcom/jibo/aws/integration/aws/services/account/model/TokenContainer;
    .locals 3

    :try_start_0
    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$8;->b:Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->createAccessToken()Lcom/jibo/aws/integration/aws/services/account/model/TokenContainer;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$8;->a:Lcom/amazonaws/handlers/AsyncHandler;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$8;->a:Lcom/amazonaws/handlers/AsyncHandler;

    new-instance v2, Lcom/jibo/aws/integration/aws/services/account/model/CreateAccessTokenRequest;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/account/model/CreateAccessTokenRequest;-><init>()V

    invoke-interface {v1, v2, v0}, Lcom/amazonaws/handlers/AsyncHandler;->onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V

    :cond_0
    return-object v0

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$8;->a:Lcom/amazonaws/handlers/AsyncHandler;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$8;->a:Lcom/amazonaws/handlers/AsyncHandler;

    invoke-interface {v1, v0}, Lcom/amazonaws/handlers/AsyncHandler;->onError(Ljava/lang/Exception;)V

    :cond_1
    throw v0
.end method

.method public synthetic call()Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$8;->a()Lcom/jibo/aws/integration/aws/services/account/model/TokenContainer;

    move-result-object v0

    return-object v0
.end method
