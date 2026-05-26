.class public Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;
.super Ljava/lang/Object;
.source "SoupSpec.java"


# static fields
.field public static final a:[Ljava/lang/String;


# instance fields
.field private b:Ljava/lang/String;

.field private c:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 45
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "externalStorage"

    aput-object v2, v0, v1

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;->a:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 58
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 59
    iput-object p1, p0, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;->b:Ljava/lang/String;

    .line 60
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;->c:Ljava/util/List;

    .line 61
    return-void
.end method

.method public varargs constructor <init>(Ljava/lang/String;[Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 69
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 70
    iput-object p1, p0, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;->b:Ljava/lang/String;

    .line 71
    if-eqz p2, :cond_0

    .line 72
    invoke-static {p2}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;->c:Ljava/util/List;

    .line 76
    :goto_0
    return-void

    .line 74
    :cond_0
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;->c:Ljava/util/List;

    goto :goto_0
.end method

.method public static a(Lorg/json/JSONObject;)Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 115
    const-string v0, "features"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 116
    if-eqz v2, :cond_1

    .line 117
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v0

    new-array v3, v0, [Ljava/lang/String;

    .line 118
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-ge v1, v0, :cond_0

    .line 119
    invoke-virtual {v2, v1}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    aput-object v0, v3, v1

    .line 118
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 122
    :cond_0
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;

    const-string v1, "name"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1, v3}, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;-><init>(Ljava/lang/String;[Ljava/lang/String;)V

    .line 124
    :goto_1
    return-object v0

    :cond_1
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;

    const-string v1, "name"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;-><init>(Ljava/lang/String;)V

    goto :goto_1
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;->b:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 93
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;->c:Ljava/util/List;

    return-object v0
.end method
