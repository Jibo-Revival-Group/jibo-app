.class public final Lcom/firebase/jobdispatcher/ObservedUri;
.super Ljava/lang/Object;
.source "ObservedUri.java"


# instance fields
.field private final a:Landroid/net/Uri;

.field private final b:I


# direct methods
.method public constructor <init>(Landroid/net/Uri;I)V
    .locals 2

    .prologue
    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    if-nez p1, :cond_0

    .line 52
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "URI must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 54
    :cond_0
    iput-object p1, p0, Lcom/firebase/jobdispatcher/ObservedUri;->a:Landroid/net/Uri;

    .line 55
    iput p2, p0, Lcom/firebase/jobdispatcher/ObservedUri;->b:I

    .line 56
    return-void
.end method


# virtual methods
.method public a()Landroid/net/Uri;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/firebase/jobdispatcher/ObservedUri;->a:Landroid/net/Uri;

    return-object v0
.end method

.method public b()I
    .locals 1

    .prologue
    .line 63
    iget v0, p0, Lcom/firebase/jobdispatcher/ObservedUri;->b:I

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 68
    if-ne p0, p1, :cond_1

    .line 76
    :cond_0
    :goto_0
    return v0

    .line 71
    :cond_1
    instance-of v2, p1, Lcom/firebase/jobdispatcher/ObservedUri;

    if-nez v2, :cond_2

    move v0, v1

    .line 72
    goto :goto_0

    .line 75
    :cond_2
    check-cast p1, Lcom/firebase/jobdispatcher/ObservedUri;

    .line 76
    iget v2, p0, Lcom/firebase/jobdispatcher/ObservedUri;->b:I

    iget v3, p1, Lcom/firebase/jobdispatcher/ObservedUri;->b:I

    if-ne v2, v3, :cond_3

    iget-object v2, p0, Lcom/firebase/jobdispatcher/ObservedUri;->a:Landroid/net/Uri;

    iget-object v3, p1, Lcom/firebase/jobdispatcher/ObservedUri;->a:Landroid/net/Uri;

    invoke-virtual {v2, v3}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    :cond_3
    move v0, v1

    goto :goto_0
.end method

.method public hashCode()I
    .locals 2

    .prologue
    .line 81
    iget-object v0, p0, Lcom/firebase/jobdispatcher/ObservedUri;->a:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->hashCode()I

    move-result v0

    iget v1, p0, Lcom/firebase/jobdispatcher/ObservedUri;->b:I

    xor-int/2addr v0, v1

    return v0
.end method
