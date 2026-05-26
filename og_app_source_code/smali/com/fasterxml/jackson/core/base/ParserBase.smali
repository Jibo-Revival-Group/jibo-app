.class public abstract Lcom/fasterxml/jackson/core/base/ParserBase;
.super Lcom/fasterxml/jackson/core/base/ParserMinimalBase;
.source "ParserBase.java"


# static fields
.field static final s:Ljava/math/BigInteger;

.field static final t:Ljava/math/BigInteger;

.field static final u:Ljava/math/BigInteger;

.field static final v:Ljava/math/BigInteger;

.field static final w:Ljava/math/BigDecimal;

.field static final x:Ljava/math/BigDecimal;

.field static final y:Ljava/math/BigDecimal;

.field static final z:Ljava/math/BigDecimal;


# instance fields
.field protected A:I

.field protected B:I

.field protected C:J

.field protected D:D

.field protected E:Ljava/math/BigInteger;

.field protected F:Ljava/math/BigDecimal;

.field protected G:Z

.field protected H:I

.field protected I:I

.field protected J:I

.field protected final b:Lcom/fasterxml/jackson/core/io/IOContext;

.field protected c:Z

.field protected d:I

.field protected e:I

.field protected f:J

.field protected g:I

.field protected h:I

.field protected i:J

.field protected j:I

.field protected k:I

.field protected l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

.field protected m:Lcom/fasterxml/jackson/core/JsonToken;

.field protected final n:Lcom/fasterxml/jackson/core/util/TextBuffer;

