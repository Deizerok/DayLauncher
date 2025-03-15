package MainScreen.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import core.Colors
import core.loadOpenSans
import kotlin.system.exitProcess

@Composable
fun MainScreen() {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxSize(1f)) {
            BackgroundImage()
            Row {
                NavigationBar()
                MainUI()
            }
        }
    }
}

@Composable
fun NavigationBar() {
    Column(
        modifier = Modifier.fillMaxHeight().background(Colors.NavigationBackColor).padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Spacer(modifier = Modifier.height(20.dp))

        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Colors.NavigationButtonColor // Застосовуємо кастомний колір
            ), onClick = { /* Handle settings action */ }, modifier = Modifier.size(56.dp).clip(CircleShape)
        ) {
            Icon(
                painter = painterResource("icons/settings_24dp.svg"),
                contentDescription = "Settings",
                tint = Color.Unspecified // Вимикає автоматичне фарбування іконки
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Colors.PrimaryColor // Застосовуємо кастомний колір
            ), onClick = { /* Handle play action */ }, modifier = Modifier.size(56.dp).clip(CircleShape)
        ) {
            Icon(
                painter = painterResource("icons/home_app_logo_24dp.svg"),
                contentDescription = "HomeScreen",
                tint = Color.Unspecified // Вимикає автоматичне фарбування іконки
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Colors.NavigationButtonColor // Застосовуємо кастомний колір
            ), onClick = { exitProcess(0) }, // Закриваємо програму при натисканні кнопки
            modifier = Modifier.size(56.dp).clip(CircleShape)
        ) {
            Icon(
                painter = painterResource("icons/exit_to_app_24dp.svg"),
                contentDescription = "Exit",
                tint = Color.Unspecified // Вимикає автоматичне фарбування іконки
            )
        }
    }
}

@Composable
fun BackgroundImage() {
    val image = painterResource("background/background_home.png") // Шлях до файлу в ресурсах

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun MainUI() {
    var expanded by remember { mutableStateOf(false) } // Стан меню

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(80.dp))

        DefaultText(
            "Minecraft Version",
            32.sp,
            Color.White,
        )

        Text(
            "Minecraft is an open-world sandbox game that lets you explore, build, and survive in a blocky universe. Whether you're crafting alone or adventuring with friends, it offers endless creativity and fun",
            modifier = Modifier.width(302.dp).padding(8.dp),
            textAlign = TextAlign.Center,
            color = Color.Gray,
            fontSize = 11.sp,
            fontFamily = loadOpenSans(),
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(16.dp))

        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Colors.PrimaryColor),
                onClick = { /* Handle play action */ },
                shape = RoundedCornerShape(50),
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                Icon(
                    modifier = Modifier.padding(end = 2.dp),
                    painter = painterResource("icons/play_24dp.svg"),
                    contentDescription = "Play",
                    tint = Color.Unspecified
                )
                DefaultText(
                    "Play",
                    14.sp,
                    Color.White,
                )

            }

            Box {
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = Colors.PrimaryColor),
                    onClick = { expanded = true },
                    shape = RoundedCornerShape(50)
                ) {
                    Icon(
                        modifier = Modifier.padding(end = 2.dp),
                        painter = painterResource("icons/more_24dp.svg"),
                        contentDescription = "Select Version",
                        tint = Color.Unspecified
                    )

                    Text(
                        "Select Version",
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontSize = 14.sp,
                        fontFamily = loadOpenSans(),
                        fontWeight = FontWeight.Bold
                    )
                }
                MaterialTheme(shapes = MaterialTheme.shapes.copy(medium = RoundedCornerShape(12.dp))) {
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier.background(Colors.PrimaryColor)
                    ) {
                        DropdownMenuItem(
                            onClick = { println("Версія Minecraft 1.16.5 Optifine"); expanded = false }
                        ) {
                            DefaultText("Minecraft 1.16.5 Optifine", 14.sp, Color.White)
                        }
                        DropdownMenuItem(
                            onClick = { println("Версія Minecraft 1.14.4 Optifine"); expanded = false }
                        ) {
                            DefaultText("Minecraft 1.14.4 Optifine", 14.sp, Color.White)
                        }
                        DropdownMenuItem(
                            onClick = { println("Версія Minecraft 1.12.2 Optifine"); expanded = false }
                        ) {
                            DefaultText("Minecraft 1.12.2 Optifine", 14.sp, Color.White)
                        }
                        DropdownMenuItem(
                            onClick = { println("Версія Minecraft 1.8.9 Optifine"); expanded = false }
                        ) {
                            DefaultText("Minecraft 1.8.9 Optifine", 14.sp, Color.White)
                        }
                    }
                }
            }
        }

        Spacer(Modifier.height(90.dp))
        Row(
            modifier = Modifier
                .background(
                    Color(0x6F202D).copy(alpha = 0.7f),
                    RoundedCornerShape(12.dp)
                )
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.padding(10.dp),
                painter = painterResource("icons/badge_24dp.svg"),
                contentDescription = "badge",
                tint = Color.Unspecified // Вимикає автоматичне фарбування іконки
            )
            Column(
                modifier = Modifier.padding(4.dp),
            ) {
                DefaultText(
                    "Nickname",
                    16.sp,
                    Color.White,
                )
                DefaultText(
                    "Local Account",
                    12.sp,
                    Color.Gray,
                )
            }
        }
    }
}


@Composable
fun DefaultText(text: String, size: TextUnit, color: Color) {
    Text(
        text,
        modifier = Modifier.padding(1.dp),
        textAlign = TextAlign.Center,
        color = color,
        fontSize = size,
        fontFamily = loadOpenSans(),
        fontWeight = FontWeight.Bold
    )
}