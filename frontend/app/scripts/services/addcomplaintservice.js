'use strict';

/**
 * @ngdoc service
 * @name inzFrontendApp.AddComplaintService
 * @description
 * # AddComplaintService
 * Service in the inzFrontendApp.
 */
angular.module('inzFrontendApp')
  .service('AddComplaintService', function (ngNotify, $http) {

    this.createFirstAdmin = function (adminPassword) {
      $http({
        method: 'POST',
        url: '/user/firstAdmin',
        dataType: 'json',
        params: {
          password: adminPassword
        }
      }).then(function () {
        ngNotify.set('Zalozono konto pierwszego admina!', 'success');
      }, function (error) {
        ngNotify.set('Nie udalo sie zalozyc konta pierwszego admina!', 'error');
      });
    }
  });
