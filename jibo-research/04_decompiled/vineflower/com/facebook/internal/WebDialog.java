package com.facebook.internal;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.AsyncTask.Status;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.AccessToken;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.R;
import com.facebook.share.internal.ShareInternalUtility;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;

public class WebDialog extends Dialog {
   private static final int API_EC_DIALOG_CANCEL = 4201;
   private static final int BACKGROUND_GRAY = -872415232;
   static final String CANCEL_URI = "fbconnect://cancel";
   static final boolean DISABLE_SSL_CHECK_FOR_TESTING = false;
   private static final String DISPLAY_TOUCH = "touch";
   private static final String LOG_TAG = "FacebookSDK.WebDialog";
   private static final int MAX_PADDING_SCREEN_HEIGHT = 1280;
   private static final int MAX_PADDING_SCREEN_WIDTH = 800;
   private static final double MIN_SCALE_FACTOR = 0.5;
   private static final int NO_PADDING_SCREEN_HEIGHT = 800;
   private static final int NO_PADDING_SCREEN_WIDTH = 480;
   static final String REDIRECT_URI = "fbconnect://success";
   private FrameLayout contentFrameLayout;
   private ImageView crossImageView;
   private String expectedRedirectUrl;
   private boolean isDetached;
   private boolean isPageFinished;
   private boolean listenerCalled;
   private WebDialog.OnCompleteListener onCompleteListener;
   private ProgressDialog spinner;
   private WebDialog.UploadStagingResourcesTask uploadTask;
   private String url;
   private WebView webView;

   public WebDialog(Context var1, String var2) {
      this(var1, var2, FacebookSdk.getWebDialogTheme());
   }

   public WebDialog(Context var1, String var2, int var3) {
      int var4 = var3;
      if (var3 == 0) {
         var4 = FacebookSdk.getWebDialogTheme();
      }

      super(var1, var4);
      this.expectedRedirectUrl = "fbconnect://success";
      this.listenerCalled = false;
      this.isDetached = false;
      this.isPageFinished = false;
      this.url = var2;
   }

