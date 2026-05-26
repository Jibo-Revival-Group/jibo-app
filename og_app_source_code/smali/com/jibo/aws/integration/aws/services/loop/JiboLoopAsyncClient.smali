.class public Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;
.super Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;"
    }
.end annotation


# direct methods
.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentials;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentials;Lcom/amazonaws/ClientConfiguration;)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;Lcom/amazonaws/ClientConfiguration;)V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentialsProvider;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentialsProvider;)V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;)V

    return-void
.end method


# virtual methods
.method public acceptInvitation(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->acceptInvitation(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    return-object v0
.end method

.method public acceptInvitation(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/AcceptLoopInvitationRequest;",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$11;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$11;-><init>(Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public createLoop(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->createLoop(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    return-object v0
.end method

.method public createLoop(Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/CreateRequest;",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$17;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$17;-><init>(Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public declineInvitation(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->declineInvitation(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    return-object v0
.end method

.method public declineInvitation(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/DeclineLoopInvitationRequest;",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$12;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$12;-><init>(Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getJiboClient()Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;

    move-result-object v0

    return-object v0
.end method

.method public getJiboClient()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;
    .locals 1

    invoke-super {p0}, Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;

    return-object v0
.end method

.method public bridge synthetic getJiboClient()Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;

    move-result-object v0

    return-object v0
.end method

.method public getRobot(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/RobotAccount;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->getRobot(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/RobotAccount;

    move-result-object v0

    return-object v0
.end method

.method public getRobot(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/GetRobotRequest;",
            "Lcom/jibo/aws/integration/aws/services/loop/model/RobotAccount;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/RobotAccount;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$9;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$9;-><init>(Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public inviteMember(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 9

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;

    move-result-object v0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    move-object v6, p6

    move-object/from16 v7, p7

    move-object/from16 v8, p8

    invoke-virtual/range {v0 .. v8}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->inviteMember(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    return-object v0
.end method

.method public inviteMember(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;",
            "Ljava/lang/Long;",
            "Ljava/lang/Boolean;",
            "Ljava/lang/Boolean;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/InviteMemberRequest;",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v11

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$1;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object/from16 v5, p4

    move-object/from16 v6, p5

    move-object/from16 v7, p6

    move-object/from16 v8, p7

    move-object/from16 v9, p8

    move-object/from16 v10, p9

    invoke-direct/range {v0 .. v10}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$1;-><init>(Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v11, v0}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public listLoops()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->listLoops()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public listLoops(Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/ListRequest;",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;>;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;>;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$18;

    invoke-direct {v1, p0, p1}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$18;-><init>(Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public listMembers(Ljava/util/List;Ljava/util/List;)Ljava/util/List;
    .locals 1
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
            "Lcom/jibo/aws/integration/aws/services/loop/model/Member;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->listMembers(Ljava/util/List;Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public listMembers(Ljava/util/List;Ljava/util/List;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
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
            ">;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/ListMembersRequest;",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Member;",
            ">;>;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Member;",
            ">;>;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$13;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$13;-><init>(Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;Ljava/util/List;Ljava/util/List;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public listOwnerRobots(Ljava/lang/String;)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Robot;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->listOwnerRobots(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public listOwnerRobots(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/ListOwnerRobotsRequest;",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Robot;",
            ">;>;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Robot;",
            ">;>;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$16;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$16;-><init>(Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public removeLoop(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->removeLoop(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    return-object v0
.end method

.method public removeLoop(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/RemoveRequest;",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$2;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$2;-><init>(Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public removeMember(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->removeMember(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    return-object v0
.end method

.method public removeMember(Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/RemoveMemberRequest;",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$14;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$14;-><init>(Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public removeMemberPhoto(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->removeMemberPhoto(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    return-object v0
.end method

.method public removeMemberPhoto(Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/RemoveMemberPhotoRequest;",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$8;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$8;-><init>(Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public setLegalGuardian(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->setLegalGuardian(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    move-result-object v0

    return-object v0
.end method

.method public setLegalGuardian(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/SetLegalGuardianRequest;",
            "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v6

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$3;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$3;-><init>(Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v6, v0}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public suspendLoop(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->suspendLoop(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    move-result-object v0

    return-object v0
.end method

.method public suspendLoop(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/SuspendLoopRequest;",
            "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$10;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$10;-><init>(Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public updateLoop(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->updateLoop(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    move-result-object v0

    return-object v0
.end method

.method public updateLoop(Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/UpdateRequest;",
            "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$15;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$15;-><init>(Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public updateMember(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 9

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;

    move-result-object v0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    move-object v6, p6

    move-object/from16 v7, p7

    move-object/from16 v8, p8

    invoke-virtual/range {v0 .. v8}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->updateMember(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    return-object v0
.end method

.method public updateMember(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;Ljava/lang/Long;Ljava/lang/Boolean;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;",
            "Ljava/lang/Long;",
            "Ljava/lang/Boolean;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberRequest;",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v11

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object/from16 v5, p4

    move-object/from16 v6, p5

    move-object/from16 v7, p6

    move-object/from16 v8, p7

    move-object/from16 v9, p8

    move-object/from16 v10, p9

    invoke-direct/range {v0 .. v10}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$6;-><init>(Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;Ljava/lang/Long;Ljava/lang/Boolean;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v11, v0}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public updateMemberPhoto(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->updateMemberPhoto(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    return-object v0
.end method

.method public updateMemberPhoto(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/io/File;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberPhotoRequest;",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v6

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$7;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$7;-><init>(Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v6, v0}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public updateNickname(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->updateNickname(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    move-result-object v0

    return-object v0
.end method

.method public updateNickname(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/UpdateNicknameRequest;",
            "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v6

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$4;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$4;-><init>(Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v6, v0}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public updatePhoneticName(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->updatePhoneticName(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    move-result-object v0

    return-object v0
.end method

.method public updatePhoneticName(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/UpdatePhoneticNameRequest;",
            "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v6

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$5;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient$5;-><init>(Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v6, v0}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method
