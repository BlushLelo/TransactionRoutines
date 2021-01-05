# Overview
This is a project for a technical interview on PISMO

#Stack
This project was implemented using `Java 11, Maven 3.6.3`

# Setup
With docker compose just run `docker-compose up` from root directory the application will be up and running on `localhost:8081`

#Endpoints 
###POST /accounts
`Request Body: 
{ 
"document_number": "12345678900" 
}`

document_number:  must have 11 characteres


###GET /accounts/:accountId
Response Body: 
`{ 
"account_id": 1, 
"document_number": "12345678900" ,
"transactions": []
} `

###POST /transactions
`Request Body: 
{ 
"account_id": 1, 
"operation_type_id": 4, 
"amount": 123.45 
}`



