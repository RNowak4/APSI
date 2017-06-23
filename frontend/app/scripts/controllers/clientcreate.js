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

    $scope.inLoginProgress = false;

    $scope.createClient = function () {
      $scope.inLoginProgress = true;
      var login = $scope.username;
      var name = $scope.name;
      var surname = $scope.surname;
      var email = $scope.email;
      var address = $scope.address;
      var btn = $('#reg-btn');
      btn.attr('disabled', 'disabled');

      ClientCreateService.createClientAccount(login, name, surname, email, address).then(function () {
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
