package com.apis.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object SelfServiceApis {
	
	val getAllApisHttp = exec(http("/apis")
							.get("/apis")
							.check(status.is(200))							
						)
						.pause(5)
						.exec(http("/apis:asc-id")
							.get("/apis")
							.queryParam("sortBy","id")
							.queryParam("sortDirection","asc")
							.check(status.is(200))
						)						
						.pause(10)


	val getAllApis = scenario("get selfservice apis").exec(getAllApisHttp)

	// val apisInAscOrderHttp = http("/apis:asc-id")
	// 						.get("/apis")
	// 						.queryParam("sortBy","id")
	// 						.queryParam("sortDirection","asc")
	// 						.check(status.is(200)
	// 						// .pause(10)
	// 					)

	// val apisInAscOrder = scenario("selfservice apis in ascending order").exec(apisInAscOrderHttp)
}