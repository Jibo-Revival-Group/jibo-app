package com.facebook.share;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.internal.CollectionMapper;
import com.facebook.internal.Mutable;
import com.facebook.internal.Utility;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.VideoUploader;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ShareApi {
   private static final String DEFAULT_CHARSET = "UTF-8";
   private static final String DEFAULT_GRAPH_NODE = "me";
   private static final String GRAPH_PATH_FORMAT = "%s/%s";
   private static final String PHOTOS_EDGE = "photos";
   private static final String TAG = "ShareApi";
   private String graphNode;
   private String message;
   private final ShareContent shareContent;

   public ShareApi(ShareContent var1) {
      this.shareContent = var1;
      this.graphNode = "me";
   }

   private void addCommonParameters(Bundle var1, ShareContent var2) {
      List var3 = var2.getPeopleIds();
      if (!Utility.isNullOrEmpty(var3)) {
         var1.putString("tags", TextUtils.join(", ", var3));
      }

      if (!Utility.isNullOrEmpty(var2.getPlaceId())) {
         var1.putString("place", var2.getPlaceId());
      }

      if (!Utility.isNullOrEmpty(var2.getRef())) {
         var1.putString("ref", var2.getRef());
      }
   }

   private String getGraphPath(String var1) {
      try {
         var1 = String.format(Locale.ROOT, "%s/%s", URLEncoder.encode(this.getGraphNode(), "UTF-8"), var1);
      } catch (UnsupportedEncodingException var2) {
         var1 = null;
      }

      return var1;
   }

   private Bundle getSharePhotoCommonParameters(SharePhoto var1, SharePhotoContent var2) throws JSONException {
      Bundle var7 = var1.getParameters();
      if (!var7.containsKey("place") && !Utility.isNullOrEmpty(var2.getPlaceId())) {
         var7.putString("place", var2.getPlaceId());
      }

      if (!var7.containsKey("tags") && !Utility.isNullOrEmpty(var2.getPeopleIds())) {
         List var4 = var2.getPeopleIds();
         if (!Utility.isNullOrEmpty(var4)) {
            JSONArray var3 = new JSONArray();

            for (String var5 : var4) {
               JSONObject var8 = new JSONObject();
               var8.put("tag_uid", var5);
               var3.put(var8);
            }

            var7.putString("tags", var3.toString());
         }
      }

      if (!var7.containsKey("ref") && !Utility.isNullOrEmpty(var2.getRef())) {
         var7.putString("ref", var2.getRef());
      }

      return var7;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static void handleImagesOnAction(Bundle var0) {
      int var1 = 0;
      String var2 = var0.getString("image");
      if (var2 != null) {
         label52: {
            JSONArray var3;
            try {
               var3 = new JSONArray(var2);
            } catch (JSONException var9) {
               break label52;
            }

            while (true) {
               JSONObject var4;
               try {
                  if (var1 >= var3.length()) {
                     break;
                  }

                  var4 = var3.optJSONObject(var1);
               } catch (JSONException var10) {
                  break label52;
               }

               if (var4 != null) {
                  try {
                     putImageInBundleWithArrayFormat(var0, var1, var4);
                  } catch (JSONException var8) {
                     break label52;
                  }
               } else {
                  try {
                     String var12 = var3.getString(var1);
                     var0.putString(String.format(Locale.ROOT, "image[%d][url]", var1), var12);
                  } catch (JSONException var7) {
                     break label52;
                  }
               }

               var1++;
            }

            try {
               var0.remove("image");
               return;
            } catch (JSONException var6) {
            }
         }

         try {
            JSONObject var11 = new JSONObject(var2);
            putImageInBundleWithArrayFormat(var0, 0, var11);
            var0.remove("image");
         } catch (JSONException var5) {
         }
      }
   }

   private static void putImageInBundleWithArrayFormat(Bundle var0, int var1, JSONObject var2) throws JSONException {
      Iterator var3 = var2.keys();

      while (var3.hasNext()) {
         String var4 = (String)var3.next();
         var0.putString(String.format(Locale.ROOT, "image[%d][%s]", var1, var4), var2.get(var4).toString());
      }
   }

   public static void share(ShareContent var0, FacebookCallback<Sharer.Result> var1) {
      new ShareApi(var0).share(var1);
   }

   private void shareLinkContent(ShareLinkContent var1, FacebookCallback<Sharer.Result> var2) {
      GraphRequest.Callback var3 = new GraphRequest.Callback(this, var2) {
         final ShareApi this$0;
         final FacebookCallback val$callback;

         {
            this.this$0 = var1;
            this.val$callback = var2x;
         }

         @Override
         public void onCompleted(GraphResponse var1) {
            JSONObject var2x = var1.getJSONObject();
            String var3x;
            if (var2x == null) {
               var3x = null;
            } else {
               var3x = var2x.optString("id");
            }

            ShareInternalUtility.invokeCallbackWithResults(this.val$callback, var3x, var1);
         }
      };
      Bundle var4 = new Bundle();
      this.addCommonParameters(var4, var1);
      var4.putString("message", this.getMessage());
      var4.putString("link", Utility.getUriString(var1.getContentUrl()));
      var4.putString("picture", Utility.getUriString(var1.getImageUrl()));
      var4.putString("name", var1.getContentTitle());
      var4.putString("description", var1.getContentDescription());
      var4.putString("ref", var1.getRef());
      new GraphRequest(AccessToken.getCurrentAccessToken(), this.getGraphPath("feed"), var4, HttpMethod.POST, var3).executeAsync();
   }

   private void shareOpenGraphContent(ShareOpenGraphContent var1, FacebookCallback<Sharer.Result> var2) {
      GraphRequest.Callback var4 = new GraphRequest.Callback(this, var2) {
         final ShareApi this$0;
         final FacebookCallback val$callback;

         {
            this.this$0 = var1;
            this.val$callback = var2x;
         }

         @Override
         public void onCompleted(GraphResponse var1) {
            JSONObject var2x = var1.getJSONObject();
            String var3;
            if (var2x == null) {
               var3 = null;
            } else {
               var3 = var2x.optString("id");
            }

            ShareInternalUtility.invokeCallbackWithResults(this.val$callback, var3, var1);
         }
      };
      ShareOpenGraphAction var5 = var1.getAction();
      Bundle var3 = var5.getBundle();
      this.addCommonParameters(var3, var1);
      if (!Utility.isNullOrEmpty(this.getMessage())) {
         var3.putString("message", this.getMessage());
      }

      this.stageOpenGraphAction(
         var3,
         new CollectionMapper.OnMapperCompleteListener(this, var3, var5, var4, var2) {
            final ShareApi this$0;
            final ShareOpenGraphAction val$action;
            final FacebookCallback val$callback;
            final Bundle val$parameters;
            final GraphRequest.Callback val$requestCallback;

            {
               this.this$0 = var1;
               this.val$parameters = var2x;
               this.val$action = var3x;
               this.val$requestCallback = var4x;
               this.val$callback = var5x;
            }

            @Override
            public void onComplete() {
               try {
                  ShareApi.handleImagesOnAction(this.val$parameters);
                  GraphRequest var1x = new GraphRequest(
                     AccessToken.getCurrentAccessToken(),
                     this.this$0.getGraphPath(URLEncoder.encode(this.val$action.getActionType(), "UTF-8")),
                     this.val$parameters,
                     HttpMethod.POST,
                     this.val$requestCallback
                  );
                  var1x.executeAsync();
               } catch (UnsupportedEncodingException var2x) {
                  ShareInternalUtility.invokeCallbackWithException(this.val$callback, var2x);
               }
            }

            @Override
            public void onError(FacebookException var1) {
               ShareInternalUtility.invokeCallbackWithException(this.val$callback, var1);
            }
         }
      );
   }

   private void sharePhotoContent(SharePhotoContent param1, FacebookCallback<Sharer.Result> param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: new com/facebook/internal/Mutable
      // 003: dup
      // 004: bipush 0
      // 005: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 008: invokespecial com/facebook/internal/Mutable.<init> (Ljava/lang/Object;)V
      // 00b: astore 8
      // 00d: invokestatic com/facebook/AccessToken.getCurrentAccessToken ()Lcom/facebook/AccessToken;
      // 010: astore 11
      // 012: new java/util/ArrayList
      // 015: dup
      // 016: invokespecial java/util/ArrayList.<init> ()V
      // 019: astore 7
      // 01b: new com/facebook/share/ShareApi$3
      // 01e: dup
      // 01f: aload 0
      // 020: new java/util/ArrayList
      // 023: dup
      // 024: invokespecial java/util/ArrayList.<init> ()V
      // 027: new java/util/ArrayList
      // 02a: dup
      // 02b: invokespecial java/util/ArrayList.<init> ()V
      // 02e: aload 8
      // 030: aload 2
      // 031: invokespecial com/facebook/share/ShareApi$3.<init> (Lcom/facebook/share/ShareApi;Ljava/util/ArrayList;Ljava/util/ArrayList;Lcom/facebook/internal/Mutable;Lcom/facebook/FacebookCallback;)V
      // 034: astore 9
      // 036: aload 1
      // 037: invokevirtual com/facebook/share/model/SharePhotoContent.getPhotos ()Ljava/util/List;
      // 03a: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 03f: astore 5
      // 041: aload 5
      // 043: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 048: ifeq 0cd
      // 04b: aload 5
      // 04d: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 052: checkcast com/facebook/share/model/SharePhoto
      // 055: astore 3
      // 056: aload 0
      // 057: aload 3
      // 058: aload 1
      // 059: invokespecial com/facebook/share/ShareApi.getSharePhotoCommonParameters (Lcom/facebook/share/model/SharePhoto;Lcom/facebook/share/model/SharePhotoContent;)Landroid/os/Bundle;
      // 05c: astore 10
      // 05e: aload 3
      // 05f: invokevirtual com/facebook/share/model/SharePhoto.getBitmap ()Landroid/graphics/Bitmap;
      // 062: astore 12
      // 064: aload 3
      // 065: invokevirtual com/facebook/share/model/SharePhoto.getImageUrl ()Landroid/net/Uri;
      // 068: astore 6
      // 06a: aload 3
      // 06b: invokevirtual com/facebook/share/model/SharePhoto.getCaption ()Ljava/lang/String;
      // 06e: astore 4
      // 070: aload 4
      // 072: astore 3
      // 073: aload 4
      // 075: ifnonnull 07d
      // 078: aload 0
      // 079: invokevirtual com/facebook/share/ShareApi.getMessage ()Ljava/lang/String;
      // 07c: astore 3
      // 07d: aload 12
      // 07f: ifnull 0ad
      // 082: aload 7
      // 084: aload 11
      // 086: aload 0
      // 087: ldc "photos"
      // 089: invokespecial com/facebook/share/ShareApi.getGraphPath (Ljava/lang/String;)Ljava/lang/String;
      // 08c: aload 12
      // 08e: aload 3
      // 08f: aload 10
      // 091: aload 9
      // 093: invokestatic com/facebook/GraphRequest.newUploadPhotoRequest (Lcom/facebook/AccessToken;Ljava/lang/String;Landroid/graphics/Bitmap;Ljava/lang/String;Landroid/os/Bundle;Lcom/facebook/GraphRequest$Callback;)Lcom/facebook/GraphRequest;
      // 096: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 099: pop
      // 09a: goto 041
      // 09d: astore 1
      // 09e: aload 2
      // 09f: aload 1
      // 0a0: invokestatic com/facebook/share/internal/ShareInternalUtility.invokeCallbackWithException (Lcom/facebook/FacebookCallback;Ljava/lang/Exception;)V
      // 0a3: return
      // 0a4: astore 1
      // 0a5: aload 2
      // 0a6: aload 1
      // 0a7: invokestatic com/facebook/share/internal/ShareInternalUtility.invokeCallbackWithException (Lcom/facebook/FacebookCallback;Ljava/lang/Exception;)V
      // 0aa: goto 0a3
      // 0ad: aload 6
      // 0af: ifnull 041
      // 0b2: aload 7
      // 0b4: aload 11
      // 0b6: aload 0
      // 0b7: ldc "photos"
      // 0b9: invokespecial com/facebook/share/ShareApi.getGraphPath (Ljava/lang/String;)Ljava/lang/String;
      // 0bc: aload 6
      // 0be: aload 3
      // 0bf: aload 10
      // 0c1: aload 9
      // 0c3: invokestatic com/facebook/GraphRequest.newUploadPhotoRequest (Lcom/facebook/AccessToken;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Landroid/os/Bundle;Lcom/facebook/GraphRequest$Callback;)Lcom/facebook/GraphRequest;
      // 0c6: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 0c9: pop
      // 0ca: goto 041
      // 0cd: aload 8
      // 0cf: aload 8
      // 0d1: getfield com/facebook/internal/Mutable.value Ljava/lang/Object;
      // 0d4: checkcast java/lang/Integer
      // 0d7: invokevirtual java/lang/Integer.intValue ()I
      // 0da: aload 7
      // 0dc: invokevirtual java/util/ArrayList.size ()I
      // 0df: iadd
      // 0e0: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 0e3: putfield com/facebook/internal/Mutable.value Ljava/lang/Object;
      // 0e6: aload 7
      // 0e8: invokevirtual java/util/ArrayList.iterator ()Ljava/util/Iterator;
      // 0eb: astore 1
      // 0ec: aload 1
      // 0ed: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0f2: ifeq 0a3
      // 0f5: aload 1
      // 0f6: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0fb: checkcast com/facebook/GraphRequest
      // 0fe: invokevirtual com/facebook/GraphRequest.executeAsync ()Lcom/facebook/GraphRequestAsyncTask;
      // 101: pop
      // 102: goto 0ec
      // try (25 -> 29): 72 java/io/FileNotFoundException
      // try (29 -> 36): 72 java/io/FileNotFoundException
      // try (36 -> 41): 77 org/json/JSONException
      // try (36 -> 41): 72 java/io/FileNotFoundException
      // try (41 -> 50): 72 java/io/FileNotFoundException
      // try (54 -> 57): 72 java/io/FileNotFoundException
      // try (59 -> 71): 72 java/io/FileNotFoundException
      // try (78 -> 81): 72 java/io/FileNotFoundException
      // try (84 -> 96): 72 java/io/FileNotFoundException
      // try (97 -> 110): 72 java/io/FileNotFoundException
      // try (110 -> 118): 72 java/io/FileNotFoundException
   }

   private void shareVideoContent(ShareVideoContent var1, FacebookCallback<Sharer.Result> var2) {
      try {
         VideoUploader.uploadAsync(var1, this.getGraphNode(), var2);
      } catch (FileNotFoundException var3) {
         ShareInternalUtility.invokeCallbackWithException(var2, var3);
      }
   }

   private void stageArrayList(ArrayList var1, CollectionMapper.OnMapValueCompleteListener var2) {
      JSONArray var3 = new JSONArray();
      this.stageCollectionValues(new CollectionMapper.Collection<Integer>(this, var1, var3) {
         final ShareApi this$0;
         final ArrayList val$arrayList;
         final JSONArray val$stagedObject;

         {
            this.this$0 = var1;
            this.val$arrayList = var2x;
            this.val$stagedObject = var3x;
         }

         public Object get(Integer var1) {
            return this.val$arrayList.get(var1);
         }

         @Override
         public Iterator<Integer> keyIterator() {
            int var1x = this.val$arrayList.size();
            return new Iterator<Integer>(this, new Mutable<>(0), var1x) {
               final <unrepresentable> this$1;
               final Mutable val$current;
               final int val$size;

               {
                  this.this$1 = var1;
                  this.val$current = var2x;
                  this.val$size = var3x;
               }

               @Override
               public boolean hasNext() {
                  boolean var1x;
                  if ((Integer)this.val$current.value < this.val$size) {
                     var1x = true;
                  } else {
                     var1x = false;
                  }

                  return var1x;
               }

               public Integer next() {
                  Integer var2x = (Integer)this.val$current.value;
                  Mutable var1x = this.val$current;
                  var1x.value = (T)(Integer)var1x.value + 1;
                  return var2x;
               }

               @Override
               public void remove() {
               }
            };
         }

         public void set(Integer var1, Object var2x, CollectionMapper.OnErrorListener var3x) {
            try {
               this.val$stagedObject.put(var1, var2x);
            } catch (JSONException var4) {
               var2x = var4.getLocalizedMessage();
               String var5 = var2x;
               if (var2x == null) {
                  var5 = "Error staging object.";
               }

               var3x.onError(new FacebookException(var5));
            }
         }
      }, new CollectionMapper.OnMapperCompleteListener(this, var2, var3) {
         final ShareApi this$0;
         final CollectionMapper.OnMapValueCompleteListener val$onArrayListStagedListener;
         final JSONArray val$stagedObject;

         {
            this.this$0 = var1;
            this.val$onArrayListStagedListener = var2x;
            this.val$stagedObject = var3x;
         }

         @Override
         public void onComplete() {
            this.val$onArrayListStagedListener.onComplete(this.val$stagedObject);
         }

         @Override
         public void onError(FacebookException var1) {
            this.val$onArrayListStagedListener.onError(var1);
         }
      });
   }

   private <T> void stageCollectionValues(CollectionMapper.Collection<T> var1, CollectionMapper.OnMapperCompleteListener var2) {
      CollectionMapper.iterate(var1, new CollectionMapper.ValueMapper(this) {
         final ShareApi this$0;

         {
            this.this$0 = var1;
         }

         @Override
         public void mapValue(Object var1, CollectionMapper.OnMapValueCompleteListener var2x) {
            if (var1 instanceof ArrayList) {
               this.this$0.stageArrayList((ArrayList)var1, var2x);
            } else if (var1 instanceof ShareOpenGraphObject) {
               this.this$0.stageOpenGraphObject((ShareOpenGraphObject)var1, var2x);
            } else if (var1 instanceof SharePhoto) {
               this.this$0.stagePhoto((SharePhoto)var1, var2x);
            } else {
               var2x.onComplete(var1);
            }
         }
      }, var2);
   }

   private void stageOpenGraphAction(Bundle var1, CollectionMapper.OnMapperCompleteListener var2) {
      this.stageCollectionValues(new CollectionMapper.Collection<String>(this, var1) {
         final ShareApi this$0;
         final Bundle val$parameters;

         {
            this.this$0 = var1;
            this.val$parameters = var2x;
         }

         public Object get(String var1) {
            return this.val$parameters.get(var1);
         }

         @Override
         public Iterator<String> keyIterator() {
            return this.val$parameters.keySet().iterator();
         }

         public void set(String var1, Object var2x, CollectionMapper.OnErrorListener var3) {
            if (!Utility.putJSONValueInBundle(this.val$parameters, var1, var2x)) {
               var3.onError(new FacebookException("Unexpected value: " + var2x.toString()));
            }
         }
      }, var2);
   }

   private void stageOpenGraphObject(ShareOpenGraphObject var1, CollectionMapper.OnMapValueCompleteListener var2) {
      String var4 = var1.getString("type");
      String var3 = var4;
      if (var4 == null) {
         var3 = var1.getString("og:type");
      }

      if (var3 == null) {
         var2.onError(new FacebookException("Open Graph objects must contain a type value."));
      } else {
         JSONObject var5 = new JSONObject();
         this.stageCollectionValues(
            new CollectionMapper.Collection<String>(this, var1, var5) {
               final ShareApi this$0;
               final ShareOpenGraphObject val$object;
               final JSONObject val$stagedObject;

               {
                  this.this$0 = var1;
                  this.val$object = var2x;
                  this.val$stagedObject = var3x;
               }

               public Object get(String var1) {
                  return this.val$object.get(var1);
               }

               @Override
               public Iterator<String> keyIterator() {
                  return this.val$object.keySet().iterator();
               }

               public void set(String var1, Object var2x, CollectionMapper.OnErrorListener var3x) {
                  try {
                     this.val$stagedObject.put(var1, var2x);
                  } catch (JSONException var4x) {
                     var2x = var4x.getLocalizedMessage();
                     var1 = var2x;
                     if (var2x == null) {
                        var1 = "Error staging object.";
                     }

                     var3x.onError(new FacebookException(var1));
                  }
               }
            },
            new CollectionMapper.OnMapperCompleteListener(this, var5, var3, new GraphRequest.Callback(this, var2) {
               final ShareApi this$0;
               final CollectionMapper.OnMapValueCompleteListener val$onOpenGraphObjectStagedListener;

               {
                  this.this$0 = var1;
                  this.val$onOpenGraphObjectStagedListener = var2x;
               }

               @Override
               public void onCompleted(GraphResponse var1) {
                  FacebookRequestError var2x = var1.getError();
                  if (var2x != null) {
                     String var3x = var2x.getErrorMessage();
                     String var4x = var3x;
                     if (var3x == null) {
                        var4x = "Error staging Open Graph object.";
                     }

                     this.val$onOpenGraphObjectStagedListener.onError(new FacebookGraphResponseException(var1, var4x));
                  } else {
                     JSONObject var5x = var1.getJSONObject();
                     if (var5x == null) {
                        this.val$onOpenGraphObjectStagedListener.onError(new FacebookGraphResponseException(var1, "Error staging Open Graph object."));
                     } else {
                        String var6 = var5x.optString("id");
                        if (var6 == null) {
                           this.val$onOpenGraphObjectStagedListener.onError(new FacebookGraphResponseException(var1, "Error staging Open Graph object."));
                        } else {
                           this.val$onOpenGraphObjectStagedListener.onComplete(var6);
                        }
                     }
                  }
               }
            }, var2) {
               final ShareApi this$0;
               final String val$ogType;
               final CollectionMapper.OnMapValueCompleteListener val$onOpenGraphObjectStagedListener;
               final GraphRequest.Callback val$requestCallback;
               final JSONObject val$stagedObject;

               {
                  this.this$0 = var1;
                  this.val$stagedObject = var2x;
                  this.val$ogType = var3x;
                  this.val$requestCallback = var4x;
                  this.val$onOpenGraphObjectStagedListener = var5x;
               }

               @Override
               public void onComplete() {
                  String var2x = this.val$stagedObject.toString();
                  Bundle var1x = new Bundle();
                  var1x.putString("object", var2x);

                  try {
                     AccessToken var4x = AccessToken.getCurrentAccessToken();
                     ShareApi var5x = this.this$0;
                     StringBuilder var9 = new StringBuilder();
                     GraphRequest var3x = new GraphRequest(
                        var4x,
                        var5x.getGraphPath(var9.append("objects/").append(URLEncoder.encode(this.val$ogType, "UTF-8")).toString()),
                        var1x,
                        HttpMethod.POST,
                        this.val$requestCallback
                     );
                     var3x.executeAsync();
                  } catch (UnsupportedEncodingException var6) {
                     var2x = var6.getLocalizedMessage();
                     String var7 = var2x;
                     if (var2x == null) {
                        var7 = "Error staging Open Graph object.";
                     }

                     this.val$onOpenGraphObjectStagedListener.onError(new FacebookException(var7));
                  }
               }

               @Override
               public void onError(FacebookException var1) {
                  this.val$onOpenGraphObjectStagedListener.onError(var1);
               }
            }
         );
      }
   }

   private void stagePhoto(SharePhoto var1, CollectionMapper.OnMapValueCompleteListener var2) {
      Bitmap var3 = var1.getBitmap();
      Uri var4 = var1.getImageUrl();
      if (var3 == null && var4 == null) {
         var2.onError(new FacebookException("Photos must have an imageURL or bitmap."));
      } else {
         GraphRequest.Callback var6 = new GraphRequest.Callback(this, var2, var1) {
            final ShareApi this$0;
            final CollectionMapper.OnMapValueCompleteListener val$onPhotoStagedListener;
            final SharePhoto val$photo;

            {
               this.this$0 = var1;
               this.val$onPhotoStagedListener = var2x;
               this.val$photo = var3x;
            }

            @Override
            public void onCompleted(GraphResponse var1) {
               FacebookRequestError var2x = var1.getError();
               if (var2x != null) {
                  String var3x = var2x.getErrorMessage();
                  String var8 = var3x;
                  if (var3x == null) {
                     var8 = "Error staging photo.";
                  }

                  this.val$onPhotoStagedListener.onError(new FacebookGraphResponseException(var1, var8));
               } else {
                  JSONObject var5 = var1.getJSONObject();
                  if (var5 == null) {
                     this.val$onPhotoStagedListener.onError(new FacebookException("Error staging photo."));
                  } else {
                     String var9 = var5.optString("uri");
                     if (var9 == null) {
                        this.val$onPhotoStagedListener.onError(new FacebookException("Error staging photo."));
                     } else {
                        JSONObject var6x = new JSONObject();

                        try {
                           var6x.put("url", var9);
                           var6x.put("user_generated", this.val$photo.getUserGenerated());
                        } catch (JSONException var4x) {
                           String var10 = var4x.getLocalizedMessage();
                           String var7 = var10;
                           if (var10 == null) {
                              var7 = "Error staging photo.";
                           }

                           this.val$onPhotoStagedListener.onError(new FacebookException(var7));
                           return;
                        }

                        this.val$onPhotoStagedListener.onComplete(var6x);
                     }
                  }
               }
            }
         };
         if (var3 != null) {
            ShareInternalUtility.newUploadStagingResourceWithImageRequest(AccessToken.getCurrentAccessToken(), var3, var6).executeAsync();
         } else {
            try {
               ShareInternalUtility.newUploadStagingResourceWithImageRequest(AccessToken.getCurrentAccessToken(), var4, var6).executeAsync();
            } catch (FileNotFoundException var5) {
               String var8 = var5.getLocalizedMessage();
               String var7 = var8;
               if (var8 == null) {
                  var7 = "Error staging photo.";
               }

               var2.onError(new FacebookException(var7));
            }
         }
      }
   }

   public boolean canShare() {
      boolean var1 = false;
      if (this.getShareContent() != null) {
         AccessToken var2 = AccessToken.getCurrentAccessToken();
         if (var2 != null) {
            Set var3 = var2.getPermissions();
            if (var3 == null || !var3.contains("publish_actions")) {
               Log.w(
                  "ShareApi",
                  "The publish_actions permissions are missing, the share will fail unless this app was authorized to publish in another installation."
               );
            }

            var1 = true;
         }
      }

      return var1;
   }

   public String getGraphNode() {
      return this.graphNode;
   }

   public String getMessage() {
      return this.message;
   }

   public ShareContent getShareContent() {
      return this.shareContent;
   }

   public void setGraphNode(String var1) {
      this.graphNode = var1;
   }

   public void setMessage(String var1) {
      this.message = var1;
   }

   public void share(FacebookCallback<Sharer.Result> var1) {
      if (!this.canShare()) {
         ShareInternalUtility.invokeCallbackWithError(var1, "Insufficient permissions for sharing content via Api.");
      } else {
         ShareContent var2 = this.getShareContent();

         try {
            ShareContentValidation.validateForApiShare(var2);
         } catch (FacebookException var3) {
            ShareInternalUtility.invokeCallbackWithException(var1, var3);
            return;
         }

         if (var2 instanceof ShareLinkContent) {
            this.shareLinkContent((ShareLinkContent)var2, var1);
         } else if (var2 instanceof SharePhotoContent) {
            this.sharePhotoContent((SharePhotoContent)var2, var1);
         } else if (var2 instanceof ShareVideoContent) {
            this.shareVideoContent((ShareVideoContent)var2, var1);
         } else if (var2 instanceof ShareOpenGraphContent) {
            this.shareOpenGraphContent((ShareOpenGraphContent)var2, var1);
         }
      }
   }
}
