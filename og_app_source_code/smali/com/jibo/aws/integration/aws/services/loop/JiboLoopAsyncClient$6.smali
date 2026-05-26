.class Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->updateMember(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;Ljava/lang/Long;Ljava/lang/Boolean;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
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
        "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Ljava/lang/String;

.field final synthetic c:Ljava/lang/String;

.field final synthetic d:Ljava/lang/String;

.field final synthetic e:Ljava/lang/String;

.field final synthetic f:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

.field final synthetic g:Ljava/lang/Long;

.field final synthetic h:Ljava/lang/Boolean;

.field final synthetic i:Lcom/amazonaws/handlers/AsyncHandler;

.field final synthetic j:Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;


# direct methods
.method constructor <init>(Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;Ljava/lang/Long;Ljava/lang/Boolean;Lcom/amazonaws/handlers/AsyncHandler;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->j:Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    iput-object p2, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->a:Ljava/lang/String;

    iput-object p3, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->b:Ljava/lang/String;

    iput-object p4, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->c:Ljava/lang/String;

    iput-object p5, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->d:Ljava/lang/String;

    iput-object p6, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->e:Ljava/lang/String;

    iput-object p7, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->f:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    iput-object p8, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->g:Ljava/lang/Long;

    iput-object p9, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->h:Ljava/lang/Boolean;

    iput-object p10, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->i:Lcom/amazonaws/handlers/AsyncHandler;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 11

    :try_start_0
    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->j:Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->a:Ljava/lang/String;

    iget-object v2, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->b:Ljava/lang/String;

    iget-object v3, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->c:Ljava/lang/String;

    iget-object v4, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->d:Ljava/lang/String;

    iget-object v5, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->e:Ljava/lang/String;

    iget-object v6, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->f:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    iget-object v7, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->g:Ljava/lang/Long;

    iget-object v8, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->h:Ljava/lang/Boolean;

    invoke-virtual/range {v0 .. v8}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->updateMember(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v9

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->i:Lcom/amazonaws/handlers/AsyncHandler;

    if-eqz v0, :cond_0

    iget-object v10, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->i:Lcom/amazonaws/handlers/AsyncHandler;

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberRequest;

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->a:Ljava/lang/String;

    iget-object v2, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->b:Ljava/lang/String;

    iget-object v3, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->c:Ljava/lang/String;

    iget-object v4, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->d:Ljava/lang/String;

    iget-object v5, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->e:Ljava/lang/String;

    iget-object v6, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->f:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    iget-object v7, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->g:Ljava/lang/Long;

    iget-object v8, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->h:Ljava/lang/Boolean;

    invoke-direct/range {v0 .. v8}, Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;Ljava/lang/Long;Ljava/lang/Boolean;)V

    invoke-interface {v10, v0, v9}, Lcom/amazonaws/handlers/AsyncHandler;->onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V

    :cond_0
    return-object v9

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->i:Lcom/amazonaws/handlers/AsyncHandler;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->i:Lcom/amazonaws/handlers/AsyncHandler;

    invoke-interface {v1, v0}, Lcom/amazonaws/handlers/AsyncHandler;->onError(Ljava/lang/Exception;)V

    :cond_1
    throw v0
.end method

.method public synthetic call()Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;->a()Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    return-object v0
.end method
