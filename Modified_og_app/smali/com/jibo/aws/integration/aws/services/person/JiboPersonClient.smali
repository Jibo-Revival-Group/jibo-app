.class public Lcom/jibo/aws/integration/aws/services/person/JiboPersonClient;
.super Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;


# static fields
.field public static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-class v0, Lcom/jibo/aws/integration/aws/services/person/JiboPersonClient;

    invoke-static {v0}, Lcom/jibo/aws/integration/util/a;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/aws/integration/aws/services/person/JiboPersonClient;->TAG:Ljava/lang/String;

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
.method public getAccountProperties(Ljava/util/List;)Ljava/util/HashMap;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/gson/JsonObject;",
            ">;"
        }
    .end annotation

    new-instance v0, Lcom/jibo/aws/integration/aws/services/person/model/GetAccountPropertiesRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/person/model/GetAccountPropertiesRequest;-><init>(Ljava/util/List;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/person/model/a/a;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/person/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/person/JiboPersonClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/HashMap;

    return-object v0
.end method

.method public getLoopProperties(Ljava/lang/String;Ljava/util/List;)Ljava/util/HashMap;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/gson/JsonObject;",
            ">;"
        }
    .end annotation

    new-instance v0, Lcom/jibo/aws/integration/aws/services/person/model/GetLoopPropertiesRequest;

    invoke-direct {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/person/model/GetLoopPropertiesRequest;-><init>(Ljava/lang/String;Ljava/util/List;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/person/model/a/a;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/person/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/person/JiboPersonClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/HashMap;

    return-object v0
.end method

.method public listHolidays(Ljava/lang/String;)Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/person/model/Holiday;",
            ">;"
        }
    .end annotation

    new-instance v0, Lcom/jibo/aws/integration/aws/services/person/model/ListHolidaysRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/person/model/ListHolidaysRequest;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/person/model/a/b;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/person/model/a/b;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/person/JiboPersonClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    return-object v0
.end method

.method public setAccountProperty(Ljava/lang/String;Lcom/google/gson/JsonObject;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/person/model/SetAccountPropertyRequest;

    invoke-direct {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/person/model/SetAccountPropertyRequest;-><init>(Ljava/lang/String;Lcom/google/gson/JsonObject;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/common/model/a/a;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/common/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/person/JiboPersonClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    return-object v0
.end method

.method public setLoopProperty(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonObject;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/person/model/SetLoopPropertyRequest;

    invoke-direct {v0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/person/model/SetLoopPropertyRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonObject;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/common/model/a/a;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/common/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/person/JiboPersonClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    return-object v0
.end method

.method public switchHolidays(ZLjava/util/List;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            ")",
            "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;"
        }
    .end annotation

    new-instance v0, Lcom/jibo/aws/integration/aws/services/person/model/HolidaysSwitchRequest;

    invoke-direct {v0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/person/model/HolidaysSwitchRequest;-><init>(ZLjava/util/List;Ljava/lang/String;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/common/model/a/a;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/common/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/person/JiboPersonClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    return-object v0
.end method
