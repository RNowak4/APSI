'use strict';

/**
 * @ngdoc function
 * @name inzFrontendApp.controller:ClientcreateCtrl
 * @description
 * # ClientcreateCtrl
 * Controller of the inzFrontendApp
 */
angular.module('inzFrontendApp')
  .controller('ClientcreateCtrl', function (ClientCreateService, $scope) {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];

    $scope.createClient = function () {
      // TODO...
    }
  });
