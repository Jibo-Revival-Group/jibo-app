.class public Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;
.super Lcom/fasterxml/jackson/core/base/ParserBase;
.source "ReaderBasedJsonParser.java"


# static fields
.field protected static final L:[I


# instance fields
.field protected M:Ljava/io/Reader;

.field protected N:[C

.field protected O:Z

.field protected P:Lcom/fasterxml/jackson/core/ObjectCodec;

.field protected final Q:Lcom/fasterxml/jackson/core/sym/CharsToNameCanonicalizer;

.field protected final R:I

.field protected S:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 24
    invoke-static {}, Lcom/fasterxml/jackson/core/io/CharTypes;->a()[I

    move-result-object v0

    sput-object v0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->L:[I

    return-void
.end method

.method public constructor <init>(Lcom/fasterxml/jackson/core/io/IOContext;ILjava/io/Reader;Lcom/fasterxml/jackson/core/ObjectCodec;Lcom/fasterxml/jackson/core/sym/CharsToNameCanonicalizer;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 114
    invoke-direct {p0, p1, p2}, Lcom/fasterxml/jackson/core/base/ParserBase;-><init>(Lcom/fasterxml/jackson/core/io/IOContext;I)V

    .line 77
    iput-boolean v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->S:Z

    .line 115
    iput-object p3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->M:Ljava/io/Reader;

    .line 116
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/io/IOContext;->g()[C

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    .line 117
    iput v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 118
    iput v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    .line 119
    iput-object p4, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->P:Lcom/fasterxml/jackson/core/ObjectCodec;

    .line 120
    iput-object p5, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->Q:Lcom/fasterxml/jackson/core/sym/CharsToNameCanonicalizer;

    .line 121
    invoke-virtual {p5}, Lcom/fasterxml/jackson/core/sym/CharsToNameCanonicalizer;->e()I

    move-result v0

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->R:I

    .line 122
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->O:Z

    .line 123
    return-void
.end method

.method public constructor <init>(Lcom/fasterxml/jackson/core/io/IOContext;ILjava/io/Reader;Lcom/fasterxml/jackson/core/ObjectCodec;Lcom/fasterxml/jackson/core/sym/CharsToNameCanonicalizer;[CIIZ)V
    .locals 1

    .prologue
    .line 96
    invoke-direct {p0, p1, p2}, Lcom/fasterxml/jackson/core/base/ParserBase;-><init>(Lcom/fasterxml/jackson/core/io/IOContext;I)V

    .line 77
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->S:Z

    .line 97
    iput-object p3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->M:Ljava/io/Reader;

    .line 98
    iput-object p6, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    .line 99
    iput p7, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 100
    iput p8, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    .line 101
    iput-object p4, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->P:Lcom/fasterxml/jackson/core/ObjectCodec;

    .line 102
    iput-object p5, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->Q:Lcom/fasterxml/jackson/core/sym/CharsToNameCanonicalizer;

    .line 103
    invoke-virtual {p5}, Lcom/fasterxml/jackson/core/sym/CharsToNameCanonicalizer;->e()I

    move-result v0

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->R:I

    .line 104
    iput-boolean p9, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->O:Z

    .line 105
    return-void
.end method

.method private final O()Lcom/fasterxml/jackson/core/JsonToken;
    .locals 4

    .prologue
    .line 703
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->p:Z

    .line 704
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->m:Lcom/fasterxml/jackson/core/JsonToken;

    .line 705
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->m:Lcom/fasterxml/jackson/core/JsonToken;

    .line 707
    sget-object v1, Lcom/fasterxml/jackson/core/JsonToken;->START_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v1, :cond_1

    .line 708
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->j:I

    iget v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->k:I

    invoke-virtual {v1, v2, v3}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->a(II)Lcom/fasterxml/jackson/core/json/JsonReadContext;

    move-result-object v1

    iput-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    .line 712
    :cond_0
    :goto_0
    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->K:Lcom/fasterxml/jackson/core/JsonToken;

    return-object v0

    .line 709
    :cond_1
    sget-object v1, Lcom/fasterxml/jackson/core/JsonToken;->START_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v1, :cond_0

    .line 710
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->j:I

    iget v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->k:I

    invoke-virtual {v1, v2, v3}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->b(II)Lcom/fasterxml/jackson/core/json/JsonReadContext;

    move-result-object v1

    iput-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    goto :goto_0
.end method

.method private final P()C
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v0, 0x30

    .line 1305
    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-ge v1, v2, :cond_1

    .line 1306
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v1, v1, v2

    .line 1308
    if-lt v1, v0, :cond_0

    const/16 v2, 0x39

    if-le v1, v2, :cond_1

    .line 1313
    :cond_0
    :goto_0
    return v0

    :cond_1
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->Q()C

    move-result v0

    goto :goto_0
.end method

.method private Q()C
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v4, 0x39

    const/16 v1, 0x30

    .line 1318
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-lt v0, v2, :cond_1

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->p()Z

    move-result v0

    if-nez v0, :cond_1

    move v0, v1

    .line 1342
    :cond_0
    :goto_0
    return v0

    .line 1321
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v0, v0, v2

    .line 1322
    if-lt v0, v1, :cond_2

    if-le v0, v4, :cond_3

    :cond_2
    move v0, v1

    .line 1323
    goto :goto_0

    .line 1325
    :cond_3
    sget-object v2, Lcom/fasterxml/jackson/core/JsonParser$Feature;->ALLOW_NUMERIC_LEADING_ZEROS:Lcom/fasterxml/jackson/core/JsonParser$Feature;

    invoke-virtual {p0, v2}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Lcom/fasterxml/jackson/core/JsonParser$Feature;)Z

    move-result v2

    if-nez v2, :cond_4

    .line 1326
    const-string v2, "Leading zeroes not allowed"

    invoke-virtual {p0, v2}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->b(Ljava/lang/String;)V

    .line 1329
    :cond_4
    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1330
    if-ne v0, v1, :cond_0

    .line 1331
    :cond_5
    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-lt v2, v3, :cond_6

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->p()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1332
    :cond_6
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v0, v0, v2

    .line 1333
    if-lt v0, v1, :cond_7

    if-le v0, v4, :cond_8

    :cond_7
    move v0, v1

    .line 1334
    goto :goto_0

    .line 1336
    :cond_8
    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1337
    if-eq v0, v1, :cond_5

    goto :goto_0
.end method

.method private final R()I
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v6, 0x9

    const/16 v5, 0x2f

    const/16 v4, 0x23

    const/4 v3, 0x1

    const/16 v2, 0x20

    .line 1859
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v0, v0, 0x4

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-lt v0, v1, :cond_0

    .line 1860
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Z)I

    move-result v0

    .line 1908
    :goto_0
    return v0

    .line 1862
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v0, v0, v1

    .line 1863
    const/16 v1, 0x3a

    if-ne v0, v1, :cond_8

    .line 1864
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v0, v0, v1

    .line 1865
    if-le v0, v2, :cond_3

    .line 1866
    if-eq v0, v5, :cond_1

    if-ne v0, v4, :cond_2

    .line 1867
    :cond_1
    invoke-direct {p0, v3}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Z)I

    move-result v0

    goto :goto_0

    .line 1869
    :cond_2
    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    goto :goto_0

    .line 1872
    :cond_3
    if-eq v0, v2, :cond_4

    if-ne v0, v6, :cond_7

    .line 1873
    :cond_4
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v0, v0, v1

    .line 1874
    if-le v0, v2, :cond_7

    .line 1875
    if-eq v0, v5, :cond_5

    if-ne v0, v4, :cond_6

    .line 1876
    :cond_5
    invoke-direct {p0, v3}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Z)I

    move-result v0

    goto :goto_0

    .line 1878
    :cond_6
    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    goto :goto_0

    .line 1882
    :cond_7
    invoke-direct {p0, v3}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Z)I

    move-result v0

    goto :goto_0

    .line 1884
    :cond_8
    if-eq v0, v2, :cond_9

    if-ne v0, v6, :cond_a

    .line 1885
    :cond_9
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v0, v0, v1

    .line 1887
    :cond_a
    const/16 v1, 0x3a

    if-ne v0, v1, :cond_12

    .line 1888
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v0, v0, v1

    .line 1889
    if-le v0, v2, :cond_d

    .line 1890
    if-eq v0, v5, :cond_b

    if-ne v0, v4, :cond_c

    .line 1891
    :cond_b
    invoke-direct {p0, v3}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Z)I

    move-result v0

    goto :goto_0

    .line 1893
    :cond_c
    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    goto :goto_0

    .line 1896
    :cond_d
    if-eq v0, v2, :cond_e

    if-ne v0, v6, :cond_11

    .line 1897
    :cond_e
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v0, v0, v1

    .line 1898
    if-le v0, v2, :cond_11

    .line 1899
    if-eq v0, v5, :cond_f

    if-ne v0, v4, :cond_10

    .line 1900
    :cond_f
    invoke-direct {p0, v3}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Z)I

    move-result v0

    goto/16 :goto_0

    .line 1902
    :cond_10
    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    goto/16 :goto_0

    .line 1906
    :cond_11
    invoke-direct {p0, v3}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Z)I

    move-result v0

    goto/16 :goto_0

    .line 1908
    :cond_12
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Z)I

    move-result v0

    goto/16 :goto_0
.end method

.method private final S()I
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v3, 0x20

    .line 1984
    :cond_0
    :goto_0
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-lt v0, v1, :cond_1

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->p()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 1985
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v0, v0, v1

    .line 1986
    if-le v0, v3, :cond_4

    .line 1987
    const/16 v1, 0x2f

    if-ne v0, v1, :cond_2

    .line 1988
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->V()V

    goto :goto_0

    .line 1991
    :cond_2
    const/16 v1, 0x23

    if-ne v0, v1, :cond_3

    .line 1992
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->X()Z

    move-result v1

    if-nez v1, :cond_0

    .line 1996
    :cond_3
    return v0

    .line 1998
    :cond_4
    if-ge v0, v3, :cond_0

    .line 1999
    const/16 v1, 0xa

    if-ne v0, v1, :cond_5

    .line 2000
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->g:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->g:I

    .line 2001
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->h:I

    goto :goto_0

    .line 2002
    :cond_5
    const/16 v1, 0xd

    if-ne v0, v1, :cond_6

    .line 2003
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N()V

    goto :goto_0

    .line 2004
    :cond_6
    const/16 v1, 0x9

    if-eq v0, v1, :cond_0

    .line 2005
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->c(I)V

    goto :goto_0

    .line 2009
    :cond_7
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Unexpected end-of-input within/between "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->d()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " entries"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Ljava/lang/String;)Lcom/fasterxml/jackson/core/JsonParseException;

    move-result-object v0

    throw v0
