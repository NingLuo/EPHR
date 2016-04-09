(function() {
	"use strict";
	
	var app = angular.module("EPHR", ["ngRoute"]);
	app.config(configuration);

	function configuration($routeProvider) {
		$routeProvider
			.when("/", {
				templateUrl:"views/home/home.view.html",
				controller: "HomeCtrl",
				controllerAs: "model"
			})
			.when("/register", {
				templateUrl:"views/user/register.view.html",
				controller: "RegisterCtrl",
				controllerAs: "model"
			})
			.when("/profile", {
				templateUrl:"views/profile/profile.view.html",
				controller:"ProfileCtrl",
				controllerAs: "model"
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
			.when("/provider/:providerName",{
				templateUrl:"views/provider/provider.view.html",
				controller:"providerController",
				controllerAs:"model"
			})
			.otherwise({
				redirectTo: "/"
			});
	}
})();