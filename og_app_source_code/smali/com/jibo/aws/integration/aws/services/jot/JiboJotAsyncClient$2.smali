.class Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient$2;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient;->listMessages(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
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
        "Ljava/util/List",
        "<",
        "Lcom/jibo/aws/integration/aws/services/jot/model/Message;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Ljava/lang/Long;

.field final synthetic c:Ljava/lang/Long;

.field final synthetic d:Lcom/amazonaws/handlers/AsyncHandler;

.field final synthetic e:Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient;


# direct methods
.method constructor <init>(Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lcom/amazonaws/handlers/AsyncHandler;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient$2;->e:Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient;

    iput-object p2, p0, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient$2;->a:Ljava/lang/String;

    iput-object p3, p0, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient$2;->b:Ljava/lang/Long;

    iput-object p4, p0, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient$2;->c:Ljava/lang/Long;

    iput-object p5, p0, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient$2;->d:Lcom/amazonaws/handlers/AsyncHandler;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()Ljava/util/List;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/jot/model/Message;",
            ">;"
        }
    .end annotation

    :try_start_0
    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient$2;->e:Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient;

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient$2;->a:Ljava/lang/String;

    iget-object v2, p0, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient$2;->b:Ljava/lang/Long;

    iget-object v3, p0, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient$2;->c:Ljava/lang/Long;

    invoke-virtual {v0, v1, v2, v3}, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient;->listMessages(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient$2;->d:Lcom/amazonaws/handlers/AsyncHandler;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient$2;->d:Lcom/amazonaws/handlers/AsyncHandler;

    new-instance v2, Lcom/jibo/aws/integration/aws/services/jot/model/ListMessagesRequest;

    iget-object v3, p0, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient$2;->a:Ljava/lang/String;

    iget-object v4, p0, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient$2;->b:Ljava/lang/Long;

    iget-object v5, p0, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient$2;->c:Ljava/lang/Long;

    invoke-direct {v2, v3, v4, v5}, Lcom/jibo/aws/integration/aws/services/jot/model/ListMessagesRequest;-><init>(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V

    invoke-interface {v1, v2, v0}, Lcom/amazonaws/handlers/AsyncHandler;->onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V

    :cond_0
    return-object v0

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient$2;->d:Lcom/amazonaws/handlers/AsyncHandler;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient$2;->d:Lcom/amazonaws/handlers/AsyncHandler;

    invoke-interface {v1, v0}, Lcom/amazonaws/handlers/AsyncHandler;->onError(Ljava/lang/Exception;)V

    :cond_1
    throw v0
.end method

.method public synthetic call()Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient$2;->a()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method
