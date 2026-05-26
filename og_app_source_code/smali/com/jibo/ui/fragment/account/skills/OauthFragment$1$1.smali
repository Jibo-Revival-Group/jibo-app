.class Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1;
.super Ljava/lang/Object;
.source "OauthFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;->a(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;Lcom/jibo/ui/helpers/skills/DataItems$DataValue;Lcom/jibo/aws/integration/util/Commons$AsyncCallback;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazonaws/handlers/AsyncHandler",
        "<",
        "Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest;",
        "Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

.field final synthetic b:Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V
    .locals 0

    .prologue
    .line 92
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1;->b:Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;

    iput-object p2, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1;->a:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest;Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;)V
    .locals 3

    .prologue
    .line 100
    if-eqz p2, :cond_0

    iget-object v0, p2, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;->value:Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData$UpdateSettingValue;

    if-eqz v0, :cond_0

    iget-object v0, p2, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;->value:Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData$UpdateSettingValue;

    iget-object v0, v0, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData$UpdateSettingValue;->value:Lcom/google/gson/JsonElement;

    if-eqz v0, :cond_0

    iget-object v0, p2, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;->value:Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData$UpdateSettingValue;

    iget-object v0, v0, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData$UpdateSettingValue;->value:Lcom/google/gson/JsonElement;

    .line 101
    invoke-virtual {v0}, Lcom/google/gson/JsonElement;->l()Lcom/google/gson/JsonObject;

    move-result-object v0

    const-string v1, "credentialExists"

    invoke-virtual {v0, v1}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/gson/JsonElement;->g()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 102
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1;->a:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-virtual {v1}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getValueDefinition()Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;->getKey()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p2, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;->value:Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData$UpdateSettingValue;

    iget-object v2, v2, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData$UpdateSettingValue;->value:Lcom/google/gson/JsonElement;

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->updateData(Ljava/lang/String;Lcom/google/gson/JsonElement;)V

    .line 104
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1;->b:Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->a(Lcom/jibo/ui/fragment/account/skills/OauthFragment;)Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataValue;

    move-result-object v0

    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataValue;->setValue(Ljava/lang/Boolean;)V

    .line 105
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1;->b:Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;

    iget-object v1, v1, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->b(Lcom/jibo/ui/fragment/account/skills/OauthFragment;)Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataItem;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataItem;->getValueDefinition()Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;->getKey()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1;->b:Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;

    iget-object v2, v2, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    invoke-static {v2}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->a(Lcom/jibo/ui/fragment/account/skills/OauthFragment;)Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataValue;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->updateData(Ljava/lang/String;Lcom/jibo/ui/helpers/skills/DataItems$DataValue;)V

    .line 107
    :cond_0
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1;->a:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->setItemDataValue(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    .line 109
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1;->b:Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->g()V

    .line 111
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1;->b:Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    new-instance v1, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1$1;-><init>(Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->a(Ljava/lang/Runnable;)V

    .line 128
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 95
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1;->b:Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    const-string v1, "skills update skill"

    const/4 v2, 0x1

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->a(Lcom/jibo/ui/fragment/account/skills/OauthFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 96
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 92
    check-cast p1, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1;->a(Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest;Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;)V

    return-void
.end method
