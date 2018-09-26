APP.factory("AutorService", function($resource) {
  return $resource('http://localhost:8080/biblioteca/api/autores/:id', {id:'@_id'},{
    update: {
      method  : 'PUT',
      url     : 'http://localhost:8080/biblioteca/api/autores/:id',
      params  : { id: '@id' },
      isArray : false
    }
  });
});
