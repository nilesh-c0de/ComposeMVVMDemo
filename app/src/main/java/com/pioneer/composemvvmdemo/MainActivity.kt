package com.pioneer.composemvvmdemo

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.pioneer.composemvvmdemo.ui.theme.ComposeMVVMDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApp {
//                CounterApp()
                LoginPage()
//                TestApp()
//                LoginDemo()
//                TriColorDemo()
//                LazyColumnDemo()
//                LzDemo()
//                ShowMessage(msg = Message("nilesh", "His body"))
            }
        }
    }
}

// starting
@Composable
fun MyApp(content: @Composable () -> Unit) {
    ComposeMVVMDemoTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}

@Composable
fun CounterApp() {
    var counter by remember {
        mutableStateOf(0)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            counter++
        }) {
            Text(text = "I have been clicked $counter times")
        }
    }

}

//@Composable
//fun ApiDemo() {
//    val data by viewModel.result.collectAsState()
//    LaunchedEffect(Unit) {
//        viewModel.fetchProducts()
//    }
//}

@Composable
fun LoginPage() {

    var userName by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier.padding(16.dp),
            elevation = 20.dp,
            shape = RoundedCornerShape(5.dp),
        ) {

            ConstraintLayout(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
            ) {

                val (text1, user, pass, box) = createRefs()

                Text(
                    text = "Welcome Nilesh!",
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Monospace,
                    modifier = Modifier.constrainAs(text1) {

                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top, margin = 10.dp)

                    })

//                Divider(modifier = Modifier.padding(top = 8.dp),Color(0xffd2d2d2))

                OutlinedTextField(
                    value = userName,
                    onValueChange = {
                        userName = it
                    },
                    placeholder = {
                        Text(text = "Username")
                    },
                    modifier = Modifier
                        .padding(start = 16.dp, top = 8.dp, end = 16.dp)
                        .fillMaxWidth(1f)
                        .constrainAs(user) {
                            top.linkTo(text1.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                )

                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    placeholder = {
                        Text(text = "Password")
                    },
                    modifier = Modifier
                        .padding(start = 16.dp, top = 8.dp, end = 16.dp)
                        .fillMaxWidth(1f)
                        .constrainAs(pass) {
                            top.linkTo(user.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                )

                Box(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 16.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .background(Color(0xFFE05836))
                        .constrainAs(box) {
                            top.linkTo(pass.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Log In", modifier = Modifier
                            .padding(top = 10.dp, bottom = 10.dp),
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }

            }
        }
    }

}

// constraint layout demo
@Composable
fun CLayout() {
    ConstraintLayout(modifier = Modifier.background(Color.Green)) {
        // Create references for the composables to constrain
        val (text1, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12, text13, text15, text16, text14) = createRefs()
//        val card = createRef()

        Text(
            text = "View 1",
            modifier = Modifier
                .background(Color.White)
                .padding(10.dp)
                .constrainAs(text1) {
                    top.linkTo(parent.top, margin = 16.dp)
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                }
        )
        Text(
            text = "View 2",
            modifier = Modifier
                .padding(8.dp)
                .background(Color.Cyan)
                .padding(10.dp)
                .constrainAs(text2) {
                    top.linkTo(text1.bottom)
                    start.linkTo(text1.start)
                    end.linkTo(text1.end)
                }
        )
        Text(
            text = "View 3",
            modifier = Modifier
                .padding(start = 8.dp)
                .background(Color.LightGray)
                .padding(10.dp)
                .constrainAs(text3) {
                    start.linkTo(text1.end)
                    top.linkTo(text1.top)
                    bottom.linkTo(text1.bottom)
                }
        )

        Text(text = "View 4",
            modifier = Modifier
                .padding(bottom = 8.dp)
                .background(Color.Yellow)
                .padding(10.dp)
                .constrainAs(text4) {
                    bottom.linkTo(text1.top)
                    start.linkTo(text1.start)
                    end.linkTo(text1.end)
                }
        )

        Text(text = "View 5",
            color = Color.White,
            modifier = Modifier
                .padding(end = 8.dp)
                .background(Color.Blue)
                .padding(10.dp)
                .constrainAs(text5) {
                    end.linkTo(text1.start)
                    top.linkTo(text1.top)
                    bottom.linkTo(text1.bottom)
                }
        )

        Text(text = "View 6",
            modifier = Modifier
                .padding(8.dp)
                .background(Color.LightGray)
                .padding(10.dp)
                .constrainAs(text6) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
        )

        Text(text = "View 7",
            modifier = Modifier
                .padding(8.dp)
                .background(Color.DarkGray)
                .padding(10.dp)
                .constrainAs(text7) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                }
        )

        Text(text = "View 8",
            modifier = Modifier
                .padding(8.dp)
                .background(Color.Magenta)
                .padding(10.dp)
                .constrainAs(text8) {
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                }
        )

        Text(text = "View 9",
            modifier = Modifier
                .padding(8.dp)
                .background(Color.Red)
                .padding(10.dp)
                .constrainAs(text9) {
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        )

        Text(text = "View 10",
            modifier = Modifier
                .padding(8.dp)
                .background(Color.Red)
                .padding(10.dp)
                .constrainAs(text10) {
                    start.linkTo(parent.start)
                    top.linkTo(text6.bottom)
                    bottom.linkTo(text8.top)
                }
        )

        Text(text = "View 11",
            modifier = Modifier
                .padding(8.dp)
                .background(Color.Yellow)
                .padding(10.dp)
                .constrainAs(text11) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Text(text = "View 12",
            modifier = Modifier
                .padding(8.dp)
                .background(Color.Cyan)
                .padding(10.dp)
                .constrainAs(text12) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
        )

        Text(text = "View 13",
            modifier = Modifier
                .padding(8.dp)
                .background(Color.LightGray)
                .padding(10.dp)
                .constrainAs(text13) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Text(
            text = "Constraint Layout Demo",
            color = Color.White,
            modifier = Modifier
                .padding(8.dp)
                .background(Color(0xFFDD2C00))
                .padding(10.dp)
                .constrainAs(text14) {
                    top.linkTo(text13.bottom)
                    bottom.linkTo(text4.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

    }
}

@Composable
fun TestApp() {
    Column(
        modifier = Modifier
            .background(Color.Cyan)
            .padding(top = 30.dp)
    ) {
        Text(
            text = "Test", modifier = Modifier
                .background(Color.Green)
                .padding(10.dp)
        )
    }
}

@Composable
fun LoginDemo() {

    var userName by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Box(modifier = Modifier.fillMaxSize()) {
        ClickableText(
            text = AnnotatedString("Sign up here"),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp),
            onClick = { },
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily.Monospace,
                textDecoration = TextDecoration.Underline,
                color = Color.Cyan
            )
        )
    }

    Column(
        Modifier
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.shankara),
            modifier = Modifier
                .width(100.dp)
                .height(100.dp),
            contentDescription = null
        )

        Card(
            modifier = Modifier
                .background(Color.White)
                .padding(10.dp),
            elevation = 20.dp,
            shape = RoundedCornerShape(5.dp),
//            border = BorderStroke(1.dp, Color.Blue)
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp),

                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Text(
                    text = "Welcome Nilesh!",
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Monospace,
                    modifier = Modifier.fillMaxWidth(1f)
                )

                Divider(modifier = Modifier.padding(top = 8.dp), Color(0xffd2d2d2))

                OutlinedTextField(
                    value = userName,
                    onValueChange = {
                        userName = it
                    },
                    placeholder = {
                        Text(text = "Username")
                    },
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth(1f)
                )

                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    placeholder = {
                        Text(text = "Password")
                    },
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth(1f)
                )

                Box(
                    Modifier
                        .padding(top = 16.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .background(Color(0xFFE05836)),

                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Log In", modifier = Modifier
                            .padding(top = 10.dp, bottom = 10.dp),
                        color = Color.White,
                        fontWeight = FontWeight.Bold

                    )
                }

                Box(
                    Modifier
                        .padding(top = 8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .background(Color(0xFFE05836)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Sign Up", modifier = Modifier
                            .padding(top = 10.dp, bottom = 10.dp),
                        color = Color.White,
                        fontWeight = FontWeight.Bold

                    )
                }
                ClickableText(

                    text = AnnotatedString("Forgot password?"),
                    onClick = {
                    },
                    modifier = Modifier.padding(10.dp),
                    style = TextStyle(
                        textDecoration = TextDecoration.Underline
                    )
                )

            }
        }
    }
}

@Composable
fun TriColorDemo() {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(30.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(colorResource(id = R.color.orange))
                .fillMaxWidth(1f)
                .padding(10.dp)
        ) {
            Text(
                text = "", modifier = Modifier
                    .width(100.dp)
                    .padding(10.dp)
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth(1f)
                .padding(10.dp)
        ) {
            Text(
                text = "", modifier = Modifier
                    .width(100.dp)
                    .background(Color.White)
                    .padding(10.dp)
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Color.Green)
                .fillMaxWidth(1f)
                .padding(10.dp)
        ) {
            Text(
                text = "", modifier = Modifier
                    .width(100.dp)
                    .background(Color.Green)
                    .padding(10.dp)
            )
        }
    }
}

data class Student(val id: String, val name: String)

@Composable
fun LazyColumnDemo() {

    val students = mutableListOf<Student>()
    students.add(Student("1", "nilesh"))
    students.add(Student("2", "xyz"))
    students.add(Student("3", "abc"))
    students.add(Student("4", "pqr"))
    students.add(Student("5", "zxcv"))
    students.add(Student("6", "zxcv"))
    students.add(Student("7", "asdf"))
    students.add(Student("8", "jkl"))
    students.add(Student("9", "mnop"))

    LazyColumn(modifier = Modifier
        .fillMaxHeight()
        .padding(8.dp)) {
//        items(students) { index ->
//            SingleItem(list[index])
//        }
        item {
            Text(text = "Students List")
        }
        items(students.size) { index ->
            Log.i("nileshphonde", "$index")
            SingleItem(students[index])
        }
    }
}

@Composable
fun SingleItem(student: Student) {
    Card(modifier = Modifier.padding(8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = R.drawable.shankara), contentDescription = null, modifier = Modifier
                .width(50.dp)
                .height(50.dp))
            Column(modifier = Modifier.padding(8.dp)) {
                Text(text = "Id: "+ student.id, modifier = Modifier
                    .fillMaxWidth())
                Text(text = "Name:" + student.name, modifier = Modifier
                    .fillMaxWidth())
            }
        }

    }

}

