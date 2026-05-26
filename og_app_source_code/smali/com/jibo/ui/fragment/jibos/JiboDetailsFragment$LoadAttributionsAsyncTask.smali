.class Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;
.super Landroid/os/AsyncTask;
.source "JiboDetailsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "LoadAttributionsAsyncTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Long;",
        "Ljava/lang/Void;",
        "Lcom/jibo/aws/integration/aws/services/gqa/model/AttributionListResponse;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

.field private b:J


# direct methods
.method private constructor <init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V
    .locals 2

    .prologue
    .line 1049
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 1051
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;->b:J

    return-void
.end method

.method synthetic constructor <init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$1;)V
    .locals 0

    .prologue
    .line 1049
    invoke-direct {p0, p1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V

    return-void
.end method


# virtual methods
.method protected varargs a([Ljava/lang/Long;)Lcom/jibo/aws/integration/aws/services/gqa/model/AttributionListResponse;
    .locals 6

    .prologue
    .line 1055
    const/4 v0, 0x0

    aget-object v0, p1, v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;->b:J

    .line 1057
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->c()Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;

    move-result-object v1

    .line 1059
    const/4 v0, 0x0

    .line 1061
    :try_start_0
    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-static {v2}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->q(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getRobotFriendlyId()Ljava/lang/String;

    move-result-object v2

    iget-wide v4, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;->b:J

    invoke-virtual {v1, v2, v4, v5}, Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;->listAttributions(Ljava/lang/String;J)Lcom/jibo/aws/integration/aws/services/gqa/model/AttributionListResponse;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 1066
    :goto_0
    return-object v0

    .line 1062
    :catch_0
    move-exception v1

    .line 1063
    invoke-static {v1}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method protected a(Lcom/jibo/aws/integration/aws/services/gqa/model/AttributionListResponse;)V
    .locals 4

    .prologue
    .line 1076
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 1077
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;->isCancelled()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->d()Z

    move-result v0

    if-nez v0, :cond_1

    .line 1097
    :cond_0
    :goto_0
    return-void

    .line 1080
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->r(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->r(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 1082
    :cond_2
    if-eqz p1, :cond_3

    .line 1083
    iget-wide v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;->b:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_4

    .line 1084
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/gqa/model/AttributionListResponse;->getData()Ljava/util/List;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Ljava/util/List;)Ljava/util/List;

    .line 1090
    :cond_3
    :goto_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->r(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Ljava/util/List;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->b(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    .line 1092
    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->j(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 1093
    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->i(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Ljava/util/List;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/helpers/Items$SubheaderItem;

    const v3, 0x7f10033f

    invoke-direct {v2, v3}, Lcom/jibo/ui/helpers/Items$SubheaderItem;-><init>(I)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1094
    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->i(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, v0}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 1095
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->j(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;->notifyDataSetChanged()V

    goto :goto_0

    .line 1086
    :cond_4
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->r(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Ljava/util/List;

    move-result-object v0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/gqa/model/AttributionListResponse;->getData()Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    goto :goto_1
.end method

.method protected synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1049
    check-cast p1, [Ljava/lang/Long;

    invoke-virtual {p0, p1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;->a([Ljava/lang/Long;)Lcom/jibo/aws/integration/aws/services/gqa/model/AttributionListResponse;

    move-result-object v0

    return-object v0
.end method

.method protected synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1049
    check-cast p1, Lcom/jibo/aws/integration/aws/services/gqa/model/AttributionListResponse;

    invoke-virtual {p0, p1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$LoadAttributionsAsyncTask;->a(Lcom/jibo/aws/integration/aws/services/gqa/model/AttributionListResponse;)V

    return-void
.end method

.method protected onPreExecute()V
    .locals 0

    .prologue
    .line 1071
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 1072
    return-void
.end method
