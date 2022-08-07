import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import dev.hirogakatageri.desktop.sandbox.ui.home.HomeViewModel
import dev.hirogakatageri.desktop.sandbox.ui.home.events.HomeEvents
import dev.hirogakatageri.desktop.sandbox.ui.home.state.CountState

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Compose Sandbox for Desktop",
        state = rememberWindowState(width = 300.dp, height = 300.dp)
    ) {
        val viewModel = HomeViewModel()

        val countState by viewModel.counterEsp.state.collectAsState(
            CountState(0)
        )

        MaterialTheme {
            Column(Modifier.fillMaxSize(), Arrangement.spacedBy(5.dp)) {
                Button(modifier = Modifier.align(Alignment.CenterHorizontally),
                    onClick = {
                        viewModel.counterEsp.postEvent {
                            HomeEvents.IncrementCount(countState.count)
                        }
                    }) {
                    Text(if (countState.count == 0) "Hello World" else "Clicked ${countState.count}!")
                }
                Button(modifier = Modifier.align(Alignment.CenterHorizontally),
                    onClick = {
                        viewModel.counterEsp.postEvent {
                            HomeEvents.ResetCount
                        }
                    }) {
                    Text("Reset")
                }
            }
        }
    }
}