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
        System.out.println("channel InActive");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel Registered");
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel UnRegistered");
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel Active");
        sendMsg(ctx,msg2Send);
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
    public void channelClose(ChannelHandlerContext ctx){
        ctx.close();
    }

    public void sendMsg (ChannelHandlerContext ctx, String msg){
        ctx.writeAndFlush(msg);
        System.out.println("sendMessage:" +  msg);
    }
}
