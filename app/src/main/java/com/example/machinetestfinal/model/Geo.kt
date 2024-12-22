import android.os.Parcel
import android.os.Parcelable

data class Geo(
    val lat: String,
    val long: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(lat)
        parcel.writeString(long)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Geo> {
        override fun createFromParcel(parcel: Parcel): Geo = Geo(parcel)
        override fun newArray(size: Int): Array<Geo?> = arrayOfNulls(size)
    }
}
