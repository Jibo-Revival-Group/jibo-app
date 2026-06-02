package com.google.api.services.youtube;

import com.google.api.client.googleapis.GoogleUtils;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Data;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.services.youtube.model.Activity;
import com.google.api.services.youtube.model.ActivityListResponse;
import com.google.api.services.youtube.model.Caption;
import com.google.api.services.youtube.model.CaptionListResponse;
import com.google.api.services.youtube.model.Channel;
import com.google.api.services.youtube.model.ChannelBannerResource;
import com.google.api.services.youtube.model.ChannelListResponse;
import com.google.api.services.youtube.model.ChannelSection;
import com.google.api.services.youtube.model.ChannelSectionListResponse;
import com.google.api.services.youtube.model.Comment;
import com.google.api.services.youtube.model.CommentListResponse;
import com.google.api.services.youtube.model.CommentThread;
import com.google.api.services.youtube.model.CommentThreadListResponse;
import com.google.api.services.youtube.model.FanFundingEventListResponse;
import com.google.api.services.youtube.model.GuideCategoryListResponse;
import com.google.api.services.youtube.model.I18nLanguageListResponse;
import com.google.api.services.youtube.model.I18nRegionListResponse;
import com.google.api.services.youtube.model.InvideoBranding;
import com.google.api.services.youtube.model.LiveBroadcast;
import com.google.api.services.youtube.model.LiveBroadcastListResponse;
import com.google.api.services.youtube.model.LiveChatBan;
import com.google.api.services.youtube.model.LiveChatMessage;
import com.google.api.services.youtube.model.LiveChatMessageListResponse;
import com.google.api.services.youtube.model.LiveChatModerator;
import com.google.api.services.youtube.model.LiveChatModeratorListResponse;
import com.google.api.services.youtube.model.LiveStream;
import com.google.api.services.youtube.model.LiveStreamListResponse;
import com.google.api.services.youtube.model.Playlist;
import com.google.api.services.youtube.model.PlaylistItem;
import com.google.api.services.youtube.model.PlaylistItemListResponse;
import com.google.api.services.youtube.model.PlaylistListResponse;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SponsorListResponse;
import com.google.api.services.youtube.model.Subscription;
import com.google.api.services.youtube.model.SubscriptionListResponse;
import com.google.api.services.youtube.model.SuperChatEventListResponse;
import com.google.api.services.youtube.model.ThumbnailSetResponse;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoAbuseReport;
import com.google.api.services.youtube.model.VideoAbuseReportReasonListResponse;
import com.google.api.services.youtube.model.VideoCategoryListResponse;
import com.google.api.services.youtube.model.VideoGetRatingResponse;
import com.google.api.services.youtube.model.VideoListResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;

public class YouTube extends AbstractGoogleJsonClient {
   public static final String DEFAULT_BASE_URL = "https://www.googleapis.com/youtube/v3/";
   public static final String DEFAULT_BATCH_PATH = "batch/youtube/v3";
   public static final String DEFAULT_ROOT_URL = "https://www.googleapis.com/";
   public static final String DEFAULT_SERVICE_PATH = "youtube/v3/";

   static {
      boolean var0;
      if (GoogleUtils.MAJOR_VERSION == 1 && GoogleUtils.MINOR_VERSION >= 15) {
         var0 = true;
      } else {
         var0 = false;
      }

      Preconditions.checkState(
         var0,
         "You are currently running with version %s of google-api-client. You need at least version 1.15 of google-api-client to run version 1.23.0 of the YouTube Data API library.",
         GoogleUtils.VERSION
      );
   }

   public YouTube(HttpTransport var1, JsonFactory var2, HttpRequestInitializer var3) {
      this(new YouTube.Builder(var1, var2, var3));
   }

   YouTube(YouTube.Builder var1) {
      super(var1);
   }

   public YouTube.Activities activities() {
      return new YouTube.Activities(this);
   }

   public YouTube.Captions captions() {
      return new YouTube.Captions(this);
   }

   public YouTube.ChannelBanners channelBanners() {
      return new YouTube.ChannelBanners(this);
   }

   public YouTube.ChannelSections channelSections() {
      return new YouTube.ChannelSections(this);
   }

   public YouTube.Channels channels() {
      return new YouTube.Channels(this);
   }

   public YouTube.CommentThreads commentThreads() {
      return new YouTube.CommentThreads(this);
   }

   public YouTube.Comments comments() {
      return new YouTube.Comments(this);
   }

   public YouTube.FanFundingEvents fanFundingEvents() {
      return new YouTube.FanFundingEvents(this);
   }

   public YouTube.GuideCategories guideCategories() {
      return new YouTube.GuideCategories(this);
   }

   public YouTube.I18nLanguages i18nLanguages() {
      return new YouTube.I18nLanguages(this);
   }

   public YouTube.I18nRegions i18nRegions() {
      return new YouTube.I18nRegions(this);
   }

   @Override
   protected void initialize(AbstractGoogleClientRequest<?> var1) throws IOException {
      super.initialize(var1);
   }

   public YouTube.LiveBroadcasts liveBroadcasts() {
      return new YouTube.LiveBroadcasts(this);
   }

   public YouTube.LiveChatBans liveChatBans() {
      return new YouTube.LiveChatBans(this);
   }

   public YouTube.LiveChatMessages liveChatMessages() {
      return new YouTube.LiveChatMessages(this);
   }

   public YouTube.LiveChatModerators liveChatModerators() {
      return new YouTube.LiveChatModerators(this);
   }

   public YouTube.LiveStreams liveStreams() {
      return new YouTube.LiveStreams(this);
   }

   public YouTube.PlaylistItems playlistItems() {
      return new YouTube.PlaylistItems(this);
   }

   public YouTube.Playlists playlists() {
      return new YouTube.Playlists(this);
   }

   public YouTube.Search search() {
      return new YouTube.Search(this);
   }

   public YouTube.Sponsors sponsors() {
      return new YouTube.Sponsors(this);
   }

   public YouTube.Subscriptions subscriptions() {
      return new YouTube.Subscriptions(this);
   }

   public YouTube.SuperChatEvents superChatEvents() {
      return new YouTube.SuperChatEvents(this);
   }

   public YouTube.Thumbnails thumbnails() {
      return new YouTube.Thumbnails(this);
   }

   public YouTube.VideoAbuseReportReasons videoAbuseReportReasons() {
      return new YouTube.VideoAbuseReportReasons(this);
   }

   public YouTube.VideoCategories videoCategories() {
      return new YouTube.VideoCategories(this);
   }

   public YouTube.Videos videos() {
      return new YouTube.Videos(this);
   }

   public YouTube.Watermarks watermarks() {
      return new YouTube.Watermarks(this);
   }

   public class Activities {
      final YouTube this$0;

      public Activities(YouTube var1) {
         this.this$0 = var1;
      }

