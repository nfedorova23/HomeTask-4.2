package com.nfedorova.task42


import kotlin.random.Random

class UserService {
    companion object {

        fun getRandomUserList(): MutableList<User> =
            (0..100).map { getNewRandomUser() }.toMutableList()

        private fun getNewRandomUser(): User = User(
            id = Random.nextInt(),
            image = ImagesList.random(),
            firstName = firstNameList.random(),
            lastName = lastNameList.random(),
            phoneNumber = getRandomPhoneNumber()
        )

        private fun getRandomPhoneNumber(): String =
            "8(${Random.nextInt(900, 999)})${Random.nextInt(100, 999)}-" +
                    "${Random.nextInt(10, 99)}-${Random.nextInt(10, 99)}"

        private val ImagesList = listOf(
            R.drawable.p1,
            R.drawable.p2,
            R.drawable.photo3,
            R.drawable.p4,
            R.drawable.p5,
            R.drawable.photo6,
            R.drawable.p7,
            R.drawable.p8,
            R.drawable.p9,
            R.drawable.p10
        )

        private val firstNameList = listOf(
            "Alex",
            "Anthony",
            "Brandon",
            "Christopher",
            "David",
            "Ethan",
            "Fred",
            "Josh",
            "Kevin",
            "Tyler"
        )

        private val lastNameList = listOf(
            "Allen",
            "Clark",
            "Harris",
            "Jackson",
            "King",
            "Lewis ",
            "Miller",
            "Taylor",
            "Wilson",
            "Washington"
        )
    }
}