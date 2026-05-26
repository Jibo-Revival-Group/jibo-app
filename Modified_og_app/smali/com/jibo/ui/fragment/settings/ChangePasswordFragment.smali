.class public Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "ChangePasswordFragment.java"


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field b:Landroid/view/MenuItem;

.field private c:Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

.field private d:Ljava/lang/String;

.field private e:Landroid/text/TextWatcher;

.field footer:Landroid/widget/TextView;
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
    .line 40
    const-class v0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;

    invoke-static {v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 53
    new-instance v0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$1;-><init>(Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->e:Landroid/text/TextWatcher;

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 36
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;Z)V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0, p1}, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->b(Z)V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;)Z
    .locals 1

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->b()Z

    move-result v0

    return v0
.end method

.method private b(Z)V
    .locals 3

    .prologue
    .line 151
    const v0, 0x7f1000a3

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 153
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->password:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->footer:Landroid/widget/TextView;

    invoke-static {v1, v2}, Lcom/jibo/utils/UIUtils;->a(Ljava/lang/String;Landroid/widget/TextView;)V

    .line 154
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->footer:Landroid/widget/TextView;

    new-instance v2, Landroid/text/SpannableStringBuilder;

    invoke-direct {v2, v0}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    const-string v0, "\n\n"

    invoke-virtual {v2, v0}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->footer:Landroid/widget/TextView;

    invoke-virtual {v2}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 155
    return-void
.end method

.method private b()Z
    .locals 2

    .prologue
    .line 147
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->password:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/jibo/utils/Commons;->b:Ljava/util/regex/Pattern;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->password:Landroid/widget/EditText;

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


# virtual methods
.method public a()V
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 159
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->a(Z)V

    .line 160
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->b:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 162
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->c:Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->d:Ljava/lang/String;

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->password:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$2;

    invoke-direct {v3, p0}, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment$2;-><init>(Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;)V

    invoke-virtual {v0, v1, v2, v3}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->changePassword(Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 182
    return-void
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 125
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 126
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayShowTitleEnabled(Z)V

    .line 127
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayShowCustomEnabled(Z)V

    .line 129
    const v0, 0x7f080282

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setHomeAsUpIndicator(I)V

    .line 131
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->n()V

    .line 132
    return-void
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 81
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->b(Landroid/os/Bundle;)V

    .line 83
    const-string v0, "ARGS_OLD_PASSWORD"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->d:Ljava/lang/String;

    .line 84
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 136
    const v0, 0x7f1003fd

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 75
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 76
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->setHasOptionsMenu(Z)V

    .line 77
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1

    .prologue
    .line 116
    const v0, 0x7f0c0007

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 117
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 118
    const v0, 0x7f090030

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->b:Landroid/view/MenuItem;

    .line 120
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;Landroid/view/Menu;)V

    .line 121
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 90
    const v0, 0x7f0b0064

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2

    .prologue
    .line 95
    const v0, 0x7f090030

    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 96
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->a()V

    .line 97
    const/4 v0, 0x1

    .line 99
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
    .line 141
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onPrepareOptionsMenu(Landroid/view/Menu;)V

    .line 143
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->b:Landroid/view/MenuItem;

    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->b()Z

    move-result v1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 144
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 105
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 107
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->password:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->e:Landroid/text/TextWatcher;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 108
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->a()Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->c:Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    .line 110
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/settings/ChangePasswordFragment;->b(Z)V

    .line 111
    return-void
.end method
