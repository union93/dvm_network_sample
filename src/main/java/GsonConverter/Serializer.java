package GsonConverter;
import Model.Message;
import com.google.gson.Gson;

public class Serializer {
    public String message2Json(Message msg){
        Gson gson = new Gson();
        String data = gson.toJson(msg);
        return data;
    }
}
