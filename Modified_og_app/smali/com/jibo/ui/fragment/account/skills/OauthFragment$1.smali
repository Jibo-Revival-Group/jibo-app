.class Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;
.super Ljava/lang/Object;
.source "OauthFragment.java"

# interfaces
.implements Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/account/skills/OauthFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/skills/OauthFragment;)V
    .locals 0

    .prologue
    .line 70
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;Lcom/jibo/ui/helpers/skills/DataItems$DataValue;Lcom/jibo/aws/integration/util/Commons$AsyncCallback;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/jibo/ui/helpers/skills/DataItems$DataItem;",
            "Lcom/jibo/ui/helpers/skills/DataItems$DataValue;",
            "Lcom/jibo/aws/integration/util/Commons$AsyncCallback",
            "<",
            "Lcom/jibo/ui/helpers/skills/DataItems$DataValue;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 77
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 130
    :cond_0
    :goto_0
    return-void

    .line 79
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->f()V

    .line 81
    new-instance v0, Lcom/google/gson/Gson;

    invoke-direct {v0}, Lcom/google/gson/Gson;-><init>()V

    invoke-virtual {v0, p2}, Lcom/google/gson/Gson;->a(Ljava/lang/Object;)Lcom/google/gson/JsonElement;

    move-result-object v0

    .line 83
    new-instance v1, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;

    .line 84
    invoke-virtual {p1}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getValueDefinition()Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;->getKey()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData$UpdateSettingValue;

    .line 86
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v4

    invoke-virtual {v4}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getCurrentSkill()Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;

    move-result-object v4

    invoke-virtual {v4}, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;->getSkillId()Ljava/lang/String;

    move-result-object v4

    .line 87
    invoke-virtual {p1}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getValueDefinition()Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;

    move-result-object v5

    invoke-virtual {v5}, Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;->getTarget()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v3, v4, v5, v0}, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData$UpdateSettingValue;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonElement;)V

    invoke-direct {v1, v2, v3}, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;-><init>(Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData$UpdateSettingValue;)V

    .line 90
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->f(Landroid/content/Context;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    .line 92
    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    invoke-static {v2}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->c(Lcom/jibo/ui/fragment/account/skills/OauthFragment;)Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

    move-result-object v2

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v0

    new-instance v3, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1;

    invoke-direct {v3, p0, p1}, Lcom/jibo/ui/fragment/account/skills/OauthFragment$1$1;-><init>(Lcom/jibo/ui/fragment/account/skills/OauthFragment$1;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    invoke-virtual {v2, v0, v1, v3}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;->updateSkill(Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    goto :goto_0
.end method
