.class Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$3;
.super Ljava/lang/Object;
.source "ConfirmPasswordFragment.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;)V
    .locals 0

    .prologue
    .line 219
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$3;->a:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0

    .prologue
    .line 235
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 224
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 1

    .prologue
    .line 228
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$3;->a:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->invalidateOptionsMenu()V

    .line 229
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$3;->a:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->b(Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;)V

    .line 230
    return-void
.end method
