.class Lcom/jibo/ui/fragment/profile/ProfileFragment$2;
.super Ljava/lang/Object;
.source "ProfileFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/profile/ProfileFragment;->personalSettingsClick(Landroid/view/View;)V
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
        "Lcom/jibo/aws/integration/aws/services/skills/model/GetSettingsRequest;",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/profile/ProfileFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/profile/ProfileFragment;)V
    .locals 0

    .prologue
    .line 313
    iput-object p1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$2;->a:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/skills/model/GetSettingsRequest;Ljava/lang/String;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 321
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->clearSkills()V

    .line 322
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->parseSkills(Ljava/lang/String;)Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    .line 324
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$2;->a:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->g()V

    .line 326
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getViews([I)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    .line 328
    instance-of v1, v0, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;

    if-eqz v1, :cond_0

    move-object v1, v0

    check-cast v1, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;

    .line 329
    invoke-virtual {v1}, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;->getChildViews()Ljava/util/List;

    move-result-object v1

    if-eqz v1, :cond_1

    move-object v1, v0

    check-cast v1, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;

    .line 330
    invoke-virtual {v1}, Lcom/jibo/ui/helpers/skills/DataItems$GroupDataItem;->getChildViews()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1

    .line 332
    :cond_0
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v1

    invoke-virtual {v1, v4}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->selectSkill(I)V

    .line 334
    new-instance v1, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    iget-object v2, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$2;->a:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    .line 335
    invoke-virtual {v2}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getContext()Landroid/content/Context;

    move-result-object v2

    const-class v3, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    const-string v2, "PARAM_PATH"

    const/4 v3, 0x1

    new-array v3, v3, [I

    aput v4, v3, v4

    .line 336
    invoke-virtual {v1, v2, v3}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Ljava/io/Serializable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    move-result-object v1

    const-string v2, "PARAM_TITLE"

    .line 337
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getTitle()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Ljava/io/Serializable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    move-result-object v0

    .line 338
    const/16 v1, 0x3e9

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(I)V

    .line 342
    :cond_1
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 316
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$2;->a:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    const-string v1, "skills get skills json"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->a(Lcom/jibo/ui/fragment/profile/ProfileFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 317
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 313
    check-cast p1, Lcom/jibo/aws/integration/aws/services/skills/model/GetSettingsRequest;

    check-cast p2, Ljava/lang/String;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/profile/ProfileFragment$2;->a(Lcom/jibo/aws/integration/aws/services/skills/model/GetSettingsRequest;Ljava/lang/String;)V

    return-void
.end method
