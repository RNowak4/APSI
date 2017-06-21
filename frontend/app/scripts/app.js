'use strict';

$.material.init();

/**
 * @ngdoc overview
 * @name inzFrontendApp
 * @description
 * # inzFrontendApp
 *
 * Main module of the application.
 */
angular
  .module('inzFrontendApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngNotify',
    'ngSanitize',
    'ngTouch',
    'ui.toggle'
  ])
  .config(function ($locationProvider, $routeProvider) {
    $routeProvider
      .when('/userRegister', {
        templateUrl: 'views/userregister.html',
        controller: 'UsercreateCtrl',
        controllerAs: 'usercreate'
      })
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/addComplaint', {
        templateUrl: 'views/addcomplaint.html',
        controller: 'AddComplaintService',
        controllerAs: 'addcomplaint'
      })
      .when('/addClient', {
        templateUrl: 'views/clientcreate.html',
        controller: 'AnswersCtrl',
        controllerAs: 'answers'
      })
      .when('/login', {
        templateUrl: 'views/login.html',
        controller: 'LoginCtrl',
        controllerAs: 'passwordChangeForm'
      })
      .otherwise({
        redirectTo: '/'
      });

    if (window.history && window.history.pushState) {
      $locationProvider.html5Mode({
        enabled: true,
        requireBase: false
      });
    }
  });
