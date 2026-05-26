.class Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder$1;
.super Ljava/lang/Object;
.source "HolidaysListFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;)V
    .locals 0

    .prologue
    .line 212
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder$1;->a:Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 215
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 216
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder$1;->a:Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;

    invoke-static {v0}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;->a(Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;)Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 217
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder$1;->a:Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;

    invoke-static {v0}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;->b(Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;)Lcom/jibo/ui/fragment/settings/HolidaysListFragment;

    move-result-object v2

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder$1;->a:Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;

    invoke-static {v0}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;->a(Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;)Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getEnabled()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-static {v2, v0, v1}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->a(Lcom/jibo/ui/fragment/settings/HolidaysListFragment;ZLjava/util/List;)V

    .line 218
    return-void

    .line 217
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
