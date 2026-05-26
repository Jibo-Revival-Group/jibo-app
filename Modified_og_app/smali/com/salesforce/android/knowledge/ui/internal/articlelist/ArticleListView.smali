.class public interface abstract Lcom/salesforce/android/knowledge/ui/internal/articlelist/ArticleListView;
.super Ljava/lang/Object;
.source "ArticleListView.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/ui/internal/AbstractView;
.implements Lcom/salesforce/android/knowledge/ui/internal/toolbar/ToolbarView;


# virtual methods
.method public abstract a(I)V
.end method

.method public abstract a(Landroid/graphics/drawable/Drawable;)V
.end method

.method public abstract a(Ljava/lang/String;)V
.end method

.method public abstract a(Ljava/util/List;Z)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/ArticleSummary;",
            ">;Z)V"
        }
    .end annotation
.end method
