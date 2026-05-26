.class public Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;
.super Ljava/lang/Object;
.source "ViewUtils.java"


# direct methods
.method public static a(Landroid/app/Activity;)V
    .locals 4
    .annotation build Landroid/annotation/TargetApi;
        value = 0x15
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 161
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-lt v0, v1, :cond_0

    .line 162
    invoke-virtual {p0}, Landroid/app/Activity;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [I

    sget v2, Lcom/salesforce/android/cases/R$attr;->salesforceToolbarBackgroundColor:I

    aput v2, v1, v3

    .line 163
    invoke-virtual {v0, v1}, Landroid/content/res/Resources$Theme;->obtainStyledAttributes([I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 164
    sget v1, Lcom/salesforce/android/cases/R$color;->salesforce_brand_primary:I

    .line 165
    invoke-static {p0, v1}, Landroid/support/v4/content/ContextCompat;->c(Landroid/content/Context;I)I

    move-result v1

    invoke-virtual {v0, v3, v1}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v1

    .line 166
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 169
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const v2, 0x3e4ccccd    # 0.2f

    invoke-static {v1, v2}, Lcom/salesforce/android/cases/ui/internal/utils/ColorUtils;->a(IF)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/view/Window;->setStatusBarColor(I)V

    .line 171
    :cond_0
    return-void
.end method

.method public static a(Landroid/support/design/widget/Snackbar;I)V
    .locals 1

    .prologue
    .line 118
    const/4 v0, 0x0

    invoke-static {p0, v0, p1}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->a(Landroid/support/design/widget/Snackbar;II)V

    .line 119
    return-void
.end method

.method public static a(Landroid/support/design/widget/Snackbar;II)V
    .locals 1

    .prologue
    .line 132
    invoke-virtual {p0}, Landroid/support/design/widget/Snackbar;->b()Landroid/view/View;

    move-result-object v0

    .line 135
    if-eqz p1, :cond_0

    .line 136
    invoke-virtual {v0, p1}, Landroid/view/View;->setBackgroundColor(I)V

    .line 139
    :cond_0
    invoke-static {p0, p2}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->b(Landroid/support/design/widget/Snackbar;I)V

    .line 140
    return-void
.end method

.method public static a(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 53
    .line 54
    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "input_method"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 55
    new-instance v1, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils$1;

    invoke-direct {v1, v0, p0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils$1;-><init>(Landroid/view/inputmethod/InputMethodManager;Landroid/view/View;)V

    invoke-virtual {p0, v1}, Landroid/view/View;->post(Ljava/lang/Runnable;)Z

    .line 60
    return-void
.end method

.method public static b(Landroid/support/design/widget/Snackbar;I)V
    .locals 2

    .prologue
    .line 145
    invoke-virtual {p0}, Landroid/support/design/widget/Snackbar;->b()Landroid/view/View;

    move-result-object v0

    .line 148
    sget v1, Landroid/support/design/R$id;->snackbar_text:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 149
    if-eqz v0, :cond_0

    .line 150
    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 152
    :cond_0
    return-void
.end method

.method public static b(Landroid/view/View;)V
    .locals 2

    .prologue
    const/high16 v1, 0x3f800000    # 1.0f

    .line 70
    invoke-virtual {p0}, Landroid/view/View;->getAlpha()F

    move-result v0

    cmpl-float v0, v0, v1

    if-nez v0, :cond_0

    invoke-virtual {p0}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 77
    :goto_0
    return-void

    .line 74
    :cond_0
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Landroid/view/View;->setVisibility(I)V

    .line 75
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Landroid/view/View;->setAlpha(F)V

    .line 76
    invoke-virtual {p0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    goto :goto_0
.end method

.method public static c(Landroid/view/View;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 87
    invoke-virtual {p0}, Landroid/view/View;->getAlpha()F

    move-result v0

    cmpl-float v0, v0, v2

    if-nez v0, :cond_0

    const/16 v0, 0x8

    invoke-virtual {p0}, Landroid/view/View;->getVisibility()I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 96
    :goto_0
    return-void

    .line 91
    :cond_0
    invoke-virtual {p0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils$2;

    invoke-direct {v1, p0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils$2;-><init>(Landroid/view/View;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->withEndAction(Ljava/lang/Runnable;)Landroid/view/ViewPropertyAnimator;

    goto :goto_0
.end method

.method public static d(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 104
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils$3;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils$3;-><init>(Landroid/view/View;)V

    invoke-virtual {p0, v0}, Landroid/view/View;->post(Ljava/lang/Runnable;)Z

    .line 109
    return-void
.end method
