.class public Lcom/jibo/ui/fragment/home/MediaFragment$HeaderViewHolder_ViewBinding;
.super Ljava/lang/Object;
.source "MediaFragment$HeaderViewHolder_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/home/MediaFragment$HeaderViewHolder;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/home/MediaFragment$HeaderViewHolder;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderViewHolder_ViewBinding;->b:Lcom/jibo/ui/fragment/home/MediaFragment$HeaderViewHolder;

    .line 22
    const v0, 0x1020014

    const-string v1, "field \'text1\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderViewHolder;->text1:Landroid/widget/TextView;

    .line 23
    const v0, 0x7f090089

    const-string v1, "field \'selectAll\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderViewHolder;->selectAll:Landroid/widget/TextView;

    .line 24
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 29
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderViewHolder_ViewBinding;->b:Lcom/jibo/ui/fragment/home/MediaFragment$HeaderViewHolder;

    .line 30
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 31
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderViewHolder_ViewBinding;->b:Lcom/jibo/ui/fragment/home/MediaFragment$HeaderViewHolder;

    .line 33
    iput-object v1, v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderViewHolder;->text1:Landroid/widget/TextView;

    .line 34
    iput-object v1, v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderViewHolder;->selectAll:Landroid/widget/TextView;

    .line 35
    return-void
.end method
