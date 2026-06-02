package com.jibo.ui.helpers.skills;

import com.crashlytics.android.Crashlytics;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import com.jibo.ui.fragment.settings.RobotSettingsFragment;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

public class SkillsJsonParser {
   public static final String TYPE_CHOICE = "choice";
   public static final String TYPE_CONNECTABLE = "connectable";
   public static final String TYPE_FOOTER = "footer";
   public static final String TYPE_LOCATION = "location";
   public static final String TYPE_LOCATION_TEXTFIELD = "locationTextField";
   public static final String TYPE_OAUTH = "oauth";
   public static final String TYPE_SKILL = "skill";
   public static final String TYPE_SUBHEADER = "subheader";
   public static final String TYPE_SWITCH = "switch";
   public static final String TYPE_TIME = "time";
   public static final String TYPE_TOGGLE = "toggle";
   private static Gson gson = new GsonBuilder()
      .a(DataItems.DataItem.class, new SkillsJsonParser.DataDeserializer())
      .a(DataItems.BooleanDataValue.class, new SkillsJsonParser.BooleanDataValueDeserializer())
      .a();
   private static HashMap<String, Class> mDataValueClassesMap = new HashMap<>();
   private static HashMap<String, Class> mSimpleTypeClassesMap = new HashMap<>();
   private static HashMap<String, Class> sComplexTypesClassesMap = new HashMap<>();
   private static SkillsJsonParser sInstance;
   private int mCurrentSkillIndx = 0;
   private DataItems mDataItems;

   static {
      sComplexTypesClassesMap.put("switch", DataItems.SwitchDataItem.class);
      sComplexTypesClassesMap.put("locationTextField", DataItems.LocationDataItem.class);
      sComplexTypesClassesMap.put("connectable", DataItems.ConnectableDataItem.class);
      mSimpleTypeClassesMap.put("skill", DataItems.SkillDataItem.class);
      mSimpleTypeClassesMap.put("subheader", DataItems.SubheaderDataItem.class);
      mSimpleTypeClassesMap.put("footer", DataItems.FooterDataItem.class);
      mSimpleTypeClassesMap.put("location", DataItems.LocationDataItem.class);
      mSimpleTypeClassesMap.put("choice", DataItems.ChoiceDataItem.class);
      mSimpleTypeClassesMap.put("oauth", DataItems.OauthDataItem.class);
      mSimpleTypeClassesMap.put("toggle", DataItems.ToggleDataItem.class);
      mSimpleTypeClassesMap.put("time", DataItems.TimeDataItem.class);
      mDataValueClassesMap.put("switch", DataItems.BooleanDataValue.class);
      mDataValueClassesMap.put("locationTextField", DataItems.LocationDataValue.class);
      mDataValueClassesMap.put("location", DataItems.LocationDataValue.class);
      mDataValueClassesMap.put("choice", DataItems.IntegerDataValue.class);
      mDataValueClassesMap.put("connectable", DataItems.ConnectableDataValue.class);
      mDataValueClassesMap.put("oauth", DataItems.OauthDataValue.class);
      mDataValueClassesMap.put("toggle", DataItems.BooleanDataValue.class);
      mDataValueClassesMap.put("time", DataItems.TimeDataValue.class);
   }

