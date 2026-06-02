package com.salesforce.android.knowledge.ui.internal.logging;

import com.salesforce.android.knowledge.ui.KnowledgeScene;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import java.util.Map;

class Translator {
   String a = null;
   String b = null;

   void a(KbBasicInfo var1, String var2, AnalyticsHook var3) {
      var3.a("KNOWLEDGE_UI_USER_LAUNCH", new AnalyticsHook.Translation(this, var1, var2) {
         final KbBasicInfo a;
         final String b;
         final Translator c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3x;
         }

         @Override
         public BaseEvent a(String var1, Map<String, Object> var2x) {
            return new LoggingEvent.KnowledgeEvent(this.a, this.b, "kb_launched");
         }
      });
      var3.a("KNOWLEDGE_UI_RESPONSE_LAUNCHED", new AnalyticsHook.Translation(this, var1, var2) {
         final KbBasicInfo a;
         final String b;
         final Translator c;

         {
            this.c = var1;
            this.a = var2;
            this.b = var3;
         }

         @Override
         public BaseEvent a(String var1, Map<String, Object> var2) {
            return new LoggingEvent.KnowledgeEvent(this.a, this.b, "kb_loaded");
         }
      });
      var3.a("KNOWLEDGE_UI_USER_CLOSE", new AnalyticsHook.Translation(this, var1, var2) {
         final KbBasicInfo a;
         final String b;
         final Translator c;

         {
            this.c = var1;
            this.a = var2;
            this.b = var3;
         }

         @Override
         public BaseEvent a(String var1, Map<String, Object> var2) {
            return new LoggingEvent.KnowledgeEvent(this.a, this.b, "kb_dismissed");
         }
      });
      var3.a("KNOWLEDGE_UI_RESPONSE_EXPANDED_CATEGORY_HEADER", new AnalyticsHook.Translation(this, var1, var2) {
         final KbBasicInfo a;
         final String b;
         final Translator c;

         {
            this.c = var1;
            this.a = var2;
            this.b = var3;
         }

         @Override
         public BaseEvent a(String var1, Map<String, Object> var2) {
            var1 = (String)var2.get("KNOWLEDGE_UI_DATA_CATEGORY_LABEL");
            return new LoggingEvent.DataCategoryEvent(this.a, this.b, "dataCategory_selected", var1);
         }
      });
      var3.a("KNOWLEDGE_UI_USER_SELECT_ARTICLE_DETAILS", new AnalyticsHook.Translation(this, var1, var2) {
         final KbBasicInfo a;
         final String b;
         final Translator c;

         {
            this.c = var1;
            this.a = var2;
            this.b = var3;
         }

         @Override
         public BaseEvent a(String var1, Map<String, Object> var2) {
            this.c.a = (String)var2.get("KNOWLEDGE_UI_DATA_ARTICLE_ID");
            this.c.b = (String)var2.get("KNOWLEDGE_UI_DATA_ARTICLE_TITLE");
            return new LoggingEvent.ArticleEvent(this.a, this.b, "article_selected", null, this.c.a, this.c.b);
         }
      });
      var3.a("KNOWLEDGE_UI_RESPONSE_LOADED_ARTICLE_DETAIL_VIEW", new AnalyticsHook.Translation(this, var1, var2) {
         final KbBasicInfo a;
         final String b;
         final Translator c;

         {
            this.c = var1;
            this.a = var2;
            this.b = var3;
         }

         @Override
         public BaseEvent a(String var1, Map<String, Object> var2) {
            var1 = (String)var2.get("KNOWLEDGE_UI_DATA_ARTICLE_ID");
            String var4 = (String)var2.get("KNOWLEDGE_UI_DATA_ARTICLE_TITLE");
            return new LoggingEvent.ArticleEvent(this.a, this.b, "article_loaded", null, var1, var4);
         }
      });
      var3.a("KNOWLEDGE_UI_USER_NAVIGATE_BACK", new AnalyticsHook.Translation(this, var1, var2) {
         final KbBasicInfo a;
         final String b;
         final Translator c;

         {
            this.c = var1;
            this.a = var2;
            this.b = var3;
         }

         @Override
         public BaseEvent a(String var1, Map<String, Object> var2) {
            LoggingEvent.ArticleEvent var3;
            if (var2.get("KNOWLEDGE_UI_DATA_KNOWLEDGE_FROM_SCENE") == KnowledgeScene.SCENE_ARTICLE_DETAIL) {
               var3 = new LoggingEvent.ArticleEvent(this.a, this.b, "article_dismissed", null, this.c.a, this.c.b);
            } else {
               var3 = null;
            }

            return var3;
         }
      });
      var3.a("KNOWLEDGE_UI_USER_SELECT_CATEGORY_DETAIL", new AnalyticsHook.Translation(this, var1, var2) {
         final KbBasicInfo a;
         final String b;
         final Translator c;

         {
            this.c = var1;
            this.a = var2;
            this.b = var3;
         }

         @Override
         public BaseEvent a(String var1, Map<String, Object> var2) {
            var1 = (String)var2.get("KNOWLEDGE_UI_DATA_CATEGORY_LABEL");
            return new LoggingEvent.CategoryEvent(this.a, this.b, "category_selected", var1, null);
         }
      });
      var3.a("KNOWLEDGE_UI_RESPONSE_LOADED_CATEGORY_DETAIL_VIEW", new AnalyticsHook.Translation(this, var1, var2) {
         final KbBasicInfo a;
         final String b;
         final Translator c;

         {
            this.c = var1;
            this.a = var2;
            this.b = var3;
         }

         @Override
         public BaseEvent a(String var1, Map<String, Object> var2) {
            var1 = (String)var2.get("KNOWLEDGE_UI_DATA_CATEGORY_LABEL");
            return new LoggingEvent.CategoryEvent(this.a, this.b, "category_loaded", var1, null);
         }
      });
      var3.a("KNOWLEDGE_UI_USER_MINIMIZE", new AnalyticsHook.Translation(this, var1, var2) {
         final KbBasicInfo a;
         final String b;
         final Translator c;

         {
            this.c = var1;
            this.a = var2;
            this.b = var3;
         }

         @Override
         public BaseEvent a(String var1, Map<String, Object> var2) {
            var1 = (String)var2.get("KNOWLEDGE_UI_DATA_ARTICLE_ID");
            String var4 = (String)var2.get("KNOWLEDGE_UI_DATA_ARTICLE_TITLE");
            return new LoggingEvent.ViewStateEvent(this.a, this.b, "minimized", var1, var4);
         }
      });
      var3.a("KNOWLEDGE_UI_USER_MAXIMIZE", new AnalyticsHook.Translation(this, var1, var2) {
         final KbBasicInfo a;
         final String b;
         final Translator c;

         {
            this.c = var1;
            this.a = var2;
            this.b = var3;
         }

         @Override
         public BaseEvent a(String var1, Map<String, Object> var2) {
            var1 = (String)var2.get("KNOWLEDGE_UI_DATA_ARTICLE_ID");
            String var4 = (String)var2.get("KNOWLEDGE_UI_DATA_ARTICLE_TITLE");
            return new LoggingEvent.ViewStateEvent(this.a, this.b, "maximized", var1, var4);
         }
      });
      var3.a("KNOWLEDGE_UI_USER_SELECT_ARTICLE_LIST", new AnalyticsHook.Translation(this, var1, var2) {
         final KbBasicInfo a;
         final String b;
         final Translator c;

         {
            this.c = var1;
            this.a = var2;
            this.b = var3;
         }

         @Override
         public BaseEvent a(String var1, Map<String, Object> var2) {
            var1 = (String)var2.get("KNOWLEDGE_UI_DATA_CATEGORY_LABEL");
            return new LoggingEvent.ArticleListEvent(this.a, this.b, "articleList_selected", null, null, var1);
         }
      });
      var3.a("KNOWLEDGE_UI_RESPONSE_LOADED_ARTICLE_LIST_VIEW", new AnalyticsHook.Translation(this, var1, var2) {
         final KbBasicInfo a;
         final String b;
         final Translator c;

         {
            this.c = var1;
            this.a = var2;
            this.b = var3;
         }

         @Override
         public BaseEvent a(String var1, Map<String, Object> var2) {
            var1 = (String)var2.get("KNOWLEDGE_UI_DATA_CATEGORY_LABEL");
            return new LoggingEvent.ArticleListEvent(this.a, this.b, "articleList_loaded", null, null, var1);
         }
      });
      var3.a("KNOWLEDGE_UI_USER_SHOW_MORE_ARTICLES", new AnalyticsHook.Translation(this, var1, var2) {
         final KbBasicInfo a;
         final String b;
         final Translator c;

         {
            this.c = var1;
            this.a = var2;
            this.b = var3;
         }

         @Override
         public BaseEvent a(String var1, Map<String, Object> var2) {
            var1 = (String)var2.get("KNOWLEDGE_UI_DATA_CATEGORY_LABEL");
            return new LoggingEvent.ArticleListEvent(this.a, this.b, "showMore_selected", null, null, var1);
         }
      });
      var3.a("KNOWLEDGE_UI_RESPONSE_LOADED_MORE_ARTICLES", new AnalyticsHook.Translation(this, var1, var2) {
         final KbBasicInfo a;
         final String b;
         final Translator c;

         {
            this.c = var1;
            this.a = var2;
            this.b = var3;
         }

         @Override
         public BaseEvent a(String var1, Map<String, Object> var2) {
            var1 = (String)var2.get("KNOWLEDGE_UI_DATA_CATEGORY_LABEL");
            return new LoggingEvent.ArticleListEvent(this.a, this.b, "showMore_loaded", null, null, var1);
         }
      });
      var3.a("KNOWLEDGE_UI_USER_INPUT_SEARCH_TERM", new AnalyticsHook.Translation(this, var1, var2) {
         final KbBasicInfo a;
         final String b;
         final Translator c;

         {
            this.c = var1;
            this.a = var2;
            this.b = var3;
         }

         @Override
         public BaseEvent a(String var1, Map<String, Object> var2) {
            return new LoggingEvent.SearchEvent(this.a, this.b);
         }
      });
   }
}
