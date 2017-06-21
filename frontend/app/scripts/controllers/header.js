'use strict';

/**
 * @ngdoc function
 * @name inzFrontendApp.controller:HeaderCtrl
 * @description
 * # HeaderCtrl
 * Controller of the inzFrontendApp
 */
angular.module('inzFrontendApp')
  .controller('HeaderCtrl', function (LoginService, $cookieStore, $scope, $rootScope) {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];

    $scope.isLoggedIn = function () {
      var cookieVal = $cookieStore.get("logged");
      return cookieVal != null && cookieVal == true;
    };

    $scope.logout = function () {
      LoginService.logout();
    };

    $scope.checkAuthority = function () {
      return $rootScope.authority;
    };

  });
