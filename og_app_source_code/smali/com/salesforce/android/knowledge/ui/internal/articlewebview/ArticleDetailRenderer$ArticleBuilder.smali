.class Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;
.super Ljava/lang/Object;
.source "ArticleDetailRenderer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "ArticleBuilder"
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;


# direct methods
.method private constructor <init>()V
    .locals 1

    .prologue
    .line 135
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 136
    invoke-static {}, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->a()Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;->a:Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;

    .line 137
    return-void
.end method

.method public static a()Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;
    .locals 1

    .prologue
    .line 132
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;

    invoke-direct {v0}, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;-><init>()V

    return-object v0
.end method


# virtual methods
.method public a(I)Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;
    .locals 6

    .prologue
    .line 174
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;->a:Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;

    const-string v1, "*"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "color:#"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const v5, 0xffffff

    and-int/2addr v5, p1

    invoke-static {v5}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->a(Ljava/lang/String;[Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;

    .line 175
    return-object p0
.end method

.method public a(Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;
    .locals 1

    .prologue
    .line 153
    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 154
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;->a:Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->b(Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;

    .line 156
    :cond_0
    return-object p0
.end method

.method public a(Ljava/util/Date;)Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;
    .locals 3

    .prologue
    .line 184
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "MMMM dd, y"

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 185
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;->a:Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;

    const-string v2, "modified_date"

    invoke-virtual {v0, p1}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;

    .line 186
    return-object p0
.end method

.method public a(Ljava/util/List;)Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/ArticleDetails$Field;",
            ">;)",
            "Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;"
        }
    .end annotation

    .prologue
    .line 190
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/core/model/ArticleDetails$Field;

    .line 191
    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/model/ArticleDetails$Field;->c()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 192
    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/model/ArticleDetails$Field;->d()I

    move-result v2

    if-eqz v2, :cond_0

    sget-object v2, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer;->a:Ljava/util/List;

    .line 193
    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/model/ArticleDetails$Field;->b()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 197
    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;->a:Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;

    invoke-virtual {v2}, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->b()Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;

    move-result-object v2

    .line 198
    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/model/ArticleDetails$Field;->c()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->e(Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;

    move-result-object v0

    .line 199
    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->c()Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;

    goto :goto_0

    .line 201
    :cond_1
    return-object p0
.end method

.method public b()Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;
    .locals 2

    .prologue
    .line 146
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;->a:Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;

    const-string v1, "CSS_FILE_PLACEHOLDER"

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->a(Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;

    .line 147
    return-object p0
.end method

.method public b(I)Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;
    .locals 6

    .prologue
    .line 179
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;->a:Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;

    const-string v1, "a"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "color:#"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const v5, 0xffffff

    and-int/2addr v5, p1

    invoke-static {v5}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->a(Ljava/lang/String;[Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;

    .line 180
    return-object p0
.end method

.method public b(Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;
    .locals 1

    .prologue
    .line 162
    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 163
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;->a:Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->c(Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;

    .line 165
    :cond_0
    return-object p0
.end method

.method public c(Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;
    .locals 1

    .prologue
    .line 169
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;->a:Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->d(Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;

    .line 170
    return-object p0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 205
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articlewebview/ArticleDetailRenderer$ArticleBuilder;->a:Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->d()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
