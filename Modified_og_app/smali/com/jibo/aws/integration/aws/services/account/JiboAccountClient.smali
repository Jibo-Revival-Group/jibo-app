.class public Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;
.super Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;


# static fields
.field public static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-class v0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    invoke-static {v0}, Lcom/jibo/aws/integration/util/a;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->TAG:Ljava/lang/String;

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
.method public activateByCode(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 4

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->clientConfiguration:Lcom/amazonaws/ClientConfiguration;

    invoke-virtual {v0}, Lcom/amazonaws/ClientConfiguration;->getSignerOverride()Ljava/lang/String;

    move-result-object v1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->clientConfiguration:Lcom/amazonaws/ClientConfiguration;

    const-string v2, "NoOpSignerType"

    invoke-virtual {v0, v2}, Lcom/amazonaws/ClientConfiguration;->setSignerOverride(Ljava/lang/String;)V

    new-instance v0, Lcom/jibo/aws/integration/aws/services/account/model/ActivateByCodeRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/account/model/ActivateByCodeRequest;-><init>(Ljava/lang/String;)V

    const/4 v2, 0x0

    new-instance v3, Lcom/jibo/aws/integration/aws/services/account/model/a/a;

    invoke-direct {v3}, Lcom/jibo/aws/integration/aws/services/account/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v2, v3}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    iget-object v2, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->clientConfiguration:Lcom/amazonaws/ClientConfiguration;

    invoke-virtual {v2, v1}, Lcom/amazonaws/ClientConfiguration;->setSignerOverride(Ljava/lang/String;)V

    return-object v0
.end method

