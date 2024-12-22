import android.os.Parcel
import android.os.Parcelable

data class User(
    val id: Int,
    val firstname: String,
    val lastname: String,
    val username: String,
    val email: String,
    val address: Address
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readParcelable(Address::class.java.classLoader) ?: Address("", "", "", Geo("", ""))
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(firstname)
        parcel.writeString(lastname)
        parcel.writeString(username)
        parcel.writeString(email)
        parcel.writeParcelable(address, flags)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User = User(parcel)
        override fun newArray(size: Int): Array<User?> = arrayOfNulls(size)
    }
}
