.class final Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$1;
.super Ljava/util/ArrayList;
.source "ArticleDetailRenderer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/util/ArrayList",
        "<",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 55
    invoke-direct {p0}, Ljava/util/ArrayList;-><init>()V

    .line 57
    const-string v0, "Summary"

    invoke-virtual {p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$1;->add(Ljava/lang/Object;)Z

    .line 58
    const-string v0, "ArticleNumber"

    invoke-virtual {p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$1;->add(Ljava/lang/Object;)Z

    .line 59
    const-string v0, "UrlName"

    invoke-virtual {p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$1;->add(Ljava/lang/Object;)Z

    .line 60
    return-void
.end method
