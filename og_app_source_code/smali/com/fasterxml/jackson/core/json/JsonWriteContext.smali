.class public Lcom/fasterxml/jackson/core/json/JsonWriteContext;
.super Lcom/fasterxml/jackson/core/JsonStreamContext;
.source "JsonWriteContext.java"


# instance fields
.field protected final c:Lcom/fasterxml/jackson/core/json/JsonWriteContext;

.field protected d:Lcom/fasterxml/jackson/core/json/DupDetector;

.field protected e:Lcom/fasterxml/jackson/core/json/JsonWriteContext;

.field protected f:Ljava/lang/String;

.field protected g:Ljava/lang/Object;

.field protected h:Z


# direct methods
.method protected constructor <init>(ILcom/fasterxml/jackson/core/json/JsonWriteContext;Lcom/fasterxml/jackson/core/json/DupDetector;)V
    .locals 1

    .prologue
    .line 70
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/JsonStreamContext;-><init>()V

    .line 38
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->e:Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    .line 71
    iput p1, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->a:I

    .line 72
    iput-object p2, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->c:Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    .line 73
    iput-object p3, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->d:Lcom/fasterxml/jackson/core/json/DupDetector;

    .line 74
    const/4 v0, -0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->b:I

    .line 75
    return-void
.end method

.method public static a(Lcom/fasterxml/jackson/core/json/DupDetector;)Lcom/fasterxml/jackson/core/json/JsonWriteContext;
    .locals 3

    .prologue
    .line 115
    new-instance v0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2, p0}, Lcom/fasterxml/jackson/core/json/JsonWriteContext;-><init>(ILcom/fasterxml/jackson/core/json/JsonWriteContext;Lcom/fasterxml/jackson/core/json/DupDetector;)V

    return-object v0
.end method

