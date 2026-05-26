.class public Lcom/jibo/aws/integration/helpers/MediaHelper;
.super Ljava/lang/Object;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getShareableFile(Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/media/model/Media;)Ljava/io/File;
    .locals 3

    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "share_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->hashCode()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Math;->abs(I)I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->getCreated()Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ".jpg"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public static getUrl(ZLcom/jibo/aws/integration/aws/services/jot/model/Message;Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;)Ljava/lang/String;
    .locals 3

    invoke-static {p0, p1}, Lcom/jibo/aws/integration/helpers/MediaHelper;->isMessageEncrypted(ZLcom/jibo/aws/integration/aws/services/jot/model/Message;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v1, "loopId"

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getLoopId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;->getUrl()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getUrl(ZLcom/jibo/aws/integration/aws/services/media/model/Media;)Ljava/lang/String;
    .locals 3

    invoke-static {p0, p1}, Lcom/jibo/aws/integration/helpers/MediaHelper;->isMediaEncrypted(ZLcom/jibo/aws/integration/aws/services/media/model/Media;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v1, "loopId"

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->getLoopId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->getUrl()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static isMediaEncrypted(ZLcom/jibo/aws/integration/aws/services/media/model/Media;)Z
    .locals 1

    if-eqz p0, :cond_0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->isEncrypted()Ljava/lang/Boolean;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->isEncrypted()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isMessageEncrypted(ZLcom/jibo/aws/integration/aws/services/jot/model/Message;)Z
    .locals 1

    if-eqz p0, :cond_0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->isEncrypted()Ljava/lang/Boolean;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->isEncrypted()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