.end method

.method private final T()I
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v7, 0x23

    const/16 v6, 0xd

    const/16 v5, 0xa

    const/16 v4, 0x9

    const/16 v3, 0x20

    .line 2016
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-lt v0, v1, :cond_1

    .line 2017
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->p()Z

    move-result v0

    if-nez v0, :cond_1

    .line 2018
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->u()I

    move-result v0

    .line 2060
    :cond_0
    :goto_0
    return v0

    .line 2021
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v0, v0, v1

    .line 2022
    if-le v0, v3, :cond_3

    .line 2023
    const/16 v1, 0x2f

    if-eq v0, v1, :cond_2

    if-ne v0, v7, :cond_0

    .line 2024
    :cond_2
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 2025
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->U()I

    move-result v0

    goto :goto_0

    .line 2029
    :cond_3
    if-eq v0, v3, :cond_4

    .line 2030
    if-ne v0, v5, :cond_6

    .line 2031
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->g:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->g:I

    .line 2032
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->h:I

    .line 2040
    :cond_4
    :goto_1
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-ge v0, v1, :cond_b

    .line 2041
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v0, v0, v1

    .line 2042
    if-le v0, v3, :cond_8

    .line 2043
    const/16 v1, 0x2f

    if-eq v0, v1, :cond_5

    if-ne v0, v7, :cond_0

    .line 2044
    :cond_5
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 2045
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->U()I

    move-result v0

    goto :goto_0

    .line 2033
    :cond_6
    if-ne v0, v6, :cond_7

    .line 2034
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N()V

    goto :goto_1

    .line 2035
    :cond_7
    if-eq v0, v4, :cond_4

    .line 2036
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->c(I)V

    goto :goto_1

    .line 2049
    :cond_8
    if-eq v0, v3, :cond_4

    .line 2050
    if-ne v0, v5, :cond_9

    .line 2051
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->g:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->g:I

    .line 2052
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->h:I

    goto :goto_1

    .line 2053
    :cond_9
    if-ne v0, v6, :cond_a

    .line 2054
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N()V

    goto :goto_1

    .line 2055
    :cond_a
    if-eq v0, v4, :cond_4

    .line 2056
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->c(I)V

    goto :goto_1

    .line 2060
    :cond_b
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->U()I

    move-result v0

    goto :goto_0
.end method

.method private U()I
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v3, 0x20

    .line 2066
    :cond_0
    :goto_0
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-lt v0, v1, :cond_2

    .line 2067
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->p()Z

    move-result v0

    if-nez v0, :cond_2

    .line 2068
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->u()I

    move-result v0

    .line 2082
    :cond_1
    return v0

    .line 2071
    :cond_2
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v0, v0, v1

    .line 2072
    if-le v0, v3, :cond_4

    .line 2073
    const/16 v1, 0x2f

    if-ne v0, v1, :cond_3

    .line 2074
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->V()V

    goto :goto_0

    .line 2077
    :cond_3
    const/16 v1, 0x23

    if-ne v0, v1, :cond_1

    .line 2078
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->X()Z

    move-result v1

    if-eqz v1, :cond_1

    goto :goto_0

    .line 2083
    :cond_4
    if-eq v0, v3, :cond_0

    .line 2084
    const/16 v1, 0xa

    if-ne v0, v1, :cond_5

    .line 2085
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->g:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->g:I

    .line 2086
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->h:I

    goto :goto_0

    .line 2087
    :cond_5
    const/16 v1, 0xd

    if-ne v0, v1, :cond_6

    .line 2088
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N()V

    goto :goto_0

    .line 2089
    :cond_6
    const/16 v1, 0x9

    if-eq v0, v1, :cond_0

    .line 2090
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->c(I)V

    goto :goto_0
.end method

.method private V()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v3, 0x2f

    .line 2098
    sget-object v0, Lcom/fasterxml/jackson/core/JsonParser$Feature;->ALLOW_COMMENTS:Lcom/fasterxml/jackson/core/JsonParser$Feature;

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Lcom/fasterxml/jackson/core/JsonParser$Feature;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 2099
    const-string v0, "maybe a (non-standard) comment? (not recognized as one since Feature \'ALLOW_COMMENTS\' not enabled for parser)"

    invoke-virtual {p0, v3, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->b(ILjava/lang/String;)V

    .line 2102
    :cond_0
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-lt v0, v1, :cond_1

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->p()Z

    move-result v0

    if-nez v0, :cond_1

    .line 2103
    const-string v0, " in a comment"

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->c(Ljava/lang/String;)V

    .line 2105
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v0, v0, v1

    .line 2106
    if-ne v0, v3, :cond_2

    .line 2107
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->Y()V

    .line 2113
    :goto_0
    return-void

    .line 2108
    :cond_2
    const/16 v1, 0x2a

    if-ne v0, v1, :cond_3

    .line 2109
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->W()V

    goto :goto_0

    .line 2111
    :cond_3
    const-string v1, "was expecting either \'*\' or \'/\' for a comment"

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->b(ILjava/lang/String;)V

    goto :goto_0
.end method

.method private W()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v3, 0x2a

    .line 2118
    :cond_0
    :goto_0
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-lt v0, v1, :cond_1

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->p()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 2119
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v0, v0, v1

    .line 2120
    if-gt v0, v3, :cond_0

    .line 2121
    if-ne v0, v3, :cond_4

    .line 2122
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-lt v0, v1, :cond_3

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->p()Z

    move-result v0

    if-nez v0, :cond_3

    .line 2143
    :cond_2
    const-string v0, " in a comment"

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->c(Ljava/lang/String;)V

    .line 2144
    :goto_1
    return-void

    .line 2125
    :cond_3
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v0, v0, v1

    const/16 v1, 0x2f

    if-ne v0, v1, :cond_0

    .line 2126
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    goto :goto_1

    .line 2131
    :cond_4
    const/16 v1, 0x20

    if-ge v0, v1, :cond_0

    .line 2132
    const/16 v1, 0xa

    if-ne v0, v1, :cond_5

    .line 2133
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->g:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->g:I

    .line 2134
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->h:I

    goto :goto_0

    .line 2135
    :cond_5
    const/16 v1, 0xd

    if-ne v0, v1, :cond_6

    .line 2136
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N()V

    goto :goto_0

    .line 2137
    :cond_6
    const/16 v1, 0x9

    if-eq v0, v1, :cond_0

    .line 2138
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->c(I)V

    goto :goto_0
.end method

.method private X()Z
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2148
    sget-object v0, Lcom/fasterxml/jackson/core/JsonParser$Feature;->ALLOW_YAML_COMMENTS:Lcom/fasterxml/jackson/core/JsonParser$Feature;

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Lcom/fasterxml/jackson/core/JsonParser$Feature;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 2149
    const/4 v0, 0x0

    .line 2152
    :goto_0
    return v0

    .line 2151
    :cond_0
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->Y()V

    .line 2152
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private Y()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2158
    :cond_0
    :goto_0
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-lt v0, v1, :cond_1

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->p()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 2159
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v0, v0, v1

    .line 2160
    const/16 v1, 0x20

    if-ge v0, v1, :cond_0

    .line 2161
    const/16 v1, 0xa

    if-ne v0, v1, :cond_3

    .line 2162
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->g:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->g:I

    .line 2163
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->h:I

    .line 2173
    :cond_2
    :goto_1
    return-void

    .line 2165
    :cond_3
    const/16 v1, 0xd

    if-ne v0, v1, :cond_4

    .line 2166
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N()V

    goto :goto_1

    .line 2168
    :cond_4
    const/16 v1, 0x9

    if-eq v0, v1, :cond_0

    .line 2169
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->c(I)V

    goto :goto_0
.end method

.method private final Z()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2230
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 2231
    add-int/lit8 v1, v0, 0x3

    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-ge v1, v2, :cond_1

    .line 2232
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    .line 2233
    aget-char v2, v1, v0

    const/16 v3, 0x72

    if-ne v2, v3, :cond_1

    add-int/lit8 v0, v0, 0x1

    aget-char v2, v1, v0

    const/16 v3, 0x75

    if-ne v2, v3, :cond_1

    add-int/lit8 v0, v0, 0x1

    aget-char v2, v1, v0

    const/16 v3, 0x65

    if-ne v2, v3, :cond_1

    .line 2234
    add-int/lit8 v0, v0, 0x1

    aget-char v1, v1, v0

    .line 2235
    const/16 v2, 0x30

    if-lt v1, v2, :cond_0

    const/16 v2, 0x5d

    if-eq v1, v2, :cond_0

    const/16 v2, 0x7d

    if-ne v1, v2, :cond_1

    .line 2236
    :cond_0
    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 2243
    :goto_0
    return-void

    .line 2242
    :cond_1
    const-string v0, "true"

    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Ljava/lang/String;I)V

    goto :goto_0
.end method

