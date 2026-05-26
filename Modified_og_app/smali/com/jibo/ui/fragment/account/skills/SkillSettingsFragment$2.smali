.class Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2;
.super Ljava/lang/Object;
.source "SkillSettingsFragment.java"

# interfaces
.implements Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;)V
    .locals 0

    .prologue
    .line 109
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2;->a:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;Lcom/jibo/ui/helpers/skills/DataItems$DataValue;Lcom/jibo/aws/integration/util/Commons$AsyncCallback;)V
    .locals 5
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
    .line 116
    if-nez p1, :cond_0

    .line 153
    :goto_0
    return-void

    .line 118
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2;->a:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->f()V

    .line 119
    const-string v0, "*:workCalendar:*"

    .line 120
    invoke-virtual {p1}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getValueDefinition()Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;->getKey()Ljava/lang/String;

    move-result-object v1

    const-string v2, "personal"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 121
    const-string v0, "*:personalCalendar:*"

    .line 124
    :cond_1
    new-instance v1, Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;

    new-instance v2, Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData$DeleteSettingValue;

    .line 127
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getCurrentSkill()Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;->getSkillId()Ljava/lang/String;

    move-result-object v3

    .line 128
    invoke-virtual {p1}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getValueDefinition()Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;

    move-result-object v4

    invoke-virtual {v4}, Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;->getTarget()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData$DeleteSettingValue;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v1, v0, v2}, Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;-><init>(Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData$DeleteSettingValue;)V

    .line 130
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2;->a:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->f(Landroid/content/Context;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    .line 132
    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2;->a:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;

    invoke-static {v2}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->c(Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;)Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

    move-result-object v2

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v0

    new-instance v3, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2$1;

    invoke-direct {v3, p0, p1}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2$1;-><init>(Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    invoke-virtual {v2, v0, v1, v3}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;->deleteSettings(Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    goto :goto_0
.end method
