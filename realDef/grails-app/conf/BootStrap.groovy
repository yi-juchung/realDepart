class BootStrap {

    def foodTruckUpdateService

    def init = { servletContext ->
        foodTruckUpdateService.initialize()
    }
    def destroy = {
    }
}
