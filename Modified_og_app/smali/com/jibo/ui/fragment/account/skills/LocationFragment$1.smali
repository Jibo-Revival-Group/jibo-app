.class Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;
.super Ljava/lang/Object;
.source "LocationFragment.java"

# interfaces
.implements Lcom/jibo/ui/fragment/settings/LocationFragment$AsyncGeocoderTaskProcessor;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/skills/LocationFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/account/skills/LocationFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/skills/LocationFragment;)V
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/LocationFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/os/Bundle;)V
    .locals 10

    .prologue
    .line 75
    :try_start_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/LocationFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->d()Z

    move-result v0

    if-nez v0, :cond_0

    .line 137
    :goto_0
    return-void

    .line 78
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/LocationFragment;

    const v1, 0x7f10012b

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 79
    new-instance v9, Landroid/text/SpannableStringBuilder;

    invoke-direct {v9, v0}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 80
    new-instance v1, Landroid/text/style/StyleSpan;

    const/4 v2, 0x1

    invoke-direct {v1, v2}, Landroid/text/style/StyleSpan;-><init>(I)V

    const-string v2, " "

    invoke-virtual {v0, v2}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v3, 0x21

    invoke-virtual {v9, v1, v2, v0, v3}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 84
    if-eqz p1, :cond_1

    invoke-virtual {p1}, Landroid/os/Bundle;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 85
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/LocationFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->a(Lcom/jibo/ui/fragment/account/skills/LocationFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v0

    invoke-virtual {v0, v9}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b(Landroid/text/SpannableStringBuilder;)V

    .line 89
    :cond_2
    new-instance v0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;

    const-string v1, "lat"

    .line 90
    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getDouble(Ljava/lang/String;)D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    const-string v2, "lng"

    .line 91
    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getDouble(Ljava/lang/String;)D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    const-string v3, "city"

    .line 92
    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "state"

    .line 93
    invoke-virtual {p1, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "country"

    .line 94
    invoke-virtual {p1, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "timezone"

    .line 95
    invoke-virtual {p1, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const-string v7, "addressLine"

    .line 96
    invoke-virtual {p1, v7}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lcom/jibo/utils/Util;->e(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    const-string v8, "addressLine"

    .line 97
    invoke-virtual {p1, v8}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Lcom/jibo/utils/Util;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-direct/range {v0 .. v8}, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;-><init>(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 98
    new-instance v1, Lcom/google/gson/Gson;

    invoke-direct {v1}, Lcom/google/gson/Gson;-><init>()V

    invoke-virtual {v1, v0}, Lcom/google/gson/Gson;->a(Ljava/lang/Object;)Lcom/google/gson/JsonElement;

    move-result-object v1

    .line 100
    new-instance v2, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;

    iget-object v3, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/LocationFragment;

    .line 101
    invoke-static {v3}, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->b(Lcom/jibo/ui/fragment/account/skills/LocationFragment;)Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;->getValueDefinition()Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;->getKey()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData$UpdateSettingValue;

    .line 103
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v5

    invoke-virtual {v5}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getCurrentSkill()Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;

    move-result-object v5

    invoke-virtual {v5}, Lcom/jibo/ui/helpers/skills/DataItems$SkillDataItem;->getSkillId()Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/LocationFragment;

    .line 104
    invoke-static {v6}, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->b(Lcom/jibo/ui/fragment/account/skills/LocationFragment;)Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;

    move-result-object v6

    invoke-virtual {v6}, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;->getValueDefinition()Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;

    move-result-object v6

    invoke-virtual {v6}, Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;->getTarget()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v4, v5, v6, v1}, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData$UpdateSettingValue;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonElement;)V

    invoke-direct {v2, v3, v4}, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;-><init>(Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData$UpdateSettingValue;)V

    .line 107
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/LocationFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/utils/SharedPreferencesUtil;->f(Landroid/content/Context;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v1

    .line 109
    iget-object v3, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/LocationFragment;

    invoke-static {v3}, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->e(Lcom/jibo/ui/fragment/account/skills/LocationFragment;)Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

    move-result-object v3

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    new-instance v4, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1;

    invoke-direct {v4, p0, v9, v0}, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1;-><init>(Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;Landroid/text/SpannableStringBuilder;Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;)V

    invoke-virtual {v3, v1, v2, v4}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;->updateSkill(Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 134
    :catch_0
    move-exception v0

    goto/16 :goto_0
.end method
