package dev.hirogakatageri.esper.demo.state

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CountState(val count: Int): Parcelable