.class Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$2;
.super Ljava/lang/Object;
.source "MinimizedViewManager.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/functional/Consumer;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->b(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/functional/Consumer",
        "<",
        "Landroid/app/Activity;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;)V
    .locals 0

    .prologue
    .line 181
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$2;->a:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 184
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$2;->a:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;

    iget-object v0, v0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->f:Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;->a(Landroid/content/Context;)V

    .line 185
    return-void
.end method

.method public bridge synthetic a(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 181
    check-cast p1, Landroid/app/Activity;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$2;->a(Landroid/app/Activity;)V

    return-void
.end method
