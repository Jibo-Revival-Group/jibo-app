.class Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment$2$1;
.super Ljava/lang/Object;
.source "ResetPasswordNewPasswordFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment$2;->onError(Ljava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment$2;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment$2;)V
    .locals 0

    .prologue
    .line 167
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment$2$1;->a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 170
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment$2$1;->a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->b(Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;)Landroid/view/MenuItem;

    move-result-object v0

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 171
    return-void
.end method
