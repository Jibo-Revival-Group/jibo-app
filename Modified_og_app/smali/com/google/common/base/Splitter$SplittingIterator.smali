.class abstract Lcom/google/common/base/Splitter$SplittingIterator;
.super Lcom/google/common/base/AbstractIterator;
.source "Splitter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/common/base/Splitter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x40a
    name = "SplittingIterator"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/common/base/AbstractIterator",
        "<",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final b:Ljava/lang/CharSequence;

.field final c:Lcom/google/common/base/CharMatcher;

.field final d:Z

.field e:I

.field f:I


# direct methods
.method protected constructor <init>(Lcom/google/common/base/Splitter;Ljava/lang/CharSequence;)V
    .locals 1

    .prologue
    .line 527
    invoke-direct {p0}, Lcom/google/common/base/AbstractIterator;-><init>()V

    .line 524
    const/4 v0, 0x0

    iput v0, p0, Lcom/google/common/base/Splitter$SplittingIterator;->e:I

    .line 528
    invoke-static {p1}, Lcom/google/common/base/Splitter;->a(Lcom/google/common/base/Splitter;)Lcom/google/common/base/CharMatcher;

    move-result-object v0

    iput-object v0, p0, Lcom/google/common/base/Splitter$SplittingIterator;->c:Lcom/google/common/base/CharMatcher;

    .line 529
    invoke-static {p1}, Lcom/google/common/base/Splitter;->b(Lcom/google/common/base/Splitter;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/google/common/base/Splitter$SplittingIterator;->d:Z

    .line 530
    invoke-static {p1}, Lcom/google/common/base/Splitter;->c(Lcom/google/common/base/Splitter;)I

    move-result v0

    iput v0, p0, Lcom/google/common/base/Splitter$SplittingIterator;->f:I

    .line 531
    iput-object p2, p0, Lcom/google/common/base/Splitter$SplittingIterator;->b:Ljava/lang/CharSequence;

    .line 532
    return-void
.end method


# virtual methods
.method abstract a(I)I
.end method

.method protected synthetic a()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 506
    invoke-virtual {p0}, Lcom/google/common/base/Splitter$SplittingIterator;->c()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method abstract b(I)I
.end method

.method protected c()Ljava/lang/String;
    .locals 6

    .prologue
    const/4 v5, -0x1

    .line 541
    iget v0, p0, Lcom/google/common/base/Splitter$SplittingIterator;->e:I

    .line 542
    :cond_0
    :goto_0
    iget v1, p0, Lcom/google/common/base/Splitter$SplittingIterator;->e:I

    if-eq v1, v5, :cond_6

    .line 546
    iget v1, p0, Lcom/google/common/base/Splitter$SplittingIterator;->e:I

    invoke-virtual {p0, v1}, Lcom/google/common/base/Splitter$SplittingIterator;->a(I)I

    move-result v1

    .line 547
    if-ne v1, v5, :cond_1

    .line 548
    iget-object v1, p0, Lcom/google/common/base/Splitter$SplittingIterator;->b:Ljava/lang/CharSequence;

    invoke-interface {v1}, Ljava/lang/CharSequence;->length()I

    move-result v1

    .line 549
    iput v5, p0, Lcom/google/common/base/Splitter$SplittingIterator;->e:I

    .line 554
    :goto_1
    iget v2, p0, Lcom/google/common/base/Splitter$SplittingIterator;->e:I

    if-ne v2, v0, :cond_8

    .line 561
    iget v1, p0, Lcom/google/common/base/Splitter$SplittingIterator;->e:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/google/common/base/Splitter$SplittingIterator;->e:I

    .line 562
    iget v1, p0, Lcom/google/common/base/Splitter$SplittingIterator;->e:I

    iget-object v2, p0, Lcom/google/common/base/Splitter$SplittingIterator;->b:Ljava/lang/CharSequence;

    invoke-interface {v2}, Ljava/lang/CharSequence;->length()I

    move-result v2

    if-le v1, v2, :cond_0

    .line 563
    iput v5, p0, Lcom/google/common/base/Splitter$SplittingIterator;->e:I

    goto :goto_0

    .line 552
    :cond_1
    invoke-virtual {p0, v1}, Lcom/google/common/base/Splitter$SplittingIterator;->b(I)I

    move-result v2

    iput v2, p0, Lcom/google/common/base/Splitter$SplittingIterator;->e:I

    goto :goto_1

    .line 568
    :goto_2
    if-ge v2, v1, :cond_7

    iget-object v0, p0, Lcom/google/common/base/Splitter$SplittingIterator;->c:Lcom/google/common/base/CharMatcher;

    iget-object v3, p0, Lcom/google/common/base/Splitter$SplittingIterator;->b:Ljava/lang/CharSequence;

    invoke-interface {v3, v2}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v3

    invoke-virtual {v0, v3}, Lcom/google/common/base/CharMatcher;->b(C)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 569
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_2

    .line 571
    :goto_3
    if-le v0, v2, :cond_2

    iget-object v1, p0, Lcom/google/common/base/Splitter$SplittingIterator;->c:Lcom/google/common/base/CharMatcher;

    iget-object v3, p0, Lcom/google/common/base/Splitter$SplittingIterator;->b:Ljava/lang/CharSequence;

    add-int/lit8 v4, v0, -0x1

    invoke-interface {v3, v4}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v3

    invoke-virtual {v1, v3}, Lcom/google/common/base/CharMatcher;->b(C)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 572
    add-int/lit8 v1, v0, -0x1

    move v0, v1

    goto :goto_3

    .line 575
    :cond_2
    iget-boolean v1, p0, Lcom/google/common/base/Splitter$SplittingIterator;->d:Z

    if-eqz v1, :cond_3

    if-ne v2, v0, :cond_3

    .line 577
    iget v0, p0, Lcom/google/common/base/Splitter$SplittingIterator;->e:I

    goto :goto_0

    .line 581
    :cond_3
    iget v1, p0, Lcom/google/common/base/Splitter$SplittingIterator;->f:I

    const/4 v3, 0x1

    if-ne v1, v3, :cond_4

    .line 585
    iget-object v0, p0, Lcom/google/common/base/Splitter$SplittingIterator;->b:Ljava/lang/CharSequence;

    invoke-interface {v0}, Ljava/lang/CharSequence;->length()I

    move-result v0

    .line 586
    iput v5, p0, Lcom/google/common/base/Splitter$SplittingIterator;->e:I

    .line 588
    :goto_4
    if-le v0, v2, :cond_5

    iget-object v1, p0, Lcom/google/common/base/Splitter$SplittingIterator;->c:Lcom/google/common/base/CharMatcher;

    iget-object v3, p0, Lcom/google/common/base/Splitter$SplittingIterator;->b:Ljava/lang/CharSequence;

    add-int/lit8 v4, v0, -0x1

    invoke-interface {v3, v4}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v3

    invoke-virtual {v1, v3}, Lcom/google/common/base/CharMatcher;->b(C)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 589
    add-int/lit8 v0, v0, -0x1

    goto :goto_4

    .line 592
    :cond_4
    iget v1, p0, Lcom/google/common/base/Splitter$SplittingIterator;->f:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Lcom/google/common/base/Splitter$SplittingIterator;->f:I

    .line 595
    :cond_5
    iget-object v1, p0, Lcom/google/common/base/Splitter$SplittingIterator;->b:Ljava/lang/CharSequence;

    invoke-interface {v1, v2, v0}, Ljava/lang/CharSequence;->subSequence(II)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    .line 597
    :goto_5
    return-object v0

    :cond_6
    invoke-virtual {p0}, Lcom/google/common/base/Splitter$SplittingIterator;->b()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    goto :goto_5

    :cond_7
    move v0, v1

    goto :goto_3

    :cond_8
    move v2, v0

    goto :goto_2
.end method
