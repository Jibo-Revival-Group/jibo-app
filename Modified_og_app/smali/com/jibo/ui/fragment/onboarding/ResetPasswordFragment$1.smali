.class Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$1;
.super Ljava/lang/Object;
.source "ResetPasswordFragment.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;)V
    .locals 0

    .prologue
    .line 59
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$1;->a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0

    .prologue
    .line 73
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 63
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment$1;->a:Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/onboarding/ResetPasswordFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->invalidateOptionsMenu()V

    .line 68
    return-void
.end method
