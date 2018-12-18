package com.tistory.jeongs0222.weatherapplication.utils


interface TemperatureDivideProvider {

    fun positionDivier(position: Int, tItem: ArrayList<String>): ArrayList<String>

}

class TemperatureDivideProviderImpl : TemperatureDivideProvider {

    override fun positionDivier(position: Int, tItem: ArrayList<String>): ArrayList<String> {
        val list = ArrayList<String>()

        return when (position) {

            0 -> {
                list.add(tItem[0])
                list.add(tItem[1])

                list
            }

            1 -> {
                list.add(tItem[0])
                list.add(tItem[1])

                list
            }

            2 -> {
                list.add(tItem[2])
                list.add(tItem[3])

                list
            }

            3 -> {
                list.add(tItem[2])
                list.add(tItem[3])

                list
            }

            4 -> {
                list.add(tItem[4])
                list.add(tItem[5])

                list
            }

            5 -> {
                list.add(tItem[4])
                list.add(tItem[5])

                list
            }

            6 -> {
                list.add(tItem[6])
                list.add(tItem[7])

                list
            }

            7 -> {
                list.add(tItem[6])
                list.add(tItem[7])

                list
            }

            8 -> {
                list.add(tItem[8])
                list.add(tItem[9])

                list
            }

            9 -> {
                list.add(tItem[8])
                list.add(tItem[9])

                list
            }

            else -> {
                list
            }

            /*0 -> {
                list.add(tItem[0])
                list.add(tItem[1])

                return list
            }

            1 -> return list

            2 -> {
                list.add(tItem[2])
                list.add(tItem[3])

                return list
            }

            3 -> return list

            4 -> {
                list.add(tItem[4])
                list.add(tItem[5])

                return list
            }

            5 -> return list

            6 -> {
                list.add(tItem[6])
                list.add(tItem[7])

                return list
            }

            7 -> return list

            8 -> {
                list.add(tItem[8])
                list.add(tItem[9])

                return list
            }

            else -> {
                return null!!
            }*/
        }
    }

}