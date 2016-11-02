package com.park.rulertest;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    WebView rsWebView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rsWebView1 = (WebView) findViewById(R.id.webView);


        WebSettings settings = rsWebView1.getSettings();
        settings.setSupportZoom(false);
        settings.setLightTouchEnabled(false);
        settings.setJavaScriptEnabled(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);

        rsWebView1.setFadingEdgeLength(20);
        rsWebView1.setVerticalFadingEdgeEnabled(true);
        rsWebView1.setHorizontalFadingEdgeEnabled(true);
        rsWebView1.setMotionEventSplittingEnabled(false);
        rsWebView1.setBackgroundColor(0x44996666);
        rsWebView1.clearCache(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            rsWebView1.setWebContentsDebuggingEnabled(true);
        }


        rsWebView1.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

       StringBuilder html = new StringBuilder("<!DOCTYPE html><html><head><meta charset=\"UTF-8\" />")
                .append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\" />")
                .append("<title>RapidSketch</title>")
                .append("<link href=\"file:///android_asset/rulersguides.css\" rel=\"stylesheet\" type=\"text/css\" />")
                .append("<script src=\"file:///android_asset/Dragdrop.js\" type=\"text/javascript\"></script>")
                .append("<script src=\"file:///android_asset/Event.js\" type=\"text/javascript\"></script>")
                .append("<script src=\"file:///android_asset/RulersGuides.js\" type=\"text/javascript\"></script>")
                .append("</head><body><div id=\"cont\">" +
                        "</div></body></html>");


        String html1 = "<html><head><title>RulersGuides.js demo</title>" +
                "<link rel=\"stylesheet\" " +
                "type=\"text/css\" href=\"file:///android_asset/rulersguides.css\"></head><body class=\"demo\">" +
                "<script type=\"text/javascript\" src=\"file:///android_asset/Event.js\"></script>" +
                "<script type=\"text/javascript\" src=\"file:///android_asset/Dragdrop.js\"></script>" +
                "<script type=\"text/javascript\" src=\"file:///android_asset/RulersGuides.js\"></script>" +
                "<script type=\"text/javascript\">" +
                "var evt = new Event(),dragdrop = new Dragdrop(evt)," +
                "rg = new RulersGuides(evt, dragdrop);</script></body></html>";



        ///  rsWebView.loadDataWithBaseURL("file:///android_asset/rs.html", html.toString(), "text/html", "utf-8", null);


        final String mimeType = "text/html";
        final String encoding = "UTF-8";
        String html5 = "<br /><br />Read the handouts please for tomorrow.<br /><br /><!--homework help homework" +
                "help help with homework homework assignments elementary school high school middle school" +
                "// --><font color='#60c000' size='4'><strong>Please!</strong></font>" +
                "<img src='http://www.homeworknow.com/hwnow/upload/images/tn_star300.gif'  />";

        //  rsWebView.loadUrl("file:///android_asset/index1.html");
        rsWebView1.loadDataWithBaseURL("", html1, mimeType, encoding, "");
    }
}
