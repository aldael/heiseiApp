package Heisei.data.local

import Heisei.model.Rider

fun Rider.toLocal() = RiderLocal(
    rider = rider,
    identidad = identidad,
    armor = armor,
    fav = fav,
    serie = serie
)

fun List<Rider>.toLocal() = map(Rider::toLocal)

fun RiderLocal.toExternal() = Rider(
    rider = rider,
    identidad = identidad,
    armor = armor,
    fav = fav,
    serie = serie
)

fun List<RiderLocal>.toExternal() = map(RiderLocal::toExternal)