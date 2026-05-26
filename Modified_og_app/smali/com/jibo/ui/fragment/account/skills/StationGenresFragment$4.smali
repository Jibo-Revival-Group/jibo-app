.class Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;
.super Ljava/lang/Object;
.source "StationGenresFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->s()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)V
    .locals 0

    .prologue
    .line 370
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    const v7, 0x7f10031c

    const v6, 0x7f100316

    const v5, 0x7f100301

    const/4 v1, 0x0

    .line 374
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->g()V

    .line 376
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->emptyView:Landroid/view/View;

    const/16 v2, 0x8

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 377
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->e(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 379
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->e(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Ljava/util/List;

    move-result-object v0

    new-instance v2, Lcom/jibo/ui/helpers/Items$SubheaderItem;

    iget-object v3, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    const v4, 0x7f100303

    invoke-virtual {v3, v4}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/jibo/ui/helpers/Items$SubheaderItem;-><init>(Ljava/lang/String;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 381
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->f(Landroid/content/Context;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v2

    .line 382
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    .line 383
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isOwner(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    const/4 v0, 0x1

    .line 386
    :goto_0
    iget-object v3, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v3}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->f(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    move-result-object v3

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v3}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->f(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    move-result-object v3

    invoke-static {v3}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getCountryCode(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 388
    :cond_0
    if-eqz v0, :cond_3

    .line 389
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->e(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Ljava/util/List;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;

    iget-object v3, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-virtual {v3, v6}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    .line 390
    invoke-static {v4, v2}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->a(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)Landroid/text/SpannableStringBuilder;

    move-result-object v2

    invoke-direct {v1, v3, v2}, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;-><init>(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V

    .line 389
    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 432
    :cond_1
    :goto_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->k(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter$SimpleImplItemRecycleViewAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter$SimpleImplItemRecycleViewAdapter;->notifyDataSetChanged()V

    .line 433
    return-void

    :cond_2
    move v0, v1

    .line 383
    goto :goto_0

    .line 392
    :cond_3
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->e(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Ljava/util/List;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-virtual {v2, v6}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-virtual {v3, v7}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;-><init>(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 394
    :cond_4
    iget-object v3, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v3}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->g(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Lcom/jibo/api/iheart/model/LocationConfig;

    move-result-object v3

    if-eqz v3, :cond_6

    iget-object v3, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v3}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->g(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Lcom/jibo/api/iheart/model/LocationConfig;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/api/iheart/model/LocationConfig;->a()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 396
    if-eqz v0, :cond_5

    .line 397
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->e(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Ljava/util/List;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;

    iget-object v3, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-virtual {v3, v5}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    .line 398
    invoke-static {v4, v2}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->a(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)Landroid/text/SpannableStringBuilder;

    move-result-object v2

    invoke-direct {v1, v3, v2}, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;-><init>(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V

    .line 397
    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 400
    :cond_5
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->e(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Ljava/util/List;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-virtual {v2, v5}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-virtual {v3, v7}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;-><init>(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 402
    :cond_6
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->h(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_7

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->h(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_8

    .line 403
    :cond_7
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->emptyView:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_1

    .line 405
    :cond_8
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->h(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/api/iheart/model/Genre;

    .line 407
    new-instance v2, Lcom/jibo/ui/helpers/Items$AvatarTwoRowsSimpleItem;

    new-instance v3, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4$1;

    invoke-direct {v3, p0, v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4$1;-><init>(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;Lcom/jibo/api/iheart/model/Genre;)V

    .line 418
    invoke-virtual {v0}, Lcom/jibo/api/iheart/model/Genre;->b()Ljava/lang/String;

    move-result-object v4

    const-string v5, ""

    invoke-direct {v2, v3, v4, v5}, Lcom/jibo/ui/helpers/Items$AvatarTwoRowsSimpleItem;-><init>(Landroid/view/View$OnClickListener;Ljava/lang/String;Ljava/lang/String;)V

    .line 419
    const v3, 0x7f080230

    invoke-virtual {v2, v3}, Lcom/jibo/ui/helpers/Items$AvatarTwoRowsSimpleItem;->a(I)V

    .line 422
    iget-object v3, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v3}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->j(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Ljava/util/List;

    move-result-object v3

    if-eqz v3, :cond_9

    iget-object v3, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v3}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->j(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_9

    .line 423
    iget-object v3, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v3}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->j(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Ljava/util/List;

    move-result-object v3

    invoke-interface {v3, v0}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v3

    if-ltz v3, :cond_9

    .line 424
    iget-object v3, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v3}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->j(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Ljava/util/List;

    move-result-object v3

    invoke-interface {v3, v0}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v3

    .line 425
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->j(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/api/iheart/model/Genre;

    invoke-virtual {v0}, Lcom/jibo/api/iheart/model/Genre;->c()Lcom/jibo/api/iheart/model/Station;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/api/iheart/model/Station;->b()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/jibo/ui/helpers/Items$AvatarTwoRowsSimpleItem;->a(Ljava/lang/CharSequence;)V

    .line 426
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->j(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/api/iheart/model/Genre;

    invoke-virtual {v0}, Lcom/jibo/api/iheart/model/Genre;->c()Lcom/jibo/api/iheart/model/Station;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/api/iheart/model/Station;->c()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/jibo/ui/helpers/Items$AvatarTwoRowsSimpleItem;->a(Ljava/lang/String;)V

    .line 429
    :cond_9
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->e(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_2
.end method
