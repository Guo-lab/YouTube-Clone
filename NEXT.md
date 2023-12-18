# BACKEND

1. Create MongoDB schema
    > Notes: In relational database, we create two tables and create one-to-many relationship between them.  
    In MongoDB, just embed one document inside another document.

2. Create New package Entities in the SpringBoot project. (as the database schema)


3. Create Spring Boot Amazon S3.  
    Reference materials:
    - [S3(Simple Storage Service) vs. Amazon Storage Gateway](https://www.trustradius.com/compare-products/amazon-s3-simple-storage-service-vs-aws-storage-gateway#pricing)
    - [Amazon Free Tier](https://aws.amazon.com/free/?all-free-tier.sort-by=item.additionalFields.SortRank&all-free-tier.sort-order=asc&awsf.Free%20Tier%20Types=*all&awsf.Free%20Tier%20Categories=categories%23storage)
    - [Getting started with Amazon S3](https://docs.aws.amazon.com/AmazonS3/latest/userguide/GetStartedWithS3.html?icmpid=docs_amazons3_console)
    - Author used previous 2.3.0-RC2 [version.](https://docs.awspring.io/spring-cloud-aws/docs/2.3.0-RC2/reference/html/index.html)
        
        <img src="./assets/Springboot AWS.jpg" alt="Employee data" width="400" height="200" title="None">

      Spring Cloud AWS maven dependency management and Spring Boot auto-configuration
      

4. Implement the controller layer and service layer (to upload the videos to Amazon S3).


5. Testing
    Postman Client.   
    > Tips: Bucket and objects changed to public.  
    
    ISSUES: Postman 404...
   
    Reason: OpenJDK 20  
    Solutions:   
      - (1) I have to downgrade the JDK version to 16.
      - (2) To solve 500 Internal Server Error.   
   
        <img src="./assets/ACL issue.jpg" alt="Employee data" width="560" height="400" title="None">

    <br>
    Finally, testing passed.   
    <br>
    <img src="./assets/Postman backend test passed.jpg" alt="Employee data" width="660" height="300" title="None">