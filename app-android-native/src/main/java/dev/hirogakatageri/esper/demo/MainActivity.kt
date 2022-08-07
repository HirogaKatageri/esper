package dev.hirogakatageri.esper.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import dev.hirogakatageri.esper.demo.databinding.ActivityMainBinding
import dev.hirogakatageri.esper.demo.events.HomeEvents
import kotlinx.coroutines.flow.collect

class MainActivity: ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    private val viewBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    init {
        lifecycleScope.launchWhenCreated {
            viewModel.counterEsp.state.collect { state ->
                val text = if (state.count == 0) "Increment Me"
                else "You clicked me ${state.count} times"

                viewBinding.btnCounter.text = text
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.btnCounter.setOnClickListener {
            viewModel.counterEsp.postEvent(HomeEvents.IncrementCount(
                viewModel.counterEsp.state.value.count
            ))
        }

        viewBinding.btnReset.setOnClickListener {
            viewModel.counterEsp.postEvent(HomeEvents.ResetCount)
        }
    }
}