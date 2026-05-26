.class public Lcom/jibo/aws/integration/aws/services/jot/JiboJotClient;
.super Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;


# static fields
.field public static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-class v0, Lcom/jibo/aws/integration/aws/services/jot/JiboJotClient;

    invoke-static {v0}, Lcom/jibo/aws/integration/util/a;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/aws/integration/aws/services/jot/JiboJotClient;->TAG:Ljava/lang/String;

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
.method public createMessage(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lcom/jibo/aws/integration/aws/services/jot/model/Message;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;",
            ">;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/jibo/aws/integration/aws/services/jot/model/Message;"
        }
    .end annotation

    new-instance v0, Lcom/jibo/aws/integration/aws/services/jot/model/CreateMessageRequest;

    invoke-direct {v0, p1, p2, p3, p4}, Lcom/jibo/aws/integration/aws/services/jot/model/CreateMessageRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/jot/model/a/a;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/jot/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/jot/JiboJotClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/jot/model/Message;

    return-object v0
.end method

.method public listMessages(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/Long;",
            "Ljava/lang/Long;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/jot/model/Message;",
            ">;"
        }
    .end annotation

    new-instance v0, Lcom/jibo/aws/integration/aws/services/jot/model/ListMessagesRequest;

    invoke-direct {v0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/jot/model/ListMessagesRequest;-><init>(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/jot/model/a/b;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/jot/model/a/b;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/jot/JiboJotClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    return-object v0
.end method

.method public markRead(Ljava/util/List;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;"
        }
    .end annotation

    new-instance v0, Lcom/jibo/aws/integration/aws/services/jot/model/MarkReadRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/jot/model/MarkReadRequest;-><init>(Ljava/util/List;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/common/model/a/a;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/common/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/jot/JiboJotClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    return-object v0
.end method
