package com.zhadko.composedemoapp.ui

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.zhadko.composedemoapp.R

val OpenSans = FontFamily(
    Font(R.font.open_sans_bold, FontWeight.W700),
    Font(R.font.open_sans_regular, FontWeight.W400)
)

val MyTypography = Typography(
    headlineMedium = TextStyle(
        fontFamily = OpenSans,
        fontWeight = FontWeight.W700,
        fontSize = 16.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = OpenSans,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp
    )
)