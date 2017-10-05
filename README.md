This project is a small web application which lets user manages their invoices. Users can
create an invoice using the UI and can add more than one line items to the invoice.

The frontend uses Angular and backend is developed using Spring Boot. For development, I
have used H2 in-memory database but in production, any RDBMS can be used like MySql etc.

<h1>Frontend Commands:</h1>

1.) npm run start - Start the ng serve with proxy to pass rest call to Spring Boot
 backend application.
 
<h1>Backend Commands:</h1>
<br/>
1.) Run the Spring Boot Server 


<h1>Build for Production:</h1>
1.) npm run build - Builds frontend and copy frontend artifacts to Spring Boot backend
 the application so that site can be accessed from 8080 port.
<br/>
2.) mvn package - To build the jar. Run this command from '$ROOT/server' folder.
<br/>
3.) java -jar evaluation-exercise-0.0.1-SNAPSHOT.jar
<br/> 
Above command can be run from '$ROOT/server/target' folder. I have also checked in latest jar under '$ROOT/lib' directory.

<h1>Application Features:</h1>
1.) Line item description text box supports type-ahead feature e.g.  if one types character "r" , 
suggestion dropdown shows "regular", "referral bonus", "reward" entries.
<br/>
<br/>
2.) "Preview" button is always enabled and shows the current state of an invoice in the modal pane in a formatted view.
<br/>
<br/>
3.) Form validation is implemented and "Send" button is only enabled when all form entries have been validated. A little green color padding on the leftmost side of form control shows entry is valid and little red padding means entered data is not in correct format.
<br/>
<br/>
4.) Users get informed with various messages on top of the page, like when the invoice is created successfully in the system or
when invoice with the same name already exists in the system. Sucess is shown in green background color and error in the red background color.
<br/>
<br/>
5.) Users can also modify an existing invoice. Once users start typing characters into invoice name text field, existing invoices
whose name start with same characters are shown in suggest box. Once the user selects a particular invoice from the suggestion list, invoice
form is populated with existing invoice details and users can modify it.

 