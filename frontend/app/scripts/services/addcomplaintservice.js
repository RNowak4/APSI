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

    this.createComplaint = function (username, text) {
      $http({
        method: 'POST',
        url: '/complaint',
        dataType: 'json',
        params: {
          userName: username,
          text: text
        }
      }).then(function () {
        ngNotify.set('Pomyslnie dodano reklamacje!', 'success');
      }, function (error) {
        ngNotify.set('Nie udalo sie dodac reklamacji!', 'error');
      });
    }
  });
