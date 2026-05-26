.class Lcom/jibo/ui/fragment/jibos/JibosListFragment$2;
.super Ljava/lang/Object;
.source "JibosListFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/jibos/JibosListFragment;->n_()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/jibos/JibosListFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/jibos/JibosListFragment;)V
    .locals 0

    .prologue
    .line 199
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment$2;->a:Lcom/jibo/ui/fragment/jibos/JibosListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 202
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment$2;->a:Lcom/jibo/ui/fragment/jibos/JibosListFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 203
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment$2;->a:Lcom/jibo/ui/fragment/jibos/JibosListFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/SwipeRefreshLayout;->setRefreshing(Z)V

    .line 204
    :cond_0
    return-void
.end method
