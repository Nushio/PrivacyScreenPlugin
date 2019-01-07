/**
 * PrivacyScreenPlugin.java Cordova Plugin Implementation
 * Created by Tommy-Carlos Williams on 18/07/14.
 * Copyright (c) 2014 Tommy-Carlos Williams. All rights reserved.
 * MIT Licensed
 */
package org.devgeeks.privacyscreen;

import android.app.Activity;
import android.view.WindowManager;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * This class sets the FLAG_SECURE flag on the window to make the app
 *  private when shown in the task switcher
 */
public class PrivacyScreenPlugin extends CordovaPlugin {

  private static final String ACTION_ENABLE = "enable";
  private static final String ACTION_DISABLE = "disable";

  @Override
  public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
      final CallbackContext callbacks = callbackContext;

      if (ACTION_ENABLE.equals(action)) {
          cordova.getActivity().runOnUiThread(new Runnable() {
              public void run() {
                try{
                  // Disable the creation of screenshots adding the FLAG_SECURE to the window
                  if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
                    cordova.getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                      WindowManager.LayoutParams.FLAG_SECURE);
                  }

                  PluginResult result = new PluginResult(PluginResult.Status.OK, "");
                  result.setKeepCallback(true);
                  callbacks.sendPluginResult(result);
                }catch(Exception e){
                  PluginResult result = new PluginResult(PluginResult.Status.ERROR, e.getMessage());
                  result.setKeepCallback(true);
                  callbacks.sendPluginResult(result);
                }
              }
          });
      }else if(ACTION_DISABLE.equals(action)){
          cordova.getActivity().runOnUiThread(new Runnable() {
              public void run() {
                try{
                  // Allow to make screenshots removing the FLAG_SECURE
                  if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
                    cordova.getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
                  }

                  PluginResult result = new PluginResult(PluginResult.Status.OK, "");
                  result.setKeepCallback(true);
                  callbacks.sendPluginResult(result);
                }catch(Exception e){
                  PluginResult result = new PluginResult(PluginResult.Status.ERROR, e.getMessage());
                  result.setKeepCallback(true);
                  callbacks.sendPluginResult(result);
                }
              }
          });
      }

      PluginResult pluginResult = new  PluginResult(PluginResult.Status.NO_RESULT);
      pluginResult.setKeepCallback(true); // Keep callback

      return true;
  }
}
