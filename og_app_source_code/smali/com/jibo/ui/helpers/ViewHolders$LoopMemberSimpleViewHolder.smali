.class public Lcom/jibo/ui/helpers/ViewHolders$LoopMemberSimpleViewHolder;
.super Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;
.source "ViewHolders.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/ViewHolders;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LoopMemberSimpleViewHolder"
.end annotation


# instance fields
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


# virtual methods
.method public invalidateView()V
    .locals 3

    .prologue
    .line 547
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberSimpleViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/Items$MemberItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$MemberItem;->b()Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v1

    .line 548
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberSimpleViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/Items$MemberItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$MemberItem;->a()Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 552
    :try_start_0
    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    .line 554
    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getNickname()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 555
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberSimpleViewHolder;->name:Landroid/widget/TextView;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getNickname()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/jibo/utils/Util;->a(Landroid/widget/TextView;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 568
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberSimpleViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberSimpleViewHolder;->avatar:Lcom/jibo/ui/view/RoundedImageView;

    invoke-static {v0, v2, v1}, Lcom/jibo/utils/Util;->a(Landroid/content/Context;Landroid/widget/ImageView;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V

    .line 569
    return-void

    .line 557
    :cond_0
    if-nez v0, :cond_1

    .line 558
    :try_start_1
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberSimpleViewHolder;->name:Landroid/widget/TextView;

    const-string v2, ""

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 563
    :catch_0
    move-exception v0

    .line 564
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0

    .line 560
    :cond_1
    :try_start_2
    iget-object v2, p0, Lcom/jibo/ui/helpers/ViewHolders$LoopMemberSimpleViewHolder;->name:Landroid/widget/TextView;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lcom/jibo/utils/Util;->a(Landroid/widget/TextView;Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_0
.end method
