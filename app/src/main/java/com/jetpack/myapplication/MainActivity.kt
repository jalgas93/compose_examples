package com.jetpack.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.jetpack.myapplication.ui.theme.Compose_1Theme
import com.jetpack.myapplication.ui.theme.Purple40


class MainActivity : ComponentActivity() {
    val viewModel by lazy {
        ViewModelProvider(this).get(MyViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            Compose_1Theme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black),
                    contentAlignment = Alignment.Center
                ) {

                    val annotatedString = buildAnnotatedString {
                        blueGradientText("NEW")
                        append("\n\n")
                        pinkBlueGradientText("Gradient")
                        append("\n\n")
                        blueGradientText("text")
                    }
                    Text(text = annotatedString)

                }
            }
        }
    }

    @OptIn(ExperimentalTextApi::class)
    private fun AnnotatedString.Builder.blueGradientText(text: String) {
        withStyle(
            style = SpanStyle(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF2788C7),
                        Color(0xFF00BB04)
                    )
                ),
                fontSize = 42.sp,
                fontWeight = FontWeight.Medium
            )
        ) {
            append(text)
        }
    }

    @OptIn(ExperimentalTextApi::class)
    private fun AnnotatedString.Builder.pinkBlueGradientText(text: String) {
        withStyle(
            style = SpanStyle(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF2788C7),
                        Color(0xFF00BB04)
                    )
                ),
                fontSize = 42.sp,
                fontWeight = FontWeight.Medium
            )
        ) {
            append(text)
        }
    }


}

@Composable
fun MyTextField(
    textValue: String,
    onValueChanged: (String) -> Unit,
    onAddClick: () -> Unit,
) {
    TextField(
        value = textValue, onValueChange = {
            onValueChanged(it)
        }, modifier = Modifier.fillMaxWidth(),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                modifier = Modifier.clickable {
                    onAddClick()
                })
        }
    )
}


//val state = viewModel.state.value
/*
     Column(
                    modifier = Modifier.fillMaxSize(),
                ) {

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        items(
                            state.namesList.size
                        ) {
                            Text(text = state.namesList[it])
                        }
                    }
                    MyTextField(
                        textValue = state.textState,
                        onValueChanged = {
                            viewModel.updateText(it)
                        },
                        onAddClick = {
                            viewModel.updateNameList()
                            viewModel.updateText("")
                        }
                    )
                }
 */
