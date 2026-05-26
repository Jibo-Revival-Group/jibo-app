.class public Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;
.super Landroid/app/DialogFragment;
.source "FingerprintAuthDialogFragment.java"


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0x17
.end annotation


# instance fields
.field private a:Landroid/widget/Button;

.field private b:Landroid/widget/TextView;

.field private c:Lcom/salesforce/androidsdk/ui/SalesforceR;

.field private d:Ljavax/crypto/Cipher;

.field private e:Lcom/salesforce/androidsdk/ui/PasscodeActivity;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 59
    invoke-direct {p0}, Landroid/app/DialogFragment;-><init>()V

    return-void
.end method

.method static synthetic a(Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->b:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic b(Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;)Lcom/salesforce/androidsdk/ui/SalesforceR;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->c:Lcom/salesforce/androidsdk/ui/SalesforceR;

    return-object v0
.end method

.method static synthetic c(Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;)Lcom/salesforce/androidsdk/ui/PasscodeActivity;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->e:Lcom/salesforce/androidsdk/ui/PasscodeActivity;

    return-object v0
.end method


# virtual methods
.method public a(Lcom/salesforce/androidsdk/ui/PasscodeActivity;)V
    .locals 0

    .prologue
    .line 149
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->e:Lcom/salesforce/androidsdk/ui/PasscodeActivity;

    .line 150
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 69
    invoke-super {p0, p1}, Landroid/app/DialogFragment;->onCreate(Landroid/os/Bundle;)V

    .line 71
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->setRetainInstance(Z)V

    .line 72
    const/4 v0, 0x0

    const v1, 0x1030239

    invoke-virtual {p0, v0, v1}, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->setStyle(II)V

    .line 73
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e()Lcom/salesforce/androidsdk/ui/SalesforceR;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->c:Lcom/salesforce/androidsdk/ui/SalesforceR;

    .line 74
    return-void
.end method

.method public onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 3

    .prologue
    .line 127
    invoke-super {p0, p1}, Landroid/app/DialogFragment;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;

    move-result-object v0

    .line 129
    invoke-virtual {v0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/view/Window;->requestFeature(I)Z

    .line 130
    return-object v0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3

    .prologue
    .line 136
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->c:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->H()I

    move-result v0

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 137
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->c:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->I()I

    move-result v0

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->a:Landroid/widget/Button;

    .line 138
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->a:Landroid/widget/Button;

    new-instance v2, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment$2;

    invoke-direct {v2, p0}, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment$2;-><init>(Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;)V

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 144
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->c:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->J()I

    move-result v0

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->b:Landroid/widget/TextView;

    .line 145
    return-object v1
.end method

.method public onResume()V
    .locals 6

    .prologue
    const/4 v2, 0x0

    .line 78
    invoke-super {p0}, Landroid/app/DialogFragment;->onResume()V

    .line 79
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x17

    if-lt v0, v1, :cond_0

    .line 80
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->e:Lcom/salesforce/androidsdk/ui/PasscodeActivity;

    const-string v1, "fingerprint"

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/hardware/fingerprint/FingerprintManager;

    .line 81
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->e:Lcom/salesforce/androidsdk/ui/PasscodeActivity;

    const-string v3, "android.permission.USE_FINGERPRINT"

    invoke-virtual {v1, v3}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->checkSelfPermission(Ljava/lang/String;)I

    move-result v1

    if-eqz v1, :cond_1

    .line 123
    :cond_0
    :goto_0
    return-void

    .line 85
    :cond_1
    new-instance v1, Landroid/hardware/fingerprint/FingerprintManager$CryptoObject;

    iget-object v3, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->d:Ljavax/crypto/Cipher;

    invoke-direct {v1, v3}, Landroid/hardware/fingerprint/FingerprintManager$CryptoObject;-><init>(Ljavax/crypto/Cipher;)V

    const/4 v3, 0x0

    new-instance v4, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment$1;

    invoke-direct {v4, p0}, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment$1;-><init>(Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;)V

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/hardware/fingerprint/FingerprintManager;->authenticate(Landroid/hardware/fingerprint/FingerprintManager$CryptoObject;Landroid/os/CancellationSignal;ILandroid/hardware/fingerprint/FingerprintManager$AuthenticationCallback;Landroid/os/Handler;)V

    goto :goto_0
.end method
