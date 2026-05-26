.class Lcom/google/api/client/repackaged/com/google/common/base/Splitter$4$1;
.super Lcom/google/api/client/repackaged/com/google/common/base/Splitter$SplittingIterator;
.source "Splitter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/api/client/repackaged/com/google/common/base/Splitter$4;->iterator(Lcom/google/api/client/repackaged/com/google/common/base/Splitter;Ljava/lang/CharSequence;)Lcom/google/api/client/repackaged/com/google/common/base/Splitter$SplittingIterator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/api/client/repackaged/com/google/common/base/Splitter$4;


# direct methods
.method constructor <init>(Lcom/google/api/client/repackaged/com/google/common/base/Splitter$4;Lcom/google/api/client/repackaged/com/google/common/base/Splitter;Ljava/lang/CharSequence;)V
    .locals 0

    .prologue
    .line 282
    iput-object p1, p0, Lcom/google/api/client/repackaged/com/google/common/base/Splitter$4$1;->this$0:Lcom/google/api/client/repackaged/com/google/common/base/Splitter$4;

    invoke-direct {p0, p2, p3}, Lcom/google/api/client/repackaged/com/google/common/base/Splitter$SplittingIterator;-><init>(Lcom/google/api/client/repackaged/com/google/common/base/Splitter;Ljava/lang/CharSequence;)V

    return-void
.end method


# virtual methods
.method public separatorEnd(I)I
    .locals 0

    .prologue
    .line 289
    return p1
.end method

.method public separatorStart(I)I
    .locals 2

    .prologue
    .line 284
    iget-object v0, p0, Lcom/google/api/client/repackaged/com/google/common/base/Splitter$4$1;->this$0:Lcom/google/api/client/repackaged/com/google/common/base/Splitter$4;

    iget v0, v0, Lcom/google/api/client/repackaged/com/google/common/base/Splitter$4;->val$length:I

    add-int/2addr v0, p1

    .line 285
    iget-object v1, p0, Lcom/google/api/client/repackaged/com/google/common/base/Splitter$4$1;->toSplit:Ljava/lang/CharSequence;

    invoke-interface {v1}, Ljava/lang/CharSequence;->length()I

    move-result v1

    if-ge v0, v1, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method
