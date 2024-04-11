import javax.swing.*;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.github.mgcvclicker.ui.MainFrame;

public class Application {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch(Exception ignored) {}
        new MainFrame();
    }
}
