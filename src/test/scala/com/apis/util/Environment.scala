package com.apis.util

import java.util

object Environment {
	
	// dev02 url
	val dev02 = URL	
	// dev04 url
	val dev04 = URL
	// PAD-EAS resource
	val resource = "/PAD-EAS/api"
	// api version
	val apiVersion = ("/v0","/v1")
	// url
	val dev02Url = dev02+resource+apiVersion._2
	// QaAccessToken
	val qaAccessToken = """QaAccessToken"""
	// baseURL
	val baseURL = scala.util.Properties.envOrElse("baseURL", dev02Url)	
	// nummber of users
	val virtualUsers = scala.util.Properties.envOrElse("numOfUsers", "5000")
	// max response time
	val maxResponseTime = scala.util.Properties.envOrElse("maxResponseTime", "50000")


}