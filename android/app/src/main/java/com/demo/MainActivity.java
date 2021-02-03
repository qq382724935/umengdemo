/*
 * @Author: 刘利军
 * @Date: 2020-06-22 11:12:02
 * @LastEditors: 刘利军
 * @LastEditTime: 2021-02-03 13:47:52
 * @Description: 
 */ 
package com.demo;

import com.facebook.react.ReactActivity;
import android.os.Bundle;
import android.os.Build;
import android.Manifest;

import android.util.Log;
import android.content.Intent;

import com.umeng.socialize.UMShareAPI;
import com.demo.umeng.ShareModule;

public class MainActivity extends ReactActivity {

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  @Override
  protected String getMainComponentName() {
    return "demo";
  }
  // 启动屏重写onCreate
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    /**友盟 start */
    ShareModule.initSocialSDK(this);
    /**友盟 end */
    // if(Build.VERSION.SDK_INT>=23){
    //               String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
    //               ActivityCompat.requestPermissions(this,mPermissionList,123);
    //           }
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
      super.onActivityResult(requestCode, resultCode, data);
      UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
  }

  @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}

