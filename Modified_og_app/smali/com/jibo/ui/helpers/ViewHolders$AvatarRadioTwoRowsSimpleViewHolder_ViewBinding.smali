.class public Lcom/jibo/ui/helpers/ViewHolders$AvatarRadioTwoRowsSimpleViewHolder_ViewBinding;
.super Lcom/jibo/ui/helpers/ViewHolders$AvatarTwoRowsSimpleViewHolder_ViewBinding;
.source "ViewHolders$AvatarRadioTwoRowsSimpleViewHolder_ViewBinding.java"


# instance fields
.field private b:Lcom/jibo/ui/helpers/ViewHolders$AvatarRadioTwoRowsSimpleViewHolder;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/helpers/ViewHolders$AvatarRadioTwoRowsSimpleViewHolder;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 18
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/helpers/ViewHolders$AvatarTwoRowsSimpleViewHolder_ViewBinding;-><init>(Lcom/jibo/ui/helpers/ViewHolders$AvatarTwoRowsSimpleViewHolder;Landroid/view/View;)V

    .line 20
    iput-object p1, p0, Lcom/jibo/ui/helpers/ViewHolders$AvatarRadioTwoRowsSimpleViewHolder_ViewBinding;->b:Lcom/jibo/ui/helpers/ViewHolders$AvatarRadioTwoRowsSimpleViewHolder;

    .line 22
    const v0, 0x7f0900e6

    const-string v1, "field \'mCompoundButton\'"

    const-class v2, Landroid/widget/CompoundButton;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/CompoundButton;

    iput-object v0, p1, Lcom/jibo/ui/helpers/ViewHolders$AvatarRadioTwoRowsSimpleViewHolder;->mCompoundButton:Landroid/widget/CompoundButton;

    .line 23
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 27
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AvatarRadioTwoRowsSimpleViewHolder_ViewBinding;->b:Lcom/jibo/ui/helpers/ViewHolders$AvatarRadioTwoRowsSimpleViewHolder;

    .line 28
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 29
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$AvatarRadioTwoRowsSimpleViewHolder_ViewBinding;->b:Lcom/jibo/ui/helpers/ViewHolders$AvatarRadioTwoRowsSimpleViewHolder;

    .line 31
    iput-object v1, v0, Lcom/jibo/ui/helpers/ViewHolders$AvatarRadioTwoRowsSimpleViewHolder;->mCompoundButton:Landroid/widget/CompoundButton;

    .line 33
    invoke-super {p0}, Lcom/jibo/ui/helpers/ViewHolders$AvatarTwoRowsSimpleViewHolder_ViewBinding;->unbind()V

    .line 34
    return-void
.end method
