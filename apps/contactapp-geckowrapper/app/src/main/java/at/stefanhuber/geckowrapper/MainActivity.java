package at.stefanhuber.geckowrapper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.mozilla.geckoview.GeckoRuntime;
import org.mozilla.geckoview.GeckoSession;
import org.mozilla.geckoview.GeckoView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GeckoView webview = findViewById(R.id.webview);
        GeckoSession session = new GeckoSession();
        GeckoRuntime runtime = GeckoRuntime.create(this);

        session.open(runtime);
        webview.setSession(session);
        session.loadUri("https://contactapp.stefanhuber.at");

        //this.webview = findViewById(R.id.webview);

        // this.webview.createSe

        // this.webview

    }
}