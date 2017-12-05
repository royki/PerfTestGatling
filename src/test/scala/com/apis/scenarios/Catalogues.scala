package com.apis.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import com.apis.util._

object Catalogues {

	val (level0, level1) = (("level",0),("level",1))
	val getAllCataloguesHttp = exec(http("/catalogues")
									.get("/catalogues")
									.queryParam("qaAccessToken", Environment.qaAccessToken)
									.check(status.is(200))
								)
							    .pause(3)
							    .exec(http("/catalogues:3/families")
								   	.get("/catalogues")
								   	.queryParam("catalogueId",3)
									.queryParam("qaAccessToken", Environment.qaAccessToken)
									.check(status.is(200))
								)
								.pause(5)
								.exec(http("/catalogues:3/level0")
								   	.get("/catalogues")
								   	.queryParam("catalogueId",3)
								   	.queryParam("filter",level0)
									.queryParam("qaAccessToken", Environment.qaAccessToken)
									.check(status.is(200))
								)
								.pause(10)																
								.exec(http("/catalogues:3/level1")
								   	.get("/catalogues")
								   	.queryParam("catalogueId",3)
								   	.queryParam("filter",level1)
									.queryParam("qaAccessToken", Environment.qaAccessToken)
									.check(status.is(200))
								)
								
	val getAllCatalogues = scenario("get list of open catalogue").exec(getAllCataloguesHttp)

	// val getAllCataloguesAtLevelHttp = exec(http("/catalogues:3/level0")
	// 							   	.get("/catalogues")
	// 							   	.queryParam("catalogueId",3)
	// 							   	.queryParam("filter",level0)
	// 								.queryParam("qaAccessToken", Environment.qaAccessToken)
	// 								.check(status.is(200))
	// 							)
	// 							.pause(10)																
	// 							.exec(http("/catalogues:3/level1")
	// 							   	.get("/catalogues")
	// 							   	.queryParam("catalogueId",3)
	// 							   	.queryParam("filter",level1)
	// 								.queryParam("qaAccessToken", Environment.qaAccessToken)
	// 								.check(status.is(200))
	// 							)
	// 							.pause(10)
	// val getAllCataloguesAtLevel = scenario("get catalogues at level0 and level1").exec(getAllCataloguesAtLevelHttp)															
  	
}
