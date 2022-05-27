package DVM_Server;
import Model.Message;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import java.net.InetSocketAddress;
import java.util.ArrayList;


public class DVMServer {

    private static final int PORT = 8080;
    public static ArrayList<Message> msgList = new ArrayList<>();
    public static ObservableList<Message> observableList =  FXCollections.observableArrayList();
    public void run() throws Exception{

        EventLoopGroup parentGroup = new NioEventLoopGroup();
        EventLoopGroup childGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bs = new ServerBootstrap();
            bs.group(parentGroup,childGroup)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(PORT))
                    .childHandler(new DVMServerInitializer());
            ChannelFuture future = bs.bind().sync();
            future.channel().closeFuture().sync();
        }
        catch (Exception e){
            e.toString();
        }
        finally {
            parentGroup.shutdownGracefully();
            childGroup.shutdownGracefully();
        }
    }
    public void setMessageListner( ListChangeListener listener){
        observableList.addListener(listener);
    }
}
