.class public Lcom/jibo/ui/fragment/avatar/AvatarViewHolder;
.super Landroid/support/v7/widget/RecyclerView$ViewHolder;
.source "AvatarViewHolder.java"


# instance fields
.field public avatar:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0, p1}, Landroid/support/v7/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V

    .line 24
    invoke-static {p0, p1}, Lbutterknife/ButterKnife;->a(Ljava/lang/Object;Landroid/view/View;)Lbutterknife/Unbinder;

    .line 25
    return-void
.end method


# virtual methods
.method public a(IZ)V
    .locals 4

    .prologue
    .line 28
    iget-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarViewHolder;->avatar:Landroid/widget/ImageView;

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setImageLevel(I)V

    .line 30
    if-eqz p2, :cond_0

    .line 31
    const/4 v0, 0x4

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    .line 32
    rem-int/lit8 v1, p1, 0x4

    .line 33
    iget-object v2, p0, Lcom/jibo/ui/fragment/avatar/AvatarViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f080120

    aget v0, v0, v1

    invoke-static {v2, v3, v0}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 34
    iget-object v1, p0, Lcom/jibo/ui/fragment/avatar/AvatarViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v1, v0}, Landroid/view/View;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 39
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarViewHolder;->itemView:Landroid/view/View;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 40
    return-void

    .line 36
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarViewHolder;->itemView:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setBackgroundResource(I)V

    goto :goto_0

    .line 31
    :array_0
    .array-data 4
        0x7f06007b
        0x7f06009f
        0x7f0600e1
        0x7f060078
    .end array-data
.end method