   public WebDialog(Context var1, String var2, Bundle var3, int var4, WebDialog.OnCompleteListener var5) {
      int var6 = var4;
      if (var4 == 0) {
         var6 = FacebookSdk.getWebDialogTheme();
      }

      super(var1, var6);
      this.expectedRedirectUrl = "fbconnect://success";
      this.listenerCalled = false;
      this.isDetached = false;
      this.isPageFinished = false;
      Bundle var7 = var3;
      if (var3 == null) {
         var7 = new Bundle();
      }

      var7.putString("redirect_uri", "fbconnect://success");
      var7.putString("display", "touch");
      var7.putString("sdk", String.format(Locale.ROOT, "android-%s", FacebookSdk.getSdkVersion()));
      this.onCompleteListener = var5;
      if (var2.equals("share") && var7.containsKey("media")) {
         this.uploadTask = new WebDialog.UploadStagingResourcesTask(this, var2, var7);
      } else {
         this.url = Utility.buildUri(ServerProtocol.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/" + "dialog/" + var2, var7).toString();
      }
   }

   private void createCrossImage() {
      this.crossImageView = new ImageView(this.getContext());
      this.crossImageView.setOnClickListener(new OnClickListener(this) {
         final WebDialog this$0;

         {
            this.this$0 = var1;
         }

         public void onClick(View var1) {
            this.this$0.cancel();
         }
      });
      Drawable var1 = this.getContext().getResources().getDrawable(R.drawable.com_facebook_close);
      this.crossImageView.setImageDrawable(var1);
      this.crossImageView.setVisibility(4);
   }

   private int getScaledSize(int var1, float var2, int var3, int var4) {
      double var5 = 0.5;
      int var7 = (int)(var1 / var2);
      if (var7 <= var3) {
         var5 = 1.0;
      } else if (var7 < var4) {
         var5 = 0.5 + (double)(var4 - var7) / (var4 - var3) * 0.5;
      }

      return (int)(var5 * var1);
   }

   @SuppressLint("SetJavaScriptEnabled")
   private void setUpWebView(int var1) {
      LinearLayout var2 = new LinearLayout(this.getContext());
      this.webView = new WebView(this, this.getContext().getApplicationContext()) {
         final WebDialog this$0;

         {
            this.this$0 = var1;
         }

         public void onWindowFocusChanged(boolean var1) {
            try {
               super.onWindowFocusChanged(var1);
            } catch (NullPointerException var3) {
            }
         }
      };
      this.webView.setVerticalScrollBarEnabled(false);
      this.webView.setHorizontalScrollBarEnabled(false);
      this.webView.setWebViewClient(new WebDialog.DialogWebViewClient(this));
      this.webView.getSettings().setJavaScriptEnabled(true);
      this.webView.loadUrl(this.url);
      this.webView.setLayoutParams(new LayoutParams(-1, -1));
      this.webView.setVisibility(4);
      this.webView.getSettings().setSavePassword(false);
      this.webView.getSettings().setSaveFormData(false);
      this.webView.setFocusable(true);
      this.webView.setFocusableInTouchMode(true);
      this.webView.setOnTouchListener(new OnTouchListener(this) {
         final WebDialog this$0;

         {
            this.this$0 = var1;
         }

         public boolean onTouch(View var1, MotionEvent var2x) {
            if (!var1.hasFocus()) {
               var1.requestFocus();
            }

            return false;
         }
      });
      var2.setPadding(var1, var1, var1, var1);
      var2.addView(this.webView);
      var2.setBackgroundColor(-872415232);
      this.contentFrameLayout.addView(var2);
   }

   public void cancel() {
      if (this.onCompleteListener != null && !this.listenerCalled) {
         this.sendErrorToListener(new FacebookOperationCanceledException());
      }
   }

   public void dismiss() {
      if (this.webView != null) {
         this.webView.stopLoading();
      }

      if (!this.isDetached && this.spinner != null && this.spinner.isShowing()) {
         this.spinner.dismiss();
      }

      super.dismiss();
   }

   public WebDialog.OnCompleteListener getOnCompleteListener() {
      return this.onCompleteListener;
   }

   protected WebView getWebView() {
      return this.webView;
   }

   protected boolean isListenerCalled() {
      return this.listenerCalled;
   }

   protected boolean isPageFinished() {
      return this.isPageFinished;
   }

   public void onAttachedToWindow() {
      this.isDetached = false;
      super.onAttachedToWindow();
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.spinner = new ProgressDialog(this.getContext());
      this.spinner.requestWindowFeature(1);
      this.spinner.setMessage(this.getContext().getString(R.string.com_facebook_loading));
      this.spinner.setCanceledOnTouchOutside(false);
      this.spinner.setOnCancelListener(new OnCancelListener(this) {
         final WebDialog this$0;

         {
            this.this$0 = var1;
         }

         public void onCancel(DialogInterface var1) {
            this.this$0.cancel();
         }
      });
      this.requestWindowFeature(1);
      this.contentFrameLayout = new FrameLayout(this.getContext());
      this.resize();
      this.getWindow().setGravity(17);
      this.getWindow().setSoftInputMode(16);
      this.createCrossImage();
      if (this.url != null) {
         this.setUpWebView(this.crossImageView.getDrawable().getIntrinsicWidth() / 2 + 1);
      }

      this.contentFrameLayout.addView(this.crossImageView, new android.view.ViewGroup.LayoutParams(-2, -2));
      this.setContentView(this.contentFrameLayout);
   }

   public void onDetachedFromWindow() {
      this.isDetached = true;
      super.onDetachedFromWindow();
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      if (var1 == 4) {
         this.cancel();
      }

      return super.onKeyDown(var1, var2);
   }

   protected void onStart() {
      super.onStart();
      if (this.uploadTask != null && this.uploadTask.getStatus() == Status.PENDING) {
         this.uploadTask.execute(new Void[0]);
         this.spinner.show();
      } else {
         this.resize();
      }
   }

   protected void onStop() {
      if (this.uploadTask != null) {
         this.uploadTask.cancel(true);
         this.spinner.dismiss();
      }

      super.onStop();
   }

   protected Bundle parseResponseUri(String var1) {
      Uri var3 = Uri.parse(var1);
      Bundle var2 = Utility.parseUrlQueryString(var3.getQuery());
      var2.putAll(Utility.parseUrlQueryString(var3.getFragment()));
      return var2;
   }

   public void resize() {
      Display var4 = ((WindowManager)this.getContext().getSystemService("window")).getDefaultDisplay();
      DisplayMetrics var3 = new DisplayMetrics();
      var4.getMetrics(var3);
      int var1;
      if (var3.widthPixels < var3.heightPixels) {
         var1 = var3.widthPixels;
      } else {
         var1 = var3.heightPixels;
      }

      int var2;
      if (var3.widthPixels < var3.heightPixels) {
         var2 = var3.heightPixels;
      } else {
         var2 = var3.widthPixels;
      }

      var1 = Math.min(this.getScaledSize(var1, var3.density, 480, 800), var3.widthPixels);
      var2 = Math.min(this.getScaledSize(var2, var3.density, 800, 1280), var3.heightPixels);
      this.getWindow().setLayout(var1, var2);
   }

   protected void sendErrorToListener(Throwable var1) {
      if (this.onCompleteListener != null && !this.listenerCalled) {
         this.listenerCalled = true;
         if (var1 instanceof FacebookException) {
            var1 = var1;
         } else {
            var1 = new FacebookException(var1);
         }

         this.onCompleteListener.onComplete(null, var1);
         this.dismiss();
      }
   }

   protected void sendSuccessToListener(Bundle var1) {
      if (this.onCompleteListener != null && !this.listenerCalled) {
         this.listenerCalled = true;
         this.onCompleteListener.onComplete(var1, null);
         this.dismiss();
      }
   }

   protected void setExpectedRedirectUrl(String var1) {
      this.expectedRedirectUrl = var1;
   }

   public void setOnCompleteListener(WebDialog.OnCompleteListener var1) {
      this.onCompleteListener = var1;
   }

   public static class Builder {
      private AccessToken accessToken;
      private String action;
      private String applicationId;
      private Context context;
      private WebDialog.OnCompleteListener listener;
      private Bundle parameters;
      private int theme;

      public Builder(Context var1, String var2, Bundle var3) {
         this.accessToken = AccessToken.getCurrentAccessToken();
         if (this.accessToken == null) {
            String var4 = Utility.getMetadataApplicationId(var1);
            if (var4 == null) {
               throw new FacebookException("Attempted to create a builder without a valid access token or a valid default Application ID.");
            }

            this.applicationId = var4;
         }

         this.finishInit(var1, var2, var3);
      }

      public Builder(Context var1, String var2, String var3, Bundle var4) {
         String var5 = var2;
         if (var2 == null) {
            var5 = Utility.getMetadataApplicationId(var1);
         }

         Validate.notNullOrEmpty(var5, "applicationId");
         this.applicationId = var5;
         this.finishInit(var1, var3, var4);
      }

      private void finishInit(Context var1, String var2, Bundle var3) {
         this.context = var1;
         this.action = var2;
         if (var3 != null) {
            this.parameters = var3;
         } else {
            this.parameters = new Bundle();
         }
      }

      public WebDialog build() {
         if (this.accessToken != null) {
            this.parameters.putString("app_id", this.accessToken.getApplicationId());
            this.parameters.putString("access_token", this.accessToken.getToken());
         } else {
            this.parameters.putString("app_id", this.applicationId);
         }

         return new WebDialog(this.context, this.action, this.parameters, this.theme, this.listener);
      }

      public String getApplicationId() {
         return this.applicationId;
      }

      public Context getContext() {
         return this.context;
      }

      public WebDialog.OnCompleteListener getListener() {
         return this.listener;
      }

      public Bundle getParameters() {
         return this.parameters;
      }

      public int getTheme() {
         return this.theme;
      }

      public WebDialog.Builder setOnCompleteListener(WebDialog.OnCompleteListener var1) {
         this.listener = var1;
         return this;
      }

      public WebDialog.Builder setTheme(int var1) {
         this.theme = var1;
         return this;
      }
   }

   private class DialogWebViewClient extends WebViewClient {
      final WebDialog this$0;

      private DialogWebViewClient(WebDialog var1) {
         this.this$0 = var1;
      }

      public void onPageFinished(WebView var1, String var2) {
         super.onPageFinished(var1, var2);
         if (!this.this$0.isDetached) {
            this.this$0.spinner.dismiss();
         }

         this.this$0.contentFrameLayout.setBackgroundColor(0);
         this.this$0.webView.setVisibility(0);
         this.this$0.crossImageView.setVisibility(0);
         this.this$0.isPageFinished = true;
      }

      public void onPageStarted(WebView var1, String var2, Bitmap var3) {
         Utility.logd("FacebookSDK.WebDialog", "Webview loading URL: " + var2);
         super.onPageStarted(var1, var2, var3);
         if (!this.this$0.isDetached) {
            this.this$0.spinner.show();
         }
      }

      public void onReceivedError(WebView var1, int var2, String var3, String var4) {
         super.onReceivedError(var1, var2, var3, var4);
         this.this$0.sendErrorToListener(new FacebookDialogException(var3, var2, var4));
      }

      public void onReceivedSslError(WebView var1, SslErrorHandler var2, SslError var3) {
         super.onReceivedSslError(var1, var2, var3);
         var2.cancel();
         this.this$0.sendErrorToListener(new FacebookDialogException(null, -11, null));
      }

      public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
         boolean var5 = false;
         Utility.logd("FacebookSDK.WebDialog", "Redirect URL: " + var2);
         boolean var4;
         if (var2.startsWith(this.this$0.expectedRedirectUrl)) {
            Bundle var7 = this.this$0.parseResponseUri(var2);
            String var10 = var7.getString("error");
            var2 = var10;
            if (var10 == null) {
               var2 = var7.getString("error_type");
            }

            String var6 = var7.getString("error_msg");
            String var11 = var6;
            if (var6 == null) {
               var11 = var7.getString("error_message");
            }

            var6 = var11;
            if (var11 == null) {
               var6 = var7.getString("error_description");
            }

            String var12 = var7.getString("error_code");
            int var3;
            if (!Utility.isNullOrEmpty(var12)) {
               try {
                  var3 = Integer.parseInt(var12);
               } catch (NumberFormatException var8) {
                  var3 = -1;
               }
            } else {
               var3 = -1;
            }

            if (Utility.isNullOrEmpty(var2) && Utility.isNullOrEmpty(var6) && var3 == -1) {
               this.this$0.sendSuccessToListener(var7);
            } else if (var2 == null || !var2.equals("access_denied") && !var2.equals("OAuthAccessDeniedException")) {
               if (var3 == 4201) {
                  this.this$0.cancel();
               } else {
                  FacebookRequestError var13 = new FacebookRequestError(var3, var2, var6);
                  this.this$0.sendErrorToListener(new FacebookServiceException(var13, var6));
               }
            } else {
               this.this$0.cancel();
            }

            var4 = true;
         } else if (var2.startsWith("fbconnect://cancel")) {
            this.this$0.cancel();
            var4 = true;
         } else {
            var4 = var5;
            if (!var2.contains("touch")) {
               try {
                  Context var17 = this.this$0.getContext();
                  Intent var14 = new Intent("android.intent.action.VIEW", Uri.parse(var2));
                  var17.startActivity(var14);
               } catch (ActivityNotFoundException var9) {
                  var4 = var5;
                  return var4;
               }

               var4 = true;
            }
         }

         return var4;
      }
   }

