package com.ehab.networkFramework;

import org.json.JSONObject;

import java.io.IOException;

public interface JSONObjectRequestListener {
        void onResponse(JSONObject response);
        void onError(IOException error);
}