      public YouTube.Activities.Insert insert(String var1, Activity var2) throws IOException {
         YouTube.Activities.Insert var3 = new YouTube.Activities.Insert(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public YouTube.Activities.List list(String var1) throws IOException {
         YouTube.Activities.List var2 = new YouTube.Activities.List(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public class Insert extends YouTubeRequest<Activity> {
         private static final String REST_PATH = "activities";
         @Key
         private String part;
         final YouTube.Activities this$1;

         protected Insert(YouTube.Activities var1, String var2, Activity var3) {
            super(var1.this$0, "POST", "activities", var3, Activity.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.Activities.Insert set(String var1, Object var2) {
            return (YouTube.Activities.Insert)super.set(var1, var2);
         }

         public YouTube.Activities.Insert setAlt(String var1) {
            return (YouTube.Activities.Insert)super.setAlt(var1);
         }

         public YouTube.Activities.Insert setFields(String var1) {
            return (YouTube.Activities.Insert)super.setFields(var1);
         }

         public YouTube.Activities.Insert setKey(String var1) {
            return (YouTube.Activities.Insert)super.setKey(var1);
         }

         public YouTube.Activities.Insert setOauthToken(String var1) {
            return (YouTube.Activities.Insert)super.setOauthToken(var1);
         }

         public YouTube.Activities.Insert setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.Activities.Insert setPrettyPrint(Boolean var1) {
            return (YouTube.Activities.Insert)super.setPrettyPrint(var1);
         }

         public YouTube.Activities.Insert setQuotaUser(String var1) {
            return (YouTube.Activities.Insert)super.setQuotaUser(var1);
         }

         public YouTube.Activities.Insert setUserIp(String var1) {
            return (YouTube.Activities.Insert)super.setUserIp(var1);
         }
      }

      public class List extends YouTubeRequest<ActivityListResponse> {
         private static final String REST_PATH = "activities";
         @Key
         private String channelId;
         @Key
         private Boolean home;
         @Key
         private Long maxResults;
         @Key
         private Boolean mine;
         @Key
         private String pageToken;
         @Key
         private String part;
         @Key
         private DateTime publishedAfter;
         @Key
         private DateTime publishedBefore;
         @Key
         private String regionCode;
         final YouTube.Activities this$1;

         protected List(YouTube.Activities var1, String var2) {
            super(var1.this$0, "GET", "activities", null, ActivityListResponse.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         @Override
         public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
         }

         @Override
         public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
         }

         public String getChannelId() {
            return this.channelId;
         }

         public Boolean getHome() {
            return this.home;
         }

         public Long getMaxResults() {
            return this.maxResults;
         }

         public Boolean getMine() {
            return this.mine;
         }

         public String getPageToken() {
            return this.pageToken;
         }

         public String getPart() {
            return this.part;
         }

         public DateTime getPublishedAfter() {
            return this.publishedAfter;
         }

         public DateTime getPublishedBefore() {
            return this.publishedBefore;
         }

         public String getRegionCode() {
            return this.regionCode;
         }

         public YouTube.Activities.List set(String var1, Object var2) {
            return (YouTube.Activities.List)super.set(var1, var2);
         }

         public YouTube.Activities.List setAlt(String var1) {
            return (YouTube.Activities.List)super.setAlt(var1);
         }

         public YouTube.Activities.List setChannelId(String var1) {
            this.channelId = var1;
            return this;
         }

         public YouTube.Activities.List setFields(String var1) {
            return (YouTube.Activities.List)super.setFields(var1);
         }

         public YouTube.Activities.List setHome(Boolean var1) {
            this.home = var1;
            return this;
         }

         public YouTube.Activities.List setKey(String var1) {
            return (YouTube.Activities.List)super.setKey(var1);
         }

         public YouTube.Activities.List setMaxResults(Long var1) {
            this.maxResults = var1;
            return this;
         }

         public YouTube.Activities.List setMine(Boolean var1) {
            this.mine = var1;
            return this;
         }

         public YouTube.Activities.List setOauthToken(String var1) {
            return (YouTube.Activities.List)super.setOauthToken(var1);
         }

         public YouTube.Activities.List setPageToken(String var1) {
            this.pageToken = var1;
            return this;
         }

         public YouTube.Activities.List setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.Activities.List setPrettyPrint(Boolean var1) {
            return (YouTube.Activities.List)super.setPrettyPrint(var1);
         }

         public YouTube.Activities.List setPublishedAfter(DateTime var1) {
            this.publishedAfter = var1;
            return this;
         }

         public YouTube.Activities.List setPublishedBefore(DateTime var1) {
            this.publishedBefore = var1;
            return this;
         }

         public YouTube.Activities.List setQuotaUser(String var1) {
            return (YouTube.Activities.List)super.setQuotaUser(var1);
         }

         public YouTube.Activities.List setRegionCode(String var1) {
            this.regionCode = var1;
            return this;
         }

         public YouTube.Activities.List setUserIp(String var1) {
            return (YouTube.Activities.List)super.setUserIp(var1);
         }
      }
   }

   public static final class Builder extends AbstractGoogleJsonClient.Builder {
      public Builder(HttpTransport var1, JsonFactory var2, HttpRequestInitializer var3) {
         super(var1, var2, "https://www.googleapis.com/", "youtube/v3/", var3, false);
         this.setBatchPath("batch/youtube/v3");
      }

      public YouTube build() {
         return new YouTube(this);
      }

      public YouTube.Builder setApplicationName(String var1) {
         return (YouTube.Builder)super.setApplicationName(var1);
      }

      public YouTube.Builder setBatchPath(String var1) {
         return (YouTube.Builder)super.setBatchPath(var1);
      }

      public YouTube.Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer var1) {
         return (YouTube.Builder)super.setGoogleClientRequestInitializer(var1);
      }

      public YouTube.Builder setHttpRequestInitializer(HttpRequestInitializer var1) {
         return (YouTube.Builder)super.setHttpRequestInitializer(var1);
      }

      public YouTube.Builder setRootUrl(String var1) {
         return (YouTube.Builder)super.setRootUrl(var1);
      }

      public YouTube.Builder setServicePath(String var1) {
         return (YouTube.Builder)super.setServicePath(var1);
      }

      public YouTube.Builder setSuppressAllChecks(boolean var1) {
         return (YouTube.Builder)super.setSuppressAllChecks(var1);
      }

      public YouTube.Builder setSuppressPatternChecks(boolean var1) {
         return (YouTube.Builder)super.setSuppressPatternChecks(var1);
      }

      public YouTube.Builder setSuppressRequiredParameterChecks(boolean var1) {
         return (YouTube.Builder)super.setSuppressRequiredParameterChecks(var1);
      }

      public YouTube.Builder setYouTubeRequestInitializer(YouTubeRequestInitializer var1) {
         return (YouTube.Builder)super.setGoogleClientRequestInitializer(var1);
      }
   }

   public class Captions {
      final YouTube this$0;

      public Captions(YouTube var1) {
         this.this$0 = var1;
      }

      public YouTube.Captions.Delete delete(String var1) throws IOException {
         YouTube.Captions.Delete var2 = new YouTube.Captions.Delete(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public YouTube.Captions.Download download(String var1) throws IOException {
         YouTube.Captions.Download var2 = new YouTube.Captions.Download(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public YouTube.Captions.Insert insert(String var1, Caption var2) throws IOException {
         YouTube.Captions.Insert var3 = new YouTube.Captions.Insert(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public YouTube.Captions.Insert insert(String var1, Caption var2, AbstractInputStreamContent var3) throws IOException {
         YouTube.Captions.Insert var4 = new YouTube.Captions.Insert(this, var1, var2, var3);
         this.this$0.initialize(var4);
         return var4;
      }

      public YouTube.Captions.List list(String var1, String var2) throws IOException {
         YouTube.Captions.List var3 = new YouTube.Captions.List(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public YouTube.Captions.Update update(String var1, Caption var2) throws IOException {
         YouTube.Captions.Update var3 = new YouTube.Captions.Update(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public YouTube.Captions.Update update(String var1, Caption var2, AbstractInputStreamContent var3) throws IOException {
         YouTube.Captions.Update var4 = new YouTube.Captions.Update(this, var1, var2, var3);
         this.this$0.initialize(var4);
         return var4;
      }

      public class Delete extends YouTubeRequest<Void> {
         private static final String REST_PATH = "captions";
         @Key
         private String id;
         @Key
         private String onBehalfOf;
         @Key
         private String onBehalfOfContentOwner;
         final YouTube.Captions this$1;

         protected Delete(YouTube.Captions var1, String var2) {
            super(var1.this$0, "DELETE", "captions", null, Void.class);
            this.this$1 = var1;
            this.id = Preconditions.checkNotNull(var2, "Required parameter id must be specified.");
         }

         public String getId() {
            return this.id;
         }

         public String getOnBehalfOf() {
            return this.onBehalfOf;
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public YouTube.Captions.Delete set(String var1, Object var2) {
            return (YouTube.Captions.Delete)super.set(var1, var2);
         }

         public YouTube.Captions.Delete setAlt(String var1) {
            return (YouTube.Captions.Delete)super.setAlt(var1);
         }

         public YouTube.Captions.Delete setFields(String var1) {
            return (YouTube.Captions.Delete)super.setFields(var1);
         }

         public YouTube.Captions.Delete setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.Captions.Delete setKey(String var1) {
            return (YouTube.Captions.Delete)super.setKey(var1);
         }

         public YouTube.Captions.Delete setOauthToken(String var1) {
            return (YouTube.Captions.Delete)super.setOauthToken(var1);
         }

         public YouTube.Captions.Delete setOnBehalfOf(String var1) {
            this.onBehalfOf = var1;
            return this;
         }

         public YouTube.Captions.Delete setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.Captions.Delete setPrettyPrint(Boolean var1) {
            return (YouTube.Captions.Delete)super.setPrettyPrint(var1);
         }

         public YouTube.Captions.Delete setQuotaUser(String var1) {
            return (YouTube.Captions.Delete)super.setQuotaUser(var1);
         }

         public YouTube.Captions.Delete setUserIp(String var1) {
            return (YouTube.Captions.Delete)super.setUserIp(var1);
         }
      }

      public class Download extends YouTubeRequest<Void> {
         private static final String REST_PATH = "captions/{id}";
         @Key
         private String id;
         @Key
         private String onBehalfOf;
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String tfmt;
         final YouTube.Captions this$1;
         @Key
         private String tlang;

         protected Download(YouTube.Captions var1, String var2) {
            super(var1.this$0, "GET", "captions/{id}", null, Void.class);
            this.this$1 = var1;
            this.id = Preconditions.checkNotNull(var2, "Required parameter id must be specified.");
            this.initializeMediaDownload();
         }

         @Override
         public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
         }

         @Override
         public HttpResponse executeMedia() throws IOException {
            return super.executeMedia();
         }

         @Override
         public void executeMediaAndDownloadTo(OutputStream var1) throws IOException {
            super.executeMediaAndDownloadTo(var1);
         }

         @Override
         public InputStream executeMediaAsInputStream() throws IOException {
            return super.executeMediaAsInputStream();
         }

         @Override
         public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
         }

         public String getId() {
            return this.id;
         }

         public String getOnBehalfOf() {
            return this.onBehalfOf;
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getTfmt() {
            return this.tfmt;
         }

         public String getTlang() {
            return this.tlang;
         }

         public YouTube.Captions.Download set(String var1, Object var2) {
            return (YouTube.Captions.Download)super.set(var1, var2);
         }

         public YouTube.Captions.Download setAlt(String var1) {
            return (YouTube.Captions.Download)super.setAlt(var1);
         }

         public YouTube.Captions.Download setFields(String var1) {
            return (YouTube.Captions.Download)super.setFields(var1);
         }

         public YouTube.Captions.Download setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.Captions.Download setKey(String var1) {
            return (YouTube.Captions.Download)super.setKey(var1);
         }

         public YouTube.Captions.Download setOauthToken(String var1) {
            return (YouTube.Captions.Download)super.setOauthToken(var1);
         }

         public YouTube.Captions.Download setOnBehalfOf(String var1) {
            this.onBehalfOf = var1;
            return this;
         }

         public YouTube.Captions.Download setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.Captions.Download setPrettyPrint(Boolean var1) {
            return (YouTube.Captions.Download)super.setPrettyPrint(var1);
         }

         public YouTube.Captions.Download setQuotaUser(String var1) {
            return (YouTube.Captions.Download)super.setQuotaUser(var1);
         }

         public YouTube.Captions.Download setTfmt(String var1) {
            this.tfmt = var1;
            return this;
         }

         public YouTube.Captions.Download setTlang(String var1) {
            this.tlang = var1;
            return this;
         }

         public YouTube.Captions.Download setUserIp(String var1) {
            return (YouTube.Captions.Download)super.setUserIp(var1);
         }
      }

      public class Insert extends YouTubeRequest<Caption> {
         private static final String REST_PATH = "captions";
         @Key
         private String onBehalfOf;
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String part;
         @Key
         private Boolean sync;
         final YouTube.Captions this$1;

         protected Insert(YouTube.Captions var1, String var2, Caption var3) {
            super(var1.this$0, "POST", "captions", var3, Caption.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         protected Insert(YouTube.Captions var1, String var2, Caption var3, AbstractInputStreamContent var4) {
            super(var1.this$0, "POST", "/upload/" + var1.this$0.getServicePath() + "captions", var3, Caption.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
            this.initializeMediaUpload(var4);
         }

         public String getOnBehalfOf() {
            return this.onBehalfOf;
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getPart() {
            return this.part;
         }

         public Boolean getSync() {
            return this.sync;
         }

         public YouTube.Captions.Insert set(String var1, Object var2) {
            return (YouTube.Captions.Insert)super.set(var1, var2);
         }

         public YouTube.Captions.Insert setAlt(String var1) {
            return (YouTube.Captions.Insert)super.setAlt(var1);
         }

         public YouTube.Captions.Insert setFields(String var1) {
            return (YouTube.Captions.Insert)super.setFields(var1);
         }

         public YouTube.Captions.Insert setKey(String var1) {
            return (YouTube.Captions.Insert)super.setKey(var1);
         }

         public YouTube.Captions.Insert setOauthToken(String var1) {
            return (YouTube.Captions.Insert)super.setOauthToken(var1);
         }

         public YouTube.Captions.Insert setOnBehalfOf(String var1) {
            this.onBehalfOf = var1;
            return this;
         }

         public YouTube.Captions.Insert setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.Captions.Insert setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.Captions.Insert setPrettyPrint(Boolean var1) {
            return (YouTube.Captions.Insert)super.setPrettyPrint(var1);
         }

         public YouTube.Captions.Insert setQuotaUser(String var1) {
            return (YouTube.Captions.Insert)super.setQuotaUser(var1);
         }

         public YouTube.Captions.Insert setSync(Boolean var1) {
            this.sync = var1;
            return this;
         }

         public YouTube.Captions.Insert setUserIp(String var1) {
            return (YouTube.Captions.Insert)super.setUserIp(var1);
         }
      }

      public class List extends YouTubeRequest<CaptionListResponse> {
         private static final String REST_PATH = "captions";
         @Key
         private String id;
         @Key
         private String onBehalfOf;
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String part;
         final YouTube.Captions this$1;
         @Key
         private String videoId;

         protected List(YouTube.Captions var1, String var2, String var3) {
            super(var1.this$0, "GET", "captions", null, CaptionListResponse.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
            this.videoId = Preconditions.checkNotNull(var3, "Required parameter videoId must be specified.");
         }

         @Override
         public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
         }

         @Override
         public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
         }

         public String getId() {
            return this.id;
         }

         public String getOnBehalfOf() {
            return this.onBehalfOf;
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getPart() {
            return this.part;
         }

         public String getVideoId() {
            return this.videoId;
         }

         public YouTube.Captions.List set(String var1, Object var2) {
            return (YouTube.Captions.List)super.set(var1, var2);
         }

         public YouTube.Captions.List setAlt(String var1) {
            return (YouTube.Captions.List)super.setAlt(var1);
         }

         public YouTube.Captions.List setFields(String var1) {
            return (YouTube.Captions.List)super.setFields(var1);
         }

         public YouTube.Captions.List setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.Captions.List setKey(String var1) {
            return (YouTube.Captions.List)super.setKey(var1);
         }

         public YouTube.Captions.List setOauthToken(String var1) {
            return (YouTube.Captions.List)super.setOauthToken(var1);
         }

         public YouTube.Captions.List setOnBehalfOf(String var1) {
            this.onBehalfOf = var1;
            return this;
         }

         public YouTube.Captions.List setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.Captions.List setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.Captions.List setPrettyPrint(Boolean var1) {
            return (YouTube.Captions.List)super.setPrettyPrint(var1);
         }

         public YouTube.Captions.List setQuotaUser(String var1) {
            return (YouTube.Captions.List)super.setQuotaUser(var1);
         }

         public YouTube.Captions.List setUserIp(String var1) {
            return (YouTube.Captions.List)super.setUserIp(var1);
         }

         public YouTube.Captions.List setVideoId(String var1) {
            this.videoId = var1;
            return this;
         }
      }

      public class Update extends YouTubeRequest<Caption> {
         private static final String REST_PATH = "captions";
         @Key
         private String onBehalfOf;
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String part;
         @Key
         private Boolean sync;
         final YouTube.Captions this$1;

         protected Update(YouTube.Captions var1, String var2, Caption var3) {
            super(var1.this$0, "PUT", "captions", var3, Caption.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
            this.checkRequiredParameter(var3, "content");
            this.checkRequiredParameter(var3.getId(), "Caption.getId()");
         }

         protected Update(YouTube.Captions var1, String var2, Caption var3, AbstractInputStreamContent var4) {
            super(var1.this$0, "PUT", "/upload/" + var1.this$0.getServicePath() + "captions", var3, Caption.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
            this.initializeMediaUpload(var4);
         }

         public String getOnBehalfOf() {
            return this.onBehalfOf;
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getPart() {
            return this.part;
         }

         public Boolean getSync() {
            return this.sync;
         }

         public YouTube.Captions.Update set(String var1, Object var2) {
            return (YouTube.Captions.Update)super.set(var1, var2);
         }

         public YouTube.Captions.Update setAlt(String var1) {
            return (YouTube.Captions.Update)super.setAlt(var1);
         }

         public YouTube.Captions.Update setFields(String var1) {
            return (YouTube.Captions.Update)super.setFields(var1);
         }

         public YouTube.Captions.Update setKey(String var1) {
            return (YouTube.Captions.Update)super.setKey(var1);
         }

         public YouTube.Captions.Update setOauthToken(String var1) {
            return (YouTube.Captions.Update)super.setOauthToken(var1);
         }

         public YouTube.Captions.Update setOnBehalfOf(String var1) {
            this.onBehalfOf = var1;
            return this;
         }

         public YouTube.Captions.Update setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.Captions.Update setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.Captions.Update setPrettyPrint(Boolean var1) {
            return (YouTube.Captions.Update)super.setPrettyPrint(var1);
         }

         public YouTube.Captions.Update setQuotaUser(String var1) {
            return (YouTube.Captions.Update)super.setQuotaUser(var1);
         }

         public YouTube.Captions.Update setSync(Boolean var1) {
            this.sync = var1;
            return this;
         }

         public YouTube.Captions.Update setUserIp(String var1) {
            return (YouTube.Captions.Update)super.setUserIp(var1);
         }
      }
   }

   public class ChannelBanners {
      final YouTube this$0;

      public ChannelBanners(YouTube var1) {
         this.this$0 = var1;
      }

      public YouTube.ChannelBanners.Insert insert(ChannelBannerResource var1) throws IOException {
         YouTube.ChannelBanners.Insert var2 = new YouTube.ChannelBanners.Insert(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public YouTube.ChannelBanners.Insert insert(ChannelBannerResource var1, AbstractInputStreamContent var2) throws IOException {
         YouTube.ChannelBanners.Insert var3 = new YouTube.ChannelBanners.Insert(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public class Insert extends YouTubeRequest<ChannelBannerResource> {
         private static final String REST_PATH = "channelBanners/insert";
         @Key
         private String channelId;
         @Key
         private String onBehalfOfContentOwner;
         final YouTube.ChannelBanners this$1;

         protected Insert(YouTube.ChannelBanners var1, ChannelBannerResource var2) {
            super(var1.this$0, "POST", "channelBanners/insert", var2, ChannelBannerResource.class);
            this.this$1 = var1;
         }

         protected Insert(YouTube.ChannelBanners var1, ChannelBannerResource var2, AbstractInputStreamContent var3) {
            super(var1.this$0, "POST", "/upload/" + var1.this$0.getServicePath() + "channelBanners/insert", var2, ChannelBannerResource.class);
            this.this$1 = var1;
            this.initializeMediaUpload(var3);
         }

         public String getChannelId() {
            return this.channelId;
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public YouTube.ChannelBanners.Insert set(String var1, Object var2) {
            return (YouTube.ChannelBanners.Insert)super.set(var1, var2);
         }

         public YouTube.ChannelBanners.Insert setAlt(String var1) {
            return (YouTube.ChannelBanners.Insert)super.setAlt(var1);
         }

         public YouTube.ChannelBanners.Insert setChannelId(String var1) {
            this.channelId = var1;
            return this;
         }

         public YouTube.ChannelBanners.Insert setFields(String var1) {
            return (YouTube.ChannelBanners.Insert)super.setFields(var1);
         }

         public YouTube.ChannelBanners.Insert setKey(String var1) {
            return (YouTube.ChannelBanners.Insert)super.setKey(var1);
         }

         public YouTube.ChannelBanners.Insert setOauthToken(String var1) {
            return (YouTube.ChannelBanners.Insert)super.setOauthToken(var1);
         }

         public YouTube.ChannelBanners.Insert setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.ChannelBanners.Insert setPrettyPrint(Boolean var1) {
            return (YouTube.ChannelBanners.Insert)super.setPrettyPrint(var1);
         }

         public YouTube.ChannelBanners.Insert setQuotaUser(String var1) {
            return (YouTube.ChannelBanners.Insert)super.setQuotaUser(var1);
         }

         public YouTube.ChannelBanners.Insert setUserIp(String var1) {
            return (YouTube.ChannelBanners.Insert)super.setUserIp(var1);
         }
      }
   }

   public class ChannelSections {
      final YouTube this$0;

      public ChannelSections(YouTube var1) {
         this.this$0 = var1;
      }

      public YouTube.ChannelSections.Delete delete(String var1) throws IOException {
         YouTube.ChannelSections.Delete var2 = new YouTube.ChannelSections.Delete(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public YouTube.ChannelSections.Insert insert(String var1, ChannelSection var2) throws IOException {
         YouTube.ChannelSections.Insert var3 = new YouTube.ChannelSections.Insert(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public YouTube.ChannelSections.List list(String var1) throws IOException {
         YouTube.ChannelSections.List var2 = new YouTube.ChannelSections.List(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public YouTube.ChannelSections.Update update(String var1, ChannelSection var2) throws IOException {
         YouTube.ChannelSections.Update var3 = new YouTube.ChannelSections.Update(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public class Delete extends YouTubeRequest<Void> {
         private static final String REST_PATH = "channelSections";
         @Key
         private String id;
         @Key
         private String onBehalfOfContentOwner;
         final YouTube.ChannelSections this$1;

         protected Delete(YouTube.ChannelSections var1, String var2) {
            super(var1.this$0, "DELETE", "channelSections", null, Void.class);
            this.this$1 = var1;
            this.id = Preconditions.checkNotNull(var2, "Required parameter id must be specified.");
         }

         public String getId() {
            return this.id;
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public YouTube.ChannelSections.Delete set(String var1, Object var2) {
            return (YouTube.ChannelSections.Delete)super.set(var1, var2);
         }

         public YouTube.ChannelSections.Delete setAlt(String var1) {
            return (YouTube.ChannelSections.Delete)super.setAlt(var1);
         }

         public YouTube.ChannelSections.Delete setFields(String var1) {
            return (YouTube.ChannelSections.Delete)super.setFields(var1);
         }

         public YouTube.ChannelSections.Delete setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.ChannelSections.Delete setKey(String var1) {
            return (YouTube.ChannelSections.Delete)super.setKey(var1);
         }

         public YouTube.ChannelSections.Delete setOauthToken(String var1) {
            return (YouTube.ChannelSections.Delete)super.setOauthToken(var1);
         }

         public YouTube.ChannelSections.Delete setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.ChannelSections.Delete setPrettyPrint(Boolean var1) {
            return (YouTube.ChannelSections.Delete)super.setPrettyPrint(var1);
         }

         public YouTube.ChannelSections.Delete setQuotaUser(String var1) {
            return (YouTube.ChannelSections.Delete)super.setQuotaUser(var1);
         }

         public YouTube.ChannelSections.Delete setUserIp(String var1) {
            return (YouTube.ChannelSections.Delete)super.setUserIp(var1);
         }
      }

      public class Insert extends YouTubeRequest<ChannelSection> {
         private static final String REST_PATH = "channelSections";
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String onBehalfOfContentOwnerChannel;
         @Key
         private String part;
         final YouTube.ChannelSections this$1;

         protected Insert(YouTube.ChannelSections var1, String var2, ChannelSection var3) {
            super(var1.this$0, "POST", "channelSections", var3, ChannelSection.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getOnBehalfOfContentOwnerChannel() {
            return this.onBehalfOfContentOwnerChannel;
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.ChannelSections.Insert set(String var1, Object var2) {
            return (YouTube.ChannelSections.Insert)super.set(var1, var2);
         }

         public YouTube.ChannelSections.Insert setAlt(String var1) {
            return (YouTube.ChannelSections.Insert)super.setAlt(var1);
         }

         public YouTube.ChannelSections.Insert setFields(String var1) {
            return (YouTube.ChannelSections.Insert)super.setFields(var1);
         }

         public YouTube.ChannelSections.Insert setKey(String var1) {
            return (YouTube.ChannelSections.Insert)super.setKey(var1);
         }

         public YouTube.ChannelSections.Insert setOauthToken(String var1) {
            return (YouTube.ChannelSections.Insert)super.setOauthToken(var1);
         }

         public YouTube.ChannelSections.Insert setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.ChannelSections.Insert setOnBehalfOfContentOwnerChannel(String var1) {
            this.onBehalfOfContentOwnerChannel = var1;
            return this;
         }

         public YouTube.ChannelSections.Insert setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.ChannelSections.Insert setPrettyPrint(Boolean var1) {
            return (YouTube.ChannelSections.Insert)super.setPrettyPrint(var1);
         }

         public YouTube.ChannelSections.Insert setQuotaUser(String var1) {
            return (YouTube.ChannelSections.Insert)super.setQuotaUser(var1);
         }

         public YouTube.ChannelSections.Insert setUserIp(String var1) {
            return (YouTube.ChannelSections.Insert)super.setUserIp(var1);
         }
      }

      public class List extends YouTubeRequest<ChannelSectionListResponse> {
         private static final String REST_PATH = "channelSections";
         @Key
         private String channelId;
         @Key
         private String hl;
         @Key
         private String id;
         @Key
         private Boolean mine;
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String part;
         final YouTube.ChannelSections this$1;

         protected List(YouTube.ChannelSections var1, String var2) {
            super(var1.this$0, "GET", "channelSections", null, ChannelSectionListResponse.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         @Override
         public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
         }

         @Override
         public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
         }

         public String getChannelId() {
            return this.channelId;
         }

         public String getHl() {
            return this.hl;
         }

         public String getId() {
            return this.id;
         }

         public Boolean getMine() {
            return this.mine;
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.ChannelSections.List set(String var1, Object var2) {
            return (YouTube.ChannelSections.List)super.set(var1, var2);
         }

         public YouTube.ChannelSections.List setAlt(String var1) {
            return (YouTube.ChannelSections.List)super.setAlt(var1);
         }

         public YouTube.ChannelSections.List setChannelId(String var1) {
            this.channelId = var1;
            return this;
         }

         public YouTube.ChannelSections.List setFields(String var1) {
            return (YouTube.ChannelSections.List)super.setFields(var1);
         }

         public YouTube.ChannelSections.List setHl(String var1) {
            this.hl = var1;
            return this;
         }

         public YouTube.ChannelSections.List setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.ChannelSections.List setKey(String var1) {
            return (YouTube.ChannelSections.List)super.setKey(var1);
         }

         public YouTube.ChannelSections.List setMine(Boolean var1) {
            this.mine = var1;
            return this;
         }

         public YouTube.ChannelSections.List setOauthToken(String var1) {
            return (YouTube.ChannelSections.List)super.setOauthToken(var1);
         }

         public YouTube.ChannelSections.List setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.ChannelSections.List setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.ChannelSections.List setPrettyPrint(Boolean var1) {
            return (YouTube.ChannelSections.List)super.setPrettyPrint(var1);
         }

         public YouTube.ChannelSections.List setQuotaUser(String var1) {
            return (YouTube.ChannelSections.List)super.setQuotaUser(var1);
         }

         public YouTube.ChannelSections.List setUserIp(String var1) {
            return (YouTube.ChannelSections.List)super.setUserIp(var1);
         }
      }

      public class Update extends YouTubeRequest<ChannelSection> {
         private static final String REST_PATH = "channelSections";
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String part;
         final YouTube.ChannelSections this$1;

         protected Update(YouTube.ChannelSections var1, String var2, ChannelSection var3) {
            super(var1.this$0, "PUT", "channelSections", var3, ChannelSection.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.ChannelSections.Update set(String var1, Object var2) {
            return (YouTube.ChannelSections.Update)super.set(var1, var2);
         }

         public YouTube.ChannelSections.Update setAlt(String var1) {
            return (YouTube.ChannelSections.Update)super.setAlt(var1);
         }

         public YouTube.ChannelSections.Update setFields(String var1) {
            return (YouTube.ChannelSections.Update)super.setFields(var1);
         }

         public YouTube.ChannelSections.Update setKey(String var1) {
            return (YouTube.ChannelSections.Update)super.setKey(var1);
         }

         public YouTube.ChannelSections.Update setOauthToken(String var1) {
            return (YouTube.ChannelSections.Update)super.setOauthToken(var1);
         }

         public YouTube.ChannelSections.Update setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.ChannelSections.Update setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.ChannelSections.Update setPrettyPrint(Boolean var1) {
            return (YouTube.ChannelSections.Update)super.setPrettyPrint(var1);
         }

         public YouTube.ChannelSections.Update setQuotaUser(String var1) {
            return (YouTube.ChannelSections.Update)super.setQuotaUser(var1);
         }

         public YouTube.ChannelSections.Update setUserIp(String var1) {
            return (YouTube.ChannelSections.Update)super.setUserIp(var1);
         }
      }
   }

   public class Channels {
      final YouTube this$0;

      public Channels(YouTube var1) {
         this.this$0 = var1;
      }

      public YouTube.Channels.List list(String var1) throws IOException {
         YouTube.Channels.List var2 = new YouTube.Channels.List(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public YouTube.Channels.Update update(String var1, Channel var2) throws IOException {
         YouTube.Channels.Update var3 = new YouTube.Channels.Update(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public class List extends YouTubeRequest<ChannelListResponse> {
         private static final String REST_PATH = "channels";
         @Key
         private String categoryId;
         @Key
         private String forUsername;
         @Key
         private String hl;
         @Key
         private String id;
         @Key
         private Boolean managedByMe;
         @Key
         private Long maxResults;
         @Key
         private Boolean mine;
         @Key
         private Boolean mySubscribers;
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String pageToken;
         @Key
         private String part;
         final YouTube.Channels this$1;

         protected List(YouTube.Channels var1, String var2) {
            super(var1.this$0, "GET", "channels", null, ChannelListResponse.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         @Override
         public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
         }

         @Override
         public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
         }

         public String getCategoryId() {
            return this.categoryId;
         }

         public String getForUsername() {
            return this.forUsername;
         }

         public String getHl() {
            return this.hl;
         }

         public String getId() {
            return this.id;
         }

         public Boolean getManagedByMe() {
            return this.managedByMe;
         }

         public Long getMaxResults() {
            return this.maxResults;
         }

         public Boolean getMine() {
            return this.mine;
         }

         public Boolean getMySubscribers() {
            return this.mySubscribers;
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getPageToken() {
            return this.pageToken;
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.Channels.List set(String var1, Object var2) {
            return (YouTube.Channels.List)super.set(var1, var2);
         }

         public YouTube.Channels.List setAlt(String var1) {
            return (YouTube.Channels.List)super.setAlt(var1);
         }

         public YouTube.Channels.List setCategoryId(String var1) {
            this.categoryId = var1;
            return this;
         }

         public YouTube.Channels.List setFields(String var1) {
            return (YouTube.Channels.List)super.setFields(var1);
         }

         public YouTube.Channels.List setForUsername(String var1) {
            this.forUsername = var1;
            return this;
         }

         public YouTube.Channels.List setHl(String var1) {
            this.hl = var1;
            return this;
         }

         public YouTube.Channels.List setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.Channels.List setKey(String var1) {
            return (YouTube.Channels.List)super.setKey(var1);
         }

         public YouTube.Channels.List setManagedByMe(Boolean var1) {
            this.managedByMe = var1;
            return this;
         }

         public YouTube.Channels.List setMaxResults(Long var1) {
            this.maxResults = var1;
            return this;
         }

         public YouTube.Channels.List setMine(Boolean var1) {
            this.mine = var1;
            return this;
         }

         public YouTube.Channels.List setMySubscribers(Boolean var1) {
            this.mySubscribers = var1;
            return this;
         }

         public YouTube.Channels.List setOauthToken(String var1) {
            return (YouTube.Channels.List)super.setOauthToken(var1);
         }

         public YouTube.Channels.List setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.Channels.List setPageToken(String var1) {
            this.pageToken = var1;
            return this;
         }

         public YouTube.Channels.List setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.Channels.List setPrettyPrint(Boolean var1) {
            return (YouTube.Channels.List)super.setPrettyPrint(var1);
         }

         public YouTube.Channels.List setQuotaUser(String var1) {
            return (YouTube.Channels.List)super.setQuotaUser(var1);
         }

         public YouTube.Channels.List setUserIp(String var1) {
            return (YouTube.Channels.List)super.setUserIp(var1);
         }
      }

      public class Update extends YouTubeRequest<Channel> {
         private static final String REST_PATH = "channels";
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String part;
         final YouTube.Channels this$1;

         protected Update(YouTube.Channels var1, String var2, Channel var3) {
            super(var1.this$0, "PUT", "channels", var3, Channel.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.Channels.Update set(String var1, Object var2) {
            return (YouTube.Channels.Update)super.set(var1, var2);
         }

         public YouTube.Channels.Update setAlt(String var1) {
            return (YouTube.Channels.Update)super.setAlt(var1);
         }

         public YouTube.Channels.Update setFields(String var1) {
            return (YouTube.Channels.Update)super.setFields(var1);
         }

         public YouTube.Channels.Update setKey(String var1) {
            return (YouTube.Channels.Update)super.setKey(var1);
         }

         public YouTube.Channels.Update setOauthToken(String var1) {
            return (YouTube.Channels.Update)super.setOauthToken(var1);
         }

         public YouTube.Channels.Update setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.Channels.Update setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.Channels.Update setPrettyPrint(Boolean var1) {
            return (YouTube.Channels.Update)super.setPrettyPrint(var1);
         }

         public YouTube.Channels.Update setQuotaUser(String var1) {
            return (YouTube.Channels.Update)super.setQuotaUser(var1);
         }

         public YouTube.Channels.Update setUserIp(String var1) {
            return (YouTube.Channels.Update)super.setUserIp(var1);
         }
      }
   }

   public class CommentThreads {
      final YouTube this$0;

      public CommentThreads(YouTube var1) {
         this.this$0 = var1;
      }

      public YouTube.CommentThreads.Insert insert(String var1, CommentThread var2) throws IOException {
         YouTube.CommentThreads.Insert var3 = new YouTube.CommentThreads.Insert(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public YouTube.CommentThreads.List list(String var1) throws IOException {
         YouTube.CommentThreads.List var2 = new YouTube.CommentThreads.List(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public YouTube.CommentThreads.Update update(String var1, CommentThread var2) throws IOException {
         YouTube.CommentThreads.Update var3 = new YouTube.CommentThreads.Update(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public class Insert extends YouTubeRequest<CommentThread> {
         private static final String REST_PATH = "commentThreads";
         @Key
         private String part;
         final YouTube.CommentThreads this$1;

         protected Insert(YouTube.CommentThreads var1, String var2, CommentThread var3) {
            super(var1.this$0, "POST", "commentThreads", var3, CommentThread.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.CommentThreads.Insert set(String var1, Object var2) {
            return (YouTube.CommentThreads.Insert)super.set(var1, var2);
         }

         public YouTube.CommentThreads.Insert setAlt(String var1) {
            return (YouTube.CommentThreads.Insert)super.setAlt(var1);
         }

         public YouTube.CommentThreads.Insert setFields(String var1) {
            return (YouTube.CommentThreads.Insert)super.setFields(var1);
         }

         public YouTube.CommentThreads.Insert setKey(String var1) {
            return (YouTube.CommentThreads.Insert)super.setKey(var1);
         }

         public YouTube.CommentThreads.Insert setOauthToken(String var1) {
            return (YouTube.CommentThreads.Insert)super.setOauthToken(var1);
         }

         public YouTube.CommentThreads.Insert setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.CommentThreads.Insert setPrettyPrint(Boolean var1) {
            return (YouTube.CommentThreads.Insert)super.setPrettyPrint(var1);
         }

         public YouTube.CommentThreads.Insert setQuotaUser(String var1) {
            return (YouTube.CommentThreads.Insert)super.setQuotaUser(var1);
         }

         public YouTube.CommentThreads.Insert setUserIp(String var1) {
            return (YouTube.CommentThreads.Insert)super.setUserIp(var1);
         }
      }

      public class List extends YouTubeRequest<CommentThreadListResponse> {
         private static final String REST_PATH = "commentThreads";
         @Key
         private String allThreadsRelatedToChannelId;
         @Key
         private String channelId;
         @Key
         private String id;
         @Key
         private Long maxResults;
         @Key
         private String moderationStatus;
         @Key
         private String order;
         @Key
         private String pageToken;
         @Key
         private String part;
         @Key
         private String searchTerms;
         @Key
         private String textFormat;
         final YouTube.CommentThreads this$1;
         @Key
         private String videoId;

         protected List(YouTube.CommentThreads var1, String var2) {
            super(var1.this$0, "GET", "commentThreads", null, CommentThreadListResponse.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         @Override
         public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
         }

         @Override
         public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
         }

         public String getAllThreadsRelatedToChannelId() {
            return this.allThreadsRelatedToChannelId;
         }

         public String getChannelId() {
            return this.channelId;
         }

         public String getId() {
            return this.id;
         }

         public Long getMaxResults() {
            return this.maxResults;
         }

         public String getModerationStatus() {
            return this.moderationStatus;
         }

         public String getOrder() {
            return this.order;
         }

         public String getPageToken() {
            return this.pageToken;
         }

         public String getPart() {
            return this.part;
         }

         public String getSearchTerms() {
            return this.searchTerms;
         }

         public String getTextFormat() {
            return this.textFormat;
         }

         public String getVideoId() {
            return this.videoId;
         }

         public YouTube.CommentThreads.List set(String var1, Object var2) {
            return (YouTube.CommentThreads.List)super.set(var1, var2);
         }

         public YouTube.CommentThreads.List setAllThreadsRelatedToChannelId(String var1) {
            this.allThreadsRelatedToChannelId = var1;
            return this;
         }

         public YouTube.CommentThreads.List setAlt(String var1) {
            return (YouTube.CommentThreads.List)super.setAlt(var1);
         }

         public YouTube.CommentThreads.List setChannelId(String var1) {
            this.channelId = var1;
            return this;
         }

         public YouTube.CommentThreads.List setFields(String var1) {
            return (YouTube.CommentThreads.List)super.setFields(var1);
         }

         public YouTube.CommentThreads.List setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.CommentThreads.List setKey(String var1) {
            return (YouTube.CommentThreads.List)super.setKey(var1);
         }

         public YouTube.CommentThreads.List setMaxResults(Long var1) {
            this.maxResults = var1;
            return this;
         }

         public YouTube.CommentThreads.List setModerationStatus(String var1) {
            this.moderationStatus = var1;
            return this;
         }

         public YouTube.CommentThreads.List setOauthToken(String var1) {
            return (YouTube.CommentThreads.List)super.setOauthToken(var1);
         }

         public YouTube.CommentThreads.List setOrder(String var1) {
            this.order = var1;
            return this;
         }

         public YouTube.CommentThreads.List setPageToken(String var1) {
            this.pageToken = var1;
            return this;
         }

         public YouTube.CommentThreads.List setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.CommentThreads.List setPrettyPrint(Boolean var1) {
            return (YouTube.CommentThreads.List)super.setPrettyPrint(var1);
         }

         public YouTube.CommentThreads.List setQuotaUser(String var1) {
            return (YouTube.CommentThreads.List)super.setQuotaUser(var1);
         }

         public YouTube.CommentThreads.List setSearchTerms(String var1) {
            this.searchTerms = var1;
            return this;
         }

         public YouTube.CommentThreads.List setTextFormat(String var1) {
            this.textFormat = var1;
            return this;
         }

         public YouTube.CommentThreads.List setUserIp(String var1) {
            return (YouTube.CommentThreads.List)super.setUserIp(var1);
         }

         public YouTube.CommentThreads.List setVideoId(String var1) {
            this.videoId = var1;
            return this;
         }
      }

      public class Update extends YouTubeRequest<CommentThread> {
         private static final String REST_PATH = "commentThreads";
         @Key
         private String part;
         final YouTube.CommentThreads this$1;

         protected Update(YouTube.CommentThreads var1, String var2, CommentThread var3) {
            super(var1.this$0, "PUT", "commentThreads", var3, CommentThread.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.CommentThreads.Update set(String var1, Object var2) {
            return (YouTube.CommentThreads.Update)super.set(var1, var2);
         }

         public YouTube.CommentThreads.Update setAlt(String var1) {
            return (YouTube.CommentThreads.Update)super.setAlt(var1);
         }

         public YouTube.CommentThreads.Update setFields(String var1) {
            return (YouTube.CommentThreads.Update)super.setFields(var1);
         }

         public YouTube.CommentThreads.Update setKey(String var1) {
            return (YouTube.CommentThreads.Update)super.setKey(var1);
         }

         public YouTube.CommentThreads.Update setOauthToken(String var1) {
            return (YouTube.CommentThreads.Update)super.setOauthToken(var1);
         }

         public YouTube.CommentThreads.Update setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.CommentThreads.Update setPrettyPrint(Boolean var1) {
            return (YouTube.CommentThreads.Update)super.setPrettyPrint(var1);
         }

         public YouTube.CommentThreads.Update setQuotaUser(String var1) {
            return (YouTube.CommentThreads.Update)super.setQuotaUser(var1);
         }

         public YouTube.CommentThreads.Update setUserIp(String var1) {
            return (YouTube.CommentThreads.Update)super.setUserIp(var1);
         }
      }
   }

   public class Comments {
      final YouTube this$0;

      public Comments(YouTube var1) {
         this.this$0 = var1;
      }

      public YouTube.Comments.Delete delete(String var1) throws IOException {
         YouTube.Comments.Delete var2 = new YouTube.Comments.Delete(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public YouTube.Comments.Insert insert(String var1, Comment var2) throws IOException {
         YouTube.Comments.Insert var3 = new YouTube.Comments.Insert(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public YouTube.Comments.List list(String var1) throws IOException {
         YouTube.Comments.List var2 = new YouTube.Comments.List(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public YouTube.Comments.MarkAsSpam markAsSpam(String var1) throws IOException {
         YouTube.Comments.MarkAsSpam var2 = new YouTube.Comments.MarkAsSpam(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public YouTube.Comments.SetModerationStatus setModerationStatus(String var1, String var2) throws IOException {
         YouTube.Comments.SetModerationStatus var3 = new YouTube.Comments.SetModerationStatus(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public YouTube.Comments.Update update(String var1, Comment var2) throws IOException {
         YouTube.Comments.Update var3 = new YouTube.Comments.Update(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public class Delete extends YouTubeRequest<Void> {
         private static final String REST_PATH = "comments";
         @Key
         private String id;
         final YouTube.Comments this$1;

         protected Delete(YouTube.Comments var1, String var2) {
            super(var1.this$0, "DELETE", "comments", null, Void.class);
            this.this$1 = var1;
            this.id = Preconditions.checkNotNull(var2, "Required parameter id must be specified.");
         }

         public String getId() {
            return this.id;
         }

         public YouTube.Comments.Delete set(String var1, Object var2) {
            return (YouTube.Comments.Delete)super.set(var1, var2);
         }

         public YouTube.Comments.Delete setAlt(String var1) {
            return (YouTube.Comments.Delete)super.setAlt(var1);
         }

         public YouTube.Comments.Delete setFields(String var1) {
            return (YouTube.Comments.Delete)super.setFields(var1);
         }

         public YouTube.Comments.Delete setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.Comments.Delete setKey(String var1) {
            return (YouTube.Comments.Delete)super.setKey(var1);
         }

         public YouTube.Comments.Delete setOauthToken(String var1) {
            return (YouTube.Comments.Delete)super.setOauthToken(var1);
         }

         public YouTube.Comments.Delete setPrettyPrint(Boolean var1) {
            return (YouTube.Comments.Delete)super.setPrettyPrint(var1);
         }

         public YouTube.Comments.Delete setQuotaUser(String var1) {
            return (YouTube.Comments.Delete)super.setQuotaUser(var1);
         }

         public YouTube.Comments.Delete setUserIp(String var1) {
            return (YouTube.Comments.Delete)super.setUserIp(var1);
         }
      }

      public class Insert extends YouTubeRequest<Comment> {
         private static final String REST_PATH = "comments";
         @Key
         private String part;
         final YouTube.Comments this$1;

         protected Insert(YouTube.Comments var1, String var2, Comment var3) {
            super(var1.this$0, "POST", "comments", var3, Comment.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.Comments.Insert set(String var1, Object var2) {
            return (YouTube.Comments.Insert)super.set(var1, var2);
         }

         public YouTube.Comments.Insert setAlt(String var1) {
            return (YouTube.Comments.Insert)super.setAlt(var1);
         }

         public YouTube.Comments.Insert setFields(String var1) {
            return (YouTube.Comments.Insert)super.setFields(var1);
         }

         public YouTube.Comments.Insert setKey(String var1) {
            return (YouTube.Comments.Insert)super.setKey(var1);
         }

         public YouTube.Comments.Insert setOauthToken(String var1) {
            return (YouTube.Comments.Insert)super.setOauthToken(var1);
         }

         public YouTube.Comments.Insert setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.Comments.Insert setPrettyPrint(Boolean var1) {
            return (YouTube.Comments.Insert)super.setPrettyPrint(var1);
         }

         public YouTube.Comments.Insert setQuotaUser(String var1) {
            return (YouTube.Comments.Insert)super.setQuotaUser(var1);
         }

         public YouTube.Comments.Insert setUserIp(String var1) {
            return (YouTube.Comments.Insert)super.setUserIp(var1);
         }
      }

      public class List extends YouTubeRequest<CommentListResponse> {
         private static final String REST_PATH = "comments";
         @Key
         private String id;
         @Key
         private Long maxResults;
         @Key
         private String pageToken;
         @Key
         private String parentId;
         @Key
         private String part;
         @Key
         private String textFormat;
         final YouTube.Comments this$1;

         protected List(YouTube.Comments var1, String var2) {
            super(var1.this$0, "GET", "comments", null, CommentListResponse.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         @Override
         public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
         }

         @Override
         public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
         }

         public String getId() {
            return this.id;
         }

         public Long getMaxResults() {
            return this.maxResults;
         }

         public String getPageToken() {
            return this.pageToken;
         }

         public String getParentId() {
            return this.parentId;
         }

         public String getPart() {
            return this.part;
         }

         public String getTextFormat() {
            return this.textFormat;
         }

         public YouTube.Comments.List set(String var1, Object var2) {
            return (YouTube.Comments.List)super.set(var1, var2);
         }

         public YouTube.Comments.List setAlt(String var1) {
            return (YouTube.Comments.List)super.setAlt(var1);
         }

         public YouTube.Comments.List setFields(String var1) {
            return (YouTube.Comments.List)super.setFields(var1);
         }

         public YouTube.Comments.List setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.Comments.List setKey(String var1) {
            return (YouTube.Comments.List)super.setKey(var1);
         }

         public YouTube.Comments.List setMaxResults(Long var1) {
            this.maxResults = var1;
            return this;
         }

         public YouTube.Comments.List setOauthToken(String var1) {
            return (YouTube.Comments.List)super.setOauthToken(var1);
         }

         public YouTube.Comments.List setPageToken(String var1) {
            this.pageToken = var1;
            return this;
         }

         public YouTube.Comments.List setParentId(String var1) {
            this.parentId = var1;
            return this;
         }

         public YouTube.Comments.List setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.Comments.List setPrettyPrint(Boolean var1) {
            return (YouTube.Comments.List)super.setPrettyPrint(var1);
         }

         public YouTube.Comments.List setQuotaUser(String var1) {
            return (YouTube.Comments.List)super.setQuotaUser(var1);
         }

         public YouTube.Comments.List setTextFormat(String var1) {
            this.textFormat = var1;
            return this;
         }

         public YouTube.Comments.List setUserIp(String var1) {
            return (YouTube.Comments.List)super.setUserIp(var1);
         }
      }

      public class MarkAsSpam extends YouTubeRequest<Void> {
         private static final String REST_PATH = "comments/markAsSpam";
         @Key
         private String id;
         final YouTube.Comments this$1;

         protected MarkAsSpam(YouTube.Comments var1, String var2) {
            super(var1.this$0, "POST", "comments/markAsSpam", null, Void.class);
            this.this$1 = var1;
            this.id = Preconditions.checkNotNull(var2, "Required parameter id must be specified.");
         }

         public String getId() {
            return this.id;
         }

         public YouTube.Comments.MarkAsSpam set(String var1, Object var2) {
            return (YouTube.Comments.MarkAsSpam)super.set(var1, var2);
         }

         public YouTube.Comments.MarkAsSpam setAlt(String var1) {
            return (YouTube.Comments.MarkAsSpam)super.setAlt(var1);
         }

         public YouTube.Comments.MarkAsSpam setFields(String var1) {
            return (YouTube.Comments.MarkAsSpam)super.setFields(var1);
         }

         public YouTube.Comments.MarkAsSpam setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.Comments.MarkAsSpam setKey(String var1) {
            return (YouTube.Comments.MarkAsSpam)super.setKey(var1);
         }

         public YouTube.Comments.MarkAsSpam setOauthToken(String var1) {
            return (YouTube.Comments.MarkAsSpam)super.setOauthToken(var1);
         }

         public YouTube.Comments.MarkAsSpam setPrettyPrint(Boolean var1) {
            return (YouTube.Comments.MarkAsSpam)super.setPrettyPrint(var1);
         }

         public YouTube.Comments.MarkAsSpam setQuotaUser(String var1) {
            return (YouTube.Comments.MarkAsSpam)super.setQuotaUser(var1);
         }

         public YouTube.Comments.MarkAsSpam setUserIp(String var1) {
            return (YouTube.Comments.MarkAsSpam)super.setUserIp(var1);
         }
      }

      public class SetModerationStatus extends YouTubeRequest<Void> {
         private static final String REST_PATH = "comments/setModerationStatus";
         @Key
         private Boolean banAuthor;
         @Key
         private String id;
         @Key
         private String moderationStatus;
         final YouTube.Comments this$1;

         protected SetModerationStatus(YouTube.Comments var1, String var2, String var3) {
            super(var1.this$0, "POST", "comments/setModerationStatus", null, Void.class);
            this.this$1 = var1;
            this.id = Preconditions.checkNotNull(var2, "Required parameter id must be specified.");
            this.moderationStatus = Preconditions.checkNotNull(var3, "Required parameter moderationStatus must be specified.");
         }

         public Boolean getBanAuthor() {
            return this.banAuthor;
         }

         public String getId() {
            return this.id;
         }

         public String getModerationStatus() {
            return this.moderationStatus;
         }

         public boolean isBanAuthor() {
            boolean var1;
            if (this.banAuthor != null && this.banAuthor != Data.NULL_BOOLEAN) {
               var1 = this.banAuthor;
            } else {
               var1 = false;
            }

            return var1;
         }

         public YouTube.Comments.SetModerationStatus set(String var1, Object var2) {
            return (YouTube.Comments.SetModerationStatus)super.set(var1, var2);
         }

         public YouTube.Comments.SetModerationStatus setAlt(String var1) {
            return (YouTube.Comments.SetModerationStatus)super.setAlt(var1);
         }

         public YouTube.Comments.SetModerationStatus setBanAuthor(Boolean var1) {
            this.banAuthor = var1;
            return this;
         }

         public YouTube.Comments.SetModerationStatus setFields(String var1) {
            return (YouTube.Comments.SetModerationStatus)super.setFields(var1);
         }

         public YouTube.Comments.SetModerationStatus setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.Comments.SetModerationStatus setKey(String var1) {
            return (YouTube.Comments.SetModerationStatus)super.setKey(var1);
         }

         public YouTube.Comments.SetModerationStatus setModerationStatus(String var1) {
            this.moderationStatus = var1;
            return this;
         }

         public YouTube.Comments.SetModerationStatus setOauthToken(String var1) {
            return (YouTube.Comments.SetModerationStatus)super.setOauthToken(var1);
         }

         public YouTube.Comments.SetModerationStatus setPrettyPrint(Boolean var1) {
            return (YouTube.Comments.SetModerationStatus)super.setPrettyPrint(var1);
         }

         public YouTube.Comments.SetModerationStatus setQuotaUser(String var1) {
            return (YouTube.Comments.SetModerationStatus)super.setQuotaUser(var1);
         }

         public YouTube.Comments.SetModerationStatus setUserIp(String var1) {
            return (YouTube.Comments.SetModerationStatus)super.setUserIp(var1);
         }
      }

      public class Update extends YouTubeRequest<Comment> {
         private static final String REST_PATH = "comments";
         @Key
         private String part;
         final YouTube.Comments this$1;

         protected Update(YouTube.Comments var1, String var2, Comment var3) {
            super(var1.this$0, "PUT", "comments", var3, Comment.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.Comments.Update set(String var1, Object var2) {
            return (YouTube.Comments.Update)super.set(var1, var2);
         }

         public YouTube.Comments.Update setAlt(String var1) {
            return (YouTube.Comments.Update)super.setAlt(var1);
         }

         public YouTube.Comments.Update setFields(String var1) {
            return (YouTube.Comments.Update)super.setFields(var1);
         }

         public YouTube.Comments.Update setKey(String var1) {
            return (YouTube.Comments.Update)super.setKey(var1);
         }

         public YouTube.Comments.Update setOauthToken(String var1) {
            return (YouTube.Comments.Update)super.setOauthToken(var1);
         }

         public YouTube.Comments.Update setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.Comments.Update setPrettyPrint(Boolean var1) {
            return (YouTube.Comments.Update)super.setPrettyPrint(var1);
         }

         public YouTube.Comments.Update setQuotaUser(String var1) {
            return (YouTube.Comments.Update)super.setQuotaUser(var1);
         }

         public YouTube.Comments.Update setUserIp(String var1) {
            return (YouTube.Comments.Update)super.setUserIp(var1);
         }
      }
   }

   public class FanFundingEvents {
      final YouTube this$0;

      public FanFundingEvents(YouTube var1) {
         this.this$0 = var1;
      }

      public YouTube.FanFundingEvents.List list(String var1) throws IOException {
         YouTube.FanFundingEvents.List var2 = new YouTube.FanFundingEvents.List(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public class List extends YouTubeRequest<FanFundingEventListResponse> {
         private static final String REST_PATH = "fanFundingEvents";
         @Key
         private String hl;
         @Key
         private Long maxResults;
         @Key
         private String pageToken;
         @Key
         private String part;
         final YouTube.FanFundingEvents this$1;

         protected List(YouTube.FanFundingEvents var1, String var2) {
            super(var1.this$0, "GET", "fanFundingEvents", null, FanFundingEventListResponse.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         @Override
         public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
         }

         @Override
         public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
         }

         public String getHl() {
            return this.hl;
         }

         public Long getMaxResults() {
            return this.maxResults;
         }

         public String getPageToken() {
            return this.pageToken;
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.FanFundingEvents.List set(String var1, Object var2) {
            return (YouTube.FanFundingEvents.List)super.set(var1, var2);
         }

         public YouTube.FanFundingEvents.List setAlt(String var1) {
            return (YouTube.FanFundingEvents.List)super.setAlt(var1);
         }

         public YouTube.FanFundingEvents.List setFields(String var1) {
            return (YouTube.FanFundingEvents.List)super.setFields(var1);
         }

         public YouTube.FanFundingEvents.List setHl(String var1) {
            this.hl = var1;
            return this;
         }

         public YouTube.FanFundingEvents.List setKey(String var1) {
            return (YouTube.FanFundingEvents.List)super.setKey(var1);
         }

         public YouTube.FanFundingEvents.List setMaxResults(Long var1) {
            this.maxResults = var1;
            return this;
         }

         public YouTube.FanFundingEvents.List setOauthToken(String var1) {
            return (YouTube.FanFundingEvents.List)super.setOauthToken(var1);
         }

         public YouTube.FanFundingEvents.List setPageToken(String var1) {
            this.pageToken = var1;
            return this;
         }

         public YouTube.FanFundingEvents.List setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.FanFundingEvents.List setPrettyPrint(Boolean var1) {
            return (YouTube.FanFundingEvents.List)super.setPrettyPrint(var1);
         }

         public YouTube.FanFundingEvents.List setQuotaUser(String var1) {
            return (YouTube.FanFundingEvents.List)super.setQuotaUser(var1);
         }

         public YouTube.FanFundingEvents.List setUserIp(String var1) {
            return (YouTube.FanFundingEvents.List)super.setUserIp(var1);
         }
      }
   }

   public class GuideCategories {
      final YouTube this$0;

      public GuideCategories(YouTube var1) {
         this.this$0 = var1;
      }

      public YouTube.GuideCategories.List list(String var1) throws IOException {
         YouTube.GuideCategories.List var2 = new YouTube.GuideCategories.List(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public class List extends YouTubeRequest<GuideCategoryListResponse> {
         private static final String REST_PATH = "guideCategories";
         @Key
         private String hl;
         @Key
         private String id;
         @Key
         private String part;
         @Key
         private String regionCode;
         final YouTube.GuideCategories this$1;

         protected List(YouTube.GuideCategories var1, String var2) {
            super(var1.this$0, "GET", "guideCategories", null, GuideCategoryListResponse.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         @Override
         public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
         }

         @Override
         public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
         }

         public String getHl() {
            return this.hl;
         }

         public String getId() {
            return this.id;
         }

         public String getPart() {
            return this.part;
         }

         public String getRegionCode() {
            return this.regionCode;
         }

         public YouTube.GuideCategories.List set(String var1, Object var2) {
            return (YouTube.GuideCategories.List)super.set(var1, var2);
         }

         public YouTube.GuideCategories.List setAlt(String var1) {
            return (YouTube.GuideCategories.List)super.setAlt(var1);
         }

         public YouTube.GuideCategories.List setFields(String var1) {
            return (YouTube.GuideCategories.List)super.setFields(var1);
         }

         public YouTube.GuideCategories.List setHl(String var1) {
            this.hl = var1;
            return this;
         }

         public YouTube.GuideCategories.List setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.GuideCategories.List setKey(String var1) {
            return (YouTube.GuideCategories.List)super.setKey(var1);
         }

         public YouTube.GuideCategories.List setOauthToken(String var1) {
            return (YouTube.GuideCategories.List)super.setOauthToken(var1);
         }

         public YouTube.GuideCategories.List setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.GuideCategories.List setPrettyPrint(Boolean var1) {
            return (YouTube.GuideCategories.List)super.setPrettyPrint(var1);
         }

         public YouTube.GuideCategories.List setQuotaUser(String var1) {
            return (YouTube.GuideCategories.List)super.setQuotaUser(var1);
         }

         public YouTube.GuideCategories.List setRegionCode(String var1) {
            this.regionCode = var1;
            return this;
         }

         public YouTube.GuideCategories.List setUserIp(String var1) {
            return (YouTube.GuideCategories.List)super.setUserIp(var1);
         }
      }
   }

   public class I18nLanguages {
      final YouTube this$0;

      public I18nLanguages(YouTube var1) {
         this.this$0 = var1;
      }

      public YouTube.I18nLanguages.List list(String var1) throws IOException {
         YouTube.I18nLanguages.List var2 = new YouTube.I18nLanguages.List(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public class List extends YouTubeRequest<I18nLanguageListResponse> {
         private static final String REST_PATH = "i18nLanguages";
         @Key
         private String hl;
         @Key
         private String part;
         final YouTube.I18nLanguages this$1;

         protected List(YouTube.I18nLanguages var1, String var2) {
            super(var1.this$0, "GET", "i18nLanguages", null, I18nLanguageListResponse.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         @Override
         public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
         }

         @Override
         public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
         }

         public String getHl() {
            return this.hl;
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.I18nLanguages.List set(String var1, Object var2) {
            return (YouTube.I18nLanguages.List)super.set(var1, var2);
         }

         public YouTube.I18nLanguages.List setAlt(String var1) {
            return (YouTube.I18nLanguages.List)super.setAlt(var1);
         }

         public YouTube.I18nLanguages.List setFields(String var1) {
            return (YouTube.I18nLanguages.List)super.setFields(var1);
         }

         public YouTube.I18nLanguages.List setHl(String var1) {
            this.hl = var1;
            return this;
         }

         public YouTube.I18nLanguages.List setKey(String var1) {
            return (YouTube.I18nLanguages.List)super.setKey(var1);
         }

         public YouTube.I18nLanguages.List setOauthToken(String var1) {
            return (YouTube.I18nLanguages.List)super.setOauthToken(var1);
         }

         public YouTube.I18nLanguages.List setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.I18nLanguages.List setPrettyPrint(Boolean var1) {
            return (YouTube.I18nLanguages.List)super.setPrettyPrint(var1);
         }

         public YouTube.I18nLanguages.List setQuotaUser(String var1) {
            return (YouTube.I18nLanguages.List)super.setQuotaUser(var1);
         }

         public YouTube.I18nLanguages.List setUserIp(String var1) {
            return (YouTube.I18nLanguages.List)super.setUserIp(var1);
         }
      }
   }

   public class I18nRegions {
      final YouTube this$0;

      public I18nRegions(YouTube var1) {
         this.this$0 = var1;
      }

      public YouTube.I18nRegions.List list(String var1) throws IOException {
         YouTube.I18nRegions.List var2 = new YouTube.I18nRegions.List(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public class List extends YouTubeRequest<I18nRegionListResponse> {
         private static final String REST_PATH = "i18nRegions";
         @Key
         private String hl;
         @Key
         private String part;
         final YouTube.I18nRegions this$1;

         protected List(YouTube.I18nRegions var1, String var2) {
            super(var1.this$0, "GET", "i18nRegions", null, I18nRegionListResponse.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         @Override
         public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
         }

         @Override
         public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
         }

         public String getHl() {
            return this.hl;
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.I18nRegions.List set(String var1, Object var2) {
            return (YouTube.I18nRegions.List)super.set(var1, var2);
         }

         public YouTube.I18nRegions.List setAlt(String var1) {
            return (YouTube.I18nRegions.List)super.setAlt(var1);
         }

         public YouTube.I18nRegions.List setFields(String var1) {
            return (YouTube.I18nRegions.List)super.setFields(var1);
         }

         public YouTube.I18nRegions.List setHl(String var1) {
            this.hl = var1;
            return this;
         }

         public YouTube.I18nRegions.List setKey(String var1) {
            return (YouTube.I18nRegions.List)super.setKey(var1);
         }

         public YouTube.I18nRegions.List setOauthToken(String var1) {
            return (YouTube.I18nRegions.List)super.setOauthToken(var1);
         }

         public YouTube.I18nRegions.List setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.I18nRegions.List setPrettyPrint(Boolean var1) {
            return (YouTube.I18nRegions.List)super.setPrettyPrint(var1);
         }

         public YouTube.I18nRegions.List setQuotaUser(String var1) {
            return (YouTube.I18nRegions.List)super.setQuotaUser(var1);
         }

         public YouTube.I18nRegions.List setUserIp(String var1) {
            return (YouTube.I18nRegions.List)super.setUserIp(var1);
         }
      }
   }

   public class LiveBroadcasts {
      final YouTube this$0;

      public LiveBroadcasts(YouTube var1) {
         this.this$0 = var1;
      }

      public YouTube.LiveBroadcasts.Bind bind(String var1, String var2) throws IOException {
         YouTube.LiveBroadcasts.Bind var3 = new YouTube.LiveBroadcasts.Bind(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public YouTube.LiveBroadcasts.Control control(String var1, String var2) throws IOException {
         YouTube.LiveBroadcasts.Control var3 = new YouTube.LiveBroadcasts.Control(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public YouTube.LiveBroadcasts.Delete delete(String var1) throws IOException {
         YouTube.LiveBroadcasts.Delete var2 = new YouTube.LiveBroadcasts.Delete(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public YouTube.LiveBroadcasts.Insert insert(String var1, LiveBroadcast var2) throws IOException {
         YouTube.LiveBroadcasts.Insert var3 = new YouTube.LiveBroadcasts.Insert(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public YouTube.LiveBroadcasts.List list(String var1) throws IOException {
         YouTube.LiveBroadcasts.List var2 = new YouTube.LiveBroadcasts.List(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public YouTube.LiveBroadcasts.Transition transition(String var1, String var2, String var3) throws IOException {
         YouTube.LiveBroadcasts.Transition var4 = new YouTube.LiveBroadcasts.Transition(this, var1, var2, var3);
         this.this$0.initialize(var4);
         return var4;
      }

      public YouTube.LiveBroadcasts.Update update(String var1, LiveBroadcast var2) throws IOException {
         YouTube.LiveBroadcasts.Update var3 = new YouTube.LiveBroadcasts.Update(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public class Bind extends YouTubeRequest<LiveBroadcast> {
         private static final String REST_PATH = "liveBroadcasts/bind";
         @Key
         private String id;
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String onBehalfOfContentOwnerChannel;
         @Key
         private String part;
         @Key
         private String streamId;
         final YouTube.LiveBroadcasts this$1;

         protected Bind(YouTube.LiveBroadcasts var1, String var2, String var3) {
            super(var1.this$0, "POST", "liveBroadcasts/bind", null, LiveBroadcast.class);
            this.this$1 = var1;
            this.id = Preconditions.checkNotNull(var2, "Required parameter id must be specified.");
            this.part = Preconditions.checkNotNull(var3, "Required parameter part must be specified.");
         }

         public String getId() {
            return this.id;
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getOnBehalfOfContentOwnerChannel() {
            return this.onBehalfOfContentOwnerChannel;
         }

         public String getPart() {
            return this.part;
         }

         public String getStreamId() {
            return this.streamId;
         }

         public YouTube.LiveBroadcasts.Bind set(String var1, Object var2) {
            return (YouTube.LiveBroadcasts.Bind)super.set(var1, var2);
         }

         public YouTube.LiveBroadcasts.Bind setAlt(String var1) {
            return (YouTube.LiveBroadcasts.Bind)super.setAlt(var1);
         }

         public YouTube.LiveBroadcasts.Bind setFields(String var1) {
            return (YouTube.LiveBroadcasts.Bind)super.setFields(var1);
         }

         public YouTube.LiveBroadcasts.Bind setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.Bind setKey(String var1) {
            return (YouTube.LiveBroadcasts.Bind)super.setKey(var1);
         }

         public YouTube.LiveBroadcasts.Bind setOauthToken(String var1) {
            return (YouTube.LiveBroadcasts.Bind)super.setOauthToken(var1);
         }

         public YouTube.LiveBroadcasts.Bind setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.Bind setOnBehalfOfContentOwnerChannel(String var1) {
            this.onBehalfOfContentOwnerChannel = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.Bind setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.Bind setPrettyPrint(Boolean var1) {
            return (YouTube.LiveBroadcasts.Bind)super.setPrettyPrint(var1);
         }

         public YouTube.LiveBroadcasts.Bind setQuotaUser(String var1) {
            return (YouTube.LiveBroadcasts.Bind)super.setQuotaUser(var1);
         }

         public YouTube.LiveBroadcasts.Bind setStreamId(String var1) {
            this.streamId = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.Bind setUserIp(String var1) {
            return (YouTube.LiveBroadcasts.Bind)super.setUserIp(var1);
         }
      }

      public class Control extends YouTubeRequest<LiveBroadcast> {
         private static final String REST_PATH = "liveBroadcasts/control";
         @Key
         private Boolean displaySlate;
         @Key
         private String id;
         @Key
         private BigInteger offsetTimeMs;
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String onBehalfOfContentOwnerChannel;
         @Key
         private String part;
         final YouTube.LiveBroadcasts this$1;
         @Key
         private DateTime walltime;

         protected Control(YouTube.LiveBroadcasts var1, String var2, String var3) {
            super(var1.this$0, "POST", "liveBroadcasts/control", null, LiveBroadcast.class);
            this.this$1 = var1;
            this.id = Preconditions.checkNotNull(var2, "Required parameter id must be specified.");
            this.part = Preconditions.checkNotNull(var3, "Required parameter part must be specified.");
         }

         public Boolean getDisplaySlate() {
            return this.displaySlate;
         }

         public String getId() {
            return this.id;
         }

         public BigInteger getOffsetTimeMs() {
            return this.offsetTimeMs;
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getOnBehalfOfContentOwnerChannel() {
            return this.onBehalfOfContentOwnerChannel;
         }

         public String getPart() {
            return this.part;
         }

         public DateTime getWalltime() {
            return this.walltime;
         }

         public YouTube.LiveBroadcasts.Control set(String var1, Object var2) {
            return (YouTube.LiveBroadcasts.Control)super.set(var1, var2);
         }

         public YouTube.LiveBroadcasts.Control setAlt(String var1) {
            return (YouTube.LiveBroadcasts.Control)super.setAlt(var1);
         }

         public YouTube.LiveBroadcasts.Control setDisplaySlate(Boolean var1) {
            this.displaySlate = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.Control setFields(String var1) {
            return (YouTube.LiveBroadcasts.Control)super.setFields(var1);
         }

         public YouTube.LiveBroadcasts.Control setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.Control setKey(String var1) {
            return (YouTube.LiveBroadcasts.Control)super.setKey(var1);
         }

         public YouTube.LiveBroadcasts.Control setOauthToken(String var1) {
            return (YouTube.LiveBroadcasts.Control)super.setOauthToken(var1);
         }

         public YouTube.LiveBroadcasts.Control setOffsetTimeMs(BigInteger var1) {
            this.offsetTimeMs = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.Control setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.Control setOnBehalfOfContentOwnerChannel(String var1) {
            this.onBehalfOfContentOwnerChannel = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.Control setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.Control setPrettyPrint(Boolean var1) {
            return (YouTube.LiveBroadcasts.Control)super.setPrettyPrint(var1);
         }

         public YouTube.LiveBroadcasts.Control setQuotaUser(String var1) {
            return (YouTube.LiveBroadcasts.Control)super.setQuotaUser(var1);
         }

         public YouTube.LiveBroadcasts.Control setUserIp(String var1) {
            return (YouTube.LiveBroadcasts.Control)super.setUserIp(var1);
         }

         public YouTube.LiveBroadcasts.Control setWalltime(DateTime var1) {
            this.walltime = var1;
            return this;
         }
      }

      public class Delete extends YouTubeRequest<Void> {
         private static final String REST_PATH = "liveBroadcasts";
         @Key
         private String id;
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String onBehalfOfContentOwnerChannel;
         final YouTube.LiveBroadcasts this$1;

         protected Delete(YouTube.LiveBroadcasts var1, String var2) {
            super(var1.this$0, "DELETE", "liveBroadcasts", null, Void.class);
            this.this$1 = var1;
            this.id = Preconditions.checkNotNull(var2, "Required parameter id must be specified.");
         }

         public String getId() {
            return this.id;
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getOnBehalfOfContentOwnerChannel() {
            return this.onBehalfOfContentOwnerChannel;
         }

         public YouTube.LiveBroadcasts.Delete set(String var1, Object var2) {
            return (YouTube.LiveBroadcasts.Delete)super.set(var1, var2);
         }

         public YouTube.LiveBroadcasts.Delete setAlt(String var1) {
            return (YouTube.LiveBroadcasts.Delete)super.setAlt(var1);
         }

         public YouTube.LiveBroadcasts.Delete setFields(String var1) {
            return (YouTube.LiveBroadcasts.Delete)super.setFields(var1);
         }

         public YouTube.LiveBroadcasts.Delete setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.Delete setKey(String var1) {
            return (YouTube.LiveBroadcasts.Delete)super.setKey(var1);
         }

         public YouTube.LiveBroadcasts.Delete setOauthToken(String var1) {
            return (YouTube.LiveBroadcasts.Delete)super.setOauthToken(var1);
         }

         public YouTube.LiveBroadcasts.Delete setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.Delete setOnBehalfOfContentOwnerChannel(String var1) {
            this.onBehalfOfContentOwnerChannel = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.Delete setPrettyPrint(Boolean var1) {
            return (YouTube.LiveBroadcasts.Delete)super.setPrettyPrint(var1);
         }

         public YouTube.LiveBroadcasts.Delete setQuotaUser(String var1) {
            return (YouTube.LiveBroadcasts.Delete)super.setQuotaUser(var1);
         }

         public YouTube.LiveBroadcasts.Delete setUserIp(String var1) {
            return (YouTube.LiveBroadcasts.Delete)super.setUserIp(var1);
         }
      }

      public class Insert extends YouTubeRequest<LiveBroadcast> {
         private static final String REST_PATH = "liveBroadcasts";
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String onBehalfOfContentOwnerChannel;
         @Key
         private String part;
         final YouTube.LiveBroadcasts this$1;

         protected Insert(YouTube.LiveBroadcasts var1, String var2, LiveBroadcast var3) {
            super(var1.this$0, "POST", "liveBroadcasts", var3, LiveBroadcast.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getOnBehalfOfContentOwnerChannel() {
            return this.onBehalfOfContentOwnerChannel;
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.LiveBroadcasts.Insert set(String var1, Object var2) {
            return (YouTube.LiveBroadcasts.Insert)super.set(var1, var2);
         }

         public YouTube.LiveBroadcasts.Insert setAlt(String var1) {
            return (YouTube.LiveBroadcasts.Insert)super.setAlt(var1);
         }

         public YouTube.LiveBroadcasts.Insert setFields(String var1) {
            return (YouTube.LiveBroadcasts.Insert)super.setFields(var1);
         }

         public YouTube.LiveBroadcasts.Insert setKey(String var1) {
            return (YouTube.LiveBroadcasts.Insert)super.setKey(var1);
         }

         public YouTube.LiveBroadcasts.Insert setOauthToken(String var1) {
            return (YouTube.LiveBroadcasts.Insert)super.setOauthToken(var1);
         }

         public YouTube.LiveBroadcasts.Insert setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.Insert setOnBehalfOfContentOwnerChannel(String var1) {
            this.onBehalfOfContentOwnerChannel = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.Insert setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.Insert setPrettyPrint(Boolean var1) {
            return (YouTube.LiveBroadcasts.Insert)super.setPrettyPrint(var1);
         }

         public YouTube.LiveBroadcasts.Insert setQuotaUser(String var1) {
            return (YouTube.LiveBroadcasts.Insert)super.setQuotaUser(var1);
         }

         public YouTube.LiveBroadcasts.Insert setUserIp(String var1) {
            return (YouTube.LiveBroadcasts.Insert)super.setUserIp(var1);
         }
      }

      public class List extends YouTubeRequest<LiveBroadcastListResponse> {
         private static final String REST_PATH = "liveBroadcasts";
         @Key
         private String broadcastStatus;
         @Key
         private String broadcastType;
         @Key
         private String id;
         @Key
         private Long maxResults;
         @Key
         private Boolean mine;
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String onBehalfOfContentOwnerChannel;
         @Key
         private String pageToken;
         @Key
         private String part;
         final YouTube.LiveBroadcasts this$1;

         protected List(YouTube.LiveBroadcasts var1, String var2) {
            super(var1.this$0, "GET", "liveBroadcasts", null, LiveBroadcastListResponse.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         @Override
         public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
         }

         @Override
         public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
         }

         public String getBroadcastStatus() {
            return this.broadcastStatus;
         }

         public String getBroadcastType() {
            return this.broadcastType;
         }

         public String getId() {
            return this.id;
         }

         public Long getMaxResults() {
            return this.maxResults;
         }

         public Boolean getMine() {
            return this.mine;
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getOnBehalfOfContentOwnerChannel() {
            return this.onBehalfOfContentOwnerChannel;
         }

         public String getPageToken() {
            return this.pageToken;
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.LiveBroadcasts.List set(String var1, Object var2) {
            return (YouTube.LiveBroadcasts.List)super.set(var1, var2);
         }

         public YouTube.LiveBroadcasts.List setAlt(String var1) {
            return (YouTube.LiveBroadcasts.List)super.setAlt(var1);
         }

         public YouTube.LiveBroadcasts.List setBroadcastStatus(String var1) {
            this.broadcastStatus = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.List setBroadcastType(String var1) {
            this.broadcastType = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.List setFields(String var1) {
            return (YouTube.LiveBroadcasts.List)super.setFields(var1);
         }

         public YouTube.LiveBroadcasts.List setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.List setKey(String var1) {
            return (YouTube.LiveBroadcasts.List)super.setKey(var1);
         }

         public YouTube.LiveBroadcasts.List setMaxResults(Long var1) {
            this.maxResults = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.List setMine(Boolean var1) {
            this.mine = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.List setOauthToken(String var1) {
            return (YouTube.LiveBroadcasts.List)super.setOauthToken(var1);
         }

         public YouTube.LiveBroadcasts.List setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.List setOnBehalfOfContentOwnerChannel(String var1) {
            this.onBehalfOfContentOwnerChannel = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.List setPageToken(String var1) {
            this.pageToken = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.List setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.List setPrettyPrint(Boolean var1) {
            return (YouTube.LiveBroadcasts.List)super.setPrettyPrint(var1);
         }

         public YouTube.LiveBroadcasts.List setQuotaUser(String var1) {
            return (YouTube.LiveBroadcasts.List)super.setQuotaUser(var1);
         }

         public YouTube.LiveBroadcasts.List setUserIp(String var1) {
            return (YouTube.LiveBroadcasts.List)super.setUserIp(var1);
         }
      }

      public class Transition extends YouTubeRequest<LiveBroadcast> {
         private static final String REST_PATH = "liveBroadcasts/transition";
         @Key
         private String broadcastStatus;
         @Key
         private String id;
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String onBehalfOfContentOwnerChannel;
         @Key
         private String part;
         final YouTube.LiveBroadcasts this$1;

         protected Transition(YouTube.LiveBroadcasts var1, String var2, String var3, String var4) {
            super(var1.this$0, "POST", "liveBroadcasts/transition", null, LiveBroadcast.class);
            this.this$1 = var1;
            this.broadcastStatus = Preconditions.checkNotNull(var2, "Required parameter broadcastStatus must be specified.");
            this.id = Preconditions.checkNotNull(var3, "Required parameter id must be specified.");
            this.part = Preconditions.checkNotNull(var4, "Required parameter part must be specified.");
         }

         public String getBroadcastStatus() {
            return this.broadcastStatus;
         }

         public String getId() {
            return this.id;
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getOnBehalfOfContentOwnerChannel() {
            return this.onBehalfOfContentOwnerChannel;
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.LiveBroadcasts.Transition set(String var1, Object var2) {
            return (YouTube.LiveBroadcasts.Transition)super.set(var1, var2);
         }

         public YouTube.LiveBroadcasts.Transition setAlt(String var1) {
            return (YouTube.LiveBroadcasts.Transition)super.setAlt(var1);
         }

         public YouTube.LiveBroadcasts.Transition setBroadcastStatus(String var1) {
            this.broadcastStatus = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.Transition setFields(String var1) {
            return (YouTube.LiveBroadcasts.Transition)super.setFields(var1);
         }

         public YouTube.LiveBroadcasts.Transition setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.Transition setKey(String var1) {
            return (YouTube.LiveBroadcasts.Transition)super.setKey(var1);
         }

         public YouTube.LiveBroadcasts.Transition setOauthToken(String var1) {
            return (YouTube.LiveBroadcasts.Transition)super.setOauthToken(var1);
         }

         public YouTube.LiveBroadcasts.Transition setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.Transition setOnBehalfOfContentOwnerChannel(String var1) {
            this.onBehalfOfContentOwnerChannel = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.Transition setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.Transition setPrettyPrint(Boolean var1) {
            return (YouTube.LiveBroadcasts.Transition)super.setPrettyPrint(var1);
         }

         public YouTube.LiveBroadcasts.Transition setQuotaUser(String var1) {
            return (YouTube.LiveBroadcasts.Transition)super.setQuotaUser(var1);
         }

         public YouTube.LiveBroadcasts.Transition setUserIp(String var1) {
            return (YouTube.LiveBroadcasts.Transition)super.setUserIp(var1);
         }
      }

      public class Update extends YouTubeRequest<LiveBroadcast> {
         private static final String REST_PATH = "liveBroadcasts";
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String onBehalfOfContentOwnerChannel;
         @Key
         private String part;
         final YouTube.LiveBroadcasts this$1;

         protected Update(YouTube.LiveBroadcasts var1, String var2, LiveBroadcast var3) {
            super(var1.this$0, "PUT", "liveBroadcasts", var3, LiveBroadcast.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
            this.checkRequiredParameter(var3, "content");
            this.checkRequiredParameter(var3.getId(), "LiveBroadcast.getId()");
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getOnBehalfOfContentOwnerChannel() {
            return this.onBehalfOfContentOwnerChannel;
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.LiveBroadcasts.Update set(String var1, Object var2) {
            return (YouTube.LiveBroadcasts.Update)super.set(var1, var2);
         }

         public YouTube.LiveBroadcasts.Update setAlt(String var1) {
            return (YouTube.LiveBroadcasts.Update)super.setAlt(var1);
         }

         public YouTube.LiveBroadcasts.Update setFields(String var1) {
            return (YouTube.LiveBroadcasts.Update)super.setFields(var1);
         }

         public YouTube.LiveBroadcasts.Update setKey(String var1) {
            return (YouTube.LiveBroadcasts.Update)super.setKey(var1);
         }

         public YouTube.LiveBroadcasts.Update setOauthToken(String var1) {
            return (YouTube.LiveBroadcasts.Update)super.setOauthToken(var1);
         }

         public YouTube.LiveBroadcasts.Update setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.Update setOnBehalfOfContentOwnerChannel(String var1) {
            this.onBehalfOfContentOwnerChannel = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.Update setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.LiveBroadcasts.Update setPrettyPrint(Boolean var1) {
            return (YouTube.LiveBroadcasts.Update)super.setPrettyPrint(var1);
         }

         public YouTube.LiveBroadcasts.Update setQuotaUser(String var1) {
            return (YouTube.LiveBroadcasts.Update)super.setQuotaUser(var1);
         }

         public YouTube.LiveBroadcasts.Update setUserIp(String var1) {
            return (YouTube.LiveBroadcasts.Update)super.setUserIp(var1);
         }
      }
   }

   public class LiveChatBans {
      final YouTube this$0;

      public LiveChatBans(YouTube var1) {
         this.this$0 = var1;
      }

      public YouTube.LiveChatBans.Delete delete(String var1) throws IOException {
         YouTube.LiveChatBans.Delete var2 = new YouTube.LiveChatBans.Delete(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public YouTube.LiveChatBans.Insert insert(String var1, LiveChatBan var2) throws IOException {
         YouTube.LiveChatBans.Insert var3 = new YouTube.LiveChatBans.Insert(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public class Delete extends YouTubeRequest<Void> {
         private static final String REST_PATH = "liveChat/bans";
         @Key
         private String id;
         final YouTube.LiveChatBans this$1;

         protected Delete(YouTube.LiveChatBans var1, String var2) {
            super(var1.this$0, "DELETE", "liveChat/bans", null, Void.class);
            this.this$1 = var1;
            this.id = Preconditions.checkNotNull(var2, "Required parameter id must be specified.");
         }

         public String getId() {
            return this.id;
         }

         public YouTube.LiveChatBans.Delete set(String var1, Object var2) {
            return (YouTube.LiveChatBans.Delete)super.set(var1, var2);
         }

         public YouTube.LiveChatBans.Delete setAlt(String var1) {
            return (YouTube.LiveChatBans.Delete)super.setAlt(var1);
         }

         public YouTube.LiveChatBans.Delete setFields(String var1) {
            return (YouTube.LiveChatBans.Delete)super.setFields(var1);
         }

         public YouTube.LiveChatBans.Delete setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.LiveChatBans.Delete setKey(String var1) {
            return (YouTube.LiveChatBans.Delete)super.setKey(var1);
         }

         public YouTube.LiveChatBans.Delete setOauthToken(String var1) {
            return (YouTube.LiveChatBans.Delete)super.setOauthToken(var1);
         }

         public YouTube.LiveChatBans.Delete setPrettyPrint(Boolean var1) {
            return (YouTube.LiveChatBans.Delete)super.setPrettyPrint(var1);
         }

         public YouTube.LiveChatBans.Delete setQuotaUser(String var1) {
            return (YouTube.LiveChatBans.Delete)super.setQuotaUser(var1);
         }

         public YouTube.LiveChatBans.Delete setUserIp(String var1) {
            return (YouTube.LiveChatBans.Delete)super.setUserIp(var1);
         }
      }

      public class Insert extends YouTubeRequest<LiveChatBan> {
         private static final String REST_PATH = "liveChat/bans";
         @Key
         private String part;
         final YouTube.LiveChatBans this$1;

         protected Insert(YouTube.LiveChatBans var1, String var2, LiveChatBan var3) {
            super(var1.this$0, "POST", "liveChat/bans", var3, LiveChatBan.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.LiveChatBans.Insert set(String var1, Object var2) {
            return (YouTube.LiveChatBans.Insert)super.set(var1, var2);
         }

         public YouTube.LiveChatBans.Insert setAlt(String var1) {
            return (YouTube.LiveChatBans.Insert)super.setAlt(var1);
         }

         public YouTube.LiveChatBans.Insert setFields(String var1) {
            return (YouTube.LiveChatBans.Insert)super.setFields(var1);
         }

         public YouTube.LiveChatBans.Insert setKey(String var1) {
            return (YouTube.LiveChatBans.Insert)super.setKey(var1);
         }

         public YouTube.LiveChatBans.Insert setOauthToken(String var1) {
            return (YouTube.LiveChatBans.Insert)super.setOauthToken(var1);
         }

         public YouTube.LiveChatBans.Insert setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.LiveChatBans.Insert setPrettyPrint(Boolean var1) {
            return (YouTube.LiveChatBans.Insert)super.setPrettyPrint(var1);
         }

         public YouTube.LiveChatBans.Insert setQuotaUser(String var1) {
            return (YouTube.LiveChatBans.Insert)super.setQuotaUser(var1);
         }

         public YouTube.LiveChatBans.Insert setUserIp(String var1) {
            return (YouTube.LiveChatBans.Insert)super.setUserIp(var1);
         }
      }
   }

   public class LiveChatMessages {
      final YouTube this$0;

      public LiveChatMessages(YouTube var1) {
         this.this$0 = var1;
      }

      public YouTube.LiveChatMessages.Delete delete(String var1) throws IOException {
         YouTube.LiveChatMessages.Delete var2 = new YouTube.LiveChatMessages.Delete(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public YouTube.LiveChatMessages.Insert insert(String var1, LiveChatMessage var2) throws IOException {
         YouTube.LiveChatMessages.Insert var3 = new YouTube.LiveChatMessages.Insert(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public YouTube.LiveChatMessages.List list(String var1, String var2) throws IOException {
         YouTube.LiveChatMessages.List var3 = new YouTube.LiveChatMessages.List(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public class Delete extends YouTubeRequest<Void> {
         private static final String REST_PATH = "liveChat/messages";
         @Key
         private String id;
         final YouTube.LiveChatMessages this$1;

         protected Delete(YouTube.LiveChatMessages var1, String var2) {
            super(var1.this$0, "DELETE", "liveChat/messages", null, Void.class);
            this.this$1 = var1;
            this.id = Preconditions.checkNotNull(var2, "Required parameter id must be specified.");
         }

         public String getId() {
            return this.id;
         }

         public YouTube.LiveChatMessages.Delete set(String var1, Object var2) {
            return (YouTube.LiveChatMessages.Delete)super.set(var1, var2);
         }

         public YouTube.LiveChatMessages.Delete setAlt(String var1) {
            return (YouTube.LiveChatMessages.Delete)super.setAlt(var1);
         }

         public YouTube.LiveChatMessages.Delete setFields(String var1) {
            return (YouTube.LiveChatMessages.Delete)super.setFields(var1);
         }

         public YouTube.LiveChatMessages.Delete setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.LiveChatMessages.Delete setKey(String var1) {
            return (YouTube.LiveChatMessages.Delete)super.setKey(var1);
         }

         public YouTube.LiveChatMessages.Delete setOauthToken(String var1) {
            return (YouTube.LiveChatMessages.Delete)super.setOauthToken(var1);
         }

         public YouTube.LiveChatMessages.Delete setPrettyPrint(Boolean var1) {
            return (YouTube.LiveChatMessages.Delete)super.setPrettyPrint(var1);
         }

         public YouTube.LiveChatMessages.Delete setQuotaUser(String var1) {
            return (YouTube.LiveChatMessages.Delete)super.setQuotaUser(var1);
         }

         public YouTube.LiveChatMessages.Delete setUserIp(String var1) {
            return (YouTube.LiveChatMessages.Delete)super.setUserIp(var1);
         }
      }

      public class Insert extends YouTubeRequest<LiveChatMessage> {
         private static final String REST_PATH = "liveChat/messages";
         @Key
         private String part;
         final YouTube.LiveChatMessages this$1;

         protected Insert(YouTube.LiveChatMessages var1, String var2, LiveChatMessage var3) {
            super(var1.this$0, "POST", "liveChat/messages", var3, LiveChatMessage.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.LiveChatMessages.Insert set(String var1, Object var2) {
            return (YouTube.LiveChatMessages.Insert)super.set(var1, var2);
         }

         public YouTube.LiveChatMessages.Insert setAlt(String var1) {
            return (YouTube.LiveChatMessages.Insert)super.setAlt(var1);
         }

         public YouTube.LiveChatMessages.Insert setFields(String var1) {
            return (YouTube.LiveChatMessages.Insert)super.setFields(var1);
         }

         public YouTube.LiveChatMessages.Insert setKey(String var1) {
            return (YouTube.LiveChatMessages.Insert)super.setKey(var1);
         }

         public YouTube.LiveChatMessages.Insert setOauthToken(String var1) {
            return (YouTube.LiveChatMessages.Insert)super.setOauthToken(var1);
         }

         public YouTube.LiveChatMessages.Insert setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.LiveChatMessages.Insert setPrettyPrint(Boolean var1) {
            return (YouTube.LiveChatMessages.Insert)super.setPrettyPrint(var1);
         }

         public YouTube.LiveChatMessages.Insert setQuotaUser(String var1) {
            return (YouTube.LiveChatMessages.Insert)super.setQuotaUser(var1);
         }

         public YouTube.LiveChatMessages.Insert setUserIp(String var1) {
            return (YouTube.LiveChatMessages.Insert)super.setUserIp(var1);
         }
      }

      public class List extends YouTubeRequest<LiveChatMessageListResponse> {
         private static final String REST_PATH = "liveChat/messages";
         @Key
         private String hl;
         @Key
         private String liveChatId;
         @Key
         private Long maxResults;
         @Key
         private String pageToken;
         @Key
         private String part;
         @Key
         private Long profileImageSize;
         final YouTube.LiveChatMessages this$1;

         protected List(YouTube.LiveChatMessages var1, String var2, String var3) {
            super(var1.this$0, "GET", "liveChat/messages", null, LiveChatMessageListResponse.class);
            this.this$1 = var1;
            this.liveChatId = Preconditions.checkNotNull(var2, "Required parameter liveChatId must be specified.");
            this.part = Preconditions.checkNotNull(var3, "Required parameter part must be specified.");
         }

         @Override
         public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
         }

         @Override
         public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
         }

         public String getHl() {
            return this.hl;
         }

         public String getLiveChatId() {
            return this.liveChatId;
         }

         public Long getMaxResults() {
            return this.maxResults;
         }

         public String getPageToken() {
            return this.pageToken;
         }

         public String getPart() {
            return this.part;
         }

         public Long getProfileImageSize() {
            return this.profileImageSize;
         }

         public YouTube.LiveChatMessages.List set(String var1, Object var2) {
            return (YouTube.LiveChatMessages.List)super.set(var1, var2);
         }

         public YouTube.LiveChatMessages.List setAlt(String var1) {
            return (YouTube.LiveChatMessages.List)super.setAlt(var1);
         }

         public YouTube.LiveChatMessages.List setFields(String var1) {
            return (YouTube.LiveChatMessages.List)super.setFields(var1);
         }

         public YouTube.LiveChatMessages.List setHl(String var1) {
            this.hl = var1;
            return this;
         }

         public YouTube.LiveChatMessages.List setKey(String var1) {
            return (YouTube.LiveChatMessages.List)super.setKey(var1);
         }

         public YouTube.LiveChatMessages.List setLiveChatId(String var1) {
            this.liveChatId = var1;
            return this;
         }

         public YouTube.LiveChatMessages.List setMaxResults(Long var1) {
            this.maxResults = var1;
            return this;
         }

         public YouTube.LiveChatMessages.List setOauthToken(String var1) {
            return (YouTube.LiveChatMessages.List)super.setOauthToken(var1);
         }

         public YouTube.LiveChatMessages.List setPageToken(String var1) {
            this.pageToken = var1;
            return this;
         }

         public YouTube.LiveChatMessages.List setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.LiveChatMessages.List setPrettyPrint(Boolean var1) {
            return (YouTube.LiveChatMessages.List)super.setPrettyPrint(var1);
         }

         public YouTube.LiveChatMessages.List setProfileImageSize(Long var1) {
            this.profileImageSize = var1;
            return this;
         }

         public YouTube.LiveChatMessages.List setQuotaUser(String var1) {
            return (YouTube.LiveChatMessages.List)super.setQuotaUser(var1);
         }

         public YouTube.LiveChatMessages.List setUserIp(String var1) {
            return (YouTube.LiveChatMessages.List)super.setUserIp(var1);
         }
      }
   }

   public class LiveChatModerators {
      final YouTube this$0;

      public LiveChatModerators(YouTube var1) {
         this.this$0 = var1;
      }

      public YouTube.LiveChatModerators.Delete delete(String var1) throws IOException {
         YouTube.LiveChatModerators.Delete var2 = new YouTube.LiveChatModerators.Delete(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public YouTube.LiveChatModerators.Insert insert(String var1, LiveChatModerator var2) throws IOException {
         YouTube.LiveChatModerators.Insert var3 = new YouTube.LiveChatModerators.Insert(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public YouTube.LiveChatModerators.List list(String var1, String var2) throws IOException {
         YouTube.LiveChatModerators.List var3 = new YouTube.LiveChatModerators.List(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public class Delete extends YouTubeRequest<Void> {
         private static final String REST_PATH = "liveChat/moderators";
         @Key
         private String id;
         final YouTube.LiveChatModerators this$1;

         protected Delete(YouTube.LiveChatModerators var1, String var2) {
            super(var1.this$0, "DELETE", "liveChat/moderators", null, Void.class);
            this.this$1 = var1;
            this.id = Preconditions.checkNotNull(var2, "Required parameter id must be specified.");
         }

         public String getId() {
            return this.id;
         }

         public YouTube.LiveChatModerators.Delete set(String var1, Object var2) {
            return (YouTube.LiveChatModerators.Delete)super.set(var1, var2);
         }

         public YouTube.LiveChatModerators.Delete setAlt(String var1) {
            return (YouTube.LiveChatModerators.Delete)super.setAlt(var1);
         }

         public YouTube.LiveChatModerators.Delete setFields(String var1) {
            return (YouTube.LiveChatModerators.Delete)super.setFields(var1);
         }

         public YouTube.LiveChatModerators.Delete setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.LiveChatModerators.Delete setKey(String var1) {
            return (YouTube.LiveChatModerators.Delete)super.setKey(var1);
         }

         public YouTube.LiveChatModerators.Delete setOauthToken(String var1) {
            return (YouTube.LiveChatModerators.Delete)super.setOauthToken(var1);
         }

         public YouTube.LiveChatModerators.Delete setPrettyPrint(Boolean var1) {
            return (YouTube.LiveChatModerators.Delete)super.setPrettyPrint(var1);
         }

         public YouTube.LiveChatModerators.Delete setQuotaUser(String var1) {
            return (YouTube.LiveChatModerators.Delete)super.setQuotaUser(var1);
         }

         public YouTube.LiveChatModerators.Delete setUserIp(String var1) {
            return (YouTube.LiveChatModerators.Delete)super.setUserIp(var1);
         }
      }

      public class Insert extends YouTubeRequest<LiveChatModerator> {
         private static final String REST_PATH = "liveChat/moderators";
         @Key
         private String part;
         final YouTube.LiveChatModerators this$1;

         protected Insert(YouTube.LiveChatModerators var1, String var2, LiveChatModerator var3) {
            super(var1.this$0, "POST", "liveChat/moderators", var3, LiveChatModerator.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.LiveChatModerators.Insert set(String var1, Object var2) {
            return (YouTube.LiveChatModerators.Insert)super.set(var1, var2);
         }

         public YouTube.LiveChatModerators.Insert setAlt(String var1) {
            return (YouTube.LiveChatModerators.Insert)super.setAlt(var1);
         }

         public YouTube.LiveChatModerators.Insert setFields(String var1) {
            return (YouTube.LiveChatModerators.Insert)super.setFields(var1);
         }

         public YouTube.LiveChatModerators.Insert setKey(String var1) {
            return (YouTube.LiveChatModerators.Insert)super.setKey(var1);
         }

         public YouTube.LiveChatModerators.Insert setOauthToken(String var1) {
            return (YouTube.LiveChatModerators.Insert)super.setOauthToken(var1);
         }

         public YouTube.LiveChatModerators.Insert setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.LiveChatModerators.Insert setPrettyPrint(Boolean var1) {
            return (YouTube.LiveChatModerators.Insert)super.setPrettyPrint(var1);
         }

         public YouTube.LiveChatModerators.Insert setQuotaUser(String var1) {
            return (YouTube.LiveChatModerators.Insert)super.setQuotaUser(var1);
         }

         public YouTube.LiveChatModerators.Insert setUserIp(String var1) {
            return (YouTube.LiveChatModerators.Insert)super.setUserIp(var1);
         }
      }

      public class List extends YouTubeRequest<LiveChatModeratorListResponse> {
         private static final String REST_PATH = "liveChat/moderators";
         @Key
         private String liveChatId;
         @Key
         private Long maxResults;
         @Key
         private String pageToken;
         @Key
         private String part;
         final YouTube.LiveChatModerators this$1;

         protected List(YouTube.LiveChatModerators var1, String var2, String var3) {
            super(var1.this$0, "GET", "liveChat/moderators", null, LiveChatModeratorListResponse.class);
            this.this$1 = var1;
            this.liveChatId = Preconditions.checkNotNull(var2, "Required parameter liveChatId must be specified.");
            this.part = Preconditions.checkNotNull(var3, "Required parameter part must be specified.");
         }

         @Override
         public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
         }

         @Override
         public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
         }

         public String getLiveChatId() {
            return this.liveChatId;
         }

         public Long getMaxResults() {
            return this.maxResults;
         }

         public String getPageToken() {
            return this.pageToken;
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.LiveChatModerators.List set(String var1, Object var2) {
            return (YouTube.LiveChatModerators.List)super.set(var1, var2);
         }

         public YouTube.LiveChatModerators.List setAlt(String var1) {
            return (YouTube.LiveChatModerators.List)super.setAlt(var1);
         }

         public YouTube.LiveChatModerators.List setFields(String var1) {
            return (YouTube.LiveChatModerators.List)super.setFields(var1);
         }

         public YouTube.LiveChatModerators.List setKey(String var1) {
            return (YouTube.LiveChatModerators.List)super.setKey(var1);
         }

         public YouTube.LiveChatModerators.List setLiveChatId(String var1) {
            this.liveChatId = var1;
            return this;
         }

         public YouTube.LiveChatModerators.List setMaxResults(Long var1) {
            this.maxResults = var1;
            return this;
         }

         public YouTube.LiveChatModerators.List setOauthToken(String var1) {
            return (YouTube.LiveChatModerators.List)super.setOauthToken(var1);
         }

         public YouTube.LiveChatModerators.List setPageToken(String var1) {
            this.pageToken = var1;
            return this;
         }

         public YouTube.LiveChatModerators.List setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.LiveChatModerators.List setPrettyPrint(Boolean var1) {
            return (YouTube.LiveChatModerators.List)super.setPrettyPrint(var1);
         }

         public YouTube.LiveChatModerators.List setQuotaUser(String var1) {
            return (YouTube.LiveChatModerators.List)super.setQuotaUser(var1);
         }

         public YouTube.LiveChatModerators.List setUserIp(String var1) {
            return (YouTube.LiveChatModerators.List)super.setUserIp(var1);
         }
      }
   }

   public class LiveStreams {
      final YouTube this$0;

      public LiveStreams(YouTube var1) {
         this.this$0 = var1;
      }

      public YouTube.LiveStreams.Delete delete(String var1) throws IOException {
         YouTube.LiveStreams.Delete var2 = new YouTube.LiveStreams.Delete(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public YouTube.LiveStreams.Insert insert(String var1, LiveStream var2) throws IOException {
         YouTube.LiveStreams.Insert var3 = new YouTube.LiveStreams.Insert(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public YouTube.LiveStreams.List list(String var1) throws IOException {
         YouTube.LiveStreams.List var2 = new YouTube.LiveStreams.List(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public YouTube.LiveStreams.Update update(String var1, LiveStream var2) throws IOException {
         YouTube.LiveStreams.Update var3 = new YouTube.LiveStreams.Update(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public class Delete extends YouTubeRequest<Void> {
         private static final String REST_PATH = "liveStreams";
         @Key
         private String id;
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String onBehalfOfContentOwnerChannel;
         final YouTube.LiveStreams this$1;

         protected Delete(YouTube.LiveStreams var1, String var2) {
            super(var1.this$0, "DELETE", "liveStreams", null, Void.class);
            this.this$1 = var1;
            this.id = Preconditions.checkNotNull(var2, "Required parameter id must be specified.");
         }

         public String getId() {
            return this.id;
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getOnBehalfOfContentOwnerChannel() {
            return this.onBehalfOfContentOwnerChannel;
         }

         public YouTube.LiveStreams.Delete set(String var1, Object var2) {
            return (YouTube.LiveStreams.Delete)super.set(var1, var2);
         }

         public YouTube.LiveStreams.Delete setAlt(String var1) {
            return (YouTube.LiveStreams.Delete)super.setAlt(var1);
         }

         public YouTube.LiveStreams.Delete setFields(String var1) {
            return (YouTube.LiveStreams.Delete)super.setFields(var1);
         }

         public YouTube.LiveStreams.Delete setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.LiveStreams.Delete setKey(String var1) {
            return (YouTube.LiveStreams.Delete)super.setKey(var1);
         }

         public YouTube.LiveStreams.Delete setOauthToken(String var1) {
            return (YouTube.LiveStreams.Delete)super.setOauthToken(var1);
         }

         public YouTube.LiveStreams.Delete setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.LiveStreams.Delete setOnBehalfOfContentOwnerChannel(String var1) {
            this.onBehalfOfContentOwnerChannel = var1;
            return this;
         }

         public YouTube.LiveStreams.Delete setPrettyPrint(Boolean var1) {
            return (YouTube.LiveStreams.Delete)super.setPrettyPrint(var1);
         }

         public YouTube.LiveStreams.Delete setQuotaUser(String var1) {
            return (YouTube.LiveStreams.Delete)super.setQuotaUser(var1);
         }

         public YouTube.LiveStreams.Delete setUserIp(String var1) {
            return (YouTube.LiveStreams.Delete)super.setUserIp(var1);
         }
      }

      public class Insert extends YouTubeRequest<LiveStream> {
         private static final String REST_PATH = "liveStreams";
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String onBehalfOfContentOwnerChannel;
         @Key
         private String part;
         final YouTube.LiveStreams this$1;

         protected Insert(YouTube.LiveStreams var1, String var2, LiveStream var3) {
            super(var1.this$0, "POST", "liveStreams", var3, LiveStream.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getOnBehalfOfContentOwnerChannel() {
            return this.onBehalfOfContentOwnerChannel;
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.LiveStreams.Insert set(String var1, Object var2) {
            return (YouTube.LiveStreams.Insert)super.set(var1, var2);
         }

         public YouTube.LiveStreams.Insert setAlt(String var1) {
            return (YouTube.LiveStreams.Insert)super.setAlt(var1);
         }

         public YouTube.LiveStreams.Insert setFields(String var1) {
            return (YouTube.LiveStreams.Insert)super.setFields(var1);
         }

         public YouTube.LiveStreams.Insert setKey(String var1) {
            return (YouTube.LiveStreams.Insert)super.setKey(var1);
         }

         public YouTube.LiveStreams.Insert setOauthToken(String var1) {
            return (YouTube.LiveStreams.Insert)super.setOauthToken(var1);
         }

         public YouTube.LiveStreams.Insert setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.LiveStreams.Insert setOnBehalfOfContentOwnerChannel(String var1) {
            this.onBehalfOfContentOwnerChannel = var1;
            return this;
         }

         public YouTube.LiveStreams.Insert setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.LiveStreams.Insert setPrettyPrint(Boolean var1) {
            return (YouTube.LiveStreams.Insert)super.setPrettyPrint(var1);
         }

         public YouTube.LiveStreams.Insert setQuotaUser(String var1) {
            return (YouTube.LiveStreams.Insert)super.setQuotaUser(var1);
         }

         public YouTube.LiveStreams.Insert setUserIp(String var1) {
            return (YouTube.LiveStreams.Insert)super.setUserIp(var1);
         }
      }

      public class List extends YouTubeRequest<LiveStreamListResponse> {
         private static final String REST_PATH = "liveStreams";
         @Key
         private String id;
         @Key
         private Long maxResults;
         @Key
         private Boolean mine;
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String onBehalfOfContentOwnerChannel;
         @Key
         private String pageToken;
         @Key
         private String part;
         final YouTube.LiveStreams this$1;

         protected List(YouTube.LiveStreams var1, String var2) {
            super(var1.this$0, "GET", "liveStreams", null, LiveStreamListResponse.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         @Override
         public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
         }

         @Override
         public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
         }

         public String getId() {
            return this.id;
         }

         public Long getMaxResults() {
            return this.maxResults;
         }

         public Boolean getMine() {
            return this.mine;
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getOnBehalfOfContentOwnerChannel() {
            return this.onBehalfOfContentOwnerChannel;
         }

         public String getPageToken() {
            return this.pageToken;
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.LiveStreams.List set(String var1, Object var2) {
            return (YouTube.LiveStreams.List)super.set(var1, var2);
         }

         public YouTube.LiveStreams.List setAlt(String var1) {
            return (YouTube.LiveStreams.List)super.setAlt(var1);
         }

         public YouTube.LiveStreams.List setFields(String var1) {
            return (YouTube.LiveStreams.List)super.setFields(var1);
         }

         public YouTube.LiveStreams.List setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.LiveStreams.List setKey(String var1) {
            return (YouTube.LiveStreams.List)super.setKey(var1);
         }

         public YouTube.LiveStreams.List setMaxResults(Long var1) {
            this.maxResults = var1;
            return this;
         }

         public YouTube.LiveStreams.List setMine(Boolean var1) {
            this.mine = var1;
            return this;
         }

         public YouTube.LiveStreams.List setOauthToken(String var1) {
            return (YouTube.LiveStreams.List)super.setOauthToken(var1);
         }

         public YouTube.LiveStreams.List setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.LiveStreams.List setOnBehalfOfContentOwnerChannel(String var1) {
            this.onBehalfOfContentOwnerChannel = var1;
            return this;
         }

         public YouTube.LiveStreams.List setPageToken(String var1) {
            this.pageToken = var1;
            return this;
         }

         public YouTube.LiveStreams.List setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.LiveStreams.List setPrettyPrint(Boolean var1) {
            return (YouTube.LiveStreams.List)super.setPrettyPrint(var1);
         }

         public YouTube.LiveStreams.List setQuotaUser(String var1) {
            return (YouTube.LiveStreams.List)super.setQuotaUser(var1);
         }

         public YouTube.LiveStreams.List setUserIp(String var1) {
            return (YouTube.LiveStreams.List)super.setUserIp(var1);
         }
      }

      public class Update extends YouTubeRequest<LiveStream> {
         private static final String REST_PATH = "liveStreams";
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String onBehalfOfContentOwnerChannel;
         @Key
         private String part;
         final YouTube.LiveStreams this$1;

         protected Update(YouTube.LiveStreams var1, String var2, LiveStream var3) {
            super(var1.this$0, "PUT", "liveStreams", var3, LiveStream.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
            this.checkRequiredParameter(var3, "content");
            this.checkRequiredParameter(var3.getId(), "LiveStream.getId()");
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getOnBehalfOfContentOwnerChannel() {
            return this.onBehalfOfContentOwnerChannel;
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.LiveStreams.Update set(String var1, Object var2) {
            return (YouTube.LiveStreams.Update)super.set(var1, var2);
         }

         public YouTube.LiveStreams.Update setAlt(String var1) {
            return (YouTube.LiveStreams.Update)super.setAlt(var1);
         }

         public YouTube.LiveStreams.Update setFields(String var1) {
            return (YouTube.LiveStreams.Update)super.setFields(var1);
         }

         public YouTube.LiveStreams.Update setKey(String var1) {
            return (YouTube.LiveStreams.Update)super.setKey(var1);
         }

         public YouTube.LiveStreams.Update setOauthToken(String var1) {
            return (YouTube.LiveStreams.Update)super.setOauthToken(var1);
         }

         public YouTube.LiveStreams.Update setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.LiveStreams.Update setOnBehalfOfContentOwnerChannel(String var1) {
            this.onBehalfOfContentOwnerChannel = var1;
            return this;
         }

         public YouTube.LiveStreams.Update setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.LiveStreams.Update setPrettyPrint(Boolean var1) {
            return (YouTube.LiveStreams.Update)super.setPrettyPrint(var1);
         }

         public YouTube.LiveStreams.Update setQuotaUser(String var1) {
            return (YouTube.LiveStreams.Update)super.setQuotaUser(var1);
         }

         public YouTube.LiveStreams.Update setUserIp(String var1) {
            return (YouTube.LiveStreams.Update)super.setUserIp(var1);
         }
      }
   }

   public class PlaylistItems {
      final YouTube this$0;

      public PlaylistItems(YouTube var1) {
         this.this$0 = var1;
      }

      public YouTube.PlaylistItems.Delete delete(String var1) throws IOException {
         YouTube.PlaylistItems.Delete var2 = new YouTube.PlaylistItems.Delete(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public YouTube.PlaylistItems.Insert insert(String var1, PlaylistItem var2) throws IOException {
         YouTube.PlaylistItems.Insert var3 = new YouTube.PlaylistItems.Insert(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public YouTube.PlaylistItems.List list(String var1) throws IOException {
         YouTube.PlaylistItems.List var2 = new YouTube.PlaylistItems.List(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public YouTube.PlaylistItems.Update update(String var1, PlaylistItem var2) throws IOException {
         YouTube.PlaylistItems.Update var3 = new YouTube.PlaylistItems.Update(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public class Delete extends YouTubeRequest<Void> {
         private static final String REST_PATH = "playlistItems";
         @Key
         private String id;
         @Key
         private String onBehalfOfContentOwner;
         final YouTube.PlaylistItems this$1;

         protected Delete(YouTube.PlaylistItems var1, String var2) {
            super(var1.this$0, "DELETE", "playlistItems", null, Void.class);
            this.this$1 = var1;
            this.id = Preconditions.checkNotNull(var2, "Required parameter id must be specified.");
         }

         public String getId() {
            return this.id;
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public YouTube.PlaylistItems.Delete set(String var1, Object var2) {
            return (YouTube.PlaylistItems.Delete)super.set(var1, var2);
         }

         public YouTube.PlaylistItems.Delete setAlt(String var1) {
            return (YouTube.PlaylistItems.Delete)super.setAlt(var1);
         }

         public YouTube.PlaylistItems.Delete setFields(String var1) {
            return (YouTube.PlaylistItems.Delete)super.setFields(var1);
         }

         public YouTube.PlaylistItems.Delete setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.PlaylistItems.Delete setKey(String var1) {
            return (YouTube.PlaylistItems.Delete)super.setKey(var1);
         }

         public YouTube.PlaylistItems.Delete setOauthToken(String var1) {
            return (YouTube.PlaylistItems.Delete)super.setOauthToken(var1);
         }

         public YouTube.PlaylistItems.Delete setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.PlaylistItems.Delete setPrettyPrint(Boolean var1) {
            return (YouTube.PlaylistItems.Delete)super.setPrettyPrint(var1);
         }

         public YouTube.PlaylistItems.Delete setQuotaUser(String var1) {
            return (YouTube.PlaylistItems.Delete)super.setQuotaUser(var1);
         }

         public YouTube.PlaylistItems.Delete setUserIp(String var1) {
            return (YouTube.PlaylistItems.Delete)super.setUserIp(var1);
         }
      }

      public class Insert extends YouTubeRequest<PlaylistItem> {
         private static final String REST_PATH = "playlistItems";
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String part;
         final YouTube.PlaylistItems this$1;

         protected Insert(YouTube.PlaylistItems var1, String var2, PlaylistItem var3) {
            super(var1.this$0, "POST", "playlistItems", var3, PlaylistItem.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.PlaylistItems.Insert set(String var1, Object var2) {
            return (YouTube.PlaylistItems.Insert)super.set(var1, var2);
         }

         public YouTube.PlaylistItems.Insert setAlt(String var1) {
            return (YouTube.PlaylistItems.Insert)super.setAlt(var1);
         }

         public YouTube.PlaylistItems.Insert setFields(String var1) {
            return (YouTube.PlaylistItems.Insert)super.setFields(var1);
         }

         public YouTube.PlaylistItems.Insert setKey(String var1) {
            return (YouTube.PlaylistItems.Insert)super.setKey(var1);
         }

         public YouTube.PlaylistItems.Insert setOauthToken(String var1) {
            return (YouTube.PlaylistItems.Insert)super.setOauthToken(var1);
         }

         public YouTube.PlaylistItems.Insert setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.PlaylistItems.Insert setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.PlaylistItems.Insert setPrettyPrint(Boolean var1) {
            return (YouTube.PlaylistItems.Insert)super.setPrettyPrint(var1);
         }

         public YouTube.PlaylistItems.Insert setQuotaUser(String var1) {
            return (YouTube.PlaylistItems.Insert)super.setQuotaUser(var1);
         }

         public YouTube.PlaylistItems.Insert setUserIp(String var1) {
            return (YouTube.PlaylistItems.Insert)super.setUserIp(var1);
         }
      }

      public class List extends YouTubeRequest<PlaylistItemListResponse> {
         private static final String REST_PATH = "playlistItems";
         @Key
         private String id;
         @Key
         private Long maxResults;
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String pageToken;
         @Key
         private String part;
         @Key
         private String playlistId;
         final YouTube.PlaylistItems this$1;
         @Key
         private String videoId;

         protected List(YouTube.PlaylistItems var1, String var2) {
            super(var1.this$0, "GET", "playlistItems", null, PlaylistItemListResponse.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         @Override
         public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
         }

         @Override
         public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
         }

         public String getId() {
            return this.id;
         }

         public Long getMaxResults() {
            return this.maxResults;
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getPageToken() {
            return this.pageToken;
         }

         public String getPart() {
            return this.part;
         }

         public String getPlaylistId() {
            return this.playlistId;
         }

         public String getVideoId() {
            return this.videoId;
         }

         public YouTube.PlaylistItems.List set(String var1, Object var2) {
            return (YouTube.PlaylistItems.List)super.set(var1, var2);
         }

         public YouTube.PlaylistItems.List setAlt(String var1) {
            return (YouTube.PlaylistItems.List)super.setAlt(var1);
         }

         public YouTube.PlaylistItems.List setFields(String var1) {
            return (YouTube.PlaylistItems.List)super.setFields(var1);
         }

         public YouTube.PlaylistItems.List setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.PlaylistItems.List setKey(String var1) {
            return (YouTube.PlaylistItems.List)super.setKey(var1);
         }

         public YouTube.PlaylistItems.List setMaxResults(Long var1) {
            this.maxResults = var1;
            return this;
         }

         public YouTube.PlaylistItems.List setOauthToken(String var1) {
            return (YouTube.PlaylistItems.List)super.setOauthToken(var1);
         }

         public YouTube.PlaylistItems.List setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.PlaylistItems.List setPageToken(String var1) {
            this.pageToken = var1;
            return this;
         }

         public YouTube.PlaylistItems.List setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.PlaylistItems.List setPlaylistId(String var1) {
            this.playlistId = var1;
            return this;
         }

         public YouTube.PlaylistItems.List setPrettyPrint(Boolean var1) {
            return (YouTube.PlaylistItems.List)super.setPrettyPrint(var1);
         }

         public YouTube.PlaylistItems.List setQuotaUser(String var1) {
            return (YouTube.PlaylistItems.List)super.setQuotaUser(var1);
         }

         public YouTube.PlaylistItems.List setUserIp(String var1) {
            return (YouTube.PlaylistItems.List)super.setUserIp(var1);
         }

         public YouTube.PlaylistItems.List setVideoId(String var1) {
            this.videoId = var1;
            return this;
         }
      }

      public class Update extends YouTubeRequest<PlaylistItem> {
         private static final String REST_PATH = "playlistItems";
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String part;
         final YouTube.PlaylistItems this$1;

         protected Update(YouTube.PlaylistItems var1, String var2, PlaylistItem var3) {
            super(var1.this$0, "PUT", "playlistItems", var3, PlaylistItem.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.PlaylistItems.Update set(String var1, Object var2) {
            return (YouTube.PlaylistItems.Update)super.set(var1, var2);
         }

         public YouTube.PlaylistItems.Update setAlt(String var1) {
            return (YouTube.PlaylistItems.Update)super.setAlt(var1);
         }

         public YouTube.PlaylistItems.Update setFields(String var1) {
            return (YouTube.PlaylistItems.Update)super.setFields(var1);
         }

         public YouTube.PlaylistItems.Update setKey(String var1) {
            return (YouTube.PlaylistItems.Update)super.setKey(var1);
         }

         public YouTube.PlaylistItems.Update setOauthToken(String var1) {
            return (YouTube.PlaylistItems.Update)super.setOauthToken(var1);
         }

         public YouTube.PlaylistItems.Update setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.PlaylistItems.Update setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.PlaylistItems.Update setPrettyPrint(Boolean var1) {
            return (YouTube.PlaylistItems.Update)super.setPrettyPrint(var1);
         }

         public YouTube.PlaylistItems.Update setQuotaUser(String var1) {
            return (YouTube.PlaylistItems.Update)super.setQuotaUser(var1);
         }

         public YouTube.PlaylistItems.Update setUserIp(String var1) {
            return (YouTube.PlaylistItems.Update)super.setUserIp(var1);
         }
      }
   }

   public class Playlists {
      final YouTube this$0;

      public Playlists(YouTube var1) {
         this.this$0 = var1;
      }

      public YouTube.Playlists.Delete delete(String var1) throws IOException {
         YouTube.Playlists.Delete var2 = new YouTube.Playlists.Delete(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public YouTube.Playlists.Insert insert(String var1, Playlist var2) throws IOException {
         YouTube.Playlists.Insert var3 = new YouTube.Playlists.Insert(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public YouTube.Playlists.List list(String var1) throws IOException {
         YouTube.Playlists.List var2 = new YouTube.Playlists.List(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public YouTube.Playlists.Update update(String var1, Playlist var2) throws IOException {
         YouTube.Playlists.Update var3 = new YouTube.Playlists.Update(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public class Delete extends YouTubeRequest<Void> {
         private static final String REST_PATH = "playlists";
         @Key
         private String id;
         @Key
         private String onBehalfOfContentOwner;
         final YouTube.Playlists this$1;

         protected Delete(YouTube.Playlists var1, String var2) {
            super(var1.this$0, "DELETE", "playlists", null, Void.class);
            this.this$1 = var1;
            this.id = Preconditions.checkNotNull(var2, "Required parameter id must be specified.");
         }

         public String getId() {
            return this.id;
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public YouTube.Playlists.Delete set(String var1, Object var2) {
            return (YouTube.Playlists.Delete)super.set(var1, var2);
         }

         public YouTube.Playlists.Delete setAlt(String var1) {
            return (YouTube.Playlists.Delete)super.setAlt(var1);
         }

         public YouTube.Playlists.Delete setFields(String var1) {
            return (YouTube.Playlists.Delete)super.setFields(var1);
         }

         public YouTube.Playlists.Delete setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.Playlists.Delete setKey(String var1) {
            return (YouTube.Playlists.Delete)super.setKey(var1);
         }

         public YouTube.Playlists.Delete setOauthToken(String var1) {
            return (YouTube.Playlists.Delete)super.setOauthToken(var1);
         }

         public YouTube.Playlists.Delete setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.Playlists.Delete setPrettyPrint(Boolean var1) {
            return (YouTube.Playlists.Delete)super.setPrettyPrint(var1);
         }

         public YouTube.Playlists.Delete setQuotaUser(String var1) {
            return (YouTube.Playlists.Delete)super.setQuotaUser(var1);
         }

         public YouTube.Playlists.Delete setUserIp(String var1) {
            return (YouTube.Playlists.Delete)super.setUserIp(var1);
         }
      }

      public class Insert extends YouTubeRequest<Playlist> {
         private static final String REST_PATH = "playlists";
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String onBehalfOfContentOwnerChannel;
         @Key
         private String part;
         final YouTube.Playlists this$1;

         protected Insert(YouTube.Playlists var1, String var2, Playlist var3) {
            super(var1.this$0, "POST", "playlists", var3, Playlist.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getOnBehalfOfContentOwnerChannel() {
            return this.onBehalfOfContentOwnerChannel;
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.Playlists.Insert set(String var1, Object var2) {
            return (YouTube.Playlists.Insert)super.set(var1, var2);
         }

         public YouTube.Playlists.Insert setAlt(String var1) {
            return (YouTube.Playlists.Insert)super.setAlt(var1);
         }

         public YouTube.Playlists.Insert setFields(String var1) {
            return (YouTube.Playlists.Insert)super.setFields(var1);
         }

         public YouTube.Playlists.Insert setKey(String var1) {
            return (YouTube.Playlists.Insert)super.setKey(var1);
         }

         public YouTube.Playlists.Insert setOauthToken(String var1) {
            return (YouTube.Playlists.Insert)super.setOauthToken(var1);
         }

         public YouTube.Playlists.Insert setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.Playlists.Insert setOnBehalfOfContentOwnerChannel(String var1) {
            this.onBehalfOfContentOwnerChannel = var1;
            return this;
         }

         public YouTube.Playlists.Insert setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.Playlists.Insert setPrettyPrint(Boolean var1) {
            return (YouTube.Playlists.Insert)super.setPrettyPrint(var1);
         }

         public YouTube.Playlists.Insert setQuotaUser(String var1) {
            return (YouTube.Playlists.Insert)super.setQuotaUser(var1);
         }

         public YouTube.Playlists.Insert setUserIp(String var1) {
            return (YouTube.Playlists.Insert)super.setUserIp(var1);
         }
      }

      public class List extends YouTubeRequest<PlaylistListResponse> {
         private static final String REST_PATH = "playlists";
         @Key
         private String channelId;
         @Key
         private String hl;
         @Key
         private String id;
         @Key
         private Long maxResults;
         @Key
         private Boolean mine;
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String onBehalfOfContentOwnerChannel;
         @Key
         private String pageToken;
         @Key
         private String part;
         final YouTube.Playlists this$1;

         protected List(YouTube.Playlists var1, String var2) {
            super(var1.this$0, "GET", "playlists", null, PlaylistListResponse.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         @Override
         public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
         }

         @Override
         public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
         }

         public String getChannelId() {
            return this.channelId;
         }

         public String getHl() {
            return this.hl;
         }

         public String getId() {
            return this.id;
         }

         public Long getMaxResults() {
            return this.maxResults;
         }

         public Boolean getMine() {
            return this.mine;
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getOnBehalfOfContentOwnerChannel() {
            return this.onBehalfOfContentOwnerChannel;
         }

         public String getPageToken() {
            return this.pageToken;
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.Playlists.List set(String var1, Object var2) {
            return (YouTube.Playlists.List)super.set(var1, var2);
         }

         public YouTube.Playlists.List setAlt(String var1) {
            return (YouTube.Playlists.List)super.setAlt(var1);
         }

         public YouTube.Playlists.List setChannelId(String var1) {
            this.channelId = var1;
            return this;
         }

         public YouTube.Playlists.List setFields(String var1) {
            return (YouTube.Playlists.List)super.setFields(var1);
         }

         public YouTube.Playlists.List setHl(String var1) {
            this.hl = var1;
            return this;
         }

         public YouTube.Playlists.List setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.Playlists.List setKey(String var1) {
            return (YouTube.Playlists.List)super.setKey(var1);
         }

         public YouTube.Playlists.List setMaxResults(Long var1) {
            this.maxResults = var1;
            return this;
         }

         public YouTube.Playlists.List setMine(Boolean var1) {
            this.mine = var1;
            return this;
         }

         public YouTube.Playlists.List setOauthToken(String var1) {
            return (YouTube.Playlists.List)super.setOauthToken(var1);
         }

         public YouTube.Playlists.List setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.Playlists.List setOnBehalfOfContentOwnerChannel(String var1) {
            this.onBehalfOfContentOwnerChannel = var1;
            return this;
         }

         public YouTube.Playlists.List setPageToken(String var1) {
            this.pageToken = var1;
            return this;
         }

         public YouTube.Playlists.List setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.Playlists.List setPrettyPrint(Boolean var1) {
            return (YouTube.Playlists.List)super.setPrettyPrint(var1);
         }

         public YouTube.Playlists.List setQuotaUser(String var1) {
            return (YouTube.Playlists.List)super.setQuotaUser(var1);
         }

         public YouTube.Playlists.List setUserIp(String var1) {
            return (YouTube.Playlists.List)super.setUserIp(var1);
         }
      }

      public class Update extends YouTubeRequest<Playlist> {
         private static final String REST_PATH = "playlists";
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String part;
         final YouTube.Playlists this$1;

         protected Update(YouTube.Playlists var1, String var2, Playlist var3) {
            super(var1.this$0, "PUT", "playlists", var3, Playlist.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.Playlists.Update set(String var1, Object var2) {
            return (YouTube.Playlists.Update)super.set(var1, var2);
         }

         public YouTube.Playlists.Update setAlt(String var1) {
            return (YouTube.Playlists.Update)super.setAlt(var1);
         }

         public YouTube.Playlists.Update setFields(String var1) {
            return (YouTube.Playlists.Update)super.setFields(var1);
         }

         public YouTube.Playlists.Update setKey(String var1) {
            return (YouTube.Playlists.Update)super.setKey(var1);
         }

         public YouTube.Playlists.Update setOauthToken(String var1) {
            return (YouTube.Playlists.Update)super.setOauthToken(var1);
         }

         public YouTube.Playlists.Update setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.Playlists.Update setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.Playlists.Update setPrettyPrint(Boolean var1) {
            return (YouTube.Playlists.Update)super.setPrettyPrint(var1);
         }

         public YouTube.Playlists.Update setQuotaUser(String var1) {
            return (YouTube.Playlists.Update)super.setQuotaUser(var1);
         }

         public YouTube.Playlists.Update setUserIp(String var1) {
            return (YouTube.Playlists.Update)super.setUserIp(var1);
         }
      }
   }

   public class Search {
      final YouTube this$0;

      public Search(YouTube var1) {
         this.this$0 = var1;
      }

      public YouTube.Search.List list(String var1) throws IOException {
         YouTube.Search.List var2 = new YouTube.Search.List(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public class List extends YouTubeRequest<SearchListResponse> {
         private static final String REST_PATH = "search";
         @Key
         private String channelId;
         @Key
         private String channelType;
         @Key
         private String eventType;
         @Key
         private Boolean forContentOwner;
         @Key
         private Boolean forDeveloper;
         @Key
         private Boolean forMine;
         @Key
         private String location;
         @Key
         private String locationRadius;
         @Key
         private Long maxResults;
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String order;
         @Key
         private String pageToken;
         @Key
         private String part;
         @Key
         private DateTime publishedAfter;
         @Key
         private DateTime publishedBefore;
         @Key
         private String q;
         @Key
         private String regionCode;
         @Key
         private String relatedToVideoId;
         @Key
         private String relevanceLanguage;
         @Key
         private String safeSearch;
         final YouTube.Search this$1;
         @Key
         private String topicId;
         @Key
         private String type;
         @Key
         private String videoCaption;
         @Key
         private String videoCategoryId;
         @Key
         private String videoDefinition;
         @Key
         private String videoDimension;
         @Key
         private String videoDuration;
         @Key
         private String videoEmbeddable;
         @Key
         private String videoLicense;
         @Key
         private String videoSyndicated;
         @Key
         private String videoType;

         protected List(YouTube.Search var1, String var2) {
            super(var1.this$0, "GET", "search", null, SearchListResponse.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         @Override
         public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
         }

         @Override
         public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
         }

         public String getChannelId() {
            return this.channelId;
         }

         public String getChannelType() {
            return this.channelType;
         }

         public String getEventType() {
            return this.eventType;
         }

         public Boolean getForContentOwner() {
            return this.forContentOwner;
         }

         public Boolean getForDeveloper() {
            return this.forDeveloper;
         }

         public Boolean getForMine() {
            return this.forMine;
         }

         public String getLocation() {
            return this.location;
         }

         public String getLocationRadius() {
            return this.locationRadius;
         }

         public Long getMaxResults() {
            return this.maxResults;
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getOrder() {
            return this.order;
         }

         public String getPageToken() {
            return this.pageToken;
         }

         public String getPart() {
            return this.part;
         }

         public DateTime getPublishedAfter() {
            return this.publishedAfter;
         }

         public DateTime getPublishedBefore() {
            return this.publishedBefore;
         }

         public String getQ() {
            return this.q;
         }

         public String getRegionCode() {
            return this.regionCode;
         }

         public String getRelatedToVideoId() {
            return this.relatedToVideoId;
         }

         public String getRelevanceLanguage() {
            return this.relevanceLanguage;
         }

         public String getSafeSearch() {
            return this.safeSearch;
         }

         public String getTopicId() {
            return this.topicId;
         }

         public String getType() {
            return this.type;
         }

         public String getVideoCaption() {
            return this.videoCaption;
         }

         public String getVideoCategoryId() {
            return this.videoCategoryId;
         }

         public String getVideoDefinition() {
            return this.videoDefinition;
         }

         public String getVideoDimension() {
            return this.videoDimension;
         }

         public String getVideoDuration() {
            return this.videoDuration;
         }

         public String getVideoEmbeddable() {
            return this.videoEmbeddable;
         }

         public String getVideoLicense() {
            return this.videoLicense;
         }

         public String getVideoSyndicated() {
            return this.videoSyndicated;
         }

         public String getVideoType() {
            return this.videoType;
         }

         public YouTube.Search.List set(String var1, Object var2) {
            return (YouTube.Search.List)super.set(var1, var2);
         }

         public YouTube.Search.List setAlt(String var1) {
            return (YouTube.Search.List)super.setAlt(var1);
         }

         public YouTube.Search.List setChannelId(String var1) {
            this.channelId = var1;
            return this;
         }

         public YouTube.Search.List setChannelType(String var1) {
            this.channelType = var1;
            return this;
         }

         public YouTube.Search.List setEventType(String var1) {
            this.eventType = var1;
            return this;
         }

         public YouTube.Search.List setFields(String var1) {
            return (YouTube.Search.List)super.setFields(var1);
         }

         public YouTube.Search.List setForContentOwner(Boolean var1) {
            this.forContentOwner = var1;
            return this;
         }

         public YouTube.Search.List setForDeveloper(Boolean var1) {
            this.forDeveloper = var1;
            return this;
         }

         public YouTube.Search.List setForMine(Boolean var1) {
            this.forMine = var1;
            return this;
         }

         public YouTube.Search.List setKey(String var1) {
            return (YouTube.Search.List)super.setKey(var1);
         }

         public YouTube.Search.List setLocation(String var1) {
            this.location = var1;
            return this;
         }

         public YouTube.Search.List setLocationRadius(String var1) {
            this.locationRadius = var1;
            return this;
         }

         public YouTube.Search.List setMaxResults(Long var1) {
            this.maxResults = var1;
            return this;
         }

         public YouTube.Search.List setOauthToken(String var1) {
            return (YouTube.Search.List)super.setOauthToken(var1);
         }

         public YouTube.Search.List setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.Search.List setOrder(String var1) {
            this.order = var1;
            return this;
         }

         public YouTube.Search.List setPageToken(String var1) {
            this.pageToken = var1;
            return this;
         }

         public YouTube.Search.List setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.Search.List setPrettyPrint(Boolean var1) {
            return (YouTube.Search.List)super.setPrettyPrint(var1);
         }

         public YouTube.Search.List setPublishedAfter(DateTime var1) {
            this.publishedAfter = var1;
            return this;
         }

         public YouTube.Search.List setPublishedBefore(DateTime var1) {
            this.publishedBefore = var1;
            return this;
         }

         public YouTube.Search.List setQ(String var1) {
            this.q = var1;
            return this;
         }

         public YouTube.Search.List setQuotaUser(String var1) {
            return (YouTube.Search.List)super.setQuotaUser(var1);
         }

         public YouTube.Search.List setRegionCode(String var1) {
            this.regionCode = var1;
            return this;
         }

         public YouTube.Search.List setRelatedToVideoId(String var1) {
            this.relatedToVideoId = var1;
            return this;
         }

         public YouTube.Search.List setRelevanceLanguage(String var1) {
            this.relevanceLanguage = var1;
            return this;
         }

         public YouTube.Search.List setSafeSearch(String var1) {
            this.safeSearch = var1;
            return this;
         }

         public YouTube.Search.List setTopicId(String var1) {
            this.topicId = var1;
            return this;
         }

         public YouTube.Search.List setType(String var1) {
            this.type = var1;
            return this;
         }

         public YouTube.Search.List setUserIp(String var1) {
            return (YouTube.Search.List)super.setUserIp(var1);
         }

         public YouTube.Search.List setVideoCaption(String var1) {
            this.videoCaption = var1;
            return this;
         }

         public YouTube.Search.List setVideoCategoryId(String var1) {
            this.videoCategoryId = var1;
            return this;
         }

         public YouTube.Search.List setVideoDefinition(String var1) {
            this.videoDefinition = var1;
            return this;
         }

         public YouTube.Search.List setVideoDimension(String var1) {
            this.videoDimension = var1;
            return this;
         }

         public YouTube.Search.List setVideoDuration(String var1) {
            this.videoDuration = var1;
            return this;
         }

         public YouTube.Search.List setVideoEmbeddable(String var1) {
            this.videoEmbeddable = var1;
            return this;
         }

         public YouTube.Search.List setVideoLicense(String var1) {
            this.videoLicense = var1;
            return this;
         }

         public YouTube.Search.List setVideoSyndicated(String var1) {
            this.videoSyndicated = var1;
            return this;
         }

         public YouTube.Search.List setVideoType(String var1) {
            this.videoType = var1;
            return this;
         }
      }
   }

   public class Sponsors {
      final YouTube this$0;

      public Sponsors(YouTube var1) {
         this.this$0 = var1;
      }

      public YouTube.Sponsors.List list(String var1) throws IOException {
         YouTube.Sponsors.List var2 = new YouTube.Sponsors.List(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public class List extends YouTubeRequest<SponsorListResponse> {
         private static final String REST_PATH = "sponsors";
         @Key
         private String filter;
         @Key
         private Long maxResults;
         @Key
         private String pageToken;
         @Key
         private String part;
         final YouTube.Sponsors this$1;

         protected List(YouTube.Sponsors var1, String var2) {
            super(var1.this$0, "GET", "sponsors", null, SponsorListResponse.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         @Override
         public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
         }

         @Override
         public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
         }

         public String getFilter() {
            return this.filter;
         }

         public Long getMaxResults() {
            return this.maxResults;
         }

         public String getPageToken() {
            return this.pageToken;
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.Sponsors.List set(String var1, Object var2) {
            return (YouTube.Sponsors.List)super.set(var1, var2);
         }

         public YouTube.Sponsors.List setAlt(String var1) {
            return (YouTube.Sponsors.List)super.setAlt(var1);
         }

         public YouTube.Sponsors.List setFields(String var1) {
            return (YouTube.Sponsors.List)super.setFields(var1);
         }

         public YouTube.Sponsors.List setFilter(String var1) {
            this.filter = var1;
            return this;
         }

         public YouTube.Sponsors.List setKey(String var1) {
            return (YouTube.Sponsors.List)super.setKey(var1);
         }

         public YouTube.Sponsors.List setMaxResults(Long var1) {
            this.maxResults = var1;
            return this;
         }

         public YouTube.Sponsors.List setOauthToken(String var1) {
            return (YouTube.Sponsors.List)super.setOauthToken(var1);
         }

         public YouTube.Sponsors.List setPageToken(String var1) {
            this.pageToken = var1;
            return this;
         }

         public YouTube.Sponsors.List setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.Sponsors.List setPrettyPrint(Boolean var1) {
            return (YouTube.Sponsors.List)super.setPrettyPrint(var1);
         }

         public YouTube.Sponsors.List setQuotaUser(String var1) {
            return (YouTube.Sponsors.List)super.setQuotaUser(var1);
         }

         public YouTube.Sponsors.List setUserIp(String var1) {
            return (YouTube.Sponsors.List)super.setUserIp(var1);
         }
      }
   }

   public class Subscriptions {
      final YouTube this$0;

      public Subscriptions(YouTube var1) {
         this.this$0 = var1;
      }

      public YouTube.Subscriptions.Delete delete(String var1) throws IOException {
         YouTube.Subscriptions.Delete var2 = new YouTube.Subscriptions.Delete(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public YouTube.Subscriptions.Insert insert(String var1, Subscription var2) throws IOException {
         YouTube.Subscriptions.Insert var3 = new YouTube.Subscriptions.Insert(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public YouTube.Subscriptions.List list(String var1) throws IOException {
         YouTube.Subscriptions.List var2 = new YouTube.Subscriptions.List(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public class Delete extends YouTubeRequest<Void> {
         private static final String REST_PATH = "subscriptions";
         @Key
         private String id;
         final YouTube.Subscriptions this$1;

         protected Delete(YouTube.Subscriptions var1, String var2) {
            super(var1.this$0, "DELETE", "subscriptions", null, Void.class);
            this.this$1 = var1;
            this.id = Preconditions.checkNotNull(var2, "Required parameter id must be specified.");
         }

         public String getId() {
            return this.id;
         }

         public YouTube.Subscriptions.Delete set(String var1, Object var2) {
            return (YouTube.Subscriptions.Delete)super.set(var1, var2);
         }

         public YouTube.Subscriptions.Delete setAlt(String var1) {
            return (YouTube.Subscriptions.Delete)super.setAlt(var1);
         }

         public YouTube.Subscriptions.Delete setFields(String var1) {
            return (YouTube.Subscriptions.Delete)super.setFields(var1);
         }

         public YouTube.Subscriptions.Delete setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.Subscriptions.Delete setKey(String var1) {
            return (YouTube.Subscriptions.Delete)super.setKey(var1);
         }

         public YouTube.Subscriptions.Delete setOauthToken(String var1) {
            return (YouTube.Subscriptions.Delete)super.setOauthToken(var1);
         }

         public YouTube.Subscriptions.Delete setPrettyPrint(Boolean var1) {
            return (YouTube.Subscriptions.Delete)super.setPrettyPrint(var1);
         }

         public YouTube.Subscriptions.Delete setQuotaUser(String var1) {
            return (YouTube.Subscriptions.Delete)super.setQuotaUser(var1);
         }

         public YouTube.Subscriptions.Delete setUserIp(String var1) {
            return (YouTube.Subscriptions.Delete)super.setUserIp(var1);
         }
      }

      public class Insert extends YouTubeRequest<Subscription> {
         private static final String REST_PATH = "subscriptions";
         @Key
         private String part;
         final YouTube.Subscriptions this$1;

         protected Insert(YouTube.Subscriptions var1, String var2, Subscription var3) {
            super(var1.this$0, "POST", "subscriptions", var3, Subscription.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.Subscriptions.Insert set(String var1, Object var2) {
            return (YouTube.Subscriptions.Insert)super.set(var1, var2);
         }

         public YouTube.Subscriptions.Insert setAlt(String var1) {
            return (YouTube.Subscriptions.Insert)super.setAlt(var1);
         }

         public YouTube.Subscriptions.Insert setFields(String var1) {
            return (YouTube.Subscriptions.Insert)super.setFields(var1);
         }

         public YouTube.Subscriptions.Insert setKey(String var1) {
            return (YouTube.Subscriptions.Insert)super.setKey(var1);
         }

         public YouTube.Subscriptions.Insert setOauthToken(String var1) {
            return (YouTube.Subscriptions.Insert)super.setOauthToken(var1);
         }

         public YouTube.Subscriptions.Insert setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.Subscriptions.Insert setPrettyPrint(Boolean var1) {
            return (YouTube.Subscriptions.Insert)super.setPrettyPrint(var1);
         }

         public YouTube.Subscriptions.Insert setQuotaUser(String var1) {
            return (YouTube.Subscriptions.Insert)super.setQuotaUser(var1);
         }

         public YouTube.Subscriptions.Insert setUserIp(String var1) {
            return (YouTube.Subscriptions.Insert)super.setUserIp(var1);
         }
      }

      public class List extends YouTubeRequest<SubscriptionListResponse> {
         private static final String REST_PATH = "subscriptions";
         @Key
         private String channelId;
         @Key
         private String forChannelId;
         @Key
         private String id;
         @Key
         private Long maxResults;
         @Key
         private Boolean mine;
         @Key
         private Boolean myRecentSubscribers;
         @Key
         private Boolean mySubscribers;
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String onBehalfOfContentOwnerChannel;
         @Key
         private String order;
         @Key
         private String pageToken;
         @Key
         private String part;
         final YouTube.Subscriptions this$1;

         protected List(YouTube.Subscriptions var1, String var2) {
            super(var1.this$0, "GET", "subscriptions", null, SubscriptionListResponse.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         @Override
         public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
         }

         @Override
         public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
         }

         public String getChannelId() {
            return this.channelId;
         }

         public String getForChannelId() {
            return this.forChannelId;
         }

         public String getId() {
            return this.id;
         }

         public Long getMaxResults() {
            return this.maxResults;
         }

         public Boolean getMine() {
            return this.mine;
         }

         public Boolean getMyRecentSubscribers() {
            return this.myRecentSubscribers;
         }

         public Boolean getMySubscribers() {
            return this.mySubscribers;
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getOnBehalfOfContentOwnerChannel() {
            return this.onBehalfOfContentOwnerChannel;
         }

         public String getOrder() {
            return this.order;
         }

         public String getPageToken() {
            return this.pageToken;
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.Subscriptions.List set(String var1, Object var2) {
            return (YouTube.Subscriptions.List)super.set(var1, var2);
         }

         public YouTube.Subscriptions.List setAlt(String var1) {
            return (YouTube.Subscriptions.List)super.setAlt(var1);
         }

         public YouTube.Subscriptions.List setChannelId(String var1) {
            this.channelId = var1;
            return this;
         }

         public YouTube.Subscriptions.List setFields(String var1) {
            return (YouTube.Subscriptions.List)super.setFields(var1);
         }

         public YouTube.Subscriptions.List setForChannelId(String var1) {
            this.forChannelId = var1;
            return this;
         }

         public YouTube.Subscriptions.List setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.Subscriptions.List setKey(String var1) {
            return (YouTube.Subscriptions.List)super.setKey(var1);
         }

         public YouTube.Subscriptions.List setMaxResults(Long var1) {
            this.maxResults = var1;
            return this;
         }

         public YouTube.Subscriptions.List setMine(Boolean var1) {
            this.mine = var1;
            return this;
         }

         public YouTube.Subscriptions.List setMyRecentSubscribers(Boolean var1) {
            this.myRecentSubscribers = var1;
            return this;
         }

         public YouTube.Subscriptions.List setMySubscribers(Boolean var1) {
            this.mySubscribers = var1;
            return this;
         }

         public YouTube.Subscriptions.List setOauthToken(String var1) {
            return (YouTube.Subscriptions.List)super.setOauthToken(var1);
         }

         public YouTube.Subscriptions.List setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.Subscriptions.List setOnBehalfOfContentOwnerChannel(String var1) {
            this.onBehalfOfContentOwnerChannel = var1;
            return this;
         }

         public YouTube.Subscriptions.List setOrder(String var1) {
            this.order = var1;
            return this;
         }

         public YouTube.Subscriptions.List setPageToken(String var1) {
            this.pageToken = var1;
            return this;
         }

         public YouTube.Subscriptions.List setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.Subscriptions.List setPrettyPrint(Boolean var1) {
            return (YouTube.Subscriptions.List)super.setPrettyPrint(var1);
         }

         public YouTube.Subscriptions.List setQuotaUser(String var1) {
            return (YouTube.Subscriptions.List)super.setQuotaUser(var1);
         }

         public YouTube.Subscriptions.List setUserIp(String var1) {
            return (YouTube.Subscriptions.List)super.setUserIp(var1);
         }
      }
   }

   public class SuperChatEvents {
      final YouTube this$0;

      public SuperChatEvents(YouTube var1) {
         this.this$0 = var1;
      }

      public YouTube.SuperChatEvents.List list(String var1) throws IOException {
         YouTube.SuperChatEvents.List var2 = new YouTube.SuperChatEvents.List(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public class List extends YouTubeRequest<SuperChatEventListResponse> {
         private static final String REST_PATH = "superChatEvents";
         @Key
         private String hl;
         @Key
         private Long maxResults;
         @Key
         private String pageToken;
         @Key
         private String part;
         final YouTube.SuperChatEvents this$1;

         protected List(YouTube.SuperChatEvents var1, String var2) {
            super(var1.this$0, "GET", "superChatEvents", null, SuperChatEventListResponse.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         @Override
         public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
         }

         @Override
         public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
         }

         public String getHl() {
            return this.hl;
         }

         public Long getMaxResults() {
            return this.maxResults;
         }

         public String getPageToken() {
            return this.pageToken;
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.SuperChatEvents.List set(String var1, Object var2) {
            return (YouTube.SuperChatEvents.List)super.set(var1, var2);
         }

         public YouTube.SuperChatEvents.List setAlt(String var1) {
            return (YouTube.SuperChatEvents.List)super.setAlt(var1);
         }

         public YouTube.SuperChatEvents.List setFields(String var1) {
            return (YouTube.SuperChatEvents.List)super.setFields(var1);
         }

         public YouTube.SuperChatEvents.List setHl(String var1) {
            this.hl = var1;
            return this;
         }

         public YouTube.SuperChatEvents.List setKey(String var1) {
            return (YouTube.SuperChatEvents.List)super.setKey(var1);
         }

         public YouTube.SuperChatEvents.List setMaxResults(Long var1) {
            this.maxResults = var1;
            return this;
         }

         public YouTube.SuperChatEvents.List setOauthToken(String var1) {
            return (YouTube.SuperChatEvents.List)super.setOauthToken(var1);
         }

         public YouTube.SuperChatEvents.List setPageToken(String var1) {
            this.pageToken = var1;
            return this;
         }

         public YouTube.SuperChatEvents.List setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.SuperChatEvents.List setPrettyPrint(Boolean var1) {
            return (YouTube.SuperChatEvents.List)super.setPrettyPrint(var1);
         }

         public YouTube.SuperChatEvents.List setQuotaUser(String var1) {
            return (YouTube.SuperChatEvents.List)super.setQuotaUser(var1);
         }

         public YouTube.SuperChatEvents.List setUserIp(String var1) {
            return (YouTube.SuperChatEvents.List)super.setUserIp(var1);
         }
      }
   }

   public class Thumbnails {
      final YouTube this$0;

      public Thumbnails(YouTube var1) {
         this.this$0 = var1;
      }

      public YouTube.Thumbnails.Set set(String var1) throws IOException {
         YouTube.Thumbnails.Set var2 = new YouTube.Thumbnails.Set(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public YouTube.Thumbnails.Set set(String var1, AbstractInputStreamContent var2) throws IOException {
         YouTube.Thumbnails.Set var3 = new YouTube.Thumbnails.Set(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public class Set extends YouTubeRequest<ThumbnailSetResponse> {
         private static final String REST_PATH = "thumbnails/set";
         @Key
         private String onBehalfOfContentOwner;
         final YouTube.Thumbnails this$1;
         @Key
         private String videoId;

         protected Set(YouTube.Thumbnails var1, String var2) {
            super(var1.this$0, "POST", "thumbnails/set", null, ThumbnailSetResponse.class);
            this.this$1 = var1;
            this.videoId = Preconditions.checkNotNull(var2, "Required parameter videoId must be specified.");
         }

         protected Set(YouTube.Thumbnails var1, String var2, AbstractInputStreamContent var3) {
            super(var1.this$0, "POST", "/upload/" + var1.this$0.getServicePath() + "thumbnails/set", null, ThumbnailSetResponse.class);
            this.this$1 = var1;
            this.videoId = Preconditions.checkNotNull(var2, "Required parameter videoId must be specified.");
            this.initializeMediaUpload(var3);
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getVideoId() {
            return this.videoId;
         }

         public YouTube.Thumbnails.Set set(String var1, Object var2) {
            return (YouTube.Thumbnails.Set)super.set(var1, var2);
         }

         public YouTube.Thumbnails.Set setAlt(String var1) {
            return (YouTube.Thumbnails.Set)super.setAlt(var1);
         }

         public YouTube.Thumbnails.Set setFields(String var1) {
            return (YouTube.Thumbnails.Set)super.setFields(var1);
         }

         public YouTube.Thumbnails.Set setKey(String var1) {
            return (YouTube.Thumbnails.Set)super.setKey(var1);
         }

         public YouTube.Thumbnails.Set setOauthToken(String var1) {
            return (YouTube.Thumbnails.Set)super.setOauthToken(var1);
         }

         public YouTube.Thumbnails.Set setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.Thumbnails.Set setPrettyPrint(Boolean var1) {
            return (YouTube.Thumbnails.Set)super.setPrettyPrint(var1);
         }

         public YouTube.Thumbnails.Set setQuotaUser(String var1) {
            return (YouTube.Thumbnails.Set)super.setQuotaUser(var1);
         }

         public YouTube.Thumbnails.Set setUserIp(String var1) {
            return (YouTube.Thumbnails.Set)super.setUserIp(var1);
         }

         public YouTube.Thumbnails.Set setVideoId(String var1) {
            this.videoId = var1;
            return this;
         }
      }
   }

   public class VideoAbuseReportReasons {
      final YouTube this$0;

      public VideoAbuseReportReasons(YouTube var1) {
         this.this$0 = var1;
      }

      public YouTube.VideoAbuseReportReasons.List list(String var1) throws IOException {
         YouTube.VideoAbuseReportReasons.List var2 = new YouTube.VideoAbuseReportReasons.List(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public class List extends YouTubeRequest<VideoAbuseReportReasonListResponse> {
         private static final String REST_PATH = "videoAbuseReportReasons";
         @Key
         private String hl;
         @Key
         private String part;
         final YouTube.VideoAbuseReportReasons this$1;

         protected List(YouTube.VideoAbuseReportReasons var1, String var2) {
            super(var1.this$0, "GET", "videoAbuseReportReasons", null, VideoAbuseReportReasonListResponse.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         @Override
         public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
         }

         @Override
         public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
         }

         public String getHl() {
            return this.hl;
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.VideoAbuseReportReasons.List set(String var1, Object var2) {
            return (YouTube.VideoAbuseReportReasons.List)super.set(var1, var2);
         }

         public YouTube.VideoAbuseReportReasons.List setAlt(String var1) {
            return (YouTube.VideoAbuseReportReasons.List)super.setAlt(var1);
         }

         public YouTube.VideoAbuseReportReasons.List setFields(String var1) {
            return (YouTube.VideoAbuseReportReasons.List)super.setFields(var1);
         }

         public YouTube.VideoAbuseReportReasons.List setHl(String var1) {
            this.hl = var1;
            return this;
         }

         public YouTube.VideoAbuseReportReasons.List setKey(String var1) {
            return (YouTube.VideoAbuseReportReasons.List)super.setKey(var1);
         }

         public YouTube.VideoAbuseReportReasons.List setOauthToken(String var1) {
            return (YouTube.VideoAbuseReportReasons.List)super.setOauthToken(var1);
         }

         public YouTube.VideoAbuseReportReasons.List setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.VideoAbuseReportReasons.List setPrettyPrint(Boolean var1) {
            return (YouTube.VideoAbuseReportReasons.List)super.setPrettyPrint(var1);
         }

         public YouTube.VideoAbuseReportReasons.List setQuotaUser(String var1) {
            return (YouTube.VideoAbuseReportReasons.List)super.setQuotaUser(var1);
         }

         public YouTube.VideoAbuseReportReasons.List setUserIp(String var1) {
            return (YouTube.VideoAbuseReportReasons.List)super.setUserIp(var1);
         }
      }
   }

   public class VideoCategories {
      final YouTube this$0;

      public VideoCategories(YouTube var1) {
         this.this$0 = var1;
      }

      public YouTube.VideoCategories.List list(String var1) throws IOException {
         YouTube.VideoCategories.List var2 = new YouTube.VideoCategories.List(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public class List extends YouTubeRequest<VideoCategoryListResponse> {
         private static final String REST_PATH = "videoCategories";
         @Key
         private String hl;
         @Key
         private String id;
         @Key
         private String part;
         @Key
         private String regionCode;
         final YouTube.VideoCategories this$1;

         protected List(YouTube.VideoCategories var1, String var2) {
            super(var1.this$0, "GET", "videoCategories", null, VideoCategoryListResponse.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         @Override
         public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
         }

         @Override
         public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
         }

         public String getHl() {
            return this.hl;
         }

         public String getId() {
            return this.id;
         }

         public String getPart() {
            return this.part;
         }

         public String getRegionCode() {
            return this.regionCode;
         }

         public YouTube.VideoCategories.List set(String var1, Object var2) {
            return (YouTube.VideoCategories.List)super.set(var1, var2);
         }

         public YouTube.VideoCategories.List setAlt(String var1) {
            return (YouTube.VideoCategories.List)super.setAlt(var1);
         }

         public YouTube.VideoCategories.List setFields(String var1) {
            return (YouTube.VideoCategories.List)super.setFields(var1);
         }

         public YouTube.VideoCategories.List setHl(String var1) {
            this.hl = var1;
            return this;
         }

         public YouTube.VideoCategories.List setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.VideoCategories.List setKey(String var1) {
            return (YouTube.VideoCategories.List)super.setKey(var1);
         }

         public YouTube.VideoCategories.List setOauthToken(String var1) {
            return (YouTube.VideoCategories.List)super.setOauthToken(var1);
         }

         public YouTube.VideoCategories.List setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.VideoCategories.List setPrettyPrint(Boolean var1) {
            return (YouTube.VideoCategories.List)super.setPrettyPrint(var1);
         }

         public YouTube.VideoCategories.List setQuotaUser(String var1) {
            return (YouTube.VideoCategories.List)super.setQuotaUser(var1);
         }

         public YouTube.VideoCategories.List setRegionCode(String var1) {
            this.regionCode = var1;
            return this;
         }

         public YouTube.VideoCategories.List setUserIp(String var1) {
            return (YouTube.VideoCategories.List)super.setUserIp(var1);
         }
      }
   }

   public class Videos {
      final YouTube this$0;

      public Videos(YouTube var1) {
         this.this$0 = var1;
      }

      public YouTube.Videos.Delete delete(String var1) throws IOException {
         YouTube.Videos.Delete var2 = new YouTube.Videos.Delete(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public YouTube.Videos.GetRating getRating(String var1) throws IOException {
         YouTube.Videos.GetRating var2 = new YouTube.Videos.GetRating(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public YouTube.Videos.Insert insert(String var1, Video var2) throws IOException {
         YouTube.Videos.Insert var3 = new YouTube.Videos.Insert(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public YouTube.Videos.Insert insert(String var1, Video var2, AbstractInputStreamContent var3) throws IOException {
         YouTube.Videos.Insert var4 = new YouTube.Videos.Insert(this, var1, var2, var3);
         this.this$0.initialize(var4);
         return var4;
      }

      public YouTube.Videos.List list(String var1) throws IOException {
         YouTube.Videos.List var2 = new YouTube.Videos.List(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public YouTube.Videos.Rate rate(String var1, String var2) throws IOException {
         YouTube.Videos.Rate var3 = new YouTube.Videos.Rate(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public YouTube.Videos.ReportAbuse reportAbuse(VideoAbuseReport var1) throws IOException {
         YouTube.Videos.ReportAbuse var2 = new YouTube.Videos.ReportAbuse(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public YouTube.Videos.Update update(String var1, Video var2) throws IOException {
         YouTube.Videos.Update var3 = new YouTube.Videos.Update(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public class Delete extends YouTubeRequest<Void> {
         private static final String REST_PATH = "videos";
         @Key
         private String id;
         @Key
         private String onBehalfOfContentOwner;
         final YouTube.Videos this$1;

         protected Delete(YouTube.Videos var1, String var2) {
            super(var1.this$0, "DELETE", "videos", null, Void.class);
            this.this$1 = var1;
            this.id = Preconditions.checkNotNull(var2, "Required parameter id must be specified.");
         }

         public String getId() {
            return this.id;
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public YouTube.Videos.Delete set(String var1, Object var2) {
            return (YouTube.Videos.Delete)super.set(var1, var2);
         }

         public YouTube.Videos.Delete setAlt(String var1) {
            return (YouTube.Videos.Delete)super.setAlt(var1);
         }

         public YouTube.Videos.Delete setFields(String var1) {
            return (YouTube.Videos.Delete)super.setFields(var1);
         }

         public YouTube.Videos.Delete setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.Videos.Delete setKey(String var1) {
            return (YouTube.Videos.Delete)super.setKey(var1);
         }

         public YouTube.Videos.Delete setOauthToken(String var1) {
            return (YouTube.Videos.Delete)super.setOauthToken(var1);
         }

         public YouTube.Videos.Delete setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.Videos.Delete setPrettyPrint(Boolean var1) {
            return (YouTube.Videos.Delete)super.setPrettyPrint(var1);
         }

         public YouTube.Videos.Delete setQuotaUser(String var1) {
            return (YouTube.Videos.Delete)super.setQuotaUser(var1);
         }

         public YouTube.Videos.Delete setUserIp(String var1) {
            return (YouTube.Videos.Delete)super.setUserIp(var1);
         }
      }

      public class GetRating extends YouTubeRequest<VideoGetRatingResponse> {
         private static final String REST_PATH = "videos/getRating";
         @Key
         private String id;
         @Key
         private String onBehalfOfContentOwner;
         final YouTube.Videos this$1;

         protected GetRating(YouTube.Videos var1, String var2) {
            super(var1.this$0, "GET", "videos/getRating", null, VideoGetRatingResponse.class);
            this.this$1 = var1;
            this.id = Preconditions.checkNotNull(var2, "Required parameter id must be specified.");
         }

         @Override
         public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
         }

         @Override
         public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
         }

         public String getId() {
            return this.id;
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public YouTube.Videos.GetRating set(String var1, Object var2) {
            return (YouTube.Videos.GetRating)super.set(var1, var2);
         }

         public YouTube.Videos.GetRating setAlt(String var1) {
            return (YouTube.Videos.GetRating)super.setAlt(var1);
         }

         public YouTube.Videos.GetRating setFields(String var1) {
            return (YouTube.Videos.GetRating)super.setFields(var1);
         }

         public YouTube.Videos.GetRating setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.Videos.GetRating setKey(String var1) {
            return (YouTube.Videos.GetRating)super.setKey(var1);
         }

         public YouTube.Videos.GetRating setOauthToken(String var1) {
            return (YouTube.Videos.GetRating)super.setOauthToken(var1);
         }

         public YouTube.Videos.GetRating setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.Videos.GetRating setPrettyPrint(Boolean var1) {
            return (YouTube.Videos.GetRating)super.setPrettyPrint(var1);
         }

         public YouTube.Videos.GetRating setQuotaUser(String var1) {
            return (YouTube.Videos.GetRating)super.setQuotaUser(var1);
         }

         public YouTube.Videos.GetRating setUserIp(String var1) {
            return (YouTube.Videos.GetRating)super.setUserIp(var1);
         }
      }

      public class Insert extends YouTubeRequest<Video> {
         private static final String REST_PATH = "videos";
         @Key
         private Boolean autoLevels;
         @Key
         private Boolean notifySubscribers;
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String onBehalfOfContentOwnerChannel;
         @Key
         private String part;
         @Key
         private Boolean stabilize;
         final YouTube.Videos this$1;

         protected Insert(YouTube.Videos var1, String var2, Video var3) {
            super(var1.this$0, "POST", "videos", var3, Video.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         protected Insert(YouTube.Videos var1, String var2, Video var3, AbstractInputStreamContent var4) {
            super(var1.this$0, "POST", "/upload/" + var1.this$0.getServicePath() + "videos", var3, Video.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
            this.initializeMediaUpload(var4);
         }

         public Boolean getAutoLevels() {
            return this.autoLevels;
         }

         public Boolean getNotifySubscribers() {
            return this.notifySubscribers;
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getOnBehalfOfContentOwnerChannel() {
            return this.onBehalfOfContentOwnerChannel;
         }

         public String getPart() {
            return this.part;
         }

         public Boolean getStabilize() {
            return this.stabilize;
         }

         public boolean isNotifySubscribers() {
            boolean var1;
            if (this.notifySubscribers != null && this.notifySubscribers != Data.NULL_BOOLEAN) {
               var1 = this.notifySubscribers;
            } else {
               var1 = true;
            }

            return var1;
         }

         public YouTube.Videos.Insert set(String var1, Object var2) {
            return (YouTube.Videos.Insert)super.set(var1, var2);
         }

         public YouTube.Videos.Insert setAlt(String var1) {
            return (YouTube.Videos.Insert)super.setAlt(var1);
         }

         public YouTube.Videos.Insert setAutoLevels(Boolean var1) {
            this.autoLevels = var1;
            return this;
         }

         public YouTube.Videos.Insert setFields(String var1) {
            return (YouTube.Videos.Insert)super.setFields(var1);
         }

         public YouTube.Videos.Insert setKey(String var1) {
            return (YouTube.Videos.Insert)super.setKey(var1);
         }

         public YouTube.Videos.Insert setNotifySubscribers(Boolean var1) {
            this.notifySubscribers = var1;
            return this;
         }

         public YouTube.Videos.Insert setOauthToken(String var1) {
            return (YouTube.Videos.Insert)super.setOauthToken(var1);
         }

         public YouTube.Videos.Insert setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.Videos.Insert setOnBehalfOfContentOwnerChannel(String var1) {
            this.onBehalfOfContentOwnerChannel = var1;
            return this;
         }

         public YouTube.Videos.Insert setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.Videos.Insert setPrettyPrint(Boolean var1) {
            return (YouTube.Videos.Insert)super.setPrettyPrint(var1);
         }

         public YouTube.Videos.Insert setQuotaUser(String var1) {
            return (YouTube.Videos.Insert)super.setQuotaUser(var1);
         }

         public YouTube.Videos.Insert setStabilize(Boolean var1) {
            this.stabilize = var1;
            return this;
         }

         public YouTube.Videos.Insert setUserIp(String var1) {
            return (YouTube.Videos.Insert)super.setUserIp(var1);
         }
      }

      public class List extends YouTubeRequest<VideoListResponse> {
         private static final String REST_PATH = "videos";
         @Key
         private String chart;
         @Key
         private String hl;
         @Key
         private String id;
         @Key
         private String locale;
         @Key
         private Long maxHeight;
         @Key
         private Long maxResults;
         @Key
         private Long maxWidth;
         @Key
         private String myRating;
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String pageToken;
         @Key
         private String part;
         @Key
         private String regionCode;
         final YouTube.Videos this$1;
         @Key
         private String videoCategoryId;

         protected List(YouTube.Videos var1, String var2) {
            super(var1.this$0, "GET", "videos", null, VideoListResponse.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
         }

         @Override
         public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
         }

         @Override
         public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
         }

         public String getChart() {
            return this.chart;
         }

         public String getHl() {
            return this.hl;
         }

         public String getId() {
            return this.id;
         }

         public String getLocale() {
            return this.locale;
         }

         public Long getMaxHeight() {
            return this.maxHeight;
         }

         public Long getMaxResults() {
            return this.maxResults;
         }

         public Long getMaxWidth() {
            return this.maxWidth;
         }

         public String getMyRating() {
            return this.myRating;
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getPageToken() {
            return this.pageToken;
         }

         public String getPart() {
            return this.part;
         }

         public String getRegionCode() {
            return this.regionCode;
         }

         public String getVideoCategoryId() {
            return this.videoCategoryId;
         }

         public YouTube.Videos.List set(String var1, Object var2) {
            return (YouTube.Videos.List)super.set(var1, var2);
         }

         public YouTube.Videos.List setAlt(String var1) {
            return (YouTube.Videos.List)super.setAlt(var1);
         }

         public YouTube.Videos.List setChart(String var1) {
            this.chart = var1;
            return this;
         }

         public YouTube.Videos.List setFields(String var1) {
            return (YouTube.Videos.List)super.setFields(var1);
         }

         public YouTube.Videos.List setHl(String var1) {
            this.hl = var1;
            return this;
         }

         public YouTube.Videos.List setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.Videos.List setKey(String var1) {
            return (YouTube.Videos.List)super.setKey(var1);
         }

         public YouTube.Videos.List setLocale(String var1) {
            this.locale = var1;
            return this;
         }

         public YouTube.Videos.List setMaxHeight(Long var1) {
            this.maxHeight = var1;
            return this;
         }

         public YouTube.Videos.List setMaxResults(Long var1) {
            this.maxResults = var1;
            return this;
         }

         public YouTube.Videos.List setMaxWidth(Long var1) {
            this.maxWidth = var1;
            return this;
         }

         public YouTube.Videos.List setMyRating(String var1) {
            this.myRating = var1;
            return this;
         }

         public YouTube.Videos.List setOauthToken(String var1) {
            return (YouTube.Videos.List)super.setOauthToken(var1);
         }

         public YouTube.Videos.List setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.Videos.List setPageToken(String var1) {
            this.pageToken = var1;
            return this;
         }

         public YouTube.Videos.List setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.Videos.List setPrettyPrint(Boolean var1) {
            return (YouTube.Videos.List)super.setPrettyPrint(var1);
         }

         public YouTube.Videos.List setQuotaUser(String var1) {
            return (YouTube.Videos.List)super.setQuotaUser(var1);
         }

         public YouTube.Videos.List setRegionCode(String var1) {
            this.regionCode = var1;
            return this;
         }

         public YouTube.Videos.List setUserIp(String var1) {
            return (YouTube.Videos.List)super.setUserIp(var1);
         }

         public YouTube.Videos.List setVideoCategoryId(String var1) {
            this.videoCategoryId = var1;
            return this;
         }
      }

      public class Rate extends YouTubeRequest<Void> {
         private static final String REST_PATH = "videos/rate";
         @Key
         private String id;
         @Key
         private String rating;
         final YouTube.Videos this$1;

         protected Rate(YouTube.Videos var1, String var2, String var3) {
            super(var1.this$0, "POST", "videos/rate", null, Void.class);
            this.this$1 = var1;
            this.id = Preconditions.checkNotNull(var2, "Required parameter id must be specified.");
            this.rating = Preconditions.checkNotNull(var3, "Required parameter rating must be specified.");
         }

         public String getId() {
            return this.id;
         }

         public String getRating() {
            return this.rating;
         }

         public YouTube.Videos.Rate set(String var1, Object var2) {
            return (YouTube.Videos.Rate)super.set(var1, var2);
         }

         public YouTube.Videos.Rate setAlt(String var1) {
            return (YouTube.Videos.Rate)super.setAlt(var1);
         }

         public YouTube.Videos.Rate setFields(String var1) {
            return (YouTube.Videos.Rate)super.setFields(var1);
         }

         public YouTube.Videos.Rate setId(String var1) {
            this.id = var1;
            return this;
         }

         public YouTube.Videos.Rate setKey(String var1) {
            return (YouTube.Videos.Rate)super.setKey(var1);
         }

         public YouTube.Videos.Rate setOauthToken(String var1) {
            return (YouTube.Videos.Rate)super.setOauthToken(var1);
         }

         public YouTube.Videos.Rate setPrettyPrint(Boolean var1) {
            return (YouTube.Videos.Rate)super.setPrettyPrint(var1);
         }

         public YouTube.Videos.Rate setQuotaUser(String var1) {
            return (YouTube.Videos.Rate)super.setQuotaUser(var1);
         }

         public YouTube.Videos.Rate setRating(String var1) {
            this.rating = var1;
            return this;
         }

         public YouTube.Videos.Rate setUserIp(String var1) {
            return (YouTube.Videos.Rate)super.setUserIp(var1);
         }
      }

      public class ReportAbuse extends YouTubeRequest<Void> {
         private static final String REST_PATH = "videos/reportAbuse";
         @Key
         private String onBehalfOfContentOwner;
         final YouTube.Videos this$1;

         protected ReportAbuse(YouTube.Videos var1, VideoAbuseReport var2) {
            super(var1.this$0, "POST", "videos/reportAbuse", var2, Void.class);
            this.this$1 = var1;
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public YouTube.Videos.ReportAbuse set(String var1, Object var2) {
            return (YouTube.Videos.ReportAbuse)super.set(var1, var2);
         }

         public YouTube.Videos.ReportAbuse setAlt(String var1) {
            return (YouTube.Videos.ReportAbuse)super.setAlt(var1);
         }

         public YouTube.Videos.ReportAbuse setFields(String var1) {
            return (YouTube.Videos.ReportAbuse)super.setFields(var1);
         }

         public YouTube.Videos.ReportAbuse setKey(String var1) {
            return (YouTube.Videos.ReportAbuse)super.setKey(var1);
         }

         public YouTube.Videos.ReportAbuse setOauthToken(String var1) {
            return (YouTube.Videos.ReportAbuse)super.setOauthToken(var1);
         }

         public YouTube.Videos.ReportAbuse setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.Videos.ReportAbuse setPrettyPrint(Boolean var1) {
            return (YouTube.Videos.ReportAbuse)super.setPrettyPrint(var1);
         }

         public YouTube.Videos.ReportAbuse setQuotaUser(String var1) {
            return (YouTube.Videos.ReportAbuse)super.setQuotaUser(var1);
         }

         public YouTube.Videos.ReportAbuse setUserIp(String var1) {
            return (YouTube.Videos.ReportAbuse)super.setUserIp(var1);
         }
      }

      public class Update extends YouTubeRequest<Video> {
         private static final String REST_PATH = "videos";
         @Key
         private String onBehalfOfContentOwner;
         @Key
         private String part;
         final YouTube.Videos this$1;

         protected Update(YouTube.Videos var1, String var2, Video var3) {
            super(var1.this$0, "PUT", "videos", var3, Video.class);
            this.this$1 = var1;
            this.part = Preconditions.checkNotNull(var2, "Required parameter part must be specified.");
            this.checkRequiredParameter(var3, "content");
            this.checkRequiredParameter(var3.getAccessToken(), "Video.getAccessToken()");
            this.checkRequiredParameter(var3, "content");
            this.checkRequiredParameter(var3.getId(), "Video.getId()");
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public String getPart() {
            return this.part;
         }

         public YouTube.Videos.Update set(String var1, Object var2) {
            return (YouTube.Videos.Update)super.set(var1, var2);
         }

         public YouTube.Videos.Update setAlt(String var1) {
            return (YouTube.Videos.Update)super.setAlt(var1);
         }

         public YouTube.Videos.Update setFields(String var1) {
            return (YouTube.Videos.Update)super.setFields(var1);
         }

         public YouTube.Videos.Update setKey(String var1) {
            return (YouTube.Videos.Update)super.setKey(var1);
         }

         public YouTube.Videos.Update setOauthToken(String var1) {
            return (YouTube.Videos.Update)super.setOauthToken(var1);
         }

         public YouTube.Videos.Update setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.Videos.Update setPart(String var1) {
            this.part = var1;
            return this;
         }

         public YouTube.Videos.Update setPrettyPrint(Boolean var1) {
            return (YouTube.Videos.Update)super.setPrettyPrint(var1);
         }

         public YouTube.Videos.Update setQuotaUser(String var1) {
            return (YouTube.Videos.Update)super.setQuotaUser(var1);
         }

         public YouTube.Videos.Update setUserIp(String var1) {
            return (YouTube.Videos.Update)super.setUserIp(var1);
         }
      }
   }

   public class Watermarks {
      final YouTube this$0;

      public Watermarks(YouTube var1) {
         this.this$0 = var1;
      }

      public YouTube.Watermarks.Set set(String var1, InvideoBranding var2) throws IOException {
         YouTube.Watermarks.Set var3 = new YouTube.Watermarks.Set(this, var1, var2);
         this.this$0.initialize(var3);
         return var3;
      }

      public YouTube.Watermarks.Set set(String var1, InvideoBranding var2, AbstractInputStreamContent var3) throws IOException {
         YouTube.Watermarks.Set var4 = new YouTube.Watermarks.Set(this, var1, var2, var3);
         this.this$0.initialize(var4);
         return var4;
      }

      public YouTube.Watermarks.Unset unset(String var1) throws IOException {
         YouTube.Watermarks.Unset var2 = new YouTube.Watermarks.Unset(this, var1);
         this.this$0.initialize(var2);
         return var2;
      }

      public class Set extends YouTubeRequest<Void> {
         private static final String REST_PATH = "watermarks/set";
         @Key
         private String channelId;
         @Key
         private String onBehalfOfContentOwner;
         final YouTube.Watermarks this$1;

         protected Set(YouTube.Watermarks var1, String var2, InvideoBranding var3) {
            super(var1.this$0, "POST", "watermarks/set", var3, Void.class);
            this.this$1 = var1;
            this.channelId = Preconditions.checkNotNull(var2, "Required parameter channelId must be specified.");
         }

         protected Set(YouTube.Watermarks var1, String var2, InvideoBranding var3, AbstractInputStreamContent var4) {
            super(var1.this$0, "POST", "/upload/" + var1.this$0.getServicePath() + "watermarks/set", var3, Void.class);
            this.this$1 = var1;
            this.channelId = Preconditions.checkNotNull(var2, "Required parameter channelId must be specified.");
            this.initializeMediaUpload(var4);
         }

         public String getChannelId() {
            return this.channelId;
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public YouTube.Watermarks.Set set(String var1, Object var2) {
            return (YouTube.Watermarks.Set)super.set(var1, var2);
         }

         public YouTube.Watermarks.Set setAlt(String var1) {
            return (YouTube.Watermarks.Set)super.setAlt(var1);
         }

         public YouTube.Watermarks.Set setChannelId(String var1) {
            this.channelId = var1;
            return this;
         }

         public YouTube.Watermarks.Set setFields(String var1) {
            return (YouTube.Watermarks.Set)super.setFields(var1);
         }

         public YouTube.Watermarks.Set setKey(String var1) {
            return (YouTube.Watermarks.Set)super.setKey(var1);
         }

         public YouTube.Watermarks.Set setOauthToken(String var1) {
            return (YouTube.Watermarks.Set)super.setOauthToken(var1);
         }

         public YouTube.Watermarks.Set setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.Watermarks.Set setPrettyPrint(Boolean var1) {
            return (YouTube.Watermarks.Set)super.setPrettyPrint(var1);
         }

         public YouTube.Watermarks.Set setQuotaUser(String var1) {
            return (YouTube.Watermarks.Set)super.setQuotaUser(var1);
         }

         public YouTube.Watermarks.Set setUserIp(String var1) {
            return (YouTube.Watermarks.Set)super.setUserIp(var1);
         }
      }

      public class Unset extends YouTubeRequest<Void> {
         private static final String REST_PATH = "watermarks/unset";
         @Key
         private String channelId;
         @Key
         private String onBehalfOfContentOwner;
         final YouTube.Watermarks this$1;

         protected Unset(YouTube.Watermarks var1, String var2) {
            super(var1.this$0, "POST", "watermarks/unset", null, Void.class);
            this.this$1 = var1;
            this.channelId = Preconditions.checkNotNull(var2, "Required parameter channelId must be specified.");
         }

         public String getChannelId() {
            return this.channelId;
         }

         public String getOnBehalfOfContentOwner() {
            return this.onBehalfOfContentOwner;
         }

         public YouTube.Watermarks.Unset set(String var1, Object var2) {
            return (YouTube.Watermarks.Unset)super.set(var1, var2);
         }

         public YouTube.Watermarks.Unset setAlt(String var1) {
            return (YouTube.Watermarks.Unset)super.setAlt(var1);
         }

         public YouTube.Watermarks.Unset setChannelId(String var1) {
            this.channelId = var1;
            return this;
         }

         public YouTube.Watermarks.Unset setFields(String var1) {
            return (YouTube.Watermarks.Unset)super.setFields(var1);
         }

         public YouTube.Watermarks.Unset setKey(String var1) {
            return (YouTube.Watermarks.Unset)super.setKey(var1);
         }

         public YouTube.Watermarks.Unset setOauthToken(String var1) {
            return (YouTube.Watermarks.Unset)super.setOauthToken(var1);
         }

         public YouTube.Watermarks.Unset setOnBehalfOfContentOwner(String var1) {
            this.onBehalfOfContentOwner = var1;
            return this;
         }

         public YouTube.Watermarks.Unset setPrettyPrint(Boolean var1) {
            return (YouTube.Watermarks.Unset)super.setPrettyPrint(var1);
         }

         public YouTube.Watermarks.Unset setQuotaUser(String var1) {
            return (YouTube.Watermarks.Unset)super.setQuotaUser(var1);
         }

         public YouTube.Watermarks.Unset setUserIp(String var1) {
            return (YouTube.Watermarks.Unset)super.setUserIp(var1);
         }
      }
   }
}
