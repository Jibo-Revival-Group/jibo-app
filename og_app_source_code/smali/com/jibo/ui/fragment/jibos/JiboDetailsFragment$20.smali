.class Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$20;
.super Ljava/lang/Object;
.source "JiboDetailsFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->A()V
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
.field final synthetic a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V
    .locals 0

    .prologue
    .line 1131
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$20;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/skills/model/GetSettingsRequest;Ljava/lang/String;)V
    .locals 6

    .prologue
    const/4 v1, 0x1

    .line 1140
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->clearSkills()V

    .line 1141
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->parseSkills(Ljava/lang/String;)Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    .line 1143
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->isConfigured()Z

    move-result v0

    if-nez v0, :cond_1

    move v0, v1

    .line 1145
    :goto_0
    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$20;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-virtual {v2}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->g()V

    .line 1147
    if-eqz v0, :cond_0

    .line 1148
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$20;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0, v1}, Lcom/jibo/utils/SharedPreferencesUtil;->b(Landroid/content/Context;Z)V

    .line 1149
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$20;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    const/16 v1, 0x7c

    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$20;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    const v3, 0x7f100247

    .line 1152
    invoke-virtual {v2, v3}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$20;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    const v4, 0x7f100245

    .line 1153
    invoke-virtual {v3, v4}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$20;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    const v5, 0x7f100246

    .line 1154
    invoke-virtual {v4, v5}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 1149
    invoke-static {v0, v1, v2, v3, v4}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->a(Landroid/support/v4/app/Fragment;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 1156
    :cond_0
    return-void

    .line 1143
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 1134
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$20;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    const-string v1, "skills get skills json"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->e(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 1135
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1131
    check-cast p1, Lcom/jibo/aws/integration/aws/services/skills/model/GetSettingsRequest;

    check-cast p2, Ljava/lang/String;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$20;->a(Lcom/jibo/aws/integration/aws/services/skills/model/GetSettingsRequest;Ljava/lang/String;)V

    return-void
.end method
