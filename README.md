# zemoga-portfolio
Portfolio showing experience and opinions from twitter

_____
## Steps to execute the program
1. To compile the project code, use the OS console from the project root and execute `mvn compile`
2. To execute the project, from the root directory execute mvn spring-boot:run
3. Endpoint execution as follows:
   1. **Get portfolio by Id**
      - URl http://localhost:8080/portfolio/{id}
      - Method GET
   2. **Update portfolio by Id**
      - URl http://localhost:8080/portfolio/{id}
      - Method PUT
      - Payload example
      - ```JSON
        {      
            "experience": "Sharing things I'm learning through my foundation work and other interests",
            "imagePath": "https://pbs.twimg.com/profile_images/1414439092373254147/JdS8yLGI_400x400.jpg",
            "name": "Bill Gates",
            "twitterUser": "BillGates",
            "email": null,
            "phone": 3214567890,
            "zipCode": "456"
        }
 
