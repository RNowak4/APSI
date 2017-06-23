'use strict';

/**
 * @ngdoc function
 * @name inzFrontendApp.controller:AddcomplaintCtrl
 * @description
 * # AddcomplaintCtrl
 * Controller of the inzFrontendApp
 */
angular.module('inzFrontendApp')
  .controller('AddcomplaintCtrl', function (AddComplaintService, $scope) {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];

    $scope.inLoginProgress = false;

    $scope.addComplaint = function () {
      $scope.inLoginProgress = true;
      var login = $scope.username;
      var text = $scope.text;
      var btn = $('#reg-btn');
      btn.attr('disabled', 'disabled');

      AddComplaintService.createComplaint(login, text).then(function () {
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
