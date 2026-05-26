.class Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4$1;
.super Ljava/lang/Object;
.source "HolidaySettingsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;->a(Lcom/jibo/aws/integration/aws/services/person/model/HolidaysSwitchRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;)V
    .locals 0

    .prologue
    .line 267
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4$1;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 270
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4$1;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    .line 271
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4$1;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;

    iget-boolean v1, v1, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;->b:Z

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->setEnabled(Ljava/lang/Boolean;)V

    .line 273
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4$1;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;->c:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->b:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v1

    const/4 v3, -0x1

    if-eq v1, v3, :cond_1

    .line 274
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getCategory()Ljava/lang/String;

    move-result-object v1

    const-string v3, "birthday"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 275
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4$1;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;->c:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iget-object v3, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4$1;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;

    iget-object v3, v3, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;->c:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iget-object v3, v3, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->b:Ljava/util/ArrayList;

    invoke-static {v1, v3, v0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Ljava/util/List;Lcom/jibo/aws/integration/aws/services/person/model/Holiday;)I

    move-result v3

    .line 277
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4$1;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;->c:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v1}, Landroid/support/v7/widget/RecyclerView;->getAdapter()Landroid/support/v7/widget/RecyclerView$Adapter;

    move-result-object v1

    check-cast v1, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;

    invoke-virtual {v1, v3}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;->a(I)Lcom/jibo/ui/helpers/Items$Item;

    move-result-object v1

    .line 278
    if-eqz v1, :cond_0

    .line 279
    check-cast v1, Lcom/jibo/ui/helpers/Items$StateSwitchItem;

    iget-object v4, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4$1;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;

    iget-boolean v4, v4, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;->b:Z

    invoke-virtual {v1, v4}, Lcom/jibo/ui/helpers/Items$StateSwitchItem;->a(Z)V

    .line 281
    :cond_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4$1;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;->c:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v1}, Landroid/support/v7/widget/RecyclerView;->getAdapter()Landroid/support/v7/widget/RecyclerView$Adapter;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/support/v7/widget/RecyclerView$Adapter;->notifyItemChanged(I)V

    .line 283
    :cond_1
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4$1;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;->c:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getName()Ljava/lang/String;

    move-result-object v0

    iget-object v3, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4$1;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;

    iget-boolean v3, v3, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;->b:Z

    invoke-static {v1, v0, v3}, Lcom/jibo/JiboAnalytics;->a(Landroid/content/Context;Ljava/lang/String;Z)V

    goto :goto_0

    .line 286
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4$1;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;->c:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->getAdapter()Landroid/support/v7/widget/RecyclerView$Adapter;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;

    invoke-virtual {v0, v5}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;->a(I)Lcom/jibo/ui/helpers/Items$Item;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/Items$StateSwitchItem;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4$1;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;->c:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->b(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;)Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/helpers/Items$StateSwitchItem;->a(Z)V

    .line 287
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4$1;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;->c:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->getAdapter()Landroid/support/v7/widget/RecyclerView$Adapter;

    move-result-object v0

    invoke-virtual {v0, v5}, Landroid/support/v7/widget/RecyclerView$Adapter;->notifyItemChanged(I)V

    .line 288
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4$1;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;->c:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->g()V

    .line 289
    return-void
.end method
