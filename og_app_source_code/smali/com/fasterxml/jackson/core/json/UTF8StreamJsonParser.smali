.class public Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;
.super Lcom/fasterxml/jackson/core/base/ParserBase;
.source "UTF8StreamJsonParser.java"


# static fields
.field protected static final L:[I

.field private static final T:[I


# instance fields
.field protected M:Lcom/fasterxml/jackson/core/ObjectCodec;

.field protected final N:Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;

.field protected O:[I

.field protected P:Z

.field protected Q:Ljava/io/InputStream;

.field protected R:[B

.field protected S:Z

.field private U:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 27
    invoke-static {}, Lcom/fasterxml/jackson/core/io/CharTypes;->b()[I

    move-result-object v0

    sput-object v0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->T:[I

    .line 31
    invoke-static {}, Lcom/fasterxml/jackson/core/io/CharTypes;->a()[I

    move-result-object v0

    sput-object v0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->L:[I

    return-void
.end method

.method public constructor <init>(Lcom/fasterxml/jackson/core/io/IOContext;ILjava/io/InputStream;Lcom/fasterxml/jackson/core/ObjectCodec;Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;[BIIZ)V
    .locals 2

    .prologue
    .line 115
    invoke-direct {p0, p1, p2}, Lcom/fasterxml/jackson/core/base/ParserBase;-><init>(Lcom/fasterxml/jackson/core/io/IOContext;I)V

    .line 60
    const/16 v0, 0x10

    new-array v0, v0, [I

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    .line 67
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->P:Z

    .line 116
    iput-object p3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->Q:Ljava/io/InputStream;

    .line 117
    iput-object p4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->M:Lcom/fasterxml/jackson/core/ObjectCodec;

    .line 118
    iput-object p5, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->N:Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;

    .line 119
    iput-object p6, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    .line 120
    iput p7, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 121
    iput p8, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    .line 122
    iput p7, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->h:I

    .line 124
    neg-int v0, p7

    int-to-long v0, v0

    iput-wide v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->f:J

    .line 125
    iput-boolean p9, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->S:Z

    .line 126
    return-void
.end method

.method private final O()Lcom/fasterxml/jackson/core/JsonToken;
    .locals 4

    .prologue
    .line 846
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->p:Z

    .line 847
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->m:Lcom/fasterxml/jackson/core/JsonToken;

    .line 848
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->m:Lcom/fasterxml/jackson/core/JsonToken;

    .line 850
    sget-object v1, Lcom/fasterxml/jackson/core/JsonToken;->START_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v1, :cond_1

    .line 851
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->j:I

    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->k:I

    invoke-virtual {v1, v2, v3}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->a(II)Lcom/fasterxml/jackson/core/json/JsonReadContext;

    move-result-object v1

    iput-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    .line 855
    :cond_0
    :goto_0
    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->K:Lcom/fasterxml/jackson/core/JsonToken;

    return-object v0

    .line 852
    :cond_1
    sget-object v1, Lcom/fasterxml/jackson/core/JsonToken;->START_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v1, :cond_0

    .line 853
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->j:I

    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->k:I

    invoke-virtual {v1, v2, v3}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->b(II)Lcom/fasterxml/jackson/core/json/JsonReadContext;

    move-result-object v1

    iput-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    goto :goto_0
.end method

.method private final P()I
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v4, 0x39

    const/16 v1, 0x30

    .line 1492
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v2, :cond_1

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->p()Z

    move-result v0

    if-nez v0, :cond_1

    move v0, v1

    .line 1518
    :cond_0
    :goto_0
    return v0

    .line 1495
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v2

    and-int/lit16 v0, v0, 0xff

    .line 1497
    if-lt v0, v1, :cond_2

    if-le v0, v4, :cond_3

    :cond_2
    move v0, v1

    .line 1498
    goto :goto_0

    .line 1501
    :cond_3
    sget-object v2, Lcom/fasterxml/jackson/core/JsonParser$Feature;->ALLOW_NUMERIC_LEADING_ZEROS:Lcom/fasterxml/jackson/core/JsonParser$Feature;

    invoke-virtual {p0, v2}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Lcom/fasterxml/jackson/core/JsonParser$Feature;)Z

    move-result v2

    if-nez v2, :cond_4

    .line 1502
    const-string v2, "Leading zeroes not allowed"

    invoke-virtual {p0, v2}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(Ljava/lang/String;)V

    .line 1505
    :cond_4
    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 1506
    if-ne v0, v1, :cond_0

    .line 1507
    :cond_5
    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v2, v3, :cond_6

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->p()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1508
    :cond_6
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v2

    and-int/lit16 v0, v0, 0xff

    .line 1509
    if-lt v0, v1, :cond_7

    if-le v0, v4, :cond_8

    :cond_7
    move v0, v1

    .line 1510
    goto :goto_0

    .line 1512
    :cond_8
    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 1513
    if-eq v0, v1, :cond_5

    goto :goto_0
.end method

.method private final Q()I
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v3, 0x20

    .line 2798
    :cond_0
    :goto_0
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-ge v0, v1, :cond_6

    .line 2799
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v1

    and-int/lit16 v0, v0, 0xff

    .line 2800
    if-le v0, v3, :cond_3

    .line 2801
    const/16 v1, 0x2f

    if-eq v0, v1, :cond_1

    const/16 v1, 0x23

    if-ne v0, v1, :cond_2

    .line 2802
    :cond_1
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 2803
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R()I

    move-result v0

    .line 2818
    :cond_2
    :goto_1
    return v0

    .line 2807
    :cond_3
    if-eq v0, v3, :cond_0

    .line 2808
    const/16 v1, 0xa

    if-ne v0, v1, :cond_4

    .line 2809
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->g:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->g:I

    .line 2810
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->h:I

    goto :goto_0

    .line 2811
    :cond_4
    const/16 v1, 0xd

    if-ne v0, v1, :cond_5

    .line 2812
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->N()V

    goto :goto_0

    .line 2813
    :cond_5
    const/16 v1, 0x9

    if-eq v0, v1, :cond_0

    .line 2814
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(I)V

    goto :goto_0

    .line 2818
    :cond_6
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R()I

    move-result v0

    goto :goto_1
.end method

.method private final R()I
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v3, 0x20

    .line 2823
    :cond_0
    :goto_0
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v1, :cond_1

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->p()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 2824
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v1

    and-int/lit16 v0, v0, 0xff

    .line 2825
    if-le v0, v3, :cond_4

    .line 2826
    const/16 v1, 0x2f

    if-ne v0, v1, :cond_2

    .line 2827
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->V()V

    goto :goto_0

    .line 2830
    :cond_2
    const/16 v1, 0x23

    if-ne v0, v1, :cond_3

    .line 2831
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->X()Z

    move-result v1

    if-nez v1, :cond_0

    .line 2835
    :cond_3
    return v0

    .line 2837
    :cond_4
    if-eq v0, v3, :cond_0

    .line 2838
    const/16 v1, 0xa

    if-ne v0, v1, :cond_5

    .line 2839
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->g:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->g:I

    .line 2840
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->h:I

    goto :goto_0

    .line 2841
    :cond_5
    const/16 v1, 0xd

    if-ne v0, v1, :cond_6

    .line 2842
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->N()V

    goto :goto_0

    .line 2843
    :cond_6
    const/16 v1, 0x9

    if-eq v0, v1, :cond_0

    .line 2844
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(I)V

    goto :goto_0

    .line 2848
    :cond_7
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Unexpected end-of-input within/between "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->d()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " entries"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Ljava/lang/String;)Lcom/fasterxml/jackson/core/JsonParseException;

    move-result-object v0

    throw v0
.end method

.method private final S()I
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

    .line 2855
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v1, :cond_1

    .line 2856
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->p()Z

    move-result v0

    if-nez v0, :cond_1

    .line 2857
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->u()I

    move-result v0

    .line 2899
    :cond_0
    :goto_0
    return v0

    .line 2860
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v1

    and-int/lit16 v0, v0, 0xff

    .line 2861
    if-le v0, v3, :cond_3

    .line 2862
    const/16 v1, 0x2f

    if-eq v0, v1, :cond_2

    if-ne v0, v7, :cond_0

    .line 2863
    :cond_2
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 2864
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->T()I

    move-result v0

    goto :goto_0

    .line 2868
    :cond_3
    if-eq v0, v3, :cond_4

    .line 2869
    if-ne v0, v5, :cond_6

    .line 2870
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->g:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->g:I

    .line 2871
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->h:I

    .line 2879
    :cond_4
    :goto_1
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-ge v0, v1, :cond_b

    .line 2880
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v1

    and-int/lit16 v0, v0, 0xff

    .line 2881
    if-le v0, v3, :cond_8

    .line 2882
    const/16 v1, 0x2f

    if-eq v0, v1, :cond_5

    if-ne v0, v7, :cond_0

    .line 2883
    :cond_5
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 2884
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->T()I

    move-result v0

    goto :goto_0

    .line 2872
    :cond_6
    if-ne v0, v6, :cond_7

    .line 2873
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->N()V

    goto :goto_1

    .line 2874
    :cond_7
    if-eq v0, v4, :cond_4

    .line 2875
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(I)V

    goto :goto_1

    .line 2888
    :cond_8
    if-eq v0, v3, :cond_4

    .line 2889
    if-ne v0, v5, :cond_9

    .line 2890
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->g:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->g:I

    .line 2891
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->h:I

    goto :goto_1

    .line 2892
    :cond_9
    if-ne v0, v6, :cond_a

    .line 2893
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->N()V

    goto :goto_1

    .line 2894
    :cond_a
    if-eq v0, v4, :cond_4

    .line 2895
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(I)V

    goto :goto_1

    .line 2899
    :cond_b
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->T()I

    move-result v0

    goto :goto_0
.end method

.method private final T()I
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v3, 0x20

    .line 2904
    :cond_0
    :goto_0
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v1, :cond_1

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->p()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 2905
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v1

    and-int/lit16 v0, v0, 0xff

    .line 2906
    if-le v0, v3, :cond_4

    .line 2907
    const/16 v1, 0x2f

    if-ne v0, v1, :cond_2

    .line 2908
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->V()V

    goto :goto_0

    .line 2911
    :cond_2
    const/16 v1, 0x23

    if-ne v0, v1, :cond_3

    .line 2912
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->X()Z

    move-result v1

    if-nez v1, :cond_0

    .line 2929
    :cond_3
    :goto_1
    return v0

    .line 2917
    :cond_4
    if-eq v0, v3, :cond_0

    .line 2918
    const/16 v1, 0xa

    if-ne v0, v1, :cond_5

    .line 2919
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->g:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->g:I

    .line 2920
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->h:I

    goto :goto_0

    .line 2921
    :cond_5
    const/16 v1, 0xd

    if-ne v0, v1, :cond_6

    .line 2922
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->N()V

    goto :goto_0

    .line 2923
    :cond_6
    const/16 v1, 0x9

    if-eq v0, v1, :cond_0

    .line 2924
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(I)V

    goto :goto_0

    .line 2929
    :cond_7
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->u()I

    move-result v0

    goto :goto_1
.end method

.method private final U()I
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

    .line 2934
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v0, v0, 0x4

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v1, :cond_0

    .line 2935
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Z)I

    move-result v0

    .line 2984
    :goto_0
    return v0

    .line 2938
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v1

    .line 2939
    const/16 v1, 0x3a

    if-ne v0, v1, :cond_8

    .line 2940
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v1

    .line 2941
    if-le v0, v2, :cond_3

    .line 2942
    if-eq v0, v5, :cond_1

    if-ne v0, v4, :cond_2

    .line 2943
    :cond_1
    invoke-direct {p0, v3}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Z)I

    move-result v0

    goto :goto_0

    .line 2945
    :cond_2
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    goto :goto_0

    .line 2948
    :cond_3
    if-eq v0, v2, :cond_4

    if-ne v0, v6, :cond_7

    .line 2949
    :cond_4
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v1

    .line 2950
    if-le v0, v2, :cond_7

    .line 2951
    if-eq v0, v5, :cond_5

    if-ne v0, v4, :cond_6

    .line 2952
    :cond_5
    invoke-direct {p0, v3}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Z)I

    move-result v0

    goto :goto_0

    .line 2954
    :cond_6
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    goto :goto_0

    .line 2958
    :cond_7
    invoke-direct {p0, v3}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Z)I

    move-result v0

    goto :goto_0

    .line 2960
    :cond_8
    if-eq v0, v2, :cond_9

    if-ne v0, v6, :cond_a

    .line 2961
    :cond_9
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v1

    .line 2963
    :cond_a
    const/16 v1, 0x3a

    if-ne v0, v1, :cond_12

    .line 2964
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v1

    .line 2965
    if-le v0, v2, :cond_d

    .line 2966
    if-eq v0, v5, :cond_b

    if-ne v0, v4, :cond_c

    .line 2967
    :cond_b
    invoke-direct {p0, v3}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Z)I

    move-result v0

    goto :goto_0

    .line 2969
    :cond_c
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    goto :goto_0

    .line 2972
    :cond_d
    if-eq v0, v2, :cond_e

    if-ne v0, v6, :cond_11

    .line 2973
    :cond_e
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v1

    .line 2974
    if-le v0, v2, :cond_11

    .line 2975
    if-eq v0, v5, :cond_f

    if-ne v0, v4, :cond_10

    .line 2976
    :cond_f
    invoke-direct {p0, v3}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Z)I

    move-result v0

    goto/16 :goto_0

    .line 2978
    :cond_10
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    goto/16 :goto_0

    .line 2982
    :cond_11
    invoke-direct {p0, v3}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Z)I

    move-result v0

    goto/16 :goto_0

    .line 2984
    :cond_12
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Z)I

    move-result v0

    goto/16 :goto_0
.end method

.method private final V()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v3, 0x2f

    .line 3028
    sget-object v0, Lcom/fasterxml/jackson/core/JsonParser$Feature;->ALLOW_COMMENTS:Lcom/fasterxml/jackson/core/JsonParser$Feature;

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Lcom/fasterxml/jackson/core/JsonParser$Feature;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 3029
    const-string v0, "maybe a (non-standard) comment? (not recognized as one since Feature \'ALLOW_COMMENTS\' not enabled for parser)"

    invoke-virtual {p0, v3, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(ILjava/lang/String;)V

    .line 3032
    :cond_0
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v1, :cond_1

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->p()Z

    move-result v0

    if-nez v0, :cond_1

    .line 3033
    const-string v0, " in a comment"

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(Ljava/lang/String;)V

    .line 3035
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v1

    and-int/lit16 v0, v0, 0xff

    .line 3036
    if-ne v0, v3, :cond_2

    .line 3037
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->Y()V

    .line 3043
    :goto_0
    return-void

    .line 3038
    :cond_2
    const/16 v1, 0x2a

    if-ne v0, v1, :cond_3

    .line 3039
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->W()V

    goto :goto_0

    .line 3041
    :cond_3
    const-string v1, "was expecting either \'*\' or \'/\' for a comment"

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(ILjava/lang/String;)V

    goto :goto_0
.end method

.method private final W()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 3048
    invoke-static {}, Lcom/fasterxml/jackson/core/io/CharTypes;->e()[I

    move-result-object v0

    .line 3052
    :cond_0
    :goto_0
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v1, v2, :cond_1

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->p()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 3053
    :cond_1
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v1, v1, v2

    and-int/lit16 v1, v1, 0xff

    .line 3054
    aget v2, v0, v1

    .line 3055
    if-eqz v2, :cond_0

    .line 3056
    sparse-switch v2, :sswitch_data_0

    .line 3084
    invoke-virtual {p0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->k(I)V

    goto :goto_0

    .line 3058
    :sswitch_0
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v1, v2, :cond_3

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->p()Z

    move-result v1

    if-nez v1, :cond_3

    .line 3088
    :cond_2
    const-string v0, " in a comment"

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(Ljava/lang/String;)V

    .line 3089
    :goto_1
    return-void

    .line 3061
    :cond_3
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v1, v1, v2

    const/16 v2, 0x2f

    if-ne v1, v2, :cond_0

    .line 3062
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    goto :goto_1

    .line 3067
    :sswitch_1
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->g:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->g:I

    .line 3068
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iput v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->h:I

    goto :goto_0

    .line 3071
    :sswitch_2
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->N()V

    goto :goto_0

    .line 3074
    :sswitch_3
    invoke-direct {p0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->t(I)V

    goto :goto_0

    .line 3077
    :sswitch_4
    invoke-direct {p0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->u(I)V

    goto :goto_0

    .line 3080
    :sswitch_5
    invoke-direct {p0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->v(I)V

    goto :goto_0

    .line 3056
    nop

    :sswitch_data_0
    .sparse-switch
        0x2 -> :sswitch_3
        0x3 -> :sswitch_4
        0x4 -> :sswitch_5
        0xa -> :sswitch_1
        0xd -> :sswitch_2
        0x2a -> :sswitch_0
    .end sparse-switch
.end method

.method private final X()Z
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 3093
    sget-object v0, Lcom/fasterxml/jackson/core/JsonParser$Feature;->ALLOW_YAML_COMMENTS:Lcom/fasterxml/jackson/core/JsonParser$Feature;

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Lcom/fasterxml/jackson/core/JsonParser$Feature;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 3094
    const/4 v0, 0x0

    .line 3097
    :goto_0
    return v0

    .line 3096
    :cond_0
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->Y()V

    .line 3097
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private final Y()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 3107
    invoke-static {}, Lcom/fasterxml/jackson/core/io/CharTypes;->e()[I

    move-result-object v0

    .line 3108
    :cond_0
    :goto_0
    :sswitch_0
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v1, v2, :cond_1

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->p()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 3109
    :cond_1
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v1, v1, v2

    and-int/lit16 v1, v1, 0xff

    .line 3110
    aget v2, v0, v1

    .line 3111
    if-eqz v2, :cond_0

    .line 3112
    sparse-switch v2, :sswitch_data_0

    .line 3132
    if-gez v2, :cond_0

    .line 3134
    invoke-virtual {p0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->k(I)V

    goto :goto_0

    .line 3114
    :sswitch_1
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->g:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->g:I

    .line 3115
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->h:I

    .line 3139
    :cond_2
    :goto_1
    return-void

    .line 3118
    :sswitch_2
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->N()V

    goto :goto_1

    .line 3123
    :sswitch_3
    invoke-direct {p0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->t(I)V

    goto :goto_0

    .line 3126
    :sswitch_4
    invoke-direct {p0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->u(I)V

    goto :goto_0

    .line 3129
    :sswitch_5
    invoke-direct {p0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->v(I)V

    goto :goto_0

    .line 3112
    :sswitch_data_0
    .sparse-switch
        0x2 -> :sswitch_3
        0x3 -> :sswitch_4
        0x4 -> :sswitch_5
        0xa -> :sswitch_1
        0xd -> :sswitch_2
        0x2a -> :sswitch_0
    .end sparse-switch
.end method

.method private Z()I
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 3415
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v1, :cond_0

    .line 3416
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->o()V

    .line 3418
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v1

    and-int/lit16 v0, v0, 0xff

    return v0
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

    .line 2989
    :cond_0
    :goto_0
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v1, :cond_1

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->p()Z

    move-result v0

    if-eqz v0, :cond_a

    .line 2990
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v1

    and-int/lit16 v0, v0, 0xff

    .line 2992
    if-le v0, v3, :cond_7

    .line 2993
    const/16 v1, 0x2f

    if-ne v0, v1, :cond_2

    .line 2994
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->V()V

    goto :goto_0

    .line 2997
    :cond_2
    const/16 v1, 0x23

    if-ne v0, v1, :cond_3

    .line 2998
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->X()Z

    move-result v1

    if-nez v1, :cond_0

    .line 3002
    :cond_3
    if-eqz p1, :cond_4

    .line 3003
    return v0

    .line 3005
    :cond_4
    const/16 v1, 0x3a

    if-eq v0, v1, :cond_6

    .line 3006
    if-ge v0, v3, :cond_5

    .line 3007
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(I)V

    .line 3009
    :cond_5
    const-string v1, "was expecting a colon to separate field name and value"

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(ILjava/lang/String;)V

    .line 3011
    :cond_6
    const/4 p1, 0x1

    goto :goto_0

    .line 3012
    :cond_7
    if-eq v0, v3, :cond_0

    .line 3013
    const/16 v1, 0xa

    if-ne v0, v1, :cond_8

    .line 3014
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->g:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->g:I

    .line 3015
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->h:I

    goto :goto_0

    .line 3016
    :cond_8
    const/16 v1, 0xd

    if-ne v0, v1, :cond_9

    .line 3017
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->N()V

    goto :goto_0

    .line 3018
    :cond_9
    const/16 v1, 0x9

    if-eq v0, v1, :cond_0

    .line 3019
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(I)V

    goto :goto_0

    .line 3023
    :cond_a
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Unexpected end-of-input within/between "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->d()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " entries"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Ljava/lang/String;)Lcom/fasterxml/jackson/core/JsonParseException;

    move-result-object v0

    throw v0
.end method

.method private final a([CIIZI)Lcom/fasterxml/jackson/core/JsonToken;
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1524
    const/4 v0, 0x0

    .line 1525
    const/4 v4, 0x0

    .line 1528
    const/16 v1, 0x2e

    if-ne p3, v1, :cond_12

    .line 1529
    add-int/lit8 v1, p2, 0x1

    int-to-char v2, p3

    aput-char v2, p1, p2

    .line 1533
    :goto_0
    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v2, v3, :cond_9

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->p()Z

    move-result v2

    if-nez v2, :cond_9

    .line 1534
    const/4 v4, 0x1

    move v5, p3

    .line 1549
    :goto_1
    if-nez v0, :cond_0

    .line 1550
    const-string v2, "Decimal point not followed by a digit"

    invoke-virtual {p0, v5, v2}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(ILjava/lang/String;)V

    :cond_0
    move v7, v0

    move v0, v1

    move-object v1, p1

    .line 1554
    :goto_2
    const/4 v3, 0x0

    .line 1555
    const/16 v2, 0x65

    if-eq v5, v2, :cond_1

    const/16 v2, 0x45

    if-ne v5, v2, :cond_f

    .line 1556
    :cond_1
    array-length v2, v1

    if-lt v0, v2, :cond_2

    .line 1557
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->m()[C

    move-result-object v1

    .line 1558
    const/4 v0, 0x0

    .line 1560
    :cond_2
    add-int/lit8 v2, v0, 0x1

    int-to-char v5, v5

    aput-char v5, v1, v0

    .line 1562
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v5, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v5, :cond_3

    .line 1563
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->o()V

    .line 1565
    :cond_3
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v5, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v6, v5, 0x1

    iput v6, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v5

    and-int/lit16 v5, v0, 0xff

    .line 1567
    const/16 v0, 0x2d

    if-eq v5, v0, :cond_4

    const/16 v0, 0x2b

    if-ne v5, v0, :cond_e

    .line 1568
    :cond_4
    array-length v0, v1

    if-lt v2, v0, :cond_d

    .line 1569
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->m()[C

    move-result-object v1

    .line 1570
    const/4 v0, 0x0

    .line 1572
    :goto_3
    add-int/lit8 v6, v0, 0x1

    int-to-char v2, v5

    aput-char v2, v1, v0

    .line 1574
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v2, :cond_5

    .line 1575
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->o()V

    .line 1577
    :cond_5
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v5, v2, 0x1

    iput v5, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v2

    and-int/lit16 v2, v0, 0xff

    move v0, v6

    .line 1581
    :goto_4
    const/16 v5, 0x39

    if-gt v2, v5, :cond_c

    const/16 v5, 0x30

    if-lt v2, v5, :cond_c

    .line 1582
    add-int/lit8 v3, v3, 0x1

    .line 1583
    array-length v5, v1

    if-lt v0, v5, :cond_6

    .line 1584
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->m()[C

    move-result-object v1

    .line 1585
    const/4 v0, 0x0

    .line 1587
    :cond_6
    add-int/lit8 v5, v0, 0x1

    int-to-char v6, v2

    aput-char v6, v1, v0

    .line 1588
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v6, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v6, :cond_b

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->p()Z

    move-result v0

    if-nez v0, :cond_b

    .line 1589
    const/4 v4, 0x1

    move v0, v3

    move v1, v4

    move v3, v5

    .line 1595
    :goto_5
    if-nez v0, :cond_7

    .line 1596
    const-string v4, "Exponent indicator not followed by a digit"

    invoke-virtual {p0, v2, v4}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(ILjava/lang/String;)V

    .line 1601
    :cond_7
    :goto_6
    if-nez v1, :cond_8

    .line 1602
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 1604
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->b()Z

    move-result v1

    if-eqz v1, :cond_8

    .line 1605
    invoke-direct {p0, v2}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->o(I)V

    .line 1608
    :cond_8
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v1, v3}, Lcom/fasterxml/jackson/core/util/TextBuffer;->a(I)V

    .line 1611
    invoke-virtual {p0, p4, p5, v7, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(ZIII)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    return-object v0

    .line 1537
    :cond_9
    iget-object v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v5, v3, 0x1

    iput v5, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v2, v2, v3

    and-int/lit16 p3, v2, 0xff

    .line 1538
    const/16 v2, 0x30

    if-lt p3, v2, :cond_11

    const/16 v2, 0x39

    if-le p3, v2, :cond_a

    move v5, p3

    .line 1539
    goto/16 :goto_1

    .line 1541
    :cond_a
    add-int/lit8 v0, v0, 0x1

    .line 1542
    array-length v2, p1

    if-lt v1, v2, :cond_10

    .line 1543
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/util/TextBuffer;->m()[C

    move-result-object p1

    .line 1544
    const/4 v1, 0x0

    move v2, v1

    .line 1546
    :goto_7
    add-int/lit8 v1, v2, 0x1

    int-to-char v3, p3

    aput-char v3, p1, v2

    goto/16 :goto_0

    .line 1592
    :cond_b
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v6, v2, 0x1

    iput v6, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v2

    and-int/lit16 v2, v0, 0xff

    move v0, v5

    goto/16 :goto_4

    :cond_c
    move v1, v4

    move v8, v3

    move v3, v0

    move v0, v8

    goto :goto_5

    :cond_d
    move v0, v2

    goto/16 :goto_3

    :cond_e
    move v0, v2

    move v2, v5

    goto/16 :goto_4

    :cond_f
    move v1, v4

    move v2, v5

    move v8, v3

    move v3, v0

    move v0, v8

    goto :goto_6

    :cond_10
    move v2, v1

    goto :goto_7

    :cond_11
    move v5, p3

    goto/16 :goto_1

    :cond_12
    move v7, v0

    move v5, p3

    move-object v1, p1

    move v0, p2

    goto/16 :goto_2
.end method

.method private final a([CIZI)Lcom/fasterxml/jackson/core/JsonToken;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1455
    move v5, p4

    move v2, p2

    move-object v1, p1

    :goto_0
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v3, :cond_0

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->p()Z

    move-result v0

    if-nez v0, :cond_0

    .line 1456
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0, v2}, Lcom/fasterxml/jackson/core/util/TextBuffer;->a(I)V

    .line 1457
    invoke-virtual {p0, p3, v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(ZI)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 1481
    :goto_1
    return-object v0

    .line 1459
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v4, v3, 0x1

    iput v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v3

    and-int/lit16 v3, v0, 0xff

    .line 1460
    const/16 v0, 0x39

    if-gt v3, v0, :cond_1

    const/16 v0, 0x30

    if-ge v3, v0, :cond_3

    .line 1461
    :cond_1
    const/16 v0, 0x2e

    if-eq v3, v0, :cond_2

    const/16 v0, 0x65

    if-eq v3, v0, :cond_2

    const/16 v0, 0x45

    if-ne v3, v0, :cond_4

    :cond_2
    move-object v0, p0

    move v4, p3

    .line 1462
    invoke-direct/range {v0 .. v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([CIIZI)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_1

    .line 1466
    :cond_3
    array-length v0, v1

    if-lt v2, v0, :cond_6

    .line 1467
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->m()[C

    move-result-object v1

    .line 1468
    const/4 v2, 0x0

    move v0, v2

    .line 1470
    :goto_2
    add-int/lit8 v2, v0, 0x1

    int-to-char v3, v3

    aput-char v3, v1, v0

    .line 1471
    add-int/lit8 v5, v5, 0x1

    .line 1472
    goto :goto_0

    .line 1473
    :cond_4
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 1474
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0, v2}, Lcom/fasterxml/jackson/core/util/TextBuffer;->a(I)V

    .line 1476
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->b()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 1477
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v1

    and-int/lit16 v0, v0, 0xff

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->o(I)V

    .line 1481
    :cond_5
    invoke-virtual {p0, p3, v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(ZI)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_1

    :cond_6
    move v0, v2

    goto :goto_2
.end method

.method private final a(IIII)Ljava/lang/String;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1878
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    const/4 v1, 0x0

    aput p1, v0, v1

    .line 1879
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    const/4 v2, 0x1

    move-object v0, p0

    move v3, p2

    move v4, p3

    move v5, p4

    invoke-virtual/range {v0 .. v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([IIIII)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private final a(IIIII)Ljava/lang/String;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1883
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    const/4 v1, 0x0

    aput p1, v0, v1

    .line 1884
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    const/4 v1, 0x1

    aput p2, v0, v1

    .line 1885
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    const/4 v2, 0x2

    move-object v0, p0

    move v3, p3

    move v4, p4

    move v5, p5

    invoke-virtual/range {v0 .. v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([IIIII)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private final a([III)Ljava/lang/String;
    .locals 11
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/core/JsonParseException;
        }
    .end annotation

    .prologue
    .line 2245
    shl-int/lit8 v0, p2, 0x2

    add-int/lit8 v0, v0, -0x4

    add-int v6, v0, p3

    .line 2254
    const/4 v0, 0x4

    if-ge p3, v0, :cond_7

    .line 2255
    add-int/lit8 v0, p2, -0x1

    aget v0, p1, v0

    .line 2257
    add-int/lit8 v1, p2, -0x1

    rsub-int/lit8 v2, p3, 0x4

    shl-int/lit8 v2, v2, 0x3

    shl-int v2, v0, v2

    aput v2, p1, v1

    .line 2263
    :goto_0
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/util/TextBuffer;->k()[C

    move-result-object v1

    .line 2264
    const/4 v5, 0x0

    .line 2266
    const/4 v2, 0x0

    move v3, v2

    :goto_1
    if-ge v3, v6, :cond_b

    .line 2267
    shr-int/lit8 v2, v3, 0x2

    aget v2, p1, v2

    .line 2268
    and-int/lit8 v4, v3, 0x3

    .line 2269
    rsub-int/lit8 v4, v4, 0x3

    shl-int/lit8 v4, v4, 0x3

    shr-int/2addr v2, v4

    and-int/lit16 v2, v2, 0xff

    .line 2270
    add-int/lit8 v3, v3, 0x1

    .line 2272
    const/16 v4, 0x7f

    if-le v2, v4, :cond_d

    .line 2274
    and-int/lit16 v4, v2, 0xe0

    const/16 v7, 0xc0

    if-ne v4, v7, :cond_8

    .line 2275
    and-int/lit8 v4, v2, 0x1f

    .line 2276
    const/4 v2, 0x1

    move v10, v2

    move v2, v4

    move v4, v10

    .line 2287
    :goto_2
    add-int v7, v3, v4

    if-le v7, v6, :cond_0

    .line 2288
    const-string v7, " in field name"

    invoke-virtual {p0, v7}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(Ljava/lang/String;)V

    .line 2292
    :cond_0
    shr-int/lit8 v7, v3, 0x2

    aget v7, p1, v7

    .line 2293
    and-int/lit8 v8, v3, 0x3

    .line 2294
    rsub-int/lit8 v8, v8, 0x3

    shl-int/lit8 v8, v8, 0x3

    shr-int/2addr v7, v8

    .line 2295
    add-int/lit8 v3, v3, 0x1

    .line 2297
    and-int/lit16 v8, v7, 0xc0

    const/16 v9, 0x80

    if-eq v8, v9, :cond_1

    .line 2298
    invoke-virtual {p0, v7}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->m(I)V

    .line 2300
    :cond_1
    shl-int/lit8 v2, v2, 0x6

    and-int/lit8 v7, v7, 0x3f

    or-int/2addr v2, v7

    .line 2301
    const/4 v7, 0x1

    if-le v4, v7, :cond_4

    .line 2302
    shr-int/lit8 v7, v3, 0x2

    aget v7, p1, v7

    .line 2303
    and-int/lit8 v8, v3, 0x3

    .line 2304
    rsub-int/lit8 v8, v8, 0x3

    shl-int/lit8 v8, v8, 0x3

    shr-int/2addr v7, v8

    .line 2305
    add-int/lit8 v3, v3, 0x1

    .line 2307
    and-int/lit16 v8, v7, 0xc0

    const/16 v9, 0x80

    if-eq v8, v9, :cond_2

    .line 2308
    invoke-virtual {p0, v7}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->m(I)V

    .line 2310
    :cond_2
    shl-int/lit8 v2, v2, 0x6

    and-int/lit8 v7, v7, 0x3f

    or-int/2addr v2, v7

    .line 2311
    const/4 v7, 0x2

    if-le v4, v7, :cond_4

    .line 2312
    shr-int/lit8 v7, v3, 0x2

    aget v7, p1, v7

    .line 2313
    and-int/lit8 v8, v3, 0x3

    .line 2314
    rsub-int/lit8 v8, v8, 0x3

    shl-int/lit8 v8, v8, 0x3

    shr-int/2addr v7, v8

    .line 2315
    add-int/lit8 v3, v3, 0x1

    .line 2316
    and-int/lit16 v8, v7, 0xc0

    const/16 v9, 0x80

    if-eq v8, v9, :cond_3

    .line 2317
    and-int/lit16 v8, v7, 0xff

    invoke-virtual {p0, v8}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->m(I)V

    .line 2319
    :cond_3
    shl-int/lit8 v2, v2, 0x6

    and-int/lit8 v7, v7, 0x3f

    or-int/2addr v2, v7

    .line 2322
    :cond_4
    const/4 v7, 0x2

    if-le v4, v7, :cond_d

    .line 2323
    const/high16 v4, 0x10000

    sub-int/2addr v2, v4

    .line 2324
    array-length v4, v1

    if-lt v5, v4, :cond_5

    .line 2325
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/util/TextBuffer;->n()[C

    move-result-object v1

    .line 2327
    :cond_5
    add-int/lit8 v4, v5, 0x1

    const v7, 0xd800

    shr-int/lit8 v8, v2, 0xa

    add-int/2addr v7, v8

    int-to-char v7, v7

    aput-char v7, v1, v5

    .line 2328
    const v5, 0xdc00

    and-int/lit16 v2, v2, 0x3ff

    or-int/2addr v2, v5

    move v10, v2

    move v2, v3

    move v3, v4

    move-object v4, v1

    move v1, v10

    .line 2331
    :goto_3
    array-length v5, v4

    if-lt v3, v5, :cond_6

    .line 2332
    iget-object v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v4}, Lcom/fasterxml/jackson/core/util/TextBuffer;->n()[C

    move-result-object v4

    .line 2334
    :cond_6
    add-int/lit8 v5, v3, 0x1

    int-to-char v1, v1

    aput-char v1, v4, v3

    move v3, v2

    move-object v1, v4

    .line 2335
    goto/16 :goto_1

    .line 2259
    :cond_7
    const/4 v0, 0x0

    goto/16 :goto_0

    .line 2277
    :cond_8
    and-int/lit16 v4, v2, 0xf0

    const/16 v7, 0xe0

    if-ne v4, v7, :cond_9

    .line 2278
    and-int/lit8 v4, v2, 0xf

    .line 2279
    const/4 v2, 0x2

    move v10, v2

    move v2, v4

    move v4, v10

    goto/16 :goto_2

    .line 2280
    :cond_9
    and-int/lit16 v4, v2, 0xf8

    const/16 v7, 0xf0

    if-ne v4, v7, :cond_a

    .line 2281
    and-int/lit8 v4, v2, 0x7

    .line 2282
    const/4 v2, 0x3

    move v10, v2

    move v2, v4

    move v4, v10

    goto/16 :goto_2

    .line 2284
    :cond_a
    invoke-virtual {p0, v2}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->l(I)V

    .line 2285
    const/4 v2, 0x1

    move v4, v2

    goto/16 :goto_2

    .line 2338
    :cond_b
    new-instance v2, Ljava/lang/String;

    const/4 v3, 0x0

    invoke-direct {v2, v1, v3, v5}, Ljava/lang/String;-><init>([CII)V

    .line 2340
    const/4 v1, 0x4

    if-ge p3, v1, :cond_c

    .line 2341
    add-int/lit8 v1, p2, -0x1

    aput v0, p1, v1

    .line 2343
    :cond_c
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->N:Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;

    invoke-virtual {v0, v2, p1, p2}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->a(Ljava/lang/String;[II)Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_d
    move-object v4, v1

    move v1, v2

    move v2, v3

    move v3, v5

    goto :goto_3
.end method

.method private final a([IIII)Ljava/lang/String;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/core/JsonParseException;
        }
    .end annotation

    .prologue
    .line 2221
    array-length v0, p1

    if-lt p2, v0, :cond_0

    .line 2222
    array-length v0, p1

    invoke-static {p1, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([II)[I

    move-result-object p1

    iput-object p1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    .line 2224
    :cond_0
    add-int/lit8 v1, p2, 0x1

    invoke-static {p3, p4}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d(II)I

    move-result v0

    aput v0, p1, p2

    .line 2225
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->N:Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;

    invoke-virtual {v0, p1, v1}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->a([II)Ljava/lang/String;

    move-result-object v0

    .line 2226
    if-nez v0, :cond_1

    .line 2227
    invoke-direct {p0, p1, v1, p4}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([III)Ljava/lang/String;

    move-result-object v0

    .line 2229
    :cond_1
    return-object v0
.end method

.method private final a(Ljava/lang/String;II)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2784
    invoke-virtual {p0, p3}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->j(I)I

    move-result v0

    int-to-char v0, v0

    .line 2785
    invoke-static {v0}, Ljava/lang/Character;->isJavaIdentifierPart(C)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2786
    const/4 v0, 0x0

    invoke-virtual {p1, v0, p2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e(Ljava/lang/String;)V

    .line 2788
    :cond_0
    return-void
.end method

.method private final a([CI)V
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 2424
    sget-object v4, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->T:[I

    .line 2425
    iget-object v5, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    .line 2432
    :goto_0
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 2433
    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v2, :cond_0

    .line 2434
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->o()V

    .line 2435
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 2437
    :cond_0
    array-length v2, p1

    if-lt p2, v2, :cond_1

    .line 2438
    iget-object v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v2}, Lcom/fasterxml/jackson/core/util/TextBuffer;->m()[C

    move-result-object p1

    move p2, v1

    .line 2441
    :cond_1
    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    array-length v3, p1

    sub-int/2addr v3, p2

    add-int/2addr v3, v0

    invoke-static {v2, v3}, Ljava/lang/Math;->min(II)I

    move-result v6

    .line 2442
    :goto_1
    if-ge v0, v6, :cond_3

    .line 2443
    add-int/lit8 v2, v0, 0x1

    aget-byte v0, v5, v0

    and-int/lit16 v0, v0, 0xff

    .line 2444
    aget v3, v4, v0

    if-eqz v3, :cond_2

    .line 2445
    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 2453
    const/16 v2, 0x22

    if-ne v0, v2, :cond_4

    .line 2499
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0, p2}, Lcom/fasterxml/jackson/core/util/TextBuffer;->a(I)V

    .line 2500
    return-void

    .line 2448
    :cond_2
    add-int/lit8 v3, p2, 0x1

    int-to-char v0, v0

    aput-char v0, p1, p2

    move v0, v2

    move p2, v3

    goto :goto_1

    .line 2450
    :cond_3
    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    goto :goto_0

    .line 2457
    :cond_4
    aget v2, v4, v0

    packed-switch v2, :pswitch_data_0

    .line 2483
    const/16 v2, 0x20

    if-ge v0, v2, :cond_7

    .line 2485
    const-string v2, "string value"

    invoke-virtual {p0, v0, v2}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(ILjava/lang/String;)V

    .line 2492
    :goto_2
    array-length v2, p1

    if-lt p2, v2, :cond_8

    .line 2493
    iget-object v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v2}, Lcom/fasterxml/jackson/core/util/TextBuffer;->m()[C

    move-result-object p1

    move v2, v1

    .line 2497
    :goto_3
    add-int/lit8 p2, v2, 0x1

    int-to-char v0, v0

    aput-char v0, p1, v2

    goto :goto_0

    .line 2459
    :pswitch_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->D()C

    move-result v0

    goto :goto_2

    .line 2462
    :pswitch_1
    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->p(I)I

    move-result v0

    goto :goto_2

    .line 2465
    :pswitch_2
    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    sub-int/2addr v2, v3

    const/4 v3, 0x2

    if-lt v2, v3, :cond_5

    .line 2466
    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->r(I)I

    move-result v0

    goto :goto_2

    .line 2468
    :cond_5
    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->q(I)I

    move-result v0

    goto :goto_2

    .line 2472
    :pswitch_3
    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->s(I)I

    move-result v2

    .line 2474
    add-int/lit8 v0, p2, 0x1

    const v3, 0xd800

    shr-int/lit8 v6, v2, 0xa

    or-int/2addr v3, v6

    int-to-char v3, v3

    aput-char v3, p1, p2

    .line 2475
    array-length v3, p1

    if-lt v0, v3, :cond_6

    .line 2476
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->m()[C

    move-result-object p1

    move v0, v1

    .line 2479
    :cond_6
    const v3, 0xdc00

    and-int/lit16 v2, v2, 0x3ff

    or-int/2addr v2, v3

    move p2, v0

    move v0, v2

    .line 2481
    goto :goto_2

    .line 2488
    :cond_7
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->k(I)V

    goto :goto_2

    :cond_8
    move v2, p2

    goto :goto_3

    .line 2457
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public static a([II)[I
    .locals 1

    .prologue
    .line 3485
    if-nez p0, :cond_0

    .line 3486
    new-array v0, p1, [I

    .line 3488
    :goto_0
    return-object v0

    :cond_0
    array-length v0, p0

    add-int/2addr v0, p1

    invoke-static {p0, v0}, Ljava/util/Arrays;->copyOf([II)[I

    move-result-object v0

    goto :goto_0
.end method

.method private final b(III)Ljava/lang/String;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1874
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    const/4 v2, 0x0

    move-object v0, p0

    move v3, p1

    move v4, p2

    move v5, p3

    invoke-virtual/range {v0 .. v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([IIIII)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private final b(IIII)Ljava/lang/String;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/core/JsonParseException;
        }
    .end annotation

    .prologue
    .line 2207
    invoke-static {p3, p4}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d(II)I

    move-result v1

    .line 2208
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->N:Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;

    invoke-virtual {v0, p1, p2, v1}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->a(III)Ljava/lang/String;

    move-result-object v0

    .line 2209
    if-eqz v0, :cond_0

    .line 2216
    :goto_0
    return-object v0

    .line 2212
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    .line 2213
    const/4 v2, 0x0

    aput p1, v0, v2

    .line 2214
    const/4 v2, 0x1

    aput p2, v0, v2

    .line 2215
    const/4 v2, 0x2

    invoke-static {v1, p4}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d(II)I

    move-result v1

    aput v1, v0, v2

    .line 2216
    const/4 v1, 0x3

    invoke-direct {p0, v0, v1, p4}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([III)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private final b(Ljava/lang/String;I)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2763
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    .line 2765
    :cond_0
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v1, v2, :cond_1

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->p()Z

    move-result v1

    if-eqz v1, :cond_2

    :cond_1
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v1, v1, v2

    invoke-virtual {p1, p2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    if-eq v1, v2, :cond_3

    .line 2767
    :cond_2
    const/4 v1, 0x0

    invoke-virtual {p1, v1, p2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e(Ljava/lang/String;)V

    .line 2769
    :cond_3
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 2770
    add-int/lit8 p2, p2, 0x1

    if-lt p2, v0, :cond_0

    .line 2773
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v1, :cond_5

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->p()Z

    move-result v0

    if-nez v0, :cond_5

    .line 2780
    :cond_4
    :goto_0
    return-void

    .line 2776
    :cond_5
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v1

    and-int/lit16 v0, v0, 0xff

    .line 2777
    const/16 v1, 0x30

    if-lt v0, v1, :cond_4

    const/16 v1, 0x5d

    if-eq v0, v1, :cond_4

    const/16 v1, 0x7d

    if-eq v0, v1, :cond_4

    .line 2778
    invoke-direct {p0, p1, p2, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Ljava/lang/String;II)V

    goto :goto_0
.end method

.method private final c(II)Ljava/lang/String;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/core/JsonParseException;
        }
    .end annotation

    .prologue
    .line 2180
    invoke-static {p1, p2}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d(II)I

    move-result v1

    .line 2182
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->N:Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->c(I)Ljava/lang/String;

    move-result-object v0

    .line 2183
    if-eqz v0, :cond_0

    .line 2188
    :goto_0
    return-object v0

    .line 2187
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    const/4 v2, 0x0

    aput v1, v0, v2

    .line 2188
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    const/4 v1, 0x1

    invoke-direct {p0, v0, v1, p2}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([III)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private final c(III)Ljava/lang/String;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/core/JsonParseException;
        }
    .end annotation

    .prologue
    .line 2193
    invoke-static {p2, p3}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d(II)I

    move-result v1

    .line 2195
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->N:Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;

    invoke-virtual {v0, p1, v1}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->a(II)Ljava/lang/String;

    move-result-object v0

    .line 2196
    if-eqz v0, :cond_0

    .line 2202
    :goto_0
    return-object v0

    .line 2200
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    const/4 v2, 0x0

    aput p1, v0, v2

    .line 2201
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    const/4 v2, 0x1

    aput v1, v0, v2

    .line 2202
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    const/4 v1, 0x2

    invoke-direct {p0, v0, v1, p3}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([III)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private static final d(II)I
    .locals 2

    .prologue
    .line 3619
    const/4 v0, 0x4

    if-ne p1, v0, :cond_0

    :goto_0
    return p0

    :cond_0
    const/4 v0, -0x1

    shl-int/lit8 v1, p1, 0x3

    shl-int/2addr v0, v1

    or-int/2addr p0, v0

    goto :goto_0
.end method

.method private final n(I)Lcom/fasterxml/jackson/core/JsonToken;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    .line 803
    const/16 v0, 0x22

    if-ne p1, v0, :cond_0

    .line 804
    iput-boolean v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->P:Z

    .line 805
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_STRING:Lcom/fasterxml/jackson/core/JsonToken;

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->K:Lcom/fasterxml/jackson/core/JsonToken;

    .line 841
    :goto_0
    return-object v0

    .line 807
    :cond_0
    sparse-switch p1, :sswitch_data_0

    .line 841
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->i(I)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->K:Lcom/fasterxml/jackson/core/JsonToken;

    goto :goto_0

    .line 809
    :sswitch_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->j:I

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->k:I

    invoke-virtual {v0, v1, v2}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->a(II)Lcom/fasterxml/jackson/core/json/JsonReadContext;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    .line 810
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->START_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->K:Lcom/fasterxml/jackson/core/JsonToken;

    goto :goto_0

    .line 812
    :sswitch_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->j:I

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->k:I

    invoke-virtual {v0, v1, v2}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->b(II)Lcom/fasterxml/jackson/core/json/JsonReadContext;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    .line 813
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->START_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->K:Lcom/fasterxml/jackson/core/JsonToken;

    goto :goto_0

    .line 815
    :sswitch_2
    const-string v0, "true"

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Ljava/lang/String;I)V

    .line 816
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_TRUE:Lcom/fasterxml/jackson/core/JsonToken;

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->K:Lcom/fasterxml/jackson/core/JsonToken;

    goto :goto_0

    .line 818
    :sswitch_3
    const-string v0, "false"

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Ljava/lang/String;I)V

    .line 819
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_FALSE:Lcom/fasterxml/jackson/core/JsonToken;

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->K:Lcom/fasterxml/jackson/core/JsonToken;

    goto :goto_0

    .line 821
    :sswitch_4
    const-string v0, "null"

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Ljava/lang/String;I)V

    .line 822
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NULL:Lcom/fasterxml/jackson/core/JsonToken;

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->K:Lcom/fasterxml/jackson/core/JsonToken;

    goto :goto_0

    .line 824
    :sswitch_5
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->H()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->K:Lcom/fasterxml/jackson/core/JsonToken;

    goto :goto_0

    .line 839
    :sswitch_6
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e(I)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->K:Lcom/fasterxml/jackson/core/JsonToken;

    goto :goto_0

    .line 807
    :sswitch_data_0
    .sparse-switch
        0x2d -> :sswitch_5
        0x30 -> :sswitch_6
        0x31 -> :sswitch_6
        0x32 -> :sswitch_6
        0x33 -> :sswitch_6
        0x34 -> :sswitch_6
        0x35 -> :sswitch_6
        0x36 -> :sswitch_6
        0x37 -> :sswitch_6
        0x38 -> :sswitch_6
        0x39 -> :sswitch_6
        0x5b -> :sswitch_0
        0x66 -> :sswitch_3
        0x6e -> :sswitch_4
        0x74 -> :sswitch_2
        0x7b -> :sswitch_1
    .end sparse-switch
.end method

.method private final o(I)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1624
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 1626
    sparse-switch p1, :sswitch_data_0

    .line 1638
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(I)V

    .line 1639
    :goto_0
    :sswitch_0
    return-void

    .line 1631
    :sswitch_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->N()V

    goto :goto_0

    .line 1634
    :sswitch_2
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->g:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->g:I

    .line 1635
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->h:I

    goto :goto_0

    .line 1626
    :sswitch_data_0
    .sparse-switch
        0x9 -> :sswitch_0
        0xa -> :sswitch_2
        0xd -> :sswitch_1
        0x20 -> :sswitch_0
    .end sparse-switch
.end method

.method private final p(I)I
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 3249
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v1, :cond_0

    .line 3250
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->o()V

    .line 3252
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v1

    .line 3253
    and-int/lit16 v1, v0, 0xc0

    const/16 v2, 0x80

    if-eq v1, v2, :cond_1

    .line 3254
    and-int/lit16 v1, v0, 0xff

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    invoke-virtual {p0, v1, v2}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(II)V

    .line 3256
    :cond_1
    and-int/lit8 v1, p1, 0x1f

    shl-int/lit8 v1, v1, 0x6

    and-int/lit8 v0, v0, 0x3f

    or-int/2addr v0, v1

    return v0
.end method

.method private final q(I)I
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v4, 0x80

    .line 3261
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v1, :cond_0

    .line 3262
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->o()V

    .line 3264
    :cond_0
    and-int/lit8 v0, p1, 0xf

    .line 3265
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v1, v1, v2

    .line 3266
    and-int/lit16 v2, v1, 0xc0

    if-eq v2, v4, :cond_1

    .line 3267
    and-int/lit16 v2, v1, 0xff

    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    invoke-virtual {p0, v2, v3}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(II)V

    .line 3269
    :cond_1
    shl-int/lit8 v0, v0, 0x6

    and-int/lit8 v1, v1, 0x3f

    or-int/2addr v0, v1

    .line 3270
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v1, v2, :cond_2

    .line 3271
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->o()V

    .line 3273
    :cond_2
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v1, v1, v2

    .line 3274
    and-int/lit16 v2, v1, 0xc0

    if-eq v2, v4, :cond_3

    .line 3275
    and-int/lit16 v2, v1, 0xff

    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    invoke-virtual {p0, v2, v3}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(II)V

    .line 3277
    :cond_3
    shl-int/lit8 v0, v0, 0x6

    and-int/lit8 v1, v1, 0x3f

    or-int/2addr v0, v1

    .line 3278
    return v0
.end method

.method private final r(I)I
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v4, 0x80

    .line 3283
    and-int/lit8 v0, p1, 0xf

    .line 3284
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v1, v1, v2

    .line 3285
    and-int/lit16 v2, v1, 0xc0

    if-eq v2, v4, :cond_0

    .line 3286
    and-int/lit16 v2, v1, 0xff

    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    invoke-virtual {p0, v2, v3}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(II)V

    .line 3288
    :cond_0
    shl-int/lit8 v0, v0, 0x6

    and-int/lit8 v1, v1, 0x3f

    or-int/2addr v0, v1

    .line 3289
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v1, v1, v2

    .line 3290
    and-int/lit16 v2, v1, 0xc0

    if-eq v2, v4, :cond_1

    .line 3291
    and-int/lit16 v2, v1, 0xff

    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    invoke-virtual {p0, v2, v3}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(II)V

    .line 3293
    :cond_1
    shl-int/lit8 v0, v0, 0x6

    and-int/lit8 v1, v1, 0x3f

    or-int/2addr v0, v1

    .line 3294
    return v0
.end method

.method private final s(I)I
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v4, 0x80

    .line 3303
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v1, :cond_0

    .line 3304
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->o()V

    .line 3306
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v1

    .line 3307
    and-int/lit16 v1, v0, 0xc0

    if-eq v1, v4, :cond_1

    .line 3308
    and-int/lit16 v1, v0, 0xff

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    invoke-virtual {p0, v1, v2}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(II)V

    .line 3310
    :cond_1
    and-int/lit8 v1, p1, 0x7

    shl-int/lit8 v1, v1, 0x6

    and-int/lit8 v0, v0, 0x3f

    or-int/2addr v0, v1

    .line 3312
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v1, v2, :cond_2

    .line 3313
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->o()V

    .line 3315
    :cond_2
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v1, v1, v2

    .line 3316
    and-int/lit16 v2, v1, 0xc0

    if-eq v2, v4, :cond_3

    .line 3317
    and-int/lit16 v2, v1, 0xff

    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    invoke-virtual {p0, v2, v3}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(II)V

    .line 3319
    :cond_3
    shl-int/lit8 v0, v0, 0x6

    and-int/lit8 v1, v1, 0x3f

    or-int/2addr v0, v1

    .line 3320
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v1, v2, :cond_4

    .line 3321
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->o()V

    .line 3323
    :cond_4
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v1, v1, v2

    .line 3324
    and-int/lit16 v2, v1, 0xc0

    if-eq v2, v4, :cond_5

    .line 3325
    and-int/lit16 v2, v1, 0xff

    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    invoke-virtual {p0, v2, v3}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(II)V

    .line 3331
    :cond_5
    shl-int/lit8 v0, v0, 0x6

    and-int/lit8 v1, v1, 0x3f

    or-int/2addr v0, v1

    const/high16 v1, 0x10000

    sub-int/2addr v0, v1

    return v0
.end method

.method private final t(I)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 3336
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v1, :cond_0

    .line 3337
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->o()V

    .line 3339
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v1

    .line 3340
    and-int/lit16 v1, v0, 0xc0

    const/16 v2, 0x80

    if-eq v1, v2, :cond_1

    .line 3341
    and-int/lit16 v0, v0, 0xff

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(II)V

    .line 3343
    :cond_1
    return-void
.end method

.method private final u(I)V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v3, 0x80

    .line 3350
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v1, :cond_0

    .line 3351
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->o()V

    .line 3354
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v1

    .line 3355
    and-int/lit16 v1, v0, 0xc0

    if-eq v1, v3, :cond_1

    .line 3356
    and-int/lit16 v0, v0, 0xff

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(II)V

    .line 3358
    :cond_1
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v1, :cond_2

    .line 3359
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->o()V

    .line 3361
    :cond_2
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v1

    .line 3362
    and-int/lit16 v1, v0, 0xc0

    if-eq v1, v3, :cond_3

    .line 3363
    and-int/lit16 v0, v0, 0xff

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(II)V

    .line 3365
    :cond_3
    return-void
.end method

.method private final v(I)V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v3, 0x80

    .line 3369
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v1, :cond_0

    .line 3370
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->o()V

    .line 3372
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v1

    .line 3373
    and-int/lit16 v1, v0, 0xc0

    if-eq v1, v3, :cond_1

    .line 3374
    and-int/lit16 v0, v0, 0xff

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(II)V

    .line 3376
    :cond_1
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v1, :cond_2

    .line 3377
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->o()V

    .line 3379
    :cond_2
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v1

    .line 3380
    and-int/lit16 v1, v0, 0xc0

    if-eq v1, v3, :cond_3

    .line 3381
    and-int/lit16 v0, v0, 0xff

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(II)V

    .line 3383
    :cond_3
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v1, :cond_4

    .line 3384
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->o()V

    .line 3386
    :cond_4
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v1

    .line 3387
    and-int/lit16 v1, v0, 0xc0

    if-eq v1, v3, :cond_5

    .line 3388
    and-int/lit16 v0, v0, 0xff

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(II)V

    .line 3390
    :cond_5
    return-void
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
    const/4 v0, 0x0

    .line 3144
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v1, v2, :cond_0

    .line 3145
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->p()Z

    move-result v1

    if-nez v1, :cond_0

    .line 3146
    const-string v1, " in character escape sequence"

    invoke-virtual {p0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(Ljava/lang/String;)V

    .line 3149
    :cond_0
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v1, v1, v2

    .line 3151
    sparse-switch v1, :sswitch_data_0

    .line 3174
    invoke-virtual {p0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->j(I)I

    move-result v0

    int-to-char v0, v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(C)C

    move-result v0

    .line 3192
    :goto_0
    return v0

    .line 3154
    :sswitch_0
    const/16 v0, 0x8

    goto :goto_0

    .line 3156
    :sswitch_1
    const/16 v0, 0x9

    goto :goto_0

    .line 3158
    :sswitch_2
    const/16 v0, 0xa

    goto :goto_0

    .line 3160
    :sswitch_3
    const/16 v0, 0xc

    goto :goto_0

    .line 3162
    :sswitch_4
    const/16 v0, 0xd

    goto :goto_0

    .line 3168
    :sswitch_5
    int-to-char v0, v1

    goto :goto_0

    :sswitch_6
    move v1, v0

    .line 3179
    :goto_1
    const/4 v2, 0x4

    if-ge v0, v2, :cond_3

    .line 3180
    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v2, v3, :cond_1

    .line 3181
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->p()Z

    move-result v2

    if-nez v2, :cond_1

    .line 3182
    const-string v2, " in character escape sequence"

    invoke-virtual {p0, v2}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(Ljava/lang/String;)V

    .line 3185
    :cond_1
    iget-object v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v4, v3, 0x1

    iput v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v2, v2, v3

    .line 3186
    invoke-static {v2}, Lcom/fasterxml/jackson/core/io/CharTypes;->a(I)I

    move-result v3

    .line 3187
    if-gez v3, :cond_2

    .line 3188
    const-string v4, "expected a hex-digit for character escape sequence"

    invoke-virtual {p0, v2, v4}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(ILjava/lang/String;)V

    .line 3190
    :cond_2
    shl-int/lit8 v1, v1, 0x4

    or-int/2addr v1, v3

    .line 3179
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 3192
    :cond_3
    int-to-char v0, v1

    goto :goto_0

    .line 3151
    :sswitch_data_0
    .sparse-switch
        0x22 -> :sswitch_5
        0x2f -> :sswitch_5
        0x5c -> :sswitch_5
        0x62 -> :sswitch_0
        0x66 -> :sswitch_3
        0x6e -> :sswitch_2
        0x72 -> :sswitch_4
        0x74 -> :sswitch_1
        0x75 -> :sswitch_6
    .end sparse-switch
.end method

.method protected H()Lcom/fasterxml/jackson/core/JsonToken;
    .locals 10
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v9, 0x39

    const/16 v8, 0x30

    const/4 v4, 0x1

    .line 1387
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->k()[C

    move-result-object v1

    .line 1388
    const/4 v0, 0x0

    .line 1391
    const/16 v2, 0x2d

    aput-char v2, v1, v0

    .line 1393
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v2, :cond_0

    .line 1394
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->o()V

    .line 1396
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v2

    and-int/lit16 v0, v0, 0xff

    .line 1398
    if-lt v0, v8, :cond_1

    if-le v0, v9, :cond_2

    .line 1399
    :cond_1
    invoke-virtual {p0, v0, v4}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(IZ)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 1443
    :goto_0
    return-object v0

    .line 1403
    :cond_2
    if-ne v0, v8, :cond_3

    .line 1404
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->P()I

    move-result v0

    .line 1408
    :cond_3
    const/4 v2, 0x2

    int-to-char v0, v0

    aput-char v0, v1, v4

    .line 1413
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    array-length v3, v1

    add-int/2addr v0, v3

    add-int/lit8 v0, v0, -0x2

    .line 1414
    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-le v0, v3, :cond_a

    .line 1415
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    move v5, v4

    .line 1420
    :goto_1
    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    if-lt v3, v0, :cond_4

    .line 1422
    invoke-direct {p0, v1, v2, v4, v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([CIZI)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_0

    .line 1424
    :cond_4
    iget-object v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v6, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v7, v6, 0x1

    iput v7, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v3, v3, v6

    and-int/lit16 v3, v3, 0xff

    .line 1425
    if-lt v3, v8, :cond_5

    if-le v3, v9, :cond_7

    .line 1431
    :cond_5
    const/16 v0, 0x2e

    if-eq v3, v0, :cond_6

    const/16 v0, 0x65

    if-eq v3, v0, :cond_6

    const/16 v0, 0x45

    if-ne v3, v0, :cond_8

    :cond_6
    move-object v0, p0

    .line 1432
    invoke-direct/range {v0 .. v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([CIIZI)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_0

    .line 1428
    :cond_7
    add-int/lit8 v5, v5, 0x1

    .line 1429
    add-int/lit8 v6, v2, 0x1

    int-to-char v3, v3

    aput-char v3, v1, v2

    move v2, v6

    goto :goto_1

    .line 1435
    :cond_8
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 1436
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0, v2}, Lcom/fasterxml/jackson/core/util/TextBuffer;->a(I)V

    .line 1438
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->b()Z

    move-result v0

    if-eqz v0, :cond_9

    .line 1439
    invoke-direct {p0, v3}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->o(I)V

    .line 1443
    :cond_9
    invoke-virtual {p0, v4, v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(ZI)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_0

    :cond_a
    move v5, v4

    goto :goto_1
.end method

.method protected I()Ljava/lang/String;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 1861
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v1, :cond_0

    .line 1862
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->p()Z

    move-result v0

    if-nez v0, :cond_0

    .line 1863
    const-string v0, ": was expecting closing \'\"\' for name"

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(Ljava/lang/String;)V

    .line 1866
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v3, v1, 0x1

    iput v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v1

    and-int/lit16 v4, v0, 0xff

    .line 1867
    const/16 v0, 0x22

    if-ne v4, v0, :cond_1

    .line 1868
    const-string v0, ""

    .line 1870
    :goto_0
    return-object v0

    :cond_1
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    move-object v0, p0

    move v3, v2

    move v5, v2

    invoke-virtual/range {v0 .. v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([IIIII)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method protected J()Ljava/lang/String;
    .locals 12
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v10, 0x27

    const/4 v9, 0x4

    const/4 v1, 0x0

    .line 2069
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v2, :cond_0

    .line 2070
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->p()Z

    move-result v0

    if-nez v0, :cond_0

    .line 2071
    const-string v0, ": was expecting closing \'\'\' for name"

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(Ljava/lang/String;)V

    .line 2074
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v2

    and-int/lit16 v5, v0, 0xff

    .line 2075
    if-ne v5, v10, :cond_1

    .line 2076
    const-string v0, ""

    .line 2169
    :goto_0
    return-object v0

    .line 2078
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    .line 2085
    sget-object v7, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->L:[I

    move v3, v1

    move v4, v1

    move v2, v1

    .line 2088
    :goto_1
    if-ne v5, v10, :cond_3

    .line 2159
    if-lez v3, :cond_c

    .line 2160
    array-length v1, v0

    if-lt v2, v1, :cond_2

    .line 2161
    array-length v1, v0

    invoke-static {v0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([II)[I

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    .line 2163
    :cond_2
    add-int/lit8 v1, v2, 0x1

    invoke-static {v4, v3}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d(II)I

    move-result v4

    aput v4, v0, v2

    move v11, v1

    move-object v1, v0

    move v0, v11

    .line 2165
    :goto_2
    iget-object v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->N:Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;

    invoke-virtual {v2, v1, v0}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->a([II)Ljava/lang/String;

    move-result-object v2

    .line 2166
    if-nez v2, :cond_b

    .line 2167
    invoke-direct {p0, v1, v0, v3}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([III)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 2092
    :cond_3
    const/16 v6, 0x22

    if-eq v5, v6, :cond_f

    aget v6, v7, v5

    if-eqz v6, :cond_f

    .line 2093
    const/16 v6, 0x5c

    if-eq v5, v6, :cond_6

    .line 2096
    const-string v6, "name"

    invoke-virtual {p0, v5, v6}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(ILjava/lang/String;)V

    .line 2106
    :goto_3
    const/16 v6, 0x7f

    if-le v5, v6, :cond_f

    .line 2108
    if-lt v3, v9, :cond_e

    .line 2109
    array-length v3, v0

    if-lt v2, v3, :cond_4

    .line 2110
    array-length v3, v0

    invoke-static {v0, v3}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([II)[I

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    .line 2112
    :cond_4
    add-int/lit8 v3, v2, 0x1

    aput v4, v0, v2

    move v2, v1

    move v4, v3

    move v3, v1

    .line 2116
    :goto_4
    const/16 v6, 0x800

    if-ge v5, v6, :cond_7

    .line 2117
    shl-int/lit8 v3, v3, 0x8

    shr-int/lit8 v6, v5, 0x6

    or-int/lit16 v6, v6, 0xc0

    or-int/2addr v3, v6

    .line 2118
    add-int/lit8 v2, v2, 0x1

    move v11, v2

    move v2, v3

    move-object v3, v0

    move v0, v11

    .line 2136
    :goto_5
    and-int/lit8 v5, v5, 0x3f

    or-int/lit16 v5, v5, 0x80

    move v6, v2

    move v2, v0

    move-object v0, v3

    move v3, v5

    .line 2140
    :goto_6
    if-ge v2, v9, :cond_9

    .line 2141
    add-int/lit8 v2, v2, 0x1

    .line 2142
    shl-int/lit8 v5, v6, 0x8

    or-int/2addr v3, v5

    move v11, v2

    move v2, v3

    move v3, v4

    move-object v4, v0

    move v0, v11

    .line 2151
    :goto_7
    iget v5, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v6, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v5, v6, :cond_5

    .line 2152
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->p()Z

    move-result v5

    if-nez v5, :cond_5

    .line 2153
    const-string v5, " in field name"

    invoke-virtual {p0, v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(Ljava/lang/String;)V

    .line 2156
    :cond_5
    iget-object v5, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v6, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v8, v6, 0x1

    iput v8, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v5, v5, v6

    and-int/lit16 v5, v5, 0xff

    move v11, v0

    move-object v0, v4

    move v4, v2

    move v2, v3

    move v3, v11

    goto/16 :goto_1

    .line 2099
    :cond_6
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->D()C

    move-result v5

    goto :goto_3

    .line 2121
    :cond_7
    shl-int/lit8 v3, v3, 0x8

    shr-int/lit8 v6, v5, 0xc

    or-int/lit16 v6, v6, 0xe0

    or-int/2addr v3, v6

    .line 2122
    add-int/lit8 v2, v2, 0x1

    .line 2124
    if-lt v2, v9, :cond_d

    .line 2125
    array-length v2, v0

    if-lt v4, v2, :cond_8

    .line 2126
    array-length v2, v0

    invoke-static {v0, v2}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([II)[I

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    .line 2128
    :cond_8
    add-int/lit8 v2, v4, 0x1

    aput v3, v0, v4

    move v3, v2

    move-object v4, v0

    move v0, v1

    move v2, v1

    .line 2132
    :goto_8
    shl-int/lit8 v2, v2, 0x8

    shr-int/lit8 v6, v5, 0x6

    and-int/lit8 v6, v6, 0x3f

    or-int/lit16 v6, v6, 0x80

    or-int/2addr v2, v6

    .line 2133
    add-int/lit8 v0, v0, 0x1

    move v11, v3

    move-object v3, v4

    move v4, v11

    goto :goto_5

    .line 2144
    :cond_9
    array-length v2, v0

    if-lt v4, v2, :cond_a

    .line 2145
    array-length v2, v0

    invoke-static {v0, v2}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([II)[I

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    .line 2147
    :cond_a
    add-int/lit8 v5, v4, 0x1

    aput v6, v0, v4

    .line 2149
    const/4 v2, 0x1

    move-object v4, v0

    move v0, v2

    move v2, v3

    move v3, v5

    goto :goto_7

    :cond_b
    move-object v0, v2

    goto/16 :goto_0

    :cond_c
    move-object v1, v0

    move v0, v2

    goto/16 :goto_2

    :cond_d
    move v11, v2

    move v2, v3

    move v3, v4

    move-object v4, v0

    move v0, v11

    goto :goto_8

    :cond_e
    move v11, v3

    move v3, v4

    move v4, v2

    move v2, v11

    goto/16 :goto_4

    :cond_f
    move v6, v4

    move v4, v2

    move v2, v3

    move v3, v5

    goto/16 :goto_6
.end method

.method protected K()Ljava/lang/String;
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2390
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 2391
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v1, :cond_0

    .line 2392
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->o()V

    .line 2393
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 2395
    :cond_0
    const/4 v1, 0x0

    .line 2396
    iget-object v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v2}, Lcom/fasterxml/jackson/core/util/TextBuffer;->k()[C

    move-result-object v3

    .line 2397
    sget-object v4, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->T:[I

    .line 2399
    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    array-length v5, v3

    add-int/2addr v5, v0

    invoke-static {v2, v5}, Ljava/lang/Math;->min(II)I

    move-result v5

    .line 2400
    iget-object v6, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    move v8, v1

    move v1, v0

    move v0, v8

    .line 2401
    :goto_0
    if-ge v1, v5, :cond_2

    .line 2402
    aget-byte v2, v6, v1

    and-int/lit16 v7, v2, 0xff

    .line 2403
    aget v2, v4, v7

    if-eqz v2, :cond_1

    .line 2404
    const/16 v2, 0x22

    if-ne v7, v2, :cond_2

    .line 2405
    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 2406
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v1, v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->b(I)Ljava/lang/String;

    move-result-object v0

    .line 2415
    :goto_1
    return-object v0

    .line 2410
    :cond_1
    add-int/lit8 v2, v1, 0x1

    .line 2411
    add-int/lit8 v1, v0, 0x1

    int-to-char v7, v7

    aput-char v7, v3, v0

    move v0, v1

    move v1, v2

    .line 2412
    goto :goto_0

    .line 2413
    :cond_2
    iput v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 2414
    invoke-direct {p0, v3, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([CI)V

    .line 2415
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->f()Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method

.method protected L()V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2509
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->P:Z

    .line 2512
    sget-object v3, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->T:[I

    .line 2513
    iget-object v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    .line 2521
    :goto_0
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 2522
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    .line 2523
    if-lt v1, v0, :cond_0

    .line 2524
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->o()V

    .line 2525
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 2526
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    .line 2528
    :cond_0
    :goto_1
    if-ge v1, v0, :cond_1

    .line 2529
    add-int/lit8 v2, v1, 0x1

    aget-byte v1, v4, v1

    and-int/lit16 v1, v1, 0xff

    .line 2530
    aget v5, v3, v1

    if-eqz v5, :cond_4

    .line 2531
    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 2538
    const/16 v0, 0x22

    if-ne v1, v0, :cond_2

    .line 2565
    return-void

    .line 2535
    :cond_1
    iput v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    goto :goto_0

    .line 2542
    :cond_2
    aget v0, v3, v1

    packed-switch v0, :pswitch_data_0

    .line 2556
    const/16 v0, 0x20

    if-ge v1, v0, :cond_3

    .line 2558
    const-string v0, "string value"

    invoke-virtual {p0, v1, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(ILjava/lang/String;)V

    goto :goto_0

    .line 2544
    :pswitch_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->D()C

    goto :goto_0

    .line 2547
    :pswitch_1
    invoke-direct {p0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->t(I)V

    goto :goto_0

    .line 2550
    :pswitch_2
    invoke-direct {p0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->u(I)V

    goto :goto_0

    .line 2553
    :pswitch_3
    invoke-direct {p0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->v(I)V

    goto :goto_0

    .line 2561
    :cond_3
    invoke-virtual {p0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->k(I)V

    goto :goto_0

    :cond_4
    move v1, v2

    goto :goto_1

    .line 2542
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method protected M()Lcom/fasterxml/jackson/core/JsonToken;
    .locals 10
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v9, 0x27

    const/4 v2, 0x0

    .line 2620
    .line 2623
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->k()[C

    move-result-object v0

    .line 2626
    sget-object v6, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->T:[I

    .line 2627
    iget-object v7, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    move v1, v2

    .line 2634
    :cond_0
    :goto_0
    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v3, v4, :cond_1

    .line 2635
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->o()V

    .line 2637
    :cond_1
    array-length v3, v0

    if-lt v1, v3, :cond_2

    .line 2638
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->m()[C

    move-result-object v0

    move v1, v2

    .line 2641
    :cond_2
    iget v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    .line 2643
    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    array-length v5, v0

    sub-int/2addr v5, v1

    add-int/2addr v3, v5

    .line 2644
    if-ge v3, v4, :cond_b

    .line 2648
    :goto_1
    iget v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    if-ge v4, v3, :cond_0

    .line 2649
    iget v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v5, v4, 0x1

    iput v5, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v4, v7, v4

    and-int/lit16 v5, v4, 0xff

    .line 2650
    if-eq v5, v9, :cond_3

    aget v4, v6, v5

    if-eqz v4, :cond_4

    .line 2658
    :cond_3
    if-ne v5, v9, :cond_5

    .line 2704
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/core/util/TextBuffer;->a(I)V

    .line 2706
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_STRING:Lcom/fasterxml/jackson/core/JsonToken;

    return-object v0

    .line 2653
    :cond_4
    add-int/lit8 v4, v1, 0x1

    int-to-char v5, v5

    aput-char v5, v0, v1

    move v1, v4

    goto :goto_1

    .line 2662
    :cond_5
    aget v3, v6, v5

    packed-switch v3, :pswitch_data_0

    .line 2690
    const/16 v3, 0x20

    if-ge v5, v3, :cond_6

    .line 2691
    const-string v3, "string value"

    invoke-virtual {p0, v5, v3}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(ILjava/lang/String;)V

    .line 2694
    :cond_6
    invoke-virtual {p0, v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->k(I)V

    :cond_7
    move v3, v5

    .line 2697
    :goto_2
    array-length v4, v0

    if-lt v1, v4, :cond_9

    .line 2698
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->m()[C

    move-result-object v0

    move v4, v2

    .line 2702
    :goto_3
    add-int/lit8 v1, v4, 0x1

    int-to-char v3, v3

    aput-char v3, v0, v4

    goto :goto_0

    .line 2664
    :pswitch_0
    if-eq v5, v9, :cond_7

    .line 2665
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->D()C

    move-result v3

    goto :goto_2

    .line 2669
    :pswitch_1
    invoke-direct {p0, v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->p(I)I

    move-result v3

    goto :goto_2

    .line 2672
    :pswitch_2
    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    iget v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    sub-int/2addr v3, v4

    const/4 v4, 0x2

    if-lt v3, v4, :cond_8

    .line 2673
    invoke-direct {p0, v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->r(I)I

    move-result v3

    goto :goto_2

    .line 2675
    :cond_8
    invoke-direct {p0, v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->q(I)I

    move-result v3

    goto :goto_2

    .line 2679
    :pswitch_3
    invoke-direct {p0, v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->s(I)I

    move-result v4

    .line 2681
    add-int/lit8 v3, v1, 0x1

    const v5, 0xd800

    shr-int/lit8 v8, v4, 0xa

    or-int/2addr v5, v8

    int-to-char v5, v5

    aput-char v5, v0, v1

    .line 2682
    array-length v1, v0

    if-lt v3, v1, :cond_a

    .line 2683
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->m()[C

    move-result-object v0

    move v1, v2

    .line 2686
    :goto_4
    const v3, 0xdc00

    and-int/lit16 v4, v4, 0x3ff

    or-int/2addr v3, v4

    .line 2688
    goto :goto_2

    :cond_9
    move v4, v1

    goto :goto_3

    :cond_a
    move v1, v3

    goto :goto_4

    :cond_b
    move v3, v4

    goto/16 :goto_1

    .line 2662
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method protected final N()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 3404
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v1, :cond_0

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->p()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 3405
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v1

    const/16 v1, 0xa

    if-ne v0, v1, :cond_1

    .line 3406
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 3409
    :cond_1
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->g:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->g:I

    .line 3410
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->h:I

    .line 3411
    return-void
.end method

.method public a()Lcom/fasterxml/jackson/core/JsonToken;
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    const/16 v8, 0x7d

    const/16 v7, 0x5d

    const/4 v6, 0x1

    .line 681
    const/4 v0, 0x0

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->A:I

    .line 686
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->K:Lcom/fasterxml/jackson/core/JsonToken;

    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->FIELD_NAME:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v2, :cond_0

    .line 687
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 798
    :goto_0
    return-object v0

    .line 689
    :cond_0
    iget-boolean v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->P:Z

    if-eqz v0, :cond_1

    .line 690
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->L()V

    .line 692
    :cond_1
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->S()I

    move-result v0

    .line 693
    if-gez v0, :cond_2

    .line 695
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->close()V

    .line 696
    iput-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->K:Lcom/fasterxml/jackson/core/JsonToken;

    move-object v0, v1

    goto :goto_0

    .line 701
    :cond_2
    iget-wide v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->f:J

    iget v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    int-to-long v4, v4

    add-long/2addr v2, v4

    const-wide/16 v4, 0x1

    sub-long/2addr v2, v4

    iput-wide v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->i:J

    .line 702
    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->g:I

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->j:I

    .line 703
    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->h:I

    sub-int/2addr v2, v3

    add-int/lit8 v2, v2, -0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->k:I

    .line 706
    iput-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->r:[B

    .line 709
    if-ne v0, v7, :cond_4

    .line 710
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->a()Z

    move-result v1

    if-nez v1, :cond_3

    .line 711
    invoke-virtual {p0, v0, v8}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(IC)V

    .line 713
    :cond_3
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->h()Lcom/fasterxml/jackson/core/json/JsonReadContext;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    .line 714
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->END_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->K:Lcom/fasterxml/jackson/core/JsonToken;

    goto :goto_0

    .line 716
    :cond_4
    if-ne v0, v8, :cond_6

    .line 717
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->c()Z

    move-result v1

    if-nez v1, :cond_5

    .line 718
    invoke-virtual {p0, v0, v7}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(IC)V

    .line 720
    :cond_5
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->h()Lcom/fasterxml/jackson/core/json/JsonReadContext;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    .line 721
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->K:Lcom/fasterxml/jackson/core/JsonToken;

    goto :goto_0

    .line 725
    :cond_6
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->i()Z

    move-result v1

    if-eqz v1, :cond_8

    .line 726
    const/16 v1, 0x2c

    if-eq v0, v1, :cond_7

    .line 727
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "was expecting comma to separate "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v2}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->d()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " entries"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(ILjava/lang/String;)V

    .line 729
    :cond_7
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->Q()I

    move-result v0

    .line 736
    :cond_8
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->c()Z

    move-result v1

    if-nez v1, :cond_9

    .line 737
    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n(I)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto/16 :goto_0

    .line 740
    :cond_9
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->f(I)Ljava/lang/String;

    move-result-object v0

    .line 741
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v1, v0}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->a(Ljava/lang/String;)V

    .line 742
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->FIELD_NAME:Lcom/fasterxml/jackson/core/JsonToken;

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->K:Lcom/fasterxml/jackson/core/JsonToken;

    .line 744
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->U()I

    move-result v0

    .line 747
    const/16 v1, 0x22

    if-ne v0, v1, :cond_a

    .line 748
    iput-boolean v6, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->P:Z

    .line 749
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_STRING:Lcom/fasterxml/jackson/core/JsonToken;

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->m:Lcom/fasterxml/jackson/core/JsonToken;

    .line 750
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->K:Lcom/fasterxml/jackson/core/JsonToken;

    goto/16 :goto_0

    .line 754
    :cond_a
    sparse-switch v0, :sswitch_data_0

    .line 795
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->i(I)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 797
    :goto_1
    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->m:Lcom/fasterxml/jackson/core/JsonToken;

    .line 798
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->K:Lcom/fasterxml/jackson/core/JsonToken;

    goto/16 :goto_0

    .line 756
    :sswitch_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->H()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_1

    .line 773
    :sswitch_1
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e(I)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_1

    .line 776
    :sswitch_2
    const-string v0, "false"

    invoke-virtual {p0, v0, v6}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Ljava/lang/String;I)V

    .line 777
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_FALSE:Lcom/fasterxml/jackson/core/JsonToken;

    goto :goto_1

    .line 780
    :sswitch_3
    const-string v0, "null"

    invoke-virtual {p0, v0, v6}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Ljava/lang/String;I)V

    .line 781
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NULL:Lcom/fasterxml/jackson/core/JsonToken;

    goto :goto_1

    .line 784
    :sswitch_4
    const-string v0, "true"

    invoke-virtual {p0, v0, v6}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Ljava/lang/String;I)V

    .line 785
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_TRUE:Lcom/fasterxml/jackson/core/JsonToken;

    goto :goto_1

    .line 788
    :sswitch_5
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->START_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    goto :goto_1

    .line 791
    :sswitch_6
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->START_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    goto :goto_1

    .line 754
    :sswitch_data_0
    .sparse-switch
        0x2d -> :sswitch_0
        0x30 -> :sswitch_1
        0x31 -> :sswitch_1
        0x32 -> :sswitch_1
        0x33 -> :sswitch_1
        0x34 -> :sswitch_1
        0x35 -> :sswitch_1
        0x36 -> :sswitch_1
        0x37 -> :sswitch_1
        0x38 -> :sswitch_1
        0x39 -> :sswitch_1
        0x5b -> :sswitch_5
        0x66 -> :sswitch_2
        0x6e -> :sswitch_3
        0x74 -> :sswitch_4
        0x7b -> :sswitch_6
    .end sparse-switch
.end method

.method protected a(IZ)Lcom/fasterxml/jackson/core/JsonToken;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2716
    move v0, p1

    :goto_0
    const/16 v1, 0x49

    if-ne v0, v1, :cond_7

    .line 2717
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v1, :cond_0

    .line 2718
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->p()Z

    move-result v0

    if-nez v0, :cond_0

    .line 2719
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->F()V

    .line 2722
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v1, v0, v1

    .line 2724
    const/16 v0, 0x4e

    if-ne v1, v0, :cond_2

    .line 2725
    if-eqz p2, :cond_1

    const-string v0, "-INF"

    .line 2731
    :goto_1
    const/4 v2, 0x3

    invoke-virtual {p0, v0, v2}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Ljava/lang/String;I)V

    .line 2732
    sget-object v2, Lcom/fasterxml/jackson/core/JsonParser$Feature;->ALLOW_NON_NUMERIC_NUMBERS:Lcom/fasterxml/jackson/core/JsonParser$Feature;

    invoke-virtual {p0, v2}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Lcom/fasterxml/jackson/core/JsonParser$Feature;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 2733
    if-eqz p2, :cond_4

    const-wide/high16 v2, -0x10000000000000L    # Double.NEGATIVE_INFINITY

    :goto_2
    invoke-virtual {p0, v0, v2, v3}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Ljava/lang/String;D)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 2738
    :goto_3
    return-object v0

    .line 2725
    :cond_1
    const-string v0, "+INF"

    goto :goto_1

    .line 2726
    :cond_2
    const/16 v0, 0x6e

    if-ne v1, v0, :cond_6

    .line 2727
    if-eqz p2, :cond_3

    const-string v0, "-Infinity"

    goto :goto_1

    :cond_3
    const-string v0, "+Infinity"

    goto :goto_1

    .line 2733
    :cond_4
    const-wide/high16 v2, 0x7ff0000000000000L    # Double.POSITIVE_INFINITY

    goto :goto_2

    .line 2735
    :cond_5
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Non-standard token \'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "\': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d(Ljava/lang/String;)V

    move v0, v1

    .line 2736
    goto :goto_0

    :cond_6
    move v0, v1

    .line 2737
    :cond_7
    const-string v1, "expected digit (0-9) to follow minus sign, for valid numeric value"

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(ILjava/lang/String;)V

    .line 2738
    const/4 v0, 0x0

    goto :goto_3
.end method

.method protected final a(II)Ljava/lang/String;
    .locals 10
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v9, 0x4

    const/4 v8, 0x3

    const/4 v7, 0x2

    const/4 v5, 0x1

    const/16 v6, 0x22

    .line 1754
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    .line 1755
    sget-object v1, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->L:[I

    .line 1758
    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v2, v0, v2

    and-int/lit16 v4, v2, 0xff

    .line 1759
    aget v2, v1, v4

    if-eqz v2, :cond_1

    .line 1760
    if-ne v4, v6, :cond_0

    .line 1761
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->U:I

    invoke-direct {p0, v0, p2, p1, v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(IIII)Ljava/lang/String;

    move-result-object v0

    .line 1789
    :goto_0
    return-object v0

    .line 1763
    :cond_0
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->U:I

    move-object v0, p0

    move v2, p2

    move v3, p1

    invoke-direct/range {v0 .. v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(IIIII)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1765
    :cond_1
    shl-int/lit8 v2, p1, 0x8

    or-int v3, v2, v4

    .line 1766
    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v4, v2, 0x1

    iput v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v2, v0, v2

    and-int/lit16 v4, v2, 0xff

    .line 1767
    aget v2, v1, v4

    if-eqz v2, :cond_3

    .line 1768
    if-ne v4, v6, :cond_2

    .line 1769
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->U:I

    invoke-direct {p0, v0, p2, v3, v7}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(IIII)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1771
    :cond_2
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->U:I

    move-object v0, p0

    move v2, p2

    move v5, v7

    invoke-direct/range {v0 .. v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(IIIII)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1773
    :cond_3
    shl-int/lit8 v2, v3, 0x8

    or-int v3, v2, v4

    .line 1774
    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v4, v2, 0x1

    iput v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v2, v0, v2

    and-int/lit16 v4, v2, 0xff

    .line 1775
    aget v2, v1, v4

    if-eqz v2, :cond_5

    .line 1776
    if-ne v4, v6, :cond_4

    .line 1777
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->U:I

    invoke-direct {p0, v0, p2, v3, v8}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(IIII)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1779
    :cond_4
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->U:I

    move-object v0, p0

    move v2, p2

    move v5, v8

    invoke-direct/range {v0 .. v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(IIIII)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1781
    :cond_5
    shl-int/lit8 v2, v3, 0x8

    or-int v3, v2, v4

    .line 1782
    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v4, v2, 0x1

    iput v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v2

    and-int/lit16 v4, v0, 0xff

    .line 1783
    aget v0, v1, v4

    if-eqz v0, :cond_7

    .line 1784
    if-ne v4, v6, :cond_6

    .line 1785
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->U:I

    invoke-direct {p0, v0, p2, v3, v9}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(IIII)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1787
    :cond_6
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->U:I

    move-object v0, p0

    move v2, p2

    move v5, v9

    invoke-direct/range {v0 .. v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(IIIII)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1789
    :cond_7
    invoke-virtual {p0, v4, p2, v3}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(III)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method protected final a(III)Ljava/lang/String;
    .locals 12
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v6, 0x3

    const/4 v11, 0x2

    const/4 v5, 0x1

    const/4 v7, 0x0

    const/16 v10, 0x22

    .line 1794
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->U:I

    aput v1, v0, v7

    .line 1795
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    aput p2, v0, v5

    .line 1796
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    aput p3, v0, v11

    .line 1799
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    .line 1800
    sget-object v8, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->L:[I

    move v2, v6

    move v3, p1

    .line 1803
    :goto_0
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v0, v0, 0x4

    iget v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-gt v0, v4, :cond_9

    .line 1804
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v4, v0, 0x1

    iput v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v1, v0

    and-int/lit16 v4, v0, 0xff

    .line 1805
    aget v0, v8, v4

    if-eqz v0, :cond_1

    .line 1806
    if-ne v4, v10, :cond_0

    .line 1807
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    invoke-direct {p0, v0, v2, v3, v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([IIII)Ljava/lang/String;

    move-result-object v0

    .line 1851
    :goto_1
    return-object v0

    .line 1809
    :cond_0
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([IIIII)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 1812
    :cond_1
    shl-int/lit8 v0, v3, 0x8

    or-int v3, v0, v4

    .line 1813
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v4, v0, 0x1

    iput v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v1, v0

    and-int/lit16 v4, v0, 0xff

    .line 1814
    aget v0, v8, v4

    if-eqz v0, :cond_3

    .line 1815
    if-ne v4, v10, :cond_2

    .line 1816
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    invoke-direct {p0, v0, v2, v3, v11}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([IIII)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 1818
    :cond_2
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    move-object v0, p0

    move v5, v11

    invoke-virtual/range {v0 .. v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([IIIII)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 1821
    :cond_3
    shl-int/lit8 v0, v3, 0x8

    or-int v3, v0, v4

    .line 1822
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v4, v0, 0x1

    iput v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v1, v0

    and-int/lit16 v4, v0, 0xff

    .line 1823
    aget v0, v8, v4

    if-eqz v0, :cond_5

    .line 1824
    if-ne v4, v10, :cond_4

    .line 1825
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    invoke-direct {p0, v0, v2, v3, v6}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([IIII)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 1827
    :cond_4
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    move-object v0, p0

    move v5, v6

    invoke-virtual/range {v0 .. v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([IIIII)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 1830
    :cond_5
    shl-int/lit8 v0, v3, 0x8

    or-int v3, v0, v4

    .line 1831
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v4, v0, 0x1

    iput v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v1, v0

    and-int/lit16 v4, v0, 0xff

    .line 1832
    aget v0, v8, v4

    if-eqz v0, :cond_7

    .line 1833
    if-ne v4, v10, :cond_6

    .line 1834
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    const/4 v1, 0x4

    invoke-direct {p0, v0, v2, v3, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([IIII)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 1836
    :cond_6
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    const/4 v5, 0x4

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([IIIII)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 1840
    :cond_7
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    array-length v0, v0

    if-lt v2, v0, :cond_8

    .line 1841
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    invoke-static {v0, v2}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([II)[I

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    .line 1843
    :cond_8
    iget-object v9, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    add-int/lit8 v0, v2, 0x1

    aput v3, v9, v2

    move v2, v0

    move v3, v4

    .line 1845
    goto/16 :goto_0

    .line 1851
    :cond_9
    iget-object v5, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    move-object v4, p0

    move v6, v2

    move v8, v3

    move v9, v7

    invoke-virtual/range {v4 .. v9}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([IIIII)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1
.end method

.method protected final a(Lcom/fasterxml/jackson/core/JsonToken;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 370
    if-nez p1, :cond_0

    .line 371
    const/4 v0, 0x0

    .line 383
    :goto_0
    return-object v0

    .line 373
    :cond_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonToken;->id()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 383
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonToken;->asString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 375
    :pswitch_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->g()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 381
    :pswitch_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->f()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 373
    :pswitch_data_0
    .packed-switch 0x5
        :pswitch_0
        :pswitch_1
        :pswitch_1
        :pswitch_1
    .end packed-switch
.end method

.method protected final a([IIIII)Ljava/lang/String;
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x4

    const/4 v1, 0x0

    .line 1902
    sget-object v5, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->L:[I

    .line 1905
    :goto_0
    aget v0, v5, p4

    if-eqz v0, :cond_d

    .line 1906
    const/16 v0, 0x22

    if-ne p4, v0, :cond_3

    .line 1975
    if-lez p5, :cond_1

    .line 1976
    array-length v0, p1

    if-lt p2, v0, :cond_0

    .line 1977
    array-length v0, p1

    invoke-static {p1, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([II)[I

    move-result-object p1

    iput-object p1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    .line 1979
    :cond_0
    add-int/lit8 v0, p2, 0x1

    invoke-static {p3, p5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d(II)I

    move-result v1

    aput v1, p1, p2

    move p2, v0

    .line 1981
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->N:Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;

    invoke-virtual {v0, p1, p2}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->a([II)Ljava/lang/String;

    move-result-object v0

    .line 1982
    if-nez v0, :cond_2

    .line 1983
    invoke-direct {p0, p1, p2, p5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([III)Ljava/lang/String;

    move-result-object v0

    .line 1985
    :cond_2
    return-object v0

    .line 1910
    :cond_3
    const/16 v0, 0x5c

    if-eq p4, v0, :cond_6

    .line 1912
    const-string v0, "name"

    invoke-virtual {p0, p4, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(ILjava/lang/String;)V

    .line 1922
    :goto_1
    const/16 v0, 0x7f

    if-le p4, v0, :cond_d

    .line 1924
    if-lt p5, v7, :cond_c

    .line 1925
    array-length v0, p1

    if-lt p2, v0, :cond_4

    .line 1926
    array-length v0, p1

    invoke-static {p1, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([II)[I

    move-result-object p1

    iput-object p1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    .line 1928
    :cond_4
    add-int/lit8 v4, p2, 0x1

    aput p3, p1, p2

    move p5, v1

    move p3, v1

    move-object v0, p1

    .line 1932
    :goto_2
    const/16 v2, 0x800

    if-ge p4, v2, :cond_7

    .line 1933
    shl-int/lit8 v2, p3, 0x8

    shr-int/lit8 v3, p4, 0x6

    or-int/lit16 v3, v3, 0xc0

    or-int/2addr v3, v2

    .line 1934
    add-int/lit8 v2, p5, 0x1

    move v8, v2

    move v2, v3

    move-object v3, v0

    move v0, v8

    .line 1952
    :goto_3
    and-int/lit8 v6, p4, 0x3f

    or-int/lit16 p3, v6, 0x80

    move p5, v0

    move p2, v4

    move-object v0, v3

    move v3, v2

    .line 1956
    :goto_4
    if-ge p5, v7, :cond_9

    .line 1957
    add-int/lit8 p5, p5, 0x1

    .line 1958
    shl-int/lit8 v2, v3, 0x8

    or-int/2addr p3, v2

    move-object p1, v0

    .line 1967
    :goto_5
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v2, :cond_5

    .line 1968
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->p()Z

    move-result v0

    if-nez v0, :cond_5

    .line 1969
    const-string v0, " in field name"

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(Ljava/lang/String;)V

    .line 1972
    :cond_5
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v2

    and-int/lit16 p4, v0, 0xff

    goto/16 :goto_0

    .line 1915
    :cond_6
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->D()C

    move-result p4

    goto :goto_1

    .line 1937
    :cond_7
    shl-int/lit8 v2, p3, 0x8

    shr-int/lit8 v3, p4, 0xc

    or-int/lit16 v3, v3, 0xe0

    or-int/2addr v3, v2

    .line 1938
    add-int/lit8 v2, p5, 0x1

    .line 1940
    if-lt v2, v7, :cond_b

    .line 1941
    array-length v2, v0

    if-lt v4, v2, :cond_8

    .line 1942
    array-length v2, v0

    invoke-static {v0, v2}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([II)[I

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    .line 1944
    :cond_8
    add-int/lit8 v2, v4, 0x1

    aput v3, v0, v4

    move v3, v2

    move-object v4, v0

    move v0, v1

    move v2, v1

    .line 1948
    :goto_6
    shl-int/lit8 v2, v2, 0x8

    shr-int/lit8 v6, p4, 0x6

    and-int/lit8 v6, v6, 0x3f

    or-int/lit16 v6, v6, 0x80

    or-int/2addr v2, v6

    .line 1949
    add-int/lit8 v0, v0, 0x1

    move v8, v3

    move-object v3, v4

    move v4, v8

    goto :goto_3

    .line 1960
    :cond_9
    array-length v2, v0

    if-lt p2, v2, :cond_a

    .line 1961
    array-length v2, v0

    invoke-static {v0, v2}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([II)[I

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    .line 1963
    :cond_a
    add-int/lit8 v2, p2, 0x1

    aput v3, v0, p2

    .line 1965
    const/4 p5, 0x1

    move p2, v2

    move-object p1, v0

    goto :goto_5

    :cond_b
    move v8, v2

    move v2, v3

    move v3, v4

    move-object v4, v0

    move v0, v8

    goto :goto_6

    :cond_c
    move v4, p2

    move-object v0, p1

    goto/16 :goto_2

    :cond_d
    move v3, p3

    move-object v0, p1

    move p3, p4

    goto :goto_4
.end method

.method protected final a(Ljava/lang/String;I)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2743
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    .line 2744
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/2addr v1, v0

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v1, v2, :cond_1

    .line 2745
    invoke-direct {p0, p1, p2}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(Ljava/lang/String;I)V

    .line 2759
    :cond_0
    :goto_0
    return-void

    .line 2749
    :cond_1
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v1, v1, v2

    invoke-virtual {p1, p2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    if-eq v1, v2, :cond_2

    .line 2750
    const/4 v1, 0x0

    invoke-virtual {p1, v1, p2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e(Ljava/lang/String;)V

    .line 2752
    :cond_2
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 2753
    add-int/lit8 p2, p2, 0x1

    if-lt p2, v0, :cond_1

    .line 2755
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v1

    and-int/lit16 v0, v0, 0xff

    .line 2756
    const/16 v1, 0x30

    if-lt v0, v1, :cond_0

    const/16 v1, 0x5d

    if-eq v0, v1, :cond_0

    const/16 v1, 0x7d

    if-eq v0, v1, :cond_0

    .line 2757
    invoke-direct {p0, p1, p2, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Ljava/lang/String;II)V

    goto :goto_0
.end method

.method protected a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 3434
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0, p1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 3441
    :goto_0
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v1, v2, :cond_1

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->p()Z

    move-result v1

    if-nez v1, :cond_1

    .line 3451
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

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d(Ljava/lang/String;)V

    .line 3452
    return-void

    .line 3444
    :cond_1
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v1, v1, v2

    .line 3445
    invoke-virtual {p0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->j(I)I

    move-result v1

    int-to-char v1, v1

    .line 3446
    invoke-static {v1}, Ljava/lang/Character;->isJavaIdentifierPart(C)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 3449
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_0
.end method

.method protected b(II)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/core/JsonParseException;
        }
    .end annotation

    .prologue
    .line 3479
    iput p2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 3480
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->m(I)V

    .line 3481
    return-void
.end method

.method public e()Lcom/fasterxml/jackson/core/JsonLocation;
    .locals 8

    .prologue
    .line 662
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->h:I

    sub-int/2addr v0, v1

    add-int/lit8 v7, v0, 0x1

    .line 663
    new-instance v0, Lcom/fasterxml/jackson/core/JsonLocation;

    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b:Lcom/fasterxml/jackson/core/io/IOContext;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/io/IOContext;->a()Ljava/lang/Object;

    move-result-object v1

    iget-wide v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->f:J

    iget v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    int-to-long v4, v4

    add-long/2addr v2, v4

    const-wide/16 v4, -0x1

    iget v6, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->g:I

    invoke-direct/range {v0 .. v7}, Lcom/fasterxml/jackson/core/JsonLocation;-><init>(Ljava/lang/Object;JJII)V

    return-object v0
.end method

.method protected e(I)Lcom/fasterxml/jackson/core/JsonToken;
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v8, 0x30

    const/4 v2, 0x1

    const/4 v4, 0x0

    .line 1345
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->k()[C

    move-result-object v1

    .line 1347
    if-ne p1, v8, :cond_0

    .line 1348
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->P()I

    move-result p1

    .line 1351
    :cond_0
    int-to-char v0, p1

    aput-char v0, v1, v4

    .line 1356
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    array-length v3, v1

    add-int/2addr v0, v3

    add-int/lit8 v0, v0, -0x1

    .line 1357
    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-le v0, v3, :cond_7

    .line 1358
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    move v5, v2

    .line 1362
    :goto_0
    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    if-lt v3, v0, :cond_1

    .line 1363
    invoke-direct {p0, v1, v2, v4, v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([CIZI)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 1382
    :goto_1
    return-object v0

    .line 1365
    :cond_1
    iget-object v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v6, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v7, v6, 0x1

    iput v7, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v3, v3, v6

    and-int/lit16 v3, v3, 0xff

    .line 1366
    if-lt v3, v8, :cond_2

    const/16 v6, 0x39

    if-le v3, v6, :cond_4

    .line 1372
    :cond_2
    const/16 v0, 0x2e

    if-eq v3, v0, :cond_3

    const/16 v0, 0x65

    if-eq v3, v0, :cond_3

    const/16 v0, 0x45

    if-ne v3, v0, :cond_5

    :cond_3
    move-object v0, p0

    .line 1373
    invoke-direct/range {v0 .. v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([CIIZI)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_1

    .line 1369
    :cond_4
    add-int/lit8 v6, v5, 0x1

    .line 1370
    add-int/lit8 v5, v2, 0x1

    int-to-char v3, v3

    aput-char v3, v1, v2

    move v2, v5

    move v5, v6

    goto :goto_0

    .line 1375
    :cond_5
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 1376
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0, v2}, Lcom/fasterxml/jackson/core/util/TextBuffer;->a(I)V

    .line 1378
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->l:Lcom/fasterxml/jackson/core/json/JsonReadContext;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/json/JsonReadContext;->b()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 1379
    invoke-direct {p0, v3}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->o(I)V

    .line 1382
    :cond_6
    invoke-virtual {p0, v4, v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(ZI)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_1

    :cond_7
    move v5, v2

    goto :goto_0
.end method

.method protected e(Ljava/lang/String;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 3429
    const-string v0, "\'null\', \'true\', \'false\' or NaN"

    invoke-virtual {p0, p1, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 3430
    return-void
.end method

.method public f()Ljava/lang/String;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 282
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->K:Lcom/fasterxml/jackson/core/JsonToken;

    sget-object v1, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_STRING:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v1, :cond_1

    .line 283
    iget-boolean v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->P:Z

    if-eqz v0, :cond_0

    .line 284
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->P:Z

    .line 285
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->K()Ljava/lang/String;

    move-result-object v0

    .line 289
    :goto_0
    return-object v0

    .line 287
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->f()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 289
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->K:Lcom/fasterxml/jackson/core/JsonToken;

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Lcom/fasterxml/jackson/core/JsonToken;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method protected final f(I)Ljava/lang/String;
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v8, 0x3

    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v4, 0x0

    const/16 v5, 0x22

    .line 1649
    if-eq p1, v5, :cond_0

    .line 1650
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->h(I)Ljava/lang/String;

    move-result-object v0

    .line 1706
    :goto_0
    return-object v0

    .line 1653
    :cond_0
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v0, v0, 0xd

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-le v0, v1, :cond_1

    .line 1654
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->I()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1663
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    .line 1664
    sget-object v1, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->L:[I

    .line 1666
    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v2, v0, v2

    and-int/lit16 v2, v2, 0xff

    .line 1668
    aget v3, v1, v2

    if-nez v3, :cond_a

    .line 1669
    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v4, v3, 0x1

    iput v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v3, v0, v3

    and-int/lit16 v3, v3, 0xff

    .line 1670
    aget v4, v1, v3

    if-nez v4, :cond_8

    .line 1671
    shl-int/lit8 v2, v2, 0x8

    or-int/2addr v2, v3

    .line 1672
    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v4, v3, 0x1

    iput v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v3, v0, v3

    and-int/lit16 v3, v3, 0xff

    .line 1673
    aget v4, v1, v3

    if-nez v4, :cond_6

    .line 1674
    shl-int/lit8 v2, v2, 0x8

    or-int/2addr v2, v3

    .line 1675
    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v4, v3, 0x1

    iput v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v3, v0, v3

    and-int/lit16 v3, v3, 0xff

    .line 1676
    aget v4, v1, v3

    if-nez v4, :cond_4

    .line 1677
    shl-int/lit8 v2, v2, 0x8

    or-int/2addr v2, v3

    .line 1678
    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v4, v3, 0x1

    iput v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v3

    and-int/lit16 v0, v0, 0xff

    .line 1679
    aget v1, v1, v0

    if-nez v1, :cond_2

    .line 1680
    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->U:I

    .line 1681
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->g(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1683
    :cond_2
    if-ne v0, v5, :cond_3

    .line 1684
    const/4 v0, 0x4

    invoke-direct {p0, v2, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(II)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1686
    :cond_3
    const/4 v1, 0x4

    invoke-direct {p0, v2, v0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(III)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1688
    :cond_4
    if-ne v3, v5, :cond_5

    .line 1689
    invoke-direct {p0, v2, v8}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(II)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1691
    :cond_5
    invoke-direct {p0, v2, v3, v8}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(III)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 1693
    :cond_6
    if-ne v3, v5, :cond_7

    .line 1694
    invoke-direct {p0, v2, v7}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(II)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 1696
    :cond_7
    invoke-direct {p0, v2, v3, v7}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(III)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 1698
    :cond_8
    if-ne v3, v5, :cond_9

    .line 1699
    invoke-direct {p0, v2, v6}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(II)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 1701
    :cond_9
    invoke-direct {p0, v2, v3, v6}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(III)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 1703
    :cond_a
    if-ne v2, v5, :cond_b

    .line 1704
    const-string v0, ""

    goto/16 :goto_0

    .line 1706
    :cond_b
    invoke-direct {p0, v4, v2, v4}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(III)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0
.end method

.method protected final g(I)Ljava/lang/String;
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v4, 0x1

    const/16 v5, 0x22

    .line 1711
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    .line 1712
    sget-object v1, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->L:[I

    .line 1715
    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v2, v0, v2

    and-int/lit16 v2, v2, 0xff

    .line 1716
    aget v3, v1, v2

    if-eqz v3, :cond_1

    .line 1717
    if-ne v2, v5, :cond_0

    .line 1718
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->U:I

    invoke-direct {p0, v0, p1, v4}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(III)Ljava/lang/String;

    move-result-object v0

    .line 1746
    :goto_0
    return-object v0

    .line 1720
    :cond_0
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->U:I

    invoke-direct {p0, v0, p1, v2, v4}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(IIII)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1722
    :cond_1
    shl-int/lit8 v3, p1, 0x8

    or-int/2addr v2, v3

    .line 1723
    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v4, v3, 0x1

    iput v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v3, v0, v3

    and-int/lit16 v3, v3, 0xff

    .line 1724
    aget v4, v1, v3

    if-eqz v4, :cond_3

    .line 1725
    if-ne v3, v5, :cond_2

    .line 1726
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->U:I

    invoke-direct {p0, v0, v2, v6}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(III)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1728
    :cond_2
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->U:I

    invoke-direct {p0, v0, v2, v3, v6}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(IIII)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1730
    :cond_3
    shl-int/lit8 v2, v2, 0x8

    or-int/2addr v2, v3

    .line 1731
    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v4, v3, 0x1

    iput v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v3, v0, v3

    and-int/lit16 v3, v3, 0xff

    .line 1732
    aget v4, v1, v3

    if-eqz v4, :cond_5

    .line 1733
    if-ne v3, v5, :cond_4

    .line 1734
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->U:I

    invoke-direct {p0, v0, v2, v7}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(III)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1736
    :cond_4
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->U:I

    invoke-direct {p0, v0, v2, v3, v7}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(IIII)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1738
    :cond_5
    shl-int/lit8 v2, v2, 0x8

    or-int/2addr v2, v3

    .line 1739
    iget v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v4, v3, 0x1

    iput v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v3

    and-int/lit16 v0, v0, 0xff

    .line 1740
    aget v1, v1, v0

    if-eqz v1, :cond_7

    .line 1741
    if-ne v0, v5, :cond_6

    .line 1742
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->U:I

    invoke-direct {p0, v0, v2, v8}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(III)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1744
    :cond_6
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->U:I

    invoke-direct {p0, v1, v2, v0, v8}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(IIII)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1746
    :cond_7
    invoke-virtual {p0, v0, v2}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(II)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method protected h(I)Ljava/lang/String;
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 1997
    const/16 v1, 0x27

    if-ne p1, v1, :cond_0

    sget-object v1, Lcom/fasterxml/jackson/core/JsonParser$Feature;->ALLOW_SINGLE_QUOTES:Lcom/fasterxml/jackson/core/JsonParser$Feature;

    invoke-virtual {p0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Lcom/fasterxml/jackson/core/JsonParser$Feature;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1998
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->J()Ljava/lang/String;

    move-result-object v0

    .line 2059
    :goto_0
    return-object v0

    .line 2001
    :cond_0
    sget-object v1, Lcom/fasterxml/jackson/core/JsonParser$Feature;->ALLOW_UNQUOTED_FIELD_NAMES:Lcom/fasterxml/jackson/core/JsonParser$Feature;

    invoke-virtual {p0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Lcom/fasterxml/jackson/core/JsonParser$Feature;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 2002
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->j(I)I

    move-result v1

    int-to-char v1, v1

    .line 2003
    const-string v2, "was expecting double-quote to start field name"

    invoke-virtual {p0, v1, v2}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(ILjava/lang/String;)V

    .line 2009
    :cond_1
    invoke-static {}, Lcom/fasterxml/jackson/core/io/CharTypes;->d()[I

    move-result-object v6

    .line 2011
    aget v1, v6, p1

    if-eqz v1, :cond_2

    .line 2012
    const-string v1, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name"

    invoke-virtual {p0, p1, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(ILjava/lang/String;)V

    .line 2019
    :cond_2
    iget-object v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    move v1, v0

    move v5, v0

    move v2, p1

    move-object v7, v3

    move v3, v0

    move-object v0, v7

    .line 2026
    :goto_1
    const/4 v4, 0x4

    if-ge v1, v4, :cond_6

    .line 2027
    add-int/lit8 v1, v1, 0x1

    .line 2028
    shl-int/lit8 v4, v5, 0x8

    or-int/2addr v2, v4

    move v7, v1

    move v1, v2

    move v2, v3

    move-object v3, v0

    move v0, v7

    .line 2037
    :goto_2
    iget v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v5, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v4, v5, :cond_3

    .line 2038
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->p()Z

    move-result v4

    if-nez v4, :cond_3

    .line 2039
    const-string v4, " in field name"

    invoke-virtual {p0, v4}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(Ljava/lang/String;)V

    .line 2042
    :cond_3
    iget-object v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v5, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v4, v4, v5

    and-int/lit16 p1, v4, 0xff

    .line 2043
    aget v4, v6, p1

    if-eqz v4, :cond_8

    .line 2049
    if-lez v0, :cond_5

    .line 2050
    array-length v4, v3

    if-lt v2, v4, :cond_4

    .line 2051
    array-length v4, v3

    invoke-static {v3, v4}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([II)[I

    move-result-object v3

    iput-object v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    .line 2053
    :cond_4
    add-int/lit8 v4, v2, 0x1

    aput v1, v3, v2

    move v2, v4

    .line 2055
    :cond_5
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->N:Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;

    invoke-virtual {v1, v3, v2}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->a([II)Ljava/lang/String;

    move-result-object v1

    .line 2056
    if-nez v1, :cond_9

    .line 2057
    invoke-direct {p0, v3, v2, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([III)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 2030
    :cond_6
    array-length v1, v0

    if-lt v3, v1, :cond_7

    .line 2031
    array-length v1, v0

    invoke-static {v0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([II)[I

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->O:[I

    .line 2033
    :cond_7
    add-int/lit8 v4, v3, 0x1

    aput v5, v0, v3

    .line 2035
    const/4 v1, 0x1

    move-object v3, v0

    move v0, v1

    move v1, v2

    move v2, v4

    goto :goto_2

    .line 2046
    :cond_8
    iget v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v4, v4, 0x1

    iput v4, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    move v5, v1

    move v1, v0

    move-object v0, v3

    move v3, v2

    move v2, p1

    goto :goto_1

    :cond_9
    move-object v0, v1

    goto/16 :goto_0
.end method

.method protected i(I)Lcom/fasterxml/jackson/core/JsonToken;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    .line 2575
    sparse-switch p1, :sswitch_data_0

    .line 2609
    :cond_0
    :goto_0
    invoke-static {p1}, Ljava/lang/Character;->isJavaIdentifierStart(I)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 2610
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

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 2613
    :cond_1
    const-string v0, "expected a valid value (number, String, array, object, \'true\', \'false\' or \'null\')"

    invoke-virtual {p0, p1, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(ILjava/lang/String;)V

    .line 2614
    const/4 v0, 0x0

    :goto_1
    return-object v0

    .line 2580
    :sswitch_0
    const-string v0, "expected a value"

    invoke-virtual {p0, p1, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b(ILjava/lang/String;)V

    .line 2582
    :sswitch_1
    sget-object v0, Lcom/fasterxml/jackson/core/JsonParser$Feature;->ALLOW_SINGLE_QUOTES:Lcom/fasterxml/jackson/core/JsonParser$Feature;

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Lcom/fasterxml/jackson/core/JsonParser$Feature;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2583
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->M()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_1

    .line 2587
    :sswitch_2
    const-string v0, "NaN"

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Ljava/lang/String;I)V

    .line 2588
    sget-object v0, Lcom/fasterxml/jackson/core/JsonParser$Feature;->ALLOW_NON_NUMERIC_NUMBERS:Lcom/fasterxml/jackson/core/JsonParser$Feature;

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Lcom/fasterxml/jackson/core/JsonParser$Feature;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 2589
    const-string v0, "NaN"

    const-wide/high16 v2, 0x7ff8000000000000L    # Double.NaN

    invoke-virtual {p0, v0, v2, v3}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Ljava/lang/String;D)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_1

    .line 2591
    :cond_2
    const-string v0, "Non-standard token \'NaN\': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow"

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d(Ljava/lang/String;)V

    goto :goto_0

    .line 2594
    :sswitch_3
    const-string v0, "Infinity"

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Ljava/lang/String;I)V

    .line 2595
    sget-object v0, Lcom/fasterxml/jackson/core/JsonParser$Feature;->ALLOW_NON_NUMERIC_NUMBERS:Lcom/fasterxml/jackson/core/JsonParser$Feature;

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Lcom/fasterxml/jackson/core/JsonParser$Feature;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 2596
    const-string v0, "Infinity"

    const-wide/high16 v2, 0x7ff0000000000000L    # Double.POSITIVE_INFINITY

    invoke-virtual {p0, v0, v2, v3}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Ljava/lang/String;D)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_1

    .line 2598
    :cond_3
    const-string v0, "Non-standard token \'Infinity\': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow"

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d(Ljava/lang/String;)V

    goto :goto_0

    .line 2601
    :sswitch_4
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v1, :cond_4

    .line 2602
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->p()Z

    move-result v0

    if-nez v0, :cond_4

    .line 2603
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->F()V

    .line 2606
    :cond_4
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    aget-byte v0, v0, v1

    and-int/lit16 v0, v0, 0xff

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(IZ)Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_1

    .line 2575
    nop

    :sswitch_data_0
    .sparse-switch
        0x27 -> :sswitch_1
        0x2b -> :sswitch_4
        0x49 -> :sswitch_3
        0x4e -> :sswitch_2
        0x5d -> :sswitch_0
        0x7d -> :sswitch_0
    .end sparse-switch
.end method

.method protected j(I)I
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x2

    const/16 v6, 0x80

    const/4 v1, 0x1

    .line 3197
    and-int/lit16 v0, p1, 0xff

    .line 3198
    const/16 v3, 0x7f

    if-le v0, v3, :cond_3

    .line 3202
    and-int/lit16 v3, v0, 0xe0

    const/16 v4, 0xc0

    if-ne v3, v4, :cond_4

    .line 3203
    and-int/lit8 v0, v0, 0x1f

    move v3, v0

    move v0, v1

    .line 3217
    :goto_0
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->Z()I

    move-result v4

    .line 3218
    and-int/lit16 v5, v4, 0xc0

    if-eq v5, v6, :cond_0

    .line 3219
    and-int/lit16 v5, v4, 0xff

    invoke-virtual {p0, v5}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->m(I)V

    .line 3221
    :cond_0
    shl-int/lit8 v3, v3, 0x6

    and-int/lit8 v4, v4, 0x3f

    or-int/2addr v3, v4

    .line 3223
    if-le v0, v1, :cond_8

    .line 3224
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->Z()I

    move-result v1

    .line 3225
    and-int/lit16 v4, v1, 0xc0

    if-eq v4, v6, :cond_1

    .line 3226
    and-int/lit16 v4, v1, 0xff

    invoke-virtual {p0, v4}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->m(I)V

    .line 3228
    :cond_1
    shl-int/lit8 v3, v3, 0x6

    and-int/lit8 v1, v1, 0x3f

    or-int/2addr v1, v3

    .line 3229
    if-le v0, v2, :cond_7

    .line 3230
    invoke-direct {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->Z()I

    move-result v0

    .line 3231
    and-int/lit16 v2, v0, 0xc0

    if-eq v2, v6, :cond_2

    .line 3232
    and-int/lit16 v2, v0, 0xff

    invoke-virtual {p0, v2}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->m(I)V

    .line 3234
    :cond_2
    shl-int/lit8 v1, v1, 0x6

    and-int/lit8 v0, v0, 0x3f

    or-int/2addr v0, v1

    .line 3238
    :cond_3
    :goto_1
    return v0

    .line 3205
    :cond_4
    and-int/lit16 v3, v0, 0xf0

    const/16 v4, 0xe0

    if-ne v3, v4, :cond_5

    .line 3206
    and-int/lit8 v0, v0, 0xf

    move v3, v0

    move v0, v2

    .line 3207
    goto :goto_0

    .line 3208
    :cond_5
    and-int/lit16 v3, v0, 0xf8

    const/16 v4, 0xf0

    if-ne v3, v4, :cond_6

    .line 3210
    and-int/lit8 v3, v0, 0x7

    .line 3211
    const/4 v0, 0x3

    goto :goto_0

    .line 3213
    :cond_6
    and-int/lit16 v3, v0, 0xff

    invoke-virtual {p0, v3}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->l(I)V

    move v3, v0

    move v0, v1

    .line 3214
    goto :goto_0

    :cond_7
    move v0, v1

    goto :goto_1

    :cond_8
    move v0, v3

    goto :goto_1
.end method

.method protected k(I)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/core/JsonParseException;
        }
    .end annotation

    .prologue
    .line 3458
    const/16 v0, 0x20

    if-ge p1, v0, :cond_0

    .line 3459
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->c(I)V

    .line 3461
    :cond_0
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->l(I)V

    .line 3462
    return-void
.end method

.method protected l(I)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/core/JsonParseException;
        }
    .end annotation

    .prologue
    .line 3467
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Invalid UTF-8 start byte 0x"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {p1}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d(Ljava/lang/String;)V

    .line 3468
    return-void
.end method

.method protected m(I)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/core/JsonParseException;
        }
    .end annotation

    .prologue
    .line 3473
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Invalid UTF-8 middle byte 0x"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {p1}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d(Ljava/lang/String;)V

    .line 3474
    return-void
.end method

.method protected final p()Z
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 171
    iget-wide v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->f:J

    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    int-to-long v4, v1

    add-long/2addr v2, v4

    iput-wide v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->f:J

    .line 172
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->h:I

    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    sub-int/2addr v1, v2

    iput v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->h:I

    .line 174
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->Q:Ljava/io/InputStream;

    if-eqz v1, :cond_0

    .line 175
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    array-length v1, v1

    .line 176
    if-nez v1, :cond_1

    .line 193
    :cond_0
    :goto_0
    return v0

    .line 180
    :cond_1
    iget-object v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->Q:Ljava/io/InputStream;

    iget-object v3, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    invoke-virtual {v2, v3, v0, v1}, Ljava/io/InputStream;->read([BII)I

    move-result v1

    .line 181
    if-lez v1, :cond_2

    .line 182
    iput v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 183
    iput v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    .line 184
    const/4 v0, 0x1

    goto :goto_0

    .line 187
    :cond_2
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->r()V

    .line 189
    if-nez v1, :cond_0

    .line 190
    new-instance v0, Ljava/io/IOException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "InputStream.read() returned 0 characters when trying to read "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    array-length v2, v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " bytes"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method protected q()V
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2356
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 2357
    iget v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    if-lt v0, v1, :cond_0

    .line 2358
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->o()V

    .line 2359
    iget v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 2361
    :cond_0
    const/4 v1, 0x0

    .line 2362
    iget-object v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v2}, Lcom/fasterxml/jackson/core/util/TextBuffer;->k()[C

    move-result-object v3

    .line 2363
    sget-object v4, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->T:[I

    .line 2365
    iget v2, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->e:I

    array-length v5, v3

    add-int/2addr v5, v0

    invoke-static {v2, v5}, Ljava/lang/Math;->min(II)I

    move-result v5

    .line 2366
    iget-object v6, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    move v8, v1

    move v1, v0

    move v0, v8

    .line 2367
    :goto_0
    if-ge v1, v5, :cond_2

    .line 2368
    aget-byte v2, v6, v1

    and-int/lit16 v7, v2, 0xff

    .line 2369
    aget v2, v4, v7

    if-eqz v2, :cond_1

    .line 2370
    const/16 v2, 0x22

    if-ne v7, v2, :cond_2

    .line 2371
    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 2372
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->n:Lcom/fasterxml/jackson/core/util/TextBuffer;

    invoke-virtual {v1, v0}, Lcom/fasterxml/jackson/core/util/TextBuffer;->a(I)V

    .line 2382
    :goto_1
    return-void

    .line 2377
    :cond_1
    add-int/lit8 v2, v1, 0x1

    .line 2378
    add-int/lit8 v1, v0, 0x1

    int-to-char v7, v7

    aput-char v7, v3, v0

    move v0, v1

    move v1, v2

    .line 2379
    goto :goto_0

    .line 2380
    :cond_2
    iput v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->d:I

    .line 2381
    invoke-direct {p0, v3, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a([CI)V

    goto :goto_1
.end method

.method protected r()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 240
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->Q:Ljava/io/InputStream;

    if-eqz v0, :cond_2

    .line 241
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b:Lcom/fasterxml/jackson/core/io/IOContext;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/io/IOContext;->c()Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/fasterxml/jackson/core/JsonParser$Feature;->AUTO_CLOSE_SOURCE:Lcom/fasterxml/jackson/core/JsonParser$Feature;

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->a(Lcom/fasterxml/jackson/core/JsonParser$Feature;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 242
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->Q:Ljava/io/InputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->close()V

    .line 244
    :cond_1
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->Q:Ljava/io/InputStream;

    .line 246
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
    .line 257
    invoke-super {p0}, Lcom/fasterxml/jackson/core/base/ParserBase;->s()V

    .line 259
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->N:Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/sym/ByteQuadsCanonicalizer;->b()V

    .line 260
    iget-boolean v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->S:Z

    if-eqz v0, :cond_0

    .line 261
    iget-object v0, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    .line 262
    if-eqz v0, :cond_0

    .line 267
    sget-object v1, Lcom/fasterxml/jackson/core/util/ByteArrayBuilder;->a:[B

    iput-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->R:[B

    .line 268
    iget-object v1, p0, Lcom/fasterxml/jackson/core/json/UTF8StreamJsonParser;->b:Lcom/fasterxml/jackson/core/io/IOContext;

    invoke-virtual {v1, v0}, Lcom/fasterxml/jackson/core/io/IOContext;->a([B)V

    .line 271
    :cond_0
    return-void
.end method
