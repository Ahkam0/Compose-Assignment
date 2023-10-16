package com.ahkam.mediassist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.ahkam.mediassist.presentation.viewmodel.ProblemViewModel
import com.ahkam.mediassist.presentation.viewmodel.ProblemViewModelFactory
import com.ahkam.mediassist.ui.theme.MediAssistTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var factory: ProblemViewModelFactory
    private lateinit var problemViewModel: ProblemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        problemViewModel = ViewModelProvider(this, factory)[ProblemViewModel::class.java]


        setContent {
            MediAssistTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val problems =
                        problemViewModel.getProblems().collectAsState(initial = null).value

                    problems?.get(0)?.diabetes?.get(0)?.medications?.get(0)?.medicationsClasses?.get(0)?.className2?.get(0)?.associatedDrug2?.get(0)?.name?.let {
                        Greeting(
                            it
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MediAssistTheme {
        Greeting("Android")
    }
}