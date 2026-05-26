.class Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$2;
.super Ljava/lang/Object;
.source "ChangeEmailFragment.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;)V
    .locals 0

    .prologue
    .line 205
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$2;->a:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0

    .prologue
    .line 221
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 210
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 1

    .prologue
    .line 214
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$2;->a:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->invalidateOptionsMenu()V

    .line 215
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$2;->a:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->b(Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;)V

    .line 216
    return-void
.end method
