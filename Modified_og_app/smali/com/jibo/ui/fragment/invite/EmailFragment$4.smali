.class Lcom/jibo/ui/fragment/invite/EmailFragment$4;
.super Ljava/lang/Object;
.source "EmailFragment.java"

# interfaces
.implements Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$OnDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/invite/EmailFragment;->t()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/invite/EmailFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/EmailFragment;)V
    .locals 0

    .prologue
    .line 284
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment$4;->a:Lcom/jibo/ui/fragment/invite/EmailFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;)V
    .locals 3

    .prologue
    .line 287
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 288
    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/EmailFragment$4;->a:Lcom/jibo/ui/fragment/invite/EmailFragment;

    iget-object v2, v2, Lcom/jibo/ui/fragment/invite/EmailFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 289
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment$4;->a:Lcom/jibo/ui/fragment/invite/EmailFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/invite/EmailFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/4 v2, -0x1

    invoke-virtual {v1, v2, v0}, Landroid/support/v4/app/FragmentActivity;->setResult(ILandroid/content/Intent;)V

    .line 290
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment$4;->a:Lcom/jibo/ui/fragment/invite/EmailFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/EmailFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 291
    return-void
.end method
