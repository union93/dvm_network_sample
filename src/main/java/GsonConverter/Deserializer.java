package GsonConverter;

import Model.Message;
import com.google.gson.Gson;

public class Deserializer {
    public Message json2Message(String json){
        Gson gson = new Gson();
        Message msg = gson.fromJson(json,Message.class);
        return msg;
    }
}
