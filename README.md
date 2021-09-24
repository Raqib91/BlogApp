# BlogApp (server.port=8081)
This is a blog app web application having following features:
* Two types of role - 1. Admin (Initial Admin username = 'super' and password = '1234'), 2. Blogger.
* Admin can create new admin, approve or delete pending blogger, deactivate or delete approved blogger, approve or delete pending blog, delete approved blogger.
* Blogger can create account and send for Admin's approval. After being approved by a blogger, he can login using username and password, can create new blog and send for Admin's approval, delete own blog post, view others approved blog posts.

## Technologies used are:
#### Database:
* H2 embedded database
* JDBC URL: jdbc:h2:mem:raqib91
* Username: sa
* Password: No password is given
#### Backend:
* Maven
* Spring Boot
* Spring ORM (Hibernate)
#### Frontend:
* JSP
* HTML
* CSS
* Javascript
* JQuery
* Bootstrap

### Instructions to run the application:
* Download the zip file and extract it
* Create a Maven project and import the SqBlogApp folder
* Run the project as Spring Boot App and send request (Root address for localhost:- localhost:8081)
