package realdef

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.junit.Test

@TestFor(FoodTruckUpdateService)
@Mock([FoodTruck])
class FoodTruckUpdateServiceTests {

    def jsonMock = '''
[ {
"location" : {
"needs_recoding" : false,
"longitude" : "-122.398658184594",
"latitude" : "37.7901490874965"
},
"status" : "APPROVED",
"expirationdate" : "2015-03-15T00:00:00",
"permit" : "14MFF-0102",
"block" : "3708",
"received" : "Jun 2 2014 12:23PM",
"facilitytype" : "Truck",
"blocklot" : "3708055",
"locationdescription" : "01ST ST: STEVENSON ST to JESSIE ST (21 - 56)",
"cnn" : "101000",
"priorpermit" : "0",
"approved" : "2014-06-02T15:32:00",
"schedule" : "http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule&params=permit=14MFF-0102&ExportPDF=1&Filename=14MFF-0102_schedule.pdf",
"address" : "50 01ST ST",
"applicant" : "Cupkates Bakery, LLC",
"lot" : "055",
"fooditems" : "Cupcakes",
"longitude" : "-122.398658184604",
"latitude" : "37.7901490737255",
"objectid" : "546631",
"y" : "2115738.283",
"x" : "6013063.33"
}
, {
"status" : "APPROVED",
"expirationdate" : "2015-03-15T00:00:00",
"permit" : "14MFF-0035",
"block" : "3720",
"received" : "Mar 13 2014 12:14PM",
"facilitytype" : "Truck",
"blocklot" : "3720008",
"locationdescription" : "01ST ST: NATOMA ST to HOWARD ST (165 - 199)",
"cnn" : "106000",
"priorpermit" : "0",
"approved" : "2014-03-13T12:25:46",
"schedule" : "http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule&params=permit=14MFF-0035&ExportPDF=1&Filename=14MFF-0035_schedule.pdf",
"address" : "400 HOWARD ST",
"applicant" : "Cheese Gone Wild",
"lot" : "008",
"fooditems" : "Grilled Cheese Sandwiches",
"objectid" : "526147",
"y" : "2115347.09492",
"x" : "6013858.05956"
}
, {
"location" : {
"needs_recoding" : false,
"status" : "APPROVED",
"expirationdate" : "2015-03-15T00:00:00",
"permit" : "14MFF-0059",
"block" : "3737",
"received" : "Mar 14 2014 1:05PM",
"facilitytype" : "Truck",
"blocklot" : "3737012",
"locationdescription" : "01ST ST: CLEMENTINA ST to FOLSOM ST (245 - 299)",
"cnn" : "110000",
"priorpermit" : "1",
"approved" : "2014-03-14T13:11:53",
"schedule" : "http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule&params=permit=14MFF-0059&ExportPDF=1&Filename=14MFF-0059_schedule.pdf",
"applicant" : "Mini Mobile Food Catering",
"lot" : "012",
"fooditems" : "Cold Truck: Corn Dogs: Noodle Soups: Candy: Pre-packaged Snacks: Sandwiches: Chips: Coffee: Tea: Various Beverages",
"objectid" : "526452",
"y" : "2114895.75",
"x" : "6014220.898"
}
, {
"location" : {
"needs_recoding" : false,
"longitude" : "-122.39347293179",
"latitude" : "37.7860914772"
},
"status" : "EXPIRED",
"expirationdate" : "2015-03-15T00:00:00",
"permit" : "14MFF-0107",
"block" : "3749",
"received" : "Jun 24 2014 1:49PM",
"facilitytype" : "Truck",
"blocklot" : "3749058",
"locationdescription" : "01ST ST: LANSING ST to HARRISON ST \\\\ I-80 E ON RAMP (362 - 399)",
"cnn" : "113000",
"priorpermit" : "1",
"approved" : "2014-06-24T13:55:30",
"schedule" : "http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule&params=permit=14MFF-0107&ExportPDF=1&Filename=14MFF-0107_schedule.pdf",
"address" : "390 01ST ST",
"applicant" : "Steve's Mobile Deli",
"lot" : "058",
"fooditems" : "Cold Truck: Pre-packaged sandwiches: Burgers: Hot Dogs: Muffin Sandwiches: Enchiladas: Bagels: Burritos: Salads: Snacks: Beverages",
"longitude" : "-122.3934729318",
"latitude" : "37.7860914634251",
"objectid" : "554540",
"y" : "2114230.765",
"x" : "6014531.475"
} ]
'''

