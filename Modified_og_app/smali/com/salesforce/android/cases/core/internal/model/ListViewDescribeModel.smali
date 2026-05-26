.class public Lcom/salesforce/android/cases/core/internal/model/ListViewDescribeModel;
.super Ljava/lang/Object;
.source "ListViewDescribeModel.java"

# interfaces
.implements Lcom/salesforce/android/cases/core/model/ListViewDescribe;


# static fields
.field private static final a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 50
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/salesforce/android/cases/core/internal/model/ListViewDescribeModel;->a:Ljava/util/List;

    .line 51
    sget-object v0, Lcom/salesforce/android/cases/core/internal/model/ListViewDescribeModel;->a:Ljava/util/List;

    const-string v1, "WITH "

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 52
    sget-object v0, Lcom/salesforce/android/cases/core/internal/model/ListViewDescribeModel;->a:Ljava/util/List;

    const-string v1, "GROUP BY "

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 53
    sget-object v0, Lcom/salesforce/android/cases/core/internal/model/ListViewDescribeModel;->a:Ljava/util/List;

    const-string v1, "HAVING "

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 54
    sget-object v0, Lcom/salesforce/android/cases/core/internal/model/ListViewDescribeModel;->a:Ljava/util/List;

    const-string v1, "ORDER BY "

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 55
    sget-object v0, Lcom/salesforce/android/cases/core/internal/model/ListViewDescribeModel;->a:Ljava/util/List;

    const-string v1, "LIMIT "

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 56
    sget-object v0, Lcom/salesforce/android/cases/core/internal/model/ListViewDescribeModel;->a:Ljava/util/List;

    const-string v1, "OFFSET "

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 57
    sget-object v0, Lcom/salesforce/android/cases/core/internal/model/ListViewDescribeModel;->a:Ljava/util/List;

    const-string v1, "FOR "

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 58
    sget-object v0, Lcom/salesforce/android/cases/core/internal/model/ListViewDescribeModel;->a:Ljava/util/List;

    const-string v1, "UPDATE "

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 59
    return-void
.end method

.method private constructor <init>(Lcom/salesforce/android/cases/core/internal/http/response/ListViewDescribeResponse;)V
    .locals 3

    .prologue
    const/4 v2, -0x1

    .line 68
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 69
    if-nez p1, :cond_0

    .line 70
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "ListViewDescribeResponse cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 73
    :cond_0
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/ListViewDescribeResponse;->a()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/ListViewDescribeModel;->b:Ljava/lang/String;

    .line 74
    const-string v0, ""

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/ListViewDescribeModel;->c:Ljava/lang/String;

    .line 76
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/ListViewDescribeResponse;->b()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 78
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/ListViewDescribeResponse;->b()Ljava/lang/String;

    move-result-object v0

    const-string v1, "USING SCOPE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v0

    .line 81
    if-ne v0, v2, :cond_1

    .line 82
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/ListViewDescribeResponse;->b()Ljava/lang/String;

    move-result-object v0

    const-string v1, "WHERE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v0

    .line 86
    :cond_1
    if-eq v0, v2, :cond_2

    .line 87
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/ListViewDescribeResponse;->b()Ljava/lang/String;

    move-result-object v1

    .line 88
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/ListViewDescribeResponse;->b()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v0, v2}, Lcom/salesforce/android/cases/core/internal/model/ListViewDescribeModel;->a(ILjava/lang/String;)I

    move-result v2

    invoke-virtual {v1, v0, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 89
    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/ListViewDescribeModel;->c:Ljava/lang/String;

    .line 92
    :cond_2
    return-void
.end method

.method private a(ILjava/lang/String;)I
    .locals 3

    .prologue
    .line 103
    sget-object v0, Lcom/salesforce/android/cases/core/internal/model/ListViewDescribeModel;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 104
    invoke-virtual {p2, v0}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v0

    .line 105
    const/4 v2, -0x1

    if-eq v0, v2, :cond_0

    if-le v0, p1, :cond_0

    .line 109
    :goto_0
    return v0

    :cond_1
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v0

    goto :goto_0
.end method

.method public static a(Lcom/salesforce/android/cases/core/internal/http/response/ListViewDescribeResponse;)Lcom/salesforce/android/cases/core/model/ListViewDescribe;
    .locals 1

    .prologue
    .line 65
    new-instance v0, Lcom/salesforce/android/cases/core/internal/model/ListViewDescribeModel;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/internal/model/ListViewDescribeModel;-><init>(Lcom/salesforce/android/cases/core/internal/http/response/ListViewDescribeResponse;)V

    return-object v0
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/ListViewDescribeModel;->c:Ljava/lang/String;

    return-object v0
.end method
