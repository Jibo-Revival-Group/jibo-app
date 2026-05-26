.class public Lcom/jibo/ui/fragment/avatar/AvatarsAdapter;
.super Landroid/support/v7/widget/RecyclerView$Adapter;
.source "AvatarsAdapter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/support/v7/widget/RecyclerView$Adapter",
        "<",
        "Landroid/support/v7/widget/RecyclerView$ViewHolder;",
        ">;"
    }
.end annotation


# instance fields
.field private a:I

.field private b:Landroid/view/View$OnClickListener;

.field private c:I


# direct methods
.method public constructor <init>(IILandroid/view/View$OnClickListener;)V
    .locals 1

    .prologue
    .line 18
    invoke-direct {p0}, Landroid/support/v7/widget/RecyclerView$Adapter;-><init>()V

    .line 14
    const/4 v0, 0x0

    iput v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarsAdapter;->a:I

    .line 19
    iput p1, p0, Lcom/jibo/ui/fragment/avatar/AvatarsAdapter;->c:I

    .line 20
    iput p2, p0, Lcom/jibo/ui/fragment/avatar/AvatarsAdapter;->a:I

    .line 21
    iput-object p3, p0, Lcom/jibo/ui/fragment/avatar/AvatarsAdapter;->b:Landroid/view/View$OnClickListener;

    .line 22
    return-void
.end method


# virtual methods
.method public a(I)V
    .locals 0

    .prologue
    .line 45
    iput p1, p0, Lcom/jibo/ui/fragment/avatar/AvatarsAdapter;->a:I

    .line 46
    return-void
.end method

.method public getItemCount()I
    .locals 1

    .prologue
    .line 41
    const/16 v0, 0xc

    return v0
.end method

.method public onBindViewHolder(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V
    .locals 1

    .prologue
    .line 36
    check-cast p1, Lcom/jibo/ui/fragment/avatar/AvatarViewHolder;

    iget v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarsAdapter;->a:I

    if-ne p2, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p1, p2, v0}, Lcom/jibo/ui/fragment/avatar/AvatarViewHolder;->a(IZ)V

    .line 37
    return-void

    .line 36
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onCreateViewHolder(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;
    .locals 3

    .prologue
    .line 28
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iget v1, p0, Lcom/jibo/ui/fragment/avatar/AvatarsAdapter;->c:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 29
    new-instance v1, Lcom/jibo/ui/fragment/avatar/AvatarViewHolder;

    invoke-direct {v1, v0}, Lcom/jibo/ui/fragment/avatar/AvatarViewHolder;-><init>(Landroid/view/View;)V

    .line 30
    iget-object v2, p0, Lcom/jibo/ui/fragment/avatar/AvatarsAdapter;->b:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 31
    return-object v1
.end method
