.class Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;
.super Landroid/os/AsyncTask;
.source "MediaFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/home/MediaFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "PaginationAsyncTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/home/MediaFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/home/MediaFragment;)V
    .locals 0

    .prologue
    .line 1724
    iput-object p1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected varargs a([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 13

    .prologue
    const/4 v11, 0x1

    const/4 v9, 0x0

    const/4 v7, 0x0

    .line 1729
    .line 1731
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->l(Lcom/jibo/ui/fragment/home/MediaFragment;)Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v12

    move v8, v9

    move-object v10, v7

    :goto_0
    invoke-interface {v12}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_b

    invoke-interface {v12}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    move-object v6, v0

    check-cast v6, Ljava/lang/String;

    .line 1733
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;->isCancelled()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->d()Z

    move-result v0

    if-nez v0, :cond_1

    .line 1787
    :cond_0
    :goto_1
    return-object v7

    .line 1737
    :cond_1
    :try_start_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/jibo/db/DatabaseContract$MediaEntry;->b:Landroid/net/Uri;

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "_id"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    const-string v4, "created"

    aput-object v4, v2, v3

    const-string v3, "loopId = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    aput-object v6, v4, v5

    const-string v5, "created ASC LIMIT 1"

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Lcom/amazonaws/AmazonServiceException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v1

    .line 1743
    if-eqz v1, :cond_8

    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_8

    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_8

    .line 1744
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->e()Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;

    move-result-object v0

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    aput-object v6, v2, v3

    .line 1745
    invoke-static {v2}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v4, 0x1

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v0, v2, v3, v4}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;->list(Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;)Ljava/util/List;

    move-result-object v0

    .line 1747
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;->isCancelled()Z

    move-result v2

    if-nez v2, :cond_2

    iget-object v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-virtual {v2}, Lcom/jibo/ui/fragment/home/MediaFragment;->d()Z

    move-result v2

    if-nez v2, :cond_3

    .line 1748
    :cond_2
    invoke-interface {v1}, Landroid/database/Cursor;->close()V
    :try_end_1
    .catch Lcom/amazonaws/AmazonServiceException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1779
    if-eqz v1, :cond_0

    .line 1780
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 1753
    :cond_3
    if-eqz v0, :cond_8

    :try_start_2
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_8

    .line 1755
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    add-int/2addr v8, v2

    .line 1757
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;->isCancelled()Z

    move-result v2

    if-nez v2, :cond_4

    iget-object v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-virtual {v2}, Lcom/jibo/ui/fragment/home/MediaFragment;->d()Z

    move-result v2

    if-nez v2, :cond_5

    .line 1758
    :cond_4
    invoke-interface {v1}, Landroid/database/Cursor;->close()V
    :try_end_2
    .catch Lcom/amazonaws/AmazonServiceException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 1779
    if-eqz v1, :cond_0

    .line 1780
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto/16 :goto_1

    .line 1763
    :cond_5
    :try_start_3
    iget-object v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-virtual {v2}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v2, v0, v3}, Lcom/jibo/db/EntityData;->a(Ljava/util/List;Z)V

    .line 1765
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;->isCancelled()Z

    move-result v0

    if-nez v0, :cond_6

    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->d()Z

    move-result v0

    if-nez v0, :cond_7

    .line 1766
    :cond_6
    invoke-interface {v1}, Landroid/database/Cursor;->close()V
    :try_end_3
    .catch Lcom/amazonaws/AmazonServiceException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 1779
    if-eqz v1, :cond_0

    .line 1780
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto/16 :goto_1

    .line 1771
    :cond_7
    :try_start_4
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->j()V
    :try_end_4
    .catch Lcom/amazonaws/AmazonServiceException; {:try_start_4 .. :try_end_4} :catch_0
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    :cond_8
    move v0, v8

    .line 1779
    if-eqz v1, :cond_9

    .line 1780
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    move-object v1, v7

    :cond_9
    :goto_2
    move v8, v0

    move-object v10, v1

    .line 1784
    goto/16 :goto_0

    .line 1774
    :catch_0
    move-exception v0

    move-object v2, v0

    move v0, v8

    .line 1775
    :goto_3
    :try_start_5
    invoke-static {v2}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 1779
    if-eqz v1, :cond_9

    .line 1780
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    move-object v1, v7

    .line 1781
    goto :goto_2

    .line 1776
    :catch_1
    move-exception v0

    move-object v2, v0

    move v0, v8

    .line 1777
    :goto_4
    :try_start_6
    invoke-static {v2}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 1779
    if-eqz v1, :cond_9

    .line 1780
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    move-object v1, v7

    .line 1781
    goto :goto_2

    .line 1779
    :catchall_0
    move-exception v0

    :goto_5
    if-eqz v1, :cond_a

    .line 1780
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1781
    :cond_a
    throw v0

    .line 1786
    :cond_b
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    if-lez v8, :cond_c

    move v9, v11

    :cond_c
    invoke-static {v0, v9}, Lcom/jibo/ui/fragment/home/MediaFragment;->b(Lcom/jibo/ui/fragment/home/MediaFragment;Z)Z

    goto/16 :goto_1

    .line 1779
    :catchall_1
    move-exception v0

    move-object v1, v10

    goto :goto_5

    .line 1776
    :catch_2
    move-exception v0

    move-object v2, v0

    move-object v1, v10

    move v0, v8

    goto :goto_4

    .line 1774
    :catch_3
    move-exception v0

    move-object v2, v0

    move-object v1, v10

    move v0, v8

    goto :goto_3
.end method

.method protected a(Ljava/lang/Void;)V
    .locals 2

    .prologue
    .line 1799
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;->isCancelled()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->d()Z

    move-result v0

    if-nez v0, :cond_1

    .line 1803
    :cond_0
    :goto_0
    return-void

    .line 1801
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/home/MediaFragment;->a(Lcom/jibo/ui/fragment/home/MediaFragment;Z)Z

    .line 1802
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/home/MediaFragment;->progressView:Landroid/view/View;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method protected synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1724
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;->a([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1724
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;->a(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 1792
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;->isCancelled()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->d()Z

    move-result v0

    if-nez v0, :cond_1

    .line 1795
    :cond_0
    :goto_0
    return-void

    .line 1794
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/home/MediaFragment;->progressView:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method
