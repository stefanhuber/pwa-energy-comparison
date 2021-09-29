package at.stefanhuber.instrumentation.interactions;

import android.os.Build;
import android.os.SystemClock;

public class ScrollUpListInteraction extends Interaction {

    protected int swipes = 5;

    public void ScrollDownListInteraction(int swipes) {
        this.swipes = swipes;
    }

    @Override
    public void interact() {
        for (int i = 0; i < swipes; i++) {
            uiDevice.swipe(calculateRelativeXPosition(0.5), calculateRelativeYPosition(0.4), calculateRelativeXPosition(0.5), calculateRelativeYPosition(0.75), 5);
            SystemClock.sleep(2000);
        }
    }
}
