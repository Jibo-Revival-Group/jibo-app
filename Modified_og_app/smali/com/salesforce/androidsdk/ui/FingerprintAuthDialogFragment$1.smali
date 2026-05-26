.class Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment$1;
.super Landroid/hardware/fingerprint/FingerprintManager$AuthenticationCallback;
.source "FingerprintAuthDialogFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->onResume()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;


# direct methods
.method constructor <init>(Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;)V
    .locals 0

    .prologue
    .line 85
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment$1;->a:Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;

    invoke-direct {p0}, Landroid/hardware/fingerprint/FingerprintManager$AuthenticationCallback;-><init>()V

    return-void
.end method


# virtual methods
.method public onAuthenticationError(ILjava/lang/CharSequence;)V
    .locals 0

    .prologue
    .line 88
    invoke-super {p0, p1, p2}, Landroid/hardware/fingerprint/FingerprintManager$AuthenticationCallback;->onAuthenticationError(ILjava/lang/CharSequence;)V

    .line 89
    return-void
.end method

.method public onAuthenticationFailed()V
    .locals 2

    .prologue
    .line 106
    invoke-super {p0}, Landroid/hardware/fingerprint/FingerprintManager$AuthenticationCallback;->onAuthenticationFailed()V

    .line 107
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment$1;->a:Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;

    invoke-static {v0}, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->a(Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;)Landroid/widget/TextView;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 108
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment$1;->a:Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;

    invoke-static {v0}, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->a(Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;)Landroid/widget/TextView;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment$1;->a:Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;

    invoke-static {v1}, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->b(Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;)Lcom/salesforce/androidsdk/ui/SalesforceR;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/ui/SalesforceR;->L()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 109
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment$1;->a:Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;

    invoke-static {v0}, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->a(Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;)Landroid/widget/TextView;

    move-result-object v0

    const/high16 v1, -0x10000

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 111
    :cond_0
    return-void
.end method

.method public onAuthenticationHelp(ILjava/lang/CharSequence;)V
    .locals 2

    .prologue
    .line 115
    invoke-super {p0, p1, p2}, Landroid/hardware/fingerprint/FingerprintManager$AuthenticationCallback;->onAuthenticationHelp(ILjava/lang/CharSequence;)V

    .line 116
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment$1;->a:Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;

    invoke-static {v0}, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->a(Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;)Landroid/widget/TextView;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 117
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment$1;->a:Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;

    invoke-static {v0}, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->a(Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;)Landroid/widget/TextView;

    move-result-object v0

    invoke-interface {p2}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 118
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment$1;->a:Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;

    invoke-static {v0}, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->a(Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;)Landroid/widget/TextView;

    move-result-object v0

    const/high16 v1, -0x10000

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 120
    :cond_0
    return-void
.end method

.method public onAuthenticationSucceeded(Landroid/hardware/fingerprint/FingerprintManager$AuthenticationResult;)V
    .locals 2

    .prologue
    .line 93
    invoke-super {p0, p1}, Landroid/hardware/fingerprint/FingerprintManager$AuthenticationCallback;->onAuthenticationSucceeded(Landroid/hardware/fingerprint/FingerprintManager$AuthenticationResult;)V

    .line 94
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment$1;->a:Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;

    invoke-static {v0}, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->a(Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;)Landroid/widget/TextView;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 95
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment$1;->a:Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;

    invoke-static {v0}, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->a(Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;)Landroid/widget/TextView;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment$1;->a:Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;

    invoke-static {v1}, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->b(Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;)Lcom/salesforce/androidsdk/ui/SalesforceR;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/ui/SalesforceR;->K()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 96
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment$1;->a:Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;

    invoke-static {v0}, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->a(Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;)Landroid/widget/TextView;

    move-result-object v0

    const v1, -0xff0100

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 98
    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment$1;->a:Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 99
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment$1;->a:Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->dismiss()V

    .line 101
    :cond_1
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment$1;->a:Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;

    invoke-static {v0}, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->c(Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;)Lcom/salesforce/androidsdk/ui/PasscodeActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->x()V

    .line 102
    return-void
.end method
