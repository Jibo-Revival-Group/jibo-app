.class public Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsClient;
.super Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;


# static fields
.field public static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-class v0, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsClient;

    invoke-static {v0}, Lcom/jibo/aws/integration/util/a;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsClient;->TAG:Ljava/lang/String;

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
.method public deleteSettings(Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;)Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;
    .locals 4

    const/4 v1, 0x0

    new-instance v2, Lcom/google/gson/JsonParser;

    invoke-direct {v2}, Lcom/google/gson/JsonParser;-><init>()V

    new-instance v0, Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest;

    invoke-direct {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest;-><init>(Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;)V

    new-instance v3, Lcom/jibo/aws/integration/aws/services/skills/model/SettingsUnmarshaller;

    invoke-direct {v3}, Lcom/jibo/aws/integration/aws/services/skills/model/SettingsUnmarshaller;-><init>()V

    invoke-virtual {p0, v0, v1, v3}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v2, v0}, Lcom/google/gson/JsonParser;->a(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v0

    check-cast v0, Lcom/google/gson/JsonObject;

    const-string v2, "data"

    invoke-virtual {v0, v2}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    const-string v2, "data"

    invoke-virtual {v0, v2}, Lcom/google/gson/JsonObject;->e(Ljava/lang/String;)Lcom/google/gson/JsonObject;

    move-result-object v2

    iget-object v3, p2, Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;->key:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    const-string v2, "data"

    invoke-virtual {v0, v2}, Lcom/google/gson/JsonObject;->e(Ljava/lang/String;)Lcom/google/gson/JsonObject;

    move-result-object v2

    iget-object v3, p2, Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;->key:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/gson/JsonElement;->i()Z

    move-result v2

    if-eqz v2, :cond_0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;

    new-instance v2, Lcom/google/gson/Gson;

    invoke-direct {v2}, Lcom/google/gson/Gson;-><init>()V

    const-string v3, "data"

    invoke-virtual {v0, v3}, Lcom/google/gson/JsonObject;->e(Ljava/lang/String;)Lcom/google/gson/JsonObject;

    move-result-object v0

    iget-object v3, p2, Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;->key:Ljava/lang/String;

    invoke-virtual {v0, v3}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v0

    const-class v3, Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData$DeleteSettingValue;

    invoke-virtual {v2, v0, v3}, Lcom/google/gson/Gson;->a(Lcom/google/gson/JsonElement;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData$DeleteSettingValue;

    invoke-direct {v1, p1, v0}, Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;-><init>(Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData$DeleteSettingValue;)V

    move-object v0, v1

    :goto_0
    return-object v0

    :cond_0
    move-object v0, v1

    goto :goto_0
.end method

.method public getSkillsJson(Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    new-instance v0, Lcom/jibo/aws/integration/aws/services/skills/model/GetSettingsRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/skills/model/GetSettingsRequest;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/aws/integration/aws/services/skills/model/SettingsUnmarshaller;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/skills/model/SettingsUnmarshaller;-><init>()V

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public updateSkill(Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;)Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;
    .locals 4

    const/4 v1, 0x0

    new-instance v2, Lcom/google/gson/JsonParser;

    invoke-direct {v2}, Lcom/google/gson/JsonParser;-><init>()V

    new-instance v0, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest;

    invoke-direct {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest;-><init>(Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;)V

    new-instance v3, Lcom/jibo/aws/integration/aws/services/skills/model/SettingsUnmarshaller;

    invoke-direct {v3}, Lcom/jibo/aws/integration/aws/services/skills/model/SettingsUnmarshaller;-><init>()V

    invoke-virtual {p0, v0, v1, v3}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsClient;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v2, v0}, Lcom/google/gson/JsonParser;->a(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v0

    check-cast v0, Lcom/google/gson/JsonObject;

    const-string v2, "data"

    invoke-virtual {v0, v2}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    const-string v2, "data"

    invoke-virtual {v0, v2}, Lcom/google/gson/JsonObject;->e(Ljava/lang/String;)Lcom/google/gson/JsonObject;

    move-result-object v2

    iget-object v3, p2, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;->key:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    const-string v2, "data"

    invoke-virtual {v0, v2}, Lcom/google/gson/JsonObject;->e(Ljava/lang/String;)Lcom/google/gson/JsonObject;

    move-result-object v2

    iget-object v3, p2, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;->key:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/gson/JsonElement;->i()Z

    move-result v2

    if-eqz v2, :cond_0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;

    new-instance v2, Lcom/google/gson/Gson;

    invoke-direct {v2}, Lcom/google/gson/Gson;-><init>()V

    const-string v3, "data"

    invoke-virtual {v0, v3}, Lcom/google/gson/JsonObject;->e(Ljava/lang/String;)Lcom/google/gson/JsonObject;

    move-result-object v0

    iget-object v3, p2, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;->key:Ljava/lang/String;

    invoke-virtual {v0, v3}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v0

    const-class v3, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData$UpdateSettingValue;

    invoke-virtual {v2, v0, v3}, Lcom/google/gson/Gson;->a(Lcom/google/gson/JsonElement;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData$UpdateSettingValue;

    invoke-direct {v1, p1, v0}, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;-><init>(Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData$UpdateSettingValue;)V

    move-object v0, v1

    :goto_0
    return-object v0

    :cond_0
    move-object v0, v1

    goto :goto_0
.end method
