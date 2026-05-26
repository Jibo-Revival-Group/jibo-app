.class Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2$1;
.super Ljava/lang/Object;
.source "SkillSettingsFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2;->a(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;Lcom/jibo/ui/helpers/skills/DataItems$DataValue;Lcom/jibo/aws/integration/util/Commons$AsyncCallback;)V
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
        "Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest;",
        "Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

.field final synthetic b:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V
    .locals 0

    .prologue
    .line 132
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2$1;->b:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2;

    iput-object p2, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2$1;->a:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest;Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;)V
    .locals 3

    .prologue
    .line 140
    new-instance v0, Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataValue;

    invoke-direct {v0}, Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataValue;-><init>()V

    .line 141
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/jibo/ui/helpers/skills/DataItems$ConnectableDataValue;->setConnected(Z)V

    .line 143
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2$1;->a:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getValueDefinition()Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;->getKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->updateData(Ljava/lang/String;Lcom/jibo/ui/helpers/skills/DataItems$DataValue;)V

    .line 144
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v1

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2$1;->b:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2;->a:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;

    .line 146
    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->a(Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;)Ljava/util/List;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2$1;->a:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getIndex()I

    move-result v2

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;->getDataItem()Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    move-result-object v0

    .line 144
    invoke-virtual {v1, v0}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->setItemDataValue(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    .line 148
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2$1;->b:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2;->a:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->b(Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;)Lcom/jibo/ui/helpers/skills/SkillBasedRecycleViewAdapter;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2$1;->a:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-virtual {v1}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getIndex()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/helpers/skills/SkillBasedRecycleViewAdapter;->notifyItemChanged(I)V

    .line 150
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2$1;->b:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2;->a:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->g()V

    .line 151
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 135
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2$1;->b:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2;->a:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;

    const-string v1, "skills delete skill"

    const/4 v2, 0x1

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->b(Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 136
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 132
    check-cast p1, Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2$1;->a(Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest;Lcom/jibo/aws/integration/aws/services/skills/model/DeleteSettingsRequest$DeleteSettingData;)V

    return-void
.end method
