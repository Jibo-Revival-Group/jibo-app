.class Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$1;
.super Landroid/support/v7/widget/LinearLayoutManager;
.source "HolidaySettingsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Landroid/content/Context;IZ)V
    .locals 0

    .prologue
    .line 83
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$1;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    invoke-direct {p0, p2, p3, p4}, Landroid/support/v7/widget/LinearLayoutManager;-><init>(Landroid/content/Context;IZ)V

    return-void
.end method


# virtual methods
.method public c(Landroid/support/v7/widget/RecyclerView$Recycler;Landroid/support/v7/widget/RecyclerView$State;)V
    .locals 4

    .prologue
    const/16 v0, 0x8

    .line 86
    invoke-super {p0, p1, p2}, Landroid/support/v7/widget/LinearLayoutManager;->c(Landroid/support/v7/widget/RecyclerView$Recycler;Landroid/support/v7/widget/RecyclerView$State;)V

    .line 88
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$1;->m()I

    move-result v1

    .line 89
    if-eqz v1, :cond_1

    .line 91
    const/4 v2, -0x1

    if-ne v1, v2, :cond_0

    .line 93
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$1;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->fastScroller:Lcom/jibo/ui/view/RecyclerViewFastScroller;

    invoke-virtual {v1, v0}, Lcom/jibo/ui/view/RecyclerViewFastScroller;->setVisibility(I)V

    .line 100
    :cond_0
    :goto_0
    return-void

    .line 96
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$1;->n()I

    move-result v2

    .line 97
    sub-int v1, v2, v1

    add-int/lit8 v1, v1, 0x1

    .line 99
    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$1;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iget-object v2, v2, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->fastScroller:Lcom/jibo/ui/view/RecyclerViewFastScroller;

    iget-object v3, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$1;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    invoke-static {v3}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;)Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;->getItemCount()I

    move-result v3

    if-le v3, v1, :cond_2

    const/4 v0, 0x0

    :cond_2
    invoke-virtual {v2, v0}, Lcom/jibo/ui/view/RecyclerViewFastScroller;->setVisibility(I)V

    goto :goto_0
.end method
