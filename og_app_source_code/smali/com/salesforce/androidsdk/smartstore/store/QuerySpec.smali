.class public Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;
.super Ljava/lang/Object;
.source "QuerySpec.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;,
        Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;
    }
.end annotation


# instance fields
.field public final a:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

.field public final b:I

.field public final c:Ljava/lang/String;

.field public final d:Ljava/lang/String;

.field public final e:Ljava/lang/String;

.field public final f:Ljava/lang/String;

.field public final g:[Ljava/lang/String;

.field public final h:Ljava/lang/String;

.field public final i:Ljava/lang/String;

.field public final j:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;

.field public final k:Ljava/lang/String;

.field public final l:Ljava/lang/String;

.field public final m:Ljava/lang/String;

.field public final n:Ljava/lang/String;


# direct methods
.method private constructor <init>(Ljava/lang/String;I)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 111
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 112
    iput-object p1, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->c:Ljava/lang/String;

    .line 113
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->d:Ljava/lang/String;

    .line 114
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->e:Ljava/lang/String;

    .line 115
    iput p2, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->b:I

    .line 116
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;->smart:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->a:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    .line 119
    iput-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->f:Ljava/lang/String;

    .line 120
    iput-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->g:[Ljava/lang/String;

    .line 121
    iput-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->h:Ljava/lang/String;

    .line 122
    iput-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->k:Ljava/lang/String;

    .line 123
    iput-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->l:Ljava/lang/String;

    .line 124
    iput-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->m:Ljava/lang/String;

    .line 125
    iput-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->n:Ljava/lang/String;

    .line 126
    iput-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->i:Ljava/lang/String;

    .line 127
    iput-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->j:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;

    .line 128
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;[Ljava/lang/String;Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;ILjava/lang/String;)V
    .locals 1

    .prologue
    .line 93
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 94
    iput-object p1, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->f:Ljava/lang/String;

    .line 95
    iput-object p2, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->g:[Ljava/lang/String;

    .line 96
    iput-object p11, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->h:Ljava/lang/String;

    .line 97
    iput-object p3, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->a:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    .line 98
    iput-object p4, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->k:Ljava/lang/String;

    .line 99
    iput-object p5, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->l:Ljava/lang/String;

    .line 100
    iput-object p6, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->m:Ljava/lang/String;

    .line 101
    iput-object p7, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->n:Ljava/lang/String;

    .line 102
    iput-object p8, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->i:Ljava/lang/String;

    .line 103
    iput-object p9, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->j:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;

    .line 104
    iput p10, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->b:I

    .line 105
    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->b()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->c:Ljava/lang/String;

    .line 106
    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->c()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->d:Ljava/lang/String;

    .line 107
    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->d()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->e:Ljava/lang/String;

    .line 108
    return-void
.end method

.method public static a(Ljava/lang/String;I)Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;
    .locals 1

    .prologue
    .line 280
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;

    invoke-direct {v0, p0, p1}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;-><init>(Ljava/lang/String;I)V

    return-object v0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;I)Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;
    .locals 1

    .prologue
    .line 139
    const/4 v0, 0x0

    invoke-static {p0, v0, p1, p2, p3}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;I)Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;

    move-result-object v0

    return-object v0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;I)Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;
    .locals 7

    .prologue
    .line 166
    const/4 v1, 0x0

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move v6, p5

    invoke-static/range {v0 .. v6}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;I)Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;

    move-result-object v0

    return-object v0
.end method

