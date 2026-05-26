.class public Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;
.super Lcom/jibo/ui/fragment/dialog/BaseDialogFragment;
.source "LoopPassphraseBaseDialog.java"


# static fields
.field public static final d:Ljava/lang/String;


# instance fields
.field btnCancel:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field btnSet:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field protected e:Ljava/lang/String;

.field protected f:Landroid/text/TextWatcher;

.field footer:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field passphraseEdit:Landroid/widget/EditText;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field text:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field title:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 26
    const-class v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->d:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 24
    invoke-direct {p0}, Lcom/jibo/ui/fragment/dialog/BaseDialogFragment;-><init>()V

    .line 83
    new-instance v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog$1;-><init>(Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->f:Landroid/text/TextWatcher;

    return-void
.end method


# virtual methods
.method public a(Landroid/os/Bundle;I)Landroid/app/Dialog;
    .locals 5

    .prologue
    .line 51
    new-instance v0, Landroid/support/v7/app/AppCompatDialog;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x1030134

    invoke-direct {v0, v1, v2}, Landroid/support/v7/app/AppCompatDialog;-><init>(Landroid/content/Context;I)V

    .line 54
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->b:Landroid/view/View;

    .line 55
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->b:Landroid/view/View;

    invoke-static {p0, v1}, Lbutterknife/ButterKnife;->a(Ljava/lang/Object;Landroid/view/View;)Lbutterknife/Unbinder;

    .line 57
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->passphraseEdit:Landroid/widget/EditText;

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->f:Landroid/text/TextWatcher;

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 59
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->passphraseEdit:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->footer:Landroid/widget/TextView;

    .line 60
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->getContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f06001f

    invoke-static {v3, v4}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v3

    .line 59
    invoke-static {v1, v2, v3}, Lcom/jibo/utils/UIUtils;->b(Ljava/lang/String;Landroid/widget/TextView;I)V

    .line 61
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->btnSet:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->passphraseEdit:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/jibo/utils/UIUtils;->a(Ljava/lang/String;)Z

    move-result v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setEnabled(Z)V

    .line 63
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->b:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/support/v7/app/AppCompatDialog;->setContentView(Landroid/view/View;)V

    .line 64
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->setCancelable(Z)V

    .line 66
    return-object v0
.end method

.method public a(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 78
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/dialog/BaseDialogFragment;->a(Landroid/os/Bundle;)V

    .line 80
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARGS_DIALOG_TYPE"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->e:Ljava/lang/String;

    .line 81
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 71
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/dialog/BaseDialogFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 73
    const-string v0, "ARGS_DIALOG_TYPE"

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseBaseDialog;->e:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 74
    return-void
.end method
