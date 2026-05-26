.class public Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;
.super Ljava/lang/Object;
.source "IndexSpec.java"


# instance fields
.field public final a:Ljava/lang/String;

.field public final b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

.field public final c:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;)V
    .locals 1

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    iput-object p1, p0, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->a:Ljava/lang/String;

    .line 50
    iput-object p2, p0, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    .line 51
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->c:Ljava/lang/String;

    .line 52
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    iput-object p1, p0, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->a:Ljava/lang/String;

    .line 56
    iput-object p2, p0, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    .line 57
    iput-object p3, p0, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->c:Ljava/lang/String;

    .line 58
    return-void
.end method

.method public static a(Lorg/json/JSONObject;)Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 143
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    const-string v1, "path"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "type"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->valueOf(Ljava/lang/String;)Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    move-result-object v2

    const-string v3, "columnName"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;-><init>(Ljava/lang/String;Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;Ljava/lang/String;)V

    return-object v0
.end method

.method public static a([Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)Ljava/util/Map;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;",
            ">;"
        }
    .end annotation

    .prologue
    .line 152
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 153
    array-length v2, p0

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v2, :cond_0

    aget-object v3, p0, v0

    .line 154
    iget-object v4, v3, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->a:Ljava/lang/String;

    invoke-interface {v1, v4, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 153
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 156
    :cond_0
    return-object v1
.end method

.method public static a(Lorg/json/JSONArray;)[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 129
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    move v0, v1

    .line 130
    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-ge v0, v3, :cond_0

    .line 131
    invoke-virtual {p0, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    invoke-static {v3}, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->a(Lorg/json/JSONObject;)Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 130
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 133
    :cond_0
    new-array v0, v1, [Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    invoke-interface {v2, v0}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    return-object v0
.end method

.method public static b([Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)Z
    .locals 5

    .prologue
    const/4 v0, 0x0

    .line 164
    array-length v2, p0

    move v1, v0

    :goto_0
    if-ge v1, v2, :cond_0

    aget-object v3, p0, v1

    .line 165
    iget-object v3, v3, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    sget-object v4, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->full_text:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    if-ne v3, v4, :cond_1

    .line 166
    const/4 v0, 0x1

    .line 169
    :cond_0
    return v0

    .line 164
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method public static c([Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)Z
    .locals 5

    .prologue
    const/4 v0, 0x0

    .line 177
    array-length v2, p0

    move v1, v0

    :goto_0
    if-ge v1, v2, :cond_0

    aget-object v3, p0, v1

    .line 178
    iget-object v3, v3, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    sget-object v4, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->json1:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    if-ne v3, v4, :cond_1

    .line 179
    const/4 v0, 0x1

    .line 182
    :cond_0
    return v0

    .line 177
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 2

    .prologue
    .line 95
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "|"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 72
    if-nez p1, :cond_1

    .line 88
    :cond_0
    :goto_0
    return v2

    .line 74
    :cond_1
    if-ne p1, p0, :cond_2

    move v2, v1

    .line 75
    goto :goto_0

    .line 76
    :cond_2
    instance-of v0, p1, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    if-eqz v0, :cond_0

    .line 79
    check-cast p1, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    .line 81
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->a:Ljava/lang/String;

    iget-object v3, p1, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->a:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    move v0, v1

    .line 82
    :goto_1
    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    iget-object v3, p1, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    invoke-virtual {v0, v3}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    move v0, v1

    .line 83
    :goto_2
    iget-object v3, p0, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->c:Ljava/lang/String;

    if-nez v3, :cond_7

    .line 84
    if-eqz v0, :cond_6

    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->c:Ljava/lang/String;

    iget-object v3, p1, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->c:Ljava/lang/String;

    if-ne v0, v3, :cond_6

    :cond_3
    :goto_3
    move v2, v1

    .line 88
    goto :goto_0

    :cond_4
    move v0, v2

    .line 81
    goto :goto_1

    :cond_5
    move v0, v2

    .line 82
    goto :goto_2

    :cond_6
    move v1, v2

    .line 84
    goto :goto_3

    .line 86
    :cond_7
    if-eqz v0, :cond_8

    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->c:Ljava/lang/String;

    iget-object v3, p1, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->c:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    :cond_8
    move v1, v2

    goto :goto_3
.end method

.method public hashCode()I
    .locals 2

    .prologue
    .line 62
    .line 63
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->a:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    add-int/lit16 v0, v0, 0x20f

    .line 64
    mul-int/lit8 v0, v0, 0x1f

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    .line 65
    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->c:Ljava/lang/String;

    if-eqz v1, :cond_0

    .line 66
    mul-int/lit8 v0, v0, 0x1f

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;->c:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    .line 67
    :cond_0
    return v0
.end method
