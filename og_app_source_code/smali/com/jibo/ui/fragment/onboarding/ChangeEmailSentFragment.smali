.class public Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "ChangeEmailSentFragment.java"

# interfaces
.implements Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapperClickListener;


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field private b:Ljava/lang/String;

.field private c:Z

.field private d:Z

.field private e:Ljava/lang/String;

.field text_instructions:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 36
    const-class v0, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 50
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 46
    iput-boolean v0, p0, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->c:Z

    .line 47
    iput-boolean v0, p0, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->d:Z

    .line 52
    return-void
.end method

.method private a()V
    .locals 3

    .prologue
    .line 88
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 89
    const-string v1, "ARGS_EMAIL"

    iget-object v2, p0, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->b:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 90
    new-instance v1, Lcom/jibo/ui/fragment/dialog/EmailChangeFailedDialog;

    invoke-direct {v1}, Lcom/jibo/ui/fragment/dialog/EmailChangeFailedDialog;-><init>()V

    .line 91
    invoke-virtual {v1, v0}, Lcom/jibo/ui/fragment/dialog/EmailChangeFailedDialog;->setArguments(Landroid/os/Bundle;)V

    .line 92
    const/4 v0, 0x1

    invoke-virtual {v1, p0, v0}, Lcom/jibo/ui/fragment/dialog/EmailChangeFailedDialog;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 93
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-class v2, Lcom/jibo/ui/fragment/dialog/EmailChangeFailedDialog;

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Lcom/jibo/ui/fragment/dialog/EmailChangeFailedDialog;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 94
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;)V
    .locals 0

    .prologue
    .line 32
    invoke-direct {p0}, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->a()V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 32
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method


# virtual methods
.method public a(IILjava/lang/Object;)V
    .locals 4

    .prologue
    .line 116
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->a(Z)V

    .line 118
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->a()Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    move-result-object v0

    .line 120
    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->b:Ljava/lang/String;

    iget-object v2, p0, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->e:Ljava/lang/String;

    new-instance v3, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment$1;

    invoke-direct {v3, p0}, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment$1;-><init>(Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;)V

    invoke-virtual {v0, v1, v2, v3}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->changeEmail(Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 145
    return-void
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 98
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 99
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->l()V

    .line 100
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 101
    return-void
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 61
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->b(Landroid/os/Bundle;)V

    .line 62
    const-string v0, "ARGS_EMAIL"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->b:Ljava/lang/String;

    .line 63
    const-string v0, "ARGS_PASSWORD"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->e:Ljava/lang/String;

    .line 65
    const-string v0, "ARGS_IS_ERROR"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->d:Z

    .line 67
    return-void
.end method

.method public logout(Landroid/view/View;)V
    .locals 2
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 110
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    sget v1, Lcom/jibo/ui/activity/TabbedActivity;->c:I

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->setResult(I)V

    .line 111
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 112
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 105
    const v0, 0x7f1002fc

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 56
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 57
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 71
    const v0, 0x7f0b006a

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 76
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 78
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->text_instructions:Landroid/widget/TextView;

    const v1, 0x7f1000a0

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->b:Ljava/lang/String;

    aput-object v3, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 81
    iget-boolean v0, p0, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->d:Z

    if-eqz v0, :cond_0

    .line 82
    iput-boolean v4, p0, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->d:Z

    .line 83
    invoke-direct {p0}, Lcom/jibo/ui/fragment/onboarding/ChangeEmailSentFragment;->a()V

    .line 85
    :cond_0
    return-void
.end method
