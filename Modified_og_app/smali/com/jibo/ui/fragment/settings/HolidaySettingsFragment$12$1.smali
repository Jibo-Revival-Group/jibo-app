.class Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12$1;
.super Ljava/lang/Object;
.source "HolidaySettingsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;->a(Lcom/jibo/aws/integration/aws/services/person/model/SetLoopPropertyRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;)V
    .locals 0

    .prologue
    .line 543
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12$1;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 547
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12$1;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;->c:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12$1;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;->c:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->b:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12$1;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;

    iget-object v2, v2, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;->a:Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    invoke-static {v0, v1, v2}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Ljava/util/List;Lcom/jibo/aws/integration/aws/services/person/model/Holiday;)I

    move-result v1

    .line 550
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12$1;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;->c:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->getAdapter()Landroid/support/v7/widget/RecyclerView$Adapter;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;->a(I)Lcom/jibo/ui/helpers/Items$Item;

    move-result-object v0

    .line 551
    if-eqz v0, :cond_0

    .line 552
    check-cast v0, Lcom/jibo/ui/helpers/Items$StateSwitchItem;

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12$1;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;

    iget-boolean v2, v2, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;->b:Z

    invoke-virtual {v0, v2}, Lcom/jibo/ui/helpers/Items$StateSwitchItem;->a(Z)V

    .line 556
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12$1;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;->c:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->getAdapter()Landroid/support/v7/widget/RecyclerView$Adapter;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView$Adapter;->notifyItemChanged(I)V

    .line 559
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12$1;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;->c:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->g()V

    .line 560
    return-void
.end method
