.class public Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;
.super Landroid/app/Activity;
.source "SmartStoreInspectorActivity.java"


# instance fields
.field private a:Ljava/lang/String;

.field private b:Z

.field private c:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

.field private d:Landroid/widget/MultiAutoCompleteTextView;

.field private e:Landroid/widget/EditText;

.field private f:Landroid/widget/EditText;

.field private g:Landroid/widget/GridView;

.field private h:Ljava/lang/String;

.field private i:Ljava/lang/String;

.field private j:Lorg/json/JSONArray;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 61
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method private a(Landroid/widget/EditText;I)I
    .locals 2

    .prologue
    .line 254
    invoke-virtual {p1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 255
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_0

    .line 258
    :goto_0
    return p2

    :cond_0
    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result p2

    goto :goto_0
.end method

.method private a(Landroid/widget/GridView;)V
    .locals 4

    .prologue
    .line 307
    const/high16 v0, 0x10a0000

    invoke-static {p0, v0}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    .line 309
    new-instance v1, Landroid/view/animation/GridLayoutAnimationController;

    const/4 v2, 0x0

    const v3, 0x3dcccccd    # 0.1f

    invoke-direct {v1, v0, v2, v3}, Landroid/view/animation/GridLayoutAnimationController;-><init>(Landroid/view/animation/Animation;FF)V

    .line 311
    invoke-virtual {p1, v1}, Landroid/widget/GridView;->setLayoutAnimation(Landroid/view/animation/LayoutAnimationController;)V

    .line 312
    invoke-virtual {v1}, Landroid/view/animation/GridLayoutAnimationController;->start()V

    .line 313
    return-void
.end method

.method private a(Landroid/widget/MultiAutoCompleteTextView;)V
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 321
    new-instance v2, Landroid/widget/ArrayAdapter;

    const v0, 0x109000a

    invoke-direct {v2, p0, v0}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;I)V

    .line 325
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    .line 326
    iget-object v3, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->c:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->d()Ljava/util/List;

    move-result-object v3

    invoke-interface {v0, v3}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 327
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 328
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "{"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "}"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/widget/ArrayAdapter;->add(Ljava/lang/Object;)V

    .line 329
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "{"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ":"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "_soup"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "}"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/widget/ArrayAdapter;->add(Ljava/lang/Object;)V

    .line 330
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "{"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ":"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "_soupEntryId"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "}"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/widget/ArrayAdapter;->add(Ljava/lang/Object;)V

    .line 331
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "{"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, ":"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "_soupLastModifiedDate"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "}"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/widget/ArrayAdapter;->add(Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 337
    :cond_0
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->c:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    const-string v3, "SELECT soupName, path FROM soup_index_map"

    const/16 v4, 0x3e8

    invoke-static {v3, v4}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->a(Ljava/lang/String;I)Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v0, v3, v4}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;I)Lorg/json/JSONArray;

    move-result-object v3

    move v0, v1

    .line 339
    :goto_1
    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v1

    if-ge v0, v1, :cond_1

    .line 340
    invoke-virtual {v3, v0}, Lorg/json/JSONArray;->getJSONArray(I)Lorg/json/JSONArray;

    move-result-object v1

    .line 341
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "{"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v1, v5}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ":"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const/4 v5, 0x1

    invoke-virtual {v1, v5}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "}"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Landroid/widget/ArrayAdapter;->add(Ljava/lang/Object;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 339
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 344
    :catch_0
    move-exception v0

    .line 345
    const-string v1, "SmartStoreInspectorActivity"

    const-string v3, "Error occurred while parsing JSON"

    invoke-static {v1, v3, v0}, Lcom/salesforce/androidsdk/smartstore/util/SmartStoreLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 349
    :cond_1
    const-string v0, "select"

    invoke-virtual {v2, v0}, Landroid/widget/ArrayAdapter;->add(Ljava/lang/Object;)V

    .line 350
    const-string v0, "from"

    invoke-virtual {v2, v0}, Landroid/widget/ArrayAdapter;->add(Ljava/lang/Object;)V

    .line 351
    const-string v0, "where"

    invoke-virtual {v2, v0}, Landroid/widget/ArrayAdapter;->add(Ljava/lang/Object;)V

    .line 352
    const-string v0, "order by"

    invoke-virtual {v2, v0}, Landroid/widget/ArrayAdapter;->add(Ljava/lang/Object;)V

    .line 353
    const-string v0, "asc"

    invoke-virtual {v2, v0}, Landroid/widget/ArrayAdapter;->add(Ljava/lang/Object;)V

    .line 354
    const-string v0, "desc"

    invoke-virtual {v2, v0}, Landroid/widget/ArrayAdapter;->add(Ljava/lang/Object;)V

    .line 355
    const-string v0, "group by"

    invoke-virtual {v2, v0}, Landroid/widget/ArrayAdapter;->add(Ljava/lang/Object;)V

    .line 357
    invoke-virtual {p1, v2}, Landroid/widget/MultiAutoCompleteTextView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 358
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/ui/QueryTokenizer;

    invoke-direct {v0}, Lcom/salesforce/androidsdk/smartstore/ui/QueryTokenizer;-><init>()V

    invoke-virtual {p1, v0}, Landroid/widget/MultiAutoCompleteTextView;->setTokenizer(Landroid/widget/MultiAutoCompleteTextView$Tokenizer;)V

    .line 359
    return-void
.end method

.method private a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 263
    iput-object p1, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->h:Ljava/lang/String;

    .line 264
    iput-object p2, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->i:Ljava/lang/String;

    .line 265
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0, p1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 266
    invoke-virtual {v0, p2}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 267
    return-void
.end method

.method private a(Lorg/json/JSONArray;)V
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 277
    iput-object p1, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->j:Lorg/json/JSONArray;

    .line 278
    new-instance v4, Landroid/widget/ArrayAdapter;

    sget v0, Lcom/salesforce/androidsdk/smartstore/R$layout;->sf__inspector_result_cell:I

    invoke-direct {v4, p0, v0}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;I)V

    .line 281
    invoke-virtual {p1}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-nez v0, :cond_0

    .line 282
    const/4 v0, 0x0

    sget v1, Lcom/salesforce/androidsdk/smartstore/R$string;->sf__inspector_no_rows_returned:I

    invoke-virtual {p0, v1}, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->a(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    move v1, v2

    .line 285
    :goto_0
    invoke-virtual {p1}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-ge v1, v0, :cond_3

    .line 286
    invoke-virtual {p1, v1}, Lorg/json/JSONArray;->getJSONArray(I)Lorg/json/JSONArray;

    move-result-object v5

    move v3, v2

    .line 287
    :goto_1
    invoke-virtual {v5}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-ge v3, v0, :cond_2

    .line 288
    invoke-virtual {v5, v3}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    .line 289
    instance-of v6, v0, Lorg/json/JSONObject;

    if-eqz v6, :cond_1

    check-cast v0, Lorg/json/JSONObject;

    const/4 v6, 0x2

    .line 290
    invoke-virtual {v0, v6}, Lorg/json/JSONObject;->toString(I)Ljava/lang/String;

    move-result-object v0

    .line 289
    :goto_2
    invoke-virtual {v4, v0}, Landroid/widget/ArrayAdapter;->add(Ljava/lang/Object;)V

    .line 287
    add-int/lit8 v0, v3, 0x1

    move v3, v0

    goto :goto_1

    .line 290
    :cond_1
    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_2

    .line 285
    :cond_2
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 294
    :cond_3
    invoke-virtual {p1}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-lez v0, :cond_4

    invoke-virtual {p1, v2}, Lorg/json/JSONArray;->getJSONArray(I)Lorg/json/JSONArray;

    move-result-object v0

    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I

    move-result v2

    .line 296
    :cond_4
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->g:Landroid/widget/GridView;

    invoke-virtual {v0, v2}, Landroid/widget/GridView;->setNumColumns(I)V

    .line 297
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->g:Landroid/widget/GridView;

    invoke-virtual {v0, v4}, Landroid/widget/GridView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 298
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->g:Landroid/widget/GridView;

    invoke-direct {p0, v0}, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->a(Landroid/widget/GridView;)V

    .line 299
    return-void
.end method

.method private b()V
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 128
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    .line 129
    if-nez v1, :cond_0

    :goto_0
    iput-boolean v0, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->b:Z

    .line 130
    if-nez v1, :cond_1

    const-string v0, "smartstore"

    :goto_1
    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->a:Ljava/lang/String;

    .line 131
    return-void

    .line 129
    :cond_0
    const-string v2, "isGlobalStore"

    invoke-virtual {v1, v2, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    goto :goto_0

    .line 130
    :cond_1
    const-string v0, "dbName"

    const-string v2, "smartstore"

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method

.method private c()V
    .locals 4

    .prologue
    .line 230
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->d:Landroid/widget/MultiAutoCompleteTextView;

    invoke-virtual {v0}, Landroid/widget/MultiAutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 231
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_0

    .line 232
    const/4 v0, 0x0

    sget v1, Lcom/salesforce/androidsdk/smartstore/R$string;->sf__inspector_no_query_specified:I

    invoke-virtual {p0, v1}, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 243
    :goto_0
    return-void

    .line 235
    :cond_0
    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->e:Landroid/widget/EditText;

    const/16 v2, 0xa

    invoke-direct {p0, v1, v2}, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->a(Landroid/widget/EditText;I)I

    move-result v1

    .line 236
    iget-object v2, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->f:Landroid/widget/EditText;

    const/4 v3, 0x0

    invoke-direct {p0, v2, v3}, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->a(Landroid/widget/EditText;I)I

    move-result v2

    .line 238
    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->a(Ljava/lang/String;I)Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;

    move-result-object v0

    .line 239
    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->c:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    invoke-virtual {v1, v0, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;I)Lorg/json/JSONArray;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->a(Lorg/json/JSONArray;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 240
    :catch_0
    move-exception v0

    .line 241
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v1, v0}, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->a(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method public a()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 146
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->d:Landroid/widget/MultiAutoCompleteTextView;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/MultiAutoCompleteTextView;->setText(Ljava/lang/CharSequence;)V

    .line 147
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->e:Landroid/widget/EditText;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 148
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->f:Landroid/widget/EditText;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 149
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->g:Landroid/widget/GridView;

    invoke-virtual {v0, v2}, Landroid/widget/GridView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 150
    iput-object v2, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->h:Ljava/lang/String;

    .line 151
    iput-object v2, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->i:Ljava/lang/String;

    .line 152
    iput-object v2, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->j:Lorg/json/JSONArray;

    .line 153
    return-void
.end method

.method public onClearClick(Landroid/view/View;)V
    .locals 0

    .prologue
    .line 139
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->a()V

    .line 140
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    const-string v0, "com.salesforce.androidsdk.smartstore.ui.SmartStoreInspectorActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnCreateTime(Ljava/lang/String;)V

    .line 108
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 109
    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->b()V

    .line 110
    sget v0, Lcom/salesforce/androidsdk/smartstore/R$layout;->sf__inspector:I

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->setContentView(I)V

    .line 111
    sget v0, Lcom/salesforce/androidsdk/smartstore/R$id;->sf__inspector_query_text:I

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/MultiAutoCompleteTextView;

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->d:Landroid/widget/MultiAutoCompleteTextView;

    .line 112
    sget v0, Lcom/salesforce/androidsdk/smartstore/R$id;->sf__inspector_pagesize_text:I

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->e:Landroid/widget/EditText;

    .line 113
    sget v0, Lcom/salesforce/androidsdk/smartstore/R$id;->sf__inspector_pageindex_text:I

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->f:Landroid/widget/EditText;

    .line 114
    sget v0, Lcom/salesforce/androidsdk/smartstore/R$id;->sf__inspector_result_grid:I

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/GridView;

    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->g:Landroid/widget/GridView;

    .line 115
    return-void
.end method

.method public onIndicesClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 219
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->d:Landroid/widget/MultiAutoCompleteTextView;

    sget v1, Lcom/salesforce/androidsdk/smartstore/R$string;->sf__inspector_indices_query:I

    .line 220
    invoke-virtual {p0, v1}, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/MultiAutoCompleteTextView;->setText(Ljava/lang/CharSequence;)V

    .line 221
    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->c()V

    .line 222
    return-void
.end method

.method protected onResume()V
    .locals 4

    .prologue
    const-string v0, "com.salesforce.androidsdk.smartstore.ui.SmartStoreInspectorActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnResumeTime(Ljava/lang/String;)V

    .line 119
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 120
    invoke-static {}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->H()Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;

    move-result-object v0

    .line 121
    iget-boolean v1, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->b:Z

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->a:Ljava/lang/String;

    .line 122
    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->g(Ljava/lang/String;)Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    move-result-object v0

    .line 123
    :goto_0
    iput-object v0, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->c:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    .line 124
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->d:Landroid/widget/MultiAutoCompleteTextView;

    invoke-direct {p0, v0}, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->a(Landroid/widget/MultiAutoCompleteTextView;)V

    .line 125
    return-void

    .line 122
    :cond_0
    iget-object v1, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->a:Ljava/lang/String;

    .line 123
    invoke-virtual {v0}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->o()Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->b()Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->a(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    move-result-object v0

    goto :goto_0
.end method

.method public onRunClick(Landroid/view/View;)V
    .locals 0

    .prologue
    .line 182
    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->c()V

    .line 183
    return-void
.end method

.method public onSoupsClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 191
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->c:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->d()Ljava/util/List;

    move-result-object v1

    .line 193
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v0

    const/16 v2, 0xa

    if-le v0, v2, :cond_0

    .line 194
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->d:Landroid/widget/MultiAutoCompleteTextView;

    sget v1, Lcom/salesforce/androidsdk/smartstore/R$string;->sf__inspector_soups_query:I

    invoke-virtual {p0, v1}, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/MultiAutoCompleteTextView;->setText(Ljava/lang/CharSequence;)V

    .line 210
    :goto_0
    invoke-direct {p0}, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->c()V

    .line 211
    return-void

    .line 196
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 197
    const/4 v0, 0x1

    .line 198
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    move v1, v0

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 199
    if-nez v1, :cond_1

    .line 200
    const-string v1, " union "

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 201
    :cond_1
    const-string v1, "select \'"

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 202
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 203
    const-string v1, "\', count(*) from {"

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 204
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 205
    const-string v0, "}"

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 206
    const/4 v0, 0x0

    move v1, v0

    .line 207
    goto :goto_1

    .line 208
    :cond_2
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/ui/SmartStoreInspectorActivity;->d:Landroid/widget/MultiAutoCompleteTextView;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/MultiAutoCompleteTextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.method protected onStart()V
    .locals 1

    const-string v0, "com.salesforce.androidsdk.smartstore.ui.SmartStoreInspectorActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnStartTime(Ljava/lang/String;)V

    invoke-super {p0}, Landroid/app/Activity;->onStart()V

    return-void
.end method
