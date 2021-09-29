package at.stefanhuber.instrumentation;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ServerTest {

    @Test
    public void start() throws Exception {
        ServerSocket server = null;

        try {
            server = new ServerSocket(9000);
            boolean loop = true;

            while (loop) {
                Socket socket = server.accept();
                InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
                BufferedReader inputStream = new BufferedReader(inputStreamReader);
                final String line = inputStream.readLine();

                if (line != null) {
                    Log.i("Server", line);
                } else {
                    Log.i("Server", "Message was null");
                }

                if (line == "close") {
                    loop = false;
                    Log.i("Server", "Goodby!");
                }

                inputStream.close();
                socket.close();
            }

        } catch (Exception e) {
            Log.e("Server", e.getMessage());
        }

        if (server != null) {
            server.close();
        }
    }

}
