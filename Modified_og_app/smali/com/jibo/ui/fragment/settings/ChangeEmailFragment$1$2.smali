.class Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1$2;
.super Ljava/lang/Object;
.source "ChangeEmailFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;->a(Lcom/jibo/aws/integration/aws/services/account/model/ChangeEmailRequest;Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;)V
    .locals 0

    .prologue
    .line 178
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1$2;->a:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 181
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1$2;->a:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;->a:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->g()V

    .line 183
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1$2;->a:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;->a:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->b:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 185
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1$2;->a:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;->a:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->b(Z)V

    .line 186
    return-void
.end method