@Composable
fun ShowUI() {
    Text(
        text = "lol",
        fontStyle = FontStyle.Italic,
        fontFamily = FontFamily.Monospace
    )
}

@Composable
fun CardDemo() {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .padding(15.dp)
            .clickable { },
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(
                buildAnnotatedString {
                    append("welcome to ")
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.W900,
                            color = Color(0xFF4552B8)
                        )
                    ) {
                        append("Jetpack Compose Playground")
                    }
                }
            )
            Text(
                buildAnnotatedString {
                    append("Now you are in the ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W900)) {
                        append("Card")
                    }
                    append(" section")
                }
            )
        }
    }
}

@Composable
fun MyDesign() {

    var counter by remember {
        mutableStateOf(0)
    }
    var text1 by remember {
        mutableStateOf("")
    }

    var text2 by remember {
        mutableStateOf("")
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Text(text = "$counter")
//        Button(
//            onClick = {
//            counter++
//        }) {
//            Text(text = "Click ME")
//        }
//        Button(
//            onClick = {
//                counter = 0
//            }
//        ) {
//            Text(text = "Reset")
//        }

        Image(
            painter = painterResource(id = R.drawable.shankara),
            contentDescription = null,
            Modifier.padding(top = 50.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))
        Column {
            OutlinedTextField(
                value = text1,
                placeholder = {
                    Text("Username")
                },
                onValueChange = {
                    text1 = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp)
            )

            Spacer(
                modifier = Modifier
                    .width(10.dp)
                    .height(10.dp)
            )

            OutlinedTextField(
                value = text2,
                placeholder = {
                    Text("Password")
                },
                onValueChange = {
                    text2 = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp)
            )
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp), onClick = {

            }) {
                Text(text = "Log In")
            }
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp), onClick = {

            }) {
                Text(text = "Sign Up")
            }
            Text(text = "Forgot Password?", modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .clickable {
                    Log.i("nileshphonde", "xddd")
                })
        }
    }
}

