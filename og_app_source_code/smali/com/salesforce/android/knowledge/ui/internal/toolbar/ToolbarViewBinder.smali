.class public abstract Lcom/salesforce/android/knowledge/ui/internal/toolbar/ToolbarViewBinder;
.super Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;
.source "ToolbarViewBinder.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/ui/internal/toolbar/ToolbarView;


# instance fields
.field private final a:Lcom/salesforce/android/knowledge/ui/internal/toolbar/ToolbarPresenter;


# direct methods
.method protected constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/toolbar/ToolbarPresenter;)V
    .locals 0

    .prologue
    .line 43
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;-><init>()V

    .line 44
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/toolbar/ToolbarViewBinder;->a:Lcom/salesforce/android/knowledge/ui/internal/toolbar/ToolbarPresenter;

    .line 45
    return-void
.end method


# virtual methods
.method public a(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1

    .prologue
    .line 56
    sget v0, Lcom/salesforce/android/knowledge/ui/R$menu;->knowledge_menu:I

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 57
    return-void
.end method

.method public a(Z)V
    .locals 2

    .prologue
    .line 78
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/toolbar/ToolbarViewBinder;->d()Landroid/support/v7/widget/Toolbar;

    move-result-object v0

    .line 79
    if-eqz p1, :cond_0

    .line 80
    sget v1, Lcom/salesforce/android/knowledge/ui/R$drawable;->knowledge_ic_home:I

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/Toolbar;->setNavigationIcon(I)V

    .line 84
    :goto_0
    return-void

    .line 82
    :cond_0
    sget v1, Lcom/salesforce/android/knowledge/ui/R$drawable;->knowledge_ic_nav_back:I

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/Toolbar;->setNavigationIcon(I)V

    goto :goto_0
.end method

.method public a(Landroid/view/MenuItem;)Z
    .locals 3

    .prologue
    const/4 v0, 0x1

    .line 60
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    .line 62
    sget v2, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_action_search:I

    if-ne v1, v2, :cond_0

    .line 63
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/toolbar/ToolbarViewBinder;->a:Lcom/salesforce/android/knowledge/ui/internal/toolbar/ToolbarPresenter;

    invoke-interface {v1}, Lcom/salesforce/android/knowledge/ui/internal/toolbar/ToolbarPresenter;->d()V

    .line 72
    :goto_0
    return v0

    .line 67
    :cond_0
    const v2, 0x102002c

    if-ne v1, v2, :cond_1

    .line 68
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/toolbar/ToolbarViewBinder;->a:Lcom/salesforce/android/knowledge/ui/internal/toolbar/ToolbarPresenter;

    invoke-interface {v1}, Lcom/salesforce/android/knowledge/ui/internal/toolbar/ToolbarPresenter;->e()V

    goto :goto_0

    .line 72
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public abstract d()Landroid/support/v7/widget/Toolbar;
.end method

.method public t_()Z
    .locals 1

    .prologue
    .line 52
    const/4 v0, 0x1

    return v0
.end method
