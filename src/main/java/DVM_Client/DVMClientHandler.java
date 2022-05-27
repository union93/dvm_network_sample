package DVM_Client;
import Model.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;



public class DVMClientHandler extends SimpleChannelInboundHandler<Message> {
    String msg2Send;
    public DVMClientHandler(String msg){
        this.msg2Send = msg;
    }
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        sendMsg(ctx,msg2Send);
        ctx.close();
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    public void sendMsg (ChannelHandlerContext ctx, String msg){
        ctx.writeAndFlush(msg);
        System.out.println("sendMessage:" +  msg);
    }
}
