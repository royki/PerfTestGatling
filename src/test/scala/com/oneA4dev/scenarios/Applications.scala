package com.oneA4dev.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import com.oneA4dev.util._

object Applications {
	
	val getAllAppsHttp = http("/apps")
							.get("/apps")
							.queryParam("qaAccessToken", Environment.qaAccessToken)
							.check(status.is(200)
							// .pause(5)
						)

	val getAllApps = scenario("get list of applications").exec(getAllAppsHttp)
	
}