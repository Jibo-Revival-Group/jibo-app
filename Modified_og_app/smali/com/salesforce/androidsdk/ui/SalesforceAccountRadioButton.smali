.class public Lcom/salesforce/androidsdk/ui/SalesforceAccountRadioButton;
.super Landroid/widget/RadioButton;
.source "SalesforceAccountRadioButton.java"


# instance fields
.field private a:Landroid/content/Context;

.field private b:Lcom/salesforce/androidsdk/accounts/UserAccount;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 0

    .prologue
    .line 57
    invoke-direct {p0, p1}, Landroid/widget/RadioButton;-><init>(Landroid/content/Context;)V

    .line 58
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/SalesforceAccountRadioButton;->a:Landroid/content/Context;

    .line 59
    iput-object p2, p0, Lcom/salesforce/androidsdk/ui/SalesforceAccountRadioButton;->b:Lcom/salesforce/androidsdk/accounts/UserAccount;

    .line 60
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/SalesforceAccountRadioButton;->a()V

    .line 61
    return-void
.end method


# virtual methods
.method public a()V
    .locals 9

    .prologue
    const/16 v8, 0x21

    const/4 v7, 0x0

    .line 67
    new-instance v0, Landroid/text/SpannableStringBuilder;

    invoke-direct {v0}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 68
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/SalesforceAccountRadioButton;->b:Lcom/salesforce/androidsdk/accounts/UserAccount;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/SalesforceAccountRadioButton;->b:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->h()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/SalesforceAccountRadioButton;->b:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->c()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 69
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/SalesforceAccountRadioButton;->b:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->h()Ljava/lang/String;

    move-result-object v1

    .line 70
    iget-object v2, p0, Lcom/salesforce/androidsdk/ui/SalesforceAccountRadioButton;->b:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/accounts/UserAccount;->c()Ljava/lang/String;

    move-result-object v2

    .line 71
    new-instance v3, Landroid/text/SpannableString;

    invoke-direct {v3, v1}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 72
    new-instance v4, Landroid/text/style/TextAppearanceSpan;

    iget-object v5, p0, Lcom/salesforce/androidsdk/ui/SalesforceAccountRadioButton;->a:Landroid/content/Context;

    const v6, 0x1030044

    invoke-direct {v4, v5, v6}, Landroid/text/style/TextAppearanceSpan;-><init>(Landroid/content/Context;I)V

    .line 73
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    .line 72
    invoke-virtual {v3, v4, v7, v1, v8}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 75
    new-instance v1, Landroid/text/SpannableString;

    invoke-direct {v1, v2}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 76
    new-instance v4, Landroid/text/style/TextAppearanceSpan;

    iget-object v5, p0, Lcom/salesforce/androidsdk/ui/SalesforceAccountRadioButton;->a:Landroid/content/Context;

    const v6, 0x1030046

    invoke-direct {v4, v5, v6}, Landroid/text/style/TextAppearanceSpan;-><init>(Landroid/content/Context;I)V

    .line 77
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    .line 76
    invoke-virtual {v1, v4, v7, v2, v8}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 79
    invoke-virtual {v0, v3}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 80
    const-string v2, "line.separator"

    invoke-static {v2}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 81
    invoke-virtual {v0, v1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 83
    :cond_0
    sget-object v1, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    invoke-super {p0, v0, v1}, Landroid/widget/RadioButton;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    .line 84
    return-void
.end method

.method public getAccount()Lcom/salesforce/androidsdk/accounts/UserAccount;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceAccountRadioButton;->b:Lcom/salesforce/androidsdk/accounts/UserAccount;

    return-object v0
.end method
