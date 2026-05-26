.class Lcom/mixpanel/android/viewcrawler/Pathfinder$IntStack;
.super Ljava/lang/Object;
.source "Pathfinder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/mixpanel/android/viewcrawler/Pathfinder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "IntStack"
.end annotation


# instance fields
.field private final a:[I

.field private b:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 245
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 246
    const/16 v0, 0x100

    new-array v0, v0, [I

    iput-object v0, p0, Lcom/mixpanel/android/viewcrawler/Pathfinder$IntStack;->a:[I

    .line 247
    const/4 v0, 0x0

    iput v0, p0, Lcom/mixpanel/android/viewcrawler/Pathfinder$IntStack;->b:I

    .line 248
    return-void
.end method


# virtual methods
.method public a(I)I
    .locals 1

    .prologue
    .line 268
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/Pathfinder$IntStack;->a:[I

    aget v0, v0, p1

    return v0
.end method

.method public a()Z
    .locals 2

    .prologue
    .line 251
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/Pathfinder$IntStack;->a:[I

    array-length v0, v0

    iget v1, p0, Lcom/mixpanel/android/viewcrawler/Pathfinder$IntStack;->b:I

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public b()I
    .locals 3

    .prologue
    .line 258
    iget v0, p0, Lcom/mixpanel/android/viewcrawler/Pathfinder$IntStack;->b:I

    .line 259
    iget v1, p0, Lcom/mixpanel/android/viewcrawler/Pathfinder$IntStack;->b:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/mixpanel/android/viewcrawler/Pathfinder$IntStack;->b:I

    .line 260
    iget-object v1, p0, Lcom/mixpanel/android/viewcrawler/Pathfinder$IntStack;->a:[I

    const/4 v2, 0x0

    aput v2, v1, v0

    .line 261
    return v0
.end method

.method public b(I)V
    .locals 2

    .prologue
    .line 272
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/Pathfinder$IntStack;->a:[I

    aget v1, v0, p1

    add-int/lit8 v1, v1, 0x1

    aput v1, v0, p1

    .line 273
    return-void
.end method

.method public c()V
    .locals 2

    .prologue
    .line 280
    iget v0, p0, Lcom/mixpanel/android/viewcrawler/Pathfinder$IntStack;->b:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/mixpanel/android/viewcrawler/Pathfinder$IntStack;->b:I

    .line 281
    iget v0, p0, Lcom/mixpanel/android/viewcrawler/Pathfinder$IntStack;->b:I

    if-gez v0, :cond_0

    .line 282
    new-instance v0, Ljava/lang/ArrayIndexOutOfBoundsException;

    iget v1, p0, Lcom/mixpanel/android/viewcrawler/Pathfinder$IntStack;->b:I

    invoke-direct {v0, v1}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>(I)V

    throw v0

    .line 284
    :cond_0
    return-void
.end method
