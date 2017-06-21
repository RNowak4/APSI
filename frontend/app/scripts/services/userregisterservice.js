'use strict';

/**
 * @ngdoc service
 * @name inzFrontendApp.UserCreateService
 * @description
 * # UserCreateService
 * Service in the inzFrontendApp.
 */
angular.module('inzFrontendApp')
  .service('UserCreateService', function (ngNotify, $http) {

    this.createUserAccount = function (login, password) {
      return $http({
        method: 'POST',
        url: '/user',
        params: {
          userName: login,
          password: password
        }
      }).then(function () {
        ngNotify.set('Pomyslnie zalozono konto!', 'success');
      }, function (response) {
        var status = response.status;
        if (status == 401) {
          ngNotify.set('Podales niepoprawne dane!', 'error');
        } else if (status == 406) {
          ngNotify.set('Konto z podanym loginem już istnieje!', 'error');
        } else {
          ngNotify.set('Nieznany blad podczas logowania!', 'error');
        }
      });
    }
  });
