package ru.otkatNotifier;

import javax.net.SocketFactory;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class McServerChecker {

    public boolean isServerOff() throws UnknownHostException,
            IOException {
        Socket socket = SocketFactory.getDefault().createSocket();
        try {
            socket.setSoTimeout(5000);
            socket.connect(new InetSocketAddress("80.89.194.200", 21000));
            socket.close();
        } catch (ConnectException e) {
            System.err.println(e);
            return false;
        }
        return true;
    }

}
