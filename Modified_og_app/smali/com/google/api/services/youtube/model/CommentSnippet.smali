.class public final Lcom/google/api/services/youtube/model/CommentSnippet;
.super Lcom/google/api/client/json/GenericJson;
.source "CommentSnippet.java"


# instance fields
.field private authorChannelId:Ljava/lang/Object;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private authorChannelUrl:Ljava/lang/String;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private authorDisplayName:Ljava/lang/String;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private authorProfileImageUrl:Ljava/lang/String;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private canRate:Ljava/lang/Boolean;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private channelId:Ljava/lang/String;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private likeCount:Ljava/lang/Long;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private moderationStatus:Ljava/lang/String;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private parentId:Ljava/lang/String;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private publishedAt:Lcom/google/api/client/util/DateTime;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private textDisplay:Ljava/lang/String;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private textOriginal:Ljava/lang/String;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private updatedAt:Lcom/google/api/client/util/DateTime;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private videoId:Ljava/lang/String;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field

.field private viewerRating:Ljava/lang/String;
    .annotation runtime Lcom/google/api/client/util/Key;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0}, Lcom/google/api/client/json/GenericJson;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic clone()Lcom/google/api/client/json/GenericJson;
    .locals 1

    .prologue
    .line 33
    invoke-virtual {p0}, Lcom/google/api/services/youtube/model/CommentSnippet;->clone()Lcom/google/api/services/youtube/model/CommentSnippet;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic clone()Lcom/google/api/client/util/GenericData;
    .locals 1

    .prologue
    .line 33
    invoke-virtual {p0}, Lcom/google/api/services/youtube/model/CommentSnippet;->clone()Lcom/google/api/services/youtube/model/CommentSnippet;

    move-result-object v0

    return-object v0
.end method

.method public clone()Lcom/google/api/services/youtube/model/CommentSnippet;
    .locals 1

    .prologue
    .line 430
    invoke-super {p0}, Lcom/google/api/client/json/GenericJson;->clone()Lcom/google/api/client/json/GenericJson;

    move-result-object v0

    check-cast v0, Lcom/google/api/services/youtube/model/CommentSnippet;

    return-object v0
.end method

.method public bridge synthetic clone()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 33
    invoke-virtual {p0}, Lcom/google/api/services/youtube/model/CommentSnippet;->clone()Lcom/google/api/services/youtube/model/CommentSnippet;

    move-result-object v0

    return-object v0
.end method

.method public getAuthorChannelId()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->authorChannelId:Ljava/lang/Object;

    return-object v0
.end method

.method public getAuthorChannelUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 172
    iget-object v0, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->authorChannelUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getAuthorDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 189
    iget-object v0, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->authorDisplayName:Ljava/lang/String;

    return-object v0
.end method

.method public getAuthorProfileImageUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 206
    iget-object v0, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->authorProfileImageUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getCanRate()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 223
    iget-object v0, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->canRate:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getChannelId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 241
    iget-object v0, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->channelId:Ljava/lang/String;

    return-object v0
.end method

.method public getLikeCount()Ljava/lang/Long;
    .locals 1

    .prologue
    .line 259
    iget-object v0, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->likeCount:Ljava/lang/Long;

    return-object v0
.end method

.method public getModerationStatus()Ljava/lang/String;
    .locals 1

    .prologue
    .line 277
    iget-object v0, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->moderationStatus:Ljava/lang/String;

    return-object v0
.end method

.method public getParentId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 295
    iget-object v0, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->parentId:Ljava/lang/String;

    return-object v0
.end method

.method public getPublishedAt()Lcom/google/api/client/util/DateTime;
    .locals 1

    .prologue
    .line 313
    iget-object v0, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->publishedAt:Lcom/google/api/client/util/DateTime;

    return-object v0
.end method

.method public getTextDisplay()Ljava/lang/String;
    .locals 1

    .prologue
    .line 333
    iget-object v0, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->textDisplay:Ljava/lang/String;

    return-object v0
.end method

.method public getTextOriginal()Ljava/lang/String;
    .locals 1

    .prologue
    .line 354
    iget-object v0, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->textOriginal:Ljava/lang/String;

    return-object v0
.end method

.method public getUpdatedAt()Lcom/google/api/client/util/DateTime;
    .locals 1

    .prologue
    .line 374
    iget-object v0, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->updatedAt:Lcom/google/api/client/util/DateTime;

    return-object v0
.end method

.method public getVideoId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 392
    iget-object v0, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->videoId:Ljava/lang/String;

    return-object v0
.end method

.method public getViewerRating()Ljava/lang/String;
    .locals 1

    .prologue
    .line 410
    iget-object v0, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->viewerRating:Ljava/lang/String;

    return-object v0
.end method

