package DVM_Server;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class DVMServerInitializer extends ChannelInitializer<SocketChannel>{
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast();
    }
}

