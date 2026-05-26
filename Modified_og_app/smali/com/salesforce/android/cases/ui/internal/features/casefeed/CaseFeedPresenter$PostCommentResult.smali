.class Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$PostCommentResult;
.super Ljava/lang/Object;
.source "CaseFeedPresenter.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "PostCommentResult"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler",
        "<",
        "Lcom/salesforce/android/cases/core/model/CommentPost;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;

.field private final b:Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;)V
    .locals 0

    .prologue
    .line 253
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$PostCommentResult;->a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 254
    iput-object p2, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$PostCommentResult;->b:Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;

    .line 255
    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/cases/core/model/CommentPost;)V
    .locals 3

    .prologue
    .line 258
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$PostCommentResult;->a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->a(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;)V

    .line 259
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$PostCommentResult;->a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;

    iget-object v0, v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;->n()V

    .line 260
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$PostCommentResult;->a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;

    iget-object v0, v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;->j()V

    .line 261
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$PostCommentResult;->a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;

    iget-object v0, v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;->m()V

    .line 262
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$PostCommentResult;->b:Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;

    invoke-virtual {v0, p2}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->a(Lcom/salesforce/android/cases/core/model/CommentPost;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    .line 263
    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$PostCommentResult;->a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;

    iget-object v2, v2, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    invoke-interface {v2, v1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;->a(Ljava/lang/Object;)V

    goto :goto_0

    .line 265
    :cond_0
    return-void
.end method

.method public bridge synthetic a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 249
    check-cast p2, Lcom/salesforce/android/cases/core/model/CommentPost;

    invoke-virtual {p0, p1, p2}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$PostCommentResult;->a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/cases/core/model/CommentPost;)V

    return-void
.end method
