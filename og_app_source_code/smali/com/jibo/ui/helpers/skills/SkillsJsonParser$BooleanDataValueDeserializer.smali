.class Lcom/jibo/ui/helpers/skills/SkillsJsonParser$BooleanDataValueDeserializer;
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
    name = "BooleanDataValueDeserializer"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/gson/JsonDeserializer",
        "<",
        "Lcom/jibo/ui/helpers/skills/DataItems$BooleanDataValue;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 304
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public deserialize(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/jibo/ui/helpers/skills/DataItems$BooleanDataValue;
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/gson/JsonParseException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 310
    new-instance v1, Lcom/jibo/ui/helpers/skills/DataItems$BooleanDataValue;

    invoke-direct {v1}, Lcom/jibo/ui/helpers/skills/DataItems$BooleanDataValue;-><init>()V

    .line 312
    invoke-virtual {p1}, Lcom/google/gson/JsonElement;->l()Lcom/google/gson/JsonObject;

    move-result-object v2

    const-string v3, "value"

    invoke-virtual {v2, v3}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v2

    .line 313
    invoke-virtual {v2}, Lcom/google/gson/JsonElement;->n()Lcom/google/gson/JsonPrimitive;

    move-result-object v3

    .line 316
    invoke-virtual {v3}, Lcom/google/gson/JsonPrimitive;->a()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-virtual {v2}, Lcom/google/gson/JsonElement;->g()Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    .line 320
    :goto_0
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    invoke-virtual {v1, v0}, Lcom/jibo/ui/helpers/skills/DataItems$BooleanDataValue;->setValue(Z)V

    .line 322
    return-object v1

    .line 317
    :cond_0
    invoke-virtual {v3}, Lcom/google/gson/JsonPrimitive;->p()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-virtual {v2}, Lcom/google/gson/JsonElement;->f()I

    move-result v2

    if-eqz v2, :cond_1

    const/4 v0, 0x1

    :cond_1
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    goto :goto_0

    .line 318
    :cond_2
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    goto :goto_0
.end method

.method public bridge synthetic deserialize(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/gson/JsonParseException;
        }
    .end annotation

    .prologue
    .line 304
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$BooleanDataValueDeserializer;->deserialize(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/jibo/ui/helpers/skills/DataItems$BooleanDataValue;

    move-result-object v0

    return-object v0
.end method
