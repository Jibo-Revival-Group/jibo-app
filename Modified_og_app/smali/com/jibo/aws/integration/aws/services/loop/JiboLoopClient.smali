.class public Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;
.super Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;


# static fields
.field public static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;

    invoke-static {v0}, Lcom/jibo/aws/integration/util/a;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentials;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentials;Lcom/amazonaws/ClientConfiguration;)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;Lcom/amazonaws/ClientConfiguration;)V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentialsProvider;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;-><init>(Lcom/amazonaws/auth/AWSCredentialsProvider;)V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;-><init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;)V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;Lcom/amazonaws/http/HttpClient;)V
    .locals 0

    invoke-direct {p0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;-><init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;Lcom/amazonaws/http/HttpClient;)V

    return-void
.end method


# virtual methods
.method public acceptInvitation(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/model/AcceptLoopInvitationRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/loop/model/AcceptLoopInvitationRequest;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/loop/model/a/b;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/a/b;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method public createLoop(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/model/CreateRequest;

    invoke-direct {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/loop/model/CreateRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/loop/model/a/b;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/a/b;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method public declineInvitation(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/model/DeclineLoopInvitationRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/loop/model/DeclineLoopInvitationRequest;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/loop/model/a/b;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/a/b;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method public getRobot(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/RobotAccount;
    .locals 4

    sget-boolean v0, Lcom/jibo/aws/integration/util/Commons;->IS_MOCK_MODE:Z

    if-eqz v0, :cond_skip_get_robot_account

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/model/RobotAccount;

    invoke-direct {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/RobotAccount;-><init>()V

    const-string v1, "mock-robot-access-key"

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/loop/model/RobotAccount;->setAccessKeyId(Ljava/lang/String;)V

    const-string v1, "mock-robot-secret-access-key"

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/loop/model/RobotAccount;->setSecretAccessKey(Ljava/lang/String;)V

    const-string v1, "mock-friendly-id-1"

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/loop/model/RobotAccount;->setFriendlyId(Ljava/lang/String;)V

    return-object v0

    :cond_skip_get_robot_account

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/model/GetRobotRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/loop/model/GetRobotRequest;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/loop/model/a/e;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/a/e;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/RobotAccount;

    return-object v0
.end method

.method public inviteMember(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 9

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/model/InviteMemberRequest;

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    move-object v6, p6

    move-object/from16 v7, p7

    move-object/from16 v8, p8

    invoke-direct/range {v0 .. v8}, Lcom/jibo/aws/integration/aws/services/loop/model/InviteMemberRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/loop/model/a/b;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/a/b;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method public listLoops()Ljava/util/List;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;"
        }
    .end annotation

    sget-boolean v0, Lcom/jibo/aws/integration/util/Commons;->IS_MOCK_MODE:Z

    if-eqz v0, :cond_skip_list_loops

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    new-instance v1, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;-><init>()V

    const-string v2, "mock-loop-id-1"

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->setId(Ljava/lang/String;)V

    const-string v2, "Jibo Revival Loop"

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->setName(Ljava/lang/String;)V

    const-string v2, "mock-user-1234"

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->setOwner(Ljava/lang/String;)V

    const-string v2, "mock-robot-id-1"

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->setRobot(Ljava/lang/String;)V

    const-string v2, "mock-friendly-id-1"

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->setRobotFriendlyId(Ljava/lang/String;)V

    sget-object v2, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->setSuspended(Ljava/lang/Boolean;)V

    const-wide/16 v2, 0x0

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->setCreated(Ljava/lang/Long;)V

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->setUpdated(Ljava/lang/Long;)V

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    new-instance v3, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-direct {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;-><init>()V

    const-string v4, "mock-user-1234"

    invoke-virtual {v3, v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->setAccountId(Ljava/lang/String;)V

    invoke-virtual {v3, v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->setId(Ljava/lang/String;)V

    const-string v4, "mock-loop-id-1"

    invoke-virtual {v3, v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->setLoopId(Ljava/lang/String;)V

    const-string v4, "Owner"

    invoke-virtual {v3, v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->setNickname(Ljava/lang/String;)V

    sget-object v4, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;->accepted:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    invoke-virtual {v3, v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->setStatus(Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;)V

    new-instance v4, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    invoke-direct {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;-><init>()V

    const-string v5, "jibo@jiborevival.com"

    invoke-virtual {v4, v5}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setEmail(Ljava/lang/String;)V

    const-string v5, "Jibo"

    invoke-virtual {v4, v5}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setFirstName(Ljava/lang/String;)V

    const-string v5, "Revival"

    invoke-virtual {v4, v5}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setLastName(Ljava/lang/String;)V

    sget-object v5, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->other:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    invoke-virtual {v4, v5}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setGender(Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;)V

    const-wide/16 v5, 0x0

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setBirthday(Ljava/lang/Long;)V

    invoke-virtual {v3, v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->setAccount(Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;)V

    new-instance v4, Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;

    invoke-direct {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;-><init>()V

    const/4 v5, 0x1

    invoke-virtual {v4, v5}, Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;->setFace(Z)V

    invoke-virtual {v4, v5}, Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;->setVoice(Z)V

    invoke-virtual {v3, v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->setEnrolled(Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;)V

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    new-instance v3, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-direct {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;-><init>()V

    const-string v4, "mock-robot-id-1"

    invoke-virtual {v3, v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->setAccountId(Ljava/lang/String;)V

    invoke-virtual {v3, v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->setId(Ljava/lang/String;)V

    const-string v4, "mock-loop-id-1"

    invoke-virtual {v3, v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->setLoopId(Ljava/lang/String;)V

    const-string v4, "Jibo"

    invoke-virtual {v3, v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->setNickname(Ljava/lang/String;)V

    sget-object v4, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;->accepted:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    invoke-virtual {v3, v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->setStatus(Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;)V

    new-instance v4, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    invoke-direct {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;-><init>()V

    const-string v5, "robot@jibo.com"

    invoke-virtual {v4, v5}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setEmail(Ljava/lang/String;)V

    const-string v5, "Jibo"

    invoke-virtual {v4, v5}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setFirstName(Ljava/lang/String;)V

    const-string v5, "Robot"

    invoke-virtual {v4, v5}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setLastName(Ljava/lang/String;)V

    sget-object v5, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->other:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    invoke-virtual {v4, v5}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setGender(Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;)V

    const-wide/16 v5, 0x0

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setBirthday(Ljava/lang/Long;)V

    invoke-virtual {v3, v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->setAccount(Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;)V

    new-instance v4, Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;

    invoke-direct {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;-><init>()V

    const/4 v5, 0x1

    invoke-virtual {v4, v5}, Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;->setFace(Z)V

    invoke-virtual {v4, v5}, Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;->setVoice(Z)V

    invoke-virtual {v3, v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->setEnrolled(Lcom/jibo/aws/integration/aws/services/loop/model/Enrolled;)V

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->setMembers(Ljava/util/List;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    return-object v0

    :cond_skip_list_loops
    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/model/ListRequest;

    invoke-direct {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/ListRequest;-><init>()V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/loop/model/a/c;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/a/c;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    return-object v0
.end method

.method public listMembers(Ljava/util/List;Ljava/util/List;)Ljava/util/List;
    .locals 3
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

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/model/ListMembersRequest;

    invoke-direct {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/loop/model/ListMembersRequest;-><init>(Ljava/util/List;Ljava/util/List;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/loop/model/a/d;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/a/d;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    return-object v0
.end method

.method public listOwnerRobots(Ljava/lang/String;)Ljava/util/List;
    .locals 3
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

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/model/ListOwnerRobotsRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/loop/model/ListOwnerRobotsRequest;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/loop/model/a/f;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/a/f;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    return-object v0
.end method

.method public removeLoop(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/model/RemoveRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/loop/model/RemoveRequest;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/loop/model/a/b;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/a/b;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method public removeMember(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/model/RemoveMemberRequest;

    invoke-direct {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/loop/model/RemoveMemberRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/loop/model/a/b;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/a/b;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method public removeMemberPhoto(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/model/RemoveMemberPhotoRequest;

    invoke-direct {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/loop/model/RemoveMemberPhotoRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/loop/model/a/b;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/a/b;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method public setLegalGuardian(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/model/SetLegalGuardianRequest;

    invoke-direct {v0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/loop/model/SetLegalGuardianRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/common/model/a/a;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/common/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    return-object v0
.end method

.method public suspendLoop(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/model/SuspendLoopRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/loop/model/SuspendLoopRequest;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/common/model/a/a;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/common/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    return-object v0
.end method

.method public updateLoop(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/model/UpdateRequest;

    invoke-direct {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/loop/model/UpdateRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/common/model/a/a;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/common/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    return-object v0
.end method

.method public updateMember(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 9

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberRequest;

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    move-object v6, p6

    move-object/from16 v7, p7

    move-object/from16 v8, p8

    invoke-direct/range {v0 .. v8}, Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;Ljava/lang/Long;Ljava/lang/Boolean;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/loop/model/a/b;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/a/b;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method public updateMemberPhoto(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberPhotoRequest;

    const/4 v1, 0x0

    invoke-direct {v0, p1, p2, p3, v1}, Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberPhotoRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Ljava/util/Map;)V

    new-instance v1, Lcom/jibo/aws/integration/aws/services/loop/model/a/g;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/a/g;-><init>()V

    new-instance v2, Lcom/jibo/aws/integration/aws/services/loop/model/a/b;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/a/b;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method public updateNickname(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/model/UpdateNicknameRequest;

    invoke-direct {v0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/loop/model/UpdateNicknameRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/common/model/a/a;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/common/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    return-object v0
.end method

.method public updatePhoneticName(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/model/UpdatePhoneticNameRequest;

    invoke-direct {v0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/loop/model/UpdatePhoneticNameRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/common/model/a/a;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/common/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    return-object v0
.end method
