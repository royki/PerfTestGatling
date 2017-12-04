package com.oneA4dev.simulation


import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import io.gatling.http.request.builder.HttpRequestBuilder.toActionBuilder

import com.oneA4dev.util._
import com.oneA4dev.scenarios.{SelfServiceApis, Applications, Analytics, Catalogues}

class SimulationOnApis extends Simulation {

   before {
          println("***** simulation is about to begin! *****")
      }

  val httpConf = http.baseURL(Environment.dev02Url)

  val simulationOnApis = List(

    // /apis
    SelfServiceApis.getAllApis.inject(
      atOnceUsers(10),
      rampUsersPerSec(1) to 100 during(30 seconds)      
    ),

    // SelfServiceApis.apisInAscOrder.inject(
    //   atOnceUsers(10),
    //   rampUsersPerSec(1) to 100 during(30 seconds)
    //   // constantUsersPerSec(2) during(1 minute)
    //   // splitUsers(1000) into(rampUsers(10) over(10 seconds)) separatedBy(10 seconds), // 8
    //   // splitUsers(1000) into(rampUsers(10) over(10 seconds)) separatedBy atOnceUsers(30), // 9
    //   // heavisideUsers(1000) over(20 seconds) // 10    
    // ),

    // /apps
    Applications.getAllApps.inject(
      atOnceUsers(10),
      rampUsersPerSec(1) to 100 during(30 seconds) 
    ),

    // /analytics
    Analytics.getAnalyticsApis.inject(
      atOnceUsers(10),
      rampUsersPerSec(1) to 100 during(30 seconds) 
    ),

    Catalogues.getAllCatalogues.inject(
      atOnceUsers(10),
      rampUsersPerSec(1) to 100 during(30 seconds)
    )

  )
  
  setUp(simulationOnApis)
    .protocols(httpConf)
    .maxDuration(1 minutes)
    .assertions(
      global.responseTime.max.lessThan(Environment.maxResponseTime.toInt)
    )
  
}
