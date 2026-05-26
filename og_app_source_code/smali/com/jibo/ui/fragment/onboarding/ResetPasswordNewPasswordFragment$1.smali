.class Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment$1;
.super Ljava/lang/Object;
.source "ResetPasswordNewPasswordFragment.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;)V
    .locals 0

    .prologue
    .line 71
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment$1;->a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0

    .prologue
    .line 87
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 75
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 2

    .prologue
    .line 79
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment$1;->a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->invalidateOptionsMenu()V

    .line 81
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment$1;->a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment$1;->a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->a(Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;)Z

    move-result v1

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;->a(Lcom/jibo/ui/fragment/onboarding/ResetPasswordNewPasswordFragment;Z)V

    .line 82
    return-void
.end method
