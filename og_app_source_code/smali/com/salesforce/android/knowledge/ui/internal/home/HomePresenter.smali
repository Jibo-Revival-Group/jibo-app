.class public interface abstract Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;
.super Ljava/lang/Object;
.source "HomePresenter.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/ui/internal/presenter/Presenter;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/knowledge/ui/internal/presenter/Presenter",
        "<",
        "Lcom/salesforce/android/knowledge/ui/internal/home/HomeView;",
        ">;"
    }
.end annotation


# virtual methods
.method public abstract a()V
.end method

.method public abstract a(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V
.end method

.method public abstract a(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V
.end method

.method public abstract b(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)Landroid/graphics/drawable/Drawable;
.end method

.method public abstract b(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)V
.end method

.method public abstract c(Lcom/salesforce/android/knowledge/ui/internal/models/DataCategoryInfo;)Z
.end method

.method public abstract d()V
.end method