.method public bridge synthetic set(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/client/json/GenericJson;
    .locals 1

    .prologue
    .line 33
    invoke-virtual {p0, p1, p2}, Lcom/google/api/services/youtube/model/CommentSnippet;->set(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/services/youtube/model/CommentSnippet;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic set(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/client/util/GenericData;
    .locals 1

    .prologue
    .line 33
    invoke-virtual {p0, p1, p2}, Lcom/google/api/services/youtube/model/CommentSnippet;->set(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/services/youtube/model/CommentSnippet;

    move-result-object v0

    return-object v0
.end method

.method public set(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/services/youtube/model/CommentSnippet;
    .locals 1

    .prologue
    .line 425
    invoke-super {p0, p1, p2}, Lcom/google/api/client/json/GenericJson;->set(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/client/json/GenericJson;

    move-result-object v0

    check-cast v0, Lcom/google/api/services/youtube/model/CommentSnippet;

    return-object v0
.end method

.method public setAuthorChannelId(Ljava/lang/Object;)Lcom/google/api/services/youtube/model/CommentSnippet;
    .locals 0

    .prologue
    .line 163
    iput-object p1, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->authorChannelId:Ljava/lang/Object;

    .line 164
    return-object p0
.end method

.method public setAuthorChannelUrl(Ljava/lang/String;)Lcom/google/api/services/youtube/model/CommentSnippet;
    .locals 0

    .prologue
    .line 180
    iput-object p1, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->authorChannelUrl:Ljava/lang/String;

    .line 181
    return-object p0
.end method

.method public setAuthorDisplayName(Ljava/lang/String;)Lcom/google/api/services/youtube/model/CommentSnippet;
    .locals 0

    .prologue
    .line 197
    iput-object p1, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->authorDisplayName:Ljava/lang/String;

    .line 198
    return-object p0
.end method

.method public setAuthorProfileImageUrl(Ljava/lang/String;)Lcom/google/api/services/youtube/model/CommentSnippet;
    .locals 0

    .prologue
    .line 214
    iput-object p1, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->authorProfileImageUrl:Ljava/lang/String;

    .line 215
    return-object p0
.end method

.method public setCanRate(Ljava/lang/Boolean;)Lcom/google/api/services/youtube/model/CommentSnippet;
    .locals 0

    .prologue
    .line 231
    iput-object p1, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->canRate:Ljava/lang/Boolean;

    .line 232
    return-object p0
.end method

.method public setChannelId(Ljava/lang/String;)Lcom/google/api/services/youtube/model/CommentSnippet;
    .locals 0

    .prologue
    .line 250
    iput-object p1, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->channelId:Ljava/lang/String;

    .line 251
    return-object p0
.end method

.method public setLikeCount(Ljava/lang/Long;)Lcom/google/api/services/youtube/model/CommentSnippet;
    .locals 0

    .prologue
    .line 267
    iput-object p1, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->likeCount:Ljava/lang/Long;

    .line 268
    return-object p0
.end method

.method public setModerationStatus(Ljava/lang/String;)Lcom/google/api/services/youtube/model/CommentSnippet;
    .locals 0

    .prologue
    .line 286
    iput-object p1, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->moderationStatus:Ljava/lang/String;

    .line 287
    return-object p0
.end method

.method public setParentId(Ljava/lang/String;)Lcom/google/api/services/youtube/model/CommentSnippet;
    .locals 0

    .prologue
    .line 303
    iput-object p1, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->parentId:Ljava/lang/String;

    .line 304
    return-object p0
.end method

.method public setPublishedAt(Lcom/google/api/client/util/DateTime;)Lcom/google/api/services/youtube/model/CommentSnippet;
    .locals 0

    .prologue
    .line 322
    iput-object p1, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->publishedAt:Lcom/google/api/client/util/DateTime;

    .line 323
    return-object p0
.end method

.method public setTextDisplay(Ljava/lang/String;)Lcom/google/api/services/youtube/model/CommentSnippet;
    .locals 0

    .prologue
    .line 343
    iput-object p1, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->textDisplay:Ljava/lang/String;

    .line 344
    return-object p0
.end method

.method public setTextOriginal(Ljava/lang/String;)Lcom/google/api/services/youtube/model/CommentSnippet;
    .locals 0

    .prologue
    .line 364
    iput-object p1, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->textOriginal:Ljava/lang/String;

    .line 365
    return-object p0
.end method

.method public setUpdatedAt(Lcom/google/api/client/util/DateTime;)Lcom/google/api/services/youtube/model/CommentSnippet;
    .locals 0

    .prologue
    .line 383
    iput-object p1, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->updatedAt:Lcom/google/api/client/util/DateTime;

    .line 384
    return-object p0
.end method

.method public setVideoId(Ljava/lang/String;)Lcom/google/api/services/youtube/model/CommentSnippet;
    .locals 0

    .prologue
    .line 400
    iput-object p1, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->videoId:Ljava/lang/String;

    .line 401
    return-object p0
.end method

.method public setViewerRating(Ljava/lang/String;)Lcom/google/api/services/youtube/model/CommentSnippet;
    .locals 0

    .prologue
    .line 419
    iput-object p1, p0, Lcom/google/api/services/youtube/model/CommentSnippet;->viewerRating:Ljava/lang/String;

    .line 420
    return-object p0
.end method
