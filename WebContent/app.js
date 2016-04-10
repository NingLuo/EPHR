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
			.when("/demographic", {
				templateUrl:"views/profile/demographic.view.html",
				controller:"DemographicCtrl",
				controllerAs: "model"
			})
			.when("/contactInfo", {
				templateUrl:"views/profile/contactInfo.view.html",
				controller:"ContactInfoCtrl",
				controllerAs: "model"
			})
			.when("/clinicalSummaries", {
				templateUrl:"views/summary/clinicalSummaries.view.html",
				controller:"ClinicalSummariesCtrl",
				controllerAs: "model"
			})
			.when("/summary", {
				templateUrl:"views/summary/summaryDetail.view.html"
			})
			.when("/testResult", {
				templateUrl:"views/testResult/testResult.view.html",
				controller:"TestResultCtrl",
				controllerAs: "model"
			})
			.when("/bloodTest", {
				templateUrl:"views/testResult/bloodTest.view.html",
				controller:"BloodTestCtrl",
				controllerAs: "model"
			})
			.when("/medication", {
				templateUrl:"views/medication/medication.view.html",
				controller:"MedicationCtrl",
				controllerAs: "model"
			})
			.otherwise({
				redirectTo: "/"
			});
	}
})();