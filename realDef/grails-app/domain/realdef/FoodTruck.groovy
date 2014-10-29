package realdef

class FoodTruck {

    String name
    String addr
    String objectId

    Double latitude
    Double longitude

    String schedule
    boolean enabled

    static constraints = {
        objectId unique: true
        addr nullable: true
    }
}
