.class public Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;
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
.method public deleteSettings(Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;)Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsClient;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsClient;->deleteSettings(Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;)Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;

    move-result-object v0

    return-object v0
.end method

.method public deleteSettings(Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest;",
            "Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient$3;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient$3;-><init>(Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getJiboClient()Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsClient;

    move-result-object v0

    return-object v0
.end method

.method public getJiboClient()Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsClient;
    .locals 1

    invoke-super {p0}, Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsClient;

    return-object v0
.end method

.method public bridge synthetic getJiboClient()Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsClient;

    move-result-object v0

    return-object v0
.end method

.method public getSkillsJson(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsClient;->getSkillsJson(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSkillsJson(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/skills/model/GetSettingsRequest;",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient$1;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient$1;-><init>(Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public updateSkill(Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;)Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsClient;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsClient;->updateSkill(Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;)Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;

    move-result-object v0

    return-object v0
.end method

.method public updateSkill(Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest;",
            "Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient$2;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient$2;-><init>(Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method