   public interface OnCompleteListener {
      void onComplete(Bundle var1, FacebookException var2);
   }

   private class UploadStagingResourcesTask extends AsyncTask<Void, Void, String[]> {
      private String action;
      private Exception[] exceptions;
      private Bundle parameters;
      final WebDialog this$0;

      UploadStagingResourcesTask(WebDialog var1, String var2, Bundle var3) {
         this.this$0 = var1;
         this.action = var2;
         this.parameters = var3;
      }

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      protected String[] doInBackground(Void... var1) {
         String[] var5 = this.parameters.getStringArray("media");
         String[] var14 = new String[var5.length];
         this.exceptions = new Exception[var5.length];
         CountDownLatch var4 = new CountDownLatch(var5.length);
         ConcurrentLinkedQueue var3 = new ConcurrentLinkedQueue();
         AccessToken var7 = AccessToken.getCurrentAccessToken();
         int var2 = 0;

         label72: {
            while (true) {
               label69: {
                  try {
                     if (var2 < var5.length) {
                        if (!this.isCancelled()) {
                           break label69;
                        }

                        var16 = var3.iterator();
                        break;
                     }
                  } catch (Exception var13) {
                     var15 = var3.iterator();
                     break label72;
                  }

                  try {
                     var4.await();
                     return var14;
                  } catch (Exception var12) {
                     var15 = var3.iterator();
                     break label72;
                  }
               }

               label56: {
                  Uri var8;
                  try {
                     var8 = Uri.parse(var5[var2]);
                     if (Utility.isWebUri(var8)) {
                        var14[var2] = var8.toString();
                        var4.countDown();
                        break label56;
                     }
                  } catch (Exception var11) {
                     var15 = var3.iterator();
                     break label72;
                  }

                  try {
                     GraphRequest.Callback var6 = new GraphRequest.Callback(this, var14, var2, var4) {
                        final WebDialog.UploadStagingResourcesTask this$1;
                        final CountDownLatch val$latch;
                        final String[] val$results;
                        final int val$writeIndex;

                        {
                           this.this$1 = var1;
                           this.val$results = var2x;
                           this.val$writeIndex = var3x;
                           this.val$latch = var4x;
                        }

                        // $VF: Duplicated exception handlers to handle obfuscated exceptions
                        @Override
                        public void onCompleted(GraphResponse var1) {
                           label61: {
                              FacebookRequestError var2x;
                              try {
                                 var2x = var1.getError();
                              } catch (Exception var11) {
                                 this.this$1.exceptions[this.val$writeIndex] = var11;
                                 break label61;
                              }

                              label58:
                              if (var2x != null) {
                                 String var3x;
                                 try {
                                    var3x = var2x.getErrorMessage();
                                 } catch (Exception var10) {
                                    this.this$1.exceptions[this.val$writeIndex] = var10;
                                    break label58;
                                 }

                                 String var16 = var3x;
                                 if (var3x == null) {
                                    var16 = "Error staging photo.";
                                 }

                                 try {
                                    FacebookGraphResponseException var17 = new FacebookGraphResponseException(var1, var16);
                                    throw var17;
                                 } catch (Exception var9) {
                                    this.this$1.exceptions[this.val$writeIndex] = var9;
                                 }
                              } else {
                                 label51: {
                                    try {
                                       var12 = var1.getJSONObject();
                                    } catch (Exception var8x) {
                                       this.this$1.exceptions[this.val$writeIndex] = var8x;
                                       break label51;
                                    }

                                    if (var12 == null) {
                                       try {
                                          FacebookException var13 = new FacebookException("Error staging photo.");
                                          throw var13;
                                       } catch (Exception var7x) {
                                          this.this$1.exceptions[this.val$writeIndex] = var7x;
                                       }
                                    } else {
                                       label45: {
                                          try {
                                             var14 = var12.optString("uri");
                                          } catch (Exception var6x) {
                                             this.this$1.exceptions[this.val$writeIndex] = var6x;
                                             break label45;
                                          }

                                          if (var14 == null) {
                                             try {
                                                FacebookException var15 = new FacebookException("Error staging photo.");
                                                throw var15;
                                             } catch (Exception var5x) {
                                                this.this$1.exceptions[this.val$writeIndex] = var5x;
                                             }
                                          } else {
                                             try {
                                                this.val$results[this.val$writeIndex] = var14;
                                             } catch (Exception var4x) {
                                                this.this$1.exceptions[this.val$writeIndex] = var4x;
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }

                           this.val$latch.countDown();
                        }
                     };
                     var3.add(ShareInternalUtility.newUploadStagingResourceWithImageRequest(var7, var8, var6).executeAsync());
                  } catch (Exception var10) {
                     var15 = var3.iterator();
                     break label72;
                  }
               }

               var2++;
            }

            while (true) {
               try {
                  if (var16.hasNext()) {
                     ((AsyncTask)var16.next()).cancel(true);
                     continue;
                  }
               } catch (Exception var9) {
                  var15 = var3.iterator();
                  break;
               }

               Object var17 = null;
               return (String[])var17;
            }
         }

         while (var15.hasNext()) {
            ((AsyncTask)var15.next()).cancel(true);
         }

         return null;
      }

      protected void onPostExecute(String[] var1) {
         this.this$0.spinner.dismiss();
         Exception[] var5 = this.exceptions;
         int var3 = var5.length;
         int var2 = 0;

         while (true) {
            if (var2 >= var3) {
               if (var1 == null) {
                  this.this$0.sendErrorToListener(new FacebookException("Failed to stage photos for web dialog"));
               } else {
                  List var6 = Arrays.asList(var1);
                  if (var6.contains(null)) {
                     this.this$0.sendErrorToListener(new FacebookException("Failed to stage photos for web dialog"));
                  } else {
                     Utility.putJSONValueInBundle(this.parameters, "media", new JSONArray(var6));
                     Uri var7 = Utility.buildUri(
                        ServerProtocol.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/" + "dialog/" + this.action, this.parameters
                     );
                     this.this$0.url = var7.toString();
                     var2 = this.this$0.crossImageView.getDrawable().getIntrinsicWidth();
                     this.this$0.setUpWebView(var2 / 2 + 1);
                  }
               }
               break;
            }

            Exception var4 = var5[var2];
            if (var4 != null) {
               this.this$0.sendErrorToListener(var4);
               break;
            }

            var2++;
         }
      }
   }
}
