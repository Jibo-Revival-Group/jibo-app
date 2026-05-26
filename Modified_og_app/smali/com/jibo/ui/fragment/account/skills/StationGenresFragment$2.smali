.class Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$2;
.super Ljava/lang/Object;
.source "StationGenresFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->q()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazonaws/handlers/AsyncHandler",
        "<",
        "Lcom/jibo/aws/integration/aws/services/person/model/GetLoopPropertiesRequest;",
        "Ljava/util/HashMap",
        "<",
        "Ljava/lang/String;",
        "Lcom/google/gson/JsonObject;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)V
    .locals 0

    .prologue
    .line 243
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$2;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/person/model/GetLoopPropertiesRequest;Ljava/util/HashMap;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/jibo/aws/integration/aws/services/person/model/GetLoopPropertiesRequest;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/gson/JsonObject;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 267
    if-eqz p2, :cond_0

    :try_start_0
    invoke-virtual {p2}, Ljava/util/HashMap;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "com.jibo.music.stations"

    .line 268
    invoke-virtual {p2, v0}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "com.jibo.music.stations"

    .line 269
    invoke-virtual {p2, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/gson/JsonObject;

    const-string v2, "loops"

    invoke-virtual {v0, v2}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 270
    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$2;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    const-string v0, "com.jibo.music.stations"

    invoke-virtual {p2, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/gson/JsonObject;

    invoke-static {v2, v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->a(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;

    .line 271
    const-string v0, "com.jibo.music.stations"

    invoke-virtual {p2, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/gson/JsonObject;

    const-string v2, "loops"

    invoke-virtual {v0, v2}, Lcom/google/gson/JsonObject;->d(Ljava/lang/String;)Lcom/google/gson/JsonArray;

    move-result-object v2

    move v0, v1

    .line 272
    :goto_0
    invoke-virtual {v2}, Lcom/google/gson/JsonArray;->a()I

    move-result v3

    if-ge v0, v3, :cond_0

    .line 273
    invoke-virtual {v2, v0}, Lcom/google/gson/JsonArray;->a(I)Lcom/google/gson/JsonElement;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/gson/JsonElement;->l()Lcom/google/gson/JsonObject;

    move-result-object v3

    const-string v4, "id"

    invoke-virtual {v3, v4}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/gson/JsonElement;->c()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$2;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v4}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->c(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v4

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 274
    iget-object v3, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$2;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    new-instance v4, Lcom/google/gson/Gson;

    invoke-direct {v4}, Lcom/google/gson/Gson;-><init>()V

    .line 275
    invoke-virtual {v2, v0}, Lcom/google/gson/JsonArray;->a(I)Lcom/google/gson/JsonElement;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/gson/JsonElement;->l()Lcom/google/gson/JsonObject;

    move-result-object v0

    const-string v2, "genres"

    invoke-virtual {v0, v2}, Lcom/google/gson/JsonObject;->d(Ljava/lang/String;)Lcom/google/gson/JsonArray;

    move-result-object v0

    new-instance v2, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$2$1;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$2$1;-><init>(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$2;)V

    .line 276
    invoke-virtual {v2}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$2$1;->getType()Ljava/lang/reflect/Type;

    move-result-object v2

    .line 274
    invoke-virtual {v4, v0, v2}, Lcom/google/gson/Gson;->a(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-static {v3, v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->a(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;Ljava/util/List;)Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 288
    :cond_0
    :goto_1
    :try_start_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$2;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->d()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 289
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$2;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->a(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 295
    :cond_1
    :goto_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$2;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->b(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)V

    .line 296
    return-void

    .line 272
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 282
    :catch_0
    move-exception v0

    .line 283
    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$2;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    const-string v3, "error parsing default for genres"

    invoke-static {v2, v0, v3, v1}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->c(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    goto :goto_1

    .line 291
    :catch_1
    move-exception v0

    .line 292
    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$2;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    const-string v3, "error getting iHeart liveStationGenres"

    invoke-static {v2, v0, v3, v1}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->d(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    goto :goto_2
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 246
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$2;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    const-string v1, "get account properties"

    invoke-static {v0, p1, v1, v3}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->a(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    move-object v0, p1

    .line 248
    check-cast v0, Lcom/amazonaws/AmazonServiceException;

    invoke-static {v0}, Lcom/jibo/utils/ErrorHelper;->b(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_1

    check-cast p1, Lcom/amazonaws/AmazonServiceException;

    .line 249
    invoke-static {p1}, Lcom/jibo/utils/ErrorHelper;->a(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 253
    :try_start_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$2;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 254
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$2;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->a(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 260
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$2;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->b(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)V

    .line 262
    :cond_1
    return-void

    .line 256
    :catch_0
    move-exception v0

    .line 257
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$2;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    const-string v2, "error getting iHeart liveStationGenres"

    invoke-static {v1, v0, v2, v3}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->b(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    goto :goto_0
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 243
    check-cast p1, Lcom/jibo/aws/integration/aws/services/person/model/GetLoopPropertiesRequest;

    check-cast p2, Ljava/util/HashMap;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$2;->a(Lcom/jibo/aws/integration/aws/services/person/model/GetLoopPropertiesRequest;Ljava/util/HashMap;)V

    return-void
.end method
