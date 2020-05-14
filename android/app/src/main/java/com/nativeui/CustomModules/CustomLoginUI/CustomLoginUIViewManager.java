package com.nativeui.CustomModules.CustomLoginUI;

import androidx.annotation.NonNull;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.Map;

public class CustomLoginUIViewManager extends SimpleViewManager<CustomLoginUIView> {
    private final String PACKAGE_NAME="CustomLoginUI";

    //Parameters
    private final String USER_ID="userId";

    //Events
    private static final String LOGIN_BUTTON_CLICKED="onLoginClicked";

    @NonNull
    @Override
    public String getName() {
        return PACKAGE_NAME;
    }

    @NonNull
    @Override
    protected CustomLoginUIView createViewInstance(@NonNull ThemedReactContext reactContext) {
        return new CustomLoginUIView(reactContext);
    }

    @ReactProp(name = USER_ID)
    public void setUserId(CustomLoginUIView view, String userId){
        view.setParamUserId(userId);
    }

    public Map getExportedCustomBubblingEventTypeConstants() {
        MapBuilder.Builder events = MapBuilder.builder();

        Map onLoginClickedHandler = MapBuilder.of("phasedRegistrationNames",MapBuilder.of("bubbled", LOGIN_BUTTON_CLICKED));
        events.put(LOGIN_BUTTON_CLICKED, onLoginClickedHandler);

        return events.build();
    }
}