@Composable
fun LzDemo(names: List<String> = listOf("Umesh", "Mahesh", "shailesh", "nilesh")) {
    LazyColumn {
        items(items = names) {
            SayHi(name = it)
            Divider()
        }
    }
}

@Composable
fun SayHi(name: String) {
    var isSelected by remember {
        mutableStateOf(false)
    }

    Log.i("nilesh", "$name")
    val targetColor by animateColorAsState(
        targetValue = if (isSelected) Color.Red else Color.Transparent,
        animationSpec = tween(durationMillis = 4000)
    )
    Surface(color = targetColor) {
        Text(
            text = "Hello $name",
            modifier = Modifier
                .padding(16.dp)
                .clickable { isSelected = !isSelected }
        )
    }
}

data class Message(val author: String, val body: String)

@Composable
fun ShowMessage(msg: Message) {

    val context = LocalContext.current as? Activity

    var text = remember {
        mutableStateOf(TextFieldValue())
    }

    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        val username = remember { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf(TextFieldValue()) }


        var user by remember {
            mutableStateOf("")
        }
        var pass by remember {
            mutableStateOf("")
        }

        var counter by remember {
            mutableStateOf(0)
        }

        Image(
            painter = painterResource(R.drawable.shankara),
            contentDescription = null,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .size(100.dp)
//                .clip(CircleShape)
        )
        TextField(
//            label = { Text(text = "Username") },
            value = username.value,
            placeholder = {
                Text(text = "Username")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Face,
                    contentDescription = null
                )
            },
            onValueChange = { username.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.surface
            ),
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
//            label = { Text(text = "Password") },
            value = password.value,
            placeholder = {
                Text(text = "Password")
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                backgroundColor = MaterialTheme.colors.surface
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Clear,
                    contentDescription = null
                )
            },
            onValueChange = { password.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Box(modifier = Modifier.padding(24.dp, 0.dp, 24.dp, 0.dp)) {
            Button(
                onClick = {
                    user = username.value.text
                    pass = password.value.text

//                    val intent = Intent(context, MainActivity2::class.java)
//                    context?.startActivity(intent)
//                          counter++
                },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Login")
            }
        }

        ClickableText(
            modifier = Modifier.padding(10.dp),
            text = AnnotatedString("Forgot password?"),
            onClick = { },
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily.Default
            )
        )

        Text(text = "Value: $counter")
//        Text(text = user + pass)
    }
}