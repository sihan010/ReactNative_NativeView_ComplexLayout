package com.nativeui.CustomModules;

import android.util.Log;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.nativeui.R;

import java.util.Map;

public class MyCustomViewManager extends SimpleViewManager<MyCustomView> {
    public static final String REACT_CLASS = "RCTMyCustomView";

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @NonNull
    @Override
    protected MyCustomView createViewInstance(@NonNull ThemedReactContext reactContext) {
//        LayoutInflater inflater = (LayoutInflater) reactContext.getSystemService(reactContext.LAYOUT_INFLATER_SERVICE);
//        MyCustomView view = (MyCustomView)inflater.inflate(R.layout.custom_vew, null);
        return new MyCustomView(reactContext);
    }

    @ReactProp(name = "status")
    public void setStatus(MyCustomView view, Boolean status){
        Log.i("Tag", String.valueOf(status));
        view.setStatus(status);
    }

    @ReactProp(name = "fontSize")
    public void setFontSize(MyCustomView view, float fontSize){
        Log.i("Tag", String.valueOf(fontSize));
        view.setFontSize(fontSize);
    }

    public Map getExportedCustomBubblingEventTypeConstants() {
        Map onClickHandler = MapBuilder.of("phasedRegistrationNames",MapBuilder.of("bubbled", "onClick"));
        Map onTextClickHandler = MapBuilder.of("phasedRegistrationNames",MapBuilder.of("bubbled", "onTextClick"));

        MapBuilder.Builder events = MapBuilder.builder();
        events.put("onClickEvent", onClickHandler);
        events.put("onTextClickEvent", onTextClickHandler);
        return events.build();
    }
}
