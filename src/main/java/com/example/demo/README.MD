## REST END POINTS

If we want Admin priviladge then manually we need to change in DB. Elase USER role will automatically apply.


For Registering user

POST : http://localhost:8080/api/v1/auth-service/register

Payload: 
{
"firstName":"ABC",
"lastName":"ABC",
"email":"ABC@gmail.com",
"password":"ABC"
}

For getting JWT Token

POST: http://localhost:8080/api/v1/auth-service/authenticate

Payload:
{
"email":"user@gmail.com",
"password":"user"
}

For testing user

POST: http://localhost:8080/api/v1/user/testUser
Need with Token
Payload:
{
"email":"user@gmail.com",
"password":"user"
}

    