package com.app.god

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.app.god.data.Bhagwan
import com.app.god.data.bhagwans
import com.app.god.ui.theme.GodTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GodTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    GodApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GodApp() {
    Scaffold(
        topBar = { GodTopAppBar() }
    ) { it->
    LazyColumn(contentPadding = it){
        items(bhagwans) {
            GodItem(
                bhagwan = it,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
            )
        }
        }
    }
}

@Composable
fun GodItem( bhagwan: Bhagwan, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
Card (modifier = modifier) {
    Column(
        modifier = Modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio =Spring.DampingRatioNoBouncy,
                    stiffness =Spring.StiffnessMedium
                )
            )
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small))
        ) {
            GodIcon(bhagwan.imageResourceId)
            GodInformation(bhagwan.name)
            Spacer(modifier = Modifier.weight(1f))
            GodItemButton(
                expanded = expanded ,
                onClick = { expanded = !expanded}
                )
            }
                if (expanded){
                    GodHobby(bhagwan.hobbies,
                        modifier = Modifier.padding(
                            start = dimensionResource(id = R.dimen.padding_medium),
                            top = dimensionResource(id = R.dimen.padding_small),
                            bottom = dimensionResource(id = R.dimen.padding_medium),
                            end = dimensionResource(id = R.dimen.padding_medium)
                        )
                    )
                }
        }
    }
}

@Composable
private fun GodItemButton(
    expanded: Boolean,
    onClick:() ->Unit,
    modifier: Modifier = Modifier) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess
            else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary,
            )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GodTopAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        {
            Row(verticalAlignment = Alignment.CenterVertically)
            {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .padding(dimensionResource(R.dimen.padding_small)),
                    painter = painterResource(R.drawable.ic_god_logo),
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayMedium
                )
            }
        }, modifier
    )
}



@Composable
fun GodIcon(@DrawableRes godIcon: Int, modifier: Modifier = Modifier){
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small)
        ,
        painter = painterResource(godIcon),
        contentDescription = null
    )
}
@Composable
fun GodInformation(@StringRes godName: Int,modifier: Modifier = Modifier){
    Column(modifier = modifier) {
        Text(
            text = stringResource(godName),
            style = MaterialTheme.typography.bodyLarge,
            modifier =Modifier
                .padding(top = dimensionResource(R.dimen.padding_small))
        )
    }
}

@Composable
fun GodHobby(
    @StringRes godHobby: Int,
    modifier: Modifier = Modifier
){
Column( modifier = modifier ){
    Text(
        text = stringResource(R.string.about),
        style = MaterialTheme.typography.bodyLarge
    )
    Text(
        text = stringResource(godHobby),
        style = MaterialTheme.typography.displayMedium
    )
}
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GodPreview() {
    GodTheme (darkTheme = false) {
        GodApp()
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GodDarkThemePreview(){
    GodTheme( darkTheme = true) {
        GodApp()
    }
}


