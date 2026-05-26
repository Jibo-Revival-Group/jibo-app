.class Lcom/jibo/ui/fragment/home/MediaFragment$5;
.super Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;
.source "MediaFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/home/MediaFragment;->b()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic b:Lcom/jibo/ui/fragment/home/MediaFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/home/MediaFragment;)V
    .locals 0

    .prologue
    .line 513
    iput-object p1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$5;->b:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-direct {p0}, Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;-><init>()V

    return-void
.end method


# virtual methods
.method public a(I)I
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 516
    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$5;->b:Lcom/jibo/ui/fragment/home/MediaFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$5;->b:Lcom/jibo/ui/fragment/home/MediaFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v1}, Landroid/support/v7/widget/RecyclerView;->getAdapter()Landroid/support/v7/widget/RecyclerView$Adapter;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 517
    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$5;->b:Lcom/jibo/ui/fragment/home/MediaFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v1}, Landroid/support/v7/widget/RecyclerView;->getAdapter()Landroid/support/v7/widget/RecyclerView$Adapter;

    move-result-object v1

    invoke-virtual {v1, p1}, Landroid/support/v7/widget/RecyclerView$Adapter;->getItemViewType(I)I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 529
    :cond_0
    :goto_0
    return v0

    .line 520
    :pswitch_0
    invoke-static {}, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper;->b()I

    move-result v0

    goto :goto_0

    .line 522
    :pswitch_1
    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$5;->b:Lcom/jibo/ui/fragment/home/MediaFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$5;->b:Lcom/jibo/ui/fragment/home/MediaFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v1}, Landroid/support/v7/widget/RecyclerView;->getAdapter()Landroid/support/v7/widget/RecyclerView$Adapter;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 523
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$5;->b:Lcom/jibo/ui/fragment/home/MediaFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->getAdapter()Landroid/support/v7/widget/RecyclerView$Adapter;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    invoke-static {v0, p1}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a(Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;I)I

    move-result v0

    goto :goto_0

    .line 517
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
