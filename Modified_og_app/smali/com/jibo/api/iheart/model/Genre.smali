.class public Lcom/jibo/api/iheart/model/Genre;
.super Ljava/lang/Object;
.source "Genre.java"


# instance fields
.field private a:I

.field private b:Ljava/lang/String;

.field private c:Lcom/jibo/api/iheart/model/Station;


# direct methods
.method public constructor <init>(ILjava/lang/String;)V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    iput p1, p0, Lcom/jibo/api/iheart/model/Genre;->a:I

    .line 14
    iput-object p2, p0, Lcom/jibo/api/iheart/model/Genre;->b:Ljava/lang/String;

    .line 15
    return-void
.end method


# virtual methods
.method public a()I
    .locals 1

    .prologue
    .line 18
    iget v0, p0, Lcom/jibo/api/iheart/model/Genre;->a:I

    return v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/jibo/api/iheart/model/Genre;->b:Ljava/lang/String;

    return-object v0
.end method

.method public c()Lcom/jibo/api/iheart/model/Station;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/jibo/api/iheart/model/Genre;->c:Lcom/jibo/api/iheart/model/Station;

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 43
    if-ne p0, p1, :cond_1

    move v1, v0

    .line 50
    :cond_0
    :goto_0
    return v1

    .line 44
    :cond_1
    if-eqz p1, :cond_0

    .line 46
    instance-of v2, p1, Lcom/jibo/api/iheart/model/Genre;

    if-eqz v2, :cond_0

    .line 47
    check-cast p1, Lcom/jibo/api/iheart/model/Genre;

    .line 49
    invoke-virtual {p1}, Lcom/jibo/api/iheart/model/Genre;->a()I

    move-result v2

    if-eqz v2, :cond_0

    .line 50
    invoke-virtual {p1}, Lcom/jibo/api/iheart/model/Genre;->a()I

    move-result v2

    invoke-virtual {p0}, Lcom/jibo/api/iheart/model/Genre;->a()I

    move-result v3

    if-ne v2, v3, :cond_2

    :goto_1
    move v1, v0

    goto :goto_0

    :cond_2
    move v0, v1

    goto :goto_1
.end method