.method public activateById(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/account/model/ActivateByIdRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/account/model/ActivateByIdRequest;-><init>(Ljava/lang/String;)V

    new-instance v1, Lcom/jibo/aws/integration/aws/services/common/model/a/c;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/common/model/a/c;-><init>()V

    new-instance v2, Lcom/jibo/aws/integration/aws/services/account/model/a/a;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/account/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    return-object v0
.end method

.method public changeEmail(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/account/model/ChangeEmailRequest;

    invoke-direct {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/account/model/ChangeEmailRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/common/model/a/d;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/common/model/a/d;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;

    return-object v0
.end method

.method public changePassword(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/account/model/ChangePasswordRequest;

    invoke-direct {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/account/model/ChangePasswordRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/account/model/a/a;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/account/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    return-object v0
.end method

.method public create(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 6

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->clientConfiguration:Lcom/amazonaws/ClientConfiguration;

    invoke-virtual {v0}, Lcom/amazonaws/ClientConfiguration;->getSignerOverride()Ljava/lang/String;

    move-result-object v1

    :try_start_0
    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->clientConfiguration:Lcom/amazonaws/ClientConfiguration;

    const-string v2, "NoOpSignerType"

    invoke-virtual {v0, v2}, Lcom/amazonaws/ClientConfiguration;->setSignerOverride(Ljava/lang/String;)V

    new-instance v0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;

    const-string v2, "Create"

    invoke-direct {v0, p1, p2, p3, v2}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    const/4 v2, 0x0

    new-instance v3, Lcom/jibo/aws/integration/aws/services/account/model/a/a;

    invoke-direct {v3}, Lcom/jibo/aws/integration/aws/services/account/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v2, v3}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    new-instance v2, Lcom/amazonaws/internal/StaticCredentialsProvider;

    new-instance v3, Lcom/amazonaws/auth/BasicAWSCredentials;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v3, v4, v5}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v2, v3}, Lcom/amazonaws/internal/StaticCredentialsProvider;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    iput-object v2, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->b:Lcom/amazonaws/auth/AWSCredentialsProvider;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    iget-object v2, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->clientConfiguration:Lcom/amazonaws/ClientConfiguration;

    invoke-virtual {v2, v1}, Lcom/amazonaws/ClientConfiguration;->setSignerOverride(Ljava/lang/String;)V

    return-object v0

    :catchall_0
    move-exception v0

    iget-object v2, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->clientConfiguration:Lcom/amazonaws/ClientConfiguration;

    invoke-virtual {v2, v1}, Lcom/amazonaws/ClientConfiguration;->setSignerOverride(Ljava/lang/String;)V

    throw v0
.end method

.method public createAccessToken()Lcom/jibo/aws/integration/aws/services/account/model/TokenContainer;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/account/model/CreateAccessTokenRequest;

    invoke-direct {v0}, Lcom/jibo/aws/integration/aws/services/account/model/CreateAccessTokenRequest;-><init>()V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/account/model/a/d;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/account/model/a/d;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/TokenContainer;

    return-object v0
.end method

.method public facebookConnect(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/account/model/FacebookConnectRequest;

    invoke-direct {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/account/model/FacebookConnectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/account/model/a/a;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/account/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    return-object v0
.end method

.method public facebookMobileConnect(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/TokenContainer;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/account/model/FacebookMobileConnectRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/account/model/FacebookMobileConnectRequest;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/account/model/a/d;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/account/model/a/d;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/TokenContainer;

    return-object v0
.end method

.method public facebookPrepareLogin()Lcom/jibo/aws/integration/aws/services/account/model/FacebookPrepareLogin;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/account/model/FacebookPrepareLoginRequest;

    invoke-direct {v0}, Lcom/jibo/aws/integration/aws/services/account/model/FacebookPrepareLoginRequest;-><init>()V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/account/model/a/c;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/account/model/a/c;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/FacebookPrepareLogin;

    return-object v0
.end method

.method public get(Ljava/util/List;)Ljava/util/List;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;"
        }
    .end annotation

    sget-boolean v0, Lcom/jibo/aws/integration/util/Commons;->IS_MOCK_MODE:Z

    if-eqz v0, :cond_mock_skip

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    if-eqz p1, :cond_iter_done

    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_iter
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_iter_done

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    new-instance v3, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-direct {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;-><init>()V

    invoke-virtual {v3, v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setId(Ljava/lang/String;)V

    const-string v4, "jibo@jiborevival.com"

    invoke-virtual {v3, v4}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setEmail(Ljava/lang/String;)V

    const-string v4, "mock-access-key-id"

    invoke-virtual {v3, v4}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setAccessKeyId(Ljava/lang/String;)V

    const-string v4, "mock-secret-access-key"

    invoke-virtual {v3, v4}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setSecretAccessKey(Ljava/lang/String;)V

    sget-object v4, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v3, v4}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setIsActive(Ljava/lang/Boolean;)V

    const-string v4, "Jibo"

    invoke-virtual {v3, v4}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setFirstName(Ljava/lang/String;)V

    const-string v4, "Revival"

    invoke-virtual {v3, v4}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setLastName(Ljava/lang/String;)V

    sget-object v4, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->other:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    invoke-virtual {v3, v4}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setGender(Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;)V

    const-wide/16 v4, 0x0

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setBirthday(Ljava/lang/Long;)V

    sget-object v4, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v3, v4}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setMessagingAllowed(Ljava/lang/Boolean;)V

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_iter

    :cond_iter_done
    return-object v0

    :cond_mock_skip
    new-instance v0, Lcom/jibo/aws/integration/aws/services/account/model/GetRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/account/model/GetRequest;-><init>(Ljava/util/List;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/account/model/a/b;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/account/model/a/b;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    return-object v0
.end method

.method public login(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 8

    const-string v6, "jibo@jiborevival.com"

    invoke-virtual {v6, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_mock_skip

    const-string v6, "Jibo12345678"

    invoke-virtual {v6, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_mock_skip

    const/4 v6, 0x1

    sput-boolean v6, Lcom/jibo/aws/integration/util/Commons;->IS_MOCK_MODE:Z

    new-instance v6, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-direct {v6}, Lcom/jibo/aws/integration/aws/services/account/model/Account;-><init>()V

    const-string v7, "mock-user-1234"

    invoke-virtual {v6, v7}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setId(Ljava/lang/String;)V

    const-string v7, "jibo@jiborevival.com"

    invoke-virtual {v6, v7}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setEmail(Ljava/lang/String;)V

    const-string v7, "mock-access-key-id"

    invoke-virtual {v6, v7}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setAccessKeyId(Ljava/lang/String;)V

    const-string v7, "mock-secret-access-key"

    invoke-virtual {v6, v7}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setSecretAccessKey(Ljava/lang/String;)V

    sget-object v7, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v6, v7}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setIsActive(Ljava/lang/Boolean;)V

    const-string v7, "Jibo"

    invoke-virtual {v6, v7}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setFirstName(Ljava/lang/String;)V

    const-string v7, "Revival"

    invoke-virtual {v6, v7}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setLastName(Ljava/lang/String;)V

    sget-object v7, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->other:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    invoke-virtual {v6, v7}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setGender(Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;)V

    const-wide/16 v0, 0x0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setBirthday(Ljava/lang/Long;)V

    sget-object v7, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v6, v7}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setMessagingAllowed(Ljava/lang/Boolean;)V

    new-instance v7, Lcom/amazonaws/internal/StaticCredentialsProvider;

    new-instance v0, Lcom/amazonaws/auth/BasicAWSCredentials;

    const-string v1, "mock-access-key-id"

    const-string v2, "mock-secret-access-key"

    invoke-direct {v0, v1, v2}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v7, v0}, Lcom/amazonaws/internal/StaticCredentialsProvider;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    iput-object v7, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->b:Lcom/amazonaws/auth/AWSCredentialsProvider;

    return-object v6

    :cond_mock_skip

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->clientConfiguration:Lcom/amazonaws/ClientConfiguration;

    invoke-virtual {v0}, Lcom/amazonaws/ClientConfiguration;->getSignerOverride()Ljava/lang/String;

    move-result-object v1

    :try_start_0
    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->clientConfiguration:Lcom/amazonaws/ClientConfiguration;

    const-string v2, "NoOpSignerType"

    invoke-virtual {v0, v2}, Lcom/amazonaws/ClientConfiguration;->setSignerOverride(Ljava/lang/String;)V

    new-instance v0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;

    const-string v2, "Login"

    invoke-direct {v0, p1, p2, v2}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    const/4 v2, 0x0

    new-instance v3, Lcom/jibo/aws/integration/aws/services/account/model/a/a;

    invoke-direct {v3}, Lcom/jibo/aws/integration/aws/services/account/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v2, v3}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    new-instance v2, Lcom/amazonaws/internal/StaticCredentialsProvider;

    new-instance v3, Lcom/amazonaws/auth/BasicAWSCredentials;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v3, v4, v5}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v2, v3}, Lcom/amazonaws/internal/StaticCredentialsProvider;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    iput-object v2, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->b:Lcom/amazonaws/auth/AWSCredentialsProvider;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    iget-object v2, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->clientConfiguration:Lcom/amazonaws/ClientConfiguration;

    invoke-virtual {v2, v1}, Lcom/amazonaws/ClientConfiguration;->setSignerOverride(Ljava/lang/String;)V

    return-object v0

    :catchall_0
    move-exception v0

    iget-object v2, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->clientConfiguration:Lcom/amazonaws/ClientConfiguration;

    invoke-virtual {v2, v1}, Lcom/amazonaws/ClientConfiguration;->setSignerOverride(Ljava/lang/String;)V

    throw v0
.end method

.method public logout()V
    .locals 4

    const/4 v0, 0x0

    sput-boolean v0, Lcom/jibo/aws/integration/util/Commons;->IS_MOCK_MODE:Z

    new-instance v0, Lcom/amazonaws/internal/StaticCredentialsProvider;

    new-instance v1, Lcom/amazonaws/auth/BasicAWSCredentials;

    const-string v2, ""

    const-string v3, ""

    invoke-direct {v1, v2, v3}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v0, v1}, Lcom/amazonaws/internal/StaticCredentialsProvider;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->b:Lcom/amazonaws/auth/AWSCredentialsProvider;

    return-void
.end method

.method public passwordResetByCode(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 4

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->clientConfiguration:Lcom/amazonaws/ClientConfiguration;

    invoke-virtual {v0}, Lcom/amazonaws/ClientConfiguration;->getSignerOverride()Ljava/lang/String;

    move-result-object v1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->clientConfiguration:Lcom/amazonaws/ClientConfiguration;

    const-string v2, "NoOpSignerType"

    invoke-virtual {v0, v2}, Lcom/amazonaws/ClientConfiguration;->setSignerOverride(Ljava/lang/String;)V

    new-instance v0, Lcom/jibo/aws/integration/aws/services/account/model/PasswordResetByCodeRequest;

    invoke-direct {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/account/model/PasswordResetByCodeRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v2, 0x0

    new-instance v3, Lcom/jibo/aws/integration/aws/services/account/model/a/a;

    invoke-direct {v3}, Lcom/jibo/aws/integration/aws/services/account/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v2, v3}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    iget-object v2, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->clientConfiguration:Lcom/amazonaws/ClientConfiguration;

    invoke-virtual {v2, v1}, Lcom/amazonaws/ClientConfiguration;->setSignerOverride(Ljava/lang/String;)V

    return-object v0
.end method

.method public remove()Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 5

    new-instance v0, Lcom/jibo/aws/integration/aws/services/account/model/RemoveRequest;

    invoke-direct {v0}, Lcom/jibo/aws/integration/aws/services/account/model/RemoveRequest;-><init>()V

    new-instance v1, Lcom/jibo/aws/integration/aws/services/common/model/a/b;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/common/model/a/b;-><init>()V

    new-instance v2, Lcom/jibo/aws/integration/aws/services/account/model/a/a;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/account/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    new-instance v1, Lcom/amazonaws/internal/StaticCredentialsProvider;

    new-instance v2, Lcom/amazonaws/auth/BasicAWSCredentials;

    const-string v3, ""

    const-string v4, ""

    invoke-direct {v2, v3, v4}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v1, v2}, Lcom/amazonaws/internal/StaticCredentialsProvider;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    iput-object v1, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->b:Lcom/amazonaws/auth/AWSCredentialsProvider;

    return-object v0
.end method

.method public removePhoto()Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/account/model/RemovePhotoRequest;

    invoke-direct {v0}, Lcom/jibo/aws/integration/aws/services/account/model/RemovePhotoRequest;-><init>()V

    new-instance v1, Lcom/jibo/aws/integration/aws/services/common/model/a/c;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/common/model/a/c;-><init>()V

    new-instance v2, Lcom/jibo/aws/integration/aws/services/account/model/a/a;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/account/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    return-object v0
.end method

.method public resendActivationCode(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 4

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->clientConfiguration:Lcom/amazonaws/ClientConfiguration;

    invoke-virtual {v0}, Lcom/amazonaws/ClientConfiguration;->getSignerOverride()Ljava/lang/String;

    move-result-object v1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->clientConfiguration:Lcom/amazonaws/ClientConfiguration;

    const-string v2, "NoOpSignerType"

    invoke-virtual {v0, v2}, Lcom/amazonaws/ClientConfiguration;->setSignerOverride(Ljava/lang/String;)V

    new-instance v0, Lcom/jibo/aws/integration/aws/services/account/model/ResendActivationCodeRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/account/model/ResendActivationCodeRequest;-><init>(Ljava/lang/String;)V

    const/4 v2, 0x0

    new-instance v3, Lcom/jibo/aws/integration/aws/services/account/model/a/a;

    invoke-direct {v3}, Lcom/jibo/aws/integration/aws/services/account/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v2, v3}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    iget-object v2, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->clientConfiguration:Lcom/amazonaws/ClientConfiguration;

    invoke-virtual {v2, v1}, Lcom/amazonaws/ClientConfiguration;->setSignerOverride(Ljava/lang/String;)V

    return-object v0
.end method

.method public resetKeys()Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 5

    new-instance v0, Lcom/jibo/aws/integration/aws/services/account/model/ResetKeysRequest;

    invoke-direct {v0}, Lcom/jibo/aws/integration/aws/services/account/model/ResetKeysRequest;-><init>()V

    new-instance v1, Lcom/jibo/aws/integration/aws/services/common/model/a/b;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/common/model/a/b;-><init>()V

    new-instance v2, Lcom/jibo/aws/integration/aws/services/account/model/a/a;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/account/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    new-instance v1, Lcom/amazonaws/internal/StaticCredentialsProvider;

    new-instance v2, Lcom/amazonaws/auth/BasicAWSCredentials;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v1, v2}, Lcom/amazonaws/internal/StaticCredentialsProvider;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    iput-object v1, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->b:Lcom/amazonaws/auth/AWSCredentialsProvider;

    return-object v0
.end method

.method public search(Ljava/lang/String;)Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;"
        }
    .end annotation

    new-instance v0, Lcom/jibo/aws/integration/aws/services/account/model/SearchRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/account/model/SearchRequest;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/account/model/a/b;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/account/model/a/b;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    return-object v0
