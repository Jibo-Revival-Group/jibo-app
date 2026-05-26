.class Lcom/jibo/ui/fragment/invite/PreferredNameFragment$1;
.super Ljava/lang/Object;
.source "PreferredNameFragment.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->a()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/PreferredNameFragment;)V
    .locals 0

    .prologue
    .line 176
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$1;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 2

    .prologue
    .line 189
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$1;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->nickname:Landroid/widget/EditText;

    if-eqz v0, :cond_0

    .line 192
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$1;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->nicknameSkip:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$1;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->nickname:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setEnabled(Z)V

    .line 193
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$1;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->a(Lcom/jibo/ui/fragment/invite/PreferredNameFragment;)V

    .line 195
    :cond_0
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 180
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 185
    return-void
.end method
