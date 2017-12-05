package com.apis.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import com.apis.util._

object Analytics  {

	val getAnalyticsApisHttp = http("/analytics")
							.get("/analytics/apis")
							.queryParam("environment", "test")
							.queryParam("timeRange", "07/01/2017 12:00~09/21/2017 18:00")
							.queryParam("qaAccessToken", Environment.qaAccessToken)
							.check(status.is(200)
							//.pause(5)
						)

	val getAnalyticsApis = scenario("get analytics of apis").exec(getAnalyticsApisHttp)
}