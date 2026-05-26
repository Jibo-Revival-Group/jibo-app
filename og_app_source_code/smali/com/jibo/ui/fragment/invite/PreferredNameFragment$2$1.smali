.class Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;
.super Ljava/lang/Object;
.source "PreferredNameFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a(Lcom/jibo/aws/integration/aws/services/collision/model/MatchRequest;Lcom/jibo/aws/integration/aws/services/collision/model/CollisionCheckContainer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/collision/model/CollisionCheckContainer;

.field final synthetic b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;Lcom/jibo/aws/integration/aws/services/collision/model/CollisionCheckContainer;)V
    .locals 0

    .prologue
    .line 253
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;

    iput-object p2, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->a:Lcom/jibo/aws/integration/aws/services/collision/model/CollisionCheckContainer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x1

    .line 256
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->g()V

    .line 258
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    invoke-virtual {v0, v4}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->b(Z)V

    .line 260
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->a:Lcom/jibo/aws/integration/aws/services/collision/model/CollisionCheckContainer;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/collision/model/CollisionCheckContainer;->getCollision()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_4

    .line 261
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->b(Lcom/jibo/ui/fragment/invite/PreferredNameFragment;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 262
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/SingleFragmentActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/SingleFragmentActivity;->q()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "ARGS_CHOSEN_NICKNAME"

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;

    iget-object v2, v2, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    iget-object v2, v2, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->d:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 263
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/SingleFragmentActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/SingleFragmentActivity;->q()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "ARGS_CHOSEN_PHONETIC_NAME"

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;

    iget-object v2, v2, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    iget-object v2, v2, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->e:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 264
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 293
    :goto_0
    return-void

    .line 266
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;

    iget-object v1, v1, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->nickname:Landroid/widget/EditText;

    invoke-static {v0, v1}, Lcom/jibo/utils/UIUtils;->a(Landroid/content/Context;Landroid/view/View;)V

    .line 268
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/aws/integration/util/DateTimeUtils;->isAdult(Ljava/lang/Long;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 269
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    if-nez v0, :cond_1

    .line 270
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    const-class v1, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->a(Ljava/lang/Class;)V

    goto :goto_0

    .line 272
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    const-class v1, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->a(Ljava/lang/Class;)V

    goto :goto_0

    .line 275
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    iget-boolean v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->o:Z

    if-eqz v0, :cond_3

    .line 276
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    const-class v1, Lcom/jibo/ui/fragment/invite/EmailFragment;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->a(Ljava/lang/Class;)V

    goto :goto_0

    .line 278
    :cond_3
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    const-class v1, Lcom/jibo/ui/fragment/invite/EmailInviteInfoFragment;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->a(Ljava/lang/Class;)V

    goto :goto_0

    .line 283
    :cond_4
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->mPreferredNameTip:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;

    iget-object v1, v1, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f060074

    invoke-static {v1, v2}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 285
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->nickname:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 286
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    iget-object v1, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->mPreferredNameTip:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;

    iget-object v2, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    const v3, 0x7f100250

    new-array v4, v4, [Ljava/lang/Object;

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->c(Lcom/jibo/ui/fragment/invite/PreferredNameFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->c(Lcom/jibo/ui/fragment/invite/PreferredNameFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v0

    :goto_1
    aput-object v0, v4, v5

    invoke-virtual {v2, v3, v4}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    :cond_5
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFirstName()Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 288
    :cond_6
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->mPreferredNameTip:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;

    iget-object v1, v1, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2;->a:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    const v2, 0x7f100251

    new-array v3, v4, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment$2$1;->a:Lcom/jibo/aws/integration/aws/services/collision/model/CollisionCheckContainer;

    .line 289
    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/collision/model/CollisionCheckContainer;->getClosestPair()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/jibo/utils/Util;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    .line 288
    invoke-virtual {v1, v2, v3}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0
.end method
