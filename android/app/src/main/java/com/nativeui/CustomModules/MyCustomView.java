package com.nativeui.CustomModules;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.nativeui.R;

public class MyCustomView extends RelativeLayout {
    private boolean status = false;
    private float size = 18f;

    LayoutInflater mInflater;
    TextView tv;

    public MyCustomView(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);

        tv = new TextView(context);
        init();
    }

    public MyCustomView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mInflater = LayoutInflater.from(context);

        tv = new TextView(context, attrs,defStyle);
        init();
    }

    public MyCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mInflater = LayoutInflater.from(context);

        tv = new TextView(context, attrs);
        init();
    }

    private void init() {
        this.addView(tv);
        setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        tv.setText("Custom RelativeLayout");
        tv.setTextSize(size);
        tv.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);

        this.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MyCustomView.this.onClick();
            }
        });

        tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                WritableMap event = Arguments.createMap();

                event.putString("value1","text view was clicked");

                ReactContext reactContext = (ReactContext)getContext();
                reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(getId(), "onTextClickEvent", event);
            }
        });
    }

    public void setStatus(boolean status) {
        this.status = status;
        setBackgroundColor( this.status ? Color.GREEN : Color.RED);
    }

    public void setFontSize(float size) {
        this.size = size;
        tv.setTextSize(size);
    }

    public void onClick() {
        WritableMap event = Arguments.createMap();

        event.putString("value1","react demo");
        event.putInt("value2",1);

        ReactContext reactContext = (ReactContext)getContext();
        reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(getId(), "onClickEvent", event);
    }
}
