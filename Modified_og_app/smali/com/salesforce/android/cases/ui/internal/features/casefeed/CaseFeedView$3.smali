.class Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView$3;
.super Ljava/lang/Object;
.source "CaseFeedView.java"

# interfaces
.implements Landroid/view/View$OnFocusChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->a(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/content/Context;

.field final synthetic b:Landroid/graphics/drawable/Drawable;

.field final synthetic c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;Landroid/content/Context;Landroid/graphics/drawable/Drawable;)V
    .locals 0

    .prologue
    .line 254
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView$3;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;

    iput-object p2, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView$3;->a:Landroid/content/Context;

    iput-object p3, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView$3;->b:Landroid/graphics/drawable/Drawable;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFocusChange(Landroid/view/View;Z)V
    .locals 3

    .prologue
    .line 256
    if-eqz p2, :cond_0

    .line 257
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView$3;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;

    iget-object v0, v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->m:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView$3;->a:Landroid/content/Context;

    const v2, 0x106000d

    .line 258
    invoke-static {v1, v2}, Landroid/support/v4/content/ContextCompat;->c(Landroid/content/Context;I)I

    move-result v1

    .line 257
    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setBackgroundColor(I)V

    .line 262
    :goto_0
    return-void

    .line 260
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView$3;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;

    iget-object v0, v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->m:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView$3;->b:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setBackground(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method
