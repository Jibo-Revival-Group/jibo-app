.class Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$1;
.super Ljava/lang/Object;
.source "MinimizedViewManager.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/functional/Consumer;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->a(Landroid/view/View;)V
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
.field final synthetic a:Landroid/view/ViewGroup;

.field final synthetic b:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;Landroid/view/ViewGroup;)V
    .locals 0

    .prologue
    .line 164
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$1;->b:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;

    iput-object p2, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$1;->a:Landroid/view/ViewGroup;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 167
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$1;->b:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;

    iget-object v0, v0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->a:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;

    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$1;->a:Landroid/view/ViewGroup;

    invoke-interface {v0, v1, p1}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;->a(Landroid/view/ViewGroup;Landroid/content/Context;)V

    .line 168
    return-void
.end method

.method public bridge synthetic a(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 164
    check-cast p1, Landroid/app/Activity;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$1;->a(Landroid/app/Activity;)V

    return-void
.end method
