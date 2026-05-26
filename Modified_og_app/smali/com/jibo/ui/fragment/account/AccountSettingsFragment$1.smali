.class Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1;
.super Ljava/lang/Object;
.source "AccountSettingsFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->b()V
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
.field final synthetic a:Lcom/jibo/ui/fragment/account/AccountSettingsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/AccountSettingsFragment;)V
    .locals 0

    .prologue
    .line 173
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1;->a:Lcom/jibo/ui/fragment/account/AccountSettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/skills/model/GetSettingsRequest;Ljava/lang/String;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 194
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->parseSkills(Ljava/lang/String;)Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    .line 196
    new-instance v0, Lcom/jibo/ui/helpers/skills/ItemFactory;

    invoke-direct {v0, v2, v2}, Lcom/jibo/ui/helpers/skills/ItemFactory;-><init>([ILcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;)V

    .line 198
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v1

    invoke-virtual {v1, v2}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getViews([I)Ljava/util/List;

    move-result-object v1

    .line 197
    invoke-virtual {v0, v1}, Lcom/jibo/ui/helpers/skills/ItemFactory;->getItems(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    .line 200
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1;->a:Lcom/jibo/ui/fragment/account/AccountSettingsFragment;

    new-instance v2, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1$2;

    invoke-direct {v2, p0, v0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1$2;-><init>(Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1;Ljava/util/List;)V

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->a(Ljava/lang/Runnable;)V

    .line 210
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 176
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1;->a:Lcom/jibo/ui/fragment/account/AccountSettingsFragment;

    new-instance v1, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1$1;-><init>(Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->a(Ljava/lang/Runnable;)V

    .line 183
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1;->a:Lcom/jibo/ui/fragment/account/AccountSettingsFragment;

    const-string v1, "skills get skills json"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->a(Lcom/jibo/ui/fragment/account/AccountSettingsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    move-object v0, p1

    .line 185
    check-cast v0, Lcom/amazonaws/AmazonServiceException;

    invoke-static {v0}, Lcom/jibo/utils/ErrorHelper;->b(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_0

    check-cast p1, Lcom/amazonaws/AmazonServiceException;

    .line 186
    invoke-static {p1}, Lcom/jibo/utils/ErrorHelper;->a(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 190
    :cond_0
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 173
    check-cast p1, Lcom/jibo/aws/integration/aws/services/skills/model/GetSettingsRequest;

    check-cast p2, Ljava/lang/String;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1;->a(Lcom/jibo/aws/integration/aws/services/skills/model/GetSettingsRequest;Ljava/lang/String;)V

    return-void
.end method