.method public static a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;I)Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;
    .locals 12

    .prologue
    .line 152
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;

    sget-object v3, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;->range:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v11, 0x0

    move-object v1, p0

    move-object v2, p1

    move-object v8, p2

    move-object v9, p3

    move/from16 v10, p4

    invoke-direct/range {v0 .. v11}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;-><init>(Ljava/lang/String;[Ljava/lang/String;Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;ILjava/lang/String;)V

    return-object v0
.end method

.method public static a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;I)Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;
    .locals 12

    .prologue
    .line 181
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;

    sget-object v3, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;->exact:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v1, p0

    move-object v2, p1

    move-object v4, p3

    move-object/from16 v8, p4

    move-object/from16 v9, p5

    move/from16 v10, p6

    move-object v11, p2

    invoke-direct/range {v0 .. v11}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;-><init>(Ljava/lang/String;[Ljava/lang/String;Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;ILjava/lang/String;)V

    return-object v0
.end method

.method private a(Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 307
    const-string v0, "SELECT count(*) FROM (%s)"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 5

    .prologue
    .line 402
    if-nez p0, :cond_0

    .line 426
    :goto_0
    return-object p1

    .line 406
    :cond_0
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 407
    const-string v1, "[^\\(\\) ]+"

    invoke-static {v1}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v1

    .line 408
    invoke-virtual {v1, p1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v1

    .line 409
    :goto_1
    invoke-virtual {v1}, Ljava/util/regex/Matcher;->find()Z

    move-result v2

    if-eqz v2, :cond_3

    .line 410
    invoke-virtual {v1}, Ljava/util/regex/Matcher;->group()Ljava/lang/String;

    move-result-object v2

    .line 411
    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v3

    .line 413
    const-string v4, "and"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_1

    const-string v4, "or"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_1

    const-string v4, "not"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    const-string v3, "{"

    .line 414
    invoke-virtual {v2, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 417
    :cond_1
    invoke-virtual {v1, v0, v2}, Ljava/util/regex/Matcher;->appendReplacement(Ljava/lang/StringBuffer;Ljava/lang/String;)Ljava/util/regex/Matcher;

    goto :goto_1

    .line 421
    :cond_2
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ":"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/regex/Matcher;->appendReplacement(Ljava/lang/StringBuffer;Ljava/lang/String;)Ljava/util/regex/Matcher;

    goto :goto_1

    .line 424
    :cond_3
    invoke-virtual {v1, v0}, Ljava/util/regex/Matcher;->appendTail(Ljava/lang/StringBuffer;)Ljava/lang/StringBuffer;

    .line 426
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object p1

    goto :goto_0
.end method

.method private b()Ljava/lang/String;
    .locals 5

    .prologue
    .line 287
    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->e()Ljava/lang/String;

    move-result-object v0

    .line 288
    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->f()Ljava/lang/String;

    move-result-object v1

    .line 289
    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->g()Ljava/lang/String;

    move-result-object v2

    .line 290
    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->h()Ljava/lang/String;

    move-result-object v3

    .line 291
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private b(Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 324
    const-string v0, "SELECT id FROM (%s)"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private c()Ljava/lang/String;
    .locals 4

    .prologue
    .line 298
    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->f()Ljava/lang/String;

    move-result-object v0

    .line 299
    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->g()Ljava/lang/String;

    move-result-object v1

    .line 300
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "SELECT count(*) "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private c(Ljava/lang/String;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 457
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "{"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->f:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private d()Ljava/lang/String;
    .locals 5

    .prologue
    .line 314
    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->f()Ljava/lang/String;

    move-result-object v0

    .line 315
    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->g()Ljava/lang/String;

    move-result-object v1

    .line 316
    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->h()Ljava/lang/String;

    move-result-object v2

    .line 317
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "SELECT id "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private e()Ljava/lang/String;
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 331
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 332
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->g:[Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->g:[Ljava/lang/String;

    :goto_0
    array-length v3, v0

    :goto_1
    if-ge v1, v3, :cond_1

    aget-object v4, v0, v1

    .line 333
    invoke-direct {p0, v4}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 332
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    :cond_0
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const-string v3, "_soup"

    aput-object v3, v0, v1

    goto :goto_0

    .line 335
    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "SELECT "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", "

    invoke-static {v1, v2}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private f()Ljava/lang/String;
    .locals 2

    .prologue
    .line 342
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "FROM "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->i()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private g()Ljava/lang/String;
    .locals 4

    .prologue
    .line 349
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->h:Ljava/lang/String;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->a:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    sget-object v1, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;->match:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    if-eq v0, v1, :cond_0

    const-string v0, ""

    .line 391
    :goto_0
    return-object v0

    .line 351
    :cond_0
    const/4 v0, 0x0

    .line 353
    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->h:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 354
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->h:Ljava/lang/String;

    invoke-direct {p0, v0}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 357
    :cond_1
    const-string v1, ""

    .line 358
    sget-object v2, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$1;->a:[I

    iget-object v3, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->a:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 389
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Fell through switch: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->a:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 360
    :pswitch_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " = ? "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 391
    :goto_1
    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    const-string v0, ""

    goto :goto_0

    .line 363
    :pswitch_1
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " LIKE ? "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 366
    :pswitch_2
    iget-object v2, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->l:Ljava/lang/String;

    if-nez v2, :cond_2

    iget-object v2, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->m:Ljava/lang/String;

    if-nez v2, :cond_2

    move-object v0, v1

    .line 367
    goto :goto_1

    .line 369
    :cond_2
    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->m:Ljava/lang/String;

    if-nez v1, :cond_3

    .line 370
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " >= ? "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 373
    :cond_3
    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->l:Ljava/lang/String;

    if-nez v1, :cond_4

    .line 374
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " <= ? "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 378
    :cond_4
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " >= ? AND "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " <= ? "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 382
    :pswitch_3
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "_soupEntryId"

    invoke-direct {p0, v2}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " IN ("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "SELECT "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "rowid"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "FROM "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 383
    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->j()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "WHERE "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 384
    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->j()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " MATCH \'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->k:Ljava/lang/String;

    invoke-static {v0, v2}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\') "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 391
    :cond_5
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "WHERE "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 358
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method private h()Ljava/lang/String;
    .locals 2

    .prologue
    .line 433
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->i:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->j:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;

    if-nez v0, :cond_1

    :cond_0
    const-string v0, ""

    .line 435
    :goto_0
    return-object v0

    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "ORDER BY "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->i:Ljava/lang/String;

    invoke-direct {p0, v1}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->j:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;

    iget-object v1, v1, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;->sql:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private i()Ljava/lang/String;
    .locals 2

    .prologue
    .line 442
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "{"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->f:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private j()Ljava/lang/String;
    .locals 2

    .prologue
    .line 449
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->i()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "_fts"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public a()[Ljava/lang/String;
    .locals 5

    .prologue
    const/4 v0, 0x0

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 464
    sget-object v1, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$1;->a:[I

    iget-object v2, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->a:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 483
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Fell through switch: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->a:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 466
    :pswitch_0
    new-array v0, v4, [Ljava/lang/String;

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->k:Ljava/lang/String;

    aput-object v1, v0, v3

    .line 481
    :cond_0
    :goto_0
    :pswitch_1
    return-object v0

    .line 468
    :pswitch_2
    new-array v0, v4, [Ljava/lang/String;

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->n:Ljava/lang/String;

    aput-object v1, v0, v3

    goto :goto_0

    .line 470
    :pswitch_3
    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->l:Ljava/lang/String;

    if-nez v1, :cond_1

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->m:Ljava/lang/String;

    if-eqz v1, :cond_0

    .line 472
    :cond_1
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->m:Ljava/lang/String;

    if-nez v0, :cond_2

    .line 473
    new-array v0, v4, [Ljava/lang/String;

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->l:Ljava/lang/String;

    aput-object v1, v0, v3

    goto :goto_0

    .line 474
    :cond_2
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->l:Ljava/lang/String;

    if-nez v0, :cond_3

    .line 475
    new-array v0, v4, [Ljava/lang/String;

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->m:Ljava/lang/String;

    aput-object v1, v0, v3

    goto :goto_0

    .line 477
    :cond_3
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/String;

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->l:Ljava/lang/String;

    aput-object v1, v0, v3

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->m:Ljava/lang/String;

    aput-object v1, v0, v4

    goto :goto_0

    .line 464
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_2
        :pswitch_3
        :pswitch_1
        :pswitch_1
    .end packed-switch
.end method
