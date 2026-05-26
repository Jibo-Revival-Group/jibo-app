.class public Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$LayoutItem;
.super Ljava/lang/Object;
.source "QuickActionResponse.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "LayoutItem"
.end annotation


# instance fields
.field private fields:Ljava/util/List;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "fields"
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$Field;",
            ">;"
        }
    .end annotation
.end field

.field private label:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "label"
    .end annotation
.end field

.field private readOnly:Z
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "readOnly"
    .end annotation
.end field

.field private required:Z
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "required"
    .end annotation
.end field


# virtual methods
.method public a()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$Field;",
            ">;"
        }
    .end annotation

    .prologue
    .line 98
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$LayoutItem;->fields:Ljava/util/List;

    if-nez v0, :cond_0

    .line 99
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    .line 101
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$LayoutItem;->fields:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    goto :goto_0
.end method

.method public b()Z
    .locals 1

    .prologue
    .line 109
    iget-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$LayoutItem;->readOnly:Z

    return v0
.end method

.method public c()Z
    .locals 1

    .prologue
    .line 113
    iget-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$LayoutItem;->required:Z

    return v0
.end method
