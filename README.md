# recapcha-with-Java-Spring
Secure Java Spring App with google recapcha 
********************************************************************************************************************************
for server side key and client side key: please check https://www.google.com/recaptcha/admin/create and follow instructions
********************************************************************************************************************************
to test this demo app: git clone https://github.com/BrodyGaudel/recapcha-with-Java-Spring.git .
********************************************************************************************************************************
Open this project and change server side key and client side by yours.
********************************************************************************************************************************
set client side key in this file recaptcha/src/main/resources/templates/registerUser.html
********************************************************************************************************************************
set server side key in this file recaptcha/src/main/java/com/brody/recaptcha/validator/CaptchaValidator.java
********************************************************************************************************************************
Go to go to the source folder of the project and run the command: mvn spring-boot:run
********************************************************************************************************************************
Go to your browser and  http://localhost:8080/user/register
