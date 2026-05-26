.class public Lcom/salesforce/androidsdk/ui/SalesforceServerRadioButton;
.super Landroid/widget/RadioButton;
.source "SalesforceServerRadioButton.java"


# instance fields
.field private a:Landroid/content/Context;

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;

.field private d:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 60
    invoke-direct {p0, p1}, Landroid/widget/RadioButton;-><init>(Landroid/content/Context;)V

    .line 61
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/SalesforceServerRadioButton;->a:Landroid/content/Context;

    .line 62
    iput-object p2, p0, Lcom/salesforce/androidsdk/ui/SalesforceServerRadioButton;->b:Ljava/lang/String;

    .line 63
    iput-object p3, p0, Lcom/salesforce/androidsdk/ui/SalesforceServerRadioButton;->c:Ljava/lang/String;

    .line 64
    iput-boolean p4, p0, Lcom/salesforce/androidsdk/ui/SalesforceServerRadioButton;->d:Z

    .line 65
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/SalesforceServerRadioButton;->a()V

    .line 66
    return-void
.end method


# virtual methods
.method public a()V
    .locals 8

    .prologue
    const/16 v7, 0x21

    const/4 v6, 0x0

    .line 72
    new-instance v0, Landroid/text/SpannableStringBuilder;

    invoke-direct {v0}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 73
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/SalesforceServerRadioButton;->b:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/SalesforceServerRadioButton;->c:Ljava/lang/String;

    if-eqz v1, :cond_0

    .line 74
    new-instance v1, Landroid/text/SpannableString;

    iget-object v2, p0, Lcom/salesforce/androidsdk/ui/SalesforceServerRadioButton;->b:Ljava/lang/String;

    invoke-direct {v1, v2}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 75
    new-instance v2, Landroid/text/style/TextAppearanceSpan;

    iget-object v3, p0, Lcom/salesforce/androidsdk/ui/SalesforceServerRadioButton;->a:Landroid/content/Context;

    const v4, 0x1030044

    invoke-direct {v2, v3, v4}, Landroid/text/style/TextAppearanceSpan;-><init>(Landroid/content/Context;I)V

    iget-object v3, p0, Lcom/salesforce/androidsdk/ui/SalesforceServerRadioButton;->b:Ljava/lang/String;

    .line 76
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    .line 75
    invoke-virtual {v1, v2, v6, v3, v7}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 78
    new-instance v2, Landroid/text/SpannableString;

    iget-object v3, p0, Lcom/salesforce/androidsdk/ui/SalesforceServerRadioButton;->c:Ljava/lang/String;

    invoke-direct {v2, v3}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 79
    new-instance v3, Landroid/text/style/TextAppearanceSpan;

    iget-object v4, p0, Lcom/salesforce/androidsdk/ui/SalesforceServerRadioButton;->a:Landroid/content/Context;

    const v5, 0x1030046

    invoke-direct {v3, v4, v5}, Landroid/text/style/TextAppearanceSpan;-><init>(Landroid/content/Context;I)V

    iget-object v4, p0, Lcom/salesforce/androidsdk/ui/SalesforceServerRadioButton;->c:Ljava/lang/String;

    .line 80
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    .line 79
    invoke-virtual {v2, v3, v6, v4, v7}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 82
    invoke-virtual {v0, v1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 83
    const-string v1, "line.separator"

    invoke-static {v1}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 84
    invoke-virtual {v0, v2}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 86
    :cond_0
    sget-object v1, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    invoke-super {p0, v0, v1}, Landroid/widget/RadioButton;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    .line 87
    return-void
.end method

.method public b()Z
    .locals 1

    .prologue
    .line 113
    iget-boolean v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceServerRadioButton;->d:Z

    return v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceServerRadioButton;->b:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/SalesforceServerRadioButton;->c:Ljava/lang/String;

    return-object v0
.end method
