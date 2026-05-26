.class public Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "ChangeEmailFragment.java"


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field b:Landroid/view/MenuItem;

.field private c:Ljava/lang/String;

.field private d:Landroid/text/TextWatcher;

.field email:Landroid/widget/EditText;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field footer:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field footerError:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 40
    const-class v0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;

    invoke-static {v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 38
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 205
    new-instance v0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$2;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$2;-><init>(Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->d:Landroid/text/TextWatcher;

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;)V
    .locals 0

    .prologue
    .line 38
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->r()V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 38
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;)V
    .locals 0

    .prologue
    .line 38
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->s()V

    return-void
.end method

.method private q()Z
    .locals 2

    .prologue
    .line 130
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->email:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/jibo/utils/Commons;->a:Ljava/util/regex/Pattern;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->email:Landroid/widget/EditText;

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

.method private r()V
    .locals 2

    .prologue
    .line 225
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->footer:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 226
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->footerError:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 227
    return-void
.end method

.method private s()V
    .locals 2

    .prologue
    .line 230
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->footer:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 231
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->footerError:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 232
    return-void
.end method


# virtual methods
.method public a()V
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 140
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->a(Z)V

    .line 141
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->b:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 143
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->a()Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    move-result-object v0

    .line 145
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->email:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->c:Ljava/lang/String;

    new-instance v3, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;

    invoke-direct {v3, p0}, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment$1;-><init>(Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;)V

    invoke-virtual {v0, v1, v2, v3}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->changeEmail(Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 190
    return-void
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 115
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 116
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayShowTitleEnabled(Z)V

    .line 117
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayShowCustomEnabled(Z)V

    .line 119
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->n()V

    .line 120
    return-void
.end method

.method protected b()I
    .locals 1

    .prologue
    .line 202
    const v0, 0x7f0b0063

    return v0
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 66
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->b(Landroid/os/Bundle;)V

    .line 67
    const-string v0, "ARGS_PASSWORD"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->c:Ljava/lang/String;

    .line 68
    return-void
.end method

.method protected b(Z)V
    .locals 3

    .prologue
    .line 193
    new-instance v1, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    const-class v0, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;

    .line 194
    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, p0, v0}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;-><init>(Landroid/support/v4/app/Fragment;Ljava/lang/String;)V

    .line 195
    const-string v0, "ARGS_EMAIL"

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->email:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Ljava/io/Serializable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 196
    const-string v0, "ARGS_PASSWORD"

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->c:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Ljava/io/Serializable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 197
    const-string v2, "ARGS_IS_ERROR"

    if-nez p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {v1, v2, v0}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Z)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 198
    const/16 v0, 0x3e7

    invoke-virtual {v1, v0}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(I)V

    .line 199
    return-void

    .line 197
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 135
    const v0, 0x7f1003fc

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 1

    .prologue
    .line 96
    invoke-super {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/BaseFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 98
    const/16 v0, 0x3e7

    if-ne p1, v0, :cond_0

    .line 99
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/support/v4/app/FragmentActivity;->setResult(I)V

    .line 100
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 102
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

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->setHasOptionsMenu(Z)V

    .line 62
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1

    .prologue
    .line 106
    const v0, 0x7f0c0006

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 107
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 108
    const v0, 0x7f090026

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->b:Landroid/view/MenuItem;

    .line 110
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;Landroid/view/Menu;)V

    .line 111
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 74
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->b()I

    move-result v0

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2

    .prologue
    .line 79
    const v0, 0x7f090026

    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 80
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->a()V

    .line 81
    const/4 v0, 0x1

    .line 83
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
    .line 124
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onPrepareOptionsMenu(Landroid/view/Menu;)V

    .line 126
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->b:Landroid/view/MenuItem;

    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->q()Z

    move-result v1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 127
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 89
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 91
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->email:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->d:Landroid/text/TextWatcher;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 92
    return-void
.end method