.method private final a(Lcom/fasterxml/jackson/core/json/DupDetector;Ljava/lang/String;)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 159
    invoke-virtual {p1, p2}, Lcom/fasterxml/jackson/core/json/DupDetector;->a(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Lcom/fasterxml/jackson/core/JsonGenerationException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Duplicate field \'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/fasterxml/jackson/core/JsonGenerationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 160
    :cond_0
    return-void
.end method


# virtual methods
.method public a(Ljava/lang/String;)I
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x1

    .line 149
    iget-boolean v1, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->h:Z

    if-eqz v1, :cond_1

    .line 150
    const/4 v0, 0x4

    .line 155
    :cond_0
    :goto_0
    return v0

    .line 152
    :cond_1
    iput-boolean v0, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->h:Z

    .line 153
    iput-object p1, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->f:Ljava/lang/String;

    .line 154
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->d:Lcom/fasterxml/jackson/core/json/DupDetector;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->d:Lcom/fasterxml/jackson/core/json/DupDetector;

    invoke-direct {p0, v1, p1}, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->a(Lcom/fasterxml/jackson/core/json/DupDetector;Ljava/lang/String;)V

    .line 155
    :cond_2
    iget v1, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->b:I

    if-gez v1, :cond_0

    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected a(I)Lcom/fasterxml/jackson/core/json/JsonWriteContext;
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 78
    iput p1, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->a:I

    .line 79
    const/4 v0, -0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->b:I

    .line 80
    iput-object v1, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->f:Ljava/lang/String;

    .line 81
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->h:Z

    .line 82
    iput-object v1, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->g:Ljava/lang/Object;

    .line 83
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->d:Lcom/fasterxml/jackson/core/json/DupDetector;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->d:Lcom/fasterxml/jackson/core/json/DupDetector;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/json/DupDetector;->b()V

    .line 84
    :cond_0
    return-object p0
.end method

.method protected a(Ljava/lang/StringBuilder;)V
    .locals 3

    .prologue
    const/16 v2, 0x22

    .line 189
    iget v0, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->a:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_1

    .line 190
    const/16 v0, 0x7b

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 191
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->f:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 192
    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 194
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->f:Ljava/lang/String;

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 195
    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 199
    :goto_0
    const/16 v0, 0x7d

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 208
    :goto_1
    return-void

    .line 197
    :cond_0
    const/16 v0, 0x3f

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 200
    :cond_1
    iget v0, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->a:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_2

    .line 201
    const/16 v0, 0x5b

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 202
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->f()I

    move-result v0

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 203
    const/16 v0, 0x5d

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 206
    :cond_2
    const-string v0, "/"

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1
.end method

.method public g()Lcom/fasterxml/jackson/core/json/JsonWriteContext;
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 119
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->e:Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    .line 120
    if-nez v0, :cond_1

    .line 121
    new-instance v1, Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->d:Lcom/fasterxml/jackson/core/json/DupDetector;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    invoke-direct {v1, v2, p0, v0}, Lcom/fasterxml/jackson/core/json/JsonWriteContext;-><init>(ILcom/fasterxml/jackson/core/json/JsonWriteContext;Lcom/fasterxml/jackson/core/json/DupDetector;)V

    iput-object v1, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->e:Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    move-object v0, v1

    .line 124
    :goto_1
    return-object v0

    .line 121
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->d:Lcom/fasterxml/jackson/core/json/DupDetector;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/json/DupDetector;->a()Lcom/fasterxml/jackson/core/json/DupDetector;

    move-result-object v0

    goto :goto_0

    .line 124
    :cond_1
    invoke-virtual {v0, v2}, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->a(I)Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    move-result-object v0

    goto :goto_1
.end method

.method public h()Lcom/fasterxml/jackson/core/json/JsonWriteContext;
    .locals 3

    .prologue
    const/4 v2, 0x2

    .line 128
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->e:Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    .line 129
    if-nez v0, :cond_1

    .line 130
    new-instance v1, Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->d:Lcom/fasterxml/jackson/core/json/DupDetector;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    invoke-direct {v1, v2, p0, v0}, Lcom/fasterxml/jackson/core/json/JsonWriteContext;-><init>(ILcom/fasterxml/jackson/core/json/JsonWriteContext;Lcom/fasterxml/jackson/core/json/DupDetector;)V

    iput-object v1, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->e:Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    move-object v0, v1

    .line 133
    :goto_1
    return-object v0

    .line 130
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->d:Lcom/fasterxml/jackson/core/json/DupDetector;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/json/DupDetector;->a()Lcom/fasterxml/jackson/core/json/DupDetector;

    move-result-object v0

    goto :goto_0

    .line 133
    :cond_1
    invoke-virtual {v0, v2}, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->a(I)Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    move-result-object v0

    goto :goto_1
.end method

.method public final i()Lcom/fasterxml/jackson/core/json/JsonWriteContext;
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->c:Lcom/fasterxml/jackson/core/json/JsonWriteContext;

    return-object v0
.end method

.method public j()I
    .locals 4

    .prologue
    const/4 v2, 0x2

    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 164
    iget v3, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->a:I

    if-ne v3, v2, :cond_2

    .line 165
    iget-boolean v1, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->h:Z

    if-nez v1, :cond_1

    .line 166
    const/4 v0, 0x5

    .line 183
    :cond_0
    :goto_0
    return v0

    .line 168
    :cond_1
    iput-boolean v0, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->h:Z

    .line 169
    iget v0, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->b:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->b:I

    move v0, v2

    .line 170
    goto :goto_0

    .line 174
    :cond_2
    iget v2, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->a:I

    if-ne v2, v1, :cond_3

    .line 175
    iget v2, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->b:I

    .line 176
    iget v3, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->b:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->b:I

    .line 177
    if-ltz v2, :cond_0

    move v0, v1

    goto :goto_0

    .line 182
    :cond_3
    iget v1, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->b:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->b:I

    .line 183
    iget v1, p0, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->b:I

    if-eqz v1, :cond_0

    const/4 v0, 0x3

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 217
    new-instance v0, Ljava/lang/StringBuilder;

    const/16 v1, 0x40

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 218
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/JsonWriteContext;->a(Ljava/lang/StringBuilder;)V

    .line 219
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
