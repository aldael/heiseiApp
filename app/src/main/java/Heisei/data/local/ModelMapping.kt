package Heisei.data.local

import Heisei.model.Rider

fun Rider.toLocal() = RiderLocal(
    rider = rider,
    identidad = identidad
)

fun List<Rider>.toLocal() = map(Rider::toLocal)

fun RiderLocal.toExternal() = Rider(
    rider = rider,
    identidad = identidad
)

fun List<RiderLocal>.toExternal() = map(RiderLocal::toExternal)