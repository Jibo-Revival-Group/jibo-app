.class Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$3;
.super Ljava/lang/Object;
.source "MediaFragment.java"

# interfaces
.implements Landroid/view/View$OnLongClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;)V
    .locals 0

    .prologue
    .line 1392
    iput-object p1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$3;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLongClick(Landroid/view/View;)Z
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 1395
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$3;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    invoke-static {v0, p1}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a(Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;Landroid/view/View;)I

    move-result v1

    .line 1397
    const/4 v0, -0x1

    if-eq v1, v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$3;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v0, v0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/RecyclerView;->findContainingViewHolder(Landroid/view/View;)Landroid/support/v7/widget/RecyclerView$ViewHolder;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;

    if-eqz v0, :cond_0

    .line 1399
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$3;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v0, v0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v4}, Landroid/support/v7/widget/RecyclerView;->performHapticFeedback(I)Z

    .line 1401
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$3;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    invoke-static {v0}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a(Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;)Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

    move-result-object v0

    invoke-virtual {v0, v1, v5}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;->a(IZ)V

    .line 1403
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$3;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v0, v0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->s(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/activity/TabbedActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/activity/TabbedActivity;->r()Landroid/support/v7/view/ActionMode;

    move-result-object v0

    if-nez v0, :cond_1

    .line 1405
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$3;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v0, v0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->t(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/activity/TabbedActivity;

    move-result-object v2

    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$3;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v0, v0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Landroid/support/v7/app/AppCompatActivity;

    iget-object v3, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$3;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v3, v3, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    .line 1406
    invoke-static {v3}, Lcom/jibo/ui/fragment/home/MediaFragment;->h(Lcom/jibo/ui/fragment/home/MediaFragment;)Landroid/support/v7/view/ActionMode$Callback;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/support/v7/app/AppCompatActivity;->startSupportActionMode(Landroid/support/v7/view/ActionMode$Callback;)Landroid/support/v7/view/ActionMode;

    move-result-object v0

    .line 1405
    invoke-virtual {v2, v0}, Lcom/jibo/ui/activity/TabbedActivity;->a(Landroid/support/v7/view/ActionMode;)V

    .line 1408
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$3;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$3;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v2, v2, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    .line 1409
    invoke-static {v2}, Lcom/jibo/ui/fragment/home/MediaFragment;->g(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->getItemCount()I

    move-result v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$3;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v3, v3, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v3}, Lcom/jibo/ui/fragment/home/MediaFragment;->h(Lcom/jibo/ui/fragment/home/MediaFragment;)Landroid/support/v7/view/ActionMode$Callback;

    move-result-object v3

    .line 1408
    invoke-virtual {v0, v4, v2, v3}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->notifyItemRangeChanged(IILjava/lang/Object;)V

    .line 1415
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$3;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v0, v0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->u(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/activity/TabbedActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/activity/TabbedActivity;->s()V

    .line 1417
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$3;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v0, v0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/home/MediaFragment;->a(Lcom/jibo/ui/fragment/home/MediaFragment;I)V

    .line 1419
    return v5

    .line 1412
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$3;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$3;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    invoke-static {v2}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a(Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;)Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->notifyItemChanged(ILjava/lang/Object;)V

    goto :goto_0
.end method
