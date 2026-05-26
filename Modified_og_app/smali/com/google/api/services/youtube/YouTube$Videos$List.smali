.class public Lcom/google/api/services/youtube/YouTube$Videos$List;
.super Lcom/google/api/services/youtube/YouTubeRequest;
.source "YouTube.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/api/services/youtube/YouTube$Videos;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "List"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/api/services/youtube/YouTubeRequest",
        "<",
        "Lcom/google/api/services/youtube/model/VideoListResponse;",
        ">;"
    }
.end annotation


# static fields
.field private static final REST_PATH:Ljava/lang/String; = "videos"


# instance fields
.field private chart:Ljava/lang/String;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private hl:Ljava/lang/String;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private id:Ljava/lang/String;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private locale:Ljava/lang/String;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private maxHeight:Ljava/lang/Long;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private maxResults:Ljava/lang/Long;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private maxWidth:Ljava/lang/Long;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private myRating:Ljava/lang/String;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private onBehalfOfContentOwner:Ljava/lang/String;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private pageToken:Ljava/lang/String;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private part:Ljava/lang/String;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private regionCode:Ljava/lang/String;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field final synthetic this$1:Lcom/google/api/services/youtube/YouTube$Videos;

.field private videoCategoryId:Ljava/lang/String;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field


# direct methods
.method protected constructor <init>(Lcom/google/api/services/youtube/YouTube$Videos;Ljava/lang/String;)V
    .locals 6

    .prologue
    .line 15203
    iput-object p1, p0, Lcom/google/api/services/youtube/YouTube$Videos$List;->this$1:Lcom/google/api/services/youtube/YouTube$Videos;

    .line 15204
    iget-object v1, p1, Lcom/google/api/services/youtube/YouTube$Videos;->this$0:Lcom/google/api/services/youtube/YouTube;

    const-string v2, "GET"

    const-string v3, "videos"

    const/4 v4, 0x0

    const-class v5, Lcom/google/api/services/youtube/model/VideoListResponse;

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/google/api/services/youtube/YouTubeRequest;-><init>(Lcom/google/api/services/youtube/YouTube;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Class;)V

    .line 15205
    const-string v0, "Required parameter part must be specified."

    invoke-static {p2, v0}, Lcom/google/api/client/util/Preconditions;->checkNotNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/google/api/services/youtube/YouTube$Videos$List;->part:Ljava/lang/String;

    .line 15206
    return-void
.end method


# virtual methods
.method public buildHttpRequestUsingHead()Lcom/google/api/client/http/HttpRequest;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 15215
    invoke-super {p0}, Lcom/google/api/services/youtube/YouTubeRequest;->buildHttpRequestUsingHead()Lcom/google/api/client/http/HttpRequest;

    move-result-object v0

    return-object v0
.end method

.method public executeUsingHead()Lcom/google/api/client/http/HttpResponse;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 15210
    invoke-super {p0}, Lcom/google/api/services/youtube/YouTubeRequest;->executeUsingHead()Lcom/google/api/client/http/HttpResponse;

    move-result-object v0

    return-object v0
.end method

.method public getChart()Ljava/lang/String;
    .locals 1

    .prologue
    .line 15298
    iget-object v0, p0, Lcom/google/api/services/youtube/YouTube$Videos$List;->chart:Ljava/lang/String;

    return-object v0
.end method

.method public getHl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 15329
    iget-object v0, p0, Lcom/google/api/services/youtube/YouTube$Videos$List;->hl:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 15359
    iget-object v0, p0, Lcom/google/api/services/youtube/YouTube$Videos$List;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getLocale()Ljava/lang/String;
    .locals 1

    .prologue
    .line 15379
    iget-object v0, p0, Lcom/google/api/services/youtube/YouTube$Videos$List;->locale:Ljava/lang/String;

    return-object v0
.end method

.method public getMaxHeight()Ljava/lang/Long;
    .locals 1

    .prologue
    .line 15401
    iget-object v0, p0, Lcom/google/api/services/youtube/YouTube$Videos$List;->maxHeight:Ljava/lang/Long;

    return-object v0
.end method

.method public getMaxResults()Ljava/lang/Long;
    .locals 1

    .prologue
    .line 15431
    iget-object v0, p0, Lcom/google/api/services/youtube/YouTube$Videos$List;->maxResults:Ljava/lang/Long;

    return-object v0
