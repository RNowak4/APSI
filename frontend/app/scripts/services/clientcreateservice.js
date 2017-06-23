'use strict';

/**
 * @ngdoc service
 * @name inzFrontendApp.ClientCreateService
 * @description
 * # ClientCreateService
 * Service in the inzFrontendApp.
 */
angular.module('inzFrontendApp')
  .service('ClientCreateService', function (ngNotify, $http) {

    this.createClientAccount = function (login, name, surname, email, address) {
      return $http({
        method: 'POST',
        url: '/client',
        params: {
          userName: login,
          name: name,
          email: email,
          surname: surname,
          address: address
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
