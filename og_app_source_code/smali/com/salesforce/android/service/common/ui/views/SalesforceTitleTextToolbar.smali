.class public Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;
.super Landroid/support/v7/widget/Toolbar;
.source "SalesforceTitleTextToolbar.java"


# instance fields
.field private a:Lcom/salesforce/android/service/common/ui/views/SalesforceTextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 50
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 51
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 54
    sget v0, Lcom/salesforce/android/service/common/ui/R$attr;->toolbarStyle:I

    invoke-direct {p0, p1, p2, v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 55
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0

    .prologue
    .line 59
    invoke-direct {p0, p1, p2, p3}, Landroid/support/v7/widget/Toolbar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 60
    invoke-direct {p0, p1, p2, p3}, Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;->a(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 61
    return-void
.end method

.method private a(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 3

    .prologue
    .line 82
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    sget v1, Lcom/salesforce/android/service/common/ui/R$layout;->salesforce_toolbar_title_text_view:I

    const/4 v2, 0x1

    .line 83
    invoke-virtual {v0, v1, p0, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    .line 84
    sget v0, Lcom/salesforce/android/service/common/ui/R$id;->salesforce_toolbar_title:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/ui/views/SalesforceTextView;

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceTextView;

    .line 85
    invoke-virtual {p1}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v0

    sget-object v1, Lcom/salesforce/android/service/common/ui/R$styleable;->SalesforceTitleTextToolbar:[I

    const/4 v2, 0x0

    invoke-virtual {v0, p2, v1, p3, v2}, Landroid/content/res/Resources$Theme;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 86
    sget v1, Lcom/salesforce/android/service/common/ui/R$styleable;->SalesforceTitleTextToolbar_salesforce_title_text:I

    invoke-virtual {v0, v1}, Landroid/content/res/TypedArray;->getText(I)Ljava/lang/CharSequence;

    move-result-object v1

    .line 87
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 88
    invoke-virtual {p0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;->setTitleText(Ljava/lang/CharSequence;)V

    .line 90
    :cond_0
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 91
    return-void
.end method


# virtual methods
.method public setTitleText(I)V
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceTextView;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/ui/views/SalesforceTextView;->setText(I)V

    .line 79
    return-void
.end method

.method public setTitleText(Ljava/lang/CharSequence;)V
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceTextView;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/ui/views/SalesforceTextView;->setText(Ljava/lang/CharSequence;)V

    .line 70
    return-void
.end method
