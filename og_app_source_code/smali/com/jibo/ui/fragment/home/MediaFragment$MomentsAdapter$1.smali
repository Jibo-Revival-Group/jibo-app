.class Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$1;
.super Ljava/lang/Object;
.source "MediaFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


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
    .line 1333
    iput-object p1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$1;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 1336
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;

    .line 1337
    iget v1, v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;->d:I

    :goto_0
    iget v2, v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;->e:I

    if-gt v1, v2, :cond_0

    .line 1338
    iget-object v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$1;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    invoke-static {v2}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a(Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;)Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

    move-result-object v2

    const/4 v3, 0x1

    invoke-virtual {v2, v1, v3}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;->a(IZ)V

    .line 1337
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 1340
    :cond_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$1;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v1, v1, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/home/MediaFragment;->n(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/activity/TabbedActivity;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/ui/activity/TabbedActivity;->r()Landroid/support/v7/view/ActionMode;

    move-result-object v1

    if-nez v1, :cond_1

    .line 1342
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$1;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v0, v0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->o(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/activity/TabbedActivity;

    move-result-object v1

    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$1;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v0, v0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Landroid/support/v7/app/AppCompatActivity;

    iget-object v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$1;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v2, v2, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    .line 1343
    invoke-static {v2}, Lcom/jibo/ui/fragment/home/MediaFragment;->h(Lcom/jibo/ui/fragment/home/MediaFragment;)Landroid/support/v7/view/ActionMode$Callback;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/support/v7/app/AppCompatActivity;->startSupportActionMode(Landroid/support/v7/view/ActionMode$Callback;)Landroid/support/v7/view/ActionMode;

    move-result-object v0

    .line 1342
    invoke-virtual {v1, v0}, Lcom/jibo/ui/activity/TabbedActivity;->a(Landroid/support/v7/view/ActionMode;)V

    .line 1345
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$1;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$1;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$1;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v2, v2, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    iget-object v2, v2, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/support/v7/widget/RecyclerView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a(Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;Landroid/view/View;)I

    move-result v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$1;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v2, v2, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    iget-object v2, v2, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    .line 1346
    invoke-virtual {v2}, Landroid/support/v7/widget/RecyclerView;->getChildCount()I

    move-result v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$1;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v3, v3, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v3}, Lcom/jibo/ui/fragment/home/MediaFragment;->h(Lcom/jibo/ui/fragment/home/MediaFragment;)Landroid/support/v7/view/ActionMode$Callback;

    move-result-object v3

    .line 1345
    invoke-virtual {v0, v1, v2, v3}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->notifyItemRangeChanged(IILjava/lang/Object;)V

    .line 1352
    :goto_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$1;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v0, v0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->p(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/activity/TabbedActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/activity/TabbedActivity;->s()V

    .line 1353
    return-void

    .line 1349
    :cond_1
    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$1;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget v2, v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;->d:I

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->notifyItemChanged(I)V

    .line 1350
    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$1;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget v2, v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;->d:I

    iget v3, v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;->e:I

    iget v0, v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;->d:I

    sub-int v0, v3, v0

    add-int/lit8 v0, v0, 0x1

    iget-object v3, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$1;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    invoke-static {v3}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a(Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;)Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

    move-result-object v3

    invoke-virtual {v1, v2, v0, v3}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->notifyItemRangeChanged(IILjava/lang/Object;)V

    goto :goto_1
.end method