.method private final a(Z)I
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v3, 0x20

    .line 1914
    :cond_0
    :goto_0
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-lt v0, v1, :cond_1

    .line 1915
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->o()V

    .line 1917
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v0, v0, v1

    .line 1918
    if-le v0, v3, :cond_7

    .line 1919
    const/16 v1, 0x2f

    if-ne v0, v1, :cond_2

    .line 1920
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->V()V

    goto :goto_0

    .line 1923
    :cond_2
    const/16 v1, 0x23

    if-ne v0, v1, :cond_3

    .line 1924
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->X()Z

    move-result v1

    if-nez v1, :cond_0

    .line 1928
    :cond_3
    if-eqz p1, :cond_4

    .line 1929
    return v0

    .line 1931
    :cond_4
    const/16 v1, 0x3a

    if-eq v0, v1, :cond_6

    .line 1932
    if-ge v0, v3, :cond_5

    .line 1933
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->c(I)V

    .line 1935
    :cond_5
    const-string v1, "was expecting a colon to separate field name and value"

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->b(ILjava/lang/String;)V

    .line 1937
    :cond_6
    const/4 p1, 0x1

    .line 1938
    goto :goto_0

    .line 1940
    :cond_7
    if-ge v0, v3, :cond_0

    .line 1941
    const/16 v1, 0xa

    if-ne v0, v1, :cond_8

    .line 1942
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->g:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->g:I

    .line 1943
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->h:I

    goto :goto_0

    .line 1944
    :cond_8
    const/16 v1, 0xd

    if-ne v0, v1, :cond_9

    .line 1945
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N()V

    goto :goto_0

    .line 1946
    :cond_9
    const/16 v1, 0x9

    if-eq v0, v1, :cond_0

    .line 1947
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->c(I)V

    goto :goto_0
.end method

