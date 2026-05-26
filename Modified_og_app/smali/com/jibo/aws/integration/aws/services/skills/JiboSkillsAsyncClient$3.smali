.class Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient$3;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;->deleteSettings(Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable",
        "<",
        "Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;

.field final synthetic c:Lcom/amazonaws/handlers/AsyncHandler;

.field final synthetic d:Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;


# direct methods
.method constructor <init>(Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;Lcom/amazonaws/handlers/AsyncHandler;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient$3;->d:Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

    iput-object p2, p0, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient$3;->a:Ljava/lang/String;

    iput-object p3, p0, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient$3;->b:Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;

    iput-object p4, p0, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient$3;->c:Lcom/amazonaws/handlers/AsyncHandler;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;
    .locals 5

    :try_start_0
    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient$3;->d:Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient$3;->a:Ljava/lang/String;

    iget-object v2, p0, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient$3;->b:Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;

    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;->deleteSettings(Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;)Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;

    move-result-object v0

    if-nez v0, :cond_1

    new-instance v0, Lcom/amazonaws/AmazonServiceException;

    const-string v1, "Bad response data"

    invoke-direct {v0, v1}, Lcom/amazonaws/AmazonServiceException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient$3;->c:Lcom/amazonaws/handlers/AsyncHandler;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient$3;->c:Lcom/amazonaws/handlers/AsyncHandler;

    invoke-interface {v1, v0}, Lcom/amazonaws/handlers/AsyncHandler;->onError(Ljava/lang/Exception;)V

    :cond_0
    throw v0

    :cond_1
    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient$3;->c:Lcom/amazonaws/handlers/AsyncHandler;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient$3;->c:Lcom/amazonaws/handlers/AsyncHandler;

    new-instance v2, Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest;

    iget-object v3, p0, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient$3;->a:Ljava/lang/String;

    iget-object v4, p0, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient$3;->b:Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;

    invoke-direct {v2, v3, v4}, Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest;-><init>(Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;)V

    invoke-interface {v1, v2, v0}, Lcom/amazonaws/handlers/AsyncHandler;->onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V

    :cond_2
    return-object v0
.end method

.method public synthetic call()Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient$3;->a()Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;

    move-result-object v0

    return-object v0
.end method
