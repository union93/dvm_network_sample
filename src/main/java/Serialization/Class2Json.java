package Serialization;

import Model.Message;
import com.google.gson.Gson;

public class Class2Json {
    public String msg2Json(Message msg){
        Gson gson = new Gson();
        String json = gson.toJson(msg);
        return json;
    }
}
