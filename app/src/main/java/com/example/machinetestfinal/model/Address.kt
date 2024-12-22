import android.os.Parcel
import android.os.Parcelable

data class Address(
    val street: String,
    val city: String,
    val zipcode: String,
    val geo: Geo
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readParcelable(Geo::class.java.classLoader) ?: Geo("", "")
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(street)
        parcel.writeString(city)
        parcel.writeString(zipcode)
        parcel.writeParcelable(geo, flags)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Address> {
        override fun createFromParcel(parcel: Parcel): Address = Address(parcel)
        override fun newArray(size: Int): Array<Address?> = arrayOfNulls(size)
    }
}
