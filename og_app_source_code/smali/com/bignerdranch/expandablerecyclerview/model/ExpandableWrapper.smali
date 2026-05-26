.class public Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;
.super Ljava/lang/Object;
.source "ExpandableWrapper.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<P::",
        "Lcom/bignerdranch/expandablerecyclerview/model/Parent",
        "<TC;>;C:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private a:Lcom/bignerdranch/expandablerecyclerview/model/Parent;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TP;"
        }
    .end annotation
.end field

.field private b:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TC;"
        }
    .end annotation
.end field

.field private c:Z

.field private d:Z

.field private e:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper",
            "<TP;TC;>;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/bignerdranch/expandablerecyclerview/model/Parent;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TP;)V"
        }
    .end annotation

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    iput-object p1, p0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->a:Lcom/bignerdranch/expandablerecyclerview/model/Parent;

    .line 30
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->c:Z

    .line 31
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->d:Z

    .line 33
    invoke-direct {p0, p1}, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->a(Lcom/bignerdranch/expandablerecyclerview/model/Parent;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->e:Ljava/util/List;

    .line 34
    return-void
.end method

.method public constructor <init>(Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TC;)V"
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    iput-object p1, p0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->b:Ljava/lang/Object;

    .line 43
    iput-boolean v0, p0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->c:Z

    .line 44
    iput-boolean v0, p0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->d:Z

    .line 45
    return-void
.end method

.method private a(Lcom/bignerdranch/expandablerecyclerview/model/Parent;)Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TP;)",
            "Ljava/util/List",
            "<",
            "Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper",
            "<TP;TC;>;>;"
        }
    .end annotation

    .prologue
    .line 97
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 99
    invoke-interface {p1}, Lcom/bignerdranch/expandablerecyclerview/model/Parent;->a()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    .line 100
    new-instance v3, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;

    invoke-direct {v3, v2}, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;-><init>(Ljava/lang/Object;)V

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 103
    :cond_0
    return-object v0
.end method


# virtual methods
.method public a()Lcom/bignerdranch/expandablerecyclerview/model/Parent;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TP;"
        }
    .end annotation

    .prologue
    .line 48
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->a:Lcom/bignerdranch/expandablerecyclerview/model/Parent;

    return-object v0
.end method

.method public a(Z)V
    .locals 0

    .prologue
    .line 65
    iput-boolean p1, p0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->d:Z

    .line 66
    return-void
.end method

.method public b()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TC;"
        }
    .end annotation

    .prologue
    .line 57
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->b:Ljava/lang/Object;

    return-object v0
.end method

.method public c()Z
    .locals 1

    .prologue
    .line 61
    iget-boolean v0, p0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->d:Z

    return v0
.end method

.method public d()Z
    .locals 1

    .prologue
    .line 69
    iget-boolean v0, p0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->c:Z

    return v0
.end method

.method public e()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper",
            "<TP;TC;>;>;"
        }
    .end annotation

    .prologue
    .line 89
    iget-boolean v0, p0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->c:Z

    if-nez v0, :cond_0

    .line 90
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Parent not wrapped"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 93
    :cond_0
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->e:Ljava/util/List;

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 108
    if-ne p0, p1, :cond_1

    .line 115
    :cond_0
    :goto_0
    return v0

    .line 109
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    if-eq v2, v3, :cond_3

    :cond_2
    move v0, v1

    goto :goto_0

    .line 111
    :cond_3
    check-cast p1, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;

    .line 113
    iget-object v2, p0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->a:Lcom/bignerdranch/expandablerecyclerview/model/Parent;

    if-eqz v2, :cond_5

    iget-object v2, p0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->a:Lcom/bignerdranch/expandablerecyclerview/model/Parent;

    iget-object v3, p1, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->a:Lcom/bignerdranch/expandablerecyclerview/model/Parent;

    invoke-virtual {v2, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_6

    :cond_4
    move v0, v1

    .line 114
    goto :goto_0

    .line 113
    :cond_5
    iget-object v2, p1, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->a:Lcom/bignerdranch/expandablerecyclerview/model/Parent;

    if-nez v2, :cond_4

    .line 115
    :cond_6
    iget-object v2, p0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->b:Ljava/lang/Object;

    if-eqz v2, :cond_7

    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->b:Ljava/lang/Object;

    iget-object v1, p1, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->b:Ljava/lang/Object;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0

    :cond_7
    iget-object v2, p1, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->b:Ljava/lang/Object;

    if-eqz v2, :cond_0

    move v0, v1

    goto :goto_0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 121
    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->a:Lcom/bignerdranch/expandablerecyclerview/model/Parent;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->a:Lcom/bignerdranch/expandablerecyclerview/model/Parent;

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    .line 122
    :goto_0
    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->b:Ljava/lang/Object;

    if-eqz v2, :cond_0

    iget-object v1, p0, Lcom/bignerdranch/expandablerecyclerview/model/ExpandableWrapper;->b:Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    :cond_0
    add-int/2addr v0, v1

    .line 123
    return v0

    :cond_1
    move v0, v1

    .line 121
    goto :goto_0
.end method
