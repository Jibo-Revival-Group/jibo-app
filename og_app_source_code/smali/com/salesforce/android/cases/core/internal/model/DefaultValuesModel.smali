.class public Lcom/salesforce/android/cases/core/internal/model/DefaultValuesModel;
.super Ljava/lang/Object;
.source "DefaultValuesModel.java"

# interfaces
.implements Lcom/salesforce/android/cases/core/model/DefaultValues;


# instance fields
.field private a:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>(Lcom/salesforce/android/cases/core/internal/http/response/DefaultValuesResponse;)V
    .locals 2

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    if-nez p1, :cond_0

    .line 43
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "DefaultValuesResponse cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 46
    :cond_0
    new-instance v0, Ljava/util/HashMap;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/DefaultValuesResponse;->a()Ljava/util/Map;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(Ljava/util/Map;)V

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/DefaultValuesModel;->a:Ljava/util/Map;

    .line 47
    return-void
.end method

.method public static a(Lcom/salesforce/android/cases/core/internal/http/response/DefaultValuesResponse;)Lcom/salesforce/android/cases/core/model/DefaultValues;
    .locals 1

    .prologue
    .line 38
    new-instance v0, Lcom/salesforce/android/cases/core/internal/model/DefaultValuesModel;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/internal/model/DefaultValuesModel;-><init>(Lcom/salesforce/android/cases/core/internal/http/response/DefaultValuesResponse;)V

    return-object v0
.end method


# virtual methods
.method public a()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 50
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/DefaultValuesModel;->a:Ljava/util/Map;

    return-object v0
.end method
