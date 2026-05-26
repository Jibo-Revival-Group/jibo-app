.class Lcom/segment/analytics/ValueMap$Cache;
.super Ljava/lang/Object;
.source "ValueMap.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/segment/analytics/ValueMap;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Cache"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Lcom/segment/analytics/ValueMap;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private final cartographer:Lcom/segment/analytics/Cartographer;

.field private final clazz:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<TT;>;"
        }
    .end annotation
.end field

.field private final key:Ljava/lang/String;

.field private final preferences:Landroid/content/SharedPreferences;

.field private value:Lcom/segment/analytics/ValueMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Landroid/content/Context;Lcom/segment/analytics/Cartographer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/segment/analytics/Cartographer;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 370
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 371
    iput-object p2, p0, Lcom/segment/analytics/ValueMap$Cache;->cartographer:Lcom/segment/analytics/Cartographer;

    .line 372
    invoke-static {p1, p4}, Lcom/segment/analytics/internal/Utils;->getSegmentSharedPreferences(Landroid/content/Context;Ljava/lang/String;)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/segment/analytics/ValueMap$Cache;->preferences:Landroid/content/SharedPreferences;

    .line 373
    iput-object p3, p0, Lcom/segment/analytics/ValueMap$Cache;->key:Ljava/lang/String;

    .line 374
    iput-object p5, p0, Lcom/segment/analytics/ValueMap$Cache;->clazz:Ljava/lang/Class;

    .line 375
    return-void
.end method


# virtual methods
.method create(Ljava/util/Map;)Lcom/segment/analytics/ValueMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)TT;"
        }
    .end annotation

    .prologue
    .line 396
    iget-object v0, p0, Lcom/segment/analytics/ValueMap$Cache;->clazz:Ljava/lang/Class;

    invoke-static {p1, v0}, Lcom/segment/analytics/ValueMap;->createValueMap(Ljava/util/Map;Ljava/lang/Class;)Lcom/segment/analytics/ValueMap;

    move-result-object v0

    return-object v0
.end method

.method delete()V
    .locals 2

    .prologue
    .line 406
    iget-object v0, p0, Lcom/segment/analytics/ValueMap$Cache;->preferences:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    iget-object v1, p0, Lcom/segment/analytics/ValueMap$Cache;->key:Ljava/lang/String;

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 407
    return-void
.end method

.method get()Lcom/segment/analytics/ValueMap;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 378
    iget-object v1, p0, Lcom/segment/analytics/ValueMap$Cache;->value:Lcom/segment/analytics/ValueMap;

    if-nez v1, :cond_1

    .line 379
    iget-object v1, p0, Lcom/segment/analytics/ValueMap$Cache;->preferences:Landroid/content/SharedPreferences;

    iget-object v2, p0, Lcom/segment/analytics/ValueMap$Cache;->key:Ljava/lang/String;

    invoke-interface {v1, v2, v0}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 380
    invoke-static {v1}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 388
    :goto_0
    return-object v0

    .line 382
    :cond_0
    :try_start_0
    iget-object v2, p0, Lcom/segment/analytics/ValueMap$Cache;->cartographer:Lcom/segment/analytics/Cartographer;

    invoke-virtual {v2, v1}, Lcom/segment/analytics/Cartographer;->fromJson(Ljava/lang/String;)Ljava/util/Map;

    move-result-object v1

    .line 383
    invoke-virtual {p0, v1}, Lcom/segment/analytics/ValueMap$Cache;->create(Ljava/util/Map;)Lcom/segment/analytics/ValueMap;

    move-result-object v1

    iput-object v1, p0, Lcom/segment/analytics/ValueMap$Cache;->value:Lcom/segment/analytics/ValueMap;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 388
    :cond_1
    iget-object v0, p0, Lcom/segment/analytics/ValueMap$Cache;->value:Lcom/segment/analytics/ValueMap;

    goto :goto_0

    .line 384
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method isSet()Z
    .locals 2

    .prologue
    .line 392
    iget-object v0, p0, Lcom/segment/analytics/ValueMap$Cache;->preferences:Landroid/content/SharedPreferences;

    iget-object v1, p0, Lcom/segment/analytics/ValueMap$Cache;->key:Ljava/lang/String;

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method set(Lcom/segment/analytics/ValueMap;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 400
    iput-object p1, p0, Lcom/segment/analytics/ValueMap$Cache;->value:Lcom/segment/analytics/ValueMap;

    .line 401
    iget-object v0, p0, Lcom/segment/analytics/ValueMap$Cache;->cartographer:Lcom/segment/analytics/Cartographer;

    invoke-virtual {v0, p1}, Lcom/segment/analytics/Cartographer;->toJson(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v0

    .line 402
    iget-object v1, p0, Lcom/segment/analytics/ValueMap$Cache;->preferences:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    iget-object v2, p0, Lcom/segment/analytics/ValueMap$Cache;->key:Ljava/lang/String;

    invoke-interface {v1, v2, v0}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 403
    return-void
.end method
