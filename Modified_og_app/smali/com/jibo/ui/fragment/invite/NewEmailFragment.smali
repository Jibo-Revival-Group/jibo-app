.class public Lcom/jibo/ui/fragment/invite/NewEmailFragment;
.super Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;
.source "NewEmailFragment.java"


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
    const-class v0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;

    invoke-static {v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->r:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 50
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;-><init>()V

    .line 63
    sget-object v0, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->send_invite:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->t:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/invite/NewEmailFragment;)V
    .locals 0

    .prologue
    .line 50
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->t()V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/invite/NewEmailFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 50
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/invite/NewEmailFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/invite/NewEmailFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method static synthetic d(Lcom/jibo/ui/fragment/invite/NewEmailFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->s:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    return-object v0
.end method

.method private r()V
    .locals 10

    .prologue
    const/4 v4, 0x0

    .line 173
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->s()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 174
    new-instance v0, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;-><init>()V

    .line 175
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 176
    const-class v2, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 177
    const-class v2, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 178
    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;->setArguments(Landroid/os/Bundle;)V

    .line 179
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-class v2, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/AlreadyInTheLoopDialog;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 230
    :goto_0
    return-void

    .line 184
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    if-nez v0, :cond_1

    .line 185
    new-instance v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 187
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    const v1, 0x7f100284

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->c(Ljava/lang/String;)V

    .line 188
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    new-instance v1, Lcom/jibo/ui/fragment/invite/NewEmailFragment$2;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/invite/NewEmailFragment$2;-><init>(Lcom/jibo/ui/fragment/invite/NewEmailFragment;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$OnDismissListener;)V

    .line 196
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->j:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-string v2, "CircleFragment"

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 199
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->b()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    move-result-object v0

    .line 200
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->s:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getId()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->s:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getEmail()Ljava/lang/String;

    move-result-object v3

    iget-object v5, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->s:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 201
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

    new-instance v9, Lcom/jibo/ui/fragment/invite/NewEmailFragment$3;

    invoke-direct {v9, p0}, Lcom/jibo/ui/fragment/invite/NewEmailFragment$3;-><init>(Lcom/jibo/ui/fragment/invite/NewEmailFragment;)V

    move-object v5, v4

    move-object v6, v4

    move-object v7, v4

    .line 200
    invoke-virtual/range {v0 .. v9}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->updateMember(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;Ljava/lang/Long;Ljava/lang/Boolean;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    goto :goto_0

    .line 201
    :cond_2
    const/4 v5, 0x0

    goto :goto_1
.end method

.method private s()Z
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 233
    .line 235
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getMembers()Ljava/util/List;

    move-result-object v0

    .line 237
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

    .line 250
    :goto_0
    return v0

    .line 241
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

    .line 242
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v3

    if-eqz v3, :cond_2

    iget-object v3, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->s:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getEmail()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v4

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getEmail()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 243
    invoke-static {v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isMemberDeclined(Lcom/jibo/aws/integration/aws/services/loop/model/Member;)Z

    move-result v3

    if-nez v3, :cond_2

    invoke-static {v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isMemberRemoved(Lcom/jibo/aws/integration/aws/services/loop/model/Member;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 244
    const/4 v0, 0x1

    .line 245
    goto :goto_0

    :cond_3
    move v0, v1

    goto :goto_0
.end method

.method private t()V
    .locals 2

    .prologue
    .line 255
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->email:Landroid/widget/AutoCompleteTextView;

    invoke-virtual {v0}, Landroid/widget/AutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/jibo/utils/Commons;->a:Ljava/util/regex/Pattern;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->email:Landroid/widget/AutoCompleteTextView;

    .line 256
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

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    .line 258
    :goto_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->p:Landroid/view/MenuItem;

    invoke-interface {v1, v0}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 259
    return-void

    .line 256
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public a()V
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 119
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->d:Ljava/lang/String;

    .line 120
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->n:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    if-eqz v1, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->n:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v0

    .line 121
    :cond_0
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->s:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->s:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    if-eqz v1, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->s:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    .line 122
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v0

    .line 123
    :cond_1
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    if-eqz v1, :cond_2

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFirstName()Ljava/lang/String;

    move-result-object v0

    .line 125
    :cond_2
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->title:Landroid/widget/TextView;

    const v2, 0x7f1002de

    new-array v3, v5, [Ljava/lang/Object;

    aput-object v0, v3, v4

    invoke-virtual {p0, v2, v3}, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 126
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->email:Landroid/widget/AutoCompleteTextView;

    invoke-virtual {v1}, Landroid/widget/AutoCompleteTextView;->requestFocus()Z

    .line 127
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->email:Landroid/widget/AutoCompleteTextView;

    invoke-static {v1, v2}, Lcom/jibo/utils/UIUtils;->b(Landroid/content/Context;Landroid/view/View;)V

    .line 128
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->email:Landroid/widget/AutoCompleteTextView;

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->n:Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getEmail()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/AutoCompleteTextView;->setText(Ljava/lang/CharSequence;)V

    .line 130
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->email:Landroid/widget/AutoCompleteTextView;

    new-instance v2, Lcom/jibo/ui/fragment/invite/NewEmailFragment$1;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/invite/NewEmailFragment$1;-><init>(Lcom/jibo/ui/fragment/invite/NewEmailFragment;)V

    invoke-virtual {v1, v2}, Landroid/widget/AutoCompleteTextView;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 147
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->t:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    sget-object v2, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->add_email:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    if-ne v1, v2, :cond_3

    .line 148
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->footer:Landroid/widget/TextView;

    invoke-virtual {v1, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 149
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->footer:Landroid/widget/TextView;

    const v2, 0x7f100113

    new-array v3, v5, [Ljava/lang/Object;

    aput-object v0, v3, v4

    invoke-virtual {p0, v2, v3}, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 151
    :cond_3
    return-void
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 107
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 108
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayShowCustomEnabled(Z)V

    .line 109
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->m()V

    .line 110
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 155
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->s:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->email:Landroid/widget/AutoCompleteTextView;

    invoke-virtual {v1}, Landroid/widget/AutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setEmail(Ljava/lang/String;)V

    .line 156
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->email:Landroid/widget/AutoCompleteTextView;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/AutoCompleteTextView;->setText(Ljava/lang/CharSequence;)V

    .line 158
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->r()V

    .line 159
    return-void
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 97
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;->b(Landroid/os/Bundle;)V

    .line 98
    const-string v0, "ARG_MODE"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 99
    invoke-static {}, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->values()[Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    move-result-object v0

    const-string v1, "ARG_MODE"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    aget-object v0, v0, v1

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->t:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    .line 102
    :cond_0
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->s:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 103
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 114
    const v0, 0x7f100177

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 2

    .prologue
    .line 163
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 165
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->p:Landroid/view/MenuItem;

    const v1, 0x7f100045

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setTitle(I)Landroid/view/MenuItem;

    .line 166
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->p:Landroid/view/MenuItem;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setIcon(Landroid/graphics/drawable/Drawable;)Landroid/view/MenuItem;

    .line 168
    invoke-direct {p0}, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->t()V

    .line 169
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 69
    const v0, 0x7f0b006c

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 82
    invoke-super {p0}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;->onResume()V

    .line 84
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->a:Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;->a:Z

    .line 85
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->email:Landroid/widget/AutoCompleteTextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->a:Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/AutoCompleteTextView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 86
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 90
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 91
    const-string v0, "ARG_MODE"

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->t:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->ordinal()I

    move-result v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 92
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->s:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 93
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 74
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 76
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->l()V

    .line 77
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->e()V

    .line 78
    return-void
.end method
