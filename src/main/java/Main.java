import DVM_Client.DVMClient;
import DVM_Server.DVMServer;
import DVM_Server.DVMServer;
import Model.Message;
import Serialization.Class2Json;

public class Main {
    public static void main(String[] args) throws Exception {
        DVMClient client = new DVMClient("localhost",8080);
        //DVMServer server = new DVMServer();

        Message msg = new Message();
        msg.setDstID("1");
        msg.setSrcId("2");
        msg.setMsgType("test");

        Class2Json converter = new Class2Json();
        String jsonMsg = converter.msg2Json(msg);

        client.run();
        client.writeMsg(jsonMsg);
    }
}
