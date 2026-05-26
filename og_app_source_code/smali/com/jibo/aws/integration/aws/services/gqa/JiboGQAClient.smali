.class public Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAClient;
.super Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;


# static fields
.field public static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-class v0, Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAClient;

    invoke-static {v0}, Lcom/jibo/aws/integration/util/a;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAClient;->TAG:Ljava/lang/String;

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
.method public listAttributions(Ljava/lang/String;J)Lcom/jibo/aws/integration/aws/services/gqa/model/AttributionListResponse;
    .locals 4

    new-instance v0, Lcom/jibo/aws/integration/aws/services/gqa/model/ListAttributionRequest;

    invoke-direct {v0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/gqa/model/ListAttributionRequest;-><init>(Ljava/lang/String;J)V

    new-instance v1, Lcom/jibo/aws/integration/aws/services/common/model/a/e;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/common/model/a/e;-><init>()V

    new-instance v2, Lcom/jibo/aws/integration/aws/services/gqa/model/a/b;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/gqa/model/a/b;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/gqa/model/AttributionListResponse;

    return-object v0
.end method

.method public sendQuestion(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/gqa/model/QuestionRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/gqa/model/QuestionRequest;-><init>(Ljava/lang/String;)V

    new-instance v1, Lcom/jibo/aws/integration/aws/services/common/model/a/e;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/common/model/a/e;-><init>()V

    new-instance v2, Lcom/jibo/aws/integration/aws/services/gqa/model/a/a;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/gqa/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;

    return-object v0
.end method
