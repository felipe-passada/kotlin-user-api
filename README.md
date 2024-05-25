# kotlin-user-api

1. Run docker-compose to start postgresql
```sh
docker-compose up -d
```

2. Test the api using the api:

> http://localhost:8080/users/batchPersist?batchAmount=50

NOTE: the batchAmount is the amount of users that is going to be fetched from the external api and be inserted in the database
you can custom the param by passing other values eg: 10, 5, etc...
