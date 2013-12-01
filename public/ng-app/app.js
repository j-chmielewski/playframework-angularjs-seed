'use strict';

// module
var template = angular.module('template', ['ui.router']);

// configuration service
template.factory('Config', function() {
    return {
	apiRoot: '/api',
	ngAppRoot: ngAppRoot
    };
});

template.config(function($stateProvider, $urlRouterProvider){
    $stateProvider
        .state('home', {
            url: '/',
            templateUrl: ngAppRoot + '/home/templates/home.html',
            controller: 'HomeCtrl'
        })
    })


