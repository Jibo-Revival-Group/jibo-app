.class Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$3;
.super Ljava/lang/Object;
.source "LegalGuardianFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->b(Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V
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
        "Lcom/jibo/aws/integration/aws/services/loop/model/SetLegalGuardianRequest;",
        "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

.field final synthetic b:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V
    .locals 0

    .prologue
    .line 173
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$3;->b:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$3;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/loop/model/SetLegalGuardianRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V
    .locals 4

    .prologue
    .line 183
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$3;->b:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$3;->b:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->d(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getRobot()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$3;->b:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    iget-object v2, v2, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-static {v0, v1, v2, v3}, Lcom/jibo/JiboAnalytics;->a(Landroid/content/Context;Ljava/lang/String;J)V

    .line 185
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$3;->b:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->d:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 186
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$3;->b:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccountId()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$3;->b:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v1

    .line 187
    invoke-virtual {v1}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v1

    .line 186
    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 188
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$3;->b:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->e(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$3;->b:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    const v2, 0x7f1001e3

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Ljava/lang/String;)V

    .line 195
    :goto_0
    return-void

    .line 190
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$3;->b:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->f(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$3;->b:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    const v2, 0x7f1001e2

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Ljava/lang/String;)V

    goto :goto_0

    .line 193
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$3;->b:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$3;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V

    goto :goto_0
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 176
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$3;->b:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->c(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$3;->b:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    const v2, 0x7f100118

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b(Ljava/lang/String;)V

    .line 178
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$3;->b:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    const-string v1, "set legal guardian"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->b(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 179
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 173
    check-cast p1, Lcom/jibo/aws/integration/aws/services/loop/model/SetLegalGuardianRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$3;->a(Lcom/jibo/aws/integration/aws/services/loop/model/SetLegalGuardianRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V

    return-void
.end method
