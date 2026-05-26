.class public Lcom/jibo/aws/integration/aws/services/key/JiboKeyClient;
.super Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;


# static fields
.field public static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-class v0, Lcom/jibo/aws/integration/aws/services/key/JiboKeyClient;

    invoke-static {v0}, Lcom/jibo/aws/integration/util/a;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/aws/integration/aws/services/key/JiboKeyClient;->TAG:Ljava/lang/String;

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
.method public backupEncryptedKey(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/key/model/BackupRequest;

    invoke-direct {v0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/key/model/BackupRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/common/model/a/a;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/common/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    return-object v0
.end method

.method public createRequest(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/key/model/Request;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/key/model/CreateRequest;

    invoke-direct {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/key/model/CreateRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/key/model/a/b;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/key/model/a/b;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/key/model/Request;

    return-object v0
.end method

.method public getRequest(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/key/model/Request;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/key/model/GetRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/key/model/GetRequest;-><init>(Ljava/lang/String;)V

    new-instance v1, Lcom/jibo/aws/integration/aws/services/common/model/a/c;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/common/model/a/c;-><init>()V

    new-instance v2, Lcom/jibo/aws/integration/aws/services/key/model/a/b;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/key/model/a/b;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/key/model/Request;

    return-object v0
.end method

.method public listIncomingRequests(Ljava/lang/String;)Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/key/model/Request;",
            ">;"
        }
    .end annotation

    new-instance v0, Lcom/jibo/aws/integration/aws/services/key/model/ListIncomingRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/key/model/ListIncomingRequest;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/key/model/a/a;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/key/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    return-object v0
.end method

.method public restoreEncryptedKey(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/key/model/Backup;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/key/model/RestoreRequest;

    invoke-direct {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/key/model/RestoreRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/loop/model/a/a;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/key/model/Backup;

    return-object v0
.end method

.method public share(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/key/model/Request;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/key/model/ShareRequest;

    invoke-direct {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/key/model/ShareRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/key/model/a/b;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/key/model/a/b;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/key/model/Request;

    return-object v0
.end method
