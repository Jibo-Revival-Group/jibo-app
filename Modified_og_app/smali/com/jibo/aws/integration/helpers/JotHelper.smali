.class public Lcom/jibo/aws/integration/helpers/JotHelper;
.super Ljava/lang/Object;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static a(Lcom/jibo/aws/integration/aws/services/jot/model/Message;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;
    .locals 5

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getParts()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getParts()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    :cond_0
    move-object v0, v1

    :cond_1
    :goto_0
    return-object v0

    :cond_2
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getParts()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    const/4 v0, 0x0

    move v2, v0

    :goto_1
    if-ge v2, v3, :cond_4

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getParts()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;->getType()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_3

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;->getType()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_1

    :cond_3
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_1

    :cond_4
    move-object v0, v1

    goto :goto_0
.end method

.method public static getAudio(Lcom/jibo/aws/integration/aws/services/jot/model/Message;)Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;
    .locals 1

    const-string v0, "audio"

    invoke-static {p0, v0}, Lcom/jibo/aws/integration/helpers/JotHelper;->a(Lcom/jibo/aws/integration/aws/services/jot/model/Message;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;

    move-result-object v0

    return-object v0
.end method

.method public static getPhoto(Lcom/jibo/aws/integration/aws/services/jot/model/Message;)Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;
    .locals 1

    const-string v0, "image"

    invoke-static {p0, v0}, Lcom/jibo/aws/integration/helpers/JotHelper;->a(Lcom/jibo/aws/integration/aws/services/jot/model/Message;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;

    move-result-object v0

    return-object v0
.end method

.method public static getRobotThumbnail(Lcom/jibo/aws/integration/aws/services/jot/model/Message;)Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;
    .locals 1

    const-string v0, "thumb_robot"

    invoke-static {p0, v0}, Lcom/jibo/aws/integration/helpers/JotHelper;->a(Lcom/jibo/aws/integration/aws/services/jot/model/Message;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;

    move-result-object v0

    return-object v0
.end method

.method public static getThumbnail(Lcom/jibo/aws/integration/aws/services/jot/model/Message;)Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;
    .locals 1

    const-string v0, "thumb"

    invoke-static {p0, v0}, Lcom/jibo/aws/integration/helpers/JotHelper;->a(Lcom/jibo/aws/integration/aws/services/jot/model/Message;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;

    move-result-object v0

    return-object v0
.end method

.method public static getVideo(Lcom/jibo/aws/integration/aws/services/jot/model/Message;)Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;
    .locals 1

    const-string v0, "recording"

    invoke-static {p0, v0}, Lcom/jibo/aws/integration/helpers/JotHelper;->a(Lcom/jibo/aws/integration/aws/services/jot/model/Message;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;

    move-result-object v0

    return-object v0
.end method

.method public static hasAudio(Lcom/jibo/aws/integration/aws/services/jot/model/Message;)Z
    .locals 1

    const-string v0, "audio"

    invoke-static {p0, v0}, Lcom/jibo/aws/integration/helpers/JotHelper;->hasMedia(Lcom/jibo/aws/integration/aws/services/jot/model/Message;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static hasDeletedMedia(Lcom/jibo/aws/integration/aws/services/jot/model/Message;)Z
    .locals 5

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getParts()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getParts()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    move v0, v1

    :goto_0
    return v0

    :cond_1
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getParts()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    move v2, v1

    :goto_1
    if-ge v2, v3, :cond_4

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getParts()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;->getType()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_2

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    :cond_2
    const/4 v0, 0x1

    goto :goto_0

    :cond_3
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_1

    :cond_4
    move v0, v1

    goto :goto_0
.end method

.method public static hasMedia(Lcom/jibo/aws/integration/aws/services/jot/model/Message;Ljava/lang/String;)Z
    .locals 5

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getParts()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getParts()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    move v0, v1

    :goto_0
    return v0

    :cond_1
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getParts()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    move v2, v1

    :goto_1
    if-ge v2, v3, :cond_3

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getParts()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;->getType()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_2

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;->getType()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    const/4 v0, 0x1

    goto :goto_0

    :cond_2
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_1

    :cond_3
    move v0, v1

    goto :goto_0
.end method

.method public static hasPhoto(Lcom/jibo/aws/integration/aws/services/jot/model/Message;)Z
    .locals 1

    const-string v0, "image"

    invoke-static {p0, v0}, Lcom/jibo/aws/integration/helpers/JotHelper;->hasMedia(Lcom/jibo/aws/integration/aws/services/jot/model/Message;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static hasPhotoOrVideo(Lcom/jibo/aws/integration/aws/services/jot/model/Message;)Z
    .locals 2

    const/4 v0, 0x1

    const-string v1, "image"

    invoke-static {p0, v1}, Lcom/jibo/aws/integration/helpers/JotHelper;->hasMedia(Lcom/jibo/aws/integration/aws/services/jot/model/Message;Ljava/lang/String;)Z

    move-result v1

    if-ne v1, v0, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    const-string v1, "recording"

    invoke-static {p0, v1}, Lcom/jibo/aws/integration/helpers/JotHelper;->hasMedia(Lcom/jibo/aws/integration/aws/services/jot/model/Message;Ljava/lang/String;)Z

    move-result v1

    if-eq v1, v0, :cond_0

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static hasVideo(Lcom/jibo/aws/integration/aws/services/jot/model/Message;)Z
    .locals 1

    const-string v0, "recording"

    invoke-static {p0, v0}, Lcom/jibo/aws/integration/helpers/JotHelper;->hasMedia(Lcom/jibo/aws/integration/aws/services/jot/model/Message;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method
