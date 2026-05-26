.class public Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;
.super Ljava/lang/Object;
.source "CaseFeedViewModel.java"


# instance fields
.field a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private final b:Landroid/content/Context;

.field private final c:Lcom/salesforce/android/cases/core/model/CaseDetailRecord;

.field private final d:Lcom/salesforce/android/cases/core/model/CaseLayoutData;

.field private final e:Lcom/salesforce/android/cases/core/model/CaseFeed;

.field private final f:Ljava/lang/String;

.field private final g:Ljava/text/DateFormat;

.field private final h:Ljava/util/Date;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/salesforce/android/cases/core/model/CaseDetailRecord;Lcom/salesforce/android/cases/core/model/CaseLayoutData;Lcom/salesforce/android/cases/core/model/CaseFeed;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 68
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 70
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->b:Landroid/content/Context;

    .line 71
    iput-object p2, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->c:Lcom/salesforce/android/cases/core/model/CaseDetailRecord;

    .line 72
    iput-object p3, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->d:Lcom/salesforce/android/cases/core/model/CaseLayoutData;

    .line 73
    iput-object p4, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->e:Lcom/salesforce/android/cases/core/model/CaseFeed;

    .line 74
    iput-object p5, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->f:Ljava/lang/String;

    .line 75
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->u()Ljava/util/Date;

    move-result-object v0

    .line 76
    invoke-interface {p4}, Lcom/salesforce/android/cases/core/model/CaseFeed;->a()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    move-object v1, v0

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/model/Element;

    .line 77
    if-eqz v1, :cond_0

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/Element;->c()Ljava/util/Date;

    move-result-object v3

    if-eqz v3, :cond_4

    .line 78
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/Element;->c()Ljava/util/Date;

    move-result-object v3

    .line 77
    invoke-virtual {v1, v3}, Ljava/util/Date;->before(Ljava/util/Date;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 79
    :cond_0
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/Element;->c()Ljava/util/Date;

    move-result-object v1

    move-object v0, v1

    :goto_1
    move-object v1, v0

    .line 81
    goto :goto_0

    .line 83
    :cond_1
    if-nez v1, :cond_2

    .line 85
    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    .line 87
    :cond_2
    iput-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->h:Ljava/util/Date;

    .line 88
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "MMM d, yyyy"

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->g:Ljava/text/DateFormat;

    .line 90
    if-eqz p2, :cond_3

    if-eqz p4, :cond_3

    invoke-interface {p4}, Lcom/salesforce/android/cases/core/model/CaseFeed;->a()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_3

    .line 91
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->e()V

    .line 93
    :cond_3
    return-void

    :cond_4
    move-object v0, v1

    goto :goto_1
.end method

.method private a(Lcom/salesforce/android/cases/core/model/CaseDetailRecord;)Ljava/lang/String;
    .locals 6

    .prologue
    .line 241
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 243
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->d:Lcom/salesforce/android/cases/core/model/CaseLayoutData;

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseLayoutData;->a()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/model/CaseField;

    .line 244
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseField;->i()Z

    move-result v3

    if-nez v3, :cond_0

    .line 248
    invoke-direct {p0, v0, p1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->a(Lcom/salesforce/android/cases/core/model/CaseField;Lcom/salesforce/android/cases/core/model/CaseDetailRecord;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/salesforce/android/cases/core/internal/util/StringUtils;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 250
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 251
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->length()I

    move-result v4

    if-lez v4, :cond_1

    .line 252
    const-string v4, "\n"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\n"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 254
    :cond_1
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseField;->b()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 255
    const-string v0, "\n"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 256
    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 260
    :cond_2
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private a(Lcom/salesforce/android/cases/core/model/CaseField;Lcom/salesforce/android/cases/core/model/CaseDetailRecord;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 275
    invoke-interface {p1}, Lcom/salesforce/android/cases/core/model/CaseField;->a()Ljava/lang/String;

    move-result-object v1

    const/4 v0, -0x1

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v2

    sparse-switch v2, :sswitch_data_0

    :cond_0
    :goto_0
    packed-switch v0, :pswitch_data_0

    .line 331
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->B()Ljava/util/Map;

    move-result-object v0

    invoke-interface {p1}, Lcom/salesforce/android/cases/core/model/CaseField;->a()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 332
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->B()Ljava/util/Map;

    move-result-object v0

    invoke-interface {p1}, Lcom/salesforce/android/cases/core/model/CaseField;->a()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 334
    :goto_1
    return-object v0

    .line 275
    :sswitch_0
    const-string v2, "Subject"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x0

    goto :goto_0

    :sswitch_1
    const-string v2, "Description"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :sswitch_2
    const-string v2, "Id"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x2

    goto :goto_0

    :sswitch_3
    const-string v2, "Status"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x3

    goto :goto_0

    :sswitch_4
    const-string v2, "RecordTypeId"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x4

    goto :goto_0

    :sswitch_5
    const-string v2, "CreatedDate"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x5

    goto :goto_0

    :sswitch_6
    const-string v2, "LastModifiedDate"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x6

    goto :goto_0

    :sswitch_7
    const-string v2, "CaseNumber"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x7

    goto :goto_0

    :sswitch_8
    const-string v2, "ContactId"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/16 v0, 0x8

    goto :goto_0

    :sswitch_9
    const-string v2, "AssetId"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/16 v0, 0x9

    goto/16 :goto_0

    :sswitch_a
    const-string v2, "FeedItemId"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/16 v0, 0xa

    goto/16 :goto_0

    :sswitch_b
    const-string v2, "SourceId"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/16 v0, 0xb

    goto/16 :goto_0

    :sswitch_c
    const-string v2, "CommunityId"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/16 v0, 0xc

    goto/16 :goto_0

    :sswitch_d
    const-string v2, "SuppliedName"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/16 v0, 0xd

    goto/16 :goto_0

    :sswitch_e
    const-string v2, "SuppliedEmail"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/16 v0, 0xe

    goto/16 :goto_0

    :sswitch_f
    const-string v2, "Type"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/16 v0, 0xf

    goto/16 :goto_0

    :sswitch_10
    const-string v2, "Reason"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/16 v0, 0x10

    goto/16 :goto_0

    :sswitch_11
    const-string v2, "Priority"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/16 v0, 0x11

    goto/16 :goto_0

    :sswitch_12
    const-string v2, "ClosedDate"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/16 v0, 0x12

    goto/16 :goto_0

    :sswitch_13
    const-string v2, "OwnerId"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/16 v0, 0x13

    goto/16 :goto_0

    :sswitch_14
    const-string v2, "CreatedById"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/16 v0, 0x14

    goto/16 :goto_0

    :sswitch_15
    const-string v2, "LastModifiedById"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/16 v0, 0x15

    goto/16 :goto_0

    :sswitch_16
    const-string v2, "LastViewedDate"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/16 v0, 0x16

    goto/16 :goto_0

    :sswitch_17
    const-string v2, "LastReferencedDate"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/16 v0, 0x17

    goto/16 :goto_0

    :sswitch_18
    const-string v2, "CreatorFullPhotoUrl"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/16 v0, 0x18

    goto/16 :goto_0

    :sswitch_19
    const-string v2, "CreatorSmallPhotoUrl"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/16 v0, 0x19

    goto/16 :goto_0

    :sswitch_1a
    const-string v2, "CreatorName"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/16 v0, 0x1a

    goto/16 :goto_0

    .line 277
    :pswitch_0
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->n()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 279
    :pswitch_1
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->p()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 281
    :pswitch_2
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->a()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 283
    :pswitch_3
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->l()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 285
    :pswitch_4
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->k()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 287
    :pswitch_5
    sget-object v0, Lcom/salesforce/android/cases/core/internal/util/DateUtils;->a:Ljava/text/DateFormat;

    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->s()Ljava/util/Date;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 289
    :pswitch_6
    sget-object v0, Lcom/salesforce/android/cases/core/internal/util/DateUtils;->a:Ljava/text/DateFormat;

    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->u()Ljava/util/Date;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 291
    :pswitch_7
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->b()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 293
    :pswitch_8
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->c()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 295
    :pswitch_9
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->d()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 297
    :pswitch_a
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->e()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 299
    :pswitch_b
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->f()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 301
    :pswitch_c
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->g()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 303
    :pswitch_d
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->h()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 305
    :pswitch_e
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->i()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 307
    :pswitch_f
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->j()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 309
    :pswitch_10
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->m()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 311
    :pswitch_11
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->o()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 313
    :pswitch_12
    sget-object v0, Lcom/salesforce/android/cases/core/internal/util/DateUtils;->a:Ljava/text/DateFormat;

    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->q()Ljava/util/Date;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 315
    :pswitch_13
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->r()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 317
    :pswitch_14
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->t()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 319
    :pswitch_15
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->v()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 321
    :pswitch_16
    sget-object v0, Lcom/salesforce/android/cases/core/internal/util/DateUtils;->a:Ljava/text/DateFormat;

    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->w()Ljava/util/Date;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 323
    :pswitch_17
    sget-object v0, Lcom/salesforce/android/cases/core/internal/util/DateUtils;->a:Ljava/text/DateFormat;

    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->x()Ljava/util/Date;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 325
    :pswitch_18
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->y()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 327
    :pswitch_19
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->z()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 329
    :pswitch_1a
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->A()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 334
    :cond_1
    invoke-interface {p1}, Lcom/salesforce/android/cases/core/model/CaseField;->h()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 275
    nop

    :sswitch_data_0
    .sparse-switch
        -0x7f62d277 -> :sswitch_d
        -0x6e55819c -> :sswitch_10
        -0x6d7107a2 -> :sswitch_e
        -0x6bcd43ee -> :sswitch_3
        -0x419d223c -> :sswitch_11
        -0xc1d12f4 -> :sswitch_0
        -0x3de74a6 -> :sswitch_12
        -0x360d424 -> :sswitch_1
        -0x5eb448 -> :sswitch_18
        0x93b -> :sswitch_2
        0x28035a -> :sswitch_f
        0x245ab30e -> :sswitch_13
        0x2ea28ac4 -> :sswitch_c
        0x31e0fab9 -> :sswitch_7
        0x3936900b -> :sswitch_9
        0x462e42ba -> :sswitch_14
        0x462ed696 -> :sswitch_5
        0x4ad7061d -> :sswitch_17
        0x580920b7 -> :sswitch_1a
        0x5ef0c53b -> :sswitch_8
        0x6bf13ab6 -> :sswitch_b
        0x6dac9758 -> :sswitch_19
        0x71ec4011 -> :sswitch_15
        0x71ecd3ed -> :sswitch_6
        0x73fe8aec -> :sswitch_a
        0x799e1dc6 -> :sswitch_4
        0x7f806b28 -> :sswitch_16
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
        :pswitch_b
        :pswitch_c
        :pswitch_d
        :pswitch_e
        :pswitch_f
        :pswitch_10
        :pswitch_11
        :pswitch_12
        :pswitch_13
        :pswitch_14
        :pswitch_15
        :pswitch_16
        :pswitch_17
        :pswitch_18
        :pswitch_19
        :pswitch_1a
    .end packed-switch
.end method

.method private a(Ljava/util/Date;Ljava/util/Date;)Z
    .locals 6

    .prologue
    const/4 v5, 0x6

    const/4 v0, 0x1

    .line 264
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v1

    .line 265
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v2

    .line 267
    invoke-virtual {v1, p1}, Ljava/util/Calendar;->setTime(Ljava/util/Date;)V

    .line 268
    invoke-virtual {v2, p2}, Ljava/util/Calendar;->setTime(Ljava/util/Date;)V

    .line 270
    invoke-virtual {v1, v0}, Ljava/util/Calendar;->get(I)I

    move-result v3

    invoke-virtual {v2, v0}, Ljava/util/Calendar;->get(I)I

    move-result v4

    if-ne v3, v4, :cond_0

    .line 271
    invoke-virtual {v1, v5}, Ljava/util/Calendar;->get(I)I

    move-result v1

    invoke-virtual {v2, v5}, Ljava/util/Calendar;->get(I)I

    move-result v2

    if-ne v1, v2, :cond_0

    .line 270
    :goto_0
    return v0

    .line 271
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private e()V
    .locals 11

    .prologue
    .line 167
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->a:Ljava/util/List;

    .line 169
    new-instance v4, Ljava/util/Date;

    invoke-direct {v4}, Ljava/util/Date;-><init>()V

    .line 171
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->c:Lcom/salesforce/android/cases/core/model/CaseDetailRecord;

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->s()Ljava/util/Date;

    move-result-object v0

    .line 173
    if-nez v0, :cond_c

    .line 175
    new-instance v0, Ljava/util/Date;

    const-wide/16 v2, 0x0

    invoke-direct {v0, v2, v3}, Ljava/util/Date;-><init>(J)V

    move-object v1, v0

    .line 179
    :goto_0
    invoke-direct {p0, v4, v1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->a(Ljava/util/Date;Ljava/util/Date;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 180
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->a:Ljava/util/List;

    new-instance v2, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/HorizontalRuleModel;

    iget-object v3, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->b:Landroid/content/Context;

    sget v5, Lcom/salesforce/android/cases/R$string;->cases_horizontal_rule_today_text:I

    .line 181
    invoke-virtual {v3, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/HorizontalRuleModel;-><init>(Ljava/lang/String;)V

    .line 180
    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 190
    :goto_1
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->c:Lcom/salesforce/android/cases/core/model/CaseDetailRecord;

    invoke-direct {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->a(Lcom/salesforce/android/cases/core/model/CaseDetailRecord;)Ljava/lang/String;

    move-result-object v0

    .line 193
    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->a:Ljava/util/List;

    new-instance v3, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/SentMessageModel;

    invoke-direct {v3, v0, v1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/SentMessageModel;-><init>(Ljava/lang/String;Ljava/util/Date;)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 196
    new-instance v2, Ljava/util/ArrayList;

    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->e:Lcom/salesforce/android/cases/core/model/CaseFeed;

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseFeed;->a()Ljava/util/List;

    move-result-object v0

    invoke-direct {v2, v0}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 197
    invoke-static {v2}, Ljava/util/Collections;->reverse(Ljava/util/List;)V

    .line 200
    new-instance v5, Ljava/util/HashSet;

    invoke-direct {v5}, Ljava/util/HashSet;-><init>()V

    .line 201
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    .line 202
    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->o()Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    move-result-object v0

    .line 203
    invoke-virtual {v0}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->d()Ljava/util/List;

    move-result-object v0

    .line 201
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/accounts/UserAccount;

    .line 204
    invoke-virtual {v0}, Lcom/salesforce/androidsdk/accounts/UserAccount;->g()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v5, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 183
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->a:Ljava/util/List;

    new-instance v2, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/HorizontalRuleModel;

    iget-object v3, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->g:Ljava/text/DateFormat;

    invoke-virtual {v3, v1}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/HorizontalRuleModel;-><init>(Ljava/lang/String;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 207
    :cond_1
    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v6

    move-object v2, v1

    :goto_3
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_a

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/model/Element;

    .line 208
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/Element;->d()Lcom/salesforce/android/cases/core/model/Body;

    move-result-object v7

    .line 209
    if-eqz v7, :cond_b

    invoke-interface {v7}, Lcom/salesforce/android/cases/core/model/Body;->a()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_b

    .line 211
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/Element;->c()Ljava/util/Date;

    move-result-object v3

    .line 212
    if-nez v3, :cond_2

    move-object v3, v1

    .line 216
    :cond_2
    if-nez v2, :cond_5

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/Element;->c()Ljava/util/Date;

    move-result-object v8

    invoke-direct {p0, v4, v8}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->a(Ljava/util/Date;Ljava/util/Date;)Z

    move-result v8

    if-eqz v8, :cond_5

    .line 217
    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->a:Ljava/util/List;

    new-instance v8, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/HorizontalRuleModel;

    iget-object v9, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->b:Landroid/content/Context;

    sget v10, Lcom/salesforce/android/cases/R$string;->cases_horizontal_rule_today_text:I

    .line 218
    invoke-virtual {v9, v10}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/HorizontalRuleModel;-><init>(Ljava/lang/String;)V

    .line 217
    invoke-interface {v2, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 223
    :cond_3
    :goto_4
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/Element;->e()Lcom/salesforce/android/cases/core/model/Actor;

    move-result-object v2

    if-eqz v2, :cond_7

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/Element;->e()Lcom/salesforce/android/cases/core/model/Actor;

    move-result-object v2

    invoke-interface {v2}, Lcom/salesforce/android/cases/core/model/Actor;->b()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v5, v2}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 224
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->a:Ljava/util/List;

    new-instance v2, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/SentMessageModel;

    invoke-interface {v7}, Lcom/salesforce/android/cases/core/model/Body;->a()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lcom/salesforce/android/cases/core/internal/util/StringUtils;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v2, v7, v3}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/SentMessageModel;-><init>(Ljava/lang/String;Ljava/util/Date;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_4
    :goto_5
    move-object v0, v3

    :goto_6
    move-object v2, v0

    .line 237
    goto :goto_3

    .line 219
    :cond_5
    if-eqz v2, :cond_6

    invoke-direct {p0, v2, v3}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->a(Ljava/util/Date;Ljava/util/Date;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 220
    :cond_6
    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->a:Ljava/util/List;

    new-instance v8, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/HorizontalRuleModel;

    iget-object v9, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->g:Ljava/text/DateFormat;

    invoke-virtual {v9, v3}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/HorizontalRuleModel;-><init>(Ljava/lang/String;)V

    invoke-interface {v2, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_4

    .line 225
    :cond_7
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/Element;->e()Lcom/salesforce/android/cases/core/model/Actor;

    move-result-object v2

    if-eqz v2, :cond_4

    .line 226
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/Element;->e()Lcom/salesforce/android/cases/core/model/Actor;

    move-result-object v2

    invoke-interface {v2}, Lcom/salesforce/android/cases/core/model/Actor;->a()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_8

    const-string v2, ""

    .line 228
    :goto_7
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/Element;->e()Lcom/salesforce/android/cases/core/model/Actor;

    move-result-object v8

    invoke-interface {v8}, Lcom/salesforce/android/cases/core/model/Actor;->b()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_9

    const-string v0, ""

    .line 230
    :goto_8
    iget-object v8, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->a:Ljava/util/List;

    new-instance v9, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/ReceivedMessageModel;

    .line 231
    invoke-interface {v7}, Lcom/salesforce/android/cases/core/model/Body;->a()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lcom/salesforce/android/cases/core/internal/util/StringUtils;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v9, v7, v2, v0, v3}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/ReceivedMessageModel;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V

    .line 230
    invoke-interface {v8, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_5

    .line 227
    :cond_8
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/Element;->e()Lcom/salesforce/android/cases/core/model/Actor;

    move-result-object v2

    invoke-interface {v2}, Lcom/salesforce/android/cases/core/model/Actor;->a()Ljava/lang/String;

    move-result-object v2

    goto :goto_7

    .line 229
    :cond_9
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/Element;->e()Lcom/salesforce/android/cases/core/model/Actor;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/Actor;->a()Ljava/lang/String;

    move-result-object v0

    goto :goto_8

    .line 238
    :cond_a
    return-void

    :cond_b
    move-object v0, v2

    goto :goto_6

    :cond_c
    move-object v1, v0

    goto/16 :goto_0
.end method


# virtual methods
.method public a()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 96
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->a:Ljava/util/List;

    if-nez v0, :cond_0

    .line 97
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    .line 99
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->a:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/cases/core/model/CommentPost;)Ljava/util/List;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/model/CommentPost;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 103
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 105
    if-eqz p1, :cond_6

    invoke-interface {p1}, Lcom/salesforce/android/cases/core/model/CommentPost;->a()Lcom/salesforce/android/cases/core/model/Body;

    move-result-object v0

    if-eqz v0, :cond_6

    .line 106
    invoke-interface {p1}, Lcom/salesforce/android/cases/core/model/CommentPost;->a()Lcom/salesforce/android/cases/core/model/Body;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/Body;->a()Ljava/lang/String;

    move-result-object v0

    .line 105
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_6

    .line 108
    invoke-interface {p1}, Lcom/salesforce/android/cases/core/model/CommentPost;->b()Ljava/util/Date;

    move-result-object v4

    .line 109
    new-instance v5, Ljava/util/Date;

    invoke-direct {v5}, Ljava/util/Date;-><init>()V

    .line 113
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    move v3, v0

    :goto_0
    if-ltz v3, :cond_0

    .line 114
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->a:Ljava/util/List;

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    .line 115
    instance-of v6, v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/SentMessageModel;

    if-eqz v6, :cond_2

    .line 116
    check-cast v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/SentMessageModel;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/SentMessageModel;->d()Ljava/util/Date;

    move-result-object v2

    .line 125
    :cond_0
    :goto_1
    if-nez v2, :cond_4

    invoke-interface {p1}, Lcom/salesforce/android/cases/core/model/CommentPost;->b()Ljava/util/Date;

    move-result-object v0

    invoke-direct {p0, v5, v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->a(Ljava/util/Date;Ljava/util/Date;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 126
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/HorizontalRuleModel;

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->b:Landroid/content/Context;

    sget v3, Lcom/salesforce/android/cases/R$string;->cases_horizontal_rule_today_text:I

    .line 127
    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/HorizontalRuleModel;-><init>(Ljava/lang/String;)V

    .line 128
    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->a:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 129
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 136
    :cond_1
    :goto_2
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/SentMessageModel;

    .line 137
    invoke-interface {p1}, Lcom/salesforce/android/cases/core/model/CommentPost;->a()Lcom/salesforce/android/cases/core/model/Body;

    move-result-object v2

    invoke-interface {v2}, Lcom/salesforce/android/cases/core/model/Body;->a()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/salesforce/android/cases/core/internal/util/StringUtils;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 138
    invoke-interface {p1}, Lcom/salesforce/android/cases/core/model/CommentPost;->b()Ljava/util/Date;

    move-result-object v3

    invoke-direct {v0, v2, v3}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/SentMessageModel;-><init>(Ljava/lang/String;Ljava/util/Date;)V

    .line 139
    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->a:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 140
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    move-object v0, v1

    .line 145
    :goto_3
    return-object v0

    .line 118
    :cond_2
    instance-of v6, v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/ReceivedMessageModel;

    if-eqz v6, :cond_3

    .line 119
    check-cast v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/ReceivedMessageModel;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/ReceivedMessageModel;->d()Ljava/util/Date;

    move-result-object v2

    goto :goto_1

    .line 113
    :cond_3
    add-int/lit8 v0, v3, -0x1

    move v3, v0

    goto :goto_0

    .line 130
    :cond_4
    if-eqz v2, :cond_5

    invoke-direct {p0, v2, v4}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->a(Ljava/util/Date;Ljava/util/Date;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 131
    :cond_5
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/HorizontalRuleModel;

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->g:Ljava/text/DateFormat;

    invoke-virtual {v2, v4}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/HorizontalRuleModel;-><init>(Ljava/lang/String;)V

    .line 132
    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->a:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 133
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2

    :cond_6
    move-object v0, v2

    .line 145
    goto :goto_3
.end method

.method public b()Ljava/lang/String;
    .locals 5

    .prologue
    .line 149
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->c:Lcom/salesforce/android/cases/core/model/CaseDetailRecord;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->c:Lcom/salesforce/android/cases/core/model/CaseDetailRecord;

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->n()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 150
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->c:Lcom/salesforce/android/cases/core/model/CaseDetailRecord;

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->n()Ljava/lang/String;

    move-result-object v0

    .line 155
    :goto_0
    return-object v0

    .line 151
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->c:Lcom/salesforce/android/cases/core/model/CaseDetailRecord;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->c:Lcom/salesforce/android/cases/core/model/CaseDetailRecord;

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->b()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 152
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->b:Landroid/content/Context;

    sget v1, Lcom/salesforce/android/cases/R$string;->cases_case_feed_default_title_text:I

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->c:Lcom/salesforce/android/cases/core/model/CaseDetailRecord;

    .line 153
    invoke-interface {v4}, Lcom/salesforce/android/cases/core/model/CaseDetailRecord;->b()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    .line 152
    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 155
    :cond_1
    const-string v0, ""

    goto :goto_0
.end method

.method public c()Ljava/util/Date;
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->h:Ljava/util/Date;

    return-object v0
.end method

.method public d()Ljava/lang/String;
    .locals 1

    .prologue
    .line 163
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->f:Ljava/lang/String;

    return-object v0
.end method
