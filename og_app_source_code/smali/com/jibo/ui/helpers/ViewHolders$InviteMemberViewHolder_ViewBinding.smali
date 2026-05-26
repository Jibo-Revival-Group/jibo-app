.class public Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder_ViewBinding;
.super Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder_ViewBinding;
.source "ViewHolders$InviteMemberViewHolder_ViewBinding.java"


# instance fields
.field private b:Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;Landroid/view/View;)V
    .locals 2

    .prologue
    .line 17
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder_ViewBinding;-><init>(Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;Landroid/view/View;)V

    .line 19
    iput-object p1, p0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder_ViewBinding;->b:Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;

    .line 21
    const v0, 0x7f090230

    const-string v1, "field \'pulseView\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;->pulseView:Landroid/view/View;

    .line 22
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 26
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder_ViewBinding;->b:Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;

    .line 27
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 28
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder_ViewBinding;->b:Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;

    .line 30
    iput-object v1, v0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;->pulseView:Landroid/view/View;

    .line 32
    invoke-super {p0}, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder_ViewBinding;->unbind()V

    .line 33
    return-void
.end method
