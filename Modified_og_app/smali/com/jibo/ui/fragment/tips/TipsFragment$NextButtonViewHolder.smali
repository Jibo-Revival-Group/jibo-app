.class Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;
.super Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;
.source "TipsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/tips/TipsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "NextButtonViewHolder"
.end annotation


# instance fields
.field final synthetic c:Lcom/jibo/ui/fragment/tips/TipsFragment;

.field private final d:I

.field private final e:I

.field nextButton:Landroid/widget/Button;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/tips/TipsFragment;Landroid/view/View;)V
    .locals 1

    .prologue
    .line 287
    iput-object p1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;->c:Lcom/jibo/ui/fragment/tips/TipsFragment;

    .line 288
    invoke-direct {p0, p2}, Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;-><init>(Landroid/view/View;)V

    .line 262
    sget-object v0, Lcom/jibo/ui/fragment/tips/TipsListFragment;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;->d:I

    .line 263
    iget v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;->d:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;->e:I

    .line 289
    invoke-static {p0, p2}, Lbutterknife/ButterKnife;->a(Ljava/lang/Object;Landroid/view/View;)Lbutterknife/Unbinder;

    .line 290
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;)V
    .locals 0

    .prologue
    .line 260
    invoke-direct {p0}, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;->f()V

    return-void
.end method

.method private f()V
    .locals 6

    .prologue
    .line 293
    sget-object v0, Lcom/jibo/ui/fragment/tips/TipsListFragment;->a:Ljava/util/List;

    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;->c:Lcom/jibo/ui/fragment/tips/TipsFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/tips/TipsFragment;->b(Lcom/jibo/ui/fragment/tips/TipsFragment;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v1

    .line 294
    add-int/lit8 v0, v1, 0x1

    iget v2, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;->d:I

    rem-int/2addr v0, v2

    .line 295
    iget-object v2, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;->c:Lcom/jibo/ui/fragment/tips/TipsFragment;

    sget-object v3, Lcom/jibo/ui/fragment/tips/TipsListFragment;->a:Ljava/util/List;

    invoke-interface {v3, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Lcom/jibo/ui/fragment/tips/TipsContent;->a(Ljava/lang/String;)I

    move-result v0

    invoke-virtual {v2, v0}, Lcom/jibo/ui/fragment/tips/TipsFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 297
    iget v2, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;->e:I

    if-ne v1, v2, :cond_0

    .line 298
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;->nextButton:Landroid/widget/Button;

    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;->c:Lcom/jibo/ui/fragment/tips/TipsFragment;

    const v2, 0x7f10003e

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/tips/TipsFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 302
    :goto_0
    return-void

    .line 300
    :cond_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;->nextButton:Landroid/widget/Button;

    iget-object v2, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;->c:Lcom/jibo/ui/fragment/tips/TipsFragment;

    const v3, 0x7f1003e9

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v0, v4, v5

    invoke-virtual {v2, v3, v4}, Lcom/jibo/ui/fragment/tips/TipsFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method


# virtual methods
.method public next(Landroid/view/View;)V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 270
    sget-object v0, Lcom/jibo/ui/fragment/tips/TipsListFragment;->a:Ljava/util/List;

    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;->c:Lcom/jibo/ui/fragment/tips/TipsFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/tips/TipsFragment;->b(Lcom/jibo/ui/fragment/tips/TipsFragment;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v0

    .line 271
    add-int/lit8 v1, v0, 0x1

    iget v2, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;->d:I

    rem-int/2addr v1, v2

    .line 273
    iget v2, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;->e:I

    if-ne v0, v2, :cond_0

    .line 274
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;->c:Lcom/jibo/ui/fragment/tips/TipsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/tips/TipsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 285
    :goto_0
    return-void

    .line 277
    :cond_0
    iget-object v2, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;->c:Lcom/jibo/ui/fragment/tips/TipsFragment;

    sget-object v0, Lcom/jibo/ui/fragment/tips/TipsListFragment;->a:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v2, v0}, Lcom/jibo/ui/fragment/tips/TipsFragment;->a(Lcom/jibo/ui/fragment/tips/TipsFragment;Ljava/lang/String;)Ljava/lang/String;

    .line 279
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 280
    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;->c:Lcom/jibo/ui/fragment/tips/TipsFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/tips/TipsFragment;->getContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/jibo/ui/activity/TipsActivity;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 281
    const-string v1, "ARGS_TAG"

    iget-object v2, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;->c:Lcom/jibo/ui/fragment/tips/TipsFragment;

    invoke-static {v2}, Lcom/jibo/ui/fragment/tips/TipsFragment;->b(Lcom/jibo/ui/fragment/tips/TipsFragment;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 282
    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;->c:Lcom/jibo/ui/fragment/tips/TipsFragment;

    invoke-virtual {v1, v0}, Lcom/jibo/ui/fragment/tips/TipsFragment;->startActivity(Landroid/content/Intent;)V

    .line 284
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;->c:Lcom/jibo/ui/fragment/tips/TipsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/tips/TipsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    goto :goto_0
.end method
