.class public Lcom/salesforce/android/service/common/ui/views/SalesforceEditText;
.super Landroid/support/design/widget/TextInputEditText;
.source "SalesforceEditText.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0, p1}, Landroid/support/design/widget/TextInputEditText;-><init>(Landroid/content/Context;)V

    .line 46
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 49
    sget v0, Lcom/salesforce/android/service/common/ui/R$attr;->editTextStyle:I

    invoke-direct {p0, p1, p2, v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceEditText;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 50
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 2

    .prologue
    .line 53
    invoke-direct {p0, p1, p2, p3}, Landroid/support/design/widget/TextInputEditText;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 54
    invoke-static {p1, p2}, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->a(Landroid/content/Context;Landroid/util/AttributeSet;)Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;

    move-result-object v0

    .line 55
    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->b()Landroid/graphics/Typeface;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceEditText;->setTypeface(Landroid/graphics/Typeface;)V

    .line 58
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/ui/views/SalesforceEditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->a(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceEditText;->setText(Ljava/lang/CharSequence;)V

    .line 61
    new-instance v1, Lcom/salesforce/android/service/common/ui/views/SalesforceEditText$1;

    invoke-direct {v1, p0, v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceEditText$1;-><init>(Lcom/salesforce/android/service/common/ui/views/SalesforceEditText;Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;)V

    invoke-virtual {p0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceEditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 75
    return-void
.end method
