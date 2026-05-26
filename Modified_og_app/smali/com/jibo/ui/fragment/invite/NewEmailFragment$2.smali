.class Lcom/jibo/ui/fragment/invite/NewEmailFragment$2;
.super Ljava/lang/Object;
.source "NewEmailFragment.java"

# interfaces
.implements Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$OnDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/invite/NewEmailFragment;->r()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/invite/NewEmailFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/NewEmailFragment;)V
    .locals 0

    .prologue
    .line 188
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment$2;->a:Lcom/jibo/ui/fragment/invite/NewEmailFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;)V
    .locals 3

    .prologue
    .line 191
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 192
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment$2;->a:Lcom/jibo/ui/fragment/invite/NewEmailFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/4 v2, -0x1

    invoke-virtual {v1, v2, v0}, Landroid/support/v4/app/FragmentActivity;->setResult(ILandroid/content/Intent;)V

    .line 193
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment$2;->a:Lcom/jibo/ui/fragment/invite/NewEmailFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 194
    return-void
.end method
