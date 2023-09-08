package com.app.god.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.app.god.R

data class Bhagwan(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    @StringRes val hobbies: Int
)

val bhagwans = listOf(
    Bhagwan(R.drawable.mahadeva, R.string.god_name_1, R.string.god_description_1),
    Bhagwan(R.drawable.rama, R.string.god_name_2, R.string.god_description_2),
    Bhagwan(R.drawable.radha_krishna, R.string.god_name_3, R.string.god_description_3),
    Bhagwan(R.drawable.durga_mata, R.string.god_name_4, R.string.god_description_4),
    Bhagwan(R.drawable.brahma, R.string.god_name_5, R.string.god_description_5),
    Bhagwan(R.drawable.vishnu, R.string.god_name_6, R.string.god_description_6),
    Bhagwan(R.drawable.parvati_mata, R.string.god_name_7, R.string.god_description_7),
    Bhagwan(R.drawable.saraswati, R.string.god_name_8, R.string.god_description_8),
    Bhagwan(R.drawable.lakshmi, R.string.god_name_9, R.string.god_description_9),
    Bhagwan(R.drawable.ganesha, R.string.god_name_10, R.string.god_description_10)
)