.class public Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesClient;
.super Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;


# static fields
.field public static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-class v0, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesClient;

    invoke-static {v0}, Lcom/jibo/aws/integration/util/a;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesClient;->TAG:Ljava/lang/String;

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
.method public createRobot(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/CreateRobotRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/CreateRobotRequest;-><init>(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/common/model/a/a;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/common/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    return-object v0
.end method

.method public getFriendlyIds(I)Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/robotProperties/model/IdPair;",
            ">;"
        }
    .end annotation

    new-instance v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetFriendlyIdsRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetFriendlyIdsRequest;-><init>(I)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/robotProperties/model/a/a;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    return-object v0
.end method

.method public getRobot(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;
    .locals 5

    sget-boolean v0, Lcom/jibo/aws/integration/util/Commons;->IS_MOCK_MODE:Z

    if-eqz v0, :cond_skip_get_robot

    new-instance v0, Lcom/google/gson/JsonObject;

    invoke-direct {v0}, Lcom/google/gson/JsonObject;-><init>()V

    const-string v1, "SSID"

    const-string v2, "JiboRevivalWiFi"

    invoke-virtual {v0, v1, v2}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "platform"

    const-string v2, "1.6.0"

    invoke-virtual {v0, v1, v2}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "serialNumber"

    const-string v2, "JIBO-REVIVAL-MOCK"

    invoke-virtual {v0, v1, v2}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "timezone"

    const-string v2, "America/New_York"

    invoke-virtual {v0, v1, v2}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "avatar"

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/Number;)V

    new-instance v1, Lcom/google/gson/JsonObject;

    invoke-direct {v1}, Lcom/google/gson/JsonObject;-><init>()V

    const-string v2, "city"

    const-string v3, "Boston"

    invoke-virtual {v1, v2, v3}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/String;)V

    const-string v2, "state"

    const-string v3, "Massachusetts"

    invoke-virtual {v1, v2, v3}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/String;)V

    const-string v2, "country"

    const-string v3, "United States"

    invoke-virtual {v1, v2, v3}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/String;)V

    const-string v2, "zipcode"

    const-string v3, "02108"

    invoke-virtual {v1, v2, v3}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/String;)V

    const-string v2, "addressLine"

    const-string v3, "100 Beacon St"

    invoke-virtual {v1, v2, v3}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/String;)V

    const-string v2, "lat"

    const-wide v3, 0x40452d7e00000000L # 42.3554 double

    invoke-static {v3, v4}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/Number;)V

    const-string v2, "lng"

    const-wide v3, -0x3fa1b58580000000L # -71.0715 double

    invoke-static {v3, v4}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/Number;)V

    const-string v2, "locationOverride"

    invoke-virtual {v0, v2, v1}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Lcom/google/gson/JsonElement;)V

    new-instance v1, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;-><init>()V

    const-string v2, "mock-friendly-id-1"

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->setId(Ljava/lang/String;)V

    const-string v2, "mock-robot-id-1"

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->setGuid(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->setPayload(Lcom/google/gson/JsonObject;)V

    const-wide/16 v2, 0x0

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->setCreatedMilliseconds(Ljava/lang/Long;)V

    invoke-virtual {v1, v0}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->setUpdatedMilliseconds(Ljava/lang/Long;)V

    return-object v1

    :cond_skip_get_robot

    new-instance v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;-><init>(Ljava/lang/String;)V

    new-instance v1, Lcom/jibo/aws/integration/aws/services/common/model/a/c;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/common/model/a/c;-><init>()V

    new-instance v2, Lcom/jibo/aws/integration/aws/services/robotProperties/model/a/b;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/a/b;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    return-object v0
.end method

.method public removeRobot(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/RemoveRobotRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/RemoveRobotRequest;-><init>(Ljava/lang/String;)V

    new-instance v1, Lcom/jibo/aws/integration/aws/services/common/model/a/c;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/common/model/a/c;-><init>()V

    new-instance v2, Lcom/jibo/aws/integration/aws/services/common/model/a/a;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/common/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    return-object v0
.end method

.method public updateRobot(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/UpdateRobotRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/UpdateRobotRequest;-><init>(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/common/model/a/a;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/common/model/a/a;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    return-object v0
.end method
