.class public Lcom/salesforce/androidsdk/ui/PasscodeActivity;
.super Landroid/app/Activity;
.source "PasscodeActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Landroid/widget/TextView$OnEditorActionListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;
    }
.end annotation


# instance fields
.field private final a:I

.field private b:Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

.field private c:Landroid/widget/TextView;

.field private d:Landroid/widget/TextView;

.field private e:Landroid/widget/TextView;

.field private f:Landroid/widget/EditText;

.field private g:Lcom/salesforce/androidsdk/security/PasscodeManager;

.field private h:Ljava/lang/String;

.field private i:Lcom/salesforce/androidsdk/ui/SalesforceR;

.field private j:Z

.field private k:Landroid/app/AlertDialog;

.field private l:Z

.field private m:Landroid/hardware/fingerprint/FingerprintManager;

.field private n:Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 62
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 68
    const/16 v0, 0xb

    iput v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->a:I

    return-void
.end method

.method private A()Z
    .locals 4
    .annotation build Landroid/annotation/TargetApi;
        value = 0x17
    .end annotation

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 455
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x17

    if-lt v0, v3, :cond_0

    .line 456
    const-string v0, "fingerprint"

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/hardware/fingerprint/FingerprintManager;

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->m:Landroid/hardware/fingerprint/FingerprintManager;

    .line 458
    const-string v0, "android.permission.USE_FINGERPRINT"

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->checkSelfPermission(Ljava/lang/String;)I

    move-result v0

    if-eqz v0, :cond_1

    .line 459
    new-array v0, v1, [Ljava/lang/String;

    const-string v1, "android.permission.USE_FINGERPRINT"

    aput-object v1, v0, v2

    const/16 v1, 0xb

    invoke-virtual {p0, v0, v1}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->requestPermissions([Ljava/lang/String;I)V

    :cond_0
    move v0, v2

    .line 464
    :goto_0
    return v0

    .line 461
    :cond_1
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->m:Landroid/hardware/fingerprint/FingerprintManager;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->m:Landroid/hardware/fingerprint/FingerprintManager;

    invoke-virtual {v0}, Landroid/hardware/fingerprint/FingerprintManager;->isHardwareDetected()Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->m:Landroid/hardware/fingerprint/FingerprintManager;

    invoke-virtual {v0}, Landroid/hardware/fingerprint/FingerprintManager;->hasEnrolledFingerprints()Z

    move-result v0

    if-eqz v0, :cond_2

    move v0, v1

    goto :goto_0

    :cond_2
    move v0, v2

    goto :goto_0
.end method

.method static synthetic a(Lcom/salesforce/androidsdk/ui/PasscodeActivity;Z)Z
    .locals 0

    .prologue
    .line 62
    iput-boolean p1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->l:Z

    return p1
.end method

.method private y()Landroid/app/AlertDialog;
    .locals 3

    .prologue
    .line 401
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 402
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->n()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 403
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->o()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/salesforce/androidsdk/ui/PasscodeActivity$2;

    invoke-direct {v2, p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity$2;-><init>(Lcom/salesforce/androidsdk/ui/PasscodeActivity;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 433
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->p()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/salesforce/androidsdk/ui/PasscodeActivity$1;

    invoke-direct {v2, p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity$1;-><init>(Lcom/salesforce/androidsdk/ui/PasscodeActivity;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 442
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 401
    return-object v0
.end method

.method private z()V
    .locals 3

    .prologue
    .line 446
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->g:Lcom/salesforce/androidsdk/security/PasscodeManager;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->g:Lcom/salesforce/androidsdk/security/PasscodeManager;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->d()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-direct {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->A()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 447
    new-instance v0, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;

    invoke-direct {v0}, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;-><init>()V

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->n:Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;

    .line 448
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->n:Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;

    invoke-virtual {v0, p0}, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->a(Lcom/salesforce/androidsdk/ui/PasscodeActivity;)V

    .line 449
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->n:Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    const-string v2, "fingerprintDialog"

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/androidsdk/ui/FingerprintAuthDialogFragment;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 451
    :cond_0
    return-void
.end method


# virtual methods
.method public a()Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;
    .locals 1

    .prologue
    .line 164
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->b:Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

    return-object v0
.end method

.method protected a(I)Ljava/lang/String;
    .locals 4

    .prologue
    .line 345
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->i:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->z()I

    move-result v0

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-virtual {p0, v0, v1}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;)V
    .locals 3

    .prologue
    const/4 v2, 0x4

    .line 168
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->b:Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

    if-ne p1, v0, :cond_0

    .line 195
    :goto_0
    return-void

    .line 169
    :cond_0
    sget-object v0, Lcom/salesforce/androidsdk/ui/PasscodeActivity$3;->a:[I

    invoke-virtual {p1}, Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 191
    :goto_1
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->f:Landroid/widget/EditText;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 192
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->e:Landroid/widget/TextView;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 193
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->b:Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

    .line 194
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->f:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->requestFocus()Z

    goto :goto_0

    .line 171
    :pswitch_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->c:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->j()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 172
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->d:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->l()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 173
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->e()Landroid/widget/TextView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1

    .line 176
    :pswitch_1
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->c:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->i()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 177
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->d:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->q()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 178
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->e()Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1

    .line 181
    :pswitch_2
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->c:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->k()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 182
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->d:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->s()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 183
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->e()Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1

    .line 186
    :pswitch_3
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->c:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->i()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 187
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->d:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->r()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 188
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->e()Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1

    .line 169
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method protected a(Ljava/lang/String;)Z
    .locals 4

    .prologue
    const/4 v0, 0x1

    .line 223
    sget-object v1, Lcom/salesforce/androidsdk/ui/PasscodeActivity$3;->a:[I

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->a()Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

    move-result-object v2

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 268
    const/4 v0, 0x0

    :cond_0
    :goto_0
    return v0

    .line 225
    :pswitch_0
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->h:Ljava/lang/String;

    .line 226
    sget-object v1, Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;->CreateConfirm:Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

    invoke-virtual {p0, v1}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->a(Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;)V

    goto :goto_0

    .line 230
    :pswitch_1
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->h:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 231
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->g:Lcom/salesforce/androidsdk/security/PasscodeManager;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/security/PasscodeManager;->d()Ljava/lang/String;

    move-result-object v1

    .line 232
    iget-object v2, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->g:Lcom/salesforce/androidsdk/security/PasscodeManager;

    invoke-virtual {v2, p0, p1}, Lcom/salesforce/androidsdk/security/PasscodeManager;->b(Landroid/content/Context;Ljava/lang/String;)V

    .line 233
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v2

    iget-object v3, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->g:Lcom/salesforce/androidsdk/security/PasscodeManager;

    .line 234
    invoke-virtual {v3, p1}, Lcom/salesforce/androidsdk/security/PasscodeManager;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 233
    invoke-virtual {v2, v1, v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->b(Ljava/lang/String;Ljava/lang/String;)V

    .line 235
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->g:Lcom/salesforce/androidsdk/security/PasscodeManager;

    invoke-virtual {v1, p1}, Lcom/salesforce/androidsdk/security/PasscodeManager;->a(Ljava/lang/String;)V

    .line 236
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->b()V

    goto :goto_0

    .line 238
    :cond_1
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->e:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->u()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 243
    :pswitch_2
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->g:Lcom/salesforce/androidsdk/security/PasscodeManager;

    invoke-virtual {v1, p0, p1}, Lcom/salesforce/androidsdk/security/PasscodeManager;->a(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 244
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->g:Lcom/salesforce/androidsdk/security/PasscodeManager;

    invoke-virtual {v1, p1}, Lcom/salesforce/androidsdk/security/PasscodeManager;->a(Ljava/lang/String;)V

    .line 245
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->b()V

    goto :goto_0

    .line 247
    :cond_2
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->g:Lcom/salesforce/androidsdk/security/PasscodeManager;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/security/PasscodeManager;->b()I

    move-result v1

    .line 248
    iget-object v2, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->f:Landroid/widget/EditText;

    const-string v3, ""

    invoke-virtual {v2, v3}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 249
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->w()I

    move-result v2

    .line 250
    add-int/lit8 v3, v2, -0x1

    if-ge v1, v3, :cond_3

    .line 251
    iget-object v3, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->e:Landroid/widget/TextView;

    sub-int v1, v2, v1

    invoke-virtual {p0, v1}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->b(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 252
    :cond_3
    if-ge v1, v2, :cond_4

    .line 253
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->e:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->t()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 255
    :cond_4
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->g:Lcom/salesforce/androidsdk/security/PasscodeManager;

    invoke-virtual {v1, p0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->a(Landroid/content/Context;)V

    .line 256
    iget-boolean v1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->j:Z

    if-eqz v1, :cond_0

    .line 257
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1, p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a(Landroid/app/Activity;)V

    goto/16 :goto_0

    .line 264
    :pswitch_3
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->h:Ljava/lang/String;

    .line 265
    sget-object v1, Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;->CreateConfirm:Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

    invoke-virtual {p0, v1}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->a(Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;)V

    goto/16 :goto_0

    .line 223
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_0
        :pswitch_1
        :pswitch_3
    .end packed-switch
.end method

.method protected b(I)Ljava/lang/String;
    .locals 4

    .prologue
    .line 349
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->i:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->A()I

    move-result v0

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-virtual {p0, v0, v1}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected b()V
    .locals 1

    .prologue
    .line 272
    const/4 v0, -0x1

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->setResult(I)V

    .line 273
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->finish()V

    .line 274
    return-void
.end method

.method protected c()I
    .locals 1

    .prologue
    .line 277
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->i:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->m()I

    move-result v0

    return v0
.end method

.method protected d()Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 281
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->i:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->n()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    return-object v0
.end method

.method protected e()Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 285
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->i:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->r()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    return-object v0
.end method

.method protected f()Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 289
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->i:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->o()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    return-object v0
.end method

.method protected g()Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 293
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->i:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->p()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    return-object v0
.end method

.method protected h()Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 297
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->i:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->q()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    return-object v0
.end method

.method protected i()Ljava/lang/String;
    .locals 4

    .prologue
    .line 301
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->i:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->s()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->s()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected j()Ljava/lang/String;
    .locals 4

    .prologue
    .line 305
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->i:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->t()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->s()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected k()Ljava/lang/String;
    .locals 4

    .prologue
    .line 309
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->i:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->u()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->s()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected l()Ljava/lang/String;
    .locals 4

    .prologue
    .line 313
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->i:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->v()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->s()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected m()Ljava/lang/String;
    .locals 1

    .prologue
    .line 317
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->i:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->D()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected n()Ljava/lang/String;
    .locals 1

    .prologue
    .line 321
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->i:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->E()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 325
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->i:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->F()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 376
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->e()Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 377
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->k:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 378
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->l:Z

    .line 380
    :cond_0
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    const/16 v2, 0x2000

    const/4 v0, 0x0

    const-string v1, "com.salesforce.androidsdk.ui.PasscodeActivity"

    invoke-static {v1}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnCreateTime(Ljava/lang/String;)V

    .line 91
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 94
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e()Lcom/salesforce/androidsdk/ui/SalesforceR;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->i:Lcom/salesforce/androidsdk/ui/SalesforceR;

    .line 97
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1, v2, v2}, Landroid/view/Window;->setFlags(II)V

    .line 100
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->c()I

    move-result v1

    invoke-virtual {p0, v1}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->setContentView(I)V

    .line 101
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->e()Landroid/widget/TextView;

    move-result-object v1

    .line 102
    if-eqz v1, :cond_0

    .line 103
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->m()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 105
    :cond_0
    invoke-virtual {v1, p0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 107
    invoke-direct {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->y()Landroid/app/AlertDialog;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->k:Landroid/app/AlertDialog;

    .line 108
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->d()Landroid/widget/TextView;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->c:Landroid/widget/TextView;

    .line 109
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->f()Landroid/widget/TextView;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->e:Landroid/widget/TextView;

    .line 110
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->g()Landroid/widget/TextView;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->d:Landroid/widget/TextView;

    .line 111
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->h()Landroid/widget/EditText;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->f:Landroid/widget/EditText;

    .line 112
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->f:Landroid/widget/EditText;

    invoke-virtual {v1, p0}, Landroid/widget/EditText;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V

    .line 113
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->n()Lcom/salesforce/androidsdk/security/PasscodeManager;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->g:Lcom/salesforce/androidsdk/security/PasscodeManager;

    .line 114
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    .line 116
    if-eqz v1, :cond_1

    .line 117
    const-string v2, "change_passcode"

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v0

    .line 120
    :cond_1
    if-eqz v0, :cond_4

    .line 121
    sget-object v0, Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;->Change:Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->a(Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;)V

    .line 126
    :goto_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->j:Z

    .line 127
    if-eqz p1, :cond_3

    .line 128
    const-string v0, "input_text"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 129
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->f:Landroid/widget/EditText;

    if-eqz v1, :cond_2

    if-eqz v0, :cond_2

    .line 130
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->f:Landroid/widget/EditText;

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 132
    :cond_2
    const-string v0, "logout_key"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->l:Z

    .line 133
    iget-boolean v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->l:Z

    if-eqz v0, :cond_3

    .line 134
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->k:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 137
    :cond_3
    return-void

    .line 123
    :cond_4
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->g:Lcom/salesforce/androidsdk/security/PasscodeManager;

    invoke-virtual {v0, p0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->b(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_5

    sget-object v0, Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;->Check:Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

    :goto_1
    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->a(Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;)V

    .line 124
    invoke-direct {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->z()V

    goto :goto_0

    .line 123
    :cond_5
    sget-object v0, Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;->Create:Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

    goto :goto_1
.end method

.method public onEditorAction(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z
    .locals 4

    .prologue
    const/4 v0, 0x1

    .line 209
    const/4 v1, 0x2

    if-eq p2, v1, :cond_0

    if-eqz p3, :cond_1

    .line 210
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getAction()I

    move-result v1

    if-ne v1, v0, :cond_1

    .line 211
    :cond_0
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->f:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 212
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-ltz v2, :cond_2

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->v()I

    move-result v3

    if-ge v2, v3, :cond_2

    .line 213
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->e:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->v()I

    move-result v2

    invoke-virtual {p0, v2}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->a(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 218
    :cond_1
    :goto_0
    return v0

    .line 216
    :cond_2
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_3

    invoke-virtual {p0, v1}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->a(Ljava/lang/String;)Z

    move-result v0

    goto :goto_0

    :cond_3
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 141
    const/4 v1, 0x4

    if-ne p1, v1, :cond_0

    .line 142
    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->moveTaskToBack(Z)Z

    .line 145
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1, p2}, Landroid/app/Activity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public onRequestPermissionsResult(I[Ljava/lang/String;[I)V
    .locals 1

    .prologue
    .line 469
    const/16 v0, 0xb

    if-ne p1, v0, :cond_0

    const/4 v0, 0x0

    aget v0, p3, v0

    if-nez v0, :cond_0

    .line 470
    invoke-direct {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->z()V

    .line 474
    :goto_0
    return-void

    .line 473
    :cond_0
    invoke-super {p0, p1, p2, p3}, Landroid/app/Activity;->onRequestPermissionsResult(I[Ljava/lang/String;[I)V

    goto :goto_0
.end method

.method protected onResume()V
    .locals 1

    const-string v0, "com.salesforce.androidsdk.ui.PasscodeActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnResumeTime(Ljava/lang/String;)V

    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    return-void
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 153
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->f:Landroid/widget/EditText;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->f:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 154
    const-string v0, "input_text"

    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->f:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 156
    :cond_0
    iget-boolean v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->l:Z

    if-eqz v0, :cond_1

    .line 157
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->k:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->dismiss()V

    .line 158
    const-string v0, "logout_key"

    const/4 v1, 0x1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 159
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->l:Z

    .line 161
    :cond_1
    return-void
.end method

.method protected onStart()V
    .locals 1

    const-string v0, "com.salesforce.androidsdk.ui.PasscodeActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnStartTime(Ljava/lang/String;)V

    invoke-super {p0}, Landroid/app/Activity;->onStart()V

    return-void
.end method

.method protected p()Ljava/lang/String;
    .locals 1

    .prologue
    .line 329
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->i:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->G()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected q()Ljava/lang/String;
    .locals 4

    .prologue
    .line 333
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->i:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->w()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->s()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected r()Ljava/lang/String;
    .locals 1

    .prologue
    .line 337
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->i:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->x()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected s()Ljava/lang/String;
    .locals 4

    .prologue
    .line 341
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->i:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->y()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->s()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected t()Ljava/lang/String;
    .locals 1

    .prologue
    .line 353
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->i:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->B()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected u()Ljava/lang/String;
    .locals 1

    .prologue
    .line 357
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->i:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->C()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected v()I
    .locals 1

    .prologue
    .line 364
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->g:Lcom/salesforce/androidsdk/security/PasscodeManager;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->h()I

    move-result v0

    return v0
.end method

.method protected w()I
    .locals 1

    .prologue
    .line 371
    const/16 v0, 0xa

    return v0
.end method

.method public x()V
    .locals 1

    .prologue
    .line 477
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->g:Lcom/salesforce/androidsdk/security/PasscodeManager;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->j()V

    .line 478
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->b()V

    .line 479
    return-void
.end method
