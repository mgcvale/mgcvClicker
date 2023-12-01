package GlobalKeyListener;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;

import java.awt.event.KeyEvent;


public class KeyEventConverter{
    public int convertKeyEvent(int e){
        int keyCode = KeyEvent.VK_UNDEFINED;
        keyCode = switch (e) {
            case KeyEvent.VK_ESCAPE -> NativeKeyEvent.VC_ESCAPE;

            // Begin Function Keys
            case KeyEvent.VK_F1 -> NativeKeyEvent.VC_F1;
            case KeyEvent.VK_F2 -> NativeKeyEvent.VC_F2;
            case KeyEvent.VK_F3 -> NativeKeyEvent.VC_F3;
            case KeyEvent.VK_F4 -> NativeKeyEvent.VC_F4;
            case KeyEvent.VK_F5 -> NativeKeyEvent.VC_F5;
            case KeyEvent.VK_F6 -> NativeKeyEvent.VC_F6;
            case KeyEvent.VK_F7 -> NativeKeyEvent.VC_F7;
            case KeyEvent.VK_F8 -> NativeKeyEvent.VC_F8;
            case KeyEvent.VK_F9 -> NativeKeyEvent.VC_F9;
            case KeyEvent.VK_F10 -> NativeKeyEvent.VC_F10;
            case KeyEvent.VK_F11 -> NativeKeyEvent.VC_F11;
            case KeyEvent.VK_F12 -> NativeKeyEvent.VC_F12;
            case KeyEvent.VK_F13 -> NativeKeyEvent.VC_F13;
            case KeyEvent.VK_F14 -> NativeKeyEvent.VC_F14;
            case KeyEvent.VK_F15 -> NativeKeyEvent.VC_F15;
            case KeyEvent.VK_F16 -> NativeKeyEvent.VC_F16;
            case KeyEvent.VK_F17 -> NativeKeyEvent.VC_F17;
            case KeyEvent.VK_F18 -> NativeKeyEvent.VC_F18;
            case KeyEvent.VK_F19 -> NativeKeyEvent.VC_F19;
            case KeyEvent.VK_F20 -> NativeKeyEvent.VC_F20;
            case KeyEvent.VK_F21 -> NativeKeyEvent.VC_F21;
            case KeyEvent.VK_F22 -> NativeKeyEvent.VC_F22;
            case KeyEvent.VK_F23 -> NativeKeyEvent.VC_F23;
            case KeyEvent.VK_F24 -> NativeKeyEvent.VC_F24;

            case KeyEvent.VK_BACK_QUOTE -> NativeKeyEvent.VC_BACKQUOTE;
            case KeyEvent.VK_1 -> NativeKeyEvent.VC_1;
            case KeyEvent.VK_2 -> NativeKeyEvent.VC_2;
            case KeyEvent.VK_3 -> NativeKeyEvent.VC_3;
            case KeyEvent.VK_4 -> NativeKeyEvent.VC_4;
            case KeyEvent.VK_5 -> NativeKeyEvent.VC_5;
            case KeyEvent.VK_6 -> NativeKeyEvent.VC_6;
            case KeyEvent.VK_7 -> NativeKeyEvent.VC_7;
            case KeyEvent.VK_8 -> NativeKeyEvent.VC_8;
            case KeyEvent.VK_9 -> NativeKeyEvent.VC_9;
            case KeyEvent.VK_0 -> NativeKeyEvent.VC_0;
            case KeyEvent.VK_MINUS -> NativeKeyEvent.VC_MINUS;
            case KeyEvent.VK_EQUALS -> NativeKeyEvent.VC_EQUALS;
            case KeyEvent.VK_BACK_SPACE -> NativeKeyEvent.VC_BACKSPACE;
            case KeyEvent.VK_TAB -> NativeKeyEvent.VC_TAB;
            case KeyEvent.VK_CAPS_LOCK -> NativeKeyEvent.VC_CAPS_LOCK;
            case KeyEvent.VK_A -> NativeKeyEvent.VC_A;
            case KeyEvent.VK_B -> NativeKeyEvent.VC_B;
            case KeyEvent.VK_C -> NativeKeyEvent.VC_C;
            case KeyEvent.VK_D -> NativeKeyEvent.VC_D;
            case KeyEvent.VK_E -> NativeKeyEvent.VC_E;
            case KeyEvent.VK_F -> NativeKeyEvent.VC_F;
            case KeyEvent.VK_G -> NativeKeyEvent.VC_G;
            case KeyEvent.VK_H -> NativeKeyEvent.VC_H;
            case KeyEvent.VK_I -> NativeKeyEvent.VC_I;
            case KeyEvent.VK_J -> NativeKeyEvent.VC_J;
            case KeyEvent.VK_K -> NativeKeyEvent.VC_K;
            case KeyEvent.VK_L -> NativeKeyEvent.VC_L;
            case KeyEvent.VK_M -> NativeKeyEvent.VC_M;
            case KeyEvent.VK_N -> NativeKeyEvent.VC_N;
            case KeyEvent.VK_O -> NativeKeyEvent.VC_O;
            case KeyEvent.VK_P -> NativeKeyEvent.VC_P;
            case KeyEvent.VK_Q -> NativeKeyEvent.VC_Q;
            case KeyEvent.VK_R -> NativeKeyEvent.VC_R;
            case KeyEvent.VK_S -> NativeKeyEvent.VC_S;
            case KeyEvent.VK_T -> NativeKeyEvent.VC_T;
            case KeyEvent.VK_U -> NativeKeyEvent.VC_U;
            case KeyEvent.VK_V -> NativeKeyEvent.VC_V;
            case KeyEvent.VK_W -> NativeKeyEvent.VC_W;
            case KeyEvent.VK_X -> NativeKeyEvent.VC_X;
            case KeyEvent.VK_Y -> NativeKeyEvent.VC_Y;
            case KeyEvent.VK_Z -> NativeKeyEvent.VC_Z;
            case KeyEvent.VK_OPEN_BRACKET -> NativeKeyEvent.VC_OPEN_BRACKET;
            case KeyEvent.VK_CLOSE_BRACKET -> NativeKeyEvent.VC_CLOSE_BRACKET;
            case KeyEvent.VK_BACK_SLASH -> NativeKeyEvent.VC_BACK_SLASH;
            case KeyEvent.VK_SEMICOLON -> NativeKeyEvent.VC_SEMICOLON;
            case KeyEvent.VK_QUOTE -> NativeKeyEvent.VC_QUOTE;
            case KeyEvent.VK_ENTER -> NativeKeyEvent.VC_ENTER;
            case KeyEvent.VK_COMMA -> NativeKeyEvent.VC_COMMA;
            case KeyEvent.VK_PERIOD -> NativeKeyEvent.VC_PERIOD;
            case KeyEvent.VK_SLASH -> NativeKeyEvent.VC_SLASH;
            case KeyEvent.VK_SPACE -> NativeKeyEvent.VC_SPACE;
            // End Alphanumeric Zone

            case KeyEvent.VK_PRINTSCREEN -> NativeKeyEvent.VC_PRINTSCREEN;
            case KeyEvent.VK_SCROLL_LOCK -> NativeKeyEvent.VC_SCROLL_LOCK;
            case KeyEvent.VK_PAUSE -> NativeKeyEvent.VC_PAUSE;

            // Begin Edit Key Zone
            case KeyEvent.VK_INSERT -> NativeKeyEvent.VC_INSERT;
            case KeyEvent.VK_DELETE -> NativeKeyEvent.VC_DELETE;
            case KeyEvent.VK_HOME -> NativeKeyEvent.VC_HOME;
            case KeyEvent.VK_END -> NativeKeyEvent.VC_END;
            case KeyEvent.VK_PAGE_UP -> NativeKeyEvent.VC_PAGE_UP;
            case KeyEvent.VK_PAGE_DOWN -> NativeKeyEvent.VC_PAGE_DOWN;
            // End Edit Key Zone


            // Begin Cursor Key Zone
            case KeyEvent.VK_UP -> NativeKeyEvent.VC_UP;
            case KeyEvent.VK_LEFT -> NativeKeyEvent.VC_LEFT;
            case KeyEvent.VK_CLEAR -> NativeKeyEvent.VC_CLEAR;
            case KeyEvent.VK_RIGHT -> NativeKeyEvent.VC_RIGHT;
            case KeyEvent.VK_DOWN -> NativeKeyEvent.VC_DOWN;
            // End Cursor Key Zone


            // Begin Numeric Zone
            case KeyEvent.VK_NUM_LOCK -> NativeKeyEvent.VC_NUM_LOCK;
            case KeyEvent.VK_SEPARATOR -> NativeKeyEvent.VC_SEPARATOR;
            // End Numeric Zone

            // Begin Modifier and Control Keys
            case KeyEvent.VK_SHIFT -> NativeKeyEvent.VC_SHIFT;
            case KeyEvent.VK_CONTROL -> NativeKeyEvent.VC_CONTROL;
            case KeyEvent.VK_ALT -> NativeKeyEvent.VC_ALT;
            case KeyEvent.VK_META -> NativeKeyEvent.VC_META;
            case KeyEvent.VK_CONTEXT_MENU -> NativeKeyEvent.VC_CONTEXT_MENU;

            // Begin Sun keyboards
            case KeyEvent.VK_HELP -> NativeKeyEvent.VC_SUN_HELP;
            case KeyEvent.VK_STOP -> NativeKeyEvent.VC_SUN_STOP;
            //case KeyEvent.VK_SUN_FRONT:
            //case KeyEvent.VK_SUN_OPEN:
            case KeyEvent.VK_PROPS -> NativeKeyEvent.VC_SUN_PROPS;
            case KeyEvent.VK_FIND -> NativeKeyEvent.VC_SUN_FIND;
            case KeyEvent.VK_AGAIN -> NativeKeyEvent.VC_SUN_AGAIN;
            case KeyEvent.VK_COPY ->
                //case KeyEvent.VK_SUN_INSERT:
                    NativeKeyEvent.VC_SUN_COPY;
            case KeyEvent.VK_CUT -> NativeKeyEvent.VC_SUN_CUT;
            default -> keyCode;
        };
        return keyCode;
    }

}
