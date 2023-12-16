##  Spring Boot 3 REST API with User Management and Social Posts 

This repository houses a REST API built with Spring Boot 3, showcasing features like user management, social media post handling, and secure access. Dive in and explore the functionalities!

**Key Features:**

* **User Management:**
    * Create, update, and delete users.
    * Secure user authentication with Spring Security.
    * Implement internalization (i18n) for global accessibility.
* **Social Media Posts:**
    * Create, fetch, and delete posts for specific users.
    * Implement content negotiation for flexible data formats (e.g., JSON, XML).
    * Leverage Spring Data JPA and Hibernate for seamless data interaction.
* **Database:**
    * Connect to a MySQL database via a Docker image for easy deployment and scalability.

**Technologies:**

* Spring Boot 3
* Spring Security
* Spring Data JPA
* Hibernate
* PostgreSQL (Docker image)
* Content Negotiation
* Internalization (i18n)

**Getting Started:**

1. Clone the repository.
2. Set up the required environment (MySQL Docker image, dependencies installation).
   install docker and run it. In your command line interface execute this, 
   docker run --detach --env MYSQL_ROOT_PASSWORD=dummypassword --env MYSQL_USER=socialmedia --env MYSQL_PASSWORD=dummy --env MYSQL_DATABASE=socialmediadatabase --name mysql_restapi --publish 3308:3306 mysql:8-oracle
5. Run the application (`mvn spring-boot:run`).
6. Explore the API endpoints using tools like Postman or your preferred REST client.

**API Endpoints:**

* **User Management:**
    * `/jpa/users`: Get and Post on this url to get and create users.
    * `/jpa/users/{id}`: Get/Delete a specific user by ID.

* **Social Media Posts:**
    * `/jpa/users/{id}/posts`: Get and Post on this url to get and create social media posts.
    * `/jpa/users/{user_id}/posts/{post_id}`: Get/Delete a specific post by ID.

**Additional Notes:**
* Feel free to contribute and extend the functionalities as per your needs.

**Join the Community:**

* Star the repository and share your feedback.
* Fork and contribute to the codebase.
* Discuss and learn from other developers in the community.

This project is your starting point for building secure and functional REST APIs with Spring Boot 3. Get coding, explore the features, and build something amazing!

