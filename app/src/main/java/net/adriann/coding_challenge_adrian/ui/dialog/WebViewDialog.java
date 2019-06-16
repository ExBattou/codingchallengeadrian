package net.adriann.coding_challenge_adrian.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import net.adriann.coding_challenge_adrian.R;

import butterknife.BindView;
import butterknife.OnClick;


public class WebViewDialog extends Dialog {


    public Context activity;
    String webToLoad;
    @BindView(R.id.webView_reddit)
    WebView webView;


    public WebViewDialog(Context activity, String web) {
        super(activity);

        this.activity = activity;
        webToLoad = web;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_post_viewer);

        webView = findViewById(R.id.webView_reddit);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
        });

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(webToLoad);

    }

    @OnClick(R.id.closingx)
    public void closeDialog(){
        dismiss();
    }
}
