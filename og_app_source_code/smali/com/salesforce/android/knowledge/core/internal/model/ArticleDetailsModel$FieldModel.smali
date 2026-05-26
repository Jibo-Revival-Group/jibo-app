.class public Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel$FieldModel;
.super Ljava/lang/Object;
.source "ArticleDetailsModel.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/core/model/ArticleDetails$Field;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FieldModel"
.end annotation


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Ljava/lang/String;

.field private final c:Ljava/lang/String;

.field private final d:I


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 145
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 146
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel$FieldModel;->a:Ljava/lang/String;

    .line 147
    iput-object p2, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel$FieldModel;->b:Ljava/lang/String;

    .line 148
    iput-object p3, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel$FieldModel;->c:Ljava/lang/String;

    .line 149
    iput p4, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel$FieldModel;->d:I

    .line 150
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse$LayoutItem;)Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel$FieldModel;
    .locals 7

    .prologue
    const/4 v2, 0x3

    const/4 v1, 0x2

    const/4 v0, 0x1

    const/4 v3, 0x0

    .line 153
    .line 154
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse$LayoutItem;->c()Ljava/lang/String;

    move-result-object v5

    const/4 v4, -0x1

    invoke-virtual {v5}, Ljava/lang/String;->hashCode()I

    move-result v6

    sparse-switch v6, :sswitch_data_0

    :cond_0
    :goto_0
    packed-switch v4, :pswitch_data_0

    move v0, v3

    .line 169
    :goto_1
    :pswitch_0
    new-instance v1, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel$FieldModel;

    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse$LayoutItem;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse$LayoutItem;->b()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse$LayoutItem;->d()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v2, v3, v4, v0}, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel$FieldModel;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    return-object v1

    .line 154
    :sswitch_0
    const-string v6, "TEXT"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    move v4, v3

    goto :goto_0

    :sswitch_1
    const-string v6, "TEXT_AREA"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    move v4, v0

    goto :goto_0

    :sswitch_2
    const-string v6, "LONG_TEXT_AREA"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    move v4, v1

    goto :goto_0

    :sswitch_3
    const-string v6, "RICH_TEXT_AREA"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    move v4, v2

    goto :goto_0

    :pswitch_1
    move v0, v1

    .line 160
    goto :goto_1

    :pswitch_2
    move v0, v2

    .line 163
    goto :goto_1

    .line 165
    :pswitch_3
    const/4 v0, 0x4

    goto :goto_1

    .line 154
    :sswitch_data_0
    .sparse-switch
        0x273d2d -> :sswitch_0
        0x517370bc -> :sswitch_3
        0x5d10465c -> :sswitch_2
        0x69fa785f -> :sswitch_1
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel$FieldModel;
    .locals 1

    .prologue
    .line 173
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel$FieldModel;

    invoke-direct {v0, p0, p1, p2, p3}, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel$FieldModel;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    return-object v0
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 177
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel$FieldModel;->a:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 181
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel$FieldModel;->b:Ljava/lang/String;

    return-object v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 185
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel$FieldModel;->c:Ljava/lang/String;

    return-object v0
.end method

.method public d()I
    .locals 1

    .prologue
    .line 189
    iget v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel$FieldModel;->d:I

    return v0
.end method
