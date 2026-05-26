.class public Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewState;
.super Ljava/lang/Object;
.source "ViewState.java"


# instance fields
.field private final a:Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;

.field private final b:Landroid/os/Bundle;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewState;->a:Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;

    .line 42
    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewState;->b:Landroid/os/Bundle;

    .line 43
    return-void
.end method


# virtual methods
.method public a()Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewState;->a:Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;

    return-object v0
.end method

.method public b()V
    .locals 2

    .prologue
    .line 50
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewState;->a:Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewState;->b:Landroid/os/Bundle;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;->a(Landroid/os/Bundle;)V

    .line 51
    return-void
.end method

.method public c()V
    .locals 2

    .prologue
    .line 54
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewState;->a:Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/ViewState;->b:Landroid/os/Bundle;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;->b(Landroid/os/Bundle;)V

    .line 55
    return-void
.end method
