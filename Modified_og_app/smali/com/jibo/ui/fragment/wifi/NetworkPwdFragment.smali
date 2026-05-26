.class public Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;
.super Lcom/jibo/ui/fragment/wifi/WiFiValidatedFragment;
.source "NetworkPwdFragment.java"

# interfaces
.implements Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment$OnStaticOptionsChangeListener;


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field final b:Landroid/text/TextWatcher;

.field btnStaticOptions:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field editPassword:Landroid/widget/EditText;
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
    .line 31
    const-class v0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;

    invoke-static {v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 30
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/WiFiValidatedFragment;-><init>()V

    .line 43
    new-instance v0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment$1;-><init>(Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->b:Landroid/text/TextWatcher;

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;)V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->q()V

    return-void
.end method

.method private q()V
    .locals 3

    .prologue
    .line 177
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->r()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->r()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0x8

    if-ge v0, v1, :cond_0

    .line 178
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->txtPasswordHint:Landroid/widget/TextView;

    const v1, 0x7f10012f

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 179
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->txtPasswordHint:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f060074

    invoke-static {v1, v2}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 189
    :goto_0
    return-void

    .line 186
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->txtPasswordHint:Landroid/widget/TextView;

    const v1, 0x7f1001d9

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 187
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->txtPasswordHint:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f0600c6

    invoke-static {v1, v2}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_0
.end method

.method private r()Ljava/lang/String;
    .locals 2

    .prologue
    .line 192
    const-string v0, ""

    .line 194
    :try_start_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->editPassword:Landroid/widget/EditText;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->editPassword:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 198
    :cond_0
    :goto_0
    return-object v0

    .line 195
    :catch_0
    move-exception v1

    goto :goto_0
.end method


# virtual methods
.method protected a()V
    .locals 3

    .prologue
    .line 146
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->e()V

    .line 148
    sget-object v0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->e:Landroid/os/Bundle;

    const-string v1, "ARG_PASSWORD"

    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->r()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 151
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->e()I

    move-result v0

    const/4 v1, 0x4

    if-le v0, v1, :cond_0

    .line 152
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-class v1, Lcom/jibo/ui/fragment/wifi/WiFiHelpFragment;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/app/FragmentManager;->a(Ljava/lang/String;I)Z

    .line 160
    :goto_0
    return-void

    .line 156
    :cond_0
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 157
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 158
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const-class v2, Lcom/jibo/ui/fragment/wifi/WaitForTapFragment;

    invoke-virtual {v0, v2, v1}, Lcom/jibo/ui/activity/BaseActivity;->c(Ljava/lang/Class;Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 115
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiValidatedFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 116
    const v0, 0x7f08005e

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setHomeAsUpIndicator(I)V

    .line 117
    return-void
.end method

.method protected a(Landroid/view/MenuItem;)V
    .locals 2

    .prologue
    .line 138
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->r()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0x8

    if-ge v0, v1, :cond_0

    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->r()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    invoke-interface {p1, v0}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 140
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    .line 141
    invoke-interface {p1}, Landroid/view/MenuItem;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_2

    const v0, 0x7f0600df

    .line 140
    :goto_1
    invoke-static {v1, p1, v0}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;Landroid/view/MenuItem;I)V

    .line 142
    return-void

    .line 138
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 141
    :cond_2
    const v0, 0x7f060035

    goto :goto_1
.end method

.method public a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 164
    sget-object v0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->e:Landroid/os/Bundle;

    const-string v1, "ARG_IPADDRESS"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 165
    sget-object v0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->e:Landroid/os/Bundle;

    const-string v1, "ARG_SUBNETMASK"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 166
    sget-object v0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->e:Landroid/os/Bundle;

    const-string v1, "ARG_ROUTER"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 167
    sget-object v0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->e:Landroid/os/Bundle;

    const-string v1, "ARG_DNS1"

    invoke-virtual {v0, v1, p4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 168
    sget-object v0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->e:Landroid/os/Bundle;

    const-string v1, "ARG_DNS2"

    invoke-virtual {v0, v1, p5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 170
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->btnStaticOptions:Landroid/widget/TextView;

    sget-object v0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->e:Landroid/os/Bundle;

    const-string v2, "ARG_IPADDRESS"

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    const v0, 0x7f100048

    :goto_0
    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(I)V

    .line 173
    return-void

    .line 170
    :cond_0
    const v0, 0x7f100047

    goto :goto_0
.end method

.method public h()Z
    .locals 2

    .prologue
    .line 103
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->e()I

    move-result v0

    const/4 v1, 0x3

    if-gt v0, v1, :cond_0

    .line 104
    sget-object v0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->e:Landroid/os/Bundle;

    const-string v1, "ARG_IPADDRESS"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->remove(Ljava/lang/String;)V

    .line 105
    sget-object v0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->e:Landroid/os/Bundle;

    const-string v1, "ARG_SUBNETMASK"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->remove(Ljava/lang/String;)V

    .line 106
    sget-object v0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->e:Landroid/os/Bundle;

    const-string v1, "ARG_ROUTER"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->remove(Ljava/lang/String;)V

    .line 107
    sget-object v0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->e:Landroid/os/Bundle;

    const-string v1, "ARG_DNS1"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->remove(Ljava/lang/String;)V

    .line 108
    sget-object v0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->e:Landroid/os/Bundle;

    const-string v1, "ARG_DNS2"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->remove(Ljava/lang/String;)V

    .line 110
    :cond_0
    invoke-super {p0}, Lcom/jibo/ui/fragment/wifi/WiFiValidatedFragment;->h()Z

    move-result v0

    return v0
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 121
    const v0, 0x7f10042b

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 0

    .prologue
    .line 30
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/WiFiValidatedFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 61
    const v0, 0x7f0b009e

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 1

    .prologue
    .line 30
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiValidatedFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    return v0
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 94
    invoke-super {p0}, Lcom/jibo/ui/fragment/wifi/WiFiValidatedFragment;->onPause()V

    .line 96
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->editPassword:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->b:Landroid/text/TextWatcher;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->removeTextChangedListener(Landroid/text/TextWatcher;)V

    .line 97
    return-void
.end method

.method public onResume()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 73
    invoke-super {p0}, Lcom/jibo/ui/fragment/wifi/WiFiValidatedFragment;->onResume()V

    .line 75
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->editPassword:Landroid/widget/EditText;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->e:Landroid/os/Bundle;

    const-string v3, "ARG_SSID"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const v2, 0x7f100169

    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    .line 76
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->btnStaticOptions:Landroid/widget/TextView;

    sget-object v0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->e:Landroid/os/Bundle;

    const-string v2, "ARG_IPADDRESS"

    invoke-virtual {v0, v2, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    const v0, 0x7f100048

    :goto_0
    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(I)V

    .line 79
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->q()V

    .line 81
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->editPassword:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->b:Landroid/text/TextWatcher;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 84
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->e()I

    move-result v0

    const/4 v1, 0x4

    if-le v0, v1, :cond_1

    .line 85
    invoke-virtual {p0, v4}, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->onStaticClick(Landroid/view/View;)V

    .line 90
    :goto_1
    return-void

    .line 76
    :cond_0
    const v0, 0x7f100047

    goto :goto_0

    .line 87
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->editPassword:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->requestFocus()Z

    .line 88
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->editPassword:Landroid/widget/EditText;

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->a(Landroid/widget/EditText;)V

    goto :goto_1
.end method

.method public onStaticClick(Landroid/view/View;)V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 127
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 128
    sget-object v1, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->e:Landroid/os/Bundle;

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    .line 129
    new-instance v1, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;

    invoke-direct {v1}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;-><init>()V

    .line 130
    invoke-virtual {v1, v0}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->setArguments(Landroid/os/Bundle;)V

    .line 131
    const/4 v0, 0x0

    invoke-virtual {v1, p0, v0}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 132
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-class v2, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;

    .line 133
    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    .line 132
    invoke-virtual {v1, v0, v2}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 134
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 66
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/WiFiValidatedFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 68
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;->n()V

    .line 69
    return-void
.end method
