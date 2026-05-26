.class public Lcom/salesforce/android/service/common/ui/views/SalesforceTextView;
.super Landroid/support/v7/widget/AppCompatTextView;
.source "SalesforceTextView.java"


# instance fields
.field private final b:Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 45
    invoke-direct {p0, p1}, Landroid/support/v7/widget/AppCompatTextView;-><init>(Landroid/content/Context;)V

    .line 46
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceTextView;->b:Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;

    .line 47
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 50
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 51
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 2

    .prologue
    .line 54
    invoke-direct {p0, p1, p2, p3}, Landroid/support/v7/widget/AppCompatTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 55
    invoke-static {p1, p2}, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->a(Landroid/content/Context;Landroid/util/AttributeSet;)Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceTextView;->b:Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;

    .line 56
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceTextView;->b:Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->b()Landroid/graphics/Typeface;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceTextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 59
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceTextView;->b:Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;

    invoke-virtual {p0}, Lcom/salesforce/android/service/common/ui/views/SalesforceTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->a(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-super {p0, v0}, Landroid/support/v7/widget/AppCompatTextView;->setText(Ljava/lang/CharSequence;)V

    .line 60
    return-void
.end method


# virtual methods
.method public setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceTextView;->b:Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;

    if-eqz v0, :cond_0

    .line 65
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceTextView;->b:Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->a(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    move-result-object p1

    .line 67
    :cond_0
    invoke-super {p0, p1, p2}, Landroid/support/v7/widget/AppCompatTextView;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    .line 68
    return-void
.end method
