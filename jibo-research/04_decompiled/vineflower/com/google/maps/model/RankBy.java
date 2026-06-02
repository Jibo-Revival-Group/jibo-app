package com.google.maps.model;

import com.google.maps.internal.StringJoin;

public enum RankBy implements StringJoin.UrlValue {
   DISTANCE("distance"),
   PROMINENCE("prominence");

   private static final RankBy[] $VALUES = new RankBy[]{RankBy.PROMINENCE, RankBy.DISTANCE};
   private final String ranking;

   RankBy(String var3) {
      this.ranking = var3;
   }

   @Override
   public String toString() {
      return this.ranking;
   }

   @Override
   public String toUrlValue() {
      return this.ranking;
   }
}
