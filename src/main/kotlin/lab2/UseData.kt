package lab2

fun duplicate(addresses: HashMap<Address, Int>) {
    println("Addresses and repetition: ")
    addresses.forEach {
        println("${it.key}. Repetition: ${it.value}")
    }
}

fun storeyBuildings(addresses: HashMap<Address, Int>) {
    val storeyBuildings: HashMap<String, StoreyBuildings> = hashMapOf()
    addresses.forEach {
        if (!storeyBuildings.containsKey(it.key.city)) {
            storeyBuildings[it.key.city] = StoreyBuildings()
        }
        else {
            when (it.key.storey) {
                1 -> storeyBuildings[it.key.city]?.one = storeyBuildings[it.key.city]?.one?.plus(1)!!
                2 -> storeyBuildings[it.key.city]?.two = storeyBuildings[it.key.city]?.two?.plus(1)!!
                3 -> storeyBuildings[it.key.city]?.three = storeyBuildings[it.key.city]?.three?.plus(1)!!
                4 -> storeyBuildings[it.key.city]?.four = storeyBuildings[it.key.city]?.four?.plus(1)!!
                5 -> storeyBuildings[it.key.city]?.five = storeyBuildings[it.key.city]?.five?.plus(1)!!
            }
        }
    }

    storeyBuildings.forEach {
        println("In ${it.key} city there are: ")
        println("${it.value.one} 1-storey buildings.")
        println("${it.value.two} 2-storey buildings.")
        println("${it.value.three} 3-storey buildings.")
        println("${it.value.four} 4-storey buildings.")
        println("${it.value.five} 5-storey buildings.")
    }
}