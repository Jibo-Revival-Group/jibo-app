.class public Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$Field;
.super Ljava/lang/Object;
.source "QuickActionResponse.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "Field"
.end annotation


# instance fields
.field private extraTypeInfo:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "extraTypeInfo"
    .end annotation
.end field

.field private label:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "label"
    .end annotation
.end field

.field private length:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "length"
    .end annotation
.end field

.field private name:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "name"
    .end annotation
.end field

.field private pickListOption:Ljava/util/List;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "pickListOption"
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$PickListOption;",
            ">;"
        }
    .end annotation
.end field

.field private type:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "type"
    .end annotation
.end field

.field private value:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "value"
    .end annotation
.end field


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 132
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$Field;->label:Ljava/lang/String;

    return-object v0
.end method

.method public b()I
    .locals 1

    .prologue
    .line 136
    iget v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$Field;->length:I

    return v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 140
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$Field;->name:Ljava/lang/String;

    return-object v0
.end method

.method public d()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$PickListOption;",
            ">;"
        }
    .end annotation

    .prologue
    .line 144
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$Field;->pickListOption:Ljava/util/List;

    if-nez v0, :cond_0

    .line 145
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    .line 147
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$Field;->pickListOption:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    goto :goto_0
.end method

.method public e()Ljava/lang/String;
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$Field;->type:Ljava/lang/String;

    return-object v0
.end method

.method public f()Ljava/lang/String;
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$Field;->value:Ljava/lang/String;

    return-object v0
.end method
