package DVM_Server;

import GsonConverter.Deserializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import javafx.application.Platform;

import static DVM_Server.DVMServer.msgList;
import static DVM_Server.DVMServer.observableList;


public class DVMServerHandler extends SimpleChannelInboundHandler{

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        String data = in.toString(CharsetUtil.UTF_8);
        Deserializer converter = new Deserializer();
        msgList.add(converter.json2Message(data));
        observableList.add(converter.json2Message(data));
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.toString();
        ctx.close();
    }
}


