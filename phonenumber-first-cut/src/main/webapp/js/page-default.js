/**
 * 
 */
var myApp = angular.module("mssp", ["ngAnimate","ngStorage"]);

angular.module("mssp").controller("tabs", ['$scope', '$http', '$q',function($scope, $http, $q) {
	var promiseTabVariables = null;

}]);

angular.module("mssp").controller("global", ['$scope', '$http', '$q', '$timeout','$rootScope', function ($scope, $http, $q, $timeout,$rootScope) {
	 $scope.initializeFlag = function(){
		 if(localStorage.getItem("menuFlagTest")==null)
		 {
		 localStorage.setItem("menuFlagTest", "true");
		 }
		 $rootScope.flag=(localStorage.getItem("menuFlagTest")==="true");
		 };
		 $scope.initializeFlag();
		 $scope.toggleflag = function(){
		 if(localStorage.getItem("menuFlagTest")=="true")
		 {localStorage.setItem("menuFlagTest", "false");}
		 else{
		 localStorage.setItem("menuFlagTest", "true");
		 }
		 $rootScope.flag=((localStorage.getItem("menuFlagTest")==="true"));
		 console.log($rootScope.flag);
		 }; 
}]);
