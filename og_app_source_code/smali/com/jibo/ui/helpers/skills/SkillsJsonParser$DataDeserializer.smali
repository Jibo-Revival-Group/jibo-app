.class Lcom/jibo/ui/helpers/skills/SkillsJsonParser$DataDeserializer;
.super Ljava/lang/Object;
.source "SkillsJsonParser.java"

# interfaces
.implements Lcom/google/gson/JsonDeserializer;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/SkillsJsonParser;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "DataDeserializer"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/google/gson/JsonDeserializer",
        "<TT;>;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 278
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public deserialize(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Ljava/lang/Object;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/gson/JsonElement;",
            "Ljava/lang/reflect/Type;",
            "Lcom/google/gson/JsonDeserializationContext;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/gson/JsonParseException;
        }
    .end annotation

    .prologue
    .line 284
    invoke-virtual {p1}, Lcom/google/gson/JsonElement;->l()Lcom/google/gson/JsonObject;

    move-result-object v0

    const-string v1, "childViews"

    invoke-virtual {v0, v1}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v0

    .line 285
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/google/gson/JsonElement;->h()Z

    move-result v1

    if-nez v1, :cond_0

    .line 286
    invoke-virtual {p1}, Lcom/google/gson/JsonElement;->l()Lcom/google/gson/JsonObject;

    move-result-object v1

    const-string v2, "childViews"

    invoke-virtual {v1, v2}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    .line 287
    new-instance v1, Lcom/google/gson/JsonArray;

    invoke-direct {v1}, Lcom/google/gson/JsonArray;-><init>()V

    .line 288
    invoke-virtual {v1, v0}, Lcom/google/gson/JsonArray;->a(Lcom/google/gson/JsonElement;)V

    .line 289
    invoke-virtual {p1}, Lcom/google/gson/JsonElement;->l()Lcom/google/gson/JsonObject;

    move-result-object v0

    const-string v2, "childViews"

    invoke-virtual {v0, v2, v1}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Lcom/google/gson/JsonElement;)V

    .line 292
    :cond_0
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->access$000()Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {p1}, Lcom/google/gson/JsonElement;->l()Lcom/google/gson/JsonObject;

    move-result-object v1

    const-string v2, "type"

    invoke-virtual {v1, v2}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/gson/JsonElement;->c()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 293
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->access$000()Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {p1}, Lcom/google/gson/JsonElement;->l()Lcom/google/gson/JsonObject;

    move-result-object v1

    const-string v2, "type"

    invoke-virtual {v1, v2}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/gson/JsonElement;->c()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/reflect/Type;

    .line 296
    :goto_0
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->access$100()Ljava/util/HashMap;

    move-result-object v1

    invoke-virtual {p1}, Lcom/google/gson/JsonElement;->l()Lcom/google/gson/JsonObject;

    move-result-object v2

    const-string v3, "type"

    invoke-virtual {v2, v3}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/gson/JsonElement;->c()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 297
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->access$200()Lcom/google/gson/Gson;

    move-result-object v1

    invoke-virtual {p1}, Lcom/google/gson/JsonElement;->l()Lcom/google/gson/JsonObject;

    move-result-object v2

    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->access$100()Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {p1}, Lcom/google/gson/JsonElement;->l()Lcom/google/gson/JsonObject;

    move-result-object v3

    const-string v4, "type"

    invoke-virtual {v3, v4}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/gson/JsonElement;->c()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Class;

    invoke-virtual {v1, v2, v0}, Lcom/google/gson/Gson;->a(Lcom/google/gson/JsonElement;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    .line 299
    :goto_1
    return-object v0

    :cond_1
    move-object v0, p2

    .line 293
    goto :goto_0

    .line 299
    :cond_2
    new-instance v1, Lcom/google/gson/Gson;

    invoke-direct {v1}, Lcom/google/gson/Gson;-><init>()V

    invoke-virtual {p1}, Lcom/google/gson/JsonElement;->l()Lcom/google/gson/JsonObject;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Lcom/google/gson/Gson;->a(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_1
.end method