    def googleMock = '''
{
"html_attributions" : [],
"next_page_token" : "CvQB7AAAAD2pV9zNiBNiV6n5-TVFfHiAndDcQq6joxte0QnVnUB8HQCFh5plVKATgNnKFTgmq8yH0JS4CP1URAd3Y-VPxD2j2pEWpLb_N_xS1rB2NjjXFZ13unVRknaJXGhlTEn5ZMIWtmNCOpSrbgSB6GmUkosFXSBqkcbWyLynXcaidzoLZGV4zT99TOfH9GTjJiaUxqywhH_4TmHNzOKrHHJTn8SoEF3R5WWLK_rWg_rmZXCN1OVG2F81mx0mKMF0a1QDnDqHdkQttaAnfJmfoWyJ6G6FlJLriv4KPdvALL1JY7Pkf7_pLwG88pt3hFMVglx34BIQ6vbFXffE4NfD0Q0BK5mpnBoUPtd6UpZvDsHvwH0SvygSH48QFGI",
"results" : [
{
"geometry" : {
"location" : {
"lat" : 37.6639147,
"lng" : -122.4339839
},
"viewport" : {
"northeast" : {
"lat" : 37.671107,
"lng" : -122.4276829
},
"southwest" : {
"lat" : 37.655534,
"lng" : -122.444383
}
}
},
"icon" : "http://maps.gstatic.com/mapfiles/place_api/icons/geocode-71.png",
"id" : "7977d26ab9e183b5edea86b6dfad4c38461bbb0e",
"name" : "Sunshine Gardens",
"place_id" : "ChIJjXDyZ2V5j4ARUq10jqsLle4",
"reference" : "CrQBoQAAACYjqp5UP6qzoXOC043qO7gg_p_rDjE8SyXfpYUrmmQv4MAqM3uwQzuzXYgV7aH59Q7fWgqVq7rcy3LntytS3y9bNJABlJ5vkNB-iI4AEFzDAL4MdFBr8urqzok4QseHCwBHryhzs5urz9qK-y7n1zyDC967CaZyWwKD8mNjjkZIFrRiSvyiLU5bp4Lgeu8TIbwmIvTvlpVJ5g7VLRuoMP8pBxUvbmyW7a0vYqbrA8CHEhAdRAenX69yJE9-d282-eDaGhT9esCqql_LvLiUYKxhxSMtsPM9SA",
"scope" : "GOOGLE",
"types" : [ "neighborhood", "political" ],
"vicinity" : "South San Francisco"
},
{
"geometry" : {
"location" : {
"lat" : 37.659223,
"lng" : -122.439226
}
},
"icon" : "http://maps.gstatic.com/mapfiles/place_api/icons/generic_business-71.png",
"id" : "6f02240b727a6457f874e7367adf8620e5105751",
"name" : "Kaiser Permanente Medical Center",
"photos" : [
{
"height" : 1280,
"html_attributions" : [ "From a Google User" ],
"photo_reference" : "CnRoAAAAQTS_hwI4KFqfUK6NQy7Z-NCobs-p6QX3sYCYoQ311NIRROnCQlU-ixjqzG27y8L-K2bAUR1s9HFMfXXY5IfB0FVQSdy7t5xqXu-egHB5Pm1ZRuGmbf3H5U8Dg07rXKiyQEhWygCWN5CDXeLZZqTP-BIQZVrNZqnsw1E3rr8Z9wBqiRoUCtCXNi6HSl_QnpXVxp4znVCWUbw",
"width" : 960
}
],
"place_id" : "ChIJ_fZFEnt5j4ARZvfXfYgrHkI",
"reference" : "CpQBggAAACGO-72FMyA2CNsE9kdprTNa--mHuD20C2kd1KaOflxIPcfyvdkXZIEEvQ3WJLTYxCEEEVLrNqaUQQLc3BTiYqt3ixt1vyeoeZOGitOCGP0EyrztZm9zTtoRGPB5_lYZGo1PwUx3fPMHmv63mCUY7JwrYPqNIP6p7PtKRarGe7dpM4tpYpAQAyrDjsN1BgQqkBIQ8JyU0Br6EmHdX5J8auR25RoUZ9geG1lnPjsaoPZ2EL79XBPeZqA",
"scope" : "GOOGLE",
"types" : [ "hospital", "health", "establishment" ],
"vicinity" : "1200 El Camino Real, South San Francisco"
}],
"status" : "OK"
}
'''

    @Test
    void testUpdateFoodTrucks() {
        String fakeDATASF = "http://data.sfgov.org/resource/rqzj-sfat.json"
        String fakeGOOGLE = "http://google.com/api"

        service.baseDataSFFoodTruckEndPoint = fakeDATASF
        service.baseGoogleLocationEndPoint = fakeGOOGLE

        def readJSON = service.metaClass.readJSONRequest

        service.metaClass.readJSONRequest = { String url ->
            if (url.equals(fakeDATASF)) {
                jsonMock
            } else if (url.equals(fakeGOOGLE)) {
                googleMock
            }
        }

        def foodTruckMock = mockFor(FoodTruckService)
        foodTruckMock.demand.upsertFoodTruck(0..4) { String objectId, String name, String address, Double latitude, Double longitude, String schedule, boolean enabled ->
            // case 1 : with locs
            if (objectId.equals("546631")) {
                assertEquals("Cupkates Bakery, LLC", name)
                assertEquals(true, enabled)
            // case 2 : without loc but with address
            } else if (objectId.equals("526147")) {
                assertEquals("Cheese Gone Wild", name)
                assertEquals(37.6639147, latitude, 0.0000001)
                assertEquals(-122.4339839, longitude, 0.0000001)
                assertEquals(true, enabled)
            // case 3 : both missing
            } else if (objectId.equals("526452")) {
                assertEquals("Mini Mobile Food Catering", name)
                assertEquals(false, enabled)
            // case 4 : status is expired
            } else if (objectId.equals("554540")) {
                assertEquals("Steve's Mobile Deli", name)
                assertEquals(false, enabled)
            }
        }

        service.updateFoodTrucks()
    }
}