.field protected o:[C

.field protected p:Z

.field protected q:Lcom/fasterxml/jackson/core/util/ByteArrayBuilder;

.field protected r:[B


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 194
    const-wide/32 v0, -0x80000000

    invoke-static {v0, v1}, Ljava/math/BigInteger;->valueOf(J)Ljava/math/BigInteger;

    move-result-object v0

    sput-object v0, Lcom/fasterxml/jackson/core/base/ParserBase;->s:Ljava/math/BigInteger;

    .line 195
    const-wide/32 v0, 0x7fffffff

    invoke-static {v0, v1}, Ljava/math/BigInteger;->valueOf(J)Ljava/math/BigInteger;

    move-result-object v0

    sput-object v0, Lcom/fasterxml/jackson/core/base/ParserBase;->t:Ljava/math/BigInteger;

    .line 197
    const-wide/high16 v0, -0x8000000000000000L

    invoke-static {v0, v1}, Ljava/math/BigInteger;->valueOf(J)Ljava/math/BigInteger;

    move-result-object v0

    sput-object v0, Lcom/fasterxml/jackson/core/base/ParserBase;->u:Ljava/math/BigInteger;

    .line 198
    const-wide v0, 0x7fffffffffffffffL

    invoke-static {v0, v1}, Ljava/math/BigInteger;->valueOf(J)Ljava/math/BigInteger;

    move-result-object v0

    sput-object v0, Lcom/fasterxml/jackson/core/base/ParserBase;->v:Ljava/math/BigInteger;

    .line 200
    new-instance v0, Ljava/math/BigDecimal;

    sget-object v1, Lcom/fasterxml/jackson/core/base/ParserBase;->u:Ljava/math/BigInteger;

    invoke-direct {v0, v1}, Ljava/math/BigDecimal;-><init>(Ljava/math/BigInteger;)V

    sput-object v0, Lcom/fasterxml/jackson/core/base/ParserBase;->w:Ljava/math/BigDecimal;

    .line 201
    new-instance v0, Ljava/math/BigDecimal;

    sget-object v1, Lcom/fasterxml/jackson/core/base/ParserBase;->v:Ljava/math/BigInteger;

    invoke-direct {v0, v1}, Ljava/math/BigDecimal;-><init>(Ljava/math/BigInteger;)V

    sput-object v0, Lcom/fasterxml/jackson/core/base/ParserBase;->x:Ljava/math/BigDecimal;

    .line 203
    new-instance v0, Ljava/math/BigDecimal;

    sget-object v1, Lcom/fasterxml/jackson/core/base/ParserBase;->s:Ljava/math/BigInteger;

    invoke-direct {v0, v1}, Ljava/math/BigDecimal;-><init>(Ljava/math/BigInteger;)V

    sput-object v0, Lcom/fasterxml/jackson/core/base/ParserBase;->y:Ljava/math/BigDecimal;

    .line 204
    new-instance v0, Ljava/math/BigDecimal;

    sget-object v1, Lcom/fasterxml/jackson/core/base/ParserBase;->t:Ljava/math/BigInteger;

    invoke-direct {v0, v1}, Ljava/math/BigDecimal;-><init>(Ljava/math/BigInteger;)V

    sput-object v0, Lcom/fasterxml/jackson/core/base/ParserBase;->z:Ljava/math/BigDecimal;

    return-void
.end method

.method protected constructor <init>(Lcom/fasterxml/jackson/core/io/IOContext;I)V
    .locals 6

    .prologue
    const-wide/16 v4, 0x0

    const/4 v2, 0x1

    const/4 v0, 0x0

    const/4 v1, 0x0

    .line 284
    invoke-direct {p0, p2}, Lcom/fasterxml/jackson/core/base/ParserMinimalBase;-><init>(I)V

    .line 53
    iput v1, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->d:I

    .line 58
    iput v1, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->e:I

    .line 70
    iput-wide v4, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->f:J

    .line 76
    iput v2, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->g:I

    .line 84
    iput v1, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->h:I

    .line 100
    iput-wide v4, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->i:J

    .line 105
    iput v2, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->j:I

    .line 111
    iput v1, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->k:I

    .line 150
    iput-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->o:[C

    .line 157
    iput-boolean v1, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->p:Z

    .line 163
    iput-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->q:Lcom/fasterxml/jackson/core/util/ByteArrayBuilder;

    .line 233
    iput v1, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    .line 285
    iput-object p1, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->b:Lcom/fasterxml/jackson/core/io/IOContext;

    .line 286
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/io/IOContext;->d()Lcom/fasterxml/jackson/core/util/TextBuffer;

    move-result-object v1

    iput-object v1, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    .line 287
    sget-object v1, Lcom/fasterxml/jackson/core/JsonParser$Feature;->STRICT_DUPLICATE_DETECTION:Lcom/fasterxml/jackson/core/JsonParser$Feature;

    invoke-virtual {v1, p2}, Lcom/fasterxml/jackson/core/JsonParser$Feature;->enabledIn(I)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {p0}, Lcom/fasterxml/jackson/core/json/DupDetector;->a(Lcom/fasterxml/jackson/core/JsonParser;)Lcom/fasterxml/jackson/core/json/DupDetector;

    move-result-object v0

    .line 289
    :cond_0
    invoke-static {v0}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->a(Lcom/fasterxml/jackson/core/json/DupDetector;)Lcom/fasterxml/jackson/core/json/JsonReadContext;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    .line 290
    return-void
.end method

.method private a(I[CII)V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 859
    iget-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->f()Ljava/lang/String;

    move-result-object v1

    .line 862
    :try_start_0
    iget-boolean v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->G:Z

    invoke-static {p2, p3, p4, v0}, Lcom/fasterxml/jackson/core/io/NumberInput;->a([CIIZ)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 864
    invoke-static {v1}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    iput-wide v2, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->C:J

    .line 865
    const/4 v0, 0x2

    iput v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    .line 875
    :goto_0
    return-void

    .line 868
    :cond_0
    new-instance v0, Ljava/math/BigInteger;

    invoke-direct {v0, v1}, Ljava/math/BigInteger;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->E:Ljava/math/BigInteger;

    .line 869
    const/4 v0, 0x4

    iput v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 871
    :catch_0
    move-exception v0

    .line 873
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Malformed numeric value \'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1, v0}, Lcom/fasterxml/jackson/core/base/ParserBase;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private e(I)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v0, 0x10

    .line 843
    if-ne p1, v0, :cond_0

    .line 844
    :try_start_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->h()Ljava/math/BigDecimal;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->F:Ljava/math/BigDecimal;

    .line 845
    const/16 v0, 0x10

    iput v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    .line 855
    :goto_0
    return-void

    .line 848
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->i()D

    move-result-wide v0

    iput-wide v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->D:D

    .line 849
    const/16 v0, 0x8

    iput v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 851
    :catch_0
    move-exception v0

    .line 853
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Malformed numeric value \'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v2}, Lcom/fasterxml/jackson/core/util/TextBuffer;->f()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1, v0}, Lcom/fasterxml/jackson/core/base/ParserBase;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method


# virtual methods
.method protected A()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 992
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x8

    if-eqz v0, :cond_0

    .line 997
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->f()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/fasterxml/jackson/core/io/NumberInput;->b(Ljava/lang/String;)Ljava/math/BigDecimal;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->F:Ljava/math/BigDecimal;

    .line 1007
    :goto_0
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    or-int/lit8 v0, v0, 0x10

    iput v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    .line 1008
    return-void

    .line 998
    :cond_0
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x4

    if-eqz v0, :cond_1

    .line 999
    new-instance v0, Ljava/math/BigDecimal;

    iget-object v1, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->E:Ljava/math/BigInteger;

    invoke-direct {v0, v1}, Ljava/math/BigDecimal;-><init>(Ljava/math/BigInteger;)V

    iput-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->F:Ljava/math/BigDecimal;

    goto :goto_0

    .line 1000
    :cond_1
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x2

    if-eqz v0, :cond_2

    .line 1001
    iget-wide v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->C:J

    invoke-static {v0, v1}, Ljava/math/BigDecimal;->valueOf(J)Ljava/math/BigDecimal;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->F:Ljava/math/BigDecimal;

    goto :goto_0

    .line 1002
    :cond_2
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x1

    if-eqz v0, :cond_3

    .line 1003
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->B:I

    int-to-long v0, v0

    invoke-static {v0, v1}, Ljava/math/BigDecimal;->valueOf(J)Ljava/math/BigDecimal;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->F:Ljava/math/BigDecimal;

    goto :goto_0

    .line 1005
    :cond_3
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->G()V

    goto :goto_0
.end method

.method protected B()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1029
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Numeric value ("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->f()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ") out of range of int ("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/high16 v1, -0x80000000

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " - "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const v1, 0x7fffffff

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/base/ParserBase;->d(Ljava/lang/String;)V

    .line 1030
    return-void
.end method

.method protected C()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1033
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Numeric value ("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->f()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ") out of range of long ("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-wide/high16 v2, -0x8000000000000000L

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " - "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-wide v2, 0x7fffffffffffffffL

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/base/ParserBase;->d(Ljava/lang/String;)V

    .line 1034
    return-void
.end method

.method protected D()C
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1048
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method protected final a(Ljava/lang/String;D)Lcom/fasterxml/jackson/core/JsonToken;
    .locals 2

    .prologue
    .line 578
    iget-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/core/util/TextBuffer;->a(Ljava/lang/String;)V

    .line 579
    iput-wide p2, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->D:D

    .line 580
    const/16 v0, 0x8

    iput v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    .line 581
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_FLOAT:Lcom/fasterxml/jackson/core/JsonToken;

    return-object v0
.end method

.method protected final a(ZI)Lcom/fasterxml/jackson/core/JsonToken;
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 558
    iput-boolean p1, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->G:Z

    .line 559
    iput p2, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->H:I

    .line 560
    iput v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->I:I

    .line 561
    iput v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->J:I

    .line 562
    iput v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    .line 563
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_INT:Lcom/fasterxml/jackson/core/JsonToken;

    return-object v0
.end method

.method protected final a(ZIII)Lcom/fasterxml/jackson/core/JsonToken;
    .locals 1

    .prologue
    const/4 v0, 0x1

    .line 550
    if-ge p3, v0, :cond_0

    if-ge p4, v0, :cond_0

    .line 551
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/core/base/ParserBase;->a(ZI)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 553
    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0, p1, p2, p3, p4}, Lcom/fasterxml/jackson/core/base/ParserBase;->b(ZIII)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_0
.end method

.method protected a(I)V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x1

    .line 754
    iget-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->K:Lcom/fasterxml/jackson/core/JsonToken;

    sget-object v1, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_INT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v1, :cond_7

    .line 755
    iget-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->e()[C

    move-result-object v1

    .line 756
    iget-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->d()I

    move-result v0

    .line 757
    iget v2, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->H:I

    .line 758
    iget-boolean v3, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->G:Z

    if-eqz v3, :cond_0

    .line 759
    add-int/lit8 v0, v0, 0x1

    .line 761
    :cond_0
    const/16 v3, 0x9

    if-gt v2, v3, :cond_2

    .line 762
    invoke-static {v1, v0, v2}, Lcom/fasterxml/jackson/core/io/NumberInput;->a([CII)I

    move-result v0

    .line 763
    iget-boolean v1, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->G:Z

    if-eqz v1, :cond_1

    neg-int v0, v0

    :cond_1
    iput v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->B:I

    .line 764
    iput v4, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    .line 800
    :goto_0
    return-void

    .line 767
    :cond_2
    const/16 v3, 0x12

    if-gt v2, v3, :cond_6

    .line 768
    invoke-static {v1, v0, v2}, Lcom/fasterxml/jackson/core/io/NumberInput;->b([CII)J

    move-result-wide v0

    .line 769
    iget-boolean v3, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->G:Z

    if-eqz v3, :cond_3

    .line 770
    neg-long v0, v0

    .line 773
    :cond_3
    const/16 v3, 0xa

    if-ne v2, v3, :cond_5

    .line 774
    iget-boolean v2, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->G:Z

    if-eqz v2, :cond_4

    .line 775
    const-wide/32 v2, -0x80000000

    cmp-long v2, v0, v2

    if-ltz v2, :cond_5

    .line 776
    long-to-int v0, v0

    iput v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->B:I

    .line 777
    iput v4, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    goto :goto_0

    .line 781
    :cond_4
    const-wide/32 v2, 0x7fffffff

    cmp-long v2, v0, v2

    if-gtz v2, :cond_5

    .line 782
    long-to-int v0, v0

    iput v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->B:I

    .line 783
    iput v4, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    goto :goto_0

    .line 788
    :cond_5
    iput-wide v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->C:J

    .line 789
    const/4 v0, 0x2

    iput v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    goto :goto_0

    .line 792
    :cond_6
    invoke-direct {p0, p1, v1, v0, v2}, Lcom/fasterxml/jackson/core/base/ParserBase;->a(I[CII)V

    goto :goto_0

    .line 795
    :cond_7
    iget-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->K:Lcom/fasterxml/jackson/core/JsonToken;

    sget-object v1, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_FLOAT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v1, :cond_8

    .line 796
    invoke-direct {p0, p1}, Lcom/fasterxml/jackson/core/base/ParserBase;->e(I)V

    goto :goto_0

    .line 799
    :cond_8
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Current token ("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->K:Lcom/fasterxml/jackson/core/JsonToken;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ") not numeric, can not use numeric value accessors"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/base/ParserBase;->d(Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected a(IC)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/core/JsonParseException;
        }
    .end annotation

    .prologue
    .line 520
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    iget-object v2, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->b:Lcom/fasterxml/jackson/core/io/IOContext;

    invoke-virtual {v2}, Lcom/fasterxml/jackson/core/io/IOContext;->a()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->a(Ljava/lang/Object;)Lcom/fasterxml/jackson/core/JsonLocation;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 521
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unexpected close marker \'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    int-to-char v2, p1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\': expected \'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\' (for "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v2}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->d()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " starting at "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/base/ParserBase;->d(Ljava/lang/String;)V

    .line 522
    return-void
.end method

.method protected a(ILjava/lang/String;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/core/JsonParseException;
        }
    .end annotation

    .prologue
    .line 1017
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Unexpected character ("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {p1}, Lcom/fasterxml/jackson/core/base/ParserBase;->d(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ") in numeric value"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1018
    if-eqz p2, :cond_0

    .line 1019
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ": "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1021
    :cond_0
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/base/ParserBase;->d(Ljava/lang/String;)V

    .line 1022
    return-void
.end method

.method protected final b(ZIII)Lcom/fasterxml/jackson/core/JsonToken;
    .locals 1

    .prologue
    .line 568
    iput-boolean p1, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->G:Z

    .line 569
    iput p2, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->H:I

    .line 570
    iput p3, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->I:I

    .line 571
    iput p4, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->J:I

    .line 572
    const/4 v0, 0x0

    iput v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    .line 573
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_FLOAT:Lcom/fasterxml/jackson/core/JsonToken;

    return-object v0
.end method

.method protected b(Ljava/lang/String;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/core/JsonParseException;
        }
    .end annotation

    .prologue
    .line 1025
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Invalid numeric value: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/base/ParserBase;->d(Ljava/lang/String;)V

    .line 1026
    return-void
.end method

.method public close()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 382
    iget-boolean v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->c:Z

    if-nez v0, :cond_0

    .line 383
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->c:Z

    .line 385
    :try_start_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->r()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 389
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->s()V

    .line 392
    :cond_0
    return-void

    .line 389
    :catchall_0
    move-exception v0

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->s()V

    throw v0
.end method

.method public d()Ljava/lang/String;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 358
    iget-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->K:Lcom/fasterxml/jackson/core/JsonToken;

    sget-object v1, Lcom/fasterxml/jackson/core/JsonToken;->START_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->K:Lcom/fasterxml/jackson/core/JsonToken;

    sget-object v1, Lcom/fasterxml/jackson/core/JsonToken;->START_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v1, :cond_1

    .line 359
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->h()Lcom/fasterxml/jackson/core/json/JsonReadContext;

    move-result-object v0

    .line 360
    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->g()Ljava/lang/String;

    move-result-object v0

    .line 362
    :goto_0
    return-object v0

    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->g()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public e()Lcom/fasterxml/jackson/core/JsonLocation;
    .locals 10

    .prologue
    .line 416
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->h:I

    sub-int/2addr v0, v1

    add-int/lit8 v7, v0, 0x1

    .line 417
    new-instance v0, Lcom/fasterxml/jackson/core/JsonLocation;

    iget-object v1, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->b:Lcom/fasterxml/jackson/core/io/IOContext;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/io/IOContext;->a()Ljava/lang/Object;

    move-result-object v1

    const-wide/16 v2, -0x1

    iget-wide v4, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->f:J

    iget v6, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->d:I

    int-to-long v8, v6

    add-long/2addr v4, v8

    iget v6, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->g:I

    invoke-direct/range {v0 .. v7}, Lcom/fasterxml/jackson/core/JsonLocation;-><init>(Ljava/lang/Object;JJII)V

    return-object v0
.end method

.method public i()I
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 654
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x1

    if-nez v0, :cond_1

    .line 655
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    if-nez v0, :cond_0

    .line 656
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->v()I

    move-result v0

    .line 662
    :goto_0
    return v0

    .line 658
    :cond_0
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x1

    if-nez v0, :cond_1

    .line 659
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->w()V

    .line 662
    :cond_1
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->B:I

    goto :goto_0
.end method

.method public j()J
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 668
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x2

    if-nez v0, :cond_1

    .line 669
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    if-nez v0, :cond_0

    .line 670
    const/4 v0, 0x2

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/base/ParserBase;->a(I)V

    .line 672
    :cond_0
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x2

    if-nez v0, :cond_1

    .line 673
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->x()V

    .line 676
    :cond_1
    iget-wide v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->C:J

    return-wide v0
.end method

.method public k()Ljava/math/BigInteger;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 682
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x4

    if-nez v0, :cond_1

    .line 683
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    if-nez v0, :cond_0

    .line 684
    const/4 v0, 0x4

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/base/ParserBase;->a(I)V

    .line 686
    :cond_0
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x4

    if-nez v0, :cond_1

    .line 687
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->y()V

    .line 690
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->E:Ljava/math/BigInteger;

    return-object v0
.end method

.method public l()F
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 696
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->m()D

    move-result-wide v0

    .line 705
    double-to-float v0, v0

    return v0
.end method

.method public m()D
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 711
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x8

    if-nez v0, :cond_1

    .line 712
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    if-nez v0, :cond_0

    .line 713
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/base/ParserBase;->a(I)V

    .line 715
    :cond_0
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x8

    if-nez v0, :cond_1

    .line 716
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->z()V

    .line 719
    :cond_1
    iget-wide v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->D:D

    return-wide v0
.end method

.method public n()Ljava/math/BigDecimal;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 725
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x10

    if-nez v0, :cond_1

    .line 726
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    if-nez v0, :cond_0

    .line 727
    const/16 v0, 0x10

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/base/ParserBase;->a(I)V

    .line 729
    :cond_0
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x10

    if-nez v0, :cond_1

    .line 730
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->A()V

    .line 733
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->F:Ljava/math/BigDecimal;

    return-object v0
.end method

.method protected final o()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 459
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->p()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->E()V

    .line 460
    :cond_0
    return-void
.end method

.method protected abstract p()Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method protected abstract q()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method protected abstract r()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method protected s()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 485
    iget-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->a()V

    .line 486
    iget-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->o:[C

    .line 487
    if-eqz v0, :cond_0

    .line 488
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->o:[C

    .line 489
    iget-object v1, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->b:Lcom/fasterxml/jackson/core/io/IOContext;

    invoke-virtual {v1, v0}, Lcom/fasterxml/jackson/core/io/IOContext;->c([C)V

    .line 491
    :cond_0
    return-void
.end method

.method protected t()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/core/JsonParseException;
        }
    .end annotation

    .prologue
    .line 500
    iget-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->b()Z

    move-result v0

    if-nez v0, :cond_0

    .line 501
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, ": expected close marker for "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->d()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " (from "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    iget-object v2, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->b:Lcom/fasterxml/jackson/core/io/IOContext;

    invoke-virtual {v2}, Lcom/fasterxml/jackson/core/io/IOContext;->a()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->a(Ljava/lang/Object;)Lcom/fasterxml/jackson/core/JsonLocation;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/base/ParserBase;->c(Ljava/lang/String;)V

    .line 503
    :cond_0
    return-void
.end method

.method protected final u()I
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/core/JsonParseException;
        }
    .end annotation

    .prologue
    .line 509
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->t()V

    .line 510
    const/4 v0, -0x1

    return v0
.end method

.method protected v()I
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x1

    .line 809
    iget-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->K:Lcom/fasterxml/jackson/core/JsonToken;

    sget-object v1, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_INT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v1, :cond_2

    .line 810
    iget-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->e()[C

    move-result-object v1

    .line 811
    iget-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->d()I

    move-result v0

    .line 812
    iget v2, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->H:I

    .line 813
    iget-boolean v3, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->G:Z

    if-eqz v3, :cond_0

    .line 814
    add-int/lit8 v0, v0, 0x1

    .line 816
    :cond_0
    const/16 v3, 0x9

    if-gt v2, v3, :cond_2

    .line 817
    invoke-static {v1, v0, v2}, Lcom/fasterxml/jackson/core/io/NumberInput;->a([CII)I

    move-result v0

    .line 818
    iget-boolean v1, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->G:Z

    if-eqz v1, :cond_1

    .line 819
    neg-int v0, v0

    .line 821
    :cond_1
    iput v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->B:I

    .line 822
    iput v4, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    .line 830
    :goto_0
    return v0

    .line 826
    :cond_2
    invoke-virtual {p0, v4}, Lcom/fasterxml/jackson/core/base/ParserBase;->a(I)V

    .line 827
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x1

    if-nez v0, :cond_3

    .line 828
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->w()V

    .line 830
    :cond_3
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->B:I

    goto :goto_0
.end method

.method protected w()V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 886
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x2

    if-eqz v0, :cond_1

    .line 888
    iget-wide v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->C:J

    long-to-int v0, v0

    .line 889
    int-to-long v2, v0

    iget-wide v4, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->C:J

    cmp-long v1, v2, v4

    if-eqz v1, :cond_0

    .line 890
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Numeric value ("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->f()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ") out of range of int"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/fasterxml/jackson/core/base/ParserBase;->d(Ljava/lang/String;)V

    .line 892
    :cond_0
    iput v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->B:I

    .line 914
    :goto_0
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    or-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    .line 915
    return-void

    .line 893
    :cond_1
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x4

    if-eqz v0, :cond_4

    .line 894
    sget-object v0, Lcom/fasterxml/jackson/core/base/ParserBase;->s:Ljava/math/BigInteger;

    iget-object v1, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->E:Ljava/math/BigInteger;

    invoke-virtual {v0, v1}, Ljava/math/BigInteger;->compareTo(Ljava/math/BigInteger;)I

    move-result v0

    if-gtz v0, :cond_2

    sget-object v0, Lcom/fasterxml/jackson/core/base/ParserBase;->t:Ljava/math/BigInteger;

    iget-object v1, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->E:Ljava/math/BigInteger;

    invoke-virtual {v0, v1}, Ljava/math/BigInteger;->compareTo(Ljava/math/BigInteger;)I

    move-result v0

    if-gez v0, :cond_3

    .line 896
    :cond_2
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->B()V

    .line 898
    :cond_3
    iget-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->E:Ljava/math/BigInteger;

    invoke-virtual {v0}, Ljava/math/BigInteger;->intValue()I

    move-result v0

    iput v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->B:I

    goto :goto_0

    .line 899
    :cond_4
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x8

    if-eqz v0, :cond_7

    .line 901
    iget-wide v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->D:D

    const-wide/high16 v2, -0x3e20000000000000L    # -2.147483648E9

    cmpg-double v0, v0, v2

    if-ltz v0, :cond_5

    iget-wide v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->D:D

    const-wide v2, 0x41dfffffffc00000L    # 2.147483647E9

    cmpl-double v0, v0, v2

    if-lez v0, :cond_6

    .line 902
    :cond_5
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->B()V

    .line 904
    :cond_6
    iget-wide v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->D:D

    double-to-int v0, v0

    iput v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->B:I

    goto :goto_0

    .line 905
    :cond_7
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x10

    if-eqz v0, :cond_a

    .line 906
    sget-object v0, Lcom/fasterxml/jackson/core/base/ParserBase;->y:Ljava/math/BigDecimal;

    iget-object v1, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->F:Ljava/math/BigDecimal;

    invoke-virtual {v0, v1}, Ljava/math/BigDecimal;->compareTo(Ljava/math/BigDecimal;)I

    move-result v0

    if-gtz v0, :cond_8

    sget-object v0, Lcom/fasterxml/jackson/core/base/ParserBase;->z:Ljava/math/BigDecimal;

    iget-object v1, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->F:Ljava/math/BigDecimal;

    invoke-virtual {v0, v1}, Ljava/math/BigDecimal;->compareTo(Ljava/math/BigDecimal;)I

    move-result v0

    if-gez v0, :cond_9

    .line 908
    :cond_8
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->B()V

    .line 910
    :cond_9
    iget-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->F:Ljava/math/BigDecimal;

    invoke-virtual {v0}, Ljava/math/BigDecimal;->intValue()I

    move-result v0

    iput v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->B:I

    goto :goto_0

    .line 912
    :cond_a
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->G()V

    goto :goto_0
.end method

.method protected x()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 919
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x1

    if-eqz v0, :cond_0

    .line 920
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->B:I

    int-to-long v0, v0

    iput-wide v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->C:J

    .line 942
    :goto_0
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    or-int/lit8 v0, v0, 0x2

    iput v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    .line 943
    return-void

    .line 921
    :cond_0
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x4

    if-eqz v0, :cond_3

    .line 922
    sget-object v0, Lcom/fasterxml/jackson/core/base/ParserBase;->u:Ljava/math/BigInteger;

    iget-object v1, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->E:Ljava/math/BigInteger;

    invoke-virtual {v0, v1}, Ljava/math/BigInteger;->compareTo(Ljava/math/BigInteger;)I

    move-result v0

    if-gtz v0, :cond_1

    sget-object v0, Lcom/fasterxml/jackson/core/base/ParserBase;->v:Ljava/math/BigInteger;

    iget-object v1, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->E:Ljava/math/BigInteger;

    invoke-virtual {v0, v1}, Ljava/math/BigInteger;->compareTo(Ljava/math/BigInteger;)I

    move-result v0

    if-gez v0, :cond_2

    .line 924
    :cond_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->C()V

    .line 926
    :cond_2
    iget-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->E:Ljava/math/BigInteger;

    invoke-virtual {v0}, Ljava/math/BigInteger;->longValue()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->C:J

    goto :goto_0

    .line 927
    :cond_3
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x8

    if-eqz v0, :cond_6

    .line 929
    iget-wide v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->D:D

    const-wide/high16 v2, -0x3c20000000000000L    # -9.223372036854776E18

    cmpg-double v0, v0, v2

    if-ltz v0, :cond_4

    iget-wide v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->D:D

    const-wide/high16 v2, 0x43e0000000000000L    # 9.223372036854776E18

    cmpl-double v0, v0, v2

    if-lez v0, :cond_5

    .line 930
    :cond_4
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->C()V

    .line 932
    :cond_5
    iget-wide v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->D:D

    double-to-long v0, v0

    iput-wide v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->C:J

    goto :goto_0

    .line 933
    :cond_6
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x10

    if-eqz v0, :cond_9

    .line 934
    sget-object v0, Lcom/fasterxml/jackson/core/base/ParserBase;->w:Ljava/math/BigDecimal;

    iget-object v1, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->F:Ljava/math/BigDecimal;

    invoke-virtual {v0, v1}, Ljava/math/BigDecimal;->compareTo(Ljava/math/BigDecimal;)I

    move-result v0

    if-gtz v0, :cond_7

    sget-object v0, Lcom/fasterxml/jackson/core/base/ParserBase;->x:Ljava/math/BigDecimal;

    iget-object v1, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->F:Ljava/math/BigDecimal;

    invoke-virtual {v0, v1}, Ljava/math/BigDecimal;->compareTo(Ljava/math/BigDecimal;)I

    move-result v0

    if-gez v0, :cond_8

    .line 936
    :cond_7
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->C()V

    .line 938
    :cond_8
    iget-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->F:Ljava/math/BigDecimal;

    invoke-virtual {v0}, Ljava/math/BigDecimal;->longValue()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->C:J

    goto :goto_0

    .line 940
    :cond_9
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->G()V

    goto :goto_0
.end method

.method protected y()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 947
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x10

    if-eqz v0, :cond_0

    .line 949
    iget-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->F:Ljava/math/BigDecimal;

    invoke-virtual {v0}, Ljava/math/BigDecimal;->toBigInteger()Ljava/math/BigInteger;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->E:Ljava/math/BigInteger;

    .line 959
    :goto_0
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    or-int/lit8 v0, v0, 0x4

    iput v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    .line 960
    return-void

    .line 950
    :cond_0
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x2

    if-eqz v0, :cond_1

    .line 951
    iget-wide v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->C:J

    invoke-static {v0, v1}, Ljava/math/BigInteger;->valueOf(J)Ljava/math/BigInteger;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->E:Ljava/math/BigInteger;

    goto :goto_0

    .line 952
    :cond_1
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x1

    if-eqz v0, :cond_2

    .line 953
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->B:I

    int-to-long v0, v0

    invoke-static {v0, v1}, Ljava/math/BigInteger;->valueOf(J)Ljava/math/BigInteger;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->E:Ljava/math/BigInteger;

    goto :goto_0

    .line 954
    :cond_2
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x8

    if-eqz v0, :cond_3

    .line 955
    iget-wide v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->D:D

    invoke-static {v0, v1}, Ljava/math/BigDecimal;->valueOf(D)Ljava/math/BigDecimal;

    move-result-object v0

    invoke-virtual {v0}, Ljava/math/BigDecimal;->toBigInteger()Ljava/math/BigInteger;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->E:Ljava/math/BigInteger;

    goto :goto_0

    .line 957
    :cond_3
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->G()V

    goto :goto_0
.end method

.method protected z()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 970
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x10

    if-eqz v0, :cond_0

    .line 971
    iget-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->F:Ljava/math/BigDecimal;

    invoke-virtual {v0}, Ljava/math/BigDecimal;->doubleValue()D

    move-result-wide v0

    iput-wide v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->D:D

    .line 981
    :goto_0
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    or-int/lit8 v0, v0, 0x8

    iput v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    .line 982
    return-void

    .line 972
    :cond_0
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x4

    if-eqz v0, :cond_1

    .line 973
    iget-object v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->E:Ljava/math/BigInteger;

    invoke-virtual {v0}, Ljava/math/BigInteger;->doubleValue()D

    move-result-wide v0

    iput-wide v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->D:D

    goto :goto_0

    .line 974
    :cond_1
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x2

    if-eqz v0, :cond_2

    .line 975
    iget-wide v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->C:J

    long-to-double v0, v0

    iput-wide v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->D:D

    goto :goto_0

    .line 976
    :cond_2
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->A:I

    and-int/lit8 v0, v0, 0x1

    if-eqz v0, :cond_3

    .line 977
    iget v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->B:I

    int-to-double v0, v0

    iput-wide v0, p0, Lcom/fasterxml/jackson/core/base/ParserBase;->D:D

    goto :goto_0

    .line 979
    :cond_3
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->G()V

    goto :goto_0
.end method
