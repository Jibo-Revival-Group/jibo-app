.class public Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;
.super Ljava/lang/Object;
.source "HtmlBuilder.java"


# instance fields
.field final a:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "[",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field final b:Ljava/lang/StringBuilder;

.field final c:Ljava/lang/StringBuilder;

.field final d:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field final e:Ljava/util/List;
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
.method private constructor <init>()V
    .locals 2

    .prologue
    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->a:Ljava/util/Map;

    .line 39
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "<!doctype html><html><head>"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->b:Ljava/lang/StringBuilder;

    .line 40
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->c:Ljava/lang/StringBuilder;

    .line 41
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->d:Ljava/util/List;

    .line 42
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->e:Ljava/util/List;

    .line 53
    return-void
.end method

.method public static a()Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;
    .locals 1

    .prologue
    .line 49
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;

    invoke-direct {v0}, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;-><init>()V

    return-object v0
.end method


# virtual methods
.method public a(Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;
    .locals 2

    .prologue
    .line 60
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->b:Ljava/lang/StringBuilder;

    const-string v1, "<link rel=\"stylesheet\" type=\"text/css\" href=\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\"/>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 61
    return-object p0
.end method

.method public a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;
    .locals 2

    .prologue
    .line 110
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->c:Ljava/lang/StringBuilder;

    const-string v1, "<p class=\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\">"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "</p>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 111
    return-object p0
.end method

.method public varargs a(Ljava/lang/String;[Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->a:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 66
    return-object p0
.end method

.method public b()Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;
    .locals 2

    .prologue
    .line 90
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->c:Ljava/lang/StringBuilder;

    const-string v1, "<section>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 91
    return-object p0
.end method

.method public b(Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->d:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 71
    return-object p0
.end method

.method public c()Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;
    .locals 2

    .prologue
    .line 100
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->c:Ljava/lang/StringBuilder;

    const-string v1, "</section>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 101
    return-object p0
.end method

.method public c(Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->e:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 76
    return-object p0
.end method

.method public d(Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;
    .locals 2

    .prologue
    .line 80
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->c:Ljava/lang/StringBuilder;

    const-string v1, "<h1>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "</h1>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 81
    return-object p0
.end method

.method public d()Ljava/lang/String;
    .locals 6

    .prologue
    .line 126
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->b:Ljava/lang/StringBuilder;

    const-string v1, "<style type=\"text/css\">"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 127
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->a:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 128
    iget-object v3, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->b:Ljava/lang/StringBuilder;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "{"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 129
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/String;

    array-length v3, v0

    const/4 v1, 0x0

    :goto_1
    if-ge v1, v3, :cond_0

    aget-object v4, v0, v1

    .line 130
    iget-object v5, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->b:Ljava/lang/StringBuilder;

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ";"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 129
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 132
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->b:Ljava/lang/StringBuilder;

    const-string v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 134
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->b:Ljava/lang/StringBuilder;

    const-string v1, "</style>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 137
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 138
    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->b:Ljava/lang/StringBuilder;

    const-string v3, "<style type=\"text/css\">"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 139
    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->b:Ljava/lang/StringBuilder;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 140
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->b:Ljava/lang/StringBuilder;

    const-string v2, "</style>"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_2

    .line 144
    :cond_2
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->e:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_3
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 145
    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->c:Ljava/lang/StringBuilder;

    const-string v3, "<script>"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 146
    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->c:Ljava/lang/StringBuilder;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 147
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->c:Ljava/lang/StringBuilder;

    const-string v2, "</script>"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_3

    .line 150
    :cond_3
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->b:Ljava/lang/StringBuilder;

    const-string v1, "</head><body>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->c:Ljava/lang/StringBuilder;

    .line 151
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "</body></html>"

    .line 152
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 153
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 150
    return-object v0
.end method

.method public e(Ljava/lang/String;)Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;
    .locals 2

    .prologue
    .line 105
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/HtmlBuilder;->c:Ljava/lang/StringBuilder;

    const-string v1, "<p>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "</p>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 106
    return-object p0
.end method
