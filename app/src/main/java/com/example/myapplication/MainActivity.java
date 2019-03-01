package com.example.myapplication;


import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;





public class MainActivity extends AppCompatActivity{
    private X5WebView mX5WebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);// 设置全屏
        setContentView(R.layout.activity_main);
        mX5WebView = (X5WebView) findViewById(R.id.mX5WebView);
        mX5WebView.loadUrl("");
        NavigationView cs = (NavigationView) findViewById(R.id.nav_view);
        cs.setCheckedItem(R.id.nav_ca);
        cs.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.nav_ca:
                        
                        break;
                    case R.id.nav_gd:
                        Intent intent = new Intent(MainActivity.this,Main4Activity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_jc:
                        
                        break;
                    case R.id.nav_yx:
                        
                        break;
                    case R.id.nav_ky:
                        
                        break;

                }

                return true;
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mX5WebView != null && mX5WebView.canGoBack()) {
                mX5WebView.goBack();
                return true;
            } else {
                return super.onKeyDown(keyCode, event);
            }
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onDestroy() {
        //释放资源
        if (mX5WebView !=null )
            mX5WebView.destroy();
        super.onDestroy();
    }
}