.end method

.method public sendPasswordReset(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 4

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->clientConfiguration:Lcom/amazonaws/ClientConfiguration;

    invoke-virtual {v0}, Lcom/amazonaws/ClientConfiguration;->getSignerOverride()Ljava/lang/String;

    move-result-object v1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->clientConfiguration:Lcom/amazonaws/ClientConfiguration;

    const-string v2, "NoOpSignerType"

    invoke-virtual {v0, v2}, Lcom/amazonaws/ClientConfiguration;->setSignerOverride(Ljava/lang/String;)V

    new-instance v0, Lcom/jibo/aws/integration/aws/services/account/model/SendPasswordResetRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/account/model/SendPasswordResetRequest;-><init>(Ljava/lang/String;)V

    const/4 v2, 0x0

    new-instance v3, Lcom/jibo/aws/integration/aws/services/account/model/a/a;

    invoke-direct {v3}, Lcom/jibo/aws/integration/aws/services/account/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v2, v3}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    iget-object v2, p0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->clientConfiguration:Lcom/amazonaws/ClientConfiguration;

    invoke-virtual {v2, v1}, Lcom/amazonaws/ClientConfiguration;->setSignerOverride(Ljava/lang/String;)V

    return-object v0
.end method

.method public sendPhoneVerificationCode(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/account/model/SendPhoneVerificationCodeRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/account/model/SendPhoneVerificationCodeRequest;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/common/model/a/d;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/common/model/a/d;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;

    return-object v0
.end method

.method public update(Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;)Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 2

    const/4 v0, 0x0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/account/model/a/a;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/account/model/a/a;-><init>()V

    invoke-virtual {p0, p1, v0, v1}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    return-object v0
.end method

.method public updatePhoto(Ljava/io/File;Ljava/util/Map;)Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/File;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;"
        }
    .end annotation

    new-instance v0, Lcom/jibo/aws/integration/aws/services/account/model/UpdatePhotoRequest;

    invoke-direct {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/account/model/UpdatePhotoRequest;-><init>(Ljava/io/File;Ljava/util/Map;)V

    new-instance v1, Lcom/jibo/aws/integration/aws/services/account/model/a/e;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/account/model/a/e;-><init>()V

    new-instance v2, Lcom/jibo/aws/integration/aws/services/account/model/a/a;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/account/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    return-object v0
.end method

.method public verifyPhoneByCode(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/account/model/VerifyPhoneByCodeRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/account/model/VerifyPhoneByCodeRequest;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/account/model/a/a;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/account/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    return-object v0
.end method
