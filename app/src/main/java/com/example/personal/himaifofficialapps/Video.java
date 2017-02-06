package com.example.personal.himaifofficialapps;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class Video extends Fragment {

    WebView webView;
    public Video() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_video, container, false);
        webView = (WebView) v.findViewById(R.id.youtubeweb);
        webView.setWebViewClient(new MyWebViewClient());
        String url = "https://www.youtube.com/watch?v=e0vei3TUXcQ";
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        return v;
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onResume()
    {
        super.onResume();
        webView.onResume();
    }

    @Override
    public void onPause()
    {
        super.onPause();
        webView.onPause();
    }

}
