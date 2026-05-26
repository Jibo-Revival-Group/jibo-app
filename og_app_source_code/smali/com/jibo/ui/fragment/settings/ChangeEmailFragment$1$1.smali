.class Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1$1;
.super Ljava/lang/Object;
.source "ChangeEmailFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;->onError(Ljava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/Exception;

.field final synthetic b:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;Ljava/lang/Exception;)V
    .locals 0

    .prologue
    .line 153
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1$1;->b:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;

    iput-object p2, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1$1;->a:Ljava/lang/Exception;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 157
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1$1;->b:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;->a:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->g()V

    .line 159
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1$1;->b:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;->a:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->b:Landroid/view/MenuItem;

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 163
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1$1;->a:Ljava/lang/Exception;

    check-cast v0, Lcom/amazonaws/AmazonServiceException;

    invoke-virtual {v0}, Lcom/amazonaws/AmazonServiceException;->getErrorCode()Ljava/lang/String;

    move-result-object v0

    const-string v1, "EMAIL_ALREADY_EXISTS"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 165
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1$1;->b:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;->a:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->b:Landroid/view/MenuItem;

    invoke-interface {v0, v2}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 166
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1$1;->b:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;->a:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->footerError:Landroid/widget/TextView;

    const v1, 0x7f10009c

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 167
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1$1;->b:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;->a:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->a(Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;)V

    .line 171
    :goto_0
    return-void

    .line 169
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1$1;->b:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;->a:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;

    invoke-virtual {v0, v2}, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->b(Z)V

    goto :goto_0
.end method
