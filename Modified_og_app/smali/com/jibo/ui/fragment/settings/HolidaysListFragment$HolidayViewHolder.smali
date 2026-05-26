.class Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;
.super Landroid/support/v7/widget/RecyclerView$ViewHolder;
.source "HolidaysListFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/settings/HolidaysListFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "HolidayViewHolder"
.end annotation


# instance fields
.field private a:Lcom/jibo/ui/fragment/settings/HolidaysListFragment;

.field private b:Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

.field private c:Landroid/view/View$OnClickListener;

.field public checkbox:Landroid/widget/CheckBox;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field public text1:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/view/View;Lcom/jibo/ui/fragment/settings/HolidaysListFragment;)V
    .locals 2

    .prologue
    .line 222
    invoke-direct {p0, p1}, Landroid/support/v7/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V

    .line 212
    new-instance v0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder$1;-><init>(Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;->c:Landroid/view/View$OnClickListener;

    .line 223
    iput-object p2, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;->a:Lcom/jibo/ui/fragment/settings/HolidaysListFragment;

    .line 224
    invoke-static {p0, p1}, Lbutterknife/ButterKnife;->a(Ljava/lang/Object;Landroid/view/View;)Lbutterknife/Unbinder;

    .line 225
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;->itemView:Landroid/view/View;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;->c:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 226
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;->checkbox:Landroid/widget/CheckBox;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;->c:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 227
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;)Lcom/jibo/aws/integration/aws/services/person/model/Holiday;
    .locals 1

    .prologue
    .line 204
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;->b:Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    return-object v0
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;)Lcom/jibo/ui/fragment/settings/HolidaysListFragment;
    .locals 1

    .prologue
    .line 204
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;->a:Lcom/jibo/ui/fragment/settings/HolidaysListFragment;

    return-object v0
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/person/model/Holiday;)V
    .locals 2

    .prologue
    .line 230
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;->b:Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    .line 231
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;->checkbox:Landroid/widget/CheckBox;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;->b:Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getEnabled()Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 232
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;->text1:Landroid/widget/TextView;

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 233
    return-void
.end method
