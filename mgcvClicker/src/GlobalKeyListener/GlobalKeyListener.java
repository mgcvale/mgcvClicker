package GlobalKeyListener;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import java.awt.event.KeyEvent;
import Clicker.SettingsManager;

import static com.github.kwhat.jnativehook.keyboard.NativeKeyEvent.*;

public class GlobalKeyListener implements NativeKeyListener {
    private JButton button = new JButton();
    private int keyBind = NativeKeyEvent.VC_G;
    private boolean ctrl, alt, shift;
    private SettingsManager sm = new SettingsManager();

    public void setButton(JButton button){
        this.button=button;
    }
    public void setKeyBind(int keyBind){
        this.keyBind=keyBind;
    }
    public GlobalKeyListener(JButton button, SettingsManager sm){
        this.button = button;
        this.sm = sm;
    }
    public int getKeyBind(){
        return keyBind;
    }
    public void setSettingsmanager(SettingsManager sm){
        this.sm=sm;
    }

    public void nativeKeyPressed(NativeKeyEvent e){
        System.out.println("Key pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
        switch(e.getKeyCode()){
            case VC_CONTROL:
                ctrl=true;
                break;
            case VC_SHIFT:
                shift=true;
                break;
            case VC_ALT:
                alt=true;
                break;
            default:
                break;
        }
        if(e.getKeyCode() == keyBind){
            if((sm.shiftModifier && shift) || (sm.ctrlModifier && ctrl) || (sm.altModifier && alt) || (sm.ctrlAltModifier && ctrl && alt) || (sm.ctrlShiftModifier && ctrl && shift)) {
                SwingUtilities.invokeLater(() -> button.doClick());
            }else if(!sm.shiftModifier && !sm.ctrlModifier && !sm.altModifier && !sm.ctrlAltModifier && !sm.ctrlShiftModifier && !ctrl && !alt && !shift){
                SwingUtilities.invokeLater(() -> button.doClick());
            }
        }
    }
    public void nativeKeyReleased(NativeKeyEvent e){
        System.out.println("Key released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
        switch(e.getKeyCode()){
            case VC_CONTROL:
                ctrl=false;
                break;
            case VC_SHIFT:
                shift=false;
                break;
            case VC_ALT:
                alt=false;
                break;
            default:
                break;
        }
    }
}
