package Model;

import javafx.collections.ObservableArray;

public class Message  {
    public String getSrcId() {
        return srcId;
    }
    public void setSrcId(String srcId) {
        this.srcId = srcId;
    }
    private String srcId;

    public String getDstID() {
        return dstID;
    }

    public void setDstID(String dstID) {
        this.dstID = dstID;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public MessageDescription getMsgDescription() {
        return msgDescription;
    }

    public void setMsgDescription(MessageDescription msgDescription) {
        this.msgDescription = msgDescription;
    }

    private String dstID;
    private String msgType;
    private MessageDescription msgDescription;
   public static class MessageDescription{
       private String itemCode;
       private int itemNum;
       private int dvmXCoord;
       private int dvmYCoord;
       private String authCode;

       public String getItemCode() {
           return itemCode;
       }

       public void setItemCode(String itemCode) {
           this.itemCode = itemCode;
       }

       public int getItemNum() {
           return itemNum;
       }

       public void setItemNum(int itemNum) {
           this.itemNum = itemNum;
       }

       public int getDvmXCoord() {
           return dvmXCoord;
       }

       public void setDvmXCoord(int dvmXCoord) {
           this.dvmXCoord = dvmXCoord;
       }

       public int getDvmYCoord() {
           return dvmYCoord;
       }

       public void setDvmYCoord(int dvmYCoord) {
           this.dvmYCoord = dvmYCoord;
       }

       public String getAuthCode() {
           return authCode;
       }

       public void setAuthCode(String authCode) {
           this.authCode = authCode;
       }
    }
}

