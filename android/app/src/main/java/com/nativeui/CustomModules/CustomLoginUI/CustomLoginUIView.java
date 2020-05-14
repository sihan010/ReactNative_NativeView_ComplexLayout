package com.nativeui.CustomModules.CustomLoginUI;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.nativeui.R;

public class CustomLoginUIView extends ConstraintLayout {
    //Main Context
    private Context mContext;
    private View mView;

    //Layout Elements
    Button loginButton;
    EditText userId;
    EditText password;

    //Parameters from React-End
    String paramUserId = null;

    //Constructors
    public CustomLoginUIView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public CustomLoginUIView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    public CustomLoginUIView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init();
    }

    //Layout Inflater, Element initializer, Adds Listener
    private void init() {
        View v = inflate(mContext, R.layout.custom_login_ui, this);
        this.mView = v;

        loginButton = v.findViewById(R.id.buttonLogin);
        userId = v.findViewById(R.id.userId);
        password = v.findViewById(R.id.password);

        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomLoginUIView.this.loginButtonPressed();
            }
        });
    }

    //React Parameter Setters
    public void setParamUserId(String paramUserId) {
        this.paramUserId = paramUserId;
        userId.setText(paramUserId);
    }

    //Custom Methods
    private void loginButtonPressed() {
        WritableMap event = Arguments.createMap();

        event.putString("user",userId.getText().toString());
        event.putString("password",password.getText().toString());

        ReactContext reactContext = (ReactContext)getContext();
        reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(getId(), "onLoginClicked", event);
    }
}
