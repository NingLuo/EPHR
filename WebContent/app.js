(function() {
	"use strict";
	
	var app = angular.module("EPHR", ["ngRoute"]);
	app.config(configuration);

	function configuration($routeProvider) {
		$routeProvider
			.when("/", {
				templateUrl:"views/home/home.view.html"
			})
			.when("/register", {
				templateUrl:"views/user/register.view.html"
			})
			.when("/profile", {
				templateUrl:"views/profile/profile.view.html"
			})
			.when("/clinicalSummaries", {
				templateUrl:"views/summary/clinicalSummaries.view.html"
			})
			.when("/summary", {
				templateUrl:"views/summary/summary.view.html"
			})
			.when("/test", {
				templateUrl:"views/testResult/testResult.view.html"
			})
			.when("/bloodTest", {
				templateUrl:"views/testResult/bloodTest.view.html"
			})
			.when("/medication", {
				templateUrl:"views/medication/medication.view.html"
			})
			.otherwise({
				redirectTo: "/"
			});
	}
})();