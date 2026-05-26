.class public Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;
.super Lcom/jibo/ui/fragment/wifi/WiFiHelpAbstractFragment;
.source "WiFiError1Fragment.java"


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field final b:Landroid/text/TextWatcher;

.field btnTryAgain:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field final c:Landroid/text/TextWatcher;

.field editPassword:Landroid/widget/EditText;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field editSSID:Landroid/widget/EditText;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field txtPasswordHint:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 29
    const-class v0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;

    invoke-static {v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/WiFiHelpAbstractFragment;-><init>()V

    .line 40
    new-instance v0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment$1;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->b:Landroid/text/TextWatcher;

    .line 53
    new-instance v0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment$2;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment$2;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->c:Landroid/text/TextWatcher;

    return-void
.end method

.method private a()Ljava/lang/String;
    .locals 2

    .prologue
    .line 125
    const-string v0, ""

    .line 127
    :try_start_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->editSSID:Landroid/widget/EditText;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->editSSID:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 131
    :cond_0
    :goto_0
    return-object v0

    .line 128
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;)V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->r()V

    return-void
.end method

.method private q()Ljava/lang/String;
    .locals 2

    .prologue
    .line 135
    const-string v0, ""

    .line 137
    :try_start_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->editPassword:Landroid/widget/EditText;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->editPassword:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 141
    :cond_0
    :goto_0
    return-object v0

    .line 138
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private r()V
    .locals 5

    .prologue
    .line 145
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 147
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->a()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/Util;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 148
    const v0, 0x7f100133

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 152
    :cond_0
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->q()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->q()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0x8

    if-ge v0, v1, :cond_1

    .line 153
    const v0, 0x7f10012f

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 156
    :cond_1
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_2

    const/4 v0, 0x1

    .line 158
    :goto_0
    iget-object v3, p0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->txtPasswordHint:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    if-nez v0, :cond_3

    const v1, 0x7f060074

    :goto_1
    invoke-static {v4, v1}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v1

    invoke-virtual {v3, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 160
    iget-object v3, p0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->txtPasswordHint:Landroid/widget/TextView;

    if-nez v0, :cond_4

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    :goto_2
    invoke-virtual {v3, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 162
    iget-object v2, p0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->editPassword:Landroid/widget/EditText;

    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->a()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/utils/Util;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_5

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 163
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->a()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/jibo/utils/Util;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const v3, 0x7f100169

    invoke-virtual {p0, v3}, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 162
    :goto_3
    invoke-virtual {v2, v1}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    .line 166
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->btnTryAgain:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setEnabled(Z)V

    .line 167
    return-void

    .line 156
    :cond_2
    const/4 v0, 0x0

    goto :goto_0

    .line 158
    :cond_3
    const v1, 0x7f0600c6

    goto :goto_1

    .line 160
    :cond_4
    const v1, 0x7f1001d5

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_2

    .line 163
    :cond_5
    const v1, 0x7f10016a

    .line 164
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_3
.end method


# virtual methods
.method public btnSupportClick(Landroid/view/View;)V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 119
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    const v2, 0x7f1002e4

    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->startActivity(Landroid/content/Intent;)V

    .line 120
    return-void
.end method

.method public btnTryAgainClick(Landroid/view/View;)V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 108
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->e()V

    .line 110
    sget-object v0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->e:Landroid/os/Bundle;

    const-string v1, "ARG_SSID"

    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->a()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/jibo/utils/Util;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 112
    sget-object v0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->e:Landroid/os/Bundle;

    const-string v1, "ARG_PASSWORD"

    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->q()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 114
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-class v1, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/app/FragmentManager;->a(Ljava/lang/String;I)Z

    .line 115
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 103
    const v0, 0x7f10042c

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 0

    .prologue
    .line 28
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/WiFiHelpAbstractFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 71
    const v0, 0x7f0b0097

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 1

    .prologue
    .line 28
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiHelpAbstractFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    return v0
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 95
    invoke-super {p0}, Lcom/jibo/ui/fragment/wifi/WiFiHelpAbstractFragment;->onPause()V

    .line 97
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->editSSID:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->b:Landroid/text/TextWatcher;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->removeTextChangedListener(Landroid/text/TextWatcher;)V

    .line 98
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->editPassword:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->c:Landroid/text/TextWatcher;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->removeTextChangedListener(Landroid/text/TextWatcher;)V

    .line 99
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 86
    invoke-super {p0}, Lcom/jibo/ui/fragment/wifi/WiFiHelpAbstractFragment;->onResume()V

    .line 88
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->editSSID:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->b:Landroid/text/TextWatcher;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 89
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->editPassword:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->c:Landroid/text/TextWatcher;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 90
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->r()V

    .line 91
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 76
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/WiFiHelpAbstractFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 78
    if-nez p2, :cond_0

    .line 79
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->editSSID:Landroid/widget/EditText;

    sget-object v1, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->e:Landroid/os/Bundle;

    const-string v2, "ARG_SSID"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 80
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->editPassword:Landroid/widget/EditText;

    sget-object v1, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->e:Landroid/os/Bundle;

    const-string v2, "ARG_PASSWORD"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 82
    :cond_0
    return-void
.end method
