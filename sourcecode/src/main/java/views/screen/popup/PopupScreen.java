package views.screen.popup;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import views.screen.BaseScreenHandler;
import views.screen.ViewsConfig;

import java.io.IOException;


public class PopupScreen extends BaseScreenHandler {

	
	private final double AUTO_CLOSE_TIME = 0.8;
    @FXML
    ImageView icon;

    @FXML
    Label message;

    public PopupScreen(Stage stage) throws IOException{
        super(stage, ViewsConfig.POPUP_PATH,null);
    }

    private static PopupScreen createPopupScreen(String message, String imagePath, Boolean undecorated) throws IOException{
        PopupScreen popup = new PopupScreen(new Stage());
        if (undecorated) popup.stage.initStyle(StageStyle.UNDECORATED);
        popup.message.setText(message);
        popup.setImage(imagePath);
        return popup;
    }

    public static void showSuccessPopup(String message) throws IOException{
        createPopupScreen(message, ViewsConfig.IMAGE_PATH + "/" + "tickgreen.png", true)
                .show(true);
    }

    public static void showErrorPopup(String message) throws IOException{
        createPopupScreen(message, ViewsConfig.IMAGE_PATH + "/" + "tickerror.png", false)
                .show(false);
    }

    public static PopupScreen loading(String message) throws IOException{
        return createPopupScreen(message, ViewsConfig.IMAGE_PATH + "/" + "loading.gif", true);
    }

    public void setImage(String path) {
        super.setImage(icon, path);
    }

    public void show(Boolean autoClose) {
        super.show();
        if (autoClose) close(AUTO_CLOSE_TIME);
    }

    public void show(double time) {
        super.show();
        close(time);
    }

    public void close(double time) {
        PauseTransition delay = new PauseTransition(Duration.seconds(time));
        delay.setOnFinished( event -> stage.close() );
        delay.play();
    }

    protected void setupData(Object dto) throws Exception {
    }

    protected void setupFunctionality() throws Exception {
    }

	@Override
	protected void showError() throws IOException {
		// TODO Auto-generated method stub
		
	}
}
