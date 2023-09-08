package com.app.god.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.app.god.R

val Overlock = FontFamily(
    Font(R.font.overlock_regular),
    Font(R.font.overlock_bold)
)

val Typography = Typography(
    displayMedium = TextStyle(
        fontFamily = Overlock,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = Overlock,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp)
)