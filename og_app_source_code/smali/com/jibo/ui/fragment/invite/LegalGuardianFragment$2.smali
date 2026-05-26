.class Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2;
.super Ljava/lang/Object;
.source "LegalGuardianFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->r()V
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
        "Lcom/jibo/aws/integration/aws/services/loop/model/InviteMemberRequest;",
        "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;)V
    .locals 0

    .prologue
    .line 134
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2;->a:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/loop/model/InviteMemberRequest;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 2

    .prologue
    .line 145
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2;->a:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    new-instance v1, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2$1;

    invoke-direct {v1, p0, p2}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2$1;-><init>(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->a(Ljava/lang/Runnable;)V

    .line 166
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 138
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2;->a:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->a(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2;->a:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    const v2, 0x7f100118

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b(Ljava/lang/String;)V

    .line 140
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2;->a:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    const-string v1, "invite member"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->a(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 141
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 134
    check-cast p1, Lcom/jibo/aws/integration/aws/services/loop/model/InviteMemberRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment$2;->a(Lcom/jibo/aws/integration/aws/services/loop/model/InviteMemberRequest;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    return-void
.end method
