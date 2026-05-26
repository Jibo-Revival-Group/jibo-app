.class Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder$2;
.super Ljava/lang/Object;
.source "HomeViewBinder.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->a(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;)V
    .locals 0

    .prologue
    .line 129
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder$2;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder$2;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;

    iget-object v0, v0, Lcom/salesforce/android/knowledge/ui/internal/home/HomeViewBinder;->a:Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;->d()V

    .line 132
    return-void
.end method
