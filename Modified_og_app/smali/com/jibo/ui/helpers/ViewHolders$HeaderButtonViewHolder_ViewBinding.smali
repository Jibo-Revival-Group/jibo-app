.class public Lcom/jibo/ui/helpers/ViewHolders$HeaderButtonViewHolder_ViewBinding;
.super Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder_ViewBinding;
.source "ViewHolders$HeaderButtonViewHolder_ViewBinding.java"


# instance fields
.field private b:Lcom/jibo/ui/helpers/ViewHolders$HeaderButtonViewHolder;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/helpers/ViewHolders$HeaderButtonViewHolder;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 17
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder_ViewBinding;-><init>(Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;Landroid/view/View;)V

    .line 19
    iput-object p1, p0, Lcom/jibo/ui/helpers/ViewHolders$HeaderButtonViewHolder_ViewBinding;->b:Lcom/jibo/ui/helpers/ViewHolders$HeaderButtonViewHolder;

    .line 21
    const v0, 0x1020019

    const-string v1, "field \'button\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/helpers/ViewHolders$HeaderButtonViewHolder;->button:Landroid/widget/TextView;

    .line 22
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 26
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$HeaderButtonViewHolder_ViewBinding;->b:Lcom/jibo/ui/helpers/ViewHolders$HeaderButtonViewHolder;

    .line 27
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 28
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$HeaderButtonViewHolder_ViewBinding;->b:Lcom/jibo/ui/helpers/ViewHolders$HeaderButtonViewHolder;

    .line 30
    iput-object v1, v0, Lcom/jibo/ui/helpers/ViewHolders$HeaderButtonViewHolder;->button:Landroid/widget/TextView;

    .line 32
    invoke-super {p0}, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder_ViewBinding;->unbind()V

    .line 33
    return-void
.end method
