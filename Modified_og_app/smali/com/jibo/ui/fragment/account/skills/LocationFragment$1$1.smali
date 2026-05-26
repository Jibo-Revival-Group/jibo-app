.class Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1;
.super Ljava/lang/Object;
.source "LocationFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;->a(Landroid/os/Bundle;)V
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
.field final synthetic a:Landroid/text/SpannableStringBuilder;

.field final synthetic b:Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;

.field final synthetic c:Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;Landroid/text/SpannableStringBuilder;Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;)V
    .locals 0

    .prologue
    .line 109
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1;->c:Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;

    iput-object p2, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1;->a:Landroid/text/SpannableStringBuilder;

    iput-object p3, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1;->b:Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest;Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;)V
    .locals 3

    .prologue
    .line 118
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1;->c:Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;

    iget-object v1, v1, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/LocationFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->b(Lcom/jibo/ui/fragment/account/skills/LocationFragment;)Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;->getValueDefinition()Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;->getKey()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1;->b:Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->updateData(Ljava/lang/String;Lcom/jibo/ui/helpers/skills/DataItems$DataValue;)V

    .line 119
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1;->c:Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;

    iget-object v1, v1, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/LocationFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->b(Lcom/jibo/ui/fragment/account/skills/LocationFragment;)Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->setItemDataValue(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    .line 120
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1;->c:Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/LocationFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1;->b:Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->a(Lcom/jibo/ui/fragment/account/skills/LocationFragment;Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;)Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;

    .line 122
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1;->c:Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/LocationFragment;

    new-instance v1, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1$1;-><init>(Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->a(Ljava/lang/Runnable;)V

    .line 131
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 112
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1;->c:Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/LocationFragment;

    const-string v1, "skills update skill"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->a(Lcom/jibo/ui/fragment/account/skills/LocationFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 113
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1;->c:Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/LocationFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->c(Lcom/jibo/ui/fragment/account/skills/LocationFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1;->a:Landroid/text/SpannableStringBuilder;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b(Landroid/text/SpannableStringBuilder;)V

    .line 114
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 109
    check-cast p1, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1;->a(Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest;Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;)V

    return-void
.end method
