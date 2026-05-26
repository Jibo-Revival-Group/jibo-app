.class public Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder_ViewBinding;
.super Ljava/lang/Object;
.source "HolidaysListFragment$HolidayViewHolder_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder_ViewBinding;->b:Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;

    .line 22
    const v0, 0x1020014

    const-string v1, "field \'text1\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;->text1:Landroid/widget/TextView;

    .line 23
    const v0, 0x1020001

    const-string v1, "field \'checkbox\'"

    const-class v2, Landroid/widget/CheckBox;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/CheckBox;

    iput-object v0, p1, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;->checkbox:Landroid/widget/CheckBox;

    .line 24
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 29
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder_ViewBinding;->b:Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;

    .line 30
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 31
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder_ViewBinding;->b:Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;

    .line 33
    iput-object v1, v0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;->text1:Landroid/widget/TextView;

    .line 34
    iput-object v1, v0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;->checkbox:Landroid/widget/CheckBox;

    .line 35
    return-void
.end method
