.class public Lcom/jibo/ui/helpers/ViewHolders$LoopMemberViewHolder;
.super Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;
.source "ViewHolders.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/ViewHolders;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LoopMemberViewHolder"
.end annotation


# instance fields
.field private final a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

.field public avatar:Lcom/jibo/ui/view/RoundedImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field public name:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field public nickName:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field public smartphone:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field public textStatus:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/view/View;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
    .locals 2

    .prologue
    .line 463
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;-><init>(Landroid/view/View;)V

    .line 464
    iput-object p2, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberViewHolder;->a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 466
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/view/View;->setLongClickable(Z)V

    .line 469
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberViewHolder;->nickName:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 471
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberViewHolder;->textStatus:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 472
    return-void
.end method


# virtual methods
.method public invalidateView()V
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 475
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/Items$MemberItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$MemberItem;->b()Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v2

    .line 476
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/Items$MemberItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$MemberItem;->a()Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v3

    .line 482
    :try_start_0
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    .line 484
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getNickname()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 485
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberViewHolder;->name:Landroid/widget/TextView;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getNickname()Ljava/lang/String;

    move-result-object v4

    invoke-static {v0, v4}, Lcom/jibo/utils/Util;->a(Landroid/widget/TextView;Ljava/lang/String;)V

    .line 495
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    iget-object v4, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberViewHolder;->avatar:Lcom/jibo/ui/view/RoundedImageView;

    invoke-static {v0, v4, v2}, Lcom/jibo/utils/Util;->a(Landroid/content/Context;Landroid/widget/ImageView;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V

    .line 497
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberViewHolder;->textStatus:Landroid/widget/TextView;

    const-string v4, ""

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 498
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberViewHolder;->textStatus:Landroid/widget/TextView;

    iget-object v4, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v4

    const v5, 0x7f0600c6

    invoke-static {v4, v5}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v4

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setTextColor(I)V

    .line 499
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberViewHolder;->smartphone:Landroid/widget/ImageView;

    const/16 v4, 0x8

    invoke-virtual {v0, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 500
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    if-nez v0, :cond_3

    .line 526
    :cond_0
    :goto_1
    return-void

    .line 487
    :cond_1
    if-nez v0, :cond_2

    .line 488
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberViewHolder;->name:Landroid/widget/TextView;

    const-string v4, ""

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 523
    :catch_0
    move-exception v0

    .line 524
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_1

    .line 490
    :cond_2
    :try_start_1
    iget-object v4, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberViewHolder;->name:Landroid/widget/TextView;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v4, v0}, Lcom/jibo/utils/Util;->a(Landroid/widget/TextView;Ljava/lang/String;)V

    goto :goto_0

    .line 502
    :cond_3
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccountId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v3, v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isOwner(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v4

    .line 503
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberViewHolder;->a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v3, v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isOwner(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    .line 504
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccountId()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_4

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccountId()Ljava/lang/String;

    move-result-object v0

    iget-object v5, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberViewHolder;->a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    const/4 v0, 0x1

    .line 506
    :goto_2
    if-eqz v0, :cond_5

    .line 507
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberViewHolder;->textStatus:Landroid/widget/TextView;

    const v1, 0x7f10017a

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    goto :goto_1

    :cond_4
    move v0, v1

    .line 504
    goto :goto_2

    .line 508
    :cond_5
    if-eqz v4, :cond_6

    .line 510
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberViewHolder;->textStatus:Landroid/widget/TextView;

    const v1, 0x7f100178

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    goto :goto_1

    .line 511
    :cond_6
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getBirthday()Ljava/lang/Long;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/aws/integration/util/DateTimeUtils;->isAdult(Ljava/lang/Long;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 513
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getEmail()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 514
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberViewHolder;->smartphone:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_1

    .line 516
    :cond_7
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getStatus()Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    move-result-object v0

    sget-object v1, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;->invited:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    if-ne v0, v1, :cond_0

    .line 518
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberViewHolder;->a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getOwner()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 519
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberViewHolder;->textStatus:Landroid/widget/TextView;

    const v1, 0x7f100179

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 520
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberViewHolder;->textStatus:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f060074

    invoke-static {v1, v2}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_1
.end method
