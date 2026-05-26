.class Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment$1;
.super Ljava/lang/Object;
.source "NetworkPwdFragment.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;)V
    .locals 0

    .prologue
    .line 43
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment$1;->a:Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment$1;->a:Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->a(Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;)V

    .line 53
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment$1;->a:Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->invalidateOptionsMenu()V

    .line 54
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 45
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 48
    return-void
.end method
