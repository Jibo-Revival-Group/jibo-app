.class Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$2;
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
    .line 1356
    iput-object p1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 1359
    iget-object v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    invoke-static {v2, p1}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a(Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;Landroid/view/View;)I

    move-result v2

    .line 1361
    const/4 v3, -0x1

    if-eq v2, v3, :cond_0

    iget-object v3, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v3, v3, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    iget-object v3, v3, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v3, p1}, Landroid/support/v7/widget/RecyclerView;->getChildViewHolder(Landroid/view/View;)Landroid/support/v7/widget/RecyclerView$ViewHolder;

    move-result-object v3

    instance-of v3, v3, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;

    if-nez v3, :cond_1

    .line 1389
    :cond_0
    :goto_0
    return-void

    .line 1365
    :cond_1
    iget-object v3, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v3, v3, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v3}, Lcom/jibo/ui/fragment/home/MediaFragment;->q(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/activity/TabbedActivity;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/ui/activity/TabbedActivity;->r()Landroid/support/v7/view/ActionMode;

    move-result-object v3

    if-nez v3, :cond_2

    .line 1367
    new-instance v3, Landroid/content/Intent;

    iget-object v4, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v4, v4, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-virtual {v4}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    const-class v5, Lcom/jibo/ui/activity/PhotoViewerActivity;

    invoke-direct {v3, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1368
    const-string v4, "media_indx"

    iget-object v5, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    invoke-virtual {v5, v2}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a(I)I

    move-result v5

    invoke-virtual {v3, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 1369
    sget-object v4, Lcom/jibo/db/DatabaseContract$MediaEntry;->b:Landroid/net/Uri;

    invoke-virtual {v3, v4}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 1370
    const-string v4, "where"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "url IS NOT NULL AND type = ? AND loopId IN ("

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v6, v6, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    .line 1374
    invoke-static {v6}, Lcom/jibo/ui/fragment/home/MediaFragment;->l(Lcom/jibo/ui/fragment/home/MediaFragment;)Ljava/util/Map;

    move-result-object v6

    invoke-static {v6}, Lcom/jibo/ui/fragment/home/MediaFragment$MediaCursor;->a(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ")"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 1370
    invoke-virtual {v3, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1376
    const-string v4, "where_args"

    new-array v0, v0, [Ljava/lang/String;

    const-string v5, "image"

    aput-object v5, v0, v1

    invoke-virtual {v3, v4, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/Intent;

    .line 1377
    const-string v0, "projection"

    sget-object v1, Lcom/jibo/db/DatabaseContract$MediaEntry;->a:[Ljava/lang/String;

    invoke-virtual {v3, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/Intent;

    .line 1379
    const-string v0, "order"

    const-string v1, "created DESC"

    invoke-virtual {v3, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1381
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v0, v0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-virtual {v0, v3}, Lcom/jibo/ui/fragment/home/MediaFragment;->startActivity(Landroid/content/Intent;)V

    .line 1388
    :goto_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v0, v0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v0, v2}, Lcom/jibo/ui/fragment/home/MediaFragment;->a(Lcom/jibo/ui/fragment/home/MediaFragment;I)V

    goto :goto_0

    .line 1384
    :cond_2
    iget-object v3, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    invoke-static {v3}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a(Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;)Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

    move-result-object v3

    iget-object v4, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    invoke-static {v4}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a(Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;)Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

    move-result-object v4

    invoke-virtual {v4, v2}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;->a(I)Z

    move-result v4

    if-nez v4, :cond_3

    :goto_2
    invoke-virtual {v3, v2, v0}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;->a(IZ)V

    .line 1385
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    invoke-static {v1}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a(Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;)Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

    move-result-object v1

    invoke-virtual {v0, v2, v1}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->notifyItemChanged(ILjava/lang/Object;)V

    .line 1386
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v0, v0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->r(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/activity/TabbedActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/activity/TabbedActivity;->s()V

    goto :goto_1

    :cond_3
    move v0, v1

    .line 1384
    goto :goto_2
.end method