.end method

.method public getMaxWidth()Ljava/lang/Long;
    .locals 1

    .prologue
    .line 15459
    iget-object v0, p0, Lcom/google/api/services/youtube/YouTube$Videos$List;->maxWidth:Ljava/lang/Long;

    return-object v0
.end method

.method public getMyRating()Ljava/lang/String;
    .locals 1

    .prologue
    .line 15482
    iget-object v0, p0, Lcom/google/api/services/youtube/YouTube$Videos$List;->myRating:Ljava/lang/String;

    return-object v0
.end method

.method public getOnBehalfOfContentOwner()Ljava/lang/String;
    .locals 1

    .prologue
    .line 15519
    iget-object v0, p0, Lcom/google/api/services/youtube/YouTube$Videos$List;->onBehalfOfContentOwner:Ljava/lang/String;

    return-object v0
.end method

.method public getPageToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 15557
    iget-object v0, p0, Lcom/google/api/services/youtube/YouTube$Videos$List;->pageToken:Ljava/lang/String;

    return-object v0
.end method

.method public getPart()Ljava/lang/String;
    .locals 1

    .prologue
    .line 15274
    iget-object v0, p0, Lcom/google/api/services/youtube/YouTube$Videos$List;->part:Ljava/lang/String;

    return-object v0
.end method

.method public getRegionCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 15586
    iget-object v0, p0, Lcom/google/api/services/youtube/YouTube$Videos$List;->regionCode:Ljava/lang/String;

    return-object v0
.end method

.method public getVideoCategoryId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 15612
    iget-object v0, p0, Lcom/google/api/services/youtube/YouTube$Videos$List;->videoCategoryId:Ljava/lang/String;

    return-object v0
.end method

