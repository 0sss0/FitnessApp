package com.example.fitnessapp.data

import com.example.fitnessapp.domain.entity.CardType
import com.example.fitnessapp.domain.entity.ListItem
import org.joda.time.DateTime

class CardsData {
    private val pattern = "dd.MM.YYYY"

    private val myData = listOf<ListItem>(
        ListItem.SplitDate(1, DateTime.now().toString(pattern)),
        ListItem.CardActivity(
            2,
            "14.32 км",
            "2 часа 46 минут",
            "Серфинг",
            "14 часов назад",
            CardType.My
        ),
        ListItem.SplitDate(3, "Май 2022 года"),
        ListItem.CardActivity(
            4,
            "1000 м",
            "60 минут",
            "Велосипед",
            "29.05.2022",
            CardType.My
        )
    )

    private val usersData = listOf<ListItem>(
        ListItem.SplitDate(4, "Вчера"),
        ListItem.CardActivity(
            4,
            "14 км",
            "2 часа 46 минут",
            "Серфинг",
            "29.05.2022",
            CardType.Users,
            "@van_darkholme"
        ),
        ListItem.CardActivity(
            4,
            "228 м",
            "14 часов 48 минут",
            "Качели",
            "14 часов назад",
            CardType.Users,
            "@techniquepasha"
        ),
        ListItem.CardActivity(
            4,
            "30 км",
            "2 часа 10 минут",
            "Езда на кадилак",
            "14 часов назад",
            CardType.Users,
            "@morgen_shtern"
        )
    )

    fun getDefaultData(type: CardType): List<ListItem> {
        return when (type) {
            CardType.My -> myData
            CardType.Users -> usersData
        }
    }
}