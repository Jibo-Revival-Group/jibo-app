.class public Lcom/salesforce/android/cases/core/internal/http/util/CaseConstants;
.super Ljava/lang/Object;
.source "CaseConstants.java"


# annotations
.annotation build Landroid/annotation/SuppressLint;
    value = {
        "SimpleDateFormat"
    }
.end annotation


# static fields
.field public static final a:Ljava/util/Date;

.field public static final b:Ljava/util/Map;
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
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 150
    new-instance v0, Ljava/util/Date;

    const-wide/16 v2, 0x0

    invoke-direct {v0, v2, v3}, Ljava/util/Date;-><init>(J)V

    sput-object v0, Lcom/salesforce/android/cases/core/internal/http/util/CaseConstants;->a:Ljava/util/Date;

    .line 167
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/salesforce/android/cases/core/internal/http/util/CaseConstants;->b:Ljava/util/Map;

    .line 168
    sget-object v0, Lcom/salesforce/android/cases/core/internal/http/util/CaseConstants;->b:Ljava/util/Map;

    const-string v1, "equals"

    const-string v2, "="

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 169
    sget-object v0, Lcom/salesforce/android/cases/core/internal/http/util/CaseConstants;->b:Ljava/util/Map;

    const-string v1, "notEquals"

    const-string v2, "!="

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 170
    sget-object v0, Lcom/salesforce/android/cases/core/internal/http/util/CaseConstants;->b:Ljava/util/Map;

    const-string v1, "lessThan"

    const-string v2, "<"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 171
    sget-object v0, Lcom/salesforce/android/cases/core/internal/http/util/CaseConstants;->b:Ljava/util/Map;

    const-string v1, "greaterThan"

    const-string v2, ">"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 172
    sget-object v0, Lcom/salesforce/android/cases/core/internal/http/util/CaseConstants;->b:Ljava/util/Map;

    const-string v1, "lessThanOrEqualTo"

    const-string v2, "<="

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 173
    sget-object v0, Lcom/salesforce/android/cases/core/internal/http/util/CaseConstants;->b:Ljava/util/Map;

    const-string v1, "greaterThanOrEqualTo"

    const-string v2, ">="

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 174
    sget-object v0, Lcom/salesforce/android/cases/core/internal/http/util/CaseConstants;->b:Ljava/util/Map;

    const-string v1, "like"

    const-string v2, "like"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 175
    return-void
.end method