.method public bridge synthetic set(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/client/googleapis/services/AbstractGoogleClientRequest;
    .locals 1

    .prologue
    .line 15180
    invoke-virtual {p0, p1, p2}, Lcom/google/api/services/youtube/YouTube$Videos$List;->set(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/services/youtube/YouTube$Videos$List;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic set(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/client/googleapis/services/json/AbstractGoogleJsonClientRequest;
    .locals 1

    .prologue
    .line 15180
    invoke-virtual {p0, p1, p2}, Lcom/google/api/services/youtube/YouTube$Videos$List;->set(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/services/youtube/YouTube$Videos$List;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic set(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/client/util/GenericData;
    .locals 1

    .prologue
    .line 15180
    invoke-virtual {p0, p1, p2}, Lcom/google/api/services/youtube/YouTube$Videos$List;->set(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/services/youtube/YouTube$Videos$List;

    move-result-object v0

    return-object v0
.end method

.method public set(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/services/youtube/YouTube$Videos$List;
    .locals 1

    .prologue
    .line 15627
    invoke-super {p0, p1, p2}, Lcom/google/api/services/youtube/YouTubeRequest;->set(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/services/youtube/YouTubeRequest;

    move-result-object v0

    check-cast v0, Lcom/google/api/services/youtube/YouTube$Videos$List;

    return-object v0
.end method

.method public bridge synthetic set(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/services/youtube/YouTubeRequest;
    .locals 1

    .prologue
    .line 15180
    invoke-virtual {p0, p1, p2}, Lcom/google/api/services/youtube/YouTube$Videos$List;->set(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/services/youtube/YouTube$Videos$List;

    move-result-object v0

    return-object v0
.end method

.method public setAlt(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTube$Videos$List;
    .locals 1

    .prologue
    .line 15220
    invoke-super {p0, p1}, Lcom/google/api/services/youtube/YouTubeRequest;->setAlt(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTubeRequest;

    move-result-object v0

    check-cast v0, Lcom/google/api/services/youtube/YouTube$Videos$List;

    return-object v0
.end method

.method public bridge synthetic setAlt(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTubeRequest;
    .locals 1

    .prologue
    .line 15180
    invoke-virtual {p0, p1}, Lcom/google/api/services/youtube/YouTube$Videos$List;->setAlt(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTube$Videos$List;

    move-result-object v0

    return-object v0
.end method

.method public setChart(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTube$Videos$List;
    .locals 0

    .prologue
    .line 15303
    iput-object p1, p0, Lcom/google/api/services/youtube/YouTube$Videos$List;->chart:Ljava/lang/String;

    .line 15304
    return-object p0
.end method

.method public setFields(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTube$Videos$List;
    .locals 1

    .prologue
    .line 15225
    invoke-super {p0, p1}, Lcom/google/api/services/youtube/YouTubeRequest;->setFields(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTubeRequest;

    move-result-object v0

    check-cast v0, Lcom/google/api/services/youtube/YouTube$Videos$List;

    return-object v0
.end method

.method public bridge synthetic setFields(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTubeRequest;
    .locals 1

    .prologue
    .line 15180
    invoke-virtual {p0, p1}, Lcom/google/api/services/youtube/YouTube$Videos$List;->setFields(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTube$Videos$List;

    move-result-object v0

    return-object v0
.end method

.method public setHl(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTube$Videos$List;
    .locals 0

    .prologue
    .line 15343
    iput-object p1, p0, Lcom/google/api/services/youtube/YouTube$Videos$List;->hl:Ljava/lang/String;

    .line 15344
    return-object p0
.end method

.method public setId(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTube$Videos$List;
    .locals 0

    .prologue
    .line 15368
    iput-object p1, p0, Lcom/google/api/services/youtube/YouTube$Videos$List;->id:Ljava/lang/String;

    .line 15369
    return-object p0
.end method

.method public setKey(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTube$Videos$List;
    .locals 1

    .prologue
    .line 15230
    invoke-super {p0, p1}, Lcom/google/api/services/youtube/YouTubeRequest;->setKey(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTubeRequest;

    move-result-object v0

    check-cast v0, Lcom/google/api/services/youtube/YouTube$Videos$List;

    return-object v0
.end method

.method public bridge synthetic setKey(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTubeRequest;
    .locals 1

    .prologue
    .line 15180
    invoke-virtual {p0, p1}, Lcom/google/api/services/youtube/YouTube$Videos$List;->setKey(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTube$Videos$List;

    move-result-object v0

    return-object v0
.end method

.method public setLocale(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTube$Videos$List;
    .locals 0

    .prologue
    .line 15384
    iput-object p1, p0, Lcom/google/api/services/youtube/YouTube$Videos$List;->locale:Ljava/lang/String;

    .line 15385
    return-object p0
.end method

.method public setMaxHeight(Ljava/lang/Long;)Lcom/google/api/services/youtube/YouTube$Videos$List;
    .locals 0

    .prologue
    .line 15409
    iput-object p1, p0, Lcom/google/api/services/youtube/YouTube$Videos$List;->maxHeight:Ljava/lang/Long;

    .line 15410
    return-object p0
.end method

.method public setMaxResults(Ljava/lang/Long;)Lcom/google/api/services/youtube/YouTube$Videos$List;
    .locals 0

    .prologue
    .line 15442
    iput-object p1, p0, Lcom/google/api/services/youtube/YouTube$Videos$List;->maxResults:Ljava/lang/Long;

    .line 15443
    return-object p0
.end method

.method public setMaxWidth(Ljava/lang/Long;)Lcom/google/api/services/youtube/YouTube$Videos$List;
    .locals 0

    .prologue
    .line 15467
    iput-object p1, p0, Lcom/google/api/services/youtube/YouTube$Videos$List;->maxWidth:Ljava/lang/Long;

    .line 15468
    return-object p0
.end method

.method public setMyRating(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTube$Videos$List;
    .locals 0

    .prologue
    .line 15490
    iput-object p1, p0, Lcom/google/api/services/youtube/YouTube$Videos$List;->myRating:Ljava/lang/String;

    .line 15491
    return-object p0
.end method

.method public setOauthToken(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTube$Videos$List;
    .locals 1

    .prologue
    .line 15235
    invoke-super {p0, p1}, Lcom/google/api/services/youtube/YouTubeRequest;->setOauthToken(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTubeRequest;

    move-result-object v0

    check-cast v0, Lcom/google/api/services/youtube/YouTube$Videos$List;

    return-object v0
.end method

.method public bridge synthetic setOauthToken(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTubeRequest;
    .locals 1

    .prologue
    .line 15180
    invoke-virtual {p0, p1}, Lcom/google/api/services/youtube/YouTube$Videos$List;->setOauthToken(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTube$Videos$List;

    move-result-object v0

    return-object v0
.end method

.method public setOnBehalfOfContentOwner(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTube$Videos$List;
    .locals 0

    .prologue
    .line 15534
    iput-object p1, p0, Lcom/google/api/services/youtube/YouTube$Videos$List;->onBehalfOfContentOwner:Ljava/lang/String;

    .line 15535
    return-object p0
.end method

.method public setPageToken(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTube$Videos$List;
    .locals 0

    .prologue
    .line 15569
    iput-object p1, p0, Lcom/google/api/services/youtube/YouTube$Videos$List;->pageToken:Ljava/lang/String;

    .line 15570
    return-object p0
.end method

.method public setPart(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTube$Videos$List;
    .locals 0

    .prologue
    .line 15287
    iput-object p1, p0, Lcom/google/api/services/youtube/YouTube$Videos$List;->part:Ljava/lang/String;

    .line 15288
    return-object p0
.end method

.method public setPrettyPrint(Ljava/lang/Boolean;)Lcom/google/api/services/youtube/YouTube$Videos$List;
    .locals 1

    .prologue
    .line 15240
    invoke-super {p0, p1}, Lcom/google/api/services/youtube/YouTubeRequest;->setPrettyPrint(Ljava/lang/Boolean;)Lcom/google/api/services/youtube/YouTubeRequest;

    move-result-object v0

    check-cast v0, Lcom/google/api/services/youtube/YouTube$Videos$List;

    return-object v0
.end method

.method public bridge synthetic setPrettyPrint(Ljava/lang/Boolean;)Lcom/google/api/services/youtube/YouTubeRequest;
    .locals 1

    .prologue
    .line 15180
    invoke-virtual {p0, p1}, Lcom/google/api/services/youtube/YouTube$Videos$List;->setPrettyPrint(Ljava/lang/Boolean;)Lcom/google/api/services/youtube/YouTube$Videos$List;

    move-result-object v0

    return-object v0
.end method

.method public setQuotaUser(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTube$Videos$List;
    .locals 1

    .prologue
    .line 15245
    invoke-super {p0, p1}, Lcom/google/api/services/youtube/YouTubeRequest;->setQuotaUser(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTubeRequest;

    move-result-object v0

    check-cast v0, Lcom/google/api/services/youtube/YouTube$Videos$List;

    return-object v0
.end method

.method public bridge synthetic setQuotaUser(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTubeRequest;
    .locals 1

    .prologue
    .line 15180
    invoke-virtual {p0, p1}, Lcom/google/api/services/youtube/YouTube$Videos$List;->setQuotaUser(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTube$Videos$List;

    move-result-object v0

    return-object v0
.end method

.method public setRegionCode(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTube$Videos$List;
    .locals 0

    .prologue
    .line 15595
    iput-object p1, p0, Lcom/google/api/services/youtube/YouTube$Videos$List;->regionCode:Ljava/lang/String;

    .line 15596
    return-object p0
.end method

.method public setUserIp(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTube$Videos$List;
    .locals 1

    .prologue
    .line 15250
    invoke-super {p0, p1}, Lcom/google/api/services/youtube/YouTubeRequest;->setUserIp(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTubeRequest;

    move-result-object v0

    check-cast v0, Lcom/google/api/services/youtube/YouTube$Videos$List;

    return-object v0
.end method

.method public bridge synthetic setUserIp(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTubeRequest;
    .locals 1

    .prologue
    .line 15180
    invoke-virtual {p0, p1}, Lcom/google/api/services/youtube/YouTube$Videos$List;->setUserIp(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTube$Videos$List;

    move-result-object v0

    return-object v0
.end method

.method public setVideoCategoryId(Ljava/lang/String;)Lcom/google/api/services/youtube/YouTube$Videos$List;
    .locals 0

    .prologue
    .line 15621
    iput-object p1, p0, Lcom/google/api/services/youtube/YouTube$Videos$List;->videoCategoryId:Ljava/lang/String;

    .line 15622
    return-object p0
.end method
