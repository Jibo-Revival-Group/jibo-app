.class public Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;
.super Lcom/jibo/ui/fragment/wifi/WiFiValidatedFragment;
.source "NetworkNameFragment.java"


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field final b:Landroid/text/TextWatcher;

.field editSSID:Landroid/widget/EditText;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field footer:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 37
    const-class v0, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;

    invoke-static {v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/WiFiValidatedFragment;-><init>()V

    .line 48
    new-instance v0, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment$1;-><init>(Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->b:Landroid/text/TextWatcher;

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;)V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->r()V

    return-void
.end method

.method private q()Ljava/lang/String;
    .locals 2

    .prologue
    .line 122
    const-string v0, ""

    .line 124
    :try_start_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->editSSID:Landroid/widget/EditText;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->editSSID:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 128
    :cond_0
    :goto_0
    return-object v0

    .line 125
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private r()V
    .locals 6

    .prologue
    .line 132
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 133
    const v1, 0x7f1001d3

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 134
    const v2, 0x7f1001d4

    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 135
    const-string v2, " "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 136
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 137
    const-string v2, " "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 138
    const v2, 0x7f1001d6

    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 140
    new-instance v2, Landroid/text/SpannableStringBuilder;

    invoke-direct {v2, v0}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 142
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->q()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    const/16 v4, 0x20

    if-lt v3, v4, :cond_0

    .line 143
    new-instance v3, Landroid/text/style/ForegroundColorSpan;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f060074

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    invoke-direct {v3, v4}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->indexOf(Ljava/lang/String;)I

    move-result v4

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->indexOf(Ljava/lang/String;)I

    move-result v0

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    add-int/2addr v0, v1

    const/16 v1, 0x12

    invoke-virtual {v2, v3, v4, v0, v1}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 146
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->footer:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 147
    return-void
.end method


# virtual methods
.method protected a()V
    .locals 3

    .prologue
    .line 111
    sget-object v0, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->e:Landroid/os/Bundle;

    const-string v1, "ARG_SSID"

    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->q()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/jibo/utils/Util;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 114
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 115
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 116
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const-class v2, Lcom/jibo/ui/fragment/wifi/NetworkPwdFragment;

    invoke-virtual {v0, v2, v1}, Lcom/jibo/ui/activity/BaseActivity;->c(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 117
    return-void
.end method

.method protected a(Landroid/view/MenuItem;)V
    .locals 2

    .prologue
    .line 94
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->q()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 95
    const/4 v0, 0x1

    invoke-interface {p1, v0}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 99
    :goto_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    .line 100
    invoke-interface {p1}, Landroid/view/MenuItem;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_1

    const v0, 0x7f0600df

    .line 99
    :goto_1
    invoke-static {v1, p1, v0}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;Landroid/view/MenuItem;I)V

    .line 101
    return-void

    .line 97
    :cond_0
    const/4 v0, 0x0

    invoke-interface {p1, v0}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    goto :goto_0

    .line 100
    :cond_1
    const v0, 0x7f060035

    goto :goto_1
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 105
    const v0, 0x7f100413

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 0

    .prologue
    .line 36
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/WiFiValidatedFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 66
    const v0, 0x7f0b009d

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 1

    .prologue
    .line 36
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiValidatedFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    return v0
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 87
    invoke-super {p0}, Lcom/jibo/ui/fragment/wifi/WiFiValidatedFragment;->onPause()V

    .line 89
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->editSSID:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->b:Landroid/text/TextWatcher;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->removeTextChangedListener(Landroid/text/TextWatcher;)V

    .line 90
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 78
    invoke-super {p0}, Lcom/jibo/ui/fragment/wifi/WiFiValidatedFragment;->onResume()V

    .line 80
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->editSSID:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->b:Landroid/text/TextWatcher;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 81
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->editSSID:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->requestFocus()Z

    .line 82
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->editSSID:Landroid/widget/EditText;

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->a(Landroid/widget/EditText;)V

    .line 83
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 71
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/WiFiValidatedFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 73
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/NetworkNameFragment;->r()V

    .line 74
    return-void
.end method
