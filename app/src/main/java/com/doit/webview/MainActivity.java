package com.doit.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
/*
webView사용법

원하는 홈페이지를 앱내에서 띄우기
android:usesCleartextTraffic="true" // err_cleartext_not_permitted error시 매니페스트에 추가



 */
public class MainActivity extends AppCompatActivity {
    private WebView webView; // 사용할 웹뷰 선언
    private String url = "https://www.naver.com"; //url변수선언후 안에 사용할 주소 저장

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView); // 선언한변수랑 웹뷰연결
        webView.getSettings().setJavaScriptEnabled(true); // 자바스크립트 허용
        webView.loadUrl(url); //url 불러들이기
        webView.setWebChromeClient(new WebChromeClient()); // 크롬브라우저 특화
        webView.setWebViewClient(new WebViewClient()); // 웹뷰에서 바로 인터넷브라우저사용가능




    }

    // 이 메서드가없으면 웹뷰에서 아이템클릭후 이동한다음 뒤로가기키를 눌렀을때 앱이 종료됨
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) { // 사용자가 키를 눌렀을때 발생하는 이벤트 메서드
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) { //입력된 키가 뒤로가기 키와 같고 웹뷰의 뒤로가기키와 같을때
            webView.goBack(); // 웹뷰를 뒤로보냄
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private static class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}