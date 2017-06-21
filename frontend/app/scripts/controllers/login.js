'use strict';

/**
 * @ngdoc function
 * @name inzFrontendApp.controller:LoginCtrl
 * @description
 * # LoginCtrl
 * Controller of the inzFrontendApp
 */
angular.module('inzFrontendApp')
  .controller('LoginCtrl', function (LoginService, $location, $scope) {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];

    $scope.inLoginProgress = false;

    $scope.performLogin = function () {
      $scope.inLoginProgress = true;

      var btn = $('#log-btn');
      btn.attr('disabled', 'disabled');

      LoginService.login($scope.username, $scope.password).then(function () {
        endLoginProcess(btn);
        $location.path('#/');
      }, function () {
        endLoginProcess(btn);
      });
    };

    function endLoginProcess(btn) {
      $scope.inLoginProgress = false;
      btn.removeAttr('disabled');
    }
  });
