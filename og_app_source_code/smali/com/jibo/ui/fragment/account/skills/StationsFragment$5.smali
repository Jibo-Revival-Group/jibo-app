.class Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;
.super Ljava/lang/Object;
.source "StationsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/skills/StationsFragment;->s()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)V
    .locals 0

    .prologue
    .line 399
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 10

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 403
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->g()V

    .line 404
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->emptyView:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 406
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->j(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 408
    const/4 v0, 0x0

    .line 409
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->b(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Lcom/google/gson/JsonObject;

    move-result-object v4

    .line 410
    if-eqz v4, :cond_8

    .line 411
    new-instance v0, Lcom/google/gson/Gson;

    invoke-direct {v0}, Lcom/google/gson/Gson;-><init>()V

    const-class v1, Lcom/jibo/api/iheart/model/Genre;

    invoke-virtual {v0, v4, v1}, Lcom/google/gson/Gson;->a(Lcom/google/gson/JsonElement;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/api/iheart/model/Genre;

    .line 412
    invoke-virtual {v0}, Lcom/jibo/api/iheart/model/Genre;->c()Lcom/jibo/api/iheart/model/Station;

    move-result-object v0

    move-object v1, v0

    .line 414
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->f(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->g(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->i(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Lcom/jibo/api/iheart/model/Genre;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->i(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Lcom/jibo/api/iheart/model/Genre;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/api/iheart/model/Genre;->a()I

    move-result v0

    if-eqz v0, :cond_0

    if-nez v4, :cond_2

    .line 416
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->emptyView:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 457
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->l(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter$SimpleImplItemRecycleViewAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter$SimpleImplItemRecycleViewAdapter;->notifyDataSetChanged()V

    .line 458
    return-void

    .line 418
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->j(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Ljava/util/List;

    move-result-object v0

    new-instance v4, Lcom/jibo/ui/helpers/Items$SubheaderItem;

    iget-object v5, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    const v6, 0x7f100376

    invoke-virtual {v5, v6}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Lcom/jibo/ui/helpers/Items$SubheaderItem;-><init>(Ljava/lang/String;)V

    invoke-interface {v0, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 419
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->f(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 420
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->f(Landroid/content/Context;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    .line 421
    iget-object v4, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-virtual {v4}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-static {v4}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v4

    invoke-virtual {v4}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v4

    .line 422
    if-eqz v4, :cond_4

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-static {v0, v4}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isOwner(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    move v0, v2

    .line 424
    :goto_1
    if-eqz v0, :cond_6

    .line 425
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->j(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Ljava/util/List;

    move-result-object v4

    new-instance v5, Lcom/jibo/ui/helpers/Items$SimpleItem;

    sget-object v6, Lcom/jibo/ui/helpers/Items$ItemType;->text_greyed_row:Lcom/jibo/ui/helpers/Items$ItemType;

    iget-object v7, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    const v8, 0x7f100329

    const/4 v0, 0x2

    new-array v9, v0, [Ljava/lang/Object;

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    .line 427
    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->i(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Lcom/jibo/api/iheart/model/Genre;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/api/iheart/model/Genre;->b()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v9, v3

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    .line 428
    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->h(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getAddressLine(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    .line 429
    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->h(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getLocation(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Ljava/lang/String;

    move-result-object v0

    .line 430
    :goto_2
    aput-object v0, v9, v2

    .line 426
    invoke-virtual {v7, v8, v9}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v5, v6, v0}, Lcom/jibo/ui/helpers/Items$SimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Ljava/lang/CharSequence;)V

    .line 425
    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 445
    :cond_3
    :goto_3
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->g(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->g(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 446
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->j(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Ljava/util/List;

    move-result-object v0

    new-instance v2, Lcom/jibo/ui/helpers/Items$SubheaderItem;

    iget-object v3, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    const v4, 0x7f1002f4

    invoke-virtual {v3, v4}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/jibo/ui/helpers/Items$SubheaderItem;-><init>(Ljava/lang/String;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 448
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->g(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_4
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/api/iheart/model/Station;

    .line 449
    new-instance v3, Lcom/jibo/ui/fragment/account/skills/StationsFragment$StationItem;

    iget-object v4, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v4}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->k(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Landroid/view/View$OnClickListener;

    move-result-object v4

    .line 450
    invoke-virtual {v0, v1}, Lcom/jibo/api/iheart/model/Station;->equals(Ljava/lang/Object;)Z

    move-result v5

    invoke-direct {v3, v4, v0, v5}, Lcom/jibo/ui/fragment/account/skills/StationsFragment$StationItem;-><init>(Landroid/view/View$OnClickListener;Lcom/jibo/api/iheart/model/Station;Z)V

    .line 451
    invoke-virtual {v0}, Lcom/jibo/api/iheart/model/Station;->c()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment$StationItem;->a(Ljava/lang/String;)V

    .line 452
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->j(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_4

    :cond_4
    move v0, v3

    .line 422
    goto/16 :goto_1

    .line 429
    :cond_5
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    .line 430
    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->h(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getAddressLine(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Ljava/lang/String;

    move-result-object v0

    goto :goto_2

    .line 432
    :cond_6
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->j(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Ljava/util/List;

    move-result-object v0

    new-instance v4, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;

    sget-object v5, Lcom/jibo/ui/helpers/Items$ItemType;->text_double_greyed_row:Lcom/jibo/ui/helpers/Items$ItemType;

    iget-object v6, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    const v7, 0x7f10032a

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v8, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    .line 433
    invoke-static {v8}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->i(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Lcom/jibo/api/iheart/model/Genre;

    move-result-object v8

    invoke-virtual {v8}, Lcom/jibo/api/iheart/model/Genre;->b()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v2, v3

    invoke-virtual {v6, v7, v2}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    const v6, 0x7f10031c

    .line 434
    invoke-virtual {v3, v6}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v4, v5, v2, v3}, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V

    .line 432
    invoke-interface {v0, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_3

    .line 437
    :cond_7
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->f(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_5
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/api/iheart/model/Station;

    .line 438
    new-instance v3, Lcom/jibo/ui/fragment/account/skills/StationsFragment$StationItem;

    iget-object v4, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v4}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->k(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Landroid/view/View$OnClickListener;

    move-result-object v4

    .line 439
    invoke-virtual {v0, v1}, Lcom/jibo/api/iheart/model/Station;->equals(Ljava/lang/Object;)Z

    move-result v5

    invoke-direct {v3, v4, v0, v5}, Lcom/jibo/ui/fragment/account/skills/StationsFragment$StationItem;-><init>(Landroid/view/View$OnClickListener;Lcom/jibo/api/iheart/model/Station;Z)V

    .line 440
    invoke-virtual {v0}, Lcom/jibo/api/iheart/model/Station;->c()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment$StationItem;->a(Ljava/lang/String;)V

    .line 441
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;->a:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->j(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_5

    :cond_8
    move-object v1, v0

    goto/16 :goto_0
.end method
