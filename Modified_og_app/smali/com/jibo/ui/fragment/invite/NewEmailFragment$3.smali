.class Lcom/jibo/ui/fragment/invite/NewEmailFragment$3;
.super Ljava/lang/Object;
.source "NewEmailFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/invite/NewEmailFragment;->r()V
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
        "Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberRequest;",
        "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/invite/NewEmailFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/NewEmailFragment;)V
    .locals 0

    .prologue
    .line 202
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment$3;->a:Lcom/jibo/ui/fragment/invite/NewEmailFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberRequest;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 3

    .prologue
    .line 212
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment$3;->a:Lcom/jibo/ui/fragment/invite/NewEmailFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->c(Lcom/jibo/ui/fragment/invite/NewEmailFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment$3;->a:Lcom/jibo/ui/fragment/invite/NewEmailFragment;

    const v2, 0x7f10013c

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Ljava/lang/String;)V

    .line 215
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment$3;->a:Lcom/jibo/ui/fragment/invite/NewEmailFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->d(Lcom/jibo/ui/fragment/invite/NewEmailFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v0

    sget-object v1, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;->invited:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->setStatus(Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;)V

    .line 218
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment$3;->a:Lcom/jibo/ui/fragment/invite/NewEmailFragment;

    new-instance v1, Lcom/jibo/ui/fragment/invite/NewEmailFragment$3$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/invite/NewEmailFragment$3$1;-><init>(Lcom/jibo/ui/fragment/invite/NewEmailFragment$3;Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberRequest;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->a(Ljava/lang/Runnable;)V

    .line 228
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 205
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment$3;->a:Lcom/jibo/ui/fragment/invite/NewEmailFragment;

    const-string v1, "sending gallery invite"

    const/4 v2, 0x1

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->a(Lcom/jibo/ui/fragment/invite/NewEmailFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 207
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment$3;->a:Lcom/jibo/ui/fragment/invite/NewEmailFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->b(Lcom/jibo/ui/fragment/invite/NewEmailFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment$3;->a:Lcom/jibo/ui/fragment/invite/NewEmailFragment;

    const v2, 0x7f10013b

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b(Ljava/lang/String;)V

    .line 208
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 202
    check-cast p1, Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/invite/NewEmailFragment$3;->a(Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberRequest;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    return-void
.end method
