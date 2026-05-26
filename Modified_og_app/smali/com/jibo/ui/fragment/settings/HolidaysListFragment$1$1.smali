.class Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1$1;
.super Ljava/lang/Object;
.source "HolidaysListFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1;->a(Lcom/jibo/aws/integration/aws/services/person/model/HolidaysSwitchRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1;)V
    .locals 0

    .prologue
    .line 174
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1$1;->a:Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 177
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1$1;->a:Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    .line 178
    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1$1;->a:Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1;

    iget-boolean v2, v2, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1;->b:Z

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->setEnabled(Ljava/lang/Boolean;)V

    .line 179
    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1$1;->a:Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1;

    iget-object v2, v2, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1;->c:Lcom/jibo/ui/fragment/settings/HolidaysListFragment;

    invoke-virtual {v2}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getName()Ljava/lang/String;

    move-result-object v0

    iget-object v3, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1$1;->a:Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1;

    iget-boolean v3, v3, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1;->b:Z

    invoke-static {v2, v0, v3}, Lcom/jibo/JiboAnalytics;->a(Landroid/content/Context;Ljava/lang/String;Z)V

    goto :goto_0

    .line 181
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1$1;->a:Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1;->c:Lcom/jibo/ui/fragment/settings/HolidaysListFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->invalidateOptionsMenu()V

    .line 182
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1$1;->a:Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1;->c:Lcom/jibo/ui/fragment/settings/HolidaysListFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->getAdapter()Landroid/support/v7/widget/RecyclerView$Adapter;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView$Adapter;->notifyDataSetChanged()V

    .line 184
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1$1;->a:Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1;->c:Lcom/jibo/ui/fragment/settings/HolidaysListFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->g()V

    .line 185
    return-void
.end method
