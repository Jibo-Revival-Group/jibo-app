.class Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2$2;
.super Ljava/lang/Object;
.source "ConfirmPasswordFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2;->a(Lcom/jibo/aws/integration/aws/services/account/model/ChangePasswordRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2;)V
    .locals 0

    .prologue
    .line 194
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2$2;->a:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 197
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2$2;->a:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2;->a:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->g()V

    .line 199
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2$2;->a:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2;->a:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->c:Landroid/view/MenuItem;

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 201
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2$2;->a:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2;->a:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->a()V

    .line 202
    return-void
.end method
