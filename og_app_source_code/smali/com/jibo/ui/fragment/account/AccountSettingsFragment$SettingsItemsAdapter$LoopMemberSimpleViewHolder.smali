.class public Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder;
.super Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;
.source "AccountSettingsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter;
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


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 390
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;-><init>(Landroid/view/View;)V

    .line 392
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder;->nickName:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 393
    return-void
.end method


# virtual methods
.method public invalidateView()V
    .locals 4

    .prologue
    .line 396
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/Items$MemberItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$MemberItem;->b()Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v1

    .line 400
    :try_start_0
    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    .line 402
    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getNickname()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 403
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder;->name:Landroid/widget/TextView;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getNickname()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/jibo/utils/Util;->a(Landroid/widget/TextView;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 415
    :goto_0
    iget-object v2, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder;->nickName:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/Items$MemberItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$MemberItem;->c()Landroid/os/Bundle;

    move-result-object v0

    const-string v3, "string"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 418
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder;->avatar:Lcom/jibo/ui/view/RoundedImageView;

    invoke-static {v0, v2, v1}, Lcom/jibo/utils/Util;->a(Landroid/content/Context;Landroid/widget/ImageView;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V

    .line 419
    return-void

    .line 405
    :cond_0
    if-nez v0, :cond_1

    .line 406
    :try_start_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder;->name:Landroid/widget/TextView;

    const-string v2, ""

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 411
    :catch_0
    move-exception v0

    .line 412
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0

    .line 408
    :cond_1
    :try_start_2
    iget-object v2, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder;->name:Landroid/widget/TextView;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lcom/jibo/utils/Util;->a(Landroid/widget/TextView;Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_0
.end method
