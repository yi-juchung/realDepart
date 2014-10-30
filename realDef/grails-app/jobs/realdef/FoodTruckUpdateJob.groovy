package realdef

class FoodTruckUpdateJob {

    static triggers = {
        //Fire at 9:00AM EST every 1st Tues
        cron name: 'FoodTruckUpdateTrigger1stTues', cronExpression: "0 0 14 ? * 3#1"
    }

    def foodTruckUpdateServiceTests

    def execute() {
        log.info "Starting food tuck update job"

        foodTruckUpdateServiceTests.updateFoodTrucks()

        log.info "Food truck update job done"
    }
}
