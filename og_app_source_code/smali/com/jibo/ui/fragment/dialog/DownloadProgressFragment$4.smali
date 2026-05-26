.class Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$4;
.super Ljava/lang/Object;
.source "DownloadProgressFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->onResume()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;)V
    .locals 0

    .prologue
    .line 116
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private a(ZLcom/jibo/aws/integration/aws/services/media/model/Media;)V
    .locals 7

    .prologue
    .line 156
    :try_start_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->c(Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 201
    :goto_0
    return-void

    .line 157
    :cond_0
    invoke-static {p1, p2}, Lcom/jibo/aws/integration/helpers/MediaHelper;->getUrl(ZLcom/jibo/aws/integration/aws/services/media/model/Media;)Ljava/lang/String;

    move-result-object v1

    .line 158
    new-instance v2, Ljava/io/File;

    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getExternalCacheDir()Ljava/io/File;

    move-result-object v0

    invoke-static {v1}, Lcom/jibo/utils/OriginalKey;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v0, v3}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 159
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-virtual {v3}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentActivity;->getExternalCacheDir()Ljava/io/File;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "/"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "share"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p2}, Lcom/jibo/aws/integration/helpers/MediaHelper;->getShareableFile(Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/media/model/Media;)Ljava/io/File;

    move-result-object v3

    .line 163
    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_3

    .line 164
    new-instance v0, Ljava/net/URL;

    invoke-direct {v0, v1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 165
    invoke-virtual {v0}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    invoke-static {v0}, Lcom/google/firebase/perf/network/FirebasePerfUrlConnection;->instrument(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/net/URLConnection;

    check-cast v0, Ljava/net/HttpURLConnection;

    .line 166
    const/16 v4, 0x2710

    invoke-virtual {v0, v4}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 167
    const/16 v4, 0x1388

    invoke-virtual {v0, v4}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 168
    const-string v4, "GET"

    invoke-virtual {v0, v4}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 169
    const/4 v4, 0x1

    invoke-virtual {v0, v4}, Ljava/net/HttpURLConnection;->setDoInput(Z)V

    .line 170
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->connect()V

    .line 171
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v4

    .line 173
    iget-object v5, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-static {v5}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->c(Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;)Z

    move-result v5

    if-eqz v5, :cond_1

    const/16 v5, 0xc8

    if-eq v4, v5, :cond_2

    .line 174
    :cond_1
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    goto :goto_0

    .line 198
    :catch_0
    move-exception v0

    goto/16 :goto_0

    .line 177
    :cond_2
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v4

    .line 180
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    .line 181
    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/JiboGlideModule;->a(Landroid/content/Context;)Lcom/jibo/utils/cache/ExternalCacheDiskCacheFactory;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/utils/cache/ExternalCacheDiskCacheFactory;->build()Lcom/bumptech/glide/load/engine/cache/DiskCache;

    move-result-object v0

    check-cast v0, Lcom/jibo/utils/cache/DiskLruCacheWrapper;

    .line 185
    new-instance v5, Lcom/jibo/utils/OriginalKey;

    invoke-static {}, Lcom/bumptech/glide/signature/EmptySignature;->a()Lcom/bumptech/glide/signature/EmptySignature;

    move-result-object v6

    invoke-direct {v5, v1, v6}, Lcom/jibo/utils/OriginalKey;-><init>(Ljava/lang/String;Lcom/bumptech/glide/load/Key;)V

    invoke-virtual {v0, v5, v4}, Lcom/jibo/utils/cache/DiskLruCacheWrapper;->a(Lcom/jibo/utils/OriginalKey;Ljava/io/InputStream;)V

    .line 188
    :cond_3
    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->c(Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 190
    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_4

    .line 191
    invoke-static {v2, v3}, Lcom/jibo/utils/ImageUtils;->a(Ljava/io/File;Ljava/io/File;)V

    .line 194
    :cond_4
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->a(Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v3}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 197
    :cond_5
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->g(Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    const/4 v6, 0x0

    .line 122
    :try_start_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/JiboGlideModule;->b(Landroid/content/Context;)V

    .line 124
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 125
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 124
    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->g(Landroid/content/Context;)Z

    move-result v7

    .line 128
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->b(Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;)Ljava/lang/Thread;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Thread;->isInterrupted()Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->c(Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;)Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->d(Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;)I

    move-result v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->e(Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    if-ge v0, v1, :cond_2

    .line 130
    :try_start_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    .line 131
    invoke-static {v1}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->e(Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;)Ljava/util/ArrayList;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-static {v2}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->d(Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;)I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-static {v1}, Lcom/jibo/db/DatabaseContract$MediaEntry;->a(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    sget-object v2, Lcom/jibo/db/DatabaseContract$MediaEntry;->a:[Ljava/lang/String;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    .line 130
    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v0

    .line 134
    if-eqz v0, :cond_0

    :try_start_2
    invoke-interface {v0}, Landroid/database/Cursor;->isClosed()Z

    move-result v1

    if-nez v1, :cond_0

    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 136
    invoke-static {v0}, Lcom/jibo/db/EntityData;->c(Landroid/database/Cursor;)Lcom/jibo/aws/integration/aws/services/media/model/Media;

    move-result-object v1

    invoke-direct {p0, v7, v1}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$4;->a(ZLcom/jibo/aws/integration/aws/services/media/model/Media;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 141
    :cond_0
    if-eqz v0, :cond_3

    :try_start_3
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    move-object v6, v0

    .line 143
    :goto_1
    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    .line 144
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->d(Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;)I

    move-result v1

    iput v1, v0, Landroid/os/Message;->what:I

    .line 145
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->f(Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;)Landroid/os/Handler;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_0

    .line 150
    :catch_0
    move-exception v0

    .line 152
    :goto_2
    return-void

    .line 138
    :catch_1
    move-exception v1

    .line 141
    :goto_3
    if-eqz v0, :cond_3

    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    move-object v6, v0

    goto :goto_1

    :catchall_0
    move-exception v1

    move-object v6, v0

    move-object v0, v1

    :goto_4
    if-eqz v6, :cond_1

    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    :cond_1
    throw v0

    .line 147
    :cond_2
    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    .line 148
    const/4 v1, -0x1

    iput v1, v0, Landroid/os/Message;->what:I

    .line 149
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->f(Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;)Landroid/os/Handler;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0

    goto :goto_2

    .line 141
    :catchall_1
    move-exception v0

    goto :goto_4

    .line 138
    :catch_2
    move-exception v0

    move-object v0, v6

    goto :goto_3

    :cond_3
    move-object v6, v0

    goto :goto_1
.end method
