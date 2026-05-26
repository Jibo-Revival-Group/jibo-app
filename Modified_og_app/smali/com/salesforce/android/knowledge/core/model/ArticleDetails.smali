.class public interface abstract Lcom/salesforce/android/knowledge/core/model/ArticleDetails;
.super Ljava/lang/Object;
.source "ArticleDetails.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/core/model/ArticleSummary;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/core/model/ArticleDetails$Field;
    }
.end annotation


# virtual methods
.method public abstract a()I
.end method

.method public abstract b()Ljava/util/Date;
.end method

.method public abstract c()Ljava/util/Date;
.end method

.method public abstract d()Lcom/salesforce/android/knowledge/core/model/ChatterUser;
.end method

.method public abstract e()Lcom/salesforce/android/knowledge/core/model/ChatterUser;
.end method

.method public abstract f()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/ArticleDetails$Field;",
            ">;"
        }
    .end annotation
.end method
