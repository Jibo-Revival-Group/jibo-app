package com.salesforce.android.knowledge.ui;

public enum KnowledgeScene {
   SCENE_ARTICLE_DETAIL,
   SCENE_ARTICLE_LIST,
   SCENE_CATEGORY_DETAIL,
   SCENE_HOME,
   SCENE_NONE,
   SCENE_SEARCH;

   private static final KnowledgeScene[] $VALUES = new KnowledgeScene[]{
      KnowledgeScene.SCENE_NONE,
      KnowledgeScene.SCENE_HOME,
      KnowledgeScene.SCENE_ARTICLE_LIST,
      KnowledgeScene.SCENE_CATEGORY_DETAIL,
      KnowledgeScene.SCENE_ARTICLE_DETAIL,
      KnowledgeScene.SCENE_SEARCH
   };
}
