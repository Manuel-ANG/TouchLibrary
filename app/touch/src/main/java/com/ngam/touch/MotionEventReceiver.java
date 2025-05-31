package com.ngam.touch;

import android.view.MotionEvent;

import androidx.annotation.Keep;
import androidx.lifecycle.Observer;
@Keep
public abstract class MotionEventReceiver implements Observer<MotionEvent> {

    @Override
    public final void onChanged(MotionEvent motionEvent) {
        onReceive(motionEvent);
    }

    protected abstract void onReceive(MotionEvent motionEvent);
}