   public static SkillsJsonParser getInstance() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: ldc com/jibo/ui/helpers/skills/SkillsJsonParser
      // 02: monitorenter
      // 03: getstatic com/jibo/ui/helpers/skills/SkillsJsonParser.sInstance Lcom/jibo/ui/helpers/skills/SkillsJsonParser;
      // 06: astore 1
      // 07: aload 1
      // 08: astore 0
      // 09: aload 1
      // 0a: ifnonnull 29
      // 0d: ldc com/jibo/ui/helpers/skills/SkillsJsonParser
      // 0f: monitorenter
      // 10: getstatic com/jibo/ui/helpers/skills/SkillsJsonParser.sInstance Lcom/jibo/ui/helpers/skills/SkillsJsonParser;
      // 13: astore 1
      // 14: aload 1
      // 15: astore 0
      // 16: aload 1
      // 17: ifnonnull 26
      // 1a: new com/jibo/ui/helpers/skills/SkillsJsonParser
      // 1d: astore 0
      // 1e: aload 0
      // 1f: invokespecial com/jibo/ui/helpers/skills/SkillsJsonParser.<init> ()V
      // 22: aload 0
      // 23: putstatic com/jibo/ui/helpers/skills/SkillsJsonParser.sInstance Lcom/jibo/ui/helpers/skills/SkillsJsonParser;
      // 26: ldc com/jibo/ui/helpers/skills/SkillsJsonParser
      // 28: monitorexit
      // 29: ldc com/jibo/ui/helpers/skills/SkillsJsonParser
      // 2b: monitorexit
      // 2c: aload 0
      // 2d: areturn
      // 2e: astore 0
      // 2f: ldc com/jibo/ui/helpers/skills/SkillsJsonParser
      // 31: monitorexit
      // 32: aload 0
      // 33: athrow
      // 34: astore 0
      // 35: ldc com/jibo/ui/helpers/skills/SkillsJsonParser
      // 37: monitorexit
      // 38: aload 0
      // 39: athrow
      // try (2 -> 4): 33 null
      // try (8 -> 10): 33 null
      // try (10 -> 12): 28 null
      // try (16 -> 22): 28 null
      // try (22 -> 24): 28 null
      // try (29 -> 31): 28 null
      // try (31 -> 33): 33 null
   }

   private boolean isConfigured(JsonElement var1) {
      boolean var2;
      if (var1.i()) {
         var2 = this.isConfigured(var1.l().a());
      } else if (var1.j() && ((JsonPrimitive)var1).a()) {
         var2 = var1.g();
      } else {
         var2 = true;
      }

      return var2;
   }

   private boolean isConfigured(Set<Entry<String, JsonElement>> var1) {
      Iterator var4 = var1.iterator();
      boolean var2 = false;

      while (var4.hasNext()) {
         Entry var3 = (Entry)var4.next();
         if (!((String)var3.getKey()).equals("offerProactively")) {
            var2 |= this.isConfigured((JsonElement)var3.getValue());
         }
      }

      return var2;
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // $VF: Could not create synchronized statement, marking monitor enters and exits
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static boolean isCreated() {
      synchronized (SkillsJsonParser.class){} // $VF: monitorenter 
      boolean var3 = false /* VF: Semaphore variable */;

      SkillsJsonParser var1;
      try {
         var3 = true;
         var1 = sInstance;
         var3 = false;
      } finally {
         if (var3) {
            // $VF: monitorexit
         }
      }

      boolean var0;
      if (var1 != null) {
         var0 = true;
      } else {
         var0 = false;
      }

      // $VF: monitorexit
      return var0;
   }

   private void setItemDataValue(DataItems.DataItem var1, Class var2) {
      if (var2 != null) {
         var1.getValueDefinition().setDataValue(gson.a(this.getSkills().get(this.mCurrentSkillIndx).getData().e(var1.getValueDefinition().getKey()), var2));
      }
   }

   public void clearSkills() {
      this.mDataItems = null;
      this.mDataItems = new DataItems();
   }

   public DataItems.SkillDataItem getCurrentSkill() {
      return this.getSkills().get(this.mCurrentSkillIndx);
   }

   public List<DataItems.SkillDataItem> getSkills() {
      List var1;
      if (this.mDataItems != null) {
         var1 = this.mDataItems.getSkills();
      } else {
         var1 = null;
      }

      return var1;
   }

   public DataItems.DataItem getView(int[] var1) {
      DataItems.SkillViewDataItem var4 = null;
      DataItems.DataItem var3 = var4;
      if (this.mDataItems != null) {
         var3 = var4;
         if (this.mDataItems.getSkills() != null) {
            if (this.mDataItems.getSkills().isEmpty()) {
               var3 = var4;
            } else if (var1 != null && var1.length != 0) {
               var3 = var4;
               if (this.mDataItems.getSkills().size() > var1[0]) {
                  var4 = this.mDataItems.getSkills().get(var1[0]).getView();
                  if (var4.getChildViews() != null) {
                     int var2 = 1;

                     while (true) {
                        var3 = var4;
                        if (var2 >= var1.length) {
                           break;
                        }

                        var3 = var4;
                        if (!(var4 instanceof DataItems.GroupDataItem)) {
                           break;
                        }

                        var3 = var4;
                        if (var4.getChildViews() == null) {
                           break;
                        }

                        var3 = var4;
                        if (var4.getChildViews().size() <= var1[var2]) {
                           break;
                        }

                        var4 = var4.getChildViews().get(var1[var2]);
                        var2++;
                     }
                  } else {
                     var3 = null;
                  }
               }
            } else {
               ArrayList var5 = new ArrayList();
               Iterator var6 = this.mDataItems.getSkills().iterator();

               while (true) {
                  var3 = var4;
                  if (!var6.hasNext()) {
                     break;
                  }

                  var5.add(((DataItems.SkillDataItem)var6.next()).getView());
               }
            }
         }
      }

      return var3;
   }

   public List<DataItems.DataItem> getViews(int[] var1) {
      List var4 = null;
      Object var5 = null;
      List var3 = (List)var5;
      if (this.mDataItems != null) {
         var3 = (List)var5;
         if (this.mDataItems.getSkills() != null) {
            if (this.mDataItems.getSkills().isEmpty()) {
               var3 = (List)var5;
            } else if (var1 != null && var1.length != 0) {
               var3 = (List)var5;
               if (this.mDataItems.getSkills().size() > var1[0]) {
                  DataItems.SkillDataItem var9 = this.mDataItems.getSkills().get(var1[0]);
                  DataItems.DataItem var10 = this.mDataItems.getSkills().get(var1[0]).getView();
                  if (((DataItems.SkillViewDataItem)var10).getChildViews() != null) {
                     for (int var2 = 1;
                        var2 < var1.length
                           && var10 instanceof DataItems.GroupDataItem
                           && ((DataItems.GroupDataItem)var10).getChildViews() != null
                           && ((DataItems.GroupDataItem)var10).getChildViews().size() > var1[var2];
                        var2++
                     ) {
                        var10 = ((DataItems.GroupDataItem)var10).getChildViews().get(var1[var2]);
                     }

                     List var7;
                     if (var10 instanceof DataItems.GroupDataItem) {
                        var7 = ((DataItems.GroupDataItem)var10).getChildViews();
                     } else {
                        var7 = null;
                     }

                     var4 = var7;
                  }

                  var3 = var4;
                  if (var4 != null) {
                     var3 = var4;
                     if (!var4.isEmpty()) {
                        Collections.sort(var4, new Comparator<DataItems.DataItem>(this) {
                           final SkillsJsonParser this$0;

                           {
                              this.this$0 = var1;
                           }

                           public int compare(DataItems.DataItem var1, DataItems.DataItem var2) {
                              return var1.getIndex() - var2.getIndex();
                           }
                        });
                        Iterator var8 = var4.iterator();

                        while (true) {
                           var3 = var4;
                           if (!var8.hasNext()) {
                              break;
                           }

                           DataItems.DataItem var11 = (DataItems.DataItem)var8.next();
                           this.setItemDataValue(var11, mDataValueClassesMap.get(var11.getType()));
                        }
                     }
                  }
               }
            } else {
               ArrayList var6 = new ArrayList();
               Iterator var12 = this.mDataItems.getSkills().iterator();

               while (true) {
                  var3 = var6;
                  if (!var12.hasNext()) {
                     break;
                  }

                  var6.add(((DataItems.SkillDataItem)var12.next()).getView());
               }
            }
         }
      }

      return var3;
   }

   public boolean isConfigured() {
      boolean var5;
      try {
         JsonObject var2 = this.getSkills().get(0).getData();
         Set var3 = var2.a();
         if (var2.p() > 7) {
            return true;
         }

         var5 = this.isConfigured(var3);
      } catch (Exception var4) {
         return true;
      }

      return var5;
   }

   public SkillsJsonParser parseSkills(String var1) {
      try {
         DataItems var2 = new DataItems();
         this.mDataItems = var2;
         JsonParser var6 = new JsonParser();
         if (var6.a(var1).h()) {
            Gson var7 = gson;
            TypeToken var3 = new TypeToken<List<DataItems.SkillDataItem>>(this) {
               final SkillsJsonParser this$0;

               {
                  this.this$0 = var1;
               }
            };
            List var5 = var7.a(var1, var3.getType());
            Comparator var8 = new Comparator<DataItems.SkillDataItem>(this) {
               final SkillsJsonParser this$0;

               {
                  this.this$0 = var1;
               }

               public int compare(DataItems.SkillDataItem var1, DataItems.SkillDataItem var2x) {
                  return var1.getView().getIndex() - var2x.getView().getIndex();
               }
            };
            Collections.sort(var5, var8);
            this.mDataItems.addSkills(var5);
         } else {
            this.mDataItems.addSkill(gson.a(var1, DataItems.SkillDataItem.class));
         }
      } catch (Exception var4) {
         Crashlytics.a(var4);
      }

      return this;
   }

   public void selectSkill(int var1) {
      this.mCurrentSkillIndx = var1;
   }

   public void setItemDataValue(DataItems.DataItem var1) {
      this.setItemDataValue(var1, mDataValueClassesMap.get(var1.getType()));
   }

   public void updateData(String var1, JsonElement var2) {
      this.getSkills().get(this.mCurrentSkillIndx).getData().a(var1, var2);
   }

   public void updateData(String var1, DataItems.DataValue var2) {
      this.getSkills().get(this.mCurrentSkillIndx).getData().a(var1, gson.a(var2));
   }

   static class BooleanDataValueDeserializer implements JsonDeserializer<DataItems.BooleanDataValue> {
      public DataItems.BooleanDataValue deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         boolean var4 = false;
         DataItems.BooleanDataValue var7 = new DataItems.BooleanDataValue();
         JsonElement var8 = var1.l().c("value");
         var1 = var8.n();
         Boolean var6;
         if (var1.a()) {
            var6 = var8.g();
         } else if (var1.p()) {
            if (var8.f() != 0) {
               var4 = true;
            }

            var6 = var4;
         } else {
            var6 = false;
         }

         var7.setValue(var6);
         return var7;
      }
   }

   static class DataDeserializer<T> implements JsonDeserializer<T> {
      @Override
      public T deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         JsonElement var6 = var1.l().c("childViews");
         if (var6 != null && !var6.h()) {
            var1.l().a("childViews");
            JsonArray var4 = new JsonArray();
            var4.a(var6);
            var1.l().a("childViews", var4);
         }

         if (SkillsJsonParser.mSimpleTypeClassesMap.containsKey(var1.l().c("type").c())) {
            var2 = SkillsJsonParser.mSimpleTypeClassesMap.get(var1.l().c("type").c());
         }

         Object var5;
         if (SkillsJsonParser.sComplexTypesClassesMap.containsKey(var1.l().c("type").c())) {
            var5 = SkillsJsonParser.gson.a(var1.l(), SkillsJsonParser.sComplexTypesClassesMap.get(var1.l().c("type").c()));
         } else {
            var5 = new Gson().a(var1.l(), var2);
         }

         return (T)var5;
      }
   }

   public static class ImageUrlMatcher {
      private static HashMap<String, Integer> sIconsHashMap = new HashMap<>();

      static {
         sIconsHashMap.put("ic_bike", 2131230997);
         sIconsHashMap.put("ic_drive", 2131231009);
         sIconsHashMap.put("ic_transport", 2131231077);
         sIconsHashMap.put("ic_walk", 2131231081);
         sIconsHashMap.put("personal_report_icon", 2131230989);
      }

      public static int getImageForUrl(String var0) {
         int var1;
         if (sIconsHashMap.containsKey(var0)) {
            var1 = sIconsHashMap.get(var0);
         } else {
            var1 = -1;
         }

         return var1;
      }

      public static boolean isExternal(String var0) {
         return var0.startsWith("http");
      }
   }

   public static class TextLinksMatcher {
      private static HashMap<String, Class> sFragmentHashMap = new HashMap<>();

      static {
         sFragmentHashMap.put("JIBO_SETTINGS", RobotSettingsFragment.class);
      }

      public static Class getClassForPlaceholder(String var0) {
         Class var1;
         if (sFragmentHashMap.containsKey(var0)) {
            var1 = sFragmentHashMap.get(var0);
         } else {
            var1 = null;
         }

         return var1;
      }
   }
}
