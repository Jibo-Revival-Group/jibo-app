.class Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$1;
.super Ljava/lang/Object;
.source "ChangePasswordFragment.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;)V
    .locals 0

    .prologue
    .line 53
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$1;->a:Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0

    .prologue
    .line 70
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 58
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 2

    .prologue
    .line 62
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$1;->a:Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->invalidateOptionsMenu()V

    .line 64
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$1;->a:Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$1;->a:Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->a(Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;)Z

    move-result v1

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->a(Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;Z)V

    .line 65
    return-void
.end method
