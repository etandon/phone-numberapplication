/**
 * 
 */
var service=angular.module("customServices",[]);
service.factory("dataFetch",['$http',function($http){
	      var url="datafetch?";
	      return {
	    	       getSingle: function(command){
	    	    	   var promise=$http.get(url+command).success( function(response) {
	    	    		           result=response;
	    	    	        });
	    	    	   return promise;
	    	    	   }
	    	     };
  }
]);
var myApp = angular.module("mssp", ["customServices"]);

