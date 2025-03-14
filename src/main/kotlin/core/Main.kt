package core

import MainScreen.presentation.MainScreen
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.io.File
import javax.imageio.ImageIO

fun loadOpenSans(): FontFamily {
    return FontFamily(
        Font(File("src/main/resources/fonts/OpenSans-Regular.ttf"), weight = FontWeight.Normal),
        Font(File("src/main/resources/fonts/OpenSans-Bold.ttf"), weight = FontWeight.Bold),
        Font(File("src/main/resources/fonts/OpenSans-Italic.ttf"), style = FontStyle.Italic),
        Font(File("src/main/resources/fonts/OpenSans-Light.ttf"), weight = FontWeight.Light)
    )
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Day Launcher",
    ) {
        window.iconImage = ImageIO.read(Thread.currentThread().contextClassLoader.getResource("icons/Launcher_Icon.png"))
        window.setSize(976, 602)
        MainScreen()
    }
}
