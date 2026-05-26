.class public Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "ConfirmPasswordFragment.java"


# static fields
.field public static final b:Ljava/lang/String;


# instance fields
.field private a:Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

.field c:Landroid/view/MenuItem;

.field private d:Landroid/text/TextWatcher;

.field footer:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field footerError:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field password:Landroid/widget/EditText;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 43
    const-class v0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;

    invoke-static {v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->b:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 41
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 219
    new-instance v0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$3;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$3;-><init>(Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->d:Landroid/text/TextWatcher;

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;)V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->s()V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 41
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;)V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->t()V

    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 41
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method private r()Z
    .locals 2

    .prologue
    .line 161
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->password:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/jibo/utils/Commons;->b:Ljava/util/regex/Pattern;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->password:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/regex/Matcher;->matches()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private s()V
    .locals 2

    .prologue
    .line 239
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->footer:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 240
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->footerError:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 241
    return-void
.end method

.method private t()V
    .locals 2

    .prologue
    .line 244
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->footer:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 245
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->footerError:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 246
    return-void
.end method


# virtual methods
.method protected a()V
    .locals 3

    .prologue
    .line 209
    new-instance v0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    const-class v1, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;

    .line 210
    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;-><init>(Landroid/support/v4/app/Fragment;Ljava/lang/String;)V

    .line 211
    const-string v1, "ARGS_OLD_PASSWORD"

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->password:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Ljava/io/Serializable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 212
    const/16 v1, 0x3e7

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(I)V

    .line 213
    return-void
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 110
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 111
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayShowTitleEnabled(Z)V

    .line 112
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayShowCustomEnabled(Z)V

    .line 114
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->n()V

    .line 115
    return-void
.end method

.method protected b()I
    .locals 1

    .prologue
    .line 216
    const v0, 0x7f0b0065

    return v0
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 166
    const v0, 0x7f100401

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 1

    .prologue
    .line 91
    invoke-super {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/BaseFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 93
    const/16 v0, 0x3e7

    if-ne p1, v0, :cond_0

    .line 94
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/support/v4/app/FragmentActivity;->setResult(I)V

    .line 95
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 97
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 59
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 61
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->setHasOptionsMenu(Z)V

    .line 62
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1

    .prologue
    .line 101
    const v0, 0x7f0c0006

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 102
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 103
    const v0, 0x7f090026

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->c:Landroid/view/MenuItem;

    .line 105
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;Landroid/view/Menu;)V

    .line 106
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 68
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->b()I

    move-result v0

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onForgotPasswordClick(Landroid/view/View;)V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 128
    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->f()V

    .line 130
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v0

    .line 131
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/db/EntityData;->a()Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    move-result-object v1

    .line 132
    new-instance v2, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$1;

    invoke-direct {v2, p0, v0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$1;-><init>(Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;Ljava/lang/String;)V

    invoke-virtual {v1, v0, v2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->sendPasswordReset(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 158
    :goto_0
    return-void

    .line 154
    :catch_0
    move-exception v0

    .line 155
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->g()V

    .line 156
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2

    .prologue
    .line 73
    const v0, 0x7f090026

    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 74
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->q()V

    .line 75
    const/4 v0, 0x1

    .line 77
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method

.method public onPrepareOptionsMenu(Landroid/view/Menu;)V
    .locals 2

    .prologue
    .line 119
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onPrepareOptionsMenu(Landroid/view/Menu;)V

    .line 121
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->c:Landroid/view/MenuItem;

    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->r()Z

    move-result v1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 122
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 83
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 85
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->password:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->d:Landroid/text/TextWatcher;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 86
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->a()Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->a:Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    .line 87
    return-void
.end method

.method public q()V
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 171
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->a(Z)V

    .line 172
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->c:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 174
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->a:Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->password:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->password:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2;

    invoke-direct {v3, p0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2;-><init>(Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;)V

    invoke-virtual {v0, v1, v2, v3}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->changePassword(Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 206
    return-void
.end method