.method private final a(IIIZI)Lcom/fasterxml/jackson/core/JsonToken;
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v7, 0x39

    const/16 v6, 0x30

    const/4 v0, 0x0

    .line 1059
    iget v4, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    .line 1063
    const/16 v1, 0x2e

    if-ne p1, v1, :cond_d

    move v1, v0

    move v2, p3

    .line 1066
    :goto_0
    if-lt v2, v4, :cond_0

    .line 1067
    invoke-direct {p0, p4, p2}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->b(ZI)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 1117
    :goto_1
    return-object v0

    .line 1069
    :cond_0
    iget-object v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    add-int/lit8 p3, v2, 0x1

    aget-char v2, v3, v2

    .line 1070
    if-lt v2, v6, :cond_1

    if-le v2, v7, :cond_4

    .line 1076
    :cond_1
    if-nez v1, :cond_2

    .line 1077
    const-string v3, "Decimal point not followed by a digit"

    invoke-virtual {p0, v2, v3}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(ILjava/lang/String;)V

    :cond_2
    move v3, v1

    move v1, p3

    .line 1081
    :goto_2
    const/16 v5, 0x65

    if-eq v2, v5, :cond_3

    const/16 v5, 0x45

    if-ne v2, v5, :cond_a

    .line 1082
    :cond_3
    if-lt v1, v4, :cond_5

    .line 1083
    iput p2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1084
    invoke-direct {p0, p4, p2}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->b(ZI)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_1

    .line 1073
    :cond_4
    add-int/lit8 v1, v1, 0x1

    move v2, p3

    goto :goto_0

    .line 1087
    :cond_5
    iget-object v5, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    add-int/lit8 v2, v1, 0x1

    aget-char v1, v5, v1

    .line 1088
    const/16 v5, 0x2d

    if-eq v1, v5, :cond_6

    const/16 v5, 0x2b

    if-ne v1, v5, :cond_c

    .line 1089
    :cond_6
    if-lt v2, v4, :cond_7

    .line 1090
    iput p2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1091
    invoke-direct {p0, p4, p2}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->b(ZI)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_1

    .line 1093
    :cond_7
    iget-object v5, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    add-int/lit8 v1, v2, 0x1

    aget-char v2, v5, v2

    .line 1095
    :goto_3
    if-gt v2, v7, :cond_9

    if-lt v2, v6, :cond_9

    .line 1096
    add-int/lit8 v0, v0, 0x1

    .line 1097
    if-lt v1, v4, :cond_8

    .line 1098
    iput p2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1099
    invoke-direct {p0, p4, p2}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->b(ZI)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_1

    .line 1101
    :cond_8
    iget-object v5, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    add-int/lit8 v2, v1, 0x1

    aget-char v1, v5, v1

    move v8, v2

    move v2, v1

    move v1, v8

    goto :goto_3

    .line 1104
    :cond_9
    if-nez v0, :cond_a

    .line 1105
    const-string v4, "Exponent indicator not followed by a digit"

    invoke-virtual {p0, v2, v4}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(ILjava/lang/String;)V

    .line 1108
    :cond_a
    add-int/lit8 v1, v1, -0x1

    .line 1109
    iput v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1111
    iget-object v4, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v4}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->b()Z

    move-result v4

    if-eqz v4, :cond_b

    .line 1112
    invoke-direct {p0, v2}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->h(I)V

    .line 1114
    :cond_b
    sub-int/2addr v1, p2

    .line 1115
    iget-object v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    iget-object v4, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    invoke-virtual {v2, v4, p2, v1}, Lcom/fasterxml/jackson/core/util/TextBuffer;->a([CII)V

    .line 1117
    invoke-virtual {p0, p4, p5, v3, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->b(ZIII)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto/16 :goto_1

    :cond_c
    move v8, v2

    move v2, v1

    move v1, v8

    goto :goto_3

    :cond_d
    move v3, v0

    move v1, p3

    move v2, p1

    goto :goto_2
.end method

.method private a(III)Ljava/lang/String;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v5, 0x5c

    .line 1436
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    sub-int/2addr v2, p1

    invoke-virtual {v0, v1, p1, v2}, Lcom/fasterxml/jackson/core/util/TextBuffer;->a([CII)V

    .line 1441
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->j()[C

    move-result-object v1

    .line 1442
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->l()I

    move-result v0

    .line 1445
    :goto_0
    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-lt v2, v3, :cond_0

    .line 1446
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->p()Z

    move-result v2

    if-nez v2, :cond_0

    .line 1447
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, ": was expecting closing \'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    int-to-char v3, p3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\' for name"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->c(Ljava/lang/String;)V

    .line 1450
    :cond_0
    iget-object v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v4, v3, 0x1

    iput v4, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v2, v2, v3

    .line 1452
    if-gt v2, v5, :cond_1

    .line 1453
    if-ne v2, v5, :cond_2

    .line 1458
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->D()C

    move-result v2

    .line 1468
    :cond_1
    :goto_1
    mul-int/lit8 v3, p2, 0x21

    add-int p2, v3, v2

    .line 1470
    add-int/lit8 v3, v0, 0x1

    aput-char v2, v1, v0

    .line 1473
    array-length v0, v1

    if-lt v3, v0, :cond_4

    .line 1474
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->m()[C

    move-result-object v1

    .line 1475
    const/4 v0, 0x0

    goto :goto_0

    .line 1459
    :cond_2
    if-gt v2, p3, :cond_1

    .line 1460
    if-ne v2, p3, :cond_3

    .line 1478
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v1, v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->a(I)V

    .line 1480
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    .line 1481
    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->e()[C

    move-result-object v1

    .line 1482
    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->d()I

    move-result v2

    .line 1483
    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->c()I

    move-result v0

    .line 1484
    iget-object v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->Q:Lcom/fasterxml/jackson/core/sym/CharsToNameCanonicalizer;

    invoke-virtual {v3, v1, v2, v0, p2}, Lcom/fasterxml/jackson/core/sym/CharsToNameCanonicalizer;->a([CIII)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 1463
    :cond_3
    const/16 v3, 0x20

    if-ge v2, v3, :cond_1

    .line 1464
    const-string v3, "name"

    invoke-virtual {p0, v2, v3}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->c(ILjava/lang/String;)V

    goto :goto_1

    :cond_4
    move v0, v3

    goto :goto_0
.end method

.method private a(II[I)Ljava/lang/String;
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1671
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    sub-int/2addr v2, p1

    invoke-virtual {v0, v1, p1, v2}, Lcom/fasterxml/jackson/core/util/TextBuffer;->a([CII)V

    .line 1672
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->j()[C

    move-result-object v1

    .line 1673
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->l()I

    move-result v0

    .line 1674
    array-length v3, p3

    .line 1677
    :goto_0
    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v4, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-lt v2, v4, :cond_1

    .line 1678
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->p()Z

    move-result v2

    if-nez v2, :cond_1

    .line 1702
    :cond_0
    :goto_1
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v1, v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->a(I)V

    .line 1704
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    .line 1705
    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->e()[C

    move-result-object v1

    .line 1706
    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->d()I

    move-result v2

    .line 1707
    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->c()I

    move-result v0

    .line 1709
    iget-object v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->Q:Lcom/fasterxml/jackson/core/sym/CharsToNameCanonicalizer;

    invoke-virtual {v3, v1, v2, v0, p2}, Lcom/fasterxml/jackson/core/sym/CharsToNameCanonicalizer;->a([CIII)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 1682
    :cond_1
    iget-object v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v4, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v4, v2, v4

    .line 1684
    if-gt v4, v3, :cond_3

    .line 1685
    aget v2, p3, v4

    if-nez v2, :cond_0

    .line 1691
    :cond_2
    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1692
    mul-int/lit8 v2, p2, 0x21

    add-int p2, v2, v4

    .line 1694
    add-int/lit8 v2, v0, 0x1

    aput-char v4, v1, v0

    .line 1697
    array-length v0, v1

    if-lt v2, v0, :cond_4

    .line 1698
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->m()[C

    move-result-object v1

    .line 1699
    const/4 v0, 0x0

    goto :goto_0

    .line 1688
    :cond_3
    invoke-static {v4}, Ljava/lang/Character;->isJavaIdentifierPart(C)Z

    move-result v2

    if-nez v2, :cond_2

    goto :goto_1

    :cond_4
    move v0, v2

    goto :goto_0
.end method

.method private final aa()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2246
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 2247
    add-int/lit8 v1, v0, 0x4

    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-ge v1, v2, :cond_1

    .line 2248
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    .line 2249
    aget-char v2, v1, v0

    const/16 v3, 0x61

    if-ne v2, v3, :cond_1

    add-int/lit8 v0, v0, 0x1

    aget-char v2, v1, v0

    const/16 v3, 0x6c

    if-ne v2, v3, :cond_1

    add-int/lit8 v0, v0, 0x1

    aget-char v2, v1, v0

    const/16 v3, 0x73

    if-ne v2, v3, :cond_1

    add-int/lit8 v0, v0, 0x1

    aget-char v2, v1, v0

    const/16 v3, 0x65

    if-ne v2, v3, :cond_1

    .line 2250
    add-int/lit8 v0, v0, 0x1

    aget-char v1, v1, v0

    .line 2251
    const/16 v2, 0x30

    if-lt v1, v2, :cond_0

    const/16 v2, 0x5d

    if-eq v1, v2, :cond_0

    const/16 v2, 0x7d

    if-ne v1, v2, :cond_1

    .line 2252
    :cond_0
    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 2259
    :goto_0
    return-void

    .line 2258
    :cond_1
    const-string v0, "false"

    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Ljava/lang/String;I)V

    goto :goto_0
.end method

.method private final ab()V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v4, 0x6c

    .line 2262
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 2263
    add-int/lit8 v1, v0, 0x3

    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-ge v1, v2, :cond_1

    .line 2264
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    .line 2265
    aget-char v2, v1, v0

    const/16 v3, 0x75

    if-ne v2, v3, :cond_1

    add-int/lit8 v0, v0, 0x1

    aget-char v2, v1, v0

    if-ne v2, v4, :cond_1

    add-int/lit8 v0, v0, 0x1

    aget-char v2, v1, v0

    if-ne v2, v4, :cond_1

    .line 2266
    add-int/lit8 v0, v0, 0x1

    aget-char v1, v1, v0

    .line 2267
    const/16 v2, 0x30

    if-lt v1, v2, :cond_0

    const/16 v2, 0x5d

    if-eq v1, v2, :cond_0

    const/16 v2, 0x7d

    if-ne v1, v2, :cond_1

    .line 2268
    :cond_0
    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 2275
    :goto_0
    return-void

    .line 2274
    :cond_1
    const-string v0, "null"

    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Ljava/lang/String;I)V

    goto :goto_0
.end method

.method private final b(ZI)Lcom/fasterxml/jackson/core/JsonToken;
    .locals 10
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1177
    if-eqz p1, :cond_0

    add-int/lit8 p2, p2, 0x1

    :cond_0
    iput p2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1178
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->k()[C

    move-result-object v2

    .line 1179
    const/4 v1, 0x0

    .line 1182
    if-eqz p1, :cond_1a

    .line 1183
    const/4 v0, 0x1

    const/16 v3, 0x2d

    aput-char v3, v2, v1

    .line 1187
    :goto_0
    const/4 v3, 0x0

    .line 1188
    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v4, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-ge v1, v4, :cond_3

    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v4, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v5, v4, 0x1

    iput v5, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v1, v1, v4

    .line 1189
    :goto_1
    const/16 v4, 0x30

    if-ne v1, v4, :cond_1

    .line 1190
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->P()C

    move-result v1

    .line 1192
    :cond_1
    const/4 v5, 0x0

    move v9, v1

    move-object v1, v2

    move v2, v9

    .line 1196
    :goto_2
    const/16 v4, 0x30

    if-lt v2, v4, :cond_19

    const/16 v4, 0x39

    if-gt v2, v4, :cond_19

    .line 1197
    add-int/lit8 v3, v3, 0x1

    .line 1198
    array-length v4, v1

    if-lt v0, v4, :cond_2

    .line 1199
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->m()[C

    move-result-object v1

    .line 1200
    const/4 v0, 0x0

    .line 1202
    :cond_2
    add-int/lit8 v4, v0, 0x1

    aput-char v2, v1, v0

    .line 1203
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-lt v0, v2, :cond_4

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->p()Z

    move-result v0

    if-nez v0, :cond_4

    .line 1205
    const/4 v0, 0x0

    .line 1206
    const/4 v5, 0x1

    move v7, v3

    move-object v3, v1

    move v1, v0

    .line 1212
    :goto_3
    if-nez v7, :cond_5

    .line 1213
    invoke-virtual {p0, v1, p1}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(IZ)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 1295
    :goto_4
    return-object v0

    .line 1188
    :cond_3
    const-string v1, "No digit following minus sign"

    invoke-virtual {p0, v1}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e(Ljava/lang/String;)C

    move-result v1

    goto :goto_1

    .line 1209
    :cond_4
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v6, v2, 0x1

    iput v6, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v2, v0, v2

    move v0, v4

    goto :goto_2

    .line 1216
    :cond_5
    const/4 v0, 0x0

    .line 1218
    const/16 v2, 0x2e

    if-ne v1, v2, :cond_18

    .line 1219
    add-int/lit8 v2, v4, 0x1

    aput-char v1, v3, v4

    .line 1223
    :goto_5
    iget v4, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v6, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-lt v4, v6, :cond_d

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->p()Z

    move-result v4

    if-nez v4, :cond_d

    .line 1224
    const/4 v5, 0x1

    move v4, v5

    move v5, v1

    .line 1239
    :goto_6
    if-nez v0, :cond_6

    .line 1240
    const-string v1, "Decimal point not followed by a digit"

    invoke-virtual {p0, v5, v1}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(ILjava/lang/String;)V

    :cond_6
    move v6, v0

    move-object v1, v3

    move v0, v2

    .line 1244
    :goto_7
    const/4 v3, 0x0

    .line 1245
    const/16 v2, 0x65

    if-eq v5, v2, :cond_7

    const/16 v2, 0x45

    if-ne v5, v2, :cond_15

    .line 1246
    :cond_7
    array-length v2, v1

    if-lt v0, v2, :cond_8

    .line 1247
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->m()[C

    move-result-object v1

    .line 1248
    const/4 v0, 0x0

    .line 1250
    :cond_8
    add-int/lit8 v2, v0, 0x1

    aput-char v5, v1, v0

    .line 1252
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v5, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-ge v0, v5, :cond_f

    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v5, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v8, v5, 0x1

    iput v8, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v5, v0, v5

    .line 1255
    :goto_8
    const/16 v0, 0x2d

    if-eq v5, v0, :cond_9

    const/16 v0, 0x2b

    if-ne v5, v0, :cond_14

    .line 1256
    :cond_9
    array-length v0, v1

    if-lt v2, v0, :cond_13

    .line 1257
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->m()[C

    move-result-object v1

    .line 1258
    const/4 v0, 0x0

    .line 1260
    :goto_9
    add-int/lit8 v2, v0, 0x1

    aput-char v5, v1, v0

    .line 1262
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v5, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-ge v0, v5, :cond_10

    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v5, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v8, v5, 0x1

    iput v8, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v0, v0, v5

    :goto_a
    move v9, v0

    move v0, v2

    move v2, v9

    .line 1267
    :goto_b
    const/16 v5, 0x39

    if-gt v2, v5, :cond_12

    const/16 v5, 0x30

    if-lt v2, v5, :cond_12

    .line 1268
    add-int/lit8 v3, v3, 0x1

    .line 1269
    array-length v5, v1

    if-lt v0, v5, :cond_a

    .line 1270
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->m()[C

    move-result-object v1

    .line 1271
    const/4 v0, 0x0

    .line 1273
    :cond_a
    add-int/lit8 v5, v0, 0x1

    aput-char v2, v1, v0

    .line 1274
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v8, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-lt v0, v8, :cond_11

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->p()Z

    move-result v0

    if-nez v0, :cond_11

    .line 1275
    const/4 v4, 0x1

    move v0, v3

    move v1, v4

    move v3, v5

    .line 1281
    :goto_c
    if-nez v0, :cond_b

    .line 1282
    const-string v4, "Exponent indicator not followed by a digit"

    invoke-virtual {p0, v2, v4}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(ILjava/lang/String;)V

    .line 1287
    :cond_b
    :goto_d
    if-nez v1, :cond_c

    .line 1288
    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1289
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->b()Z

    move-result v1

    if-eqz v1, :cond_c

    .line 1290
    invoke-direct {p0, v2}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->h(I)V

    .line 1293
    :cond_c
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v1, v3}, Lcom/fasterxml/jackson/core/util/TextBuffer;->a(I)V

    .line 1295
    invoke-virtual {p0, p1, v7, v6, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(ZIII)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto/16 :goto_4

    .line 1227
    :cond_d
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v4, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v6, v4, 0x1

    iput v6, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v1, v1, v4

    .line 1228
    const/16 v4, 0x30

    if-lt v1, v4, :cond_17

    const/16 v4, 0x39

    if-le v1, v4, :cond_e

    move v4, v5

    move v5, v1

    .line 1229
    goto/16 :goto_6

    .line 1231
    :cond_e
    add-int/lit8 v0, v0, 0x1

    .line 1232
    array-length v4, v3

    if-lt v2, v4, :cond_16

    .line 1233
    iget-object v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v2}, Lcom/fasterxml/jackson/core/util/TextBuffer;->m()[C

    move-result-object v3

    .line 1234
    const/4 v2, 0x0

    move v4, v2

    .line 1236
    :goto_e
    add-int/lit8 v2, v4, 0x1

    aput-char v1, v3, v4

    goto/16 :goto_5

    .line 1252
    :cond_f
    const-string v0, "expected a digit for number exponent"

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e(Ljava/lang/String;)C

    move-result v5

    goto/16 :goto_8

    .line 1262
    :cond_10
    const-string v0, "expected a digit for number exponent"

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e(Ljava/lang/String;)C

    move-result v0

    goto/16 :goto_a

    .line 1278
    :cond_11
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v8, v2, 0x1

    iput v8, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v2, v0, v2

    move v0, v5

    goto/16 :goto_b

    :cond_12
    move v1, v4

    move v9, v3

    move v3, v0

    move v0, v9

    goto :goto_c

    :cond_13
    move v0, v2

    goto/16 :goto_9

    :cond_14
    move v0, v2

    move v2, v5

    goto/16 :goto_b

    :cond_15
    move v1, v4

    move v2, v5

    move v9, v3

    move v3, v0

    move v0, v9

    goto :goto_d

    :cond_16
    move v4, v2

    goto :goto_e

    :cond_17
    move v4, v5

    move v5, v1

    goto/16 :goto_6

    :cond_18
    move v6, v0

    move v0, v4

    move v4, v5

    move v5, v1

    move-object v1, v3

    goto/16 :goto_7

    :cond_19
    move v7, v3

    move v4, v0

    move-object v3, v1

    move v1, v2

    goto/16 :goto_3

    :cond_1a
    move v0, v1

    goto/16 :goto_0
.end method

.method private final h(I)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1386
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1387
    sparse-switch p1, :sswitch_data_0

    .line 1399
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->b(I)V

    .line 1400
    :goto_0
    :sswitch_0
    return-void

    .line 1392
    :sswitch_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N()V

    goto :goto_0

    .line 1395
    :sswitch_2
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->g:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->g:I

    .line 1396
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->h:I

    goto :goto_0

    .line 1387
    :sswitch_data_0
    .sparse-switch
        0x9 -> :sswitch_0
        0xa -> :sswitch_2
        0xd -> :sswitch_1
        0x20 -> :sswitch_0
    .end sparse-switch
.end method

.method private final i(I)I
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v3, 0x20

    .line 1956
    const/16 v0, 0x2c

    if-eq p1, v0, :cond_0

    .line 1957
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "was expecting comma to separate "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->d()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " entries"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->b(ILjava/lang/String;)V

    .line 1959
    :cond_0
    :goto_0
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-ge v0, v1, :cond_6

    .line 1960
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v0, v0, v1

    .line 1961
    if-le v0, v3, :cond_3

    .line 1962
    const/16 v1, 0x2f

    if-eq v0, v1, :cond_1

    const/16 v1, 0x23

    if-ne v0, v1, :cond_2

    .line 1963
    :cond_1
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1964
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->S()I

    move-result v0

    .line 1979
    :cond_2
    :goto_1
    return v0

    .line 1968
    :cond_3
    if-ge v0, v3, :cond_0

    .line 1969
    const/16 v1, 0xa

    if-ne v0, v1, :cond_4

    .line 1970
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->g:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->g:I

    .line 1971
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->h:I

    goto :goto_0

    .line 1972
    :cond_4
    const/16 v1, 0xd

    if-ne v0, v1, :cond_5

    .line 1973
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N()V

    goto :goto_0

    .line 1974
    :cond_5
    const/16 v1, 0x9

    if-eq v0, v1, :cond_0

    .line 1975
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->c(I)V

    goto :goto_0

    .line 1979
    :cond_6
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->S()I

    move-result v0

    goto :goto_1
.end method


# virtual methods
.method protected D()C
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 2178
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-lt v0, v2, :cond_0

    .line 2179
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->p()Z

    move-result v0

    if-nez v0, :cond_0

    .line 2180
    const-string v0, " in character escape sequence"

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->c(Ljava/lang/String;)V

    .line 2183
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v0, v0, v2

    .line 2185
    sparse-switch v0, :sswitch_data_0

    .line 2208
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(C)C

    move-result v0

    .line 2226
    :goto_0
    :sswitch_0
    return v0

    .line 2188
    :sswitch_1
    const/16 v0, 0x8

    goto :goto_0

    .line 2190
    :sswitch_2
    const/16 v0, 0x9

    goto :goto_0

    .line 2192
    :sswitch_3
    const/16 v0, 0xa

    goto :goto_0

    .line 2194
    :sswitch_4
    const/16 v0, 0xc

    goto :goto_0

    .line 2196
    :sswitch_5
    const/16 v0, 0xd

    goto :goto_0

    :sswitch_6
    move v0, v1

    .line 2213
    :goto_1
    const/4 v2, 0x4

    if-ge v0, v2, :cond_3

    .line 2214
    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-lt v2, v3, :cond_1

    .line 2215
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->p()Z

    move-result v2

    if-nez v2, :cond_1

    .line 2216
    const-string v2, " in character escape sequence"

    invoke-virtual {p0, v2}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->c(Ljava/lang/String;)V

    .line 2219
    :cond_1
    iget-object v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v4, v3, 0x1

    iput v4, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v2, v2, v3

    .line 2220
    invoke-static {v2}, Lcom/fasterxml/jackson/core/io/CharTypes;->a(I)I

    move-result v3

    .line 2221
    if-gez v3, :cond_2

    .line 2222
    const-string v4, "expected a hex-digit for character escape sequence"

    invoke-virtual {p0, v2, v4}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->b(ILjava/lang/String;)V

    .line 2224
    :cond_2
    shl-int/lit8 v1, v1, 0x4

    or-int/2addr v1, v3

    .line 2213
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 2226
    :cond_3
    int-to-char v0, v1

    goto :goto_0

    .line 2185
    nop

    :sswitch_data_0
    .sparse-switch
        0x22 -> :sswitch_0
        0x2f -> :sswitch_0
        0x5c -> :sswitch_0
        0x62 -> :sswitch_1
        0x66 -> :sswitch_4
        0x6e -> :sswitch_3
        0x72 -> :sswitch_5
        0x74 -> :sswitch_2
        0x75 -> :sswitch_6
    .end sparse-switch
.end method

.method protected final H()Lcom/fasterxml/jackson/core/JsonToken;
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v8, 0x39

    const/16 v7, 0x30

    const/4 v4, 0x1

    .line 1122
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1123
    add-int/lit8 v2, v0, -0x1

    .line 1124
    iget v6, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    .line 1126
    if-lt v0, v6, :cond_0

    .line 1127
    invoke-direct {p0, v4, v2}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->b(ZI)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 1165
    :goto_0
    return-object v0

    .line 1129
    :cond_0
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    add-int/lit8 v3, v0, 0x1

    aget-char v0, v1, v0

    .line 1131
    if-gt v0, v8, :cond_1

    if-ge v0, v7, :cond_2

    .line 1132
    :cond_1
    iput v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1133
    invoke-virtual {p0, v0, v4}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(IZ)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_0

    .line 1136
    :cond_2
    if-ne v0, v7, :cond_3

    .line 1137
    invoke-direct {p0, v4, v2}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->b(ZI)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_0

    :cond_3
    move v5, v4

    move v0, v3

    .line 1144
    :goto_1
    if-lt v0, v6, :cond_4

    .line 1145
    invoke-direct {p0, v4, v2}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->b(ZI)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_0

    .line 1147
    :cond_4
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    add-int/lit8 v3, v0, 0x1

    aget-char v1, v1, v0

    .line 1148
    if-lt v1, v7, :cond_5

    if-le v1, v8, :cond_7

    .line 1154
    :cond_5
    const/16 v0, 0x2e

    if-eq v1, v0, :cond_6

    const/16 v0, 0x65

    if-eq v1, v0, :cond_6

    const/16 v0, 0x45

    if-ne v1, v0, :cond_8

    .line 1155
    :cond_6
    iput v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    move-object v0, p0

    .line 1156
    invoke-direct/range {v0 .. v5}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(IIIZI)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_0

    .line 1151
    :cond_7
    add-int/lit8 v5, v5, 0x1

    move v0, v3

    goto :goto_1

    .line 1158
    :cond_8
    add-int/lit8 v0, v3, -0x1

    .line 1159
    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1160
    iget-object v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v3}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->b()Z

    move-result v3

    if-eqz v3, :cond_9

    .line 1161
    invoke-direct {p0, v1}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->h(I)V

    .line 1163
    :cond_9
    sub-int/2addr v0, v2

    .line 1164
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    iget-object v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    invoke-virtual {v1, v3, v2, v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->a([CII)V

    .line 1165
    invoke-virtual {p0, v4, v5}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(ZI)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_0
.end method

.method protected final I()Ljava/lang/String;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v5, 0x22

    .line 1412
    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1413
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->R:I

    .line 1414
    sget-object v2, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->L:[I

    .line 1416
    :goto_0
    iget v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-ge v1, v3, :cond_1

    .line 1417
    iget-object v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    aget-char v3, v3, v1

    .line 1418
    array-length v4, v2

    if-ge v3, v4, :cond_0

    aget v4, v2, v3

    if-eqz v4, :cond_0

    .line 1419
    if-ne v3, v5, :cond_1

    .line 1420
    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1421
    add-int/lit8 v3, v1, 0x1

    iput v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1422
    iget-object v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->Q:Lcom/fasterxml/jackson/core/sym/CharsToNameCanonicalizer;

    iget-object v4, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    sub-int/2addr v1, v2

    invoke-virtual {v3, v4, v2, v1, v0}, Lcom/fasterxml/jackson/core/sym/CharsToNameCanonicalizer;->a([CIII)Ljava/lang/String;

    move-result-object v0

    .line 1431
    :goto_1
    return-object v0

    .line 1426
    :cond_0
    mul-int/lit8 v0, v0, 0x21

    add-int/2addr v0, v3

    .line 1427
    add-int/lit8 v1, v1, 0x1

    .line 1428
    goto :goto_0

    .line 1429
    :cond_1
    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1430
    iput v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1431
    invoke-direct {p0, v2, v0, v5}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(III)Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method

.method protected J()Ljava/lang/String;
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v7, 0x27

    .line 1548
    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1549
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->R:I

    .line 1550
    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    .line 1552
    if-ge v1, v2, :cond_2

    .line 1553
    sget-object v3, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->L:[I

    .line 1554
    array-length v4, v3

    .line 1557
    :cond_0
    iget-object v5, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    aget-char v5, v5, v1

    .line 1558
    if-ne v5, v7, :cond_1

    .line 1559
    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1560
    add-int/lit8 v3, v1, 0x1

    iput v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1561
    iget-object v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->Q:Lcom/fasterxml/jackson/core/sym/CharsToNameCanonicalizer;

    iget-object v4, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    sub-int/2addr v1, v2

    invoke-virtual {v3, v4, v2, v1, v0}, Lcom/fasterxml/jackson/core/sym/CharsToNameCanonicalizer;->a([CIII)Ljava/lang/String;

    move-result-object v0

    .line 1574
    :goto_0
    return-object v0

    .line 1563
    :cond_1
    if-ge v5, v4, :cond_3

    aget v6, v3, v5

    if-eqz v6, :cond_3

    .line 1571
    :cond_2
    :goto_1
    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1572
    iput v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1574
    invoke-direct {p0, v2, v0, v7}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(III)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1566
    :cond_3
    mul-int/lit8 v0, v0, 0x21

    add-int/2addr v0, v5

    .line 1567
    add-int/lit8 v1, v1, 0x1

    .line 1568
    if-lt v1, v2, :cond_0

    goto :goto_1
.end method

.method protected K()Lcom/fasterxml/jackson/core/JsonToken;
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v6, 0x5c

    const/16 v5, 0x27

    .line 1630
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->k()[C

    move-result-object v1

    .line 1631
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->l()I

    move-result v0

    .line 1634
    :goto_0
    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-lt v2, v3, :cond_0

    .line 1635
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->p()Z

    move-result v2

    if-nez v2, :cond_0

    .line 1636
    const-string v2, ": was expecting closing quote for a string value"

    invoke-virtual {p0, v2}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->c(Ljava/lang/String;)V

    .line 1639
    :cond_0
    iget-object v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v4, v3, 0x1

    iput v4, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v2, v2, v3

    .line 1641
    if-gt v2, v6, :cond_1

    .line 1642
    if-ne v2, v6, :cond_2

    .line 1647
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->D()C

    move-result v2

    .line 1658
    :cond_1
    :goto_1
    array-length v3, v1

    if-lt v0, v3, :cond_4

    .line 1659
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->m()[C

    move-result-object v1

    .line 1660
    const/4 v0, 0x0

    move v3, v0

    .line 1663
    :goto_2
    add-int/lit8 v0, v3, 0x1

    aput-char v2, v1, v3

    goto :goto_0

    .line 1648
    :cond_2
    if-gt v2, v5, :cond_1

    .line 1649
    if-ne v2, v5, :cond_3

    .line 1665
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v1, v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->a(I)V

    .line 1666
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_STRING:Lcom/fasterxml/jackson/core/JsonToken;

    return-object v0

    .line 1652
    :cond_3
    const/16 v3, 0x20

    if-ge v2, v3, :cond_1

    .line 1653
    const-string v3, "string value"

    invoke-virtual {p0, v2, v3}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->c(ILjava/lang/String;)V

    goto :goto_1

    :cond_4
    move v3, v0

    goto :goto_2
.end method

.method protected L()V
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1752
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->j()[C

    move-result-object v1

    .line 1753
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->l()I

    move-result v0

    .line 1754
    sget-object v4, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->L:[I

    .line 1755
    array-length v5, v4

    .line 1758
    :goto_0
    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-lt v2, v3, :cond_0

    .line 1759
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->p()Z

    move-result v2

    if-nez v2, :cond_0

    .line 1760
    const-string v2, ": was expecting closing quote for a string value"

    invoke-virtual {p0, v2}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->c(Ljava/lang/String;)V

    .line 1763
    :cond_0
    iget-object v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v6, v3, 0x1

    iput v6, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v2, v2, v3

    .line 1765
    if-ge v2, v5, :cond_2

    aget v3, v4, v2

    if-eqz v3, :cond_2

    .line 1766
    const/16 v3, 0x22

    if-ne v2, v3, :cond_1

    .line 1786
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v1, v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->a(I)V

    .line 1787
    return-void

    .line 1768
    :cond_1
    const/16 v3, 0x5c

    if-ne v2, v3, :cond_3

    .line 1773
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->D()C

    move-result v2

    .line 1779
    :cond_2
    :goto_1
    array-length v3, v1

    if-lt v0, v3, :cond_4

    .line 1780
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->m()[C

    move-result-object v1

    .line 1781
    const/4 v0, 0x0

    move v3, v0

    .line 1784
    :goto_2
    add-int/lit8 v0, v3, 0x1

    aput-char v2, v1, v3

    goto :goto_0

    .line 1774
    :cond_3
    const/16 v3, 0x20

    if-ge v2, v3, :cond_2

    .line 1775
    const-string v3, "string value"

    invoke-virtual {p0, v2, v3}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->c(ILjava/lang/String;)V

    goto :goto_1

    :cond_4
    move v3, v0

    goto :goto_2
.end method

.method protected final M()V
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v6, 0x5c

    const/16 v5, 0x22

    .line 1796
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->S:Z

    .line 1798
    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1799
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    .line 1800
    iget-object v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    .line 1803
    :goto_0
    if-lt v1, v0, :cond_1

    .line 1804
    iput v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1805
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->p()Z

    move-result v0

    if-nez v0, :cond_0

    .line 1806
    const-string v0, ": was expecting closing quote for a string value"

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->c(Ljava/lang/String;)V

    .line 1808
    :cond_0
    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1809
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    .line 1811
    :cond_1
    add-int/lit8 v2, v1, 0x1

    aget-char v1, v3, v1

    .line 1813
    if-gt v1, v6, :cond_4

    .line 1814
    if-ne v1, v6, :cond_2

    .line 1819
    iput v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1820
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->D()C

    .line 1821
    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1822
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    goto :goto_0

    .line 1823
    :cond_2
    if-gt v1, v5, :cond_4

    .line 1824
    if-ne v1, v5, :cond_3

    .line 1825
    iput v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1835
    return-void

    .line 1828
    :cond_3
    const/16 v4, 0x20

    if-ge v1, v4, :cond_4

    .line 1829
    iput v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1830
    const-string v4, "string value"

    invoke-virtual {p0, v1, v4}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->c(ILjava/lang/String;)V

    :cond_4
    move v1, v2

    goto :goto_0
.end method

.method protected final N()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1848
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-lt v0, v1, :cond_0

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->p()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1849
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v0, v0, v1

    const/16 v1, 0xa

    if-ne v0, v1, :cond_1

    .line 1850
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1853
    :cond_1
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->g:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->g:I

    .line 1854
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->h:I

    .line 1855
    return-void
.end method

.method public final a()Lcom/fasterxml/jackson/core/JsonToken;
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    const/16 v7, 0x7d

    const/16 v6, 0x5d

    .line 565
    const/4 v0, 0x0

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->A:I

    .line 571
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->K:Lcom/fasterxml/jackson/core/JsonToken;

    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->FIELD_NAME:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v2, :cond_0

    .line 572
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->O()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 698
    :goto_0
    return-object v0

    .line 574
    :cond_0
    iget-boolean v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->S:Z

    if-eqz v0, :cond_1

    .line 575
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->M()V

    .line 577
    :cond_1
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->T()I

    move-result v0

    .line 578
    if-gez v0, :cond_2

    .line 582
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->close()V

    .line 583
    iput-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->K:Lcom/fasterxml/jackson/core/JsonToken;

    move-object v0, v1

    goto :goto_0

    .line 589
    :cond_2
    iget-wide v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->f:J

    iget v4, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    int-to-long v4, v4

    add-long/2addr v2, v4

    const-wide/16 v4, 0x1

    sub-long/2addr v2, v4

    iput-wide v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->i:J

    .line 590
    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->g:I

    iput v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->j:I

    .line 591
    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->h:I

    sub-int/2addr v2, v3

    add-int/lit8 v2, v2, -0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->k:I

    .line 594
    iput-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->r:[B

    .line 597
    if-ne v0, v6, :cond_4

    .line 598
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->a()Z

    move-result v1

    if-nez v1, :cond_3

    .line 599
    invoke-virtual {p0, v0, v7}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(IC)V

    .line 601
    :cond_3
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->h()Lcom/fasterxml/jackson/core/json/JsonReadContext;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    .line 602
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->END_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->K:Lcom/fasterxml/jackson/core/JsonToken;

    goto :goto_0

    .line 604
    :cond_4
    if-ne v0, v7, :cond_6

    .line 605
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->c()Z

    move-result v1

    if-nez v1, :cond_5

    .line 606
    invoke-virtual {p0, v0, v6}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(IC)V

    .line 608
    :cond_5
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->h()Lcom/fasterxml/jackson/core/json/JsonReadContext;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    .line 609
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->K:Lcom/fasterxml/jackson/core/JsonToken;

    goto :goto_0

    .line 613
    :cond_6
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->i()Z

    move-result v1

    if-eqz v1, :cond_7

    .line 614
    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->i(I)I

    move-result v0

    .line 621
    :cond_7
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->c()Z

    move-result v1

    .line 622
    if-eqz v1, :cond_8

    .line 624
    const/16 v2, 0x22

    if-ne v0, v2, :cond_9

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->I()Ljava/lang/String;

    move-result-object v0

    .line 625
    :goto_1
    iget-object v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v2, v0}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->a(Ljava/lang/String;)V

    .line 626
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->FIELD_NAME:Lcom/fasterxml/jackson/core/JsonToken;

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->K:Lcom/fasterxml/jackson/core/JsonToken;

    .line 627
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->R()I

    move-result v0

    .line 634
    :cond_8
    sparse-switch v0, :sswitch_data_0

    .line 689
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->g(I)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 693
    :goto_2
    if-eqz v1, :cond_c

    .line 694
    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->m:Lcom/fasterxml/jackson/core/JsonToken;

    .line 695
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->K:Lcom/fasterxml/jackson/core/JsonToken;

    goto/16 :goto_0

    .line 624
    :cond_9
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->f(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 636
    :sswitch_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->S:Z

    .line 637
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_STRING:Lcom/fasterxml/jackson/core/JsonToken;

    goto :goto_2

    .line 640
    :sswitch_1
    if-nez v1, :cond_a

    .line 641
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->j:I

    iget v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->k:I

    invoke-virtual {v0, v2, v3}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->a(II)Lcom/fasterxml/jackson/core/json/JsonReadContext;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    .line 643
    :cond_a
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->START_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    goto :goto_2

    .line 646
    :sswitch_2
    if-nez v1, :cond_b

    .line 647
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->j:I

    iget v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->k:I

    invoke-virtual {v0, v2, v3}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->b(II)Lcom/fasterxml/jackson/core/json/JsonReadContext;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    .line 649
    :cond_b
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->START_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    goto :goto_2

    .line 655
    :sswitch_3
    const-string v2, "expected a value"

    invoke-virtual {p0, v0, v2}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->b(ILjava/lang/String;)V

    .line 657
    :sswitch_4
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->Z()V

    .line 658
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_TRUE:Lcom/fasterxml/jackson/core/JsonToken;

    goto :goto_2

    .line 661
    :sswitch_5
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->aa()V

    .line 662
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_FALSE:Lcom/fasterxml/jackson/core/JsonToken;

    goto :goto_2

    .line 665
    :sswitch_6
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->ab()V

    .line 666
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NULL:Lcom/fasterxml/jackson/core/JsonToken;

    goto :goto_2

    .line 674
    :sswitch_7
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->H()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_2

    .line 686
    :sswitch_8
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e(I)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_2

    .line 697
    :cond_c
    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->K:Lcom/fasterxml/jackson/core/JsonToken;

    goto/16 :goto_0

    .line 634
    nop

    :sswitch_data_0
    .sparse-switch
        0x22 -> :sswitch_0
        0x2d -> :sswitch_7
        0x30 -> :sswitch_8
        0x31 -> :sswitch_8
        0x32 -> :sswitch_8
        0x33 -> :sswitch_8
        0x34 -> :sswitch_8
        0x35 -> :sswitch_8
        0x36 -> :sswitch_8
        0x37 -> :sswitch_8
        0x38 -> :sswitch_8
        0x39 -> :sswitch_8
        0x5b -> :sswitch_1
        0x5d -> :sswitch_3
        0x66 -> :sswitch_5
        0x6e -> :sswitch_6
        0x74 -> :sswitch_4
        0x7b -> :sswitch_2
        0x7d -> :sswitch_3
    .end sparse-switch
.end method

.method protected a(IZ)Lcom/fasterxml/jackson/core/JsonToken;
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x3

    const-wide/high16 v4, 0x7ff0000000000000L    # Double.POSITIVE_INFINITY

    const-wide/high16 v2, -0x10000000000000L    # Double.NEGATIVE_INFINITY

    .line 1351
    const/16 v0, 0x49

    if-ne p1, v0, :cond_4

    .line 1352
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-lt v0, v1, :cond_0

    .line 1353
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->p()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->F()V

    .line 1355
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v6, v1, 0x1

    iput v6, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char p1, v0, v1

    .line 1356
    const/16 v0, 0x4e

    if-ne p1, v0, :cond_5

    .line 1357
    if-eqz p2, :cond_1

    const-string v0, "-INF"

    .line 1358
    :goto_0
    invoke-virtual {p0, v0, v7}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Ljava/lang/String;I)V

    .line 1359
    sget-object v1, Lcom/fasterxml/jackson/core/JsonParser$Feature;->ALLOW_NON_NUMERIC_NUMBERS:Lcom/fasterxml/jackson/core/JsonParser$Feature;

    invoke-virtual {p0, v1}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Lcom/fasterxml/jackson/core/JsonParser$Feature;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 1360
    if-eqz p2, :cond_2

    :goto_1
    invoke-virtual {p0, v0, v2, v3}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Ljava/lang/String;D)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 1373
    :goto_2
    return-object v0

    .line 1357
    :cond_1
    const-string v0, "+INF"

    goto :goto_0

    :cond_2
    move-wide v2, v4

    .line 1360
    goto :goto_1

    .line 1362
    :cond_3
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Non-standard token \'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d(Ljava/lang/String;)V

    .line 1372
    :cond_4
    :goto_3
    const-string v0, "expected digit (0-9) to follow minus sign, for valid numeric value"

    invoke-virtual {p0, p1, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(ILjava/lang/String;)V

    .line 1373
    const/4 v0, 0x0

    goto :goto_2

    .line 1363
    :cond_5
    const/16 v0, 0x6e

    if-ne p1, v0, :cond_4

    .line 1364
    if-eqz p2, :cond_6

    const-string v0, "-Infinity"

    .line 1365
    :goto_4
    invoke-virtual {p0, v0, v7}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Ljava/lang/String;I)V

    .line 1366
    sget-object v1, Lcom/fasterxml/jackson/core/JsonParser$Feature;->ALLOW_NON_NUMERIC_NUMBERS:Lcom/fasterxml/jackson/core/JsonParser$Feature;

    invoke-virtual {p0, v1}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Lcom/fasterxml/jackson/core/JsonParser$Feature;)Z

    move-result v1

    if-eqz v1, :cond_8

    .line 1367
    if-eqz p2, :cond_7

    :goto_5
    invoke-virtual {p0, v0, v2, v3}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Ljava/lang/String;D)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_2

    .line 1364
    :cond_6
    const-string v0, "+Infinity"

    goto :goto_4

    :cond_7
    move-wide v2, v4

    .line 1367
    goto :goto_5

    .line 1369
    :cond_8
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Non-standard token \'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d(Ljava/lang/String;)V

    goto :goto_3
.end method

.method protected final a(Lcom/fasterxml/jackson/core/JsonToken;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 276
    if-nez p1, :cond_0

    .line 277
    const/4 v0, 0x0

    .line 289
    :goto_0
    return-object v0

    .line 279
    :cond_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonToken;->id()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 289
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonToken;->asString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 281
    :pswitch_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->g()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 287
    :pswitch_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->f()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 279
    :pswitch_data_0
    .packed-switch 0x5
        :pswitch_0
        :pswitch_1
        :pswitch_1
        :pswitch_1
    .end packed-switch
.end method

.method protected final a(Ljava/lang/String;I)V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 2282
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    .line 2285
    :cond_0
    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-lt v1, v2, :cond_1

    .line 2286
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->p()Z

    move-result v1

    if-nez v1, :cond_1

    .line 2287
    invoke-virtual {p1, v3, p2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->f(Ljava/lang/String;)V

    .line 2290
    :cond_1
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v1, v1, v2

    invoke-virtual {p1, p2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    if-eq v1, v2, :cond_2

    .line 2291
    invoke-virtual {p1, v3, p2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->f(Ljava/lang/String;)V

    .line 2293
    :cond_2
    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 2294
    add-int/lit8 p2, p2, 0x1

    if-lt p2, v0, :cond_0

    .line 2297
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-lt v0, v1, :cond_4

    .line 2298
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->p()Z

    move-result v0

    if-nez v0, :cond_4

    .line 2310
    :cond_3
    :goto_0
    return-void

    .line 2302
    :cond_4
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v0, v0, v1

    .line 2303
    const/16 v1, 0x30

    if-lt v0, v1, :cond_3

    const/16 v1, 0x5d

    if-eq v0, v1, :cond_3

    const/16 v1, 0x7d

    if-eq v0, v1, :cond_3

    .line 2307
    invoke-static {v0}, Ljava/lang/Character;->isJavaIdentifierPart(C)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 2308
    invoke-virtual {p1, v3, p2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->f(Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2444
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0, p1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 2450
    :goto_0
    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-lt v1, v2, :cond_1

    .line 2451
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->p()Z

    move-result v1

    if-nez v1, :cond_1

    .line 2462
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unrecognized token \'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\': was expecting "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d(Ljava/lang/String;)V

    .line 2463
    return-void

    .line 2455
    :cond_1
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v1, v1, v2

    .line 2456
    invoke-static {v1}, Ljava/lang/Character;->isJavaIdentifierPart(C)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 2459
    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 2460
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_0
.end method

.method protected e(Ljava/lang/String;)C
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 170
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-lt v0, v1, :cond_0

    .line 171
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->p()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->c(Ljava/lang/String;)V

    .line 173
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v0, v0, v1

    return v0
.end method

.method protected final e(I)Lcom/fasterxml/jackson/core/JsonToken;
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v7, 0x30

    const/4 v4, 0x0

    .line 1010
    iget v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1011
    add-int/lit8 v2, v3, -0x1

    .line 1012
    iget v6, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    .line 1015
    if-ne p1, v7, :cond_0

    .line 1016
    invoke-direct {p0, v4, v2}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->b(ZI)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 1053
    :goto_0
    return-object v0

    .line 1025
    :cond_0
    const/4 v5, 0x1

    move v0, v3

    .line 1030
    :goto_1
    if-lt v0, v6, :cond_1

    .line 1031
    iput v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1032
    invoke-direct {p0, v4, v2}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->b(ZI)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_0

    .line 1034
    :cond_1
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    add-int/lit8 v3, v0, 0x1

    aget-char v1, v1, v0

    .line 1035
    if-lt v1, v7, :cond_2

    const/16 v0, 0x39

    if-le v1, v0, :cond_4

    .line 1040
    :cond_2
    const/16 v0, 0x2e

    if-eq v1, v0, :cond_3

    const/16 v0, 0x65

    if-eq v1, v0, :cond_3

    const/16 v0, 0x45

    if-ne v1, v0, :cond_5

    .line 1041
    :cond_3
    iput v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    move-object v0, p0

    .line 1042
    invoke-direct/range {v0 .. v5}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(IIIZI)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_0

    .line 1038
    :cond_4
    add-int/lit8 v5, v5, 0x1

    move v0, v3

    goto :goto_1

    .line 1045
    :cond_5
    add-int/lit8 v0, v3, -0x1

    .line 1046
    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1048
    iget-object v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v3}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->b()Z

    move-result v3

    if-eqz v3, :cond_6

    .line 1049
    invoke-direct {p0, v1}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->h(I)V

    .line 1051
    :cond_6
    sub-int/2addr v0, v2

    .line 1052
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    iget-object v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    invoke-virtual {v1, v3, v2, v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->a([CII)V

    .line 1053
    invoke-virtual {p0, v4, v5}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(ZI)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_0
.end method

.method public final f()Ljava/lang/String;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 229
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->K:Lcom/fasterxml/jackson/core/JsonToken;

    .line 230
    sget-object v1, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_STRING:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v1, :cond_1

    .line 231
    iget-boolean v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->S:Z

    if-eqz v0, :cond_0

    .line 232
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->S:Z

    .line 233
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->q()V

    .line 235
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->f()Ljava/lang/String;

    move-result-object v0

    .line 237
    :goto_0
    return-object v0

    :cond_1
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Lcom/fasterxml/jackson/core/JsonToken;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method protected f(I)Ljava/lang/String;
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1497
    const/16 v0, 0x27

    if-ne p1, v0, :cond_0

    sget-object v0, Lcom/fasterxml/jackson/core/JsonParser$Feature;->ALLOW_SINGLE_QUOTES:Lcom/fasterxml/jackson/core/JsonParser$Feature;

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Lcom/fasterxml/jackson/core/JsonParser$Feature;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1498
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->J()Ljava/lang/String;

    move-result-object v0

    .line 1542
    :goto_0
    return-object v0

    .line 1501
    :cond_0
    sget-object v0, Lcom/fasterxml/jackson/core/JsonParser$Feature;->ALLOW_UNQUOTED_FIELD_NAMES:Lcom/fasterxml/jackson/core/JsonParser$Feature;

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Lcom/fasterxml/jackson/core/JsonParser$Feature;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 1502
    const-string v0, "was expecting double-quote to start field name"

    invoke-virtual {p0, p1, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->b(ILjava/lang/String;)V

    .line 1504
    :cond_1
    invoke-static {}, Lcom/fasterxml/jackson/core/io/CharTypes;->c()[I

    move-result-object v2

    .line 1505
    array-length v3, v2

    .line 1510
    if-ge p1, v3, :cond_5

    .line 1511
    aget v0, v2, p1

    if-nez v0, :cond_4

    const/4 v0, 0x1

    .line 1515
    :goto_1
    if-nez v0, :cond_2

    .line 1516
    const-string v0, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name"

    invoke-virtual {p0, p1, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->b(ILjava/lang/String;)V

    .line 1518
    :cond_2
    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1519
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->R:I

    .line 1520
    iget v4, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    .line 1522
    if-ge v1, v4, :cond_8

    .line 1524
    :cond_3
    iget-object v5, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    aget-char v5, v5, v1

    .line 1525
    if-ge v5, v3, :cond_6

    .line 1526
    aget v6, v2, v5

    if-eqz v6, :cond_7

    .line 1527
    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v2, v2, -0x1

    .line 1528
    iput v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1529
    iget-object v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->Q:Lcom/fasterxml/jackson/core/sym/CharsToNameCanonicalizer;

    iget-object v4, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    sub-int/2addr v1, v2

    invoke-virtual {v3, v4, v2, v1, v0}, Lcom/fasterxml/jackson/core/sym/CharsToNameCanonicalizer;->a([CIII)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1511
    :cond_4
    const/4 v0, 0x0

    goto :goto_1

    .line 1513
    :cond_5
    int-to-char v0, p1

    invoke-static {v0}, Ljava/lang/Character;->isJavaIdentifierPart(C)Z

    move-result v0

    goto :goto_1

    .line 1531
    :cond_6
    int-to-char v6, v5

    invoke-static {v6}, Ljava/lang/Character;->isJavaIdentifierPart(C)Z

    move-result v6

    if-nez v6, :cond_7

    .line 1532
    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v2, v2, -0x1

    .line 1533
    iput v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1534
    iget-object v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->Q:Lcom/fasterxml/jackson/core/sym/CharsToNameCanonicalizer;

    iget-object v4, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    sub-int/2addr v1, v2

    invoke-virtual {v3, v4, v2, v1, v0}, Lcom/fasterxml/jackson/core/sym/CharsToNameCanonicalizer;->a([CIII)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1536
    :cond_7
    mul-int/lit8 v0, v0, 0x21

    add-int/2addr v0, v5

    .line 1537
    add-int/lit8 v1, v1, 0x1

    .line 1538
    if-lt v1, v4, :cond_3

    .line 1540
    :cond_8
    iget v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v3, v3, -0x1

    .line 1541
    iput v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1542
    invoke-direct {p0, v3, v0, v2}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(II[I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method protected f(Ljava/lang/String;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2439
    const-string v0, "\'null\', \'true\', \'false\' or NaN"

    invoke-virtual {p0, p1, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 2440
    return-void
.end method

.method protected g(I)Lcom/fasterxml/jackson/core/JsonToken;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    .line 1584
    sparse-switch p1, :sswitch_data_0

    .line 1620
    :cond_0
    :goto_0
    invoke-static {p1}, Ljava/lang/Character;->isJavaIdentifierStart(I)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1621
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    int-to-char v1, p1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "(\'true\', \'false\' or \'null\')"

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 1624
    :cond_1
    const-string v0, "expected a valid value (number, String, array, object, \'true\', \'false\' or \'null\')"

    invoke-virtual {p0, p1, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->b(ILjava/lang/String;)V

    .line 1625
    const/4 v0, 0x0

    :goto_1
    return-object v0

    .line 1593
    :sswitch_0
    sget-object v0, Lcom/fasterxml/jackson/core/JsonParser$Feature;->ALLOW_SINGLE_QUOTES:Lcom/fasterxml/jackson/core/JsonParser$Feature;

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Lcom/fasterxml/jackson/core/JsonParser$Feature;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1594
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->K()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_1

    .line 1598
    :sswitch_1
    const-string v0, "NaN"

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Ljava/lang/String;I)V

    .line 1599
    sget-object v0, Lcom/fasterxml/jackson/core/JsonParser$Feature;->ALLOW_NON_NUMERIC_NUMBERS:Lcom/fasterxml/jackson/core/JsonParser$Feature;

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Lcom/fasterxml/jackson/core/JsonParser$Feature;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1600
    const-string v0, "NaN"

    const-wide/high16 v2, 0x7ff8000000000000L    # Double.NaN

    invoke-virtual {p0, v0, v2, v3}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Ljava/lang/String;D)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_1

    .line 1602
    :cond_2
    const-string v0, "Non-standard token \'NaN\': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow"

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d(Ljava/lang/String;)V

    goto :goto_0

    .line 1605
    :sswitch_2
    const-string v0, "Infinity"

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Ljava/lang/String;I)V

    .line 1606
    sget-object v0, Lcom/fasterxml/jackson/core/JsonParser$Feature;->ALLOW_NON_NUMERIC_NUMBERS:Lcom/fasterxml/jackson/core/JsonParser$Feature;

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Lcom/fasterxml/jackson/core/JsonParser$Feature;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1607
    const-string v0, "Infinity"

    const-wide/high16 v2, 0x7ff0000000000000L    # Double.POSITIVE_INFINITY

    invoke-virtual {p0, v0, v2, v3}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Ljava/lang/String;D)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_1

    .line 1609
    :cond_3
    const-string v0, "Non-standard token \'Infinity\': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow"

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d(Ljava/lang/String;)V

    goto :goto_0

    .line 1612
    :sswitch_3
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    if-lt v0, v1, :cond_4

    .line 1613
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->p()Z

    move-result v0

    if-nez v0, :cond_4

    .line 1614
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->F()V

    .line 1617
    :cond_4
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    aget-char v0, v0, v1

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(IZ)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_1

    .line 1584
    :sswitch_data_0
    .sparse-switch
        0x27 -> :sswitch_0
        0x2b -> :sswitch_3
        0x49 -> :sswitch_2
        0x4e -> :sswitch_1
    .end sparse-switch
.end method

.method protected p()Z
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 149
    iget-wide v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->f:J

    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    int-to-long v4, v1

    add-long/2addr v2, v4

    iput-wide v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->f:J

    .line 150
    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->h:I

    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    sub-int/2addr v1, v2

    iput v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->h:I

    .line 152
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->M:Ljava/io/Reader;

    if-eqz v1, :cond_0

    .line 153
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->M:Ljava/io/Reader;

    iget-object v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget-object v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    array-length v3, v3

    invoke-virtual {v1, v2, v0, v3}, Ljava/io/Reader;->read([CII)I

    move-result v1

    .line 154
    if-lez v1, :cond_1

    .line 155
    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 156
    iput v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    .line 157
    const/4 v0, 0x1

    .line 166
    :cond_0
    return v0

    .line 160
    :cond_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->r()V

    .line 162
    if-nez v1, :cond_0

    .line 163
    new-instance v0, Ljava/io/IOException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Reader returned 0 characters when trying to read "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method protected final q()V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1720
    iget v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1721
    iget v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->e:I

    .line 1723
    if-ge v0, v1, :cond_2

    .line 1724
    sget-object v2, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->L:[I

    .line 1725
    array-length v3, v2

    .line 1728
    :cond_0
    iget-object v4, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    aget-char v4, v4, v0

    .line 1729
    if-ge v4, v3, :cond_1

    aget v5, v2, v4

    if-eqz v5, :cond_1

    .line 1730
    const/16 v1, 0x22

    if-ne v4, v1, :cond_2

    .line 1731
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    iget-object v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v4, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    sub-int v4, v0, v4

    invoke-virtual {v1, v2, v3, v4}, Lcom/fasterxml/jackson/core/util/TextBuffer;->a([CII)V

    .line 1732
    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1748
    :goto_0
    return-void

    .line 1738
    :cond_1
    add-int/lit8 v0, v0, 0x1

    .line 1739
    if-lt v0, v1, :cond_0

    .line 1745
    :cond_2
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    iget-object v2, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    iget v3, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    iget v4, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    sub-int v4, v0, v4

    invoke-virtual {v1, v2, v3, v4}, Lcom/fasterxml/jackson/core/util/TextBuffer;->b([CII)V

    .line 1746
    iput v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->d:I

    .line 1747
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->L()V

    goto :goto_0
.end method

.method protected r()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 185
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->M:Ljava/io/Reader;

    if-eqz v0, :cond_2

    .line 186
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->b:Lcom/fasterxml/jackson/core/io/IOContext;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/io/IOContext;->c()Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/fasterxml/jackson/core/JsonParser$Feature;->AUTO_CLOSE_SOURCE:Lcom/fasterxml/jackson/core/JsonParser$Feature;

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->a(Lcom/fasterxml/jackson/core/JsonParser$Feature;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 187
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->M:Ljava/io/Reader;

    invoke-virtual {v0}, Ljava/io/Reader;->close()V

    .line 189
    :cond_1
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->M:Ljava/io/Reader;

    .line 191
    :cond_2
    return-void
.end method

.method protected s()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 201
    invoke-super {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->s()V

    .line 203
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->Q:Lcom/fasterxml/jackson/core/sym/CharsToNameCanonicalizer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/sym/CharsToNameCanonicalizer;->b()V

    .line 205
    iget-boolean v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->O:Z

    if-eqz v0, :cond_0

    .line 206
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    .line 207
    if-eqz v0, :cond_0

    .line 208
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->N:[C

    .line 209
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/ReaderBasedJsonParser;->b:Lcom/fasterxml/jackson/core/io/IOContext;

    invoke-virtual {v1, v0}, Lcom/fasterxml/jackson/core/io/IOContext;->a([C)V

    .line 212
    :cond_0
    return-void
.end method
