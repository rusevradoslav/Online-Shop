# Online-Shop 

Online-Shop is a shop application. Users can register and login from home page. When users register in the app, they see a different navigation bar with more actions and also see all the items from the database.
Clicking on add item, they can see the item’s detail page. 
From the details page, they can delete the item if they want. 

**Technologies:**

**Front-End:**

*   HTML
*   CSS
*   Bootstrap
*   Thymeleaf

 
**Back-End:**
*   Java
*   Spring Boot
*   Spring MVC
*   MySQL Database
*   JPA

**Without authentication** you can see as a guest : 

     - see index page
     - register 
     - login
  
**With authentication** you can see as a user : 

    - add item
    - buy item
    - view item details
### Routes

URLs | Description
---------|---------
 */* | Index page - login, register
 */users/register* | Register page -  page where user can register .
 */users/login* | Login page - page where user can login .
 */home* | Home page - page where user can see all items.
 */items/details/{id}* | Item Details page - page where user can see item details.
    
 Database Diagram Screenshot
 ---
 
 ![database](/src/main/resources/static/screens/database.png)
 
Website Screenshots
---

- Index Page 
![homepage](/src/main/resources/static/screens/index.png)

- Register Page
![addons](/src/main/resources/static/screens/register.png)

- Login Page
![pending-addons](/src/main/resources/static/screens/login.png)

- Home Page
![product-page](/src/main/resources/static/screens/home.png)

- Add Item Page
![product-page](/src/main/resources/static/screens/add-item.png)

- Item Details Page
![product-page](/src/main/resources/static/screens/details.png)
