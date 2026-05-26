.class Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$1$1;
.super Ljava/lang/Object;
.source "SkillSettingsFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$1;->a(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;Lcom/jibo/ui/helpers/skills/DataItems$DataValue;Lcom/jibo/aws/integration/util/Commons$AsyncCallback;)V
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

.field final synthetic b:Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

.field final synthetic c:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$1;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;Lcom/jibo/ui/helpers/skills/DataItems$DataValue;)V
    .locals 0

    .prologue
    .line 88
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$1$1;->c:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$1;

    iput-object p2, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$1$1;->a:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    iput-object p3, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$1$1;->b:Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest;Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;)V
    .locals 3

    .prologue
    .line 96
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$1$1;->a:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-virtual {v1}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getValueDefinition()Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;->getKey()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$1$1;->b:Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->updateData(Ljava/lang/String;Lcom/jibo/ui/helpers/skills/DataItems$DataValue;)V

    .line 97
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v1

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$1$1;->c:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;

    .line 99
    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->a(Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;)Ljava/util/List;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$1$1;->a:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-virtual {v2}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getIndex()I

    move-result v2

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;->getDataItem()Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    move-result-object v0

    .line 97
    invoke-virtual {v1, v0}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->setItemDataValue(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    .line 101
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$1$1;->c:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->b(Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;)Lcom/jibo/ui/helpers/skills/SkillBasedRecycleViewAdapter;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$1$1;->a:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-virtual {v1}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getIndex()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/helpers/skills/SkillBasedRecycleViewAdapter;->notifyItemChanged(I)V

    .line 103
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$1$1;->c:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->g()V

    .line 104
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 91
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$1$1;->c:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;

    const-string v1, "skills update skill"

    const/4 v2, 0x1

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->a(Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 92
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 88
    check-cast p1, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$1$1;->a(Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest;Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;)V

    return-void
.end method
