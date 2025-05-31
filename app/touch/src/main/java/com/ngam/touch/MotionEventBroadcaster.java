package com.ngam.touch;

import android.view.MotionEvent;

import androidx.annotation.Keep;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;

@Keep
public class MotionEventBroadcaster {
    private static MutableLiveData<MotionEvent> motionEventMutableLiveData = new MutableLiveData<>();

    static void broadcast(MotionEvent motionEvent) {
        motionEventMutableLiveData.setValue(motionEvent);
    }

    public static void registerReceiver(MotionEventReceiver motionEventReceiver) {
        motionEventMutableLiveData.observeForever(motionEventReceiver);
    }

    public static void registerReceiver(LifecycleOwner owner, MotionEventReceiver motionEventReceiver) {
        motionEventMutableLiveData.observe(owner, motionEventReceiver);
    }

    public static void removeReceiver(MotionEventReceiver motionEventReceiver) {
        motionEventMutableLiveData.removeObserver(motionEventReceiver);
    }

    public static void removeReceivers(LifecycleOwner owner) {
        motionEventMutableLiveData.removeObservers(owner);
    }
}