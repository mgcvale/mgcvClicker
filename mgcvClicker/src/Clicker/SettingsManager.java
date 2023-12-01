package Clicker;
import com.github.kwhat.jnativehook.keyboard.*;

import java.awt.event.InputEvent;

public class SettingsManager {
    public double CPS=10;
    public long holdTime=20;
    public boolean waitsBeforeStart = false;
    public boolean stopsAfterTime = false;
    public boolean stopsAfterClicks = false;
    private int keyBind = NativeKeyEvent.VC_G;
    public boolean altModifier = false;
    public boolean shiftModifier = false;
    public boolean ctrlModifier = false;
    public boolean ctrlAltModifier = false;
    public boolean ctrlShiftModifier =false;
    public int mouseButton = InputEvent.BUTTON1_DOWN_MASK;

    public long waitBeforeStart = 0;
    public int stopAfterClicks = 0;
    public long stopAfterTime = 0;

    public void setKeyBind(int keyBind){
        this.keyBind = keyBind;
    }
    public int getKeyBind(){
        return keyBind;
    }
    public void setStopsAfterClicks(boolean stopAfterClicks) {
        this.stopsAfterClicks = stopAfterClicks;
    }
    public void setStopsAfterTime(boolean stopsAfterTime) {
        this.stopsAfterTime = stopsAfterTime;
    }
    public void setWaitsBeforeStart(boolean waitsBeforeStart) {
        this.waitsBeforeStart = waitsBeforeStart;
    }
    public void setStopAfterClicks(int stopAfterClicks) {
        this.stopAfterClicks = stopAfterClicks;
    }
    public void setStopAfterTime(long stopAfterTime) {
        this.stopAfterTime = stopAfterTime;
    }
    public void setWaitBeforeStart(long waitBeforeStart) {
        this.waitBeforeStart = waitBeforeStart;
    }
    public boolean getStopsAfterClicks(){
        return stopsAfterClicks;
    }
    public boolean getStopsAfterTime(){
        return stopsAfterTime;
    }
    public boolean WaitsBeforeStart(){
        return waitsBeforeStart;
    }
    public long getStopAfterClicks(){
        return stopAfterClicks;
    }
    public long getStopAfterTime(){
        return stopAfterTime;
    }
    public long getWaitBeforeStart(){
        return waitBeforeStart;
    }
    public double getHoldTime() {
        return holdTime;
    }
    public double getCPS() {
        return CPS;
    }
    public void setHoldTime(long holdTime) {
        this.holdTime = holdTime;
    }
    public void setCPS(double CPS) {
        this.CPS = CPS;
    }
}
