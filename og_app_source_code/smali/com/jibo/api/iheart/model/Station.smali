.class public Lcom/jibo/api/iheart/model/Station;
.super Ljava/lang/Object;
.source "Station.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/api/iheart/model/Station$Market;
    }
.end annotation


# instance fields
.field private a:I

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;

.field private d:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/api/iheart/model/Station$Market;",
            ">;"
        }
    .end annotation
.end field

.field private e:Ljava/lang/String;


# direct methods
.method public constructor <init>(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    iput p1, p0, Lcom/jibo/api/iheart/model/Station;->a:I

    .line 32
    iput-object p2, p0, Lcom/jibo/api/iheart/model/Station;->b:Ljava/lang/String;

    .line 33
    iput-object p3, p0, Lcom/jibo/api/iheart/model/Station;->c:Ljava/lang/String;

    .line 34
    iput-object p4, p0, Lcom/jibo/api/iheart/model/Station;->e:Ljava/lang/String;

    .line 35
    return-void
.end method


# virtual methods
.method public a()I
    .locals 1

    .prologue
    .line 38
    iget v0, p0, Lcom/jibo/api/iheart/model/Station;->a:I

    return v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/jibo/api/iheart/model/Station;->b:Ljava/lang/String;

    return-object v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/jibo/api/iheart/model/Station;->c:Ljava/lang/String;

    return-object v0
.end method

.method public d()Ljava/lang/String;
    .locals 2

    .prologue
    .line 54
    iget-object v0, p0, Lcom/jibo/api/iheart/model/Station;->d:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/api/iheart/model/Station;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/api/iheart/model/Station;->d:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/api/iheart/model/Station$Market;

    .line 55
    :goto_0
    if-eqz v0, :cond_1

    invoke-static {v0}, Lcom/jibo/api/iheart/model/Station$Market;->a(Lcom/jibo/api/iheart/model/Station$Market;)Ljava/lang/String;

    move-result-object v0

    :goto_1
    return-object v0

    .line 54
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 55
    :cond_1
    const-string v0, ""

    goto :goto_1
.end method

.method public e()Ljava/lang/String;
    .locals 2

    .prologue
    .line 59
    iget-object v0, p0, Lcom/jibo/api/iheart/model/Station;->d:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/api/iheart/model/Station;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/api/iheart/model/Station;->d:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/api/iheart/model/Station$Market;

    .line 60
    :goto_0
    if-eqz v0, :cond_1

    invoke-static {v0}, Lcom/jibo/api/iheart/model/Station$Market;->b(Lcom/jibo/api/iheart/model/Station$Market;)Ljava/lang/String;

    move-result-object v0

    :goto_1
    return-object v0

    .line 59
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 60
    :cond_1
    const-string v0, ""

    goto :goto_1
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 85
    if-ne p0, p1, :cond_1

    move v1, v0

    .line 92
    :cond_0
    :goto_0
    return v1

    .line 86
    :cond_1
    if-eqz p1, :cond_0

    .line 88
    instance-of v2, p1, Lcom/jibo/api/iheart/model/Station;

    if-eqz v2, :cond_0

    .line 89
    check-cast p1, Lcom/jibo/api/iheart/model/Station;

    .line 91
    invoke-virtual {p1}, Lcom/jibo/api/iheart/model/Station;->a()I

    move-result v2

    if-eqz v2, :cond_0

    .line 92
    invoke-virtual {p1}, Lcom/jibo/api/iheart/model/Station;->a()I

    move-result v2

    invoke-virtual {p0}, Lcom/jibo/api/iheart/model/Station;->a()I

    move-result v3

    if-ne v2, v3, :cond_2

    :goto_1
    move v1, v0

    goto :goto_0

    :cond_2
    move v0, v1

    goto :goto_1
.end method

.method public f()Ljava/lang/String;
    .locals 2

    .prologue
    .line 64
    const-string v0, "Digital"

    invoke-virtual {p0}, Lcom/jibo/api/iheart/model/Station;->d()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "Digital"

    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/jibo/api/iheart/model/Station;->d()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/api/iheart/model/Station;->e()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public g()Ljava/lang/String;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/jibo/api/iheart/model/Station;->e:Ljava/lang/String;

    return-object v0
.end method
