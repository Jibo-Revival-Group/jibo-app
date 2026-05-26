.class public Lcom/salesforce/android/service/common/ui/internal/utils/ViewGroupHelper;
.super Ljava/lang/Object;
.source "ViewGroupHelper.java"


# direct methods
.method public static a(Landroid/view/ViewGroup;Z)V
    .locals 4

    .prologue
    .line 48
    const/4 v0, 0x0

    invoke-virtual {p0}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v2

    move v1, v0

    :goto_0
    if-ge v1, v2, :cond_1

    .line 49
    invoke-virtual {p0, v1}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 50
    invoke-virtual {v0, p1}, Landroid/view/View;->setEnabled(Z)V

    .line 51
    instance-of v3, v0, Landroid/view/ViewGroup;

    if-eqz v3, :cond_0

    .line 52
    check-cast v0, Landroid/view/ViewGroup;

    invoke-static {v0, p1}, Lcom/salesforce/android/service/common/ui/internal/utils/ViewGroupHelper;->a(Landroid/view/ViewGroup;Z)V

    .line 48
    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 55
    :cond_1
    return-void
.end method
