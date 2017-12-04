package com.oneA4dev.util

import java.util

object Environment {
	
	// dev02 url
	val dev02 = "https://nceaddev02web01.etv.nce.amadeus.net"	
	// dev04 url
	val dev04 = "https://nceaddev04web01.etv.nce.amadeus.net"
	// PAD-EAS resource
	val resource = "/PAD-EAS/api"
	// api version
	val apiVersion = ("/v0","/v1")
	// oneA4dev
	val dev02Url = dev02+resource+apiVersion._2
	// QaAccessToken
	val qaAccessToken = """{"prospect": false,"login": "QAPADADMIN","firstName": "QaPadAdmin","lastName" : "Admin","mail" : "qa_pad_admin@amadeus.com","organization" : "PAD-USERS","companyCode" : "1A","permissions": ["ACCESS_CLIENT_DOCUMENTATION"]}"""
	// baseURL
	val baseURL = scala.util.Properties.envOrElse("baseURL", dev02Url)	
	// nummber of users
	val virtualUsers = scala.util.Properties.envOrElse("numOfUsers", "5000")
	// max response time
	val maxResponseTime = scala.util.Properties.envOrElse("maxResponseTime", "50000")


}