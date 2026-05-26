.class public Lcom/jibo/ui/fragment/invite/EmailFragment;
.super Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;
.source "EmailFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;
    }
.end annotation


# static fields
.field public static final r:Ljava/lang/String;


# instance fields
.field email:Landroid/widget/AutoCompleteTextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field footer:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private s:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

.field private t:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

.field title:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 52
    const-class v0, Lcom/jibo/ui/fragment/invite/EmailFragment;

    invoke-static {v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/invite/EmailFragment;->r:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;-><init>()V

    .line 65
    sget-object v0, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->send_invite:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->t:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/invite/EmailFragment;)V
    .locals 0

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/EmailFragment;->v()V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/invite/EmailFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 48
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/invite/EmailFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/invite/EmailFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/invite/EmailFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 48
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/invite/EmailFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/invite/EmailFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method static synthetic d(Lcom/jibo/ui/fragment/invite/EmailFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->s:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    return-object v0
.end method

.method static synthetic e(Lcom/jibo/ui/fragment/invite/EmailFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method static synthetic f(Lcom/jibo/ui/fragment/invite/EmailFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method private s()V
    .locals 10

    .prologue
    const/4 v4, 0x0

    .line 207
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/EmailFragment;->u()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 208
    new-instance v0, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;-><init>()V

    .line 209
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 210
    const-class v2, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 211
    const-class v2, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 212
    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;->setArguments(Landroid/os/Bundle;)V

    .line 213
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/EmailFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-class v2, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 264
    :goto_0
    return-void

    .line 218
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    if-nez v0, :cond_1

    .line 219
    new-instance v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 221
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    const v1, 0x7f100284

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/invite/EmailFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->c(Ljava/lang/String;)V

    .line 222
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    new-instance v1, Lcom/jibo/ui/fragment/invite/EmailFragment$2;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/invite/EmailFragment$2;-><init>(Lcom/jibo/ui/fragment/invite/EmailFragment;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$OnDismissListener;)V

    .line 230
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/EmailFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-string v2, "CircleFragment"

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 233
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/EmailFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->b()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    move-result-object v0

    .line 234
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->s:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getId()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->s:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getEmail()Ljava/lang/String;

    move-result-object v3

    iget-object v5, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->s:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 235
    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v5

    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getBirthday()Ljava/lang/Long;

    move-result-object v5

    invoke-static {v5}, Lcom/jibo/aws/integration/util/DateTimeUtils;->isAdult(Ljava/lang/Long;)Z

    move-result v5

    if-nez v5, :cond_2

    const/4 v5, 0x1

    :goto_1
    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    new-instance v9, Lcom/jibo/ui/fragment/invite/EmailFragment$3;

    invoke-direct {v9, p0}, Lcom/jibo/ui/fragment/invite/EmailFragment$3;-><init>(Lcom/jibo/ui/fragment/invite/EmailFragment;)V

    move-object v5, v4

    move-object v6, v4

    move-object v7, v4

    .line 234
    invoke-virtual/range {v0 .. v9}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->updateMember(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;Ljava/lang/Long;Ljava/lang/Boolean;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    goto :goto_0

    .line 235
    :cond_2
    const/4 v5, 0x0

    goto :goto_1
.end method

.method private t()V
    .locals 10

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 280
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    if-nez v0, :cond_0

    .line 281
    new-instance v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 283
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    const v1, 0x7f100344

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-virtual {p0, v1, v2}, Lcom/jibo/ui/fragment/invite/EmailFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->c(Ljava/lang/String;)V

    .line 284
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    new-instance v1, Lcom/jibo/ui/fragment/invite/EmailFragment$4;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/invite/EmailFragment$4;-><init>(Lcom/jibo/ui/fragment/invite/EmailFragment;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$OnDismissListener;)V

    .line 293
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/EmailFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-string v2, "CircleFragment"

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 296
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/EmailFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->b()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->m:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getId()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 297
    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v3

    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    new-instance v9, Lcom/jibo/ui/fragment/invite/EmailFragment$5;

    invoke-direct {v9, p0}, Lcom/jibo/ui/fragment/invite/EmailFragment$5;-><init>(Lcom/jibo/ui/fragment/invite/EmailFragment;)V

    move-object v5, v4

    move-object v6, v4

    move-object v7, v4

    .line 296
    invoke-virtual/range {v0 .. v9}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->updateMember(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;Ljava/lang/Long;Ljava/lang/Boolean;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 314
    return-void
.end method

.method private u()Z
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 317
    .line 319
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getMembers()Ljava/util/List;

    move-result-object v0

    .line 321
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    const/4 v3, 0x2

    if-gt v2, v3, :cond_1

    :cond_0
    move v0, v1

    .line 334
    :goto_0
    return v0

    .line 325
    :cond_1
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 326
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v3

    if-eqz v3, :cond_2

    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v4

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getEmail()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 327
    invoke-static {v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isMemberDeclined(Lcom/jibo/aws/integration/aws/services/loop/model/Member;)Z

    move-result v3

    if-nez v3, :cond_2

    invoke-static {v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isMemberRemoved(Lcom/jibo/aws/integration/aws/services/loop/model/Member;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 328
    const/4 v0, 0x1

    .line 329
    goto :goto_0

    :cond_3
    move v0, v1

    goto :goto_0
.end method

.method private v()V
    .locals 2

    .prologue
    .line 339
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->email:Landroid/widget/AutoCompleteTextView;

    invoke-virtual {v0}, Landroid/widget/AutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Lcom/jibo/utils/Commons;->a:Ljava/util/regex/Pattern;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->email:Landroid/widget/AutoCompleteTextView;

    .line 340
    invoke-virtual {v1}, Landroid/widget/AutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/regex/Matcher;->matches()Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    .line 342
    :goto_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->p:Landroid/view/MenuItem;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->p:Landroid/view/MenuItem;

    invoke-interface {v1, v0}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 343
    :cond_0
    return-void

    .line 340
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public a()V
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 129
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->d:Ljava/lang/String;

    .line 130
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->n:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    if-eqz v1, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->n:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v0

    .line 131
    :cond_0
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->s:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->s:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    if-eqz v1, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->s:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    .line 132
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v0

    .line 133
    :cond_1
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    if-eqz v1, :cond_2

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFirstName()Ljava/lang/String;

    move-result-object v0

    .line 134
    :cond_2
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->title:Landroid/widget/TextView;

    const v2, 0x7f1002de

    new-array v3, v5, [Ljava/lang/Object;

    aput-object v0, v3, v4

    invoke-virtual {p0, v2, v3}, Lcom/jibo/ui/fragment/invite/EmailFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 136
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->email:Landroid/widget/AutoCompleteTextView;

    new-instance v2, Lcom/jibo/ui/fragment/invite/EmailFragment$1;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/invite/EmailFragment$1;-><init>(Lcom/jibo/ui/fragment/invite/EmailFragment;)V

    invoke-virtual {v1, v2}, Landroid/widget/AutoCompleteTextView;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 153
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->email:Landroid/widget/AutoCompleteTextView;

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/AutoCompleteTextView;->setText(Ljava/lang/CharSequence;)V

    .line 154
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->email:Landroid/widget/AutoCompleteTextView;

    invoke-virtual {v1}, Landroid/widget/AutoCompleteTextView;->requestFocus()Z

    .line 155
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/EmailFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->email:Landroid/widget/AutoCompleteTextView;

    invoke-static {v1, v2}, Lcom/jibo/utils/UIUtils;->b(Landroid/content/Context;Landroid/view/View;)V

    .line 157
    iget-boolean v1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->o:Z

    if-eqz v1, :cond_4

    .line 158
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->footer:Landroid/widget/TextView;

    invoke-virtual {v1, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 159
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->footer:Landroid/widget/TextView;

    const v2, 0x7f10011e

    new-array v3, v5, [Ljava/lang/Object;

    aput-object v0, v3, v4

    invoke-virtual {p0, v2, v3}, Lcom/jibo/ui/fragment/invite/EmailFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 164
    :cond_3
    :goto_0
    return-void

    .line 160
    :cond_4
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->t:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    sget-object v2, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->add_email:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    if-ne v1, v2, :cond_3

    .line 161
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->footer:Landroid/widget/TextView;

    invoke-virtual {v1, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 162
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->footer:Landroid/widget/TextView;

    const v2, 0x7f100113

    new-array v3, v5, [Ljava/lang/Object;

    aput-object v0, v3, v4

    invoke-virtual {p0, v2, v3}, Lcom/jibo/ui/fragment/invite/EmailFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 108
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 109
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayShowTitleEnabled(Z)V

    .line 110
    const v0, 0x7f08005e

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setHomeAsUpIndicator(I)V

    .line 111
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/EmailFragment;->m()V

    .line 112
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 168
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->email:Landroid/widget/AutoCompleteTextView;

    invoke-virtual {v1}, Landroid/widget/AutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setEmail(Ljava/lang/String;)V

    .line 169
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->t:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    sget-object v1, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->add_email:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    if-ne v0, v1, :cond_0

    .line 170
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->s:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->email:Landroid/widget/AutoCompleteTextView;

    invoke-virtual {v1}, Landroid/widget/AutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setEmail(Ljava/lang/String;)V

    .line 171
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/EmailFragment;->s()V

    .line 175
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->email:Landroid/widget/AutoCompleteTextView;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/AutoCompleteTextView;->setText(Ljava/lang/CharSequence;)V

    .line 176
    return-void

    .line 173
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/EmailFragment;->r()V

    goto :goto_0
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 99
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;->b(Landroid/os/Bundle;)V

    .line 100
    const-string v0, "ARG_MODE"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 101
    invoke-static {}, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->values()[Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    move-result-object v0

    const-string v1, "ARG_MODE"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    aget-object v0, v0, v1

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->t:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    .line 103
    :cond_0
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->s:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 104
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 119
    iget-boolean v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->o:Z

    if-eqz v0, :cond_0

    .line 120
    const v0, 0x7f1003f9

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/invite/EmailFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 122
    :goto_0
    return-object v0

    :cond_0
    const v0, 0x7f100177

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/invite/EmailFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 2

    .prologue
    .line 268
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 270
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->p:Landroid/view/MenuItem;

    const v1, 0x7f100045

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setTitle(I)Landroid/view/MenuItem;

    .line 271
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->p:Landroid/view/MenuItem;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setIcon(Landroid/graphics/drawable/Drawable;)Landroid/view/MenuItem;

    .line 272
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/EmailFragment;->v()V

    .line 273
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 71
    const v0, 0x7f0b006c

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 84
    invoke-super {p0}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;->onResume()V

    .line 86
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->a:Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;->a:Z

    .line 87
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->email:Landroid/widget/AutoCompleteTextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->a:Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/AutoCompleteTextView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 88
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 92
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 93
    const-string v0, "ARG_MODE"

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->t:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->ordinal()I

    move-result v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 94
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->s:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 95
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 76
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 78
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/EmailFragment;->l()V

    .line 79
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/EmailFragment;->e()V

    .line 80
    return-void
.end method

.method public r()V
    .locals 4

    .prologue
    .line 179
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/EmailFragment;->e()V

    .line 180
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->email:Landroid/widget/AutoCompleteTextView;

    invoke-virtual {v1}, Landroid/widget/AutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setEmail(Ljava/lang/String;)V

    .line 181
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/EmailFragment;->u()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 182
    new-instance v0, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;-><init>()V

    .line 183
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 184
    const-class v2, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 185
    const-class v2, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 186
    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;->setArguments(Landroid/os/Bundle;)V

    .line 187
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/EmailFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-class v2, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 203
    :goto_0
    return-void

    .line 191
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->t:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    sget-object v1, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->return_email:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    if-ne v0, v1, :cond_1

    .line 192
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 193
    const-string v1, "ARGS_CHOSEN_EMAIL"

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->email:Landroid/widget/AutoCompleteTextView;

    invoke-virtual {v2}, Landroid/widget/AutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 194
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/EmailFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/4 v2, -0x1

    invoke-virtual {v1, v2, v0}, Landroid/support/v4/app/FragmentActivity;->setResult(ILandroid/content/Intent;)V

    .line 195
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/EmailFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    goto :goto_0

    .line 196
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment;->t:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    sget-object v1, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->send_invite:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    if-ne v0, v1, :cond_2

    .line 197
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/EmailFragment;->q()V

    goto :goto_0

    .line 200
    :cond_2
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/EmailFragment;->t()V

    goto :goto_0
.end method
