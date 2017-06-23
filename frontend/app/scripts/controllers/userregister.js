'use strict';

/**
 * @ngdoc function
 * @name inzFrontendApp.controller:UsercreateCtrl
 * @description
 * # UsercreateCtrl
 * Controller of the inzFrontendApp
 */
angular.module('inzFrontendApp')
  .controller('UsercreateCtrl', function (UserCreateService, $scope) {

    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];

    $scope.inLoginProgress = false;

    $scope.createUserAccount = function () {
      $scope.inLoginProgress = true;
      var login = $scope.username;
      var password = $scope.password;
      var passwordRepeat = $scope.passwordRepeat;
      var btn = $('#reg-btn');
      btn.attr('disabled', 'disabled');

      UserCreateService.createUserAccount(login, password).then(function () {
        endRegisterProcess(btn);
      }, function () {
        endRegisterProcess(btn);
      });

    };

    function endRegisterProcess(btn) {
      $scope.inLoginProgress = false;
      btn.removeAttr('disabled');
    }

  });